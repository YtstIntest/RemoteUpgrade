package com.example.remoteupgradesdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;


import com.example.remoteupgradesdk.bean.CurrentVehicleTaskResBean;
import com.example.remoteupgradesdk.bean.UpdateConfirInterfaceResBean;
import com.example.remoteupgradesdk.bean.UpdateVehicleTasksResBean;
import com.example.remoteupgradesdk.callback.JsonCallback;
import com.example.remoteupgradesdk.configs.DataBackResult;
import com.example.remoteupgradesdk.configs.OkHelper;
import com.example.remoteupgradesdk.interfaces.ResponseCallback;
import com.lzy.okgo.model.Response;

import java.util.TimerTask;

public class LogicProcessing {
    private Context context;
    private static final int DELAY_TIME = 5 * 1000;
    private String vin;
    private String uDate;
    private String taskcarId="";
    private String errorMsg="加载异常，请重试！！！";

    private ResponseCallback<CurrentVehicleTaskResBean> currentVehicleTaskResBeanCallback;
    private ResponseCallback<UpdateConfirInterfaceResBean> updateConfirInterfaceResBeanCallback;
    private ResponseCallback<UpdateVehicleTasksResBean> updateVehicleTasksResBeanCallback;


    public LogicProcessing(Context context) {
        this.context = context;
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123:
                    OkHelper.queryCarUpdateTask(context, vin, uDate, taskcarId, new JsonCallback<DataBackResult<CurrentVehicleTaskResBean>>() {
                        @Override
                        public void onSuccess(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                            if(response.body().getBody().getResult()!=null){
                                taskcarId=response.body().getBody().getResult().getTaskCarId();
                            }
                            currentVehicleTaskResBeanCallback.onSuccess(response.body().getBody());
                        }

                        @Override
                        public void onError(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                            super.onError(response);
                            currentVehicleTaskResBeanCallback.onError(errorMsg);
                        }
                    });

                    break;
            }

        }
    };

    private MTimerTask vehicleTask;


    /**
     * @desc 启动查询当前车辆升级任务
     * @author XL
     * @create_time 2019/4/17
     */
    public void starQueryCarUpdateTask(String vin, String uDate) {
        this.vin = vin;
        this.uDate = uDate;
        vehicleTask = new MTimerTask(DELAY_TIME, new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        });
        vehicleTask.start();
    }

    /**
     * @desc 停止查询当前车辆升级任务
     * @author XL
     * @create_time 2019/4/17
     */
    public void stopQueryCarUpdateTask() {
        vehicleTask.stop();
    }

    /**
     * @param taskcarId 车辆任务id
     * @param uDate     操作时间
     * @param type      确认类型
     * @param result    确认结果
     * @desc 确认升级任务
     * @author XL
     * @create_time 2019/4/27
     */
    public void confirmUpgrade(String taskcarId, String uDate, int type, int result) {
        OkHelper.confirmUpgrade(context, taskcarId, uDate, type, result, new JsonCallback<DataBackResult<UpdateConfirInterfaceResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateConfirInterfaceResBean>> response) {
                updateConfirInterfaceResBeanCallback.onSuccess(response.body().getBody());
            }

            @Override
            public void onError(Response<DataBackResult<UpdateConfirInterfaceResBean>> response) {
                super.onError(response);
                updateConfirInterfaceResBeanCallback.onError(errorMsg);
            }
        });

    }

    /**
     * @param vin   车辆VIN
     * @param pi    页面索引
     * @param ps    页面大小
     * @param uDate 日期时间
     * @desc 获取历史升级记录
     * @author XL
     * @create_time 2019/4/27
     */
    public void getUpdateTaskList(String vin, int pi, int ps, String uDate) {
        OkHelper.getUpdateTaskList(context, vin, pi, ps, uDate, new JsonCallback<DataBackResult<UpdateVehicleTasksResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateVehicleTasksResBean>> response) {
                updateVehicleTasksResBeanCallback.onSuccess(response.body().getBody());
            }

            @Override
            public void onError(Response<DataBackResult<UpdateVehicleTasksResBean>> response) {
                super.onError(response);
                updateVehicleTasksResBeanCallback.onError(errorMsg);
            }
        });
    }


    public void setCurrentVehicleTaskResBeanCallback(ResponseCallback<CurrentVehicleTaskResBean> currentVehicleTaskResBeanCallback) {
        this.currentVehicleTaskResBeanCallback = currentVehicleTaskResBeanCallback;
    }

    public void setUpdateConfirInterfaceResBeanCallback(ResponseCallback<UpdateConfirInterfaceResBean> updateConfirInterfaceResBeanCallback) {
        this.updateConfirInterfaceResBeanCallback = updateConfirInterfaceResBeanCallback;
    }

    public void setUpdateVehicleTasksResBeanCallback(ResponseCallback<UpdateVehicleTasksResBean> updateVehicleTasksResBeanCallback) {
        this.updateVehicleTasksResBeanCallback = updateVehicleTasksResBeanCallback;
    }
}
