
package com.example.remoteupgradesdk.callback;


import java.io.Serializable;

public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public String code;
    public String msg;

    public ResultResponse toLzyResponse() {
        ResultResponse lzyResponse = new ResultResponse();
        lzyResponse.messageCode = code;
        lzyResponse.messageDetail = msg;
        return lzyResponse;
    }
}
