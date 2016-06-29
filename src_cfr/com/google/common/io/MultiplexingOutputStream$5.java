/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.MultiplexingOutputStream;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.OutputStream;

class MultiplexingOutputStream$5
implements MultiplexingOutputStream$OutputStreamCaller {
    final /* synthetic */ int val$b;
    final /* synthetic */ MultiplexingOutputStream this$0;

    MultiplexingOutputStream$5(MultiplexingOutputStream multiplexingOutputStream, int n2) {
        this.this$0 = multiplexingOutputStream;
        this.val$b = n2;
    }

    @Override
    public void call(OutputStream outputStream) {
        outputStream.write(this.val$b);
    }
}

