package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;

class Synchronized$SynchronizedObject implements Serializable
{
    final Object delegate;
    final Object mutex;
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedObject(final Object o, @Nullable final Object o2) {
        this.delegate = Preconditions.checkNotNull(o);
        this.mutex = ((o2 == null) ? this : o2);
    }
    
    Object delegate() {
        return this.delegate;
    }
    
    @Override
    public String toString() {
        synchronized (this.mutex) {
            return this.delegate.toString();
        }
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
