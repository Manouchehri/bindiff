/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

abstract class AbstractStreamingHashFunction
implements HashFunction {
    AbstractStreamingHashFunction() {
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
        return this.newHasher().putUnencodedChars(charSequence).hash();
    }

    @Override
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.newHasher().putString(charSequence, charset).hash();
    }

    @Override
    public HashCode hashInt(int n2) {
        return this.newHasher().putInt(n2).hash();
    }

    @Override
    public HashCode hashLong(long l2) {
        return this.newHasher().putLong(l2).hash();
    }

    @Override
    public HashCode hashBytes(byte[] arrby) {
        return this.newHasher().putBytes(arrby).hash();
    }

    @Override
    public HashCode hashBytes(byte[] arrby, int n2, int n3) {
        return this.newHasher().putBytes(arrby, n2, n3).hash();
    }

    @Override
    public Hasher newHasher(int n2) {
        Preconditions.checkArgument(n2 >= 0);
        return this.newHasher();
    }
}

