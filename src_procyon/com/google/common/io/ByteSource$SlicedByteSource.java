package com.google.common.io;

import java.io.*;
import com.google.common.base.*;

final class ByteSource$SlicedByteSource extends ByteSource
{
    final long offset;
    final long length;
    final /* synthetic */ ByteSource this$0;
    
    ByteSource$SlicedByteSource(final ByteSource this$0, final long offset, final long length) {
        this.this$0 = this$0;
        Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", offset);
        Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", length);
        this.offset = offset;
        this.length = length;
    }
    
    @Override
    public InputStream openStream() {
        return this.sliceStream(this.this$0.openStream());
    }
    
    @Override
    public InputStream openBufferedStream() {
        return this.sliceStream(this.this$0.openBufferedStream());
    }
    
    private InputStream sliceStream(final InputStream inputStream) {
        if (this.offset > 0L) {
            try {
                ByteStreams.skipFully(inputStream, this.offset);
            }
            catch (Throwable t) {
                final Closer create = Closer.create();
                create.register(inputStream);
                try {
                    throw create.rethrow(t);
                }
                finally {
                    create.close();
                }
            }
        }
        return ByteStreams.limit(inputStream, this.length);
    }
    
    @Override
    public ByteSource slice(final long n, final long n2) {
        Preconditions.checkArgument(n >= 0L, "offset (%s) may not be negative", n);
        Preconditions.checkArgument(n2 >= 0L, "length (%s) may not be negative", n2);
        return this.this$0.slice(this.offset + n, Math.min(n2, this.length - n));
    }
    
    @Override
    public boolean isEmpty() {
        return this.length == 0L || super.isEmpty();
    }
    
    @Override
    public Optional sizeIfKnown() {
        final Optional sizeIfKnown = this.this$0.sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return Optional.of(Math.min(this.offset + this.length, (long)sizeIfKnown.get()) - this.offset);
        }
        return Optional.absent();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.this$0.toString());
        return new StringBuilder(50 + String.valueOf(value).length()).append(value).append(".slice(").append(this.offset).append(", ").append(this.length).append(")").toString();
    }
}
