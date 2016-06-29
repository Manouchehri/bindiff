package com.google.common.io;

import java.net.*;
import com.google.common.base.*;
import java.io.*;

final class Resources$UrlByteSource extends ByteSource
{
    private final URL url;
    
    private Resources$UrlByteSource(final URL url) {
        this.url = (URL)Preconditions.checkNotNull(url);
    }
    
    @Override
    public InputStream openStream() {
        return this.url.openStream();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.url);
        return new StringBuilder(24 + String.valueOf(value).length()).append("Resources.asByteSource(").append(value).append(")").toString();
    }
}
