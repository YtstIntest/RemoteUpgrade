package com.example.remoteupgradesdk.configs;

public class URLConfig {
    public static String IP = "http://nats.intestcar.com";//联调服务器


    public static String PORT = ":62078/api/fota/";//开发环境

    public static String IP_PORT = IP + PORT;


    /**
     * @desc 查询车辆升级任务信息
     * @author XL
     * @create_time 2019/4/27
     */
    public static String queryCarUpdateTask() {
        return IP_PORT + "s1";
    }

    /**
     * @desc 确认升级任务
     * @author XL
     * @create_time 2019/4/27
     */
    public static String confirmUpgrade() {
        return IP_PORT + "s2";
    }

    /**
     * @desc 获取历史升级记录
     * @author XL
     * @create_time 2019/4/27
     */
    public static String getUpdateTaskList() {
        return IP_PORT + "s3";
    }

}
