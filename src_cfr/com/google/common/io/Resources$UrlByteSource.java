/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources$1;
import java.io.InputStream;
import java.net.URL;

final class Resources$UrlByteSource
extends ByteSource {
    private final URL url;

    private Resources$UrlByteSource(URL uRL) {
        this.url = (URL)Preconditions.checkNotNull(uRL);
    }

    @Override
    public InputStream openStream() {
        return this.url.openStream();
    }

    public String toString() {
        String string = String.valueOf(this.url);
        return new StringBuilder(24 + String.valueOf(string).length()).append("Resources.asByteSource(").append(string).append(")").toString();
    }

    /* synthetic */ Resources$UrlByteSource(URL uRL, Resources$1 resources$1) {
        this(uRL);
    }
}

