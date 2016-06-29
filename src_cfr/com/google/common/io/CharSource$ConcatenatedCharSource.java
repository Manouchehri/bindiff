/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import com.google.common.io.MultiReader;
import java.io.Reader;
import java.util.Iterator;

final class CharSource$ConcatenatedCharSource
extends CharSource {
    private final Iterable sources;

    CharSource$ConcatenatedCharSource(Iterable iterable) {
        this.sources = (Iterable)Preconditions.checkNotNull(iterable);
    }

    @Override
    public Reader openStream() {
        return new MultiReader(this.sources.iterator());
    }

    @Override
    public boolean isEmpty() {
        CharSource charSource;
        Iterator iterator = this.sources.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while ((charSource = (CharSource)iterator.next()).isEmpty());
        return false;
    }

    @Override
    public Optional lengthIfKnown() {
        long l2 = 0;
        Iterator iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            CharSource charSource = (CharSource)iterator.next();
            Optional optional = charSource.lengthIfKnown();
            if (!optional.isPresent()) {
                return Optional.absent();
            }
            l2 += ((Long)optional.get()).longValue();
        }
        return Optional.of(l2);
    }

    @Override
    public long length() {
        long l2 = 0;
        Iterator iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            CharSource charSource = (CharSource)iterator.next();
            l2 += charSource.length();
        }
        return l2;
    }

    public String toString() {
        String string = String.valueOf(this.sources);
        return new StringBuilder(19 + String.valueOf(string).length()).append("CharSource.concat(").append(string).append(")").toString();
    }
}

