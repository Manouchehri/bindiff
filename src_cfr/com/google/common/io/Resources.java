/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources$1;
import com.google.common.io.Resources$UrlByteSource;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
public final class Resources {
    private Resources() {
    }

    public static ByteSource asByteSource(URL uRL) {
        return new Resources$UrlByteSource(uRL, null);
    }

    public static CharSource asCharSource(URL uRL, Charset charset) {
        return Resources.asByteSource(uRL).asCharSource(charset);
    }

    public static byte[] toByteArray(URL uRL) {
        return Resources.asByteSource(uRL).read();
    }

    public static String toString(URL uRL, Charset charset) {
        return Resources.asCharSource(uRL, charset).read();
    }

    public static Object readLines(URL uRL, Charset charset, LineProcessor lineProcessor) {
        return Resources.asCharSource(uRL, charset).readLines(lineProcessor);
    }

    public static List readLines(URL uRL, Charset charset) {
        return (List)Resources.readLines(uRL, charset, new Resources$1());
    }

    public static void copy(URL uRL, OutputStream outputStream) {
        Resources.asByteSource(uRL).copyTo(outputStream);
    }

    public static URL getResource(String string) {
        ClassLoader classLoader = (ClassLoader)MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader());
        URL uRL = classLoader.getResource(string);
        Preconditions.checkArgument(uRL != null, "resource %s not found.", string);
        return uRL;
    }

    public static URL getResource(Class class_, String string) {
        URL uRL = class_.getResource(string);
        Preconditions.checkArgument(uRL != null, "resource %s relative to %s not found.", string, class_.getName());
        return uRL;
    }
}

