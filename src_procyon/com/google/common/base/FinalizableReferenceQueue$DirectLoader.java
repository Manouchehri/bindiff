package com.google.common.base;

class FinalizableReferenceQueue$DirectLoader implements FinalizableReferenceQueue$FinalizerLoader
{
    @Override
    public Class loadFinalizer() {
        try {
            return Class.forName("com.google.common.base.internal.Finalizer");
        }
        catch (ClassNotFoundException ex) {
            throw new AssertionError((Object)ex);
        }
    }
}
