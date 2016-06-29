/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files$1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

final class Files$FileByteSink
extends ByteSink {
    private final File file;
    private final ImmutableSet modes;

    private /* varargs */ Files$FileByteSink(File file, FileWriteMode ... arrfileWriteMode) {
        this.file = (File)Preconditions.checkNotNull(file);
        this.modes = ImmutableSet.copyOf((Object[])arrfileWriteMode);
    }

    @Override
    public FileOutputStream openStream() {
        return new FileOutputStream(this.file, this.modes.contains((Object)FileWriteMode.APPEND));
    }

    @GoogleInternal
    @Override
    public FileChannel openChannel() {
        return this.openStream().getChannel();
    }

    public String toString() {
        String string = String.valueOf(this.file);
        String string2 = String.valueOf(this.modes);
        return new StringBuilder(20 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Files.asByteSink(").append(string).append(", ").append(string2).append(")").toString();
    }

    /* synthetic */ Files$FileByteSink(File file, FileWriteMode[] arrfileWriteMode, Files$1 files$1) {
        this(file, arrfileWriteMode);
    }
}

