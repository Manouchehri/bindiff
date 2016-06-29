/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.io.SerialUtilities;
import org.jfree.util.AbstractObjectList;
import org.jfree.util.PaintUtilities;

public class PaintList
extends AbstractObjectList {
    public Paint getPaint(int n2) {
        return (Paint)this.get(n2);
    }

    public void setPaint(int n2, Paint paint) {
        this.set(n2, paint);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof PaintList)) return true;
        PaintList paintList = (PaintList)object;
        int n2 = this.size();
        int n3 = 0;
        while (n3 < n2) {
            if (!PaintUtilities.equal(this.getPaint(n3), paintList.getPaint(n3))) {
                return false;
            }
            ++n3;
        }
        return true;
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
            Paint paint = this.getPaint(n3);
            if (paint != null) {
                objectOutputStream.writeInt(n3);
                SerialUtilities.writePaint(paint, objectOutputStream);
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
                this.setPaint(n4, SerialUtilities.readPaint(objectInputStream));
            }
            ++n3;
        }
    }
}

