/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink$1;
import com.google.common.io.ByteSink$AsCharSink;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.Closer;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public abstract class ByteSink {
    protected ByteSink() {
    }

    public CharSink asCharSink(Charset charset) {
        return new ByteSink$AsCharSink(this, charset, null);
    }

    public abstract OutputStream openStream();

    public OutputStream openBufferedStream() {
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream = this.openStream();
        if (outputStream instanceof BufferedOutputStream) {
            bufferedOutputStream = (BufferedOutputStream)outputStream;
            return bufferedOutputStream;
        }
        bufferedOutputStream = new BufferedOutputStream(outputStream);
        return bufferedOutputStream;
    }

    @GoogleInternal
    public WritableByteChannel openChannel() {
        return Channels.newChannel(this.openStream());
    }

    public void write(byte[] arrby) {
        Preconditions.checkNotNull(arrby);
        Closer closer = Closer.create();
        try {
            OutputStream outputStream = (OutputStream)closer.register(this.openStream());
            outputStream.write(arrby);
            outputStream.flush();
            return;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public long writeFrom(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        Closer closer = Closer.create();
        try {
            OutputStream outputStream = (OutputStream)closer.register(this.openStream());
            long l2 = ByteStreams.copy(inputStream, outputStream);
            outputStream.flush();
            long l3 = l2;
            return l3;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    @GoogleInternal
    public long writeFrom(ReadableByteChannel readableByteChannel) {
        Preconditions.checkNotNull(readableByteChannel);
        Closer closer = Closer.create();
        try {
            WritableByteChannel writableByteChannel = (WritableByteChannel)closer.register(this.openChannel());
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
}

