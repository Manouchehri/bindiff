/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.RuntimeCompiler$1;

class RuntimeCompiler$SingleClassLoader
extends ClassLoader {
    private RuntimeCompiler$SingleClassLoader() {
    }

    public Class loadClass(String string, boolean bl2) {
        return super.loadClass(string, bl2);
    }

    public Class fromBytes(String string, byte[] arrby) {
        return this.fromBytes(string, arrby, 0, arrby.length);
    }

    public Class fromBytes(String string, byte[] arrby, int n2, int n3) {
        Class class_ = super.defineClass(string, arrby, n2, n3);
        this.resolveClass(class_);
        return class_;
    }

    RuntimeCompiler$SingleClassLoader(RuntimeCompiler$1 runtimeCompiler$1) {
        this();
    }
}

