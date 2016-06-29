package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;

class FileBackedOutputStream$1 extends ByteSource
{
    final /* synthetic */ FileBackedOutputStream this$0;
    
    FileBackedOutputStream$1(final FileBackedOutputStream this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public InputStream openStream() {
        return this.this$0.openInputStream();
    }
    
    @Override
    protected void finalize() {
        try {
            this.this$0.reset();
        }
        catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }
}
