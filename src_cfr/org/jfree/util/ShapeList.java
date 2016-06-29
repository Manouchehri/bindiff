/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.awt.Shape;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.io.SerialUtilities;
import org.jfree.util.AbstractObjectList;

public class ShapeList
extends AbstractObjectList {
    public Shape getShape(int n2) {
        return (Shape)this.get(n2);
    }

    public void setShape(int n2, Shape shape) {
        this.set(n2, shape);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof ShapeList)) return false;
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n2 = this.size();
        objectOutputStream.writeInt(n2);
        int n3 = 0;
        while (n3 < n2) {
            Shape shape = this.getShape(n3);
            if (shape != null) {
                objectOutputStream.writeInt(n3);
                SerialUtilities.writeShape(shape, objectOutputStream);
            } else {
                objectOutputStream.writeInt(-1);
            }
            ++n3;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n2 = objectInputStream.readInt();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = objectInputStream.readInt();
            if (n4 != -1) {
                this.setShape(n4, SerialUtilities.readShape(objectInputStream));
            }
            ++n3;
        }
    }
}

