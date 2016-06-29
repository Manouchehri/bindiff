package org.jfree.data;

import java.io.*;
import org.jfree.util.*;
import java.util.*;

public class KeyedObjects implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 1321582394193530984L;
    private List data;
    
    public KeyedObjects() {
        this.data = new ArrayList();
    }
    
    public int getItemCount() {
        return this.data.size();
    }
    
    public Object getObject(final int n) {
        Object object = null;
        if (n >= 0 && n < this.data.size()) {
            final KeyedObject keyedObject = this.data.get(n);
            if (keyedObject != null) {
                object = keyedObject.getObject();
            }
        }
        return object;
    }
    
    public Comparable getKey(final int n) {
        Comparable key = null;
        if (n >= 0 && n < this.data.size()) {
            final KeyedObject keyedObject = this.data.get(n);
            if (keyedObject != null) {
                key = keyedObject.getKey();
            }
        }
        return key;
    }
    
    public int getIndex(final Comparable comparable) {
        int n = -1;
        int n2 = 0;
        final Iterator<KeyedObject> iterator = (Iterator<KeyedObject>)this.data.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(comparable)) {
                n = n2;
            }
            ++n2;
        }
        return n;
    }
    
    public List getKeys() {
        final ArrayList<Comparable> list = new ArrayList<Comparable>();
        final Iterator<KeyedObject> iterator = this.data.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getKey());
        }
        return list;
    }
    
    public Object getObject(final Comparable comparable) {
        return this.getObject(this.getIndex(comparable));
    }
    
    public void addObject(final Comparable comparable, final Object o) {
        this.setObject(comparable, o);
    }
    
    public void setObject(final Comparable comparable, final Object object) {
        final int index = this.getIndex(comparable);
        if (index >= 0) {
            ((KeyedObject)this.data.get(index)).setObject(object);
        }
        else {
            this.data.add(new KeyedObject(comparable, object));
        }
    }
    
    public void removeValue(final int n) {
        this.data.remove(n);
    }
    
    public void removeValue(final Comparable comparable) {
        this.removeValue(this.getIndex(comparable));
    }
    
    public Object clone() {
        final KeyedObjects keyedObjects = (KeyedObjects)super.clone();
        keyedObjects.data = new ArrayList();
        final Iterator<KeyedObject> iterator = this.data.iterator();
        while (iterator.hasNext()) {
            keyedObjects.data.add(iterator.next().clone());
        }
        return keyedObjects;
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyedObjects)) {
            return false;
        }
        final KeyedObjects keyedObjects = (KeyedObjects)o;
        final int itemCount = this.getItemCount();
        if (itemCount != keyedObjects.getItemCount()) {
            return false;
        }
        for (int i = 0; i < itemCount; ++i) {
            if (!this.getKey(i).equals(keyedObjects.getKey(i))) {
                return false;
            }
            final Object object = this.getObject(i);
            final Object object2 = keyedObjects.getObject(i);
            if (object == null) {
                if (object2 != null) {
                    return false;
                }
            }
            else if (!object.equals(object2)) {
                return false;
            }
        }
        return true;
    }
}
