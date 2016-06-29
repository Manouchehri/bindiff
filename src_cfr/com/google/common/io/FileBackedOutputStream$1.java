/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class FileBackedOutputStream$1
extends ByteSource {
    final /* synthetic */ FileBackedOutputStream this$0;

    FileBackedOutputStream$1(FileBackedOutputStream fileBackedOutputStream) {
        this.this$0 = fileBackedOutputStream;
    }

    @Override
    public InputStream openStream() {
        return FileBackedOutputStream.access$100(this.this$0);
    }

    protected void finalize() {
        try {
            this.this$0.reset();
            return;
        }
        catch (Throwable var1_1) {
            var1_1.printStackTrace(System.err);
        }
    }
}

