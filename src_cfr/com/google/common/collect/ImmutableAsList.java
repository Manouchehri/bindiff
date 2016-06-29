/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableAsList$SerializedForm;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

@GwtCompatible(serializable=1, emulated=1)
abstract class ImmutableAsList
extends ImmutableList {
    ImmutableAsList() {
    }

    abstract ImmutableCollection delegateCollection();

    @Override
    public boolean contains(Object object) {
        return this.delegateCollection().contains(object);
    }

    @Override
    public int size() {
        return this.delegateCollection().size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegateCollection().isEmpty();
    }

    @Override
    boolean isPartialView() {
        return this.delegateCollection().isPartialView();
    }

    @GwtIncompatible(value="serialization")
    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @GwtIncompatible(value="serialization")
    @Override
    Object writeReplace() {
        return new ImmutableAsList$SerializedForm(this.delegateCollection());
    }
}

