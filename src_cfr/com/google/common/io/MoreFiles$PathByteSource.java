/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import com.google.common.io.MoreFiles$1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

final class MoreFiles$PathByteSource
extends ByteSource {
    private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
    private final Path path;
    private final OpenOption[] options;
    private final boolean followLinks;

    private /* varargs */ MoreFiles$PathByteSource(Path path, OpenOption ... arropenOption) {
        this.path = (Path)Preconditions.checkNotNull(path);
        this.options = (OpenOption[])arropenOption.clone();
        this.followLinks = MoreFiles$PathByteSource.followLinks(this.options);
    }

    private static boolean followLinks(OpenOption[] arropenOption) {
        OpenOption[] arropenOption2 = arropenOption;
        int n2 = arropenOption2.length;
        int n3 = 0;
        while (n3 < n2) {
            OpenOption openOption = arropenOption2[n3];
            if (openOption == LinkOption.NOFOLLOW_LINKS) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    @Override
    public InputStream openStream() {
        return java.nio.file.Files.newInputStream(this.path, this.options);
    }

    @Override
    public SeekableByteChannel openChannel() {
        return java.nio.file.Files.newByteChannel(this.path, this.options);
    }

    private BasicFileAttributes readAttributes() {
        LinkOption[] arrlinkOption;
        if (this.followLinks) {
            arrlinkOption = FOLLOW_LINKS;
            return java.nio.file.Files.readAttributes(this.path, BasicFileAttributes.class, arrlinkOption);
        }
        LinkOption[] arrlinkOption2 = new LinkOption[1];
        arrlinkOption = arrlinkOption2;
        arrlinkOption2[0] = LinkOption.NOFOLLOW_LINKS;
        return java.nio.file.Files.readAttributes(this.path, BasicFileAttributes.class, arrlinkOption);
    }

    @Override
    public Optional sizeIfKnown() {
        BasicFileAttributes basicFileAttributes;
        try {
            basicFileAttributes = this.readAttributes();
        }
        catch (IOException var2_2) {
            return Optional.absent();
        }
        if (basicFileAttributes.isDirectory()) return Optional.absent();
        if (!basicFileAttributes.isSymbolicLink()) return Optional.of(basicFileAttributes.size());
        return Optional.absent();
    }

    @Override
    public long size() {
        BasicFileAttributes basicFileAttributes = this.readAttributes();
        if (basicFileAttributes.isDirectory()) {
            throw new IOException("can't read: is a directory");
        }
        if (!basicFileAttributes.isSymbolicLink()) return basicFileAttributes.size();
        throw new IOException("can't read: is a symbolic link");
    }

    @Override
    public byte[] read() {
        SeekableByteChannel seekableByteChannel = this.openChannel();
        Throwable throwable = null;
        try {
            byte[] arrby = Files.readFile(Channels.newInputStream(seekableByteChannel), seekableByteChannel.size());
            return arrby;
        }
        catch (Throwable var3_4) {
            throwable = var3_4;
            throw var3_4;
        }
        finally {
            if (seekableByteChannel != null) {
                if (throwable != null) {
                    try {
                        seekableByteChannel.close();
                    }
                    catch (Throwable var4_5) {
                        throwable.addSuppressed(var4_5);
                    }
                } else {
                    seekableByteChannel.close();
                }
            }
        }
    }

    public String toString() {
        String string = String.valueOf(this.path);
        String string2 = String.valueOf(Arrays.toString(this.options));
        return new StringBuilder(26 + String.valueOf(string).length() + String.valueOf(string2).length()).append("MoreFiles.asByteSource(").append(string).append(", ").append(string2).append(")").toString();
    }

    /* synthetic */ MoreFiles$PathByteSource(Path path, OpenOption[] arropenOption, MoreFiles$1 moreFiles$1) {
        this(path, arropenOption);
    }
}

