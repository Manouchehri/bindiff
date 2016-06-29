/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closer;
import java.io.Closeable;
import java.io.InputStream;

final class ByteSource$SlicedByteSource
extends ByteSource {
    final long offset;
    final long length;
    final /* synthetic */ ByteSource this$0;

    ByteSource$SlicedByteSource(ByteSource byteSource, long l2, long l3) {
        this.this$0 = byteSource;
        Preconditions.checkArgument(l2 >= 0, "offset (%s) may not be negative", l2);
        Preconditions.checkArgument(l3 >= 0, "length (%s) may not be negative", l3);
        this.offset = l2;
        this.length = l3;
    }

    @Override
    public InputStream openStream() {
        return this.sliceStream(this.this$0.openStream());
    }

    @Override
    public InputStream openBufferedStream() {
        return this.sliceStream(this.this$0.openBufferedStream());
    }

    private InputStream sliceStream(InputStream inputStream) {
        if (this.offset <= 0) return ByteStreams.limit(inputStream, this.length);
        try {
            ByteStreams.skipFully(inputStream, this.offset);
            return ByteStreams.limit(inputStream, this.length);
        }
        catch (Throwable var2_2) {
            Closer closer = Closer.create();
            closer.register(inputStream);
            try {
                throw closer.rethrow(var2_2);
            }
            catch (Throwable var4_4) {
                closer.close();
                throw var4_4;
            }
        }
    }

    @Override
    public ByteSource slice(long l2, long l3) {
        Preconditions.checkArgument(l2 >= 0, "offset (%s) may not be negative", l2);
        Preconditions.checkArgument(l3 >= 0, "length (%s) may not be negative", l3);
        long l4 = this.length - l2;
        return this.this$0.slice(this.offset + l2, Math.min(l3, l4));
    }

    @Override
    public boolean isEmpty() {
        if (this.length == 0) return true;
        if (super.isEmpty()) return true;
        return false;
    }

    @Override
    public Optional sizeIfKnown() {
        Optional optional = this.this$0.sizeIfKnown();
        if (!optional.isPresent()) return Optional.absent();
        return Optional.of(Math.min(this.offset + this.length, (Long)optional.get()) - this.offset);
    }

    public String toString() {
        String string = String.valueOf(this.this$0.toString());
        long l2 = this.offset;
        long l3 = this.length;
        return new StringBuilder(50 + String.valueOf(string).length()).append(string).append(".slice(").append(l2).append(", ").append(l3).append(")").toString();
    }
}

