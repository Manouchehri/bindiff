/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSink$1;
import com.google.common.io.CharSink;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

final class ByteSink$AsCharSink
extends CharSink {
    private final Charset charset;
    final /* synthetic */ ByteSink this$0;

    private ByteSink$AsCharSink(ByteSink byteSink, Charset charset) {
        this.this$0 = byteSink;
        this.charset = (Charset)Preconditions.checkNotNull(charset);
    }

    @Override
    public Writer openStream() {
        return new OutputStreamWriter(this.this$0.openStream(), this.charset);
    }

    public String toString() {
        String string = String.valueOf(this.this$0.toString());
        String string2 = String.valueOf(this.charset);
        return new StringBuilder(13 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".asCharSink(").append(string2).append(")").toString();
    }

    /* synthetic */ ByteSink$AsCharSink(ByteSink byteSink, Charset charset, ByteSink$1 byteSink$1) {
        this(byteSink, charset);
    }
}

