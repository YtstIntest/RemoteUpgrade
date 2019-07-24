package com.example.remoteupgradesdk.api;

import android.content.Context;

import com.example.remoteupgradesdk.bean.CurrentVehicleTaskResBean;
import com.example.remoteupgradesdk.bean.UpdateConfirInterfaceResBean;
import com.example.remoteupgradesdk.bean.UpdateVehicleTasksResBean;
import com.example.remoteupgradesdk.configs.Config;
import com.example.remoteupgradesdk.configs.URLConfig;
import com.example.remoteupgradesdk.interfaces.ResponseCallback;
import com.example.remoteupgradesdk.utils.LogicProcessing;


public class RemoteUpdateManage {
    private LogicProcessing logicProcessing;

    public RemoteUpdateManage(Context context) {
        logicProcessing = new LogicProcessing(context);
    }


    /**
     * @param config 环境枚举
     * @desc 设置环境
     * @author XL
     * @create_time 2019/5/16
     */
    public void configEnvironment(Config config) {
        switch (config) {
            case DEVELOPMENT:
                URLConfig.PORT = URLConfig.PORT_DEVELOP;
                break;
            case JOINT_TUNE:
                URLConfig.PORT = URLConfig.PORT_LASGING;
                break;
        }


    }


    /**
     * @desc 查询车辆升级任务信息回调接口
     * @author XL
     * @create_time 2019/5/16
     */
    public void setCurrentVehicleTaskCallback(ResponseCallback<CurrentVehicleTaskResBean> callback) {
        logicProcessing.setCurrentVehicleTaskResBeanCallback(callback);

    }

    /**
     * @desc 确认升级任务回调接口
     * @author XL
     * @create_time 2019/5/16
     */
    public void setUpdateConfirInterfaceCallback(ResponseCallback<UpdateConfirInterfaceResBean> callback) {
        logicProcessing.setUpdateConfirInterfaceResBeanCallback(callback);
    }

    /**
     * @desc 获取历史升级记录回调接口
     * @author XL
     * @create_time 2019/5/16
     */
    public void setUpdateVehicleTasksCallback(ResponseCallback<UpdateVehicleTasksResBean> callback) {
        logicProcessing.setUpdateVehicleTasksResBeanCallback(callback);
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
    public void getUpdateTaskList(String vin, int pi, int ps, String uDate) {
        logicProcessing.getUpdateTaskList(vin, pi, ps, uDate);
    }


    /**
     * @param vin 车辆VIN
     * @desc 查询当前车辆升级任务
     * @author XL
     * @create_time 2019/4/13
     */
    public void queryCarUpdateTask(String vin, String uDate) {
        logicProcessing.starQueryCarUpdateTask(vin, uDate);
    }

    /**
     * @desc 清理任务（停止任务）
     * @author XL
     * @create_time 2019/4/17
     */
    public void clearTask() {
        logicProcessing.stopQueryCarUpdateTask();
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
        logicProcessing.confirmUpgrade(taskcarId, uDate, type, result);
    }

}
