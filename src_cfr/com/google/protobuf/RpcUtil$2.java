/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil$AlreadyCalledException;

final class RpcUtil$2
implements RpcCallback {
    private boolean alreadyCalled;
    final /* synthetic */ RpcCallback val$originalCallback;

    RpcUtil$2(RpcCallback rpcCallback) {
        this.val$originalCallback = rpcCallback;
        this.alreadyCalled = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run(Object object) {
        RpcUtil$2 rpcUtil$2 = this;
        synchronized (rpcUtil$2) {
            if (this.alreadyCalled) {
                throw new RpcUtil$AlreadyCalledException();
            }
            this.alreadyCalled = true;
        }
        this.val$originalCallback.run(object);
    }
}

