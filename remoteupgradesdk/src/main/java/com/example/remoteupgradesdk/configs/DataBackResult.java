package com.example.remoteupgradesdk.configs;

/**
 * @author Zhaohao
 * @Description: 数据返回泛型转换对象
 * @Date 2017/08/17 17:28
 */

public class DataBackResult<T> {


    /**
     * statusCode : 100
     * body : [{"uuid":"ff452efd-6ef2-48c2-8111-8a6f0e9437ca","userUUID":"bae064ae-a8cf-458b-84a8-8ef3555ff913","name":"小米"}]
     */

    private int statusCode;
    private T body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
