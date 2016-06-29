package com.google.common.io;

import java.nio.charset.*;
import javax.annotation.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.util.zip.*;
import java.util.*;

@Immutable
public final class RandomAccessZipStream$ZipStreamEntry implements Serializable
{
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
    
    RandomAccessZipStream$ZipStreamEntry(final LittleEndianDataInputStream littleEndianDataInputStream, final InputStream inputStream) {
        this.versionMadeBy = littleEndianDataInputStream.readUnsignedShort();
        this.versionForExtraction = littleEndianDataInputStream.readUnsignedShort();
        this.bitFlags = littleEndianDataInputStream.readUnsignedShort();
        this.method = littleEndianDataInputStream.readUnsignedShort();
        this.time = dosToJavaTime(littleEndianDataInputStream.readUnsignedShort(), littleEndianDataInputStream.readUnsignedShort());
        this.crc = (0xFFFFFFFFL & littleEndianDataInputStream.readInt());
        this.compressedSize = littleEndianDataInputStream.readInt();
        this.size = littleEndianDataInputStream.readInt();
        this.nameLen = littleEndianDataInputStream.readUnsignedShort();
        final int unsignedShort = littleEndianDataInputStream.readUnsignedShort();
        final int unsignedShort2 = littleEndianDataInputStream.readUnsignedShort();
        littleEndianDataInputStream.readUnsignedShort();
        this.internalFileAttributes = littleEndianDataInputStream.readUnsignedShort();
        this.externalFileAttributes = littleEndianDataInputStream.readInt();
        this.relativeOffsetToLocalHeader = littleEndianDataInputStream.readInt();
        final byte[] array = new byte[this.nameLen];
        ByteStreams.readFully(inputStream, array);
        if (unsignedShort > 0) {
            ByteStreams.readFully(inputStream, this.extra = new byte[unsignedShort]);
        }
        else {
            this.extra = null;
        }
        byte[] array2 = null;
        if (unsignedShort2 > 0) {
            array2 = new byte[unsignedShort2];
            ByteStreams.readFully(inputStream, array2);
        }
        final Charset encoding = this.getEncoding();
        this.name = new String(array, encoding);
        this.comment = ((array2 == null) ? null : new String(array2, encoding));
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
        return (0x0 != (this.bitFlags >>> 11 & 0x1)) ? StandardCharsets.UTF_8 : StandardCharsets.ISO_8859_1;
    }
    
    public byte[] getExtra() {
        return (byte[])((this.extra != null) ? ((byte[])this.extra.clone()) : null);
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
    
    @Override
    public String toString() {
        return this.name;
    }
}
