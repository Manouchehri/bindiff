/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.plugins;

import com.google.security.zynamics.zylib.plugins.JarResources;
import com.google.security.zynamics.zylib.plugins.MultiClassLoader;

@Deprecated
public class JarClassLoader
extends MultiClassLoader {
    private final JarResources jarResources;

    public JarClassLoader(String string) {
        this.jarResources = new JarResources(string);
    }

    @Override
    protected byte[] loadClassBytes(String string) {
        string = this.formatClassName(string);
        return this.jarResources.getResource(string);
    }
}

