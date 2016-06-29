/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$4
implements MultiplexingOutputStream$OutputStreamCaller {
    final /* synthetic */ byte[] val$b;
    final /* synthetic */ int val$off;
    final /* synthetic */ int val$len;
    final /* synthetic */ MultiplexingOutputStream this$0;

    MultiplexingOutputStream$4(MultiplexingOutputStream multiplexingOutputStream, byte[] arrby, int n2, int n3) {
        this.this$0 = multiplexingOutputStream;
        this.val$b = arrby;
        this.val$off = n2;
        this.val$len = n3;
    }

    @Override
    public void call(OutputStream outputStream) {
        outputStream.write(this.val$b, this.val$off, this.val$len);
    }
}

