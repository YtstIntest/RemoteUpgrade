package com.example.remoteupgradesdk.configs;

import android.content.Context;

import com.example.remoteupgradesdk.bean.CurrentVehicleTaskResBean;
import com.example.remoteupgradesdk.bean.UpdateConfirInterfaceResBean;
import com.example.remoteupgradesdk.bean.UpdateVehicleTasksResBean;
import com.example.remoteupgradesdk.callback.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;

import java.util.Observable;

public class OkHelper extends Observable {
    public static final int SUCCESS = 200;
    public static final int ERRO_NOT_FOUNT = 404;
    public static String ERRO_NOT_FOUNT_MESSAGE = "未找到请求路由，多用于下载文件时，文件不存在或文件不能被下载";

    public static final int ERRO_SERVER = 500;
    public static String ERRO_SERVER_MESSAGE = "服务端错误";

    public static final int ERRO_UPTATE = 206;
    public static String ERRO_UPTATE_MESSAGE = "下载部分文件时，成功响应";

    public static String ERRO_NOT_MESSAGE = "未知错误";
    public static String ERRO_MESSAGE = "加载异常，请重试！！！";



    /**
     * @param vin 车辆VIN
     * @desc 查询车辆升级任务信息
     * @author XL
     * @create_time 2019/4/27
     */
    public static void queryCarUpdateTask(Context context, String vin, String uDate, String taskcarId, JsonCallback<DataBackResult<CurrentVehicleTaskResBean>> callback) {
        OkGo.<DataBackResult<CurrentVehicleTaskResBean>>get(URLConfig.queryCarUpdateTask())
                .tag(context)
                .cacheMode(CacheMode.NO_CACHE)
                .params("vin", vin)
                .params("uDate", uDate)
                .params("taskcarId", taskcarId)
                .execute(callback);
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
    public static void confirmUpgrade(Context context, String taskcarId, String uDate, int type, int result, JsonCallback<DataBackResult<UpdateConfirInterfaceResBean>> callback) {
        OkGo.<DataBackResult<UpdateConfirInterfaceResBean>>get(URLConfig.confirmUpgrade())
                .tag(context)
                .cacheMode(CacheMode.NO_CACHE)
                .params("taskCarId", taskcarId)
                .params("uDate", uDate)
                .params("type", type)
                .params("result", result)
                .execute(callback);
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
    public static void getUpdateTaskList(Context context, String vin, int pi, int ps, String uDate, JsonCallback<DataBackResult<UpdateVehicleTasksResBean>> callback) {
        OkGo.<DataBackResult<UpdateVehicleTasksResBean>>get(URLConfig.getUpdateTaskList())
                .tag(context)
                .cacheMode(CacheMode.NO_CACHE)
                .params("vin", vin)
                .params("pi", pi)
                .params("ps", ps)
                .params("uDate", uDate)
                .execute(callback);
    }

}
