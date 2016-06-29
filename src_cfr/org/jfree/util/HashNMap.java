/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jfree.util.HashNMap$1;
import org.jfree.util.HashNMap$EmptyIterator;
import org.jfree.util.ObjectUtilities;

public class HashNMap
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -670924844536074826L;
    private static final Iterator EMPTY_ITERATOR = new HashNMap$EmptyIterator(null);
    private HashMap table = new HashMap();
    private static final Object[] EMPTY_ARRAY = new Object[0];

    protected List createList() {
        return new ArrayList();
    }

    public boolean put(Object object, Object object2) {
        List list = (List)this.table.get(object);
        if (list == null) {
            List list2 = this.createList();
            list2.add(object2);
            this.table.put(object, list2);
            return true;
        }
        list.clear();
        return list.add(object2);
    }

    public boolean add(Object object, Object object2) {
        List list = (List)this.table.get(object);
        if (list != null) return list.add(object2);
        this.put(object, object2);
        return true;
    }

    public Object getFirst(Object object) {
        return this.get(object, 0);
    }

    public Object get(Object object, int n2) {
        List list = (List)this.table.get(object);
        if (list != null) return list.get(n2);
        return null;
    }

    public Iterator getAll(Object object) {
        List list = (List)this.table.get(object);
        if (list != null) return list.iterator();
        return EMPTY_ITERATOR;
    }

    public Iterator keys() {
        return this.table.keySet().iterator();
    }

    public Set keySet() {
        return this.table.keySet();
    }

    public boolean remove(Object object, Object object2) {
        List list = (List)this.table.get(object);
        if (list == null) {
            return false;
        }
        if (!list.remove(object2)) {
            return false;
        }
        if (list.size() != 0) return true;
        this.table.remove(object);
        return true;
    }

    public void removeAll(Object object) {
        this.table.remove(object);
    }

    public void clear() {
        this.table.clear();
    }

    public boolean containsKey(Object object) {
        return this.table.containsKey(object);
    }

    public boolean containsValue(Object object) {
        Iterator iterator = this.table.values().iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            if (bl2) return bl2;
            List list = (List)iterator.next();
            bl2 = list.contains(object);
        }
        return bl2;
    }

    public boolean containsValue(Object object, Object object2) {
        List list = (List)this.table.get(object);
        if (list != null) return list.contains(object2);
        return false;
    }

    public boolean contains(Object object) {
        if (!this.containsKey(object)) return this.containsValue(object);
        return true;
    }

    public Object clone() {
        HashNMap hashNMap = (HashNMap)super.clone();
        hashNMap.table = new HashMap();
        Iterator iterator = this.keys();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            List list = (List)hashNMap.table.get(e2);
            if (list == null) continue;
            hashNMap.table.put(e2, ObjectUtilities.clone(list));
        }
        return hashNMap;
    }

    public Object[] toArray(Object object, Object[] arrobject) {
        if (object == null) {
            throw new NullPointerException("Key must not be null.");
        }
        List list = (List)this.table.get(object);
        if (list != null) {
            return list.toArray(arrobject);
        }
        if (arrobject.length <= 0) return arrobject;
        arrobject[0] = null;
        return arrobject;
    }

    public Object[] toArray(Object object) {
        if (object == null) {
            throw new NullPointerException("Key must not be null.");
        }
        List list = (List)this.table.get(object);
        if (list == null) return EMPTY_ARRAY;
        return list.toArray();
    }

    public int getValueCount(Object object) {
        if (object == null) {
            throw new NullPointerException("Key must not be null.");
        }
        List list = (List)this.table.get(object);
        if (list == null) return 0;
        return list.size();
    }
}

