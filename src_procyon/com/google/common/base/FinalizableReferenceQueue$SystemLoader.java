package com.google.common.base;

import com.google.common.annotations.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.logging.*;
import java.lang.ref.*;

class FinalizableReferenceQueue$SystemLoader implements FinalizableReferenceQueue$FinalizerLoader
{
    @VisibleForTesting
    static boolean disabled;
    
    @Override
    public Class loadFinalizer() {
        if (FinalizableReferenceQueue$SystemLoader.disabled) {
            return null;
        }
        ClassLoader systemClassLoader;
        try {
            systemClassLoader = ClassLoader.getSystemClassLoader();
        }
        catch (SecurityException ex) {
            FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
            return null;
        }
        if (systemClassLoader != null) {
            try {
                return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
            }
            catch (ClassNotFoundException ex2) {
                return null;
            }
        }
        return null;
    }
}
