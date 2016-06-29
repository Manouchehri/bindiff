/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import com.google.common.io.Files$1;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

final class Files$FileByteSource
extends ByteSource {
    private final File file;

    private Files$FileByteSource(File file) {
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
        if (!this.file.isFile()) return Optional.absent();
        return Optional.of(this.file.length());
    }

    @Override
    public long size() {
        if (this.file.isFile()) return this.file.length();
        throw new FileNotFoundException(this.file.toString());
    }

    @Override
    public byte[] read() {
        Closer closer = Closer.create();
        try {
            FileInputStream fileInputStream = (FileInputStream)closer.register(this.openStream());
            byte[] arrby = Files.readFile(fileInputStream, fileInputStream.getChannel().size());
            return arrby;
        }
        catch (Throwable var2_3) {
            throw closer.rethrow(var2_3);
        }
        finally {
            closer.close();
        }
    }

    public String toString() {
        String string = String.valueOf(this.file);
        return new StringBuilder(20 + String.valueOf(string).length()).append("Files.asByteSource(").append(string).append(")").toString();
    }

    /* synthetic */ Files$FileByteSource(File file, Files$1 files$1) {
        this(file);
    }
}

