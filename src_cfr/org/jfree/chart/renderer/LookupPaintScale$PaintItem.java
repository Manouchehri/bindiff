/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;

class LookupPaintScale$PaintItem
implements Serializable,
Comparable {
    Number value;
    transient Paint paint;
    private final LookupPaintScale this$0;

    public LookupPaintScale$PaintItem(LookupPaintScale lookupPaintScale, Number number, Paint paint) {
        this.this$0 = lookupPaintScale;
        this.value = number;
        this.paint = paint;
    }

    public int compareTo(Object object) {
        double d2;
        LookupPaintScale$PaintItem lookupPaintScale$PaintItem = (LookupPaintScale$PaintItem)object;
        double d3 = this.value.doubleValue();
        if (d3 > (d2 = lookupPaintScale$PaintItem.value.doubleValue())) {
            return 1;
        }
        if (d3 >= d2) return 0;
        return -1;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LookupPaintScale$PaintItem)) {
            return false;
        }
        LookupPaintScale$PaintItem lookupPaintScale$PaintItem = (LookupPaintScale$PaintItem)object;
        if (!this.value.equals(lookupPaintScale$PaintItem.value)) {
            return false;
        }
        if (PaintUtilities.equal(this.paint, lookupPaintScale$PaintItem.paint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
}

