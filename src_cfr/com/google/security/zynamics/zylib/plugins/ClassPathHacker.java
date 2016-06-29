/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.plugins;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassPathHacker {
    private static final Class[] parameters = new Class[]{URL.class};

    public static void addFile(File file) {
        try {
            ClassPathHacker.addURL(file.toURI().toURL());
            return;
        }
        catch (MalformedURLException var1_1) {
            assert (false);
            return;
        }
    }

    public static void addFile(String string) {
        File file = new File(string);
        ClassPathHacker.addFile(file);
    }

    public static void addURL(URL uRL) {
        URLClassLoader uRLClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        try {
            Method method = URLClassLoader.class.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(uRLClassLoader, uRL);
            return;
        }
        catch (Exception var2_3) {
            var2_3.printStackTrace();
        }
    }
}

