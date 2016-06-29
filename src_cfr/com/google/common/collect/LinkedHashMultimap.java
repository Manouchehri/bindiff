/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap$1;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public final class LinkedHashMultimap
extends AbstractSetMultimap {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0;
    @VisibleForTesting
    transient int valueSetCapacity = 2;
    private transient LinkedHashMultimap$ValueEntry multimapHeaderEntry;
    @GwtIncompatible(value="java serialization not supported")
    private static final long serialVersionUID = 1;

    public static LinkedHashMultimap create() {
        return new LinkedHashMultimap(16, 2);
    }

    public static LinkedHashMultimap create(int n2, int n3) {
        return new LinkedHashMultimap(Maps.capacity(n2), Maps.capacity(n3));
    }

    public static LinkedHashMultimap create(Multimap multimap) {
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(multimap.keySet().size(), 2);
        linkedHashMultimap.putAll(multimap);
        return linkedHashMultimap;
    }

    private static void succeedsInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink, LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink2) {
        linkedHashMultimap$ValueSetLink.setSuccessorInValueSet(linkedHashMultimap$ValueSetLink2);
        linkedHashMultimap$ValueSetLink2.setPredecessorInValueSet(linkedHashMultimap$ValueSetLink);
    }

    private static void succeedsInMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry, LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2) {
        linkedHashMultimap$ValueEntry.setSuccessorInMultimap(linkedHashMultimap$ValueEntry2);
        linkedHashMultimap$ValueEntry2.setPredecessorInMultimap(linkedHashMultimap$ValueEntry);
    }

    private static void deleteFromValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        LinkedHashMultimap.succeedsInValueSet(linkedHashMultimap$ValueSetLink.getPredecessorInValueSet(), linkedHashMultimap$ValueSetLink.getSuccessorInValueSet());
    }

    private static void deleteFromMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        LinkedHashMultimap.succeedsInMultimap(linkedHashMultimap$ValueEntry.getPredecessorInMultimap(), linkedHashMultimap$ValueEntry.getSuccessorInMultimap());
    }

    private LinkedHashMultimap(int n2, int n3) {
        super(new LinkedHashMap(n2));
        CollectPreconditions.checkNonnegative(n3, "expectedValuesPerKey");
        this.valueSetCapacity = n3;
        this.multimapHeaderEntry = new LinkedHashMultimap$ValueEntry(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    @Override
    Set createCollection() {
        return new LinkedHashSet(this.valueSetCapacity);
    }

    @Override
    Collection createCollection(Object object) {
        return new LinkedHashMultimap$ValueSet(this, object, this.valueSetCapacity);
    }

    @Override
    public Set replaceValues(@Nullable Object object, Iterable iterable) {
        return super.replaceValues(object, iterable);
    }

    @Override
    public Set entries() {
        return super.entries();
    }

    @Override
    public Collection values() {
        return super.values();
    }

    @Override
    Iterator entryIterator() {
        return new LinkedHashMultimap$1(this);
    }

    @Override
    Iterator valueIterator() {
        return Maps.valueIterator(this.entryIterator());
    }

    @Override
    public void clear() {
        super.clear();
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.keySet().size());
        for (Object object2 : this.keySet()) {
            objectOutputStream.writeObject(object2);
        }
        objectOutputStream.writeInt(this.size());
        Iterator iterator = this.entries().iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (Map.Entry)iterator.next();
            objectOutputStream.writeObject(object2.getKey());
            objectOutputStream.writeObject(object2.getValue());
        }
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        objectInputStream.defaultReadObject();
        this.multimapHeaderEntry = new LinkedHashMultimap$ValueEntry(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
        this.valueSetCapacity = 2;
        int n3 = objectInputStream.readInt();
        LinkedHashMap<Object, Collection> linkedHashMap = new LinkedHashMap<Object, Collection>();
        for (n2 = 0; n2 < n3; ++n2) {
            Object object = objectInputStream.readObject();
            linkedHashMap.put(object, this.createCollection(object));
        }
        n2 = objectInputStream.readInt();
        int n4 = 0;
        do {
            if (n4 >= n2) {
                this.setMap(linkedHashMap);
                return;
            }
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            ((Collection)linkedHashMap.get(object)).add(object2);
            ++n4;
        } while (true);
    }

    static /* synthetic */ void access$200(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink, LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink2) {
        LinkedHashMultimap.succeedsInValueSet(linkedHashMultimap$ValueSetLink, linkedHashMultimap$ValueSetLink2);
    }

    static /* synthetic */ LinkedHashMultimap$ValueEntry access$300(LinkedHashMultimap linkedHashMultimap) {
        return linkedHashMultimap.multimapHeaderEntry;
    }

    static /* synthetic */ void access$400(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry, LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2) {
        LinkedHashMultimap.succeedsInMultimap(linkedHashMultimap$ValueEntry, linkedHashMultimap$ValueEntry2);
    }

    static /* synthetic */ void access$500(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        LinkedHashMultimap.deleteFromValueSet(linkedHashMultimap$ValueSetLink);
    }

    static /* synthetic */ void access$600(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        LinkedHashMultimap.deleteFromMultimap(linkedHashMultimap$ValueEntry);
    }
}

