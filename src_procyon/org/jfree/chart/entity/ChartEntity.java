package org.jfree.chart.entity;

import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.imagemap.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class ChartEntity implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -4445994133561919083L;
    private transient Shape area;
    private String toolTipText;
    private String urlText;
    
    public ChartEntity(final Shape shape) {
        this(shape, null);
    }
    
    public ChartEntity(final Shape shape, final String s) {
        this(shape, s, null);
    }
    
    public ChartEntity(final Shape area, final String toolTipText, final String urlText) {
        if (area == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        this.area = area;
        this.toolTipText = toolTipText;
        this.urlText = urlText;
    }
    
    public Shape getArea() {
        return this.area;
    }
    
    public void setArea(final Shape area) {
        if (area == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        this.area = area;
    }
    
    public String getToolTipText() {
        return this.toolTipText;
    }
    
    public void setToolTipText(final String toolTipText) {
        this.toolTipText = toolTipText;
    }
    
    public String getURLText() {
        return this.urlText;
    }
    
    public void setURLText(final String urlText) {
        this.urlText = urlText;
    }
    
    public String getShapeType() {
        if (this.area instanceof Rectangle2D) {
            return "rect";
        }
        return "poly";
    }
    
    public String getShapeCoords() {
        if (this.area instanceof Rectangle2D) {
            return this.getRectCoords((Rectangle2D)this.area);
        }
        return this.getPolyCoords(this.area);
    }
    
    private String getRectCoords(final Rectangle2D rectangle2D) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'rectangle' argument.");
        }
        final int n = (int)rectangle2D.getX();
        final int n2 = (int)rectangle2D.getY();
        int n3 = n + (int)rectangle2D.getWidth();
        int n4 = n2 + (int)rectangle2D.getHeight();
        if (n3 == n) {
            ++n3;
        }
        if (n4 == n2) {
            ++n4;
        }
        return n + "," + n2 + "," + n3 + "," + n4;
    }
    
    private String getPolyCoords(final Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        final StringBuffer sb = new StringBuffer();
        int n = 1;
        final float[] array = new float[6];
        final PathIterator pathIterator = shape.getPathIterator(null, 1.0);
        while (!pathIterator.isDone()) {
            pathIterator.currentSegment(array);
            if (n != 0) {
                n = 0;
                sb.append((int)array[0]);
                sb.append(",").append((int)array[1]);
            }
            else {
                sb.append(",");
                sb.append((int)array[0]);
                sb.append(",");
                sb.append((int)array[1]);
            }
            pathIterator.next();
        }
        return sb.toString();
    }
    
    public String getImageMapAreaTag(final ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, final URLTagFragmentGenerator urlTagFragmentGenerator) {
        final StringBuffer sb = new StringBuffer();
        final boolean b = this.urlText != null && !this.urlText.equals("");
        final boolean b2 = this.toolTipText != null && !this.toolTipText.equals("");
        if (b || b2) {
            sb.append("<area shape=\"" + this.getShapeType() + "\"" + " coords=\"" + this.getShapeCoords() + "\"");
            if (b2) {
                sb.append(toolTipTagFragmentGenerator.generateToolTipFragment(this.toolTipText));
            }
            if (b) {
                sb.append(urlTagFragmentGenerator.generateURLFragment(this.urlText));
            }
            if (!b2) {
                sb.append(" alt=\"\"");
            }
            sb.append("/>");
        }
        return sb.toString();
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChartEntity: ");
        sb.append("tooltip = ");
        sb.append(this.toolTipText);
        return sb.toString();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ChartEntity) {
            final ChartEntity chartEntity = (ChartEntity)o;
            return this.area.equals(chartEntity.area) && ObjectUtilities.equal(this.toolTipText, chartEntity.toolTipText) && ObjectUtilities.equal(this.urlText, chartEntity.urlText);
        }
        return false;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.area, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.area = SerialUtilities.readShape(objectInputStream);
    }
}
