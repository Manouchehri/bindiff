/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractNonStreamingHashFunction$BufferingHasher;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

abstract class AbstractNonStreamingHashFunction
implements HashFunction {
    AbstractNonStreamingHashFunction() {
    }

    @Override
    public Hasher newHasher() {
        return new AbstractNonStreamingHashFunction$BufferingHasher(this, 32);
    }

    @Override
    public Hasher newHasher(int n2) {
        Preconditions.checkArgument(n2 >= 0);
        return new AbstractNonStreamingHashFunction$BufferingHasher(this, n2);
    }

    @Override
    public HashCode hashObject(Object object, Funnel funnel) {
        return this.newHasher().putObject(object, funnel).hash();
    }

    @Deprecated
    @Override
    public HashCode hashString(CharSequence charSequence) {
        return this.hashUnencodedChars(charSequence);
    }

    @Override
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int n2 = charSequence.length();
        Hasher hasher = this.newHasher(n2 * 2);
        int n3 = 0;
        while (n3 < n2) {
            hasher.putChar(charSequence.charAt(n3));
            ++n3;
        }
        return hasher.hash();
    }

    @Override
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override
    public HashCode hashInt(int n2) {
        return this.newHasher(4).putInt(n2).hash();
    }

    @Override
    public HashCode hashLong(long l2) {
        return this.newHasher(8).putLong(l2).hash();
    }

    @Override
    public HashCode hashBytes(byte[] arrby) {
        return this.hashBytes(arrby, 0, arrby.length);
    }
}

