package org.jfree.util;

import java.awt.*;
import org.jfree.io.*;
import java.io.*;

public class ShapeList extends AbstractObjectList
{
    public Shape getShape(final int n) {
        return (Shape)this.get(n);
    }
    
    public void setShape(final int n, final Shape shape) {
        this.set(n, shape);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof ShapeList && super.equals(o)));
    }
    
    public int hashCode() {
        return super.hashCode();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        final int size = this.size();
        objectOutputStream.writeInt(size);
        for (int i = 0; i < size; ++i) {
            final Shape shape = this.getShape(i);
            if (shape != null) {
                objectOutputStream.writeInt(i);
                SerialUtilities.writeShape(shape, objectOutputStream);
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
                this.setShape(int2, SerialUtilities.readShape(objectInputStream));
            }
        }
    }
}
