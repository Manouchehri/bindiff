/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$3
implements MultiplexingOutputStream$OutputStreamCaller {
    final /* synthetic */ byte[] val$b;
    final /* synthetic */ MultiplexingOutputStream this$0;

    MultiplexingOutputStream$3(MultiplexingOutputStream multiplexingOutputStream, byte[] arrby) {
        this.this$0 = multiplexingOutputStream;
        this.val$b = arrby;
    }

    @Override
    public void call(OutputStream outputStream) {
        outputStream.write(this.val$b);
    }
}

