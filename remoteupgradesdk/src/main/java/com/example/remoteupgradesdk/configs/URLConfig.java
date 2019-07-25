package com.example.remoteupgradesdk.configs;

public class URLConfig {
    public static String IP = "http://113.57.170.58";


    public static String PORT_DEVELOP = ":62063/api/fota/";//开发环境

    public static String PORT_LASGING = ":62067/api/fota/";//联调环境


    public static Config config = Config.JOINT_TUNE;//默认环境

    /**
     * @desc 设置环境
     * @author XL
     * @create_time 2019/5/16
     */
    public static String configEnvironment() {
        switch (config) {
            case DEVELOPMENT:
                return IP + PORT_DEVELOP;
            case JOINT_TUNE:
                return IP + PORT_LASGING;
        }
        return IP + PORT_LASGING;
    }

    /**
     * @desc 查询车辆升级任务信息
     * @author XL
     * @create_time 2019/4/27
     */
    public static String queryCarUpdateTask() {
        return configEnvironment() + "s1";
    }

    /**
     * @desc 确认升级任务
     * @author XL
     * @create_time 2019/4/27
     */
    public static String confirmUpgrade() {
        return configEnvironment() + "s2";
    }

    /**
     * @desc 获取历史升级记录
     * @author XL
     * @create_time 2019/4/27
     */
    public static String getUpdateTaskList() {
        return configEnvironment() + "s3";
    }

}
