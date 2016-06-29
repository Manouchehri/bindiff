package com.google.common.io;

import java.util.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.*;
import com.google.common.annotations.*;
import com.google.common.hash.*;
import com.google.common.base.*;

class ByteSource$ByteArrayByteSource extends ByteSource
{
    final byte[] bytes;
    final int offset;
    final int length;
    
    ByteSource$ByteArrayByteSource(final byte[] array) {
        this(array, 0, array.length);
    }
    
    ByteSource$ByteArrayByteSource(final byte[] bytes, final int offset, final int length) {
        this.bytes = bytes;
        this.offset = offset;
        this.length = length;
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
        return this.length == 0;
    }
    
    @Override
    public long size() {
        return this.length;
    }
    
    @Override
    public Optional sizeIfKnown() {
        return Optional.of((long)this.length);
    }
    
    @Override
    public byte[] read() {
        return Arrays.copyOfRange(this.bytes, this.offset, this.offset + this.length);
    }
    
    @Override
    public long copyTo(final OutputStream outputStream) {
        outputStream.write(this.bytes, this.offset, this.length);
        return this.length;
    }
    
    @GoogleInternal
    @Override
    public long copyTo(final WritableByteChannel writableByteChannel) {
        return writableByteChannel.write(ByteBuffer.wrap(this.bytes, this.offset, this.length));
    }
    
    @Override
    public Object read(final ByteProcessor byteProcessor) {
        byteProcessor.processBytes(this.bytes, this.offset, this.length);
        return byteProcessor.getResult();
    }
    
    @Override
    public HashCode hash(final HashFunction hashFunction) {
        return hashFunction.hashBytes(this.bytes, this.offset, this.length);
    }
    
    @Override
    public ByteSource slice(final long n, final long n2) {
        Preconditions.checkArgument(n >= 0L, "offset (%s) may not be negative", n);
        Preconditions.checkArgument(n2 >= 0L, "length (%s) may not be negative", n2);
        final int n3 = this.offset + (int)Math.min(this.length, n);
        return new ByteSource$ByteArrayByteSource(this.bytes, n3, this.offset + (int)Math.min(this.length, n + n2) - n3);
    }
    
    @Override
    public String toString() {
        final String truncate = truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...");
        return new StringBuilder(17 + String.valueOf(truncate).length()).append("ByteSource.wrap(").append(truncate).append(")").toString();
    }
    
    private static String truncate(CharSequence charSequence, final int n, final String s) {
        Preconditions.checkNotNull(charSequence);
        final int n2 = n - s.length();
        Preconditions.checkArgument(n2 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n, s.length());
        if (charSequence.length() <= n) {
            final String string = charSequence.toString();
            if (string.length() <= n) {
                return string;
            }
            charSequence = string;
        }
        return new StringBuilder(n).append(charSequence, 0, n2).append(s).toString();
    }
}
