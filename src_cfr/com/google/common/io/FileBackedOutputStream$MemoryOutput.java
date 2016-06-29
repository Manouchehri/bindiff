/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.FileBackedOutputStream$1;
import java.io.ByteArrayOutputStream;

class FileBackedOutputStream$MemoryOutput
extends ByteArrayOutputStream {
    private FileBackedOutputStream$MemoryOutput() {
    }

    byte[] getBuffer() {
        return this.buf;
    }

    int getCount() {
        return this.count;
    }

    /* synthetic */ FileBackedOutputStream$MemoryOutput(FileBackedOutputStream$1 fileBackedOutputStream$1) {
        this();
    }
}

