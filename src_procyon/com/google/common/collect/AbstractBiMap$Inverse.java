package com.google.common.collect;

import com.google.common.annotations.*;
import java.io.*;
import java.util.*;

class AbstractBiMap$Inverse extends AbstractBiMap
{
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    private AbstractBiMap$Inverse(final Map map, final AbstractBiMap abstractBiMap) {
        super(map, abstractBiMap, null);
    }
    
    @Override
    Object checkKey(final Object o) {
        return this.inverse.checkValue(o);
    }
    
    @Override
    Object checkValue(final Object o) {
        return this.inverse.checkKey(o);
    }
    
    @GwtIncompatible("java.io.ObjectOuputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.inverse());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.setInverse((AbstractBiMap)objectInputStream.readObject());
    }
    
    @GwtIncompatible("Not needed in the emulated source.")
    Object readResolve() {
        return this.inverse().inverse();
    }
}
