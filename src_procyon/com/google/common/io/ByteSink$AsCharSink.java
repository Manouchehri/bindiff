package com.google.common.io;

import java.nio.charset.*;
import com.google.common.base.*;
import java.io.*;

final class ByteSink$AsCharSink extends CharSink
{
    private final Charset charset;
    final /* synthetic */ ByteSink this$0;
    
    private ByteSink$AsCharSink(final ByteSink this$0, final Charset charset) {
        this.this$0 = this$0;
        this.charset = (Charset)Preconditions.checkNotNull(charset);
    }
    
    @Override
    public Writer openStream() {
        return new OutputStreamWriter(this.this$0.openStream(), this.charset);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.this$0.toString());
        final String value2 = String.valueOf(this.charset);
        return new StringBuilder(13 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".asCharSink(").append(value2).append(")").toString();
    }
}
