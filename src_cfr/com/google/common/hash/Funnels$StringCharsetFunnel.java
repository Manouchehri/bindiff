/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels$StringCharsetFunnel$SerializedForm;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

class Funnels$StringCharsetFunnel
implements Funnel,
Serializable {
    private final Charset charset;

    Funnels$StringCharsetFunnel(Charset charset) {
        this.charset = (Charset)Preconditions.checkNotNull(charset);
    }

    public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
        primitiveSink.putString(charSequence, this.charset);
    }

    public String toString() {
        String string = String.valueOf(this.charset.name());
        return new StringBuilder(22 + String.valueOf(string).length()).append("Funnels.stringFunnel(").append(string).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Funnels$StringCharsetFunnel)) return false;
        Funnels$StringCharsetFunnel funnels$StringCharsetFunnel = (Funnels$StringCharsetFunnel)object;
        return this.charset.equals(funnels$StringCharsetFunnel.charset);
    }

    public int hashCode() {
        return Funnels$StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
    }

    Object writeReplace() {
        return new Funnels$StringCharsetFunnel$SerializedForm(this.charset);
    }
}

