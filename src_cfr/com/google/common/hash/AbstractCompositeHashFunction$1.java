/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.charset.Charset;

class AbstractCompositeHashFunction$1
implements Hasher {
    final /* synthetic */ Hasher[] val$hashers;
    final /* synthetic */ AbstractCompositeHashFunction this$0;

    AbstractCompositeHashFunction$1(AbstractCompositeHashFunction abstractCompositeHashFunction, Hasher[] arrhasher) {
        this.this$0 = abstractCompositeHashFunction;
        this.val$hashers = arrhasher;
    }

    @Override
    public Hasher putByte(byte by2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putByte(by2);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putBytes(byte[] arrby) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putBytes(arrby);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putBytes(byte[] arrby, int n2, int n3) {
        Hasher[] arrhasher = this.val$hashers;
        int n4 = arrhasher.length;
        int n5 = 0;
        while (n5 < n4) {
            Hasher hasher = arrhasher[n5];
            hasher.putBytes(arrby, n2, n3);
            ++n5;
        }
        return this;
    }

    @Override
    public Hasher putShort(short s2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putShort(s2);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putInt(int n2) {
        Hasher[] arrhasher = this.val$hashers;
        int n3 = arrhasher.length;
        int n4 = 0;
        while (n4 < n3) {
            Hasher hasher = arrhasher[n4];
            hasher.putInt(n2);
            ++n4;
        }
        return this;
    }

    @Override
    public Hasher putLong(long l2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putLong(l2);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putFloat(float f2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putFloat(f2);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putDouble(double d2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putDouble(d2);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putBoolean(boolean bl2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putBoolean(bl2);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putChar(char c2) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putChar(c2);
            ++n3;
        }
        return this;
    }

    @Deprecated
    @Override
    public Hasher putString(CharSequence charSequence) {
        return this.putUnencodedChars(charSequence);
    }

    @Override
    public Hasher putUnencodedChars(CharSequence charSequence) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putUnencodedChars(charSequence);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putString(CharSequence charSequence, Charset charset) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putString(charSequence, charset);
            ++n3;
        }
        return this;
    }

    @Override
    public Hasher putObject(Object object, Funnel funnel) {
        Hasher[] arrhasher = this.val$hashers;
        int n2 = arrhasher.length;
        int n3 = 0;
        while (n3 < n2) {
            Hasher hasher = arrhasher[n3];
            hasher.putObject(object, funnel);
            ++n3;
        }
        return this;
    }

    @Override
    public HashCode hash() {
        return this.this$0.makeHash(this.val$hashers);
    }
}

