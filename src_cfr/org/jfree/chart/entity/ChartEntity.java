/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.URLTagFragmentGenerator;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class ChartEntity
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -4445994133561919083L;
    private transient Shape area;
    private String toolTipText;
    private String urlText;

    public ChartEntity(Shape shape) {
        this(shape, null);
    }

    public ChartEntity(Shape shape, String string) {
        this(shape, string, null);
    }

    public ChartEntity(Shape shape, String string, String string2) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        this.area = shape;
        this.toolTipText = string;
        this.urlText = string2;
    }

    public Shape getArea() {
        return this.area;
    }

    public void setArea(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        this.area = shape;
    }

    public String getToolTipText() {
        return this.toolTipText;
    }

    public void setToolTipText(String string) {
        this.toolTipText = string;
    }

    public String getURLText() {
        return this.urlText;
    }

    public void setURLText(String string) {
        this.urlText = string;
    }

    public String getShapeType() {
        if (!(this.area instanceof Rectangle2D)) return "poly";
        return "rect";
    }

    public String getShapeCoords() {
        if (!(this.area instanceof Rectangle2D)) return this.getPolyCoords(this.area);
        return this.getRectCoords((Rectangle2D)this.area);
    }

    private String getRectCoords(Rectangle2D rectangle2D) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'rectangle' argument.");
        }
        int n2 = (int)rectangle2D.getX();
        int n3 = (int)rectangle2D.getY();
        int n4 = n2 + (int)rectangle2D.getWidth();
        int n5 = n3 + (int)rectangle2D.getHeight();
        if (n4 == n2) {
            ++n4;
        }
        if (n5 != n3) return new StringBuffer().append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).toString();
        ++n5;
        return new StringBuffer().append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).toString();
    }

    private String getPolyCoords(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl2 = true;
        float[] arrf = new float[6];
        PathIterator pathIterator = shape.getPathIterator(null, 1.0);
        while (!pathIterator.isDone()) {
            pathIterator.currentSegment(arrf);
            if (bl2) {
                bl2 = false;
                stringBuffer.append((int)arrf[0]);
                stringBuffer.append(",").append((int)arrf[1]);
            } else {
                stringBuffer.append(",");
                stringBuffer.append((int)arrf[0]);
                stringBuffer.append(",");
                stringBuffer.append((int)arrf[1]);
            }
            pathIterator.next();
        }
        return stringBuffer.toString();
    }

    public String getImageMapAreaTag(ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator uRLTagFragmentGenerator) {
        boolean bl2;
        boolean bl3;
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl4 = this.urlText == null ? false : (bl2 = !this.urlText.equals(""));
        boolean bl5 = this.toolTipText == null ? false : (bl3 = !this.toolTipText.equals(""));
        if (!bl2) {
            if (!bl3) return stringBuffer.toString();
        }
        stringBuffer.append(new StringBuffer().append("<area shape=\"").append(this.getShapeType()).append("\"").append(" coords=\"").append(this.getShapeCoords()).append("\"").toString());
        if (bl3) {
            stringBuffer.append(toolTipTagFragmentGenerator.generateToolTipFragment(this.toolTipText));
        }
        if (bl2) {
            stringBuffer.append(uRLTagFragmentGenerator.generateURLFragment(this.urlText));
        }
        if (!bl3) {
            stringBuffer.append(" alt=\"\"");
        }
        stringBuffer.append("/>");
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ChartEntity: ");
        stringBuffer.append("tooltip = ");
        stringBuffer.append(this.toolTipText);
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ChartEntity)) return false;
        ChartEntity chartEntity = (ChartEntity)object;
        if (!this.area.equals(chartEntity.area)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipText, chartEntity.toolTipText)) {
            return false;
        }
        if (ObjectUtilities.equal(this.urlText, chartEntity.urlText)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.area, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.area = SerialUtilities.readShape(objectInputStream);
    }
}

