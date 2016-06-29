package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;

@Beta
public final class FileBackedOutputStream extends OutputStream
{
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
    
    public FileBackedOutputStream(final int n) {
        this(n, false);
    }
    
    public FileBackedOutputStream(final int fileThreshold, final boolean resetOnFinalize) {
        this.fileThreshold = fileThreshold;
        this.resetOnFinalize = resetOnFinalize;
        this.memory = new FileBackedOutputStream$MemoryOutput(null);
        this.out = this.memory;
        if (resetOnFinalize) {
            this.source = new FileBackedOutputStream$1(this);
        }
        else {
            this.source = new FileBackedOutputStream$2(this);
        }
    }
    
    public ByteSource asByteSource() {
        return this.source;
    }
    
    private synchronized InputStream openInputStream() {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
    }
    
    public synchronized void reset() {
        try {
            this.close();
        }
        finally {
            if (this.memory == null) {
                this.memory = new FileBackedOutputStream$MemoryOutput(null);
            }
            else {
                this.memory.reset();
            }
            this.out = this.memory;
            if (this.file != null) {
                final File file = this.file;
                this.file = null;
                if (!file.delete()) {
                    final String value = String.valueOf(file);
                    throw new IOException(new StringBuilder(18 + String.valueOf(value).length()).append("Could not delete: ").append(value).toString());
                }
            }
        }
    }
    
    @Override
    public synchronized void write(final int n) {
        this.update(1);
        this.out.write(n);
    }
    
    @Override
    public synchronized void write(final byte[] array) {
        this.write(array, 0, array.length);
    }
    
    @Override
    public synchronized void write(final byte[] array, final int n, final int n2) {
        this.update(n2);
        this.out.write(array, n, n2);
    }
    
    @Override
    public synchronized void close() {
        this.out.close();
    }
    
    @Override
    public synchronized void flush() {
        this.out.flush();
    }
    
    private void update(final int n) {
        if (this.file == null && this.memory.getCount() + n > this.fileThreshold) {
            final File tempFile = File.createTempFile("FileBackedOutputStream", null);
            if (this.resetOnFinalize) {
                tempFile.deleteOnExit();
            }
            final FileOutputStream out = new FileOutputStream(tempFile);
            out.write(this.memory.getBuffer(), 0, this.memory.getCount());
            out.flush();
            this.out = out;
            this.file = tempFile;
            this.memory = null;
        }
    }
}
