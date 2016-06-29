package com.google.common.io;

import java.io.*;
import java.util.*;
import com.google.common.base.*;

final class ByteSource$ConcatenatedByteSource extends ByteSource
{
    final Iterable sources;
    
    ByteSource$ConcatenatedByteSource(final Iterable iterable) {
        this.sources = (Iterable)Preconditions.checkNotNull(iterable);
    }
    
    @Override
    public InputStream openStream() {
        return new MultiInputStream(this.sources.iterator());
    }
    
    @Override
    public boolean isEmpty() {
        final Iterator<ByteSource> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Optional sizeIfKnown() {
        long n = 0L;
        final Iterator<ByteSource> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            final Optional sizeIfKnown = iterator.next().sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return Optional.absent();
            }
            n += (long)sizeIfKnown.get();
        }
        return Optional.of(n);
    }
    
    @Override
    public long size() {
        long n = 0L;
        final Iterator<ByteSource> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            n += iterator.next().size();
        }
        return n;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.sources);
        return new StringBuilder(19 + String.valueOf(value).length()).append("ByteSource.concat(").append(value).append(")").toString();
    }
}
