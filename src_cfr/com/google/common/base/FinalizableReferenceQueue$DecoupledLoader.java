/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;

class FinalizableReferenceQueue$DecoupledLoader
implements FinalizableReferenceQueue$FinalizerLoader {
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

    FinalizableReferenceQueue$DecoupledLoader() {
    }

    @Override
    public Class loadFinalizer() {
        try {
            URLClassLoader uRLClassLoader = this.newLoader(this.getBaseUrl());
            return uRLClassLoader.loadClass("com.google.common.base.internal.Finalizer");
        }
        catch (Exception var1_2) {
            FinalizableReferenceQueue.access$000().log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", var1_2);
            return null;
        }
    }

    URL getBaseUrl() {
        String string;
        String string2 = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
        URL uRL = this.getClass().getClassLoader().getResource(string2);
        if (uRL == null) {
            throw new FileNotFoundException(string2);
        }
        String string3 = uRL.toString();
        if (string3.endsWith(string2)) {
            string3 = string3.substring(0, string3.length() - string2.length());
            return new URL(uRL, string3);
        }
        String string4 = String.valueOf(string3);
        if (string4.length() != 0) {
            string = "Unsupported path style: ".concat(string4);
            throw new IOException(string);
        }
        string = new String("Unsupported path style: ");
        throw new IOException(string);
    }

    URLClassLoader newLoader(URL uRL) {
        return new URLClassLoader(new URL[]{uRL}, null);
    }
}

