package com.google.common.io;

import java.io.*;
import java.util.*;
import com.google.common.base.*;

final class CharSource$ConcatenatedCharSource extends CharSource
{
    private final Iterable sources;
    
    CharSource$ConcatenatedCharSource(final Iterable iterable) {
        this.sources = (Iterable)Preconditions.checkNotNull(iterable);
    }
    
    @Override
    public Reader openStream() {
        return new MultiReader(this.sources.iterator());
    }
    
    @Override
    public boolean isEmpty() {
        final Iterator<CharSource> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Optional lengthIfKnown() {
        long n = 0L;
        final Iterator<CharSource> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            final Optional lengthIfKnown = iterator.next().lengthIfKnown();
            if (!lengthIfKnown.isPresent()) {
                return Optional.absent();
            }
            n += (long)lengthIfKnown.get();
        }
        return Optional.of(n);
    }
    
    @Override
    public long length() {
        long n = 0L;
        final Iterator<CharSource> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            n += iterator.next().length();
        }
        return n;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.sources);
        return new StringBuilder(19 + String.valueOf(value).length()).append("CharSource.concat(").append(value).append(")").toString();
    }
}
