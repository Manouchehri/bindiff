package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.zip.*;
import java.util.*;
import java.io.*;
import javax.annotation.concurrent.*;
import java.nio.charset.*;

@NotThreadSafe
@GoogleInternal
public final class RandomAccessZipStream
{
    private static final int MINIMUM_INFLATER_BUFFER_SIZE = 1024;
    private static final int MAXIMUM_INFLATER_BUFFER_SIZE = 65535;
    private static final int MAXIMUM_ZIP_COMMENT_SIZE = 65535;
    private static final int CENSIG = 33639248;
    private static final int ENDSIG = 101010256;
    private static final int ENDSIG64 = 101075792;
    private static final int ENDHDR = 22;
    private static final int LOCAL_FILE_NAME_LENGTH = 26;
    private static final int LOCEXT = 28;
    private static final String ZIP_PATH_SEPARATOR = "/";
    private final int streamLength;
    private final InputStream underlyingZipStream;
    private final LittleEndianDataInputStream littleEndianInputStream;
    private final LinkedHashMap entries;
    
    public RandomAccessZipStream(final InputStream underlyingZipStream, final int streamLength) {
        this.entries = new LinkedHashMap();
        Preconditions.checkArgument(0 < streamLength, (Object)"Must specify the length of the ZIP archive");
        Preconditions.checkArgument(underlyingZipStream.markSupported(), (Object)"InputStream must support marking and resetting");
        this.streamLength = streamLength;
        this.underlyingZipStream = underlyingZipStream;
        this.littleEndianInputStream = new LittleEndianDataInputStream(underlyingZipStream);
        underlyingZipStream.mark(streamLength);
        this.initializeCentralDirectory();
    }
    
    public RandomAccessZipStream(final byte[] array) {
        this(new ByteArrayInputStream(array), array.length);
    }
    
    public Collection getEntries() {
        return Collections.unmodifiableCollection(this.entries.values());
    }
    
    public RandomAccessZipStream$ZipStreamEntry getEntry(final String s) {
        Preconditions.checkNotNull(s);
        final RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry = this.entries.get(s);
        RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry2;
        if (randomAccessZipStream$ZipStreamEntry != null) {
            randomAccessZipStream$ZipStreamEntry2 = randomAccessZipStream$ZipStreamEntry;
        }
        else {
            final LinkedHashMap entries = this.entries;
            final String value = String.valueOf(s);
            final String value2 = String.valueOf("/");
            randomAccessZipStream$ZipStreamEntry2 = entries.get((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        return randomAccessZipStream$ZipStreamEntry2;
    }
    
    public InputStream getInputStream(final RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry) {
        Preconditions.checkNotNull(randomAccessZipStream$ZipStreamEntry, (Object)"entry");
        Preconditions.checkArgument(randomAccessZipStream$ZipStreamEntry == this.getEntry(randomAccessZipStream$ZipStreamEntry.getName()), (Object)"Entry doesn't belong to this RandomAccessZipStream");
        try {
            this.underlyingZipStream.reset();
            ByteStreams.skipFully(this.underlyingZipStream, randomAccessZipStream$ZipStreamEntry.relativeOffsetToLocalHeader + 28L);
            ByteStreams.skipFully(this.underlyingZipStream, randomAccessZipStream$ZipStreamEntry.nameLen + this.littleEndianInputStream.readUnsignedShort());
        }
        catch (IOException ex2) {
            final ZipException ex = new ZipException("Error finding local record in ZIP.");
            ex.initCause(ex2);
            throw ex;
        }
        InputStream underlyingZipStream = null;
        switch (randomAccessZipStream$ZipStreamEntry.getMethod()) {
            case 8: {
                underlyingZipStream = new InflaterInputStream(this.underlyingZipStream, new Inflater(true), (int)Math.max(1024L, Math.min(randomAccessZipStream$ZipStreamEntry.getSize(), 65535L)));
                break;
            }
            case 0: {
                underlyingZipStream = this.underlyingZipStream;
                break;
            }
            default: {
                throw new ZipException("Unsupported ZIP compression method.");
            }
        }
        return ByteStreams.limit(underlyingZipStream, randomAccessZipStream$ZipStreamEntry.getSize());
    }
    
    public String getLocalFileHeaderName(final RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry) {
        Preconditions.checkNotNull(randomAccessZipStream$ZipStreamEntry, (Object)"entry");
        Preconditions.checkArgument(randomAccessZipStream$ZipStreamEntry == this.getEntry(randomAccessZipStream$ZipStreamEntry.getName()), (Object)"Entry doesn't belong to this RandomAccessZipStream");
        this.underlyingZipStream.reset();
        ByteStreams.skipFully(this.underlyingZipStream, randomAccessZipStream$ZipStreamEntry.relativeOffsetToLocalHeader + 26L);
        final int unsignedShort = this.littleEndianInputStream.readUnsignedShort();
        ByteStreams.skipFully(this.underlyingZipStream, 2L);
        final byte[] array = new byte[unsignedShort];
        this.underlyingZipStream.read(array);
        return new String(array, randomAccessZipStream$ZipStreamEntry.getEncoding());
    }
    
    public int size() {
        return this.entries.size();
    }
    
    private void initializeCentralDirectory() {
        long n = this.streamLength - 22;
        if (n < 0L) {
            throw new ZipException("Too short to be a valid ZIP archive.");
        }
        final long max = Math.max(0L, n - 65535L);
        try {
            do {
                this.underlyingZipStream.reset();
                ByteStreams.skipFully(this.underlyingZipStream, n);
                if (this.littleEndianInputStream.readInt() == 101010256) {
                    final int unsignedShort = this.littleEndianInputStream.readUnsignedShort();
                    final int unsignedShort2 = this.littleEndianInputStream.readUnsignedShort();
                    final int unsignedShort3 = this.littleEndianInputStream.readUnsignedShort();
                    final int unsignedShort4 = this.littleEndianInputStream.readUnsignedShort();
                    this.littleEndianInputStream.readInt();
                    final long n2 = this.littleEndianInputStream.readInt();
                    this.littleEndianInputStream.readUnsignedShort();
                    if (unsignedShort3 != unsignedShort4 || unsignedShort != 0 || unsignedShort2 != 0) {
                        throw new ZipException("Spanned ZIP archives NOT supported.");
                    }
                    this.underlyingZipStream.reset();
                    ByteStreams.skipFully(this.underlyingZipStream, n2);
                    while (true) {
                        final int int1 = this.littleEndianInputStream.readInt();
                        if (int1 == 101010256 || int1 == 101075792) {
                            return;
                        }
                        if (int1 != 33639248) {
                            throw new ZipException("Local entry header NOT found");
                        }
                        final RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry = new RandomAccessZipStream$ZipStreamEntry(this.littleEndianInputStream, this.underlyingZipStream);
                        this.entries.put(randomAccessZipStream$ZipStreamEntry.getName(), randomAccessZipStream$ZipStreamEntry);
                    }
                }
                else {
                    --n;
                }
            } while (n >= max);
            throw new ZipException("ZIP directory not found, not a ZIP archive.");
        }
        catch (IOException ex2) {
            final ZipException ex = new ZipException("Invalid ZIP archive.");
            ex.initCause(ex2);
            throw ex;
        }
    }
    
    private static long dosToJavaTime(final int n, final int n2) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(1980 + (n2 >> 9 & 0x7F), (n2 >> 5 & 0xF) - 1, n2 & 0x1F, n >> 11 & 0x1F, n >> 5 & 0x3F, (n & 0x1F) << 1);
        return gregorianCalendar.getTime().getTime();
    }
}
