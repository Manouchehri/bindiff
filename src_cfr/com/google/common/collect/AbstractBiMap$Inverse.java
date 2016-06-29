/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.BiMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class AbstractBiMap$Inverse
extends AbstractBiMap {
    @GwtIncompatible(value="Not needed in emulated source.")
    private static final long serialVersionUID = 0;

    private AbstractBiMap$Inverse(Map map, AbstractBiMap abstractBiMap) {
        super(map, abstractBiMap, null);
    }

    @Override
    Object checkKey(Object object) {
        return this.inverse.checkValue(object);
    }

    @Override
    Object checkValue(Object object) {
        return this.inverse.checkKey(object);
    }

    @GwtIncompatible(value="java.io.ObjectOuputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.inverse());
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.setInverse((AbstractBiMap)objectInputStream.readObject());
    }

    @GwtIncompatible(value="Not needed in the emulated source.")
    Object readResolve() {
        return this.inverse().inverse();
    }

    /* synthetic */ AbstractBiMap$Inverse(Map map, AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(map, abstractBiMap);
    }
}

