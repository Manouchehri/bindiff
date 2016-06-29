package com.google.common.hash;

import java.nio.charset.*;

class AbstractCompositeHashFunction$1 implements Hasher
{
    final /* synthetic */ Hasher[] val$hashers;
    final /* synthetic */ AbstractCompositeHashFunction this$0;
    
    AbstractCompositeHashFunction$1(final AbstractCompositeHashFunction this$0, final Hasher[] val$hashers) {
        this.this$0 = this$0;
        this.val$hashers = val$hashers;
    }
    
    @Override
    public Hasher putByte(final byte b) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putByte(b);
        }
        return this;
    }
    
    @Override
    public Hasher putBytes(final byte[] array) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putBytes(array);
        }
        return this;
    }
    
    @Override
    public Hasher putBytes(final byte[] array, final int n, final int n2) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putBytes(array, n, n2);
        }
        return this;
    }
    
    @Override
    public Hasher putShort(final short n) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putShort(n);
        }
        return this;
    }
    
    @Override
    public Hasher putInt(final int n) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putInt(n);
        }
        return this;
    }
    
    @Override
    public Hasher putLong(final long n) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putLong(n);
        }
        return this;
    }
    
    @Override
    public Hasher putFloat(final float n) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putFloat(n);
        }
        return this;
    }
    
    @Override
    public Hasher putDouble(final double n) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putDouble(n);
        }
        return this;
    }
    
    @Override
    public Hasher putBoolean(final boolean b) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putBoolean(b);
        }
        return this;
    }
    
    @Override
    public Hasher putChar(final char c) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putChar(c);
        }
        return this;
    }
    
    @Deprecated
    @Override
    public Hasher putString(final CharSequence charSequence) {
        return this.putUnencodedChars(charSequence);
    }
    
    @Override
    public Hasher putUnencodedChars(final CharSequence charSequence) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putUnencodedChars(charSequence);
        }
        return this;
    }
    
    @Override
    public Hasher putString(final CharSequence charSequence, final Charset charset) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putString(charSequence, charset);
        }
        return this;
    }
    
    @Override
    public Hasher putObject(final Object o, final Funnel funnel) {
        final Hasher[] val$hashers = this.val$hashers;
        for (int length = val$hashers.length, i = 0; i < length; ++i) {
            val$hashers[i].putObject(o, funnel);
        }
        return this;
    }
    
    @Override
    public HashCode hash() {
        return this.this$0.makeHash(this.val$hashers);
    }
}
