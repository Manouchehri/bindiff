package com.google.security.zynamics.zylib.plugins;

import java.util.*;

@Deprecated
public abstract class MultiClassLoader extends ClassLoader
{
    private final Hashtable classes;
    private char classNameReplacementChar;
    protected boolean monitorOn;
    protected boolean sourceMonitorOn;
    
    public MultiClassLoader() {
        this.classes = new Hashtable();
        this.monitorOn = false;
        this.sourceMonitorOn = true;
    }
    
    protected static void print(final String s) {
        System.out.println(s);
    }
    
    protected String formatClassName(final String s) {
        if (this.classNameReplacementChar == '\0') {
            return String.valueOf(s.replace('.', '/')).concat(".class");
        }
        return String.valueOf(s.replace('.', this.classNameReplacementChar)).concat(".class");
    }
    
    protected abstract byte[] loadClassBytes(final String p0);
    
    protected void monitor(final String s) {
        if (this.monitorOn) {
            print(s);
        }
    }
    
    @Override
    public Class loadClass(final String s) {
        return this.loadClass(s, true);
    }
    
    public synchronized Class loadClass(final String s, final boolean b) {
        this.monitor(new StringBuilder(38 + String.valueOf(s).length()).append(">> MultiClassLoader.loadClass(").append(s).append(", ").append(b).append(")").toString());
        final Class clazz = this.classes.get(s);
        if (clazz != null) {
            this.monitor(">> returning cached result.");
            return clazz;
        }
        try {
            final Class<?> systemClass = super.findSystemClass(s);
            this.monitor(">> returning system class (in CLASSPATH).");
            return systemClass;
        }
        catch (ClassNotFoundException ex) {
            this.monitor(">> Not a system class.");
            final byte[] loadClassBytes = this.loadClassBytes(s);
            if (loadClassBytes == null) {
                throw new ClassNotFoundException();
            }
            final Class<?> defineClass = this.defineClass(s, loadClassBytes, 0, loadClassBytes.length);
            if (defineClass == null) {
                throw new ClassFormatError();
            }
            if (b) {
                this.resolveClass(defineClass);
            }
            this.classes.put(s, defineClass);
            this.monitor(">> Returning newly loaded class.");
            return defineClass;
        }
    }
    
    public void setClassNameReplacementChar(final char classNameReplacementChar) {
        this.classNameReplacementChar = classNameReplacementChar;
    }
}
