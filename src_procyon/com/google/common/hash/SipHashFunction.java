package com.google.common.hash;

import java.io.*;
import com.google.common.base.*;
import javax.annotation.*;

final class SipHashFunction extends AbstractStreamingHashFunction implements Serializable
{
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;
    private static final long serialVersionUID = 0L;
    
    SipHashFunction(final int c, final int d, final long k0, final long k2) {
        Preconditions.checkArgument(c > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", c);
        Preconditions.checkArgument(d > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", d);
        this.c = c;
        this.d = d;
        this.k0 = k0;
        this.k1 = k2;
    }
    
    @Override
    public int bits() {
        return 64;
    }
    
    @Override
    public Hasher newHasher() {
        return new SipHashFunction$SipHasher(this.c, this.d, this.k0, this.k1);
    }
    
    @Override
    public String toString() {
        return new StringBuilder(81).append("Hashing.sipHash").append(this.c).append(this.d).append("(").append(this.k0).append(", ").append(this.k1).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof SipHashFunction) {
            final SipHashFunction sipHashFunction = (SipHashFunction)o;
            return this.c == sipHashFunction.c && this.d == sipHashFunction.d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (int)(this.getClass().hashCode() ^ this.c ^ this.d ^ this.k0 ^ this.k1);
    }
}
