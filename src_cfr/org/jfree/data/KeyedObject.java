/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class KeyedObject
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 2677930479256885863L;
    private Comparable key;
    private Object object;

    public KeyedObject(Comparable comparable, Object object) {
        this.key = comparable;
        this.object = object;
    }

    public Comparable getKey() {
        return this.key;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object clone() {
        KeyedObject keyedObject = (KeyedObject)super.clone();
        if (!(this.object instanceof PublicCloneable)) return keyedObject;
        PublicCloneable publicCloneable = (PublicCloneable)this.object;
        keyedObject.object = publicCloneable.clone();
        return keyedObject;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyedObject)) {
            return false;
        }
        KeyedObject keyedObject = (KeyedObject)object;
        if (!ObjectUtilities.equal(this.key, keyedObject.key)) {
            return false;
        }
        if (ObjectUtilities.equal(this.object, keyedObject.object)) return true;
        return false;
    }
}

