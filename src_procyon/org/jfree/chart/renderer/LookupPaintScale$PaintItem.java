package org.jfree.chart.renderer;

import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

class LookupPaintScale$PaintItem implements Serializable, Comparable
{
    Number value;
    transient Paint paint;
    private final LookupPaintScale this$0;
    
    public LookupPaintScale$PaintItem(final LookupPaintScale this$0, final Number value, final Paint paint) {
        this.this$0 = this$0;
        this.value = value;
        this.paint = paint;
    }
    
    public int compareTo(final Object o) {
        final LookupPaintScale$PaintItem lookupPaintScale$PaintItem = (LookupPaintScale$PaintItem)o;
        final double doubleValue = this.value.doubleValue();
        final double doubleValue2 = lookupPaintScale$PaintItem.value.doubleValue();
        if (doubleValue > doubleValue2) {
            return 1;
        }
        if (doubleValue < doubleValue2) {
            return -1;
        }
        return 0;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LookupPaintScale$PaintItem)) {
            return false;
        }
        final LookupPaintScale$PaintItem lookupPaintScale$PaintItem = (LookupPaintScale$PaintItem)o;
        return this.value.equals(lookupPaintScale$PaintItem.value) && PaintUtilities.equal(this.paint, lookupPaintScale$PaintItem.paint);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
}
