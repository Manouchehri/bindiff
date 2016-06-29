package com.google.common.io;

import com.google.common.annotations.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
import java.io.*;
import com.google.common.base.*;

@Beta
public final class Resources
{
    public static ByteSource asByteSource(final URL url) {
        return new Resources$UrlByteSource(url, null);
    }
    
    public static CharSource asCharSource(final URL url, final Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }
    
    public static byte[] toByteArray(final URL url) {
        return asByteSource(url).read();
    }
    
    public static String toString(final URL url, final Charset charset) {
        return asCharSource(url, charset).read();
    }
    
    public static Object readLines(final URL url, final Charset charset, final LineProcessor lineProcessor) {
        return asCharSource(url, charset).readLines(lineProcessor);
    }
    
    public static List readLines(final URL url, final Charset charset) {
        return (List)readLines(url, charset, new Resources$1());
    }
    
    public static void copy(final URL url, final OutputStream outputStream) {
        asByteSource(url).copyTo(outputStream);
    }
    
    public static URL getResource(final String s) {
        final URL resource = ((ClassLoader)MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(s);
        Preconditions.checkArgument(resource != null, "resource %s not found.", s);
        return resource;
    }
    
    public static URL getResource(final Class clazz, final String s) {
        final URL resource = clazz.getResource(s);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", s, clazz.getName());
        return resource;
    }
}
