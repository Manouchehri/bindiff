package org.jfree.util;

import java.awt.*;
import org.jfree.io.*;
import java.io.*;

public class PaintList extends AbstractObjectList
{
    public Paint getPaint(final int n) {
        return (Paint)this.get(n);
    }
    
    public void setPaint(final int n, final Paint paint) {
        this.set(n, paint);
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof PaintList) {
            final PaintList list = (PaintList)o;
            for (int size = this.size(), i = 0; i < size; ++i) {
                if (!PaintUtilities.equal(this.getPaint(i), list.getPaint(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int hashCode() {
        return super.hashCode();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        final int size = this.size();
        objectOutputStream.writeInt(size);
        for (int i = 0; i < size; ++i) {
            final Paint paint = this.getPaint(i);
            if (paint != null) {
                objectOutputStream.writeInt(i);
                SerialUtilities.writePaint(paint, objectOutputStream);
            }
            else {
                objectOutputStream.writeInt(-1);
            }
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        for (int int1 = objectInputStream.readInt(), i = 0; i < int1; ++i) {
            final int int2 = objectInputStream.readInt();
            if (int2 != -1) {
                this.setPaint(int2, SerialUtilities.readPaint(objectInputStream));
            }
        }
    }
}
