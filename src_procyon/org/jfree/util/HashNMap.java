package org.jfree.util;

import java.io.*;
import java.util.*;

public class HashNMap implements Serializable, Cloneable
{
    private static final long serialVersionUID = -670924844536074826L;
    private static final Iterator EMPTY_ITERATOR;
    private HashMap table;
    private static final Object[] EMPTY_ARRAY;
    
    public HashNMap() {
        this.table = new HashMap();
    }
    
    protected List createList() {
        return new ArrayList();
    }
    
    public boolean put(final Object o, final Object o2) {
        final List<Object> list = this.table.get(o);
        if (list == null) {
            final List list2 = this.createList();
            list2.add(o2);
            this.table.put(o, list2);
            return true;
        }
        list.clear();
        return list.add(o2);
    }
    
    public boolean add(final Object o, final Object o2) {
        final List<Object> list = this.table.get(o);
        if (list == null) {
            this.put(o, o2);
            return true;
        }
        return list.add(o2);
    }
    
    public Object getFirst(final Object o) {
        return this.get(o, 0);
    }
    
    public Object get(final Object o, final int n) {
        final List<Object> list = this.table.get(o);
        if (list == null) {
            return null;
        }
        return list.get(n);
    }
    
    public Iterator getAll(final Object o) {
        final List list = this.table.get(o);
        if (list == null) {
            return HashNMap.EMPTY_ITERATOR;
        }
        return list.iterator();
    }
    
    public Iterator keys() {
        return this.table.keySet().iterator();
    }
    
    public Set keySet() {
        return this.table.keySet();
    }
    
    public boolean remove(final Object o, final Object o2) {
        final List list = this.table.get(o);
        if (list == null) {
            return false;
        }
        if (!list.remove(o2)) {
            return false;
        }
        if (list.size() == 0) {
            this.table.remove(o);
        }
        return true;
    }
    
    public void removeAll(final Object o) {
        this.table.remove(o);
    }
    
    public void clear() {
        this.table.clear();
    }
    
    public boolean containsKey(final Object o) {
        return this.table.containsKey(o);
    }
    
    public boolean containsValue(final Object o) {
        Iterator<List> iterator;
        boolean contains;
        for (iterator = this.table.values().iterator(), contains = false; iterator.hasNext() && !contains; contains = iterator.next().contains(o)) {}
        return contains;
    }
    
    public boolean containsValue(final Object o, final Object o2) {
        final List list = this.table.get(o);
        return list != null && list.contains(o2);
    }
    
    public boolean contains(final Object o) {
        return this.containsKey(o) || this.containsValue(o);
    }
    
    public Object clone() {
        final HashNMap hashNMap = (HashNMap)super.clone();
        hashNMap.table = new HashMap();
        final Iterator keys = this.keys();
        while (keys.hasNext()) {
            final Object next = keys.next();
            final List list = hashNMap.table.get(next);
            if (list != null) {
                hashNMap.table.put(next, ObjectUtilities.clone(list));
            }
        }
        return hashNMap;
    }
    
    public Object[] toArray(final Object o, final Object[] array) {
        if (o == null) {
            throw new NullPointerException("Key must not be null.");
        }
        final List list = this.table.get(o);
        if (list != null) {
            return list.toArray(array);
        }
        if (array.length > 0) {
            array[0] = null;
        }
        return array;
    }
    
    public Object[] toArray(final Object o) {
        if (o == null) {
            throw new NullPointerException("Key must not be null.");
        }
        final List list = this.table.get(o);
        if (list != null) {
            return list.toArray();
        }
        return HashNMap.EMPTY_ARRAY;
    }
    
    public int getValueCount(final Object o) {
        if (o == null) {
            throw new NullPointerException("Key must not be null.");
        }
        final List list = this.table.get(o);
        if (list != null) {
            return list.size();
        }
        return 0;
    }
    
    static {
        EMPTY_ITERATOR = new HashNMap$EmptyIterator(null);
        EMPTY_ARRAY = new Object[0];
    }
}
