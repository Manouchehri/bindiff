package com.google.common.base;

import java.net.*;
import java.io.*;
import java.util.logging.*;
import java.lang.reflect.*;
import java.lang.ref.*;

class FinalizableReferenceQueue$DecoupledLoader implements FinalizableReferenceQueue$FinalizerLoader
{
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";
    
    @Override
    public Class loadFinalizer() {
        try {
            return this.newLoader(this.getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
        }
        catch (Exception ex) {
            FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", ex);
            return null;
        }
    }
    
    URL getBaseUrl() {
        final String concat = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
        final URL resource = this.getClass().getClassLoader().getResource(concat);
        if (resource == null) {
            throw new FileNotFoundException(concat);
        }
        final String string = resource.toString();
        if (!string.endsWith(concat)) {
            final String s = "Unsupported path style: ";
            final String value = String.valueOf(string);
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        return new URL(resource, string.substring(0, string.length() - concat.length()));
    }
    
    URLClassLoader newLoader(final URL url) {
        return new URLClassLoader(new URL[] { url }, (ClassLoader)null);
    }
}
