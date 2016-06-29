/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.SipHashFunction$SipHasher;
import java.io.Serializable;
import javax.annotation.Nullable;

final class SipHashFunction
extends AbstractStreamingHashFunction
implements Serializable {
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;
    private static final long serialVersionUID = 0;

    SipHashFunction(int n2, int n3, long l2, long l3) {
        Preconditions.checkArgument(n2 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", n2);
        Preconditions.checkArgument(n3 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", n3);
        this.c = n2;
        this.d = n3;
        this.k0 = l2;
        this.k1 = l3;
    }

    @Override
    public int bits() {
        return 64;
    }

    @Override
    public Hasher newHasher() {
        return new SipHashFunction$SipHasher(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        int n2 = this.c;
        int n3 = this.d;
        long l2 = this.k0;
        long l3 = this.k1;
        return new StringBuilder(81).append("Hashing.sipHash").append(n2).append(n3).append("(").append(l2).append(", ").append(l3).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof SipHashFunction)) return false;
        SipHashFunction sipHashFunction = (SipHashFunction)object;
        if (this.c != sipHashFunction.c) return false;
        if (this.d != sipHashFunction.d) return false;
        if (this.k0 != sipHashFunction.k0) return false;
        if (this.k1 != sipHashFunction.k1) return false;
        return true;
    }

    public int hashCode() {
        return (int)((long)(this.getClass().hashCode() ^ this.c ^ this.d) ^ this.k0 ^ this.k1);
    }
}

