package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.nio.channels.*;

final class Files$FileByteSource extends ByteSource
{
    private final File file;
    
    private Files$FileByteSource(final File file) {
        this.file = (File)Preconditions.checkNotNull(file);
    }
    
    @Override
    public FileInputStream openStream() {
        return new FileInputStream(this.file);
    }
    
    @GoogleInternal
    @Override
    public FileChannel openChannel() {
        return this.openStream().getChannel();
    }
    
    @Override
    public Optional sizeIfKnown() {
        if (this.file.isFile()) {
            return Optional.of(this.file.length());
        }
        return Optional.absent();
    }
    
    @Override
    public long size() {
        if (!this.file.isFile()) {
            throw new FileNotFoundException(this.file.toString());
        }
        return this.file.length();
    }
    
    @Override
    public byte[] read() {
        final Closer create = Closer.create();
        try {
            final FileInputStream fileInputStream = (FileInputStream)create.register(this.openStream());
            return Files.readFile(fileInputStream, fileInputStream.getChannel().size());
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.file);
        return new StringBuilder(20 + String.valueOf(value).length()).append("Files.asByteSource(").append(value).append(")").toString();
    }
}
