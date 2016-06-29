package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;

class FileBackedOutputStream$2 extends ByteSource
{
    final /* synthetic */ FileBackedOutputStream this$0;
    
    FileBackedOutputStream$2(final FileBackedOutputStream this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public InputStream openStream() {
        return this.this$0.openInputStream();
    }
}
