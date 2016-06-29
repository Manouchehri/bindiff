/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.io.SerialUtilities;
import org.jfree.util.AbstractObjectList;

public class StrokeList
extends AbstractObjectList {
    public Stroke getStroke(int n2) {
        return (Stroke)this.get(n2);
    }

    public void setStroke(int n2, Stroke stroke) {
        this.set(n2, stroke);
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
        if (!(object instanceof StrokeList)) return false;
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
            Stroke stroke = this.getStroke(n3);
            if (stroke != null) {
                objectOutputStream.writeInt(n3);
                SerialUtilities.writeStroke(stroke, objectOutputStream);
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
                this.setStroke(n4, SerialUtilities.readStroke(objectInputStream));
            }
            ++n3;
        }
    }
}

