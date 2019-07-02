package com.example.remoteupgradesdk.bean;

import java.util.List;

public class UpdateVehicleTasksResBean {


    /**
     * result : [{"index":1,"taskCarId":"3a523d8a-5ce1-4a8b-bec9-75b64c7c8dde","status":0,"description":null}]
     * total : 1
     * code : 1
     * msg : null
     */

    private int total;
    private int code;
    private String msg;
    private List<ResultBean> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * index : 1
         * taskCarId : 3a523d8a-5ce1-4a8b-bec9-75b64c7c8dde
         * status : 0
         * description : null
         */

        private int index;
        private String taskCarId;
        private int status;
        private String description;
        private String upgradeDate;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTaskCarId() {
            return taskCarId;
        }

        public void setTaskCarId(String taskCarId) {
            this.taskCarId = taskCarId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUpgradeDate() {
            return upgradeDate;
        }

        public void setUpgradeDate(String upgradeDate) {
            this.upgradeDate = upgradeDate;
        }
    }
}
