package org.jfree.data;

import java.io.*;
import org.jfree.util.*;

public class KeyedObject implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 2677930479256885863L;
    private Comparable key;
    private Object object;
    
    public KeyedObject(final Comparable key, final Object object) {
        this.key = key;
        this.object = object;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public Object getObject() {
        return this.object;
    }
    
    public void setObject(final Object object) {
        this.object = object;
    }
    
    public Object clone() {
        final KeyedObject keyedObject = (KeyedObject)super.clone();
        if (this.object instanceof PublicCloneable) {
            keyedObject.object = ((PublicCloneable)this.object).clone();
        }
        return keyedObject;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyedObject)) {
            return false;
        }
        final KeyedObject keyedObject = (KeyedObject)o;
        return ObjectUtilities.equal(this.key, keyedObject.key) && ObjectUtilities.equal(this.object, keyedObject.object);
    }
}
