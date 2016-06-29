/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

class ByteSource$ByteArrayByteSource
extends ByteSource {
    final byte[] bytes;
    final int offset;
    final int length;

    ByteSource$ByteArrayByteSource(byte[] arrby) {
        this(arrby, 0, arrby.length);
    }

    ByteSource$ByteArrayByteSource(byte[] arrby, int n2, int n3) {
        this.bytes = arrby;
        this.offset = n2;
        this.length = n3;
    }

    @Override
    public InputStream openStream() {
        return new ByteArrayInputStream(this.bytes, this.offset, this.length);
    }

    @Override
    public InputStream openBufferedStream() {
        return this.openStream();
    }

    @Override
    public boolean isEmpty() {
        if (this.length != 0) return false;
        return true;
    }

    @Override
    public long size() {
        return this.length;
    }

    @Override
    public Optional sizeIfKnown() {
        return Optional.of(Long.valueOf(this.length));
    }

    @Override
    public byte[] read() {
        return Arrays.copyOfRange(this.bytes, this.offset, this.offset + this.length);
    }

    @Override
    public long copyTo(OutputStream outputStream) {
        outputStream.write(this.bytes, this.offset, this.length);
        return this.length;
    }

    @GoogleInternal
    @Override
    public long copyTo(WritableByteChannel writableByteChannel) {
        return writableByteChannel.write(ByteBuffer.wrap(this.bytes, this.offset, this.length));
    }

    @Override
    public Object read(ByteProcessor byteProcessor) {
        byteProcessor.processBytes(this.bytes, this.offset, this.length);
        return byteProcessor.getResult();
    }

    @Override
    public HashCode hash(HashFunction hashFunction) {
        return hashFunction.hashBytes(this.bytes, this.offset, this.length);
    }

    @Override
    public ByteSource slice(long l2, long l3) {
        Preconditions.checkArgument(l2 >= 0, "offset (%s) may not be negative", l2);
        Preconditions.checkArgument(l3 >= 0, "length (%s) may not be negative", l3);
        int n2 = this.offset + (int)Math.min((long)this.length, l2);
        int n3 = this.offset + (int)Math.min((long)this.length, l2 + l3);
        return new ByteSource$ByteArrayByteSource(this.bytes, n2, n3 - n2);
    }

    public String toString() {
        String string = ByteSource$ByteArrayByteSource.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...");
        return new StringBuilder(17 + String.valueOf(string).length()).append("ByteSource.wrap(").append(string).append(")").toString();
    }

    private static String truncate(CharSequence charSequence, int n2, String string) {
        Preconditions.checkNotNull(charSequence);
        int n3 = n2 - string.length();
        Preconditions.checkArgument(n3 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n2, string.length());
        if (charSequence.length() > n2) return new StringBuilder(n2).append(charSequence, 0, n3).append(string).toString();
        String string2 = charSequence.toString();
        if (string2.length() <= n2) {
            return string2;
        }
        charSequence = string2;
        return new StringBuilder(n2).append(charSequence, 0, n3).append(string).toString();
    }
}

