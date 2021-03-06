package com.example.remoteupgradesdk.api;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.example.remoteupgradesdk.bean.CurrentVehicleTaskResBean;
import com.example.remoteupgradesdk.bean.UpdateConfirInterfaceResBean;
import com.example.remoteupgradesdk.bean.UpdateVehicleTasksResBean;
import com.example.remoteupgradesdk.callback.JsonCallback;
import com.example.remoteupgradesdk.configs.DataBackResult;
import com.example.remoteupgradesdk.configs.OkHelper;
import com.example.remoteupgradesdk.configs.URLConfig;
import com.example.remoteupgradesdk.interfaces.ResponseCallback;
import com.example.remoteupgradesdk.utils.MTimerTask;
import com.lzy.okgo.model.Response;

import java.util.TimerTask;


public class RemoteUpdateManage {
    private Context context;
    private static final int DELAY_TIME = 5 * 1000;
    private String vin;
    private String uDate;
    private String taskcarId = "";
    private int isNewTask = 0;  //判断当前任务是否为最新任务
    private int status = -1;     //当前车机任务状态
    private MTimerTask vehicleTask;
    private int isTask = 0;

    private ResponseCallback<CurrentVehicleTaskResBean> currentVehicleTaskResBeanCallback;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123:
                    if (isNewTask == 0) {
                        taskcarId = "";
                    } else {
                        if (status == 11) {
                            taskcarId = "";
                        }

                    }
                    OkHelper.queryCarUpdateTask(context, vin, uDate, taskcarId, new JsonCallback<DataBackResult<CurrentVehicleTaskResBean>>() {
                        @Override
                        public void onSuccess(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                            switch (response.body().getStatusCode()) {
                                case OkHelper.SUCCESS:
                                    if (response.body().getBody().getResult() != null) {
                                        if (response.body().getBody().getResult().getTaskCarId() != null) {
                                            taskcarId = response.body().getBody().getResult().getTaskCarId();
                                            isNewTask = response.body().getBody().getResult().getIsNewTask();
                                            status = response.body().getBody().getResult().getStatus();
                                        }
                                    }
                                    currentVehicleTaskResBeanCallback.onSuccess(response.body().getBody());
                                    break;
                                case OkHelper.ERRO_NOT_FOUNT:
                                    currentVehicleTaskResBeanCallback.onError(OkHelper.ERRO_NOT_FOUNT_MESSAGE);
                                    break;
                                case OkHelper.ERRO_SERVER:
                                    currentVehicleTaskResBeanCallback.onError(OkHelper.ERRO_SERVER_MESSAGE);
                                    break;
                                case OkHelper.ERRO_UPTATE:
                                    currentVehicleTaskResBeanCallback.onError(OkHelper.ERRO_UPTATE_MESSAGE);
                                    break;
                                default:
                                    currentVehicleTaskResBeanCallback.onError(OkHelper.ERRO_NOT_MESSAGE);
                                    break;
                            }

                        }

                        @Override
                        public void onError(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                            super.onError(response);
                            currentVehicleTaskResBeanCallback.onError(OkHelper.ERRO_MESSAGE);
                        }
                    });


                    break;
            }

        }
    };

    public RemoteUpdateManage(Context context) {

        this.context = context;
    }

    /**
     * @param vin   车辆VIN
     * @param uDate 日期时间
     * @Description: 获取任务升级提示
     * @Author: XL
     * @CreateDate: 2019/9/5 2:05 PM
     */
    public void getUpdateList(String vin, String uDate, final ResponseCallback<CurrentVehicleTaskResBean> callback) {
        OkHelper.queryCarUpdateTask(context, vin, uDate, "", new JsonCallback<DataBackResult<CurrentVehicleTaskResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
                        callback.onSuccess(response.body().getBody());
                        break;
                    case OkHelper.ERRO_NOT_FOUNT:
                        callback.onError(OkHelper.ERRO_NOT_FOUNT_MESSAGE);
                        break;
                    case OkHelper.ERRO_SERVER:
                        callback.onError(OkHelper.ERRO_SERVER_MESSAGE);
                        break;
                    case OkHelper.ERRO_UPTATE:
                        callback.onError(OkHelper.ERRO_UPTATE_MESSAGE);
                        break;
                    default:
                        callback.onError(OkHelper.ERRO_NOT_MESSAGE);
                        break;
                }

            }

            @Override
            public void onError(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });
    }


    /**
     * @param vin   车辆VIN
     * @param pi    页面索引
     * @param ps    页面大小
     * @param uDate 日期时间
     * @desc 手机APP查询已升级的车辆任务列表
     * @author XL
     * @create_time 2019/4/13
     */
    public void getUpdateTaskList(String vin, int pi, int ps, String uDate, final ResponseCallback<UpdateVehicleTasksResBean> callback) {
        OkHelper.getUpdateTaskList(context, vin, pi, ps, uDate, new JsonCallback<DataBackResult<UpdateVehicleTasksResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateVehicleTasksResBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
                        callback.onSuccess(response.body().getBody());

                        break;
                    case OkHelper.ERRO_NOT_FOUNT:
                        callback.onError(OkHelper.ERRO_NOT_FOUNT_MESSAGE);
                        break;
                    case OkHelper.ERRO_SERVER:
                        callback.onError(OkHelper.ERRO_SERVER_MESSAGE);
                        break;
                    case OkHelper.ERRO_UPTATE:
                        callback.onError(OkHelper.ERRO_UPTATE_MESSAGE);
                        break;
                    default:
                        callback.onError(OkHelper.ERRO_NOT_MESSAGE);
                        break;
                }
            }

            @Override
            public void onError(Response<DataBackResult<UpdateVehicleTasksResBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });
    }


    /**
     * @param vin 车辆VIN
     * @desc 查询当前车辆升级任务
     * @author XL
     * @create_time 2019/4/13
     */
    public void queryCarUpdateTask(String vin, String uDate,ResponseCallback<CurrentVehicleTaskResBean> callback) {
        this.vin = vin;
        this.uDate = uDate;
        this.currentVehicleTaskResBeanCallback = callback;
        if (isTask == 0) {
            vehicleTask = new MTimerTask(DELAY_TIME, new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            });
            vehicleTask.start();
            isTask = 1;
        }
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
    public void confirmUpgrade(String taskcarId, String uDate, int type, int result, final ResponseCallback<UpdateConfirInterfaceResBean> callback) {
        OkHelper.confirmUpgrade(context, taskcarId, uDate, type, result, new JsonCallback<DataBackResult<UpdateConfirInterfaceResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateConfirInterfaceResBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
                        callback.onSuccess(response.body().getBody());
                        break;
                    case OkHelper.ERRO_NOT_FOUNT:
                        callback.onError(OkHelper.ERRO_NOT_FOUNT_MESSAGE);
                        break;
                    case OkHelper.ERRO_SERVER:
                        callback.onError(OkHelper.ERRO_SERVER_MESSAGE);
                        break;
                    case OkHelper.ERRO_UPTATE:
                        callback.onError(OkHelper.ERRO_UPTATE_MESSAGE);
                        break;
                    default:
                        callback.onError(OkHelper.ERRO_NOT_MESSAGE);
                        break;
                }
            }

            @Override
            public void onError(Response<DataBackResult<UpdateConfirInterfaceResBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });
    }



    /**
     * @desc 清理任务（停止任务）
     * @author XL
     * @create_time 2019/4/17
     */
    public void clearTask() {
        if(isTask==1){
            vehicleTask.stop();
            isTask = 0;
        }
    }


}
