package com.google.common.io;

import java.io.*;

class MultiplexingOutputStream$2 implements MultiplexingOutputStream$OutputStreamCaller
{
    final /* synthetic */ MultiplexingOutputStream this$0;
    
    MultiplexingOutputStream$2(final MultiplexingOutputStream this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void call(final OutputStream outputStream) {
        outputStream.flush();
    }
}
