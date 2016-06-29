package com.google.common.io;

import java.nio.charset.*;
import com.google.common.annotations.*;
import java.io.*;
import com.google.common.base.*;
import java.nio.channels.*;
import com.google.common.hash.*;
import java.util.*;
import com.google.common.collect.*;

public abstract class ByteSource
{
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer;
    
    public CharSource asCharSource(final Charset charset) {
        return new ByteSource$AsCharSource(this, charset, null);
    }
    
    public abstract InputStream openStream();
    
    public InputStream openBufferedStream() {
        final InputStream openStream = this.openStream();
        return (openStream instanceof BufferedInputStream) ? openStream : new BufferedInputStream(openStream);
    }
    
    @GoogleInternal
    public ReadableByteChannel openChannel() {
        return Channels.newChannel(this.openStream());
    }
    
    public ByteSource slice(final long n, final long n2) {
        return new ByteSource$SlicedByteSource(this, n, n2);
    }
    
    public boolean isEmpty() {
        final Optional sizeIfKnown = this.sizeIfKnown();
        if (sizeIfKnown.isPresent() && (long)sizeIfKnown.get() == 0L) {
            return true;
        }
        final Closer create = Closer.create();
        try {
            return ((InputStream)create.register(this.openStream())).read() == -1;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @Beta
    public Optional sizeIfKnown() {
        return Optional.absent();
    }
    
    public long size() {
        final Optional sizeIfKnown = this.sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return (long)sizeIfKnown.get();
        }
        final Closer create = Closer.create();
        try {
            return this.countBySkipping((InputStream)create.register(this.openStream()));
        }
        catch (IOException ex) {}
        finally {
            create.close();
        }
        final Closer create2 = Closer.create();
        try {
            return this.countByReading((InputStream)create2.register(this.openStream()));
        }
        catch (Throwable t) {
            throw create2.rethrow(t);
        }
        finally {
            create2.close();
        }
    }
    
    private long countBySkipping(final InputStream inputStream) {
        long n = 0L;
        while (true) {
            final long skip = inputStream.skip(Math.min(inputStream.available(), Integer.MAX_VALUE));
            if (skip <= 0L) {
                if (inputStream.read() == -1) {
                    return n;
                }
                if (n == 0L && inputStream.available() == 0) {
                    throw new IOException();
                }
                ++n;
            }
            else {
                n += skip;
            }
        }
    }
    
    private long countByReading(final InputStream inputStream) {
        long n = 0L;
        long n2;
        while ((n2 = inputStream.read(ByteSource.countBuffer)) != -1L) {
            n += n2;
        }
        return n;
    }
    
    public long copyTo(final OutputStream outputStream) {
        Preconditions.checkNotNull(outputStream);
        final Closer create = Closer.create();
        try {
            return ByteStreams.copy((InputStream)create.register(this.openStream()), outputStream);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long copyTo(final ByteSink byteSink) {
        Preconditions.checkNotNull(byteSink);
        final Closer create = Closer.create();
        try {
            return ByteStreams.copy((InputStream)create.register(this.openStream()), (OutputStream)create.register(byteSink.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @GoogleInternal
    public long copyTo(final WritableByteChannel writableByteChannel) {
        Preconditions.checkNotNull(writableByteChannel);
        final Closer create = Closer.create();
        try {
            return ByteStreams.copy((ReadableByteChannel)create.register(this.openChannel()), writableByteChannel);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public byte[] read() {
        final Closer create = Closer.create();
        try {
            return ByteStreams.toByteArray((InputStream)create.register(this.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @Beta
    public Object read(final ByteProcessor byteProcessor) {
        Preconditions.checkNotNull(byteProcessor);
        final Closer create = Closer.create();
        try {
            return ByteStreams.readBytes((InputStream)create.register(this.openStream()), byteProcessor);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public HashCode hash(final HashFunction hashFunction) {
        final Hasher hasher = hashFunction.newHasher();
        this.copyTo(Funnels.asOutputStream(hasher));
        return hasher.hash();
    }
    
    public boolean contentEquals(final ByteSource byteSource) {
        Preconditions.checkNotNull(byteSource);
        final byte[] array = new byte[4096];
        final byte[] array2 = new byte[4096];
        final Closer create = Closer.create();
        try {
            final InputStream inputStream = (InputStream)create.register(this.openStream());
            final InputStream inputStream2 = (InputStream)create.register(byteSource.openStream());
            while (true) {
                final int read = ByteStreams.read(inputStream, array, 0, 4096);
                if (read != ByteStreams.read(inputStream2, array2, 0, 4096) || !Arrays.equals(array, array2)) {
                    return false;
                }
                if (read != 4096) {
                    return true;
                }
            }
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public static ByteSource concat(final Iterable iterable) {
        return new ByteSource$ConcatenatedByteSource(iterable);
    }
    
    public static ByteSource concat(final Iterator iterator) {
        return concat(ImmutableList.copyOf(iterator));
    }
    
    public static ByteSource concat(final ByteSource... array) {
        return concat(ImmutableList.copyOf(array));
    }
    
    public static ByteSource wrap(final byte[] array) {
        return new ByteSource$ByteArrayByteSource(array);
    }
    
    public static ByteSource empty() {
        return ByteSource$EmptyByteSource.INSTANCE;
    }
    
    static {
        countBuffer = new byte[4096];
    }
}
