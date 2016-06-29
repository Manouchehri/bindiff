package org.ibex.nestedvm;

class RuntimeCompiler$SingleClassLoader extends ClassLoader
{
    private RuntimeCompiler$SingleClassLoader() {
    }
    
    public Class loadClass(final String s, final boolean b) {
        return super.loadClass(s, b);
    }
    
    public Class fromBytes(final String s, final byte[] array) {
        return this.fromBytes(s, array, 0, array.length);
    }
    
    public Class fromBytes(final String s, final byte[] array, final int n, final int n2) {
        final Class<?> defineClass = super.defineClass(s, array, n, n2);
        this.resolveClass(defineClass);
        return defineClass;
    }
    
    RuntimeCompiler$SingleClassLoader(final RuntimeCompiler$1 runtimeCompiler$1) {
        this();
    }
}
