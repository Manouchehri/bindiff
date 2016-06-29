/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.io;

import com.google.common.io.ByteStreams;
import com.google.common.io.LittleEndianDataInputStream;
import com.google.common.io.RandomAccessZipStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class RandomAccessZipStream$ZipStreamEntry
implements Serializable {
    private static final long serialVersionUID = -3699231327290802232L;
    private final int versionMadeBy;
    private final int versionForExtraction;
    private final int bitFlags;
    private final int method;
    private final long time;
    private final long crc;
    private final long compressedSize;
    private final long size;
    private final int nameLen;
    private final int internalFileAttributes;
    private final long externalFileAttributes;
    private final long relativeOffsetToLocalHeader;
    private final String name;
    private final byte[] extra;
    private final String comment;

    RandomAccessZipStream$ZipStreamEntry(LittleEndianDataInputStream littleEndianDataInputStream, InputStream inputStream) {
        this.versionMadeBy = littleEndianDataInputStream.readUnsignedShort();
        this.versionForExtraction = littleEndianDataInputStream.readUnsignedShort();
        this.bitFlags = littleEndianDataInputStream.readUnsignedShort();
        this.method = littleEndianDataInputStream.readUnsignedShort();
        this.time = RandomAccessZipStream.access$200(littleEndianDataInputStream.readUnsignedShort(), littleEndianDataInputStream.readUnsignedShort());
        this.crc = 0xFFFFFFFFL & (long)littleEndianDataInputStream.readInt();
        this.compressedSize = littleEndianDataInputStream.readInt();
        this.size = littleEndianDataInputStream.readInt();
        this.nameLen = littleEndianDataInputStream.readUnsignedShort();
        int n2 = littleEndianDataInputStream.readUnsignedShort();
        int n3 = littleEndianDataInputStream.readUnsignedShort();
        littleEndianDataInputStream.readUnsignedShort();
        this.internalFileAttributes = littleEndianDataInputStream.readUnsignedShort();
        this.externalFileAttributes = littleEndianDataInputStream.readInt();
        this.relativeOffsetToLocalHeader = littleEndianDataInputStream.readInt();
        byte[] arrby = new byte[this.nameLen];
        ByteStreams.readFully(inputStream, arrby);
        if (n2 > 0) {
            this.extra = new byte[n2];
            ByteStreams.readFully(inputStream, this.extra);
        } else {
            this.extra = null;
        }
        byte[] arrby2 = null;
        if (n3 > 0) {
            arrby2 = new byte[n3];
            ByteStreams.readFully(inputStream, arrby2);
        }
        Charset charset = this.getEncoding();
        this.name = new String(arrby, charset);
        this.comment = arrby2 == null ? null : new String(arrby2, charset);
    }

    public String getComment() {
        return this.comment;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public long getCrc() {
        return this.crc;
    }

    public Charset getEncoding() {
        Charset charset;
        if (0 != (this.bitFlags >>> 11 & 1)) {
            charset = StandardCharsets.UTF_8;
            return charset;
        }
        charset = StandardCharsets.ISO_8859_1;
        return charset;
    }

    public byte[] getExtra() {
        if (this.extra == null) return null;
        byte[] arrby = (byte[])this.extra.clone();
        return arrby;
    }

    public int getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isDirectory() {
        return this.name.endsWith("/");
    }

    public int getInternalFileAttributes() {
        return this.internalFileAttributes;
    }

    public long getExternalFileAttributes() {
        return this.externalFileAttributes;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public long getRelativeOffsetToLocalHeader() {
        return this.relativeOffsetToLocalHeader;
    }

    public int getVersionForExtraction() {
        return this.versionForExtraction;
    }

    public String toString() {
        return this.name;
    }

    static /* synthetic */ long access$000(RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry) {
        return randomAccessZipStream$ZipStreamEntry.relativeOffsetToLocalHeader;
    }

    static /* synthetic */ int access$100(RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry) {
        return randomAccessZipStream$ZipStreamEntry.nameLen;
    }
}

