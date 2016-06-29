/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream$1;
import com.google.common.io.FileBackedOutputStream$2;
import com.google.common.io.FileBackedOutputStream$MemoryOutput;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
public final class FileBackedOutputStream
extends OutputStream {
    private final int fileThreshold;
    private final boolean resetOnFinalize;
    private final ByteSource source;
    private OutputStream out;
    private FileBackedOutputStream$MemoryOutput memory;
    private File file;

    @VisibleForTesting
    synchronized File getFile() {
        return this.file;
    }

    public FileBackedOutputStream(int n2) {
        this(n2, false);
    }

    public FileBackedOutputStream(int n2, boolean bl2) {
        this.fileThreshold = n2;
        this.resetOnFinalize = bl2;
        this.out = this.memory = new FileBackedOutputStream$MemoryOutput(null);
        if (bl2) {
            this.source = new FileBackedOutputStream$1(this);
            return;
        }
        this.source = new FileBackedOutputStream$2(this);
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    private synchronized InputStream openInputStream() {
        if (this.file == null) return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
        return new FileInputStream(this.file);
    }

    public synchronized void reset() {
        try {
            this.close();
            return;
        }
        finally {
            if (this.memory == null) {
                this.memory = new FileBackedOutputStream$MemoryOutput(null);
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            if (this.file != null) {
                File file = this.file;
                this.file = null;
                if (!file.delete()) {
                    String string = String.valueOf(file);
                    throw new IOException(new StringBuilder(18 + String.valueOf(string).length()).append("Could not delete: ").append(string).toString());
                }
            }
        }
    }

    @Override
    public synchronized void write(int n2) {
        this.update(1);
        this.out.write(n2);
    }

    @Override
    public synchronized void write(byte[] arrby) {
        this.write(arrby, 0, arrby.length);
    }

    @Override
    public synchronized void write(byte[] arrby, int n2, int n3) {
        this.update(n3);
        this.out.write(arrby, n2, n3);
    }

    @Override
    public synchronized void close() {
        this.out.close();
    }

    @Override
    public synchronized void flush() {
        this.out.flush();
    }

    private void update(int n2) {
        if (this.file != null) return;
        if (this.memory.getCount() + n2 <= this.fileThreshold) return;
        File file = File.createTempFile("FileBackedOutputStream", null);
        if (this.resetOnFinalize) {
            file.deleteOnExit();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
        fileOutputStream.flush();
        this.out = fileOutputStream;
        this.file = file;
        this.memory = null;
    }

    static /* synthetic */ InputStream access$100(FileBackedOutputStream fileBackedOutputStream) {
        return fileBackedOutputStream.openInputStream();
    }
}

