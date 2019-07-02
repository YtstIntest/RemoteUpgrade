package com.example.remoteupgradesdk.interfaces;

public interface ResponseCallback<T> {
    void onSuccess(T bean);

    void onError(String msg);
}
