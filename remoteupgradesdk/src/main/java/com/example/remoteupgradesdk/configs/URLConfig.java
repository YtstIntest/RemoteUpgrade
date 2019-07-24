package com.example.remoteupgradesdk.configs;

public class URLConfig {
    public static String IP = "http://113.57.170.58";


    public static String PORT_DEVELOP = ":62063";//开发环境

    public static String PORT_LASGING= ":62067";//联调环境







    public static String PORT= ":62067";//默认环境


    public static String IP_PORT = IP + PORT;

    public static String host = IP_PORT + "/api/fota/";




    /**
     * @desc 查询车辆升级任务信息
     * @author XL
     * @create_time 2019/4/27
     */
    public static String queryCarUpdateTask = host + "s1";

    /**
     * @desc 确认升级任务
     * @author XL
     * @create_time 2019/4/27
     */
    public static String confirmUpgrade = host + "s2";

    /**
     * @desc 获取历史升级记录
     * @author XL
     * @create_time 2019/4/27
     */
    public static String getUpdateTaskList = host + "s3";

}
