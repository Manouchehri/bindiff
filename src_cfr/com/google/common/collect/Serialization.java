/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Serialization$1;
import com.google.common.collect.Serialization$FieldSetter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class Serialization {
    private Serialization() {
    }

    static int readCount(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static void writeMap(Map map, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    static void populateMap(Map map, ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        Serialization.populateMap(map, objectInputStream, n2);
    }

    static void populateMap(Map map, ObjectInputStream objectInputStream, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            map.put(object, object2);
            ++n3;
        }
    }

    static void writeMultiset(Multiset multiset, ObjectOutputStream objectOutputStream) {
        int n2 = multiset.entrySet().size();
        objectOutputStream.writeInt(n2);
        Iterator iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            objectOutputStream.writeObject(multiset$Entry.getElement());
            objectOutputStream.writeInt(multiset$Entry.getCount());
        }
    }

    static void populateMultiset(Multiset multiset, ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        Serialization.populateMultiset(multiset, objectInputStream, n2);
    }

    static void populateMultiset(Multiset multiset, ObjectInputStream objectInputStream, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            Object object = objectInputStream.readObject();
            int n4 = objectInputStream.readInt();
            multiset.add(object, n4);
            ++n3;
        }
    }

    static void writeMultimap(Multimap multimap, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multimap.asMap().size());
        Iterator iterator = multimap.asMap().entrySet().iterator();
        block0 : while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection)entry.getValue()).size());
            Iterator iterator2 = ((Collection)entry.getValue()).iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                Object e2 = iterator2.next();
                objectOutputStream.writeObject(e2);
            } while (true);
            break;
        }
        return;
    }

    static void populateMultimap(Multimap multimap, ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        Serialization.populateMultimap(multimap, objectInputStream, n2);
    }

    static void populateMultimap(Multimap multimap, ObjectInputStream objectInputStream, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            Object object = objectInputStream.readObject();
            Collection collection = multimap.get(object);
            int n4 = objectInputStream.readInt();
            for (int i2 = 0; i2 < n4; ++i2) {
                Object object2 = objectInputStream.readObject();
                collection.add(object2);
            }
            ++n3;
        }
    }

    static Serialization$FieldSetter getFieldSetter(Class class_, String string) {
        try {
            Field field = class_.getDeclaredField(string);
            return new Serialization$FieldSetter(field, null);
        }
        catch (NoSuchFieldException var2_3) {
            throw new AssertionError(var2_3);
        }
    }
}

