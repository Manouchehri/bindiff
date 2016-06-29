package com.google.common.io;

import java.io.*;

class MultiplexingOutputStream$1 implements MultiplexingOutputStream$OutputStreamCaller
{
    final /* synthetic */ MultiplexingOutputStream this$0;
    
    MultiplexingOutputStream$1(final MultiplexingOutputStream this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void call(final OutputStream outputStream) {
        outputStream.close();
    }
}
