/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.MultiInputStream;
import java.io.InputStream;
import java.util.Iterator;

final class ByteSource$ConcatenatedByteSource
extends ByteSource {
    final Iterable sources;

    ByteSource$ConcatenatedByteSource(Iterable iterable) {
        this.sources = (Iterable)Preconditions.checkNotNull(iterable);
    }

    @Override
    public InputStream openStream() {
        return new MultiInputStream(this.sources.iterator());
    }

    @Override
    public boolean isEmpty() {
        ByteSource byteSource;
        Iterator iterator = this.sources.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while ((byteSource = (ByteSource)iterator.next()).isEmpty());
        return false;
    }

    @Override
    public Optional sizeIfKnown() {
        long l2 = 0;
        Iterator iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            ByteSource byteSource = (ByteSource)iterator.next();
            Optional optional = byteSource.sizeIfKnown();
            if (!optional.isPresent()) {
                return Optional.absent();
            }
            l2 += ((Long)optional.get()).longValue();
        }
        return Optional.of(l2);
    }

    @Override
    public long size() {
        long l2 = 0;
        Iterator iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            ByteSource byteSource = (ByteSource)iterator.next();
            l2 += byteSource.size();
        }
        return l2;
    }

    public String toString() {
        String string = String.valueOf(this.sources);
        return new StringBuilder(19 + String.valueOf(string).length()).append("ByteSource.concat(").append(string).append(")").toString();
    }
}

