/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$2
implements MultiplexingOutputStream$OutputStreamCaller {
    final /* synthetic */ MultiplexingOutputStream this$0;

    MultiplexingOutputStream$2(MultiplexingOutputStream multiplexingOutputStream) {
        this.this$0 = multiplexingOutputStream;
    }

    @Override
    public void call(OutputStream outputStream) {
        outputStream.flush();
    }
}

