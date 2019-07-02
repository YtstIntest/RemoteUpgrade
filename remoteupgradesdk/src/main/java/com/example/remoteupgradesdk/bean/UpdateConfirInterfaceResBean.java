package com.example.remoteupgradesdk.bean;

public class UpdateConfirInterfaceResBean {

    /**
     * result : null
     * total : 0
     * code : 0
     * msg : 确认结果为取消，不保存
     */

    private Object result;
    private int total;
    private int code;
    private String msg;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
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
}
