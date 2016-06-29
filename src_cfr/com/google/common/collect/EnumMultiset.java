/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Serialization;
import com.google.common.collect.WellBehavedMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class EnumMultiset
extends AbstractMapBasedMultiset {
    private transient Class type;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0;

    public static EnumMultiset create(Class class_) {
        return new EnumMultiset(class_);
    }

    public static EnumMultiset create(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset enumMultiset = new EnumMultiset(((Enum)iterator.next()).getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static EnumMultiset create(Iterable iterable, Class class_) {
        EnumMultiset enumMultiset = EnumMultiset.create(class_);
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    private EnumMultiset(Class class_) {
        super(WellBehavedMap.wrap(new EnumMap(class_)));
        this.type = class_;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        Class class_;
        objectInputStream.defaultReadObject();
        this.type = class_ = (Class)objectInputStream.readObject();
        this.setBackingMap(WellBehavedMap.wrap(new EnumMap(this.type)));
        Serialization.populateMultiset(this, objectInputStream);
    }
}

