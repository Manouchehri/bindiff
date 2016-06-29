/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.KeyedObject;
import org.jfree.util.PublicCloneable;

public class KeyedObjects
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 1321582394193530984L;
    private List data = new ArrayList();

    public int getItemCount() {
        return this.data.size();
    }

    public Object getObject(int n2) {
        Object object = null;
        if (n2 < 0) return object;
        if (n2 >= this.data.size()) return object;
        KeyedObject keyedObject = (KeyedObject)this.data.get(n2);
        if (keyedObject == null) return object;
        return keyedObject.getObject();
    }

    public Comparable getKey(int n2) {
        Comparable comparable = null;
        if (n2 < 0) return comparable;
        if (n2 >= this.data.size()) return comparable;
        KeyedObject keyedObject = (KeyedObject)this.data.get(n2);
        if (keyedObject == null) return comparable;
        return keyedObject.getKey();
    }

    public int getIndex(Comparable comparable) {
        int n2 = -1;
        int n3 = 0;
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            KeyedObject keyedObject = (KeyedObject)iterator.next();
            if (keyedObject.getKey().equals(comparable)) {
                n2 = n3;
            }
            ++n3;
        }
        return n2;
    }

    public List getKeys() {
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            KeyedObject keyedObject = (KeyedObject)iterator.next();
            arrayList.add(keyedObject.getKey());
        }
        return arrayList;
    }

    public Object getObject(Comparable comparable) {
        return this.getObject(this.getIndex(comparable));
    }

    public void addObject(Comparable comparable, Object object) {
        this.setObject(comparable, object);
    }

    public void setObject(Comparable comparable, Object object) {
        int n2 = this.getIndex(comparable);
        if (n2 >= 0) {
            KeyedObject keyedObject = (KeyedObject)this.data.get(n2);
            keyedObject.setObject(object);
            return;
        }
        KeyedObject keyedObject = new KeyedObject(comparable, object);
        this.data.add(keyedObject);
    }

    public void removeValue(int n2) {
        this.data.remove(n2);
    }

    public void removeValue(Comparable comparable) {
        this.removeValue(this.getIndex(comparable));
    }

    @Override
    public Object clone() {
        KeyedObjects keyedObjects = (KeyedObjects)super.clone();
        keyedObjects.data = new ArrayList();
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            KeyedObject keyedObject = (KeyedObject)iterator.next();
            keyedObjects.data.add(keyedObject.clone());
        }
        return keyedObjects;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyedObjects)) {
            return false;
        }
        KeyedObjects keyedObjects = (KeyedObjects)object;
        int n2 = this.getItemCount();
        if (n2 != keyedObjects.getItemCount()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable;
            Comparable comparable2 = this.getKey(n3);
            if (!comparable2.equals(comparable = keyedObjects.getKey(n3))) {
                return false;
            }
            Object object2 = this.getObject(n3);
            Object object3 = keyedObjects.getObject(n3);
            if (object2 == null ? object3 != null : !object2.equals(object3)) {
                return false;
            }
            ++n3;
        }
        return true;
    }
}

