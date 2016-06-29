package com.google.common.hash;

import java.io.*;
import java.nio.charset.*;
import com.google.common.base.*;
import javax.annotation.*;

class Funnels$StringCharsetFunnel implements Funnel, Serializable
{
    private final Charset charset;
    
    Funnels$StringCharsetFunnel(final Charset charset) {
        this.charset = (Charset)Preconditions.checkNotNull(charset);
    }
    
    public void funnel(final CharSequence charSequence, final PrimitiveSink primitiveSink) {
        primitiveSink.putString(charSequence, this.charset);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.charset.name());
        return new StringBuilder(22 + String.valueOf(value).length()).append("Funnels.stringFunnel(").append(value).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Funnels$StringCharsetFunnel && this.charset.equals(((Funnels$StringCharsetFunnel)o).charset);
    }
    
    @Override
    public int hashCode() {
        return Funnels$StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
    }
    
    Object writeReplace() {
        return new Funnels$StringCharsetFunnel$SerializedForm(this.charset);
    }
}
