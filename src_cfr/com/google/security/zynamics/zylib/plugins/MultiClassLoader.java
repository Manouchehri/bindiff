/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.plugins;

import java.io.PrintStream;
import java.util.Hashtable;

@Deprecated
public abstract class MultiClassLoader
extends ClassLoader {
    private final Hashtable classes = new Hashtable();
    private char classNameReplacementChar;
    protected boolean monitorOn = false;
    protected boolean sourceMonitorOn = true;

    protected static void print(String string) {
        System.out.println(string);
    }

    protected String formatClassName(String string) {
        if (this.classNameReplacementChar != '\u0000') return String.valueOf(string.replace('.', this.classNameReplacementChar)).concat(".class");
        return String.valueOf(string.replace('.', '/')).concat(".class");
    }

    protected abstract byte[] loadClassBytes(String var1);

    protected void monitor(String string) {
        if (!this.monitorOn) return;
        MultiClassLoader.print(string);
    }

    public Class loadClass(String string) {
        return this.loadClass(string, true);
    }

    public synchronized Class loadClass(String string, boolean bl2) {
        this.monitor(new StringBuilder(38 + String.valueOf(string).length()).append(">> MultiClassLoader.loadClass(").append(string).append(", ").append(bl2).append(")").toString());
        Class<?> class_ = (Class<?>)this.classes.get(string);
        if (class_ != null) {
            this.monitor(">> returning cached result.");
            return class_;
        }
        try {
            class_ = super.findSystemClass(string);
            this.monitor(">> returning system class (in CLASSPATH).");
            return class_;
        }
        catch (ClassNotFoundException var5_4) {
            this.monitor(">> Not a system class.");
            byte[] arrby = this.loadClassBytes(string);
            if (arrby == null) {
                throw new ClassNotFoundException();
            }
            class_ = this.defineClass(string, arrby, 0, arrby.length);
            if (class_ == null) {
                throw new ClassFormatError();
            }
            if (bl2) {
                this.resolveClass(class_);
            }
            this.classes.put(string, class_);
            this.monitor(">> Returning newly loaded class.");
            return class_;
        }
    }

    public void setClassNameReplacementChar(char c2) {
        this.classNameReplacementChar = c2;
    }
}

