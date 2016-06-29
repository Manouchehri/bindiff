package com.google.common.io;

import com.google.common.collect.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.nio.channels.*;
import java.io.*;

final class Files$FileByteSink extends ByteSink
{
    private final File file;
    private final ImmutableSet modes;
    
    private Files$FileByteSink(final File file, final FileWriteMode... array) {
        this.file = (File)Preconditions.checkNotNull(file);
        this.modes = ImmutableSet.copyOf(array);
    }
    
    @Override
    public FileOutputStream openStream() {
        return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
    }
    
    @GoogleInternal
    @Override
    public FileChannel openChannel() {
        return this.openStream().getChannel();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.file);
        final String value2 = String.valueOf(this.modes);
        return new StringBuilder(20 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Files.asByteSink(").append(value).append(", ").append(value2).append(")").toString();
    }
}
