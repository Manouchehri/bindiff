package org.jfree.chart.block;

import java.awt.geom.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class ColorBlock extends AbstractBlock implements Block
{
    private transient Paint paint;
    
    public ColorBlock(final Paint paint, final double width, final double height) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final Rectangle2D bounds = this.getBounds();
        graphics2D.setPaint(this.paint);
        graphics2D.fill(bounds);
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof ColorBlock && PaintUtilities.equal(this.paint, ((ColorBlock)o).paint) && super.equals(o));
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
