package com.example.remoteupgradesdk.bean;

public class CurrentVehicleTaskResBean {


    /**
     * result : {"taskCarId":"39dbb5e7-1efe-44d5-8128-500ee6a575e0","taskType":1,"cVer":"1231231211","nVer":"555554444422223111111111","size":1.062,"description":"\n\ntesttesttesttesttesttest\ntesttesttesttesttesttest\ntesttesttesttesttesttest\n testtesttesttesttesttest\n        testtesttesttesttesttest\n\ntesttesttesttesttesttest\n           testtesttesttesttesttest","duration":10,"progress":0,"status":10,"result":-1,"resultCode":5354,"isNewTask":1,"time":"2020年6月17日 17:23"}
     * total : 1
     * code : 1
     * msg : null
     */

    private ResultBean result;
    private int total;
    private int code;
    private String msg;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * taskCarId : 39dbb5e7-1efe-44d5-8128-500ee6a575e0
         * taskType : 1
         * cVer : 1231231211
         * nVer : 555554444422223111111111
         * size : 1.062
         * description :

         testtesttesttesttesttest
         testtesttesttesttesttest
         testtesttesttesttesttest
         testtesttesttesttesttest
         testtesttesttesttesttest

         testtesttesttesttesttest
         testtesttesttesttesttest
         * duration : 10
         * progress : 0
         * status : 10
         * result : -1
         * resultCode : 5354
         * isNewTask : 1
         * time : 2020年6月17日 17:23
         */

        private String taskCarId;
        private int taskType;
        private String cVer;
        private String nVer;
        private double size;
        private String description;
        private int duration;
        private int progress;
        private int status;
        private int result;
        private int resultCode;
        private int isNewTask;
        private String time;

        public String getTaskCarId() {
            return taskCarId;
        }

        public void setTaskCarId(String taskCarId) {
            this.taskCarId = taskCarId;
        }

        public int getTaskType() {
            return taskType;
        }

        public void setTaskType(int taskType) {
            this.taskType = taskType;
        }

        public String getCVer() {
            return cVer;
        }

        public void setCVer(String cVer) {
            this.cVer = cVer;
        }

        public String getNVer() {
            return nVer;
        }

        public void setNVer(String nVer) {
            this.nVer = nVer;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getResultCode() {
            return resultCode;
        }

        public void setResultCode(int resultCode) {
            this.resultCode = resultCode;
        }

        public int getIsNewTask() {
            return isNewTask;
        }

        public void setIsNewTask(int isNewTask) {
            this.isNewTask = isNewTask;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
