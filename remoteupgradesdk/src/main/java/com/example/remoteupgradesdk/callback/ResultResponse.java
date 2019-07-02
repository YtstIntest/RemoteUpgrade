
package com.example.remoteupgradesdk.callback;

import java.io.Serializable;

public class ResultResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public String messageCode;
    public String messageDetail;
    public T data;

    @Override
    public String toString() {
        return "ResultResponse{\n" +//
                "\tcode=" + messageCode + "\n" +//
                "\tmsg='" + messageDetail + "\'\n" +//
                "\tdata=" + data + "\n" +//
                '}';
    }
}
