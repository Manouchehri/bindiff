/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.jfree.util.ObjectUtilities;

public class AbstractObjectList
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 7789833772597351595L;
    public static final int DEFAULT_INITIAL_CAPACITY = 8;
    private transient Object[] objects;
    private int size = 0;
    private int increment = 8;

    protected AbstractObjectList() {
        this(8);
    }

    protected AbstractObjectList(int n2) {
        this(n2, n2);
    }

    protected AbstractObjectList(int n2, int n3) {
        this.objects = new Object[n2];
        this.increment = n3;
    }

    protected Object get(int n2) {
        Object object = null;
        if (n2 < 0) return object;
        if (n2 >= this.size) return object;
        return this.objects[n2];
    }

    protected void set(int n2, Object object) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Requires index >= 0.");
        }
        if (n2 >= this.objects.length) {
            Object[] arrobject = new Object[n2 + this.increment];
            System.arraycopy(this.objects, 0, arrobject, 0, this.objects.length);
            this.objects = arrobject;
        }
        this.objects[n2] = object;
        this.size = Math.max(this.size, n2 + 1);
    }

    public void clear() {
        Arrays.fill(this.objects, null);
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    protected int indexOf(Object object) {
        int n2 = 0;
        while (n2 < this.size) {
            if (this.objects[n2] == object) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractObjectList)) {
            return false;
        }
        AbstractObjectList abstractObjectList = (AbstractObjectList)object;
        int n2 = this.size();
        int n3 = 0;
        while (n3 < n2) {
            if (!ObjectUtilities.equal(this.get(n3), abstractObjectList.get(n3))) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Object clone() {
        AbstractObjectList abstractObjectList = (AbstractObjectList)super.clone();
        if (this.objects == null) return abstractObjectList;
        abstractObjectList.objects = new Object[this.objects.length];
        System.arraycopy(this.objects, 0, abstractObjectList.objects, 0, this.objects.length);
        return abstractObjectList;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n2 = this.size();
        objectOutputStream.writeInt(n2);
        int n3 = 0;
        while (n3 < n2) {
            Object object = this.get(n3);
            if (object != null && object instanceof Serializable) {
                objectOutputStream.writeInt(n3);
                objectOutputStream.writeObject(object);
            } else {
                objectOutputStream.writeInt(-1);
            }
            ++n3;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.objects = new Object[this.size];
        int n2 = objectInputStream.readInt();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = objectInputStream.readInt();
            if (n4 != -1) {
                this.set(n4, objectInputStream.readObject());
            }
            ++n3;
        }
    }
}

