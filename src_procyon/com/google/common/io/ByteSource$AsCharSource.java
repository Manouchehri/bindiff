package com.google.common.io;

import java.nio.charset.*;
import com.google.common.base.*;
import java.io.*;

final class ByteSource$AsCharSource extends CharSource
{
    private final Charset charset;
    final /* synthetic */ ByteSource this$0;
    
    private ByteSource$AsCharSource(final ByteSource this$0, final Charset charset) {
        this.this$0 = this$0;
        this.charset = (Charset)Preconditions.checkNotNull(charset);
    }
    
    @Override
    public Reader openStream() {
        return new InputStreamReader(this.this$0.openStream(), this.charset);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.this$0.toString());
        final String value2 = String.valueOf(this.charset);
        return new StringBuilder(15 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".asCharSource(").append(value2).append(")").toString();
    }
}
