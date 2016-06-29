package com.google.common.io;

import java.nio.file.*;
import java.nio.file.attribute.*;
import com.google.common.base.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;

final class MoreFiles$PathByteSource extends ByteSource
{
    private static final LinkOption[] FOLLOW_LINKS;
    private final Path path;
    private final OpenOption[] options;
    private final boolean followLinks;
    
    private MoreFiles$PathByteSource(final Path path, final OpenOption... array) {
        this.path = (Path)Preconditions.checkNotNull(path);
        this.options = array.clone();
        this.followLinks = followLinks(this.options);
    }
    
    private static boolean followLinks(final OpenOption[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == LinkOption.NOFOLLOW_LINKS) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public InputStream openStream() {
        return Files.newInputStream(this.path, this.options);
    }
    
    @Override
    public SeekableByteChannel openChannel() {
        return Files.newByteChannel(this.path, this.options);
    }
    
    private BasicFileAttributes readAttributes() {
        final Path path = this.path;
        final Class<BasicFileAttributes> clazz = BasicFileAttributes.class;
        final LinkOption[] array;
        if (this.followLinks) {
            final LinkOption[] follow_LINKS = MoreFiles$PathByteSource.FOLLOW_LINKS;
        }
        else {
            array = new LinkOption[] { LinkOption.NOFOLLOW_LINKS };
        }
        return Files.readAttributes(path, clazz, array);
    }
    
    @Override
    public Optional sizeIfKnown() {
        BasicFileAttributes attributes;
        try {
            attributes = this.readAttributes();
        }
        catch (IOException ex) {
            return Optional.absent();
        }
        if (attributes.isDirectory() || attributes.isSymbolicLink()) {
            return Optional.absent();
        }
        return Optional.of(attributes.size());
    }
    
    @Override
    public long size() {
        final BasicFileAttributes attributes = this.readAttributes();
        if (attributes.isDirectory()) {
            throw new IOException("can't read: is a directory");
        }
        if (attributes.isSymbolicLink()) {
            throw new IOException("can't read: is a symbolic link");
        }
        return attributes.size();
    }
    
    @Override
    public byte[] read() {
        try (final SeekableByteChannel openChannel = this.openChannel()) {
            return com.google.common.io.Files.readFile(Channels.newInputStream(openChannel), openChannel.size());
        }
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.path);
        final String value2 = String.valueOf(Arrays.toString(this.options));
        return new StringBuilder(26 + String.valueOf(value).length() + String.valueOf(value2).length()).append("MoreFiles.asByteSource(").append(value).append(", ").append(value2).append(")").toString();
    }
    
    static {
        FOLLOW_LINKS = new LinkOption[0];
    }
}
