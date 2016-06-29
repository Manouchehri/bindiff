package com.google.common.io;

import java.io.*;

class MultiplexingOutputStream$5 implements MultiplexingOutputStream$OutputStreamCaller
{
    final /* synthetic */ int val$b;
    final /* synthetic */ MultiplexingOutputStream this$0;
    
    MultiplexingOutputStream$5(final MultiplexingOutputStream this$0, final int val$b) {
        this.this$0 = this$0;
        this.val$b = val$b;
    }
    
    @Override
    public void call(final OutputStream outputStream) {
        outputStream.write(this.val$b);
    }
}
