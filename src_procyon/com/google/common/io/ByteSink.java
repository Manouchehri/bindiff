package com.google.common.io;

import java.nio.charset.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.nio.channels.*;

public abstract class ByteSink
{
    public CharSink asCharSink(final Charset charset) {
        return new ByteSink$AsCharSink(this, charset, null);
    }
    
    public abstract OutputStream openStream();
    
    public OutputStream openBufferedStream() {
        final OutputStream openStream = this.openStream();
        return (openStream instanceof BufferedOutputStream) ? openStream : new BufferedOutputStream(openStream);
    }
    
    @GoogleInternal
    public WritableByteChannel openChannel() {
        return Channels.newChannel(this.openStream());
    }
    
    public void write(final byte[] array) {
        Preconditions.checkNotNull(array);
        final Closer create = Closer.create();
        try {
            final OutputStream outputStream = (OutputStream)create.register(this.openStream());
            outputStream.write(array);
            outputStream.flush();
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long writeFrom(final InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        final Closer create = Closer.create();
        try {
            final OutputStream outputStream = (OutputStream)create.register(this.openStream());
            final long copy = ByteStreams.copy(inputStream, outputStream);
            outputStream.flush();
            return copy;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @GoogleInternal
    public long writeFrom(final ReadableByteChannel readableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        final Closer create = Closer.create();
        try {
            return ByteStreams.copy(readableByteChannel, (WritableByteChannel)create.register(this.openChannel()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
}
