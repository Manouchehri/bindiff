package com.google.common.hash;

import java.nio.charset.*;
import com.google.common.base.*;

abstract class AbstractStreamingHashFunction implements HashFunction
{
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
        return this.newHasher().putUnencodedChars(charSequence).hash();
    }
    
    @Override
    public HashCode hashString(final CharSequence charSequence, final Charset charset) {
        return this.newHasher().putString(charSequence, charset).hash();
    }
    
    @Override
    public HashCode hashInt(final int n) {
        return this.newHasher().putInt(n).hash();
    }
    
    @Override
    public HashCode hashLong(final long n) {
        return this.newHasher().putLong(n).hash();
    }
    
    @Override
    public HashCode hashBytes(final byte[] array) {
        return this.newHasher().putBytes(array).hash();
    }
    
    @Override
    public HashCode hashBytes(final byte[] array, final int n, final int n2) {
        return this.newHasher().putBytes(array, n, n2).hash();
    }
    
    @Override
    public Hasher newHasher(final int n) {
        Preconditions.checkArgument(n >= 0);
        return this.newHasher();
    }
}
