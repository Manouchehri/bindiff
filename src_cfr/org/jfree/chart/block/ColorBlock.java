/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;

public class ColorBlock
extends AbstractBlock
implements Block {
    private transient Paint paint;

    public ColorBlock(Paint paint, double d2, double d3) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.setWidth(d2);
        this.setHeight(d3);
    }

    public Paint getPaint() {
        return this.paint;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Rectangle2D rectangle2D2 = this.getBounds();
        graphics2D.setPaint(this.paint);
        graphics2D.fill(rectangle2D2);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ColorBlock)) {
            return false;
        }
        ColorBlock colorBlock = (ColorBlock)object;
        if (PaintUtilities.equal(this.paint, colorBlock.paint)) return super.equals(object);
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

