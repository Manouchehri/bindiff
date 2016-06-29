/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteSource$1;
import com.google.common.io.CharSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

final class ByteSource$AsCharSource
extends CharSource {
    private final Charset charset;
    final /* synthetic */ ByteSource this$0;

    private ByteSource$AsCharSource(ByteSource byteSource, Charset charset) {
        this.this$0 = byteSource;
        this.charset = (Charset)Preconditions.checkNotNull(charset);
    }

    @Override
    public Reader openStream() {
        return new InputStreamReader(this.this$0.openStream(), this.charset);
    }

    public String toString() {
        String string = String.valueOf(this.this$0.toString());
        String string2 = String.valueOf(this.charset);
        return new StringBuilder(15 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".asCharSource(").append(string2).append(")").toString();
    }

    /* synthetic */ ByteSource$AsCharSource(ByteSource byteSource, Charset charset, ByteSource$1 byteSource$1) {
        this(byteSource, charset);
    }
}

