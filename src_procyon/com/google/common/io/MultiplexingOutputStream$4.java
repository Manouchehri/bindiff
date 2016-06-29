package com.google.common.io;

import java.io.*;

class MultiplexingOutputStream$4 implements MultiplexingOutputStream$OutputStreamCaller
{
    final /* synthetic */ byte[] val$b;
    final /* synthetic */ int val$off;
    final /* synthetic */ int val$len;
    final /* synthetic */ MultiplexingOutputStream this$0;
    
    MultiplexingOutputStream$4(final MultiplexingOutputStream this$0, final byte[] val$b, final int val$off, final int val$len) {
        this.this$0 = this$0;
        this.val$b = val$b;
        this.val$off = val$off;
        this.val$len = val$len;
    }
    
    @Override
    public void call(final OutputStream outputStream) {
        outputStream.write(this.val$b, this.val$off, this.val$len);
    }
}
