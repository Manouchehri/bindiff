package com.google.common.hash;

import java.nio.charset.*;

abstract class AbstractHasher implements Hasher
{
    @Override
    public final Hasher putBoolean(final boolean b) {
        return this.putByte((byte)(byte)(b ? 1 : 0));
    }
    
    @Override
    public final Hasher putDouble(final double n) {
        return this.putLong(Double.doubleToRawLongBits(n));
    }
    
    @Override
    public final Hasher putFloat(final float n) {
        return this.putInt(Float.floatToRawIntBits(n));
    }
    
    @Deprecated
    @Override
    public Hasher putString(final CharSequence charSequence) {
        return this.putUnencodedChars(charSequence);
    }
    
    @Override
    public Hasher putUnencodedChars(final CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); ++i) {
            this.putChar(charSequence.charAt(i));
        }
        return this;
    }
    
    @Override
    public Hasher putString(final CharSequence charSequence, final Charset charset) {
        return this.putBytes(charSequence.toString().getBytes(charset));
    }
}
