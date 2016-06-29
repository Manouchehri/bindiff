package com.google.security.zynamics.zylib.plugins;

import java.io.*;
import java.net.*;
import java.lang.reflect.*;

public class ClassPathHacker
{
    private static final Class[] parameters;
    
    public static void addFile(final File file) {
        try {
            addURL(file.toURI().toURL());
        }
        catch (MalformedURLException ex) {
            assert false : "Malformed URL from toURI()";
        }
    }
    
    public static void addFile(final String s) {
        addFile(new File(s));
    }
    
    public static void addURL(final URL url) {
        final URLClassLoader urlClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        try {
            final Method declaredMethod = URLClassLoader.class.getDeclaredMethod("addURL", (Class<?>[])ClassPathHacker.parameters);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(urlClassLoader, url);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        parameters = new Class[] { URL.class };
    }
}
