package com.example.remoteupgradesdk.configs;

public class URLConfig {
    public static String IP = "http://113.57.170.58";


    public static String PORT_DEVELOP = ":62063";//开发环境

    public static String PORT_LASGING= ":62067";//联调环境




    public static String IP_PORT = IP + PORT_LASGING;

    public static String host = IP_PORT + "/api/fota/";


    /**
     * @param config 环境枚举
     * @desc 设置环境
     * @author XL
     * @create_time 2019/5/16
     */
    public static void configEnvironment(Config config) {
        switch (config) {
            case DEVELOPMENT:
                IP_PORT = IP + PORT_DEVELOP;
                break;
            case JOINT_TUNE:
               IP_PORT = IP + PORT_LASGING;
                break;
        }
    }


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
