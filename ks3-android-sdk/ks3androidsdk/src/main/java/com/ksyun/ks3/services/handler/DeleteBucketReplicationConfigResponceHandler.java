package com.ksyun.ks3.services.handler;

import com.ksyun.ks3.exception.Ks3Error;

import cz.msebera.android.httpclient.Header;

public abstract class DeleteBucketReplicationConfigResponceHandler extends Ks3HttpResponceHandler {

    public abstract void onFailure(int statesCode, Ks3Error error, Header[] responceHeaders, String response, Throwable paramThrowable);

    public abstract void onSuccess(int statesCode, Header[] responceHeaders);

    @Override
    public final void onSuccess(int statesCode, Header[] responceHeaders,byte[] response) {
        onSuccess(statesCode, responceHeaders);
    }

    @Override
    public final void onFailure(int statesCode, Header[] responceHeaders,byte[] response, Throwable throwable) {
        Ks3Error error = new Ks3Error(statesCode, response, throwable);
        onFailure(statesCode, error,responceHeaders, response == null ?"":new String(response), throwable);
    }

    @Override
    public final void onProgress(long bytesWritten, long totalSize) {}

    @Override
    public final void onStart() {}

    @Override
    public final void onFinish() {}

    @Override
    public final void onCancel() {}
}
