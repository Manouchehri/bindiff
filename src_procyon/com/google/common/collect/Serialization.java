package com.google.common.collect;

import java.io.*;
import java.util.*;

final class Serialization
{
    static int readCount(final ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }
    
    static void writeMap(final Map map, final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }
    
    static void populateMap(final Map map, final ObjectInputStream objectInputStream) {
        populateMap(map, objectInputStream, objectInputStream.readInt());
    }
    
    static void populateMap(final Map map, final ObjectInputStream objectInputStream, final int n) {
        for (int i = 0; i < n; ++i) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }
    
    static void writeMultiset(final Multiset multiset, final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (final Multiset$Entry multiset$Entry : multiset.entrySet()) {
            objectOutputStream.writeObject(multiset$Entry.getElement());
            objectOutputStream.writeInt(multiset$Entry.getCount());
        }
    }
    
    static void populateMultiset(final Multiset multiset, final ObjectInputStream objectInputStream) {
        populateMultiset(multiset, objectInputStream, objectInputStream.readInt());
    }
    
    static void populateMultiset(final Multiset multiset, final ObjectInputStream objectInputStream, final int n) {
        for (int i = 0; i < n; ++i) {
            multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }
    
    static void writeMultimap(final Multimap multimap, final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (final Map.Entry<Object, V> entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection)entry.getValue()).size());
            final Iterator iterator2 = ((Collection)entry.getValue()).iterator();
            while (iterator2.hasNext()) {
                objectOutputStream.writeObject(iterator2.next());
            }
        }
    }
    
    static void populateMultimap(final Multimap multimap, final ObjectInputStream objectInputStream) {
        populateMultimap(multimap, objectInputStream, objectInputStream.readInt());
    }
    
    static void populateMultimap(final Multimap multimap, final ObjectInputStream objectInputStream, final int n) {
        for (int i = 0; i < n; ++i) {
            final Collection value = multimap.get(objectInputStream.readObject());
            for (int int1 = objectInputStream.readInt(), j = 0; j < int1; ++j) {
                value.add(objectInputStream.readObject());
            }
        }
    }
    
    static Serialization$FieldSetter getFieldSetter(final Class clazz, final String s) {
        try {
            return new Serialization$FieldSetter(clazz.getDeclaredField(s), null);
        }
        catch (NoSuchFieldException ex) {
            throw new AssertionError((Object)ex);
        }
    }
}
