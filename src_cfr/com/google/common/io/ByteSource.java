/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource$1;
import com.google.common.io.ByteSource$AsCharSource;
import com.google.common.io.ByteSource$ByteArrayByteSource;
import com.google.common.io.ByteSource$ConcatenatedByteSource;
import com.google.common.io.ByteSource$EmptyByteSource;
import com.google.common.io.ByteSource$SlicedByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public abstract class ByteSource {
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer = new byte[4096];

    protected ByteSource() {
    }

    public CharSource asCharSource(Charset charset) {
        return new ByteSource$AsCharSource(this, charset, null);
    }

    public abstract InputStream openStream();

    public InputStream openBufferedStream() {
        BufferedInputStream bufferedInputStream;
        InputStream inputStream = this.openStream();
        if (inputStream instanceof BufferedInputStream) {
            bufferedInputStream = (BufferedInputStream)inputStream;
            return bufferedInputStream;
        }
        bufferedInputStream = new BufferedInputStream(inputStream);
        return bufferedInputStream;
    }

    @GoogleInternal
    public ReadableByteChannel openChannel() {
        return Channels.newChannel(this.openStream());
    }

    public ByteSource slice(long l2, long l3) {
        return new ByteSource$SlicedByteSource(this, l2, l3);
    }

    public boolean isEmpty() {
        Optional optional = this.sizeIfKnown();
        if (optional.isPresent() && (Long)optional.get() == 0) {
            return true;
        }
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            boolean bl2 = inputStream.read() == -1;
            return bl2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    @Beta
    public Optional sizeIfKnown() {
        return Optional.absent();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long size() {
        Optional optional = this.sizeIfKnown();
        if (optional.isPresent()) {
            return (Long)optional.get();
        }
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            long l2 = this.countBySkipping(inputStream);
            return l2;
        }
        catch (IOException var3_4) {}
        closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            long l3 = this.countByReading(inputStream);
            return l3;
        }
        catch (Throwable var3_6) {
            throw closer.rethrow(var3_6);
        }
        finally {
            closer.close();
        }
    }

    private long countBySkipping(InputStream inputStream) {
        long l2 = 0;
        do {
            long l3;
            if ((l3 = inputStream.skip(Math.min(inputStream.available(), Integer.MAX_VALUE))) <= 0) {
                if (inputStream.read() == -1) {
                    return l2;
                }
                if (l2 == 0 && inputStream.available() == 0) {
                    throw new IOException();
                }
                ++l2;
                continue;
            }
            l2 += l3;
        } while (true);
    }

    private long countByReading(InputStream inputStream) {
        long l2;
        long l3 = 0;
        while ((l2 = (long)inputStream.read(countBuffer)) != -1) {
            l3 += l2;
        }
        return l3;
    }

    public long copyTo(OutputStream outputStream) {
        Preconditions.checkNotNull(outputStream);
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            long l2 = ByteStreams.copy(inputStream, outputStream);
            return l2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public long copyTo(ByteSink byteSink) {
        Preconditions.checkNotNull(byteSink);
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            OutputStream outputStream = (OutputStream)closer.register(byteSink.openStream());
            long l2 = ByteStreams.copy(inputStream, outputStream);
            return l2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    @GoogleInternal
    public long copyTo(WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(writableByteChannel);
        Closer closer = Closer.create();
        try {
            ReadableByteChannel readableByteChannel = (ReadableByteChannel)closer.register(this.openChannel());
            long l2 = ByteStreams.copy(readableByteChannel, writableByteChannel);
            return l2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public byte[] read() {
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            byte[] arrby = ByteStreams.toByteArray(inputStream);
            return arrby;
        }
        catch (Throwable var2_3) {
            throw closer.rethrow(var2_3);
        }
        finally {
            closer.close();
        }
    }

    @Beta
    public Object read(ByteProcessor byteProcessor) {
        Preconditions.checkNotNull(byteProcessor);
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            Object object = ByteStreams.readBytes(inputStream, byteProcessor);
            return object;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public HashCode hash(HashFunction hashFunction) {
        Hasher hasher = hashFunction.newHasher();
        this.copyTo(Funnels.asOutputStream(hasher));
        return hasher.hash();
    }

    public boolean contentEquals(ByteSource byteSource) {
        Preconditions.checkNotNull(byteSource);
        byte[] arrby = new byte[4096];
        byte[] arrby2 = new byte[4096];
        Closer closer = Closer.create();
        try {
            InputStream inputStream = (InputStream)closer.register(this.openStream());
            InputStream inputStream2 = (InputStream)closer.register(byteSource.openStream());
            do {
                int n2;
                int n3;
                if ((n2 = ByteStreams.read(inputStream, arrby, 0, 4096)) != (n3 = ByteStreams.read(inputStream2, arrby2, 0, 4096)) || !Arrays.equals(arrby, arrby2)) {
                    boolean bl2 = false;
                    return bl2;
                }
                if (n2 != 4096) {
                    boolean bl3 = true;
                    return bl3;
                }
                continue;
                break;
            } while (true);
        }
        catch (Throwable var5_6) {
            throw closer.rethrow(var5_6);
        }
        finally {
            closer.close();
        }
    }

    public static ByteSource concat(Iterable iterable) {
        return new ByteSource$ConcatenatedByteSource(iterable);
    }

    public static ByteSource concat(Iterator iterator) {
        return ByteSource.concat(ImmutableList.copyOf(iterator));
    }

    public static /* varargs */ ByteSource concat(ByteSource ... arrbyteSource) {
        return ByteSource.concat(ImmutableList.copyOf(arrbyteSource));
    }

    public static ByteSource wrap(byte[] arrby) {
        return new ByteSource$ByteArrayByteSource(arrby);
    }

    public static ByteSource empty() {
        return ByteSource$EmptyByteSource.INSTANCE;
    }
}

