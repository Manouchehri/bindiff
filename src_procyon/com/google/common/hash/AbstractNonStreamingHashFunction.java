package com.google.common.hash;

import com.google.common.base.*;
import java.nio.charset.*;

abstract class AbstractNonStreamingHashFunction implements HashFunction
{
    @Override
    public Hasher newHasher() {
        return new AbstractNonStreamingHashFunction$BufferingHasher(this, 32);
    }
    
    @Override
    public Hasher newHasher(final int n) {
        Preconditions.checkArgument(n >= 0);
        return new AbstractNonStreamingHashFunction$BufferingHasher(this, n);
    }
    
    @Override
    public HashCode hashObject(final Object o, final Funnel funnel) {
        return this.newHasher().putObject(o, funnel).hash();
    }
    
    @Deprecated
    @Override
    public HashCode hashString(final CharSequence charSequence) {
        return this.hashUnencodedChars(charSequence);
    }
    
    @Override
    public HashCode hashUnencodedChars(final CharSequence charSequence) {
        final int length = charSequence.length();
        final Hasher hasher = this.newHasher(length * 2);
        for (int i = 0; i < length; ++i) {
            hasher.putChar(charSequence.charAt(i));
        }
        return hasher.hash();
    }
    
    @Override
    public HashCode hashString(final CharSequence charSequence, final Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }
    
    @Override
    public HashCode hashInt(final int n) {
        return this.newHasher(4).putInt(n).hash();
    }
    
    @Override
    public HashCode hashLong(final long n) {
        return this.newHasher(8).putLong(n).hash();
    }
    
    @Override
    public HashCode hashBytes(final byte[] array) {
        return this.hashBytes(array, 0, array.length);
    }
}
