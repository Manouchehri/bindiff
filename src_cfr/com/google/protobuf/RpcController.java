/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.RpcCallback;

public interface RpcController {
    public void reset();

    public boolean failed();

    public String errorText();

    public void startCancel();

    public void setFailed(String var1);

    public boolean isCanceled();

    public void notifyOnCancel(RpcCallback var1);
}

