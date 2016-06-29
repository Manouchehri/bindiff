package org.jfree.util;

import java.awt.*;
import org.jfree.io.*;
import java.io.*;

public class StrokeList extends AbstractObjectList
{
    public Stroke getStroke(final int n) {
        return (Stroke)this.get(n);
    }
    
    public void setStroke(final int n, final Stroke stroke) {
        this.set(n, stroke);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof StrokeList && super.equals(o)));
    }
    
    public int hashCode() {
        return super.hashCode();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        final int size = this.size();
        objectOutputStream.writeInt(size);
        for (int i = 0; i < size; ++i) {
            final Stroke stroke = this.getStroke(i);
            if (stroke != null) {
                objectOutputStream.writeInt(i);
                SerialUtilities.writeStroke(stroke, objectOutputStream);
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
                this.setStroke(int2, SerialUtilities.readStroke(objectInputStream));
            }
        }
    }
}
