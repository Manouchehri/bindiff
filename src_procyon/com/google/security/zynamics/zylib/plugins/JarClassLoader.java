package com.google.security.zynamics.zylib.plugins;

@Deprecated
public class JarClassLoader extends MultiClassLoader
{
    private final JarResources jarResources;
    
    public JarClassLoader(final String s) {
        this.jarResources = new JarResources(s);
    }
    
    @Override
    protected byte[] loadClassBytes(String formatClassName) {
        formatClassName = this.formatClassName(formatClassName);
        return this.jarResources.getResource(formatClassName);
    }
}
