package com.google.common.io;

import java.util.zip.*;
import com.google.common.base.*;
import java.io.*;

final class ZipFiles$ZipEntryByteSource extends ByteSource
{
    private final ZipFile file;
    private final ZipEntry entry;
    
    ZipFiles$ZipEntryByteSource(final ZipFile zipFile, final ZipEntry zipEntry) {
        this.file = (ZipFile)Preconditions.checkNotNull(zipFile);
        this.entry = (ZipEntry)Preconditions.checkNotNull(zipEntry);
    }
    
    @Override
    public InputStream openStream() {
        return this.file.getInputStream(this.entry);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.file);
        final String value2 = String.valueOf(this.entry);
        return new StringBuilder(25 + String.valueOf(value).length() + String.valueOf(value2).length()).append("ZipFiles.asByteSource(").append(value).append(", ").append(value2).append(")").toString();
    }
}
