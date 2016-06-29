/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class ZipFiles$ZipEntryByteSource
extends ByteSource {
    private final ZipFile file;
    private final ZipEntry entry;

    ZipFiles$ZipEntryByteSource(ZipFile zipFile, ZipEntry zipEntry) {
        this.file = (ZipFile)Preconditions.checkNotNull(zipFile);
        this.entry = (ZipEntry)Preconditions.checkNotNull(zipEntry);
    }

    @Override
    public InputStream openStream() {
        return this.file.getInputStream(this.entry);
    }

    public String toString() {
        String string = String.valueOf(this.file);
        String string2 = String.valueOf(this.entry);
        return new StringBuilder(25 + String.valueOf(string).length() + String.valueOf(string2).length()).append("ZipFiles.asByteSource(").append(string).append(", ").append(string2).append(")").toString();
    }
}

