/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.charset.Charset;

abstract class AbstractHasher
implements Hasher {
    AbstractHasher() {
    }

    @Override
    public final Hasher putBoolean(boolean bl2) {
        byte by2;
        if (bl2) {
            by2 = 1;
            return this.putByte(by2);
        }
        by2 = 0;
        return this.putByte(by2);
    }

    @Override
    public final Hasher putDouble(double d2) {
        return this.putLong(Double.doubleToRawLongBits(d2));
    }

    @Override
    public final Hasher putFloat(float f2) {
        return this.putInt(Float.floatToRawIntBits(f2));
    }

    @Deprecated
    @Override
    public Hasher putString(CharSequence charSequence) {
        return this.putUnencodedChars(charSequence);
    }

    @Override
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int n2 = 0;
        int n3 = charSequence.length();
        while (n2 < n3) {
            this.putChar(charSequence.charAt(n2));
            ++n2;
        }
        return this;
    }

    @Override
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return this.putBytes(charSequence.toString().getBytes(charset));
    }
}

