/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.NotThreadSafe
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.LittleEndianDataInputStream;
import com.google.common.io.RandomAccessZipStream$ZipStreamEntry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@GoogleInternal
public final class RandomAccessZipStream {
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
    private final LinkedHashMap entries = new LinkedHashMap();

    public RandomAccessZipStream(InputStream inputStream, int n2) {
        Preconditions.checkArgument(0 < n2, "Must specify the length of the ZIP archive");
        Preconditions.checkArgument(inputStream.markSupported(), "InputStream must support marking and resetting");
        this.streamLength = n2;
        this.underlyingZipStream = inputStream;
        this.littleEndianInputStream = new LittleEndianDataInputStream(inputStream);
        inputStream.mark(n2);
        this.initializeCentralDirectory();
    }

    public RandomAccessZipStream(byte[] arrby) {
        this(new ByteArrayInputStream(arrby), arrby.length);
    }

    public Collection getEntries() {
        return Collections.unmodifiableCollection(this.entries.values());
    }

    public RandomAccessZipStream$ZipStreamEntry getEntry(String string) {
        RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry;
        Preconditions.checkNotNull(string);
        RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry2 = (RandomAccessZipStream$ZipStreamEntry)this.entries.get(string);
        if (randomAccessZipStream$ZipStreamEntry2 != null) {
            randomAccessZipStream$ZipStreamEntry = randomAccessZipStream$ZipStreamEntry2;
            return randomAccessZipStream$ZipStreamEntry;
        }
        String string2 = String.valueOf(string);
        String string3 = String.valueOf("/");
        randomAccessZipStream$ZipStreamEntry = (RandomAccessZipStream$ZipStreamEntry)this.entries.get(string3.length() != 0 ? string2.concat(string3) : new String(string2));
        return randomAccessZipStream$ZipStreamEntry;
    }

    public InputStream getInputStream(RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry) {
        Preconditions.checkNotNull(randomAccessZipStream$ZipStreamEntry, "entry");
        Preconditions.checkArgument(randomAccessZipStream$ZipStreamEntry == this.getEntry(randomAccessZipStream$ZipStreamEntry.getName()), "Entry doesn't belong to this RandomAccessZipStream");
        try {
            this.underlyingZipStream.reset();
            ByteStreams.skipFully(this.underlyingZipStream, RandomAccessZipStream$ZipStreamEntry.access$000(randomAccessZipStream$ZipStreamEntry) + 28);
            int n2 = this.littleEndianInputStream.readUnsignedShort();
            ByteStreams.skipFully(this.underlyingZipStream, RandomAccessZipStream$ZipStreamEntry.access$100(randomAccessZipStream$ZipStreamEntry) + n2);
        }
        catch (IOException var2_3) {
            ZipException zipException = new ZipException("Error finding local record in ZIP.");
            zipException.initCause(var2_3);
            throw zipException;
        }
        switch (randomAccessZipStream$ZipStreamEntry.getMethod()) {
            InputStream inputStream;
            case 8: {
                int n3 = (int)Math.max(1024, Math.min(randomAccessZipStream$ZipStreamEntry.getSize(), 65535));
                inputStream = new InflaterInputStream(this.underlyingZipStream, new Inflater(true), n3);
                return ByteStreams.limit(inputStream, randomAccessZipStream$ZipStreamEntry.getSize());
            }
            case 0: {
                inputStream = this.underlyingZipStream;
                return ByteStreams.limit(inputStream, randomAccessZipStream$ZipStreamEntry.getSize());
            }
        }
        throw new ZipException("Unsupported ZIP compression method.");
    }

    public String getLocalFileHeaderName(RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry) {
        Preconditions.checkNotNull(randomAccessZipStream$ZipStreamEntry, "entry");
        Preconditions.checkArgument(randomAccessZipStream$ZipStreamEntry == this.getEntry(randomAccessZipStream$ZipStreamEntry.getName()), "Entry doesn't belong to this RandomAccessZipStream");
        this.underlyingZipStream.reset();
        ByteStreams.skipFully(this.underlyingZipStream, RandomAccessZipStream$ZipStreamEntry.access$000(randomAccessZipStream$ZipStreamEntry) + 26);
        int n2 = this.littleEndianInputStream.readUnsignedShort();
        ByteStreams.skipFully(this.underlyingZipStream, 2);
        byte[] arrby = new byte[n2];
        this.underlyingZipStream.read(arrby);
        return new String(arrby, randomAccessZipStream$ZipStreamEntry.getEncoding());
    }

    public int size() {
        return this.entries.size();
    }

    private void initializeCentralDirectory() {
        long l2 = this.streamLength - 22;
        if (l2 < 0) {
            throw new ZipException("Too short to be a valid ZIP archive.");
        }
        long l3 = Math.max(0, l2 - 65535);
        try {
            int n2;
            long l4;
            block7 : {
                do {
                    this.underlyingZipStream.reset();
                    ByteStreams.skipFully(this.underlyingZipStream, l2);
                    if (this.littleEndianInputStream.readInt() != 101010256) continue;
                    int n3 = this.littleEndianInputStream.readUnsignedShort();
                    int n4 = this.littleEndianInputStream.readUnsignedShort();
                    int n5 = this.littleEndianInputStream.readUnsignedShort();
                    int n6 = this.littleEndianInputStream.readUnsignedShort();
                    this.littleEndianInputStream.readInt();
                    l4 = this.littleEndianInputStream.readInt();
                    this.littleEndianInputStream.readUnsignedShort();
                    if (n5 != n6) throw new ZipException("Spanned ZIP archives NOT supported.");
                    if (n3 != 0) throw new ZipException("Spanned ZIP archives NOT supported.");
                    if (n4 == 0) break block7;
                    throw new ZipException("Spanned ZIP archives NOT supported.");
                } while (--l2 >= l3);
                throw new ZipException("ZIP directory not found, not a ZIP archive.");
            }
            this.underlyingZipStream.reset();
            ByteStreams.skipFully(this.underlyingZipStream, l4);
            while ((n2 = this.littleEndianInputStream.readInt()) != 101010256) {
                if (n2 == 101075792) {
                    return;
                }
                if (n2 != 33639248) {
                    throw new ZipException("Local entry header NOT found");
                }
                RandomAccessZipStream$ZipStreamEntry randomAccessZipStream$ZipStreamEntry = new RandomAccessZipStream$ZipStreamEntry(this.littleEndianInputStream, this.underlyingZipStream);
                this.entries.put(randomAccessZipStream$ZipStreamEntry.getName(), randomAccessZipStream$ZipStreamEntry);
            }
            return;
        }
        catch (IOException var5_4) {
            ZipException zipException = new ZipException("Invalid ZIP archive.");
            zipException.initCause(var5_4);
            throw zipException;
        }
    }

    private static long dosToJavaTime(int n2, int n3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(1980 + (n3 >> 9 & 127), (n3 >> 5 & 15) - 1, n3 & 31, n2 >> 11 & 31, n2 >> 5 & 63, (n2 & 31) << 1);
        return gregorianCalendar.getTime().getTime();
    }

    static /* synthetic */ long access$200(int n2, int n3) {
        return RandomAccessZipStream.dosToJavaTime(n2, n3);
    }
}

