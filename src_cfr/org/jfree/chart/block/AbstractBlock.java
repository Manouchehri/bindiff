/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class AbstractBlock
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 7689852412141274563L;
    private String id = null;
    private RectangleInsets margin = RectangleInsets.ZERO_INSETS;
    private BlockFrame frame = BlockBorder.NONE;
    private RectangleInsets padding = RectangleInsets.ZERO_INSETS;
    private double width = 0.0;
    private double height = 0.0;
    private transient Rectangle2D bounds = new Rectangle2D.Float();

    protected AbstractBlock() {
    }

    public String getID() {
        return this.id;
    }

    public void setID(String string) {
        this.id = string;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double d2) {
        this.width = d2;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double d2) {
        this.height = d2;
    }

    public RectangleInsets getMargin() {
        return this.margin;
    }

    public void setMargin(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'margin' argument.");
        }
        this.margin = rectangleInsets;
    }

    public void setMargin(double d2, double d3, double d4, double d5) {
        this.setMargin(new RectangleInsets(d2, d3, d4, d5));
    }

    public BlockBorder getBorder() {
        if (!(this.frame instanceof BlockBorder)) return null;
        return (BlockBorder)this.frame;
    }

    public void setBorder(BlockBorder blockBorder) {
        this.setFrame(blockBorder);
    }

    public void setBorder(double d2, double d3, double d4, double d5) {
        this.setFrame(new BlockBorder(d2, d3, d4, d5));
    }

    public BlockFrame getFrame() {
        return this.frame;
    }

    public void setFrame(BlockFrame blockFrame) {
        if (blockFrame == null) {
            throw new IllegalArgumentException("Null 'frame' argument.");
        }
        this.frame = blockFrame;
    }

    public RectangleInsets getPadding() {
        return this.padding;
    }

    public void setPadding(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.padding = rectangleInsets;
    }

    public void setPadding(double d2, double d3, double d4, double d5) {
        this.setPadding(new RectangleInsets(d2, d3, d4, d5));
    }

    public double getContentXOffset() {
        return this.margin.getLeft() + this.frame.getInsets().getLeft() + this.padding.getLeft();
    }

    public double getContentYOffset() {
        return this.margin.getTop() + this.frame.getInsets().getTop() + this.padding.getTop();
    }

    public Size2D arrange(Graphics2D graphics2D) {
        return this.arrange(graphics2D, RectangleConstraint.NONE);
    }

    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = new Size2D(this.getWidth(), this.getHeight());
        return rectangleConstraint.calculateConstrainedSize(size2D);
    }

    public Rectangle2D getBounds() {
        return this.bounds;
    }

    public void setBounds(Rectangle2D rectangle2D) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'bounds' argument.");
        }
        this.bounds = rectangle2D;
    }

    protected double trimToContentWidth(double d2) {
        double d3 = this.margin.trimWidth(d2);
        d3 = this.frame.getInsets().trimWidth(d3);
        d3 = this.padding.trimWidth(d3);
        return Math.max(d3, 0.0);
    }

    protected double trimToContentHeight(double d2) {
        double d3 = this.margin.trimHeight(d2);
        d3 = this.frame.getInsets().trimHeight(d3);
        d3 = this.padding.trimHeight(d3);
        return Math.max(d3, 0.0);
    }

    protected RectangleConstraint toContentConstraint(RectangleConstraint rectangleConstraint) {
        if (rectangleConstraint == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        if (rectangleConstraint.equals(RectangleConstraint.NONE)) {
            return rectangleConstraint;
        }
        double d2 = rectangleConstraint.getWidth();
        Range range = rectangleConstraint.getWidthRange();
        double d3 = rectangleConstraint.getHeight();
        Range range2 = rectangleConstraint.getHeightRange();
        double d4 = this.trimToContentWidth(d2);
        double d5 = this.trimToContentHeight(d3);
        Range range3 = this.trimToContentWidth(range);
        Range range4 = this.trimToContentHeight(range2);
        return new RectangleConstraint(d4, range3, rectangleConstraint.getWidthConstraintType(), d5, range4, rectangleConstraint.getHeightConstraintType());
    }

    private Range trimToContentWidth(Range range) {
        if (range == null) {
            return null;
        }
        double d2 = 0.0;
        double d3 = Double.POSITIVE_INFINITY;
        if (range.getLowerBound() > 0.0) {
            d2 = this.trimToContentWidth(range.getLowerBound());
        }
        if (range.getUpperBound() >= Double.POSITIVE_INFINITY) return new Range(d2, d3);
        d3 = this.trimToContentWidth(range.getUpperBound());
        return new Range(d2, d3);
    }

    private Range trimToContentHeight(Range range) {
        if (range == null) {
            return null;
        }
        double d2 = 0.0;
        double d3 = Double.POSITIVE_INFINITY;
        if (range.getLowerBound() > 0.0) {
            d2 = this.trimToContentHeight(range.getLowerBound());
        }
        if (range.getUpperBound() >= Double.POSITIVE_INFINITY) return new Range(d2, d3);
        d3 = this.trimToContentHeight(range.getUpperBound());
        return new Range(d2, d3);
    }

    protected double calculateTotalWidth(double d2) {
        double d3 = d2;
        d3 = this.padding.extendWidth(d3);
        d3 = this.frame.getInsets().extendWidth(d3);
        return this.margin.extendWidth(d3);
    }

    protected double calculateTotalHeight(double d2) {
        double d3 = d2;
        d3 = this.padding.extendHeight(d3);
        d3 = this.frame.getInsets().extendHeight(d3);
        return this.margin.extendHeight(d3);
    }

    protected Rectangle2D trimMargin(Rectangle2D rectangle2D) {
        this.margin.trim(rectangle2D);
        return rectangle2D;
    }

    protected Rectangle2D trimBorder(Rectangle2D rectangle2D) {
        this.frame.getInsets().trim(rectangle2D);
        return rectangle2D;
    }

    protected Rectangle2D trimPadding(Rectangle2D rectangle2D) {
        this.padding.trim(rectangle2D);
        return rectangle2D;
    }

    protected void drawBorder(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.frame.draw(graphics2D, rectangle2D);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractBlock)) {
            return false;
        }
        AbstractBlock abstractBlock = (AbstractBlock)object;
        if (!ObjectUtilities.equal(this.id, abstractBlock.id)) {
            return false;
        }
        if (!this.frame.equals(abstractBlock.frame)) {
            return false;
        }
        if (!this.bounds.equals(abstractBlock.bounds)) {
            return false;
        }
        if (!this.margin.equals(abstractBlock.margin)) {
            return false;
        }
        if (!this.padding.equals(abstractBlock.padding)) {
            return false;
        }
        if (this.height != abstractBlock.height) {
            return false;
        }
        if (this.width == abstractBlock.width) return true;
        return false;
    }

    public Object clone() {
        AbstractBlock abstractBlock = (AbstractBlock)super.clone();
        abstractBlock.bounds = (Rectangle2D)ShapeUtilities.clone(this.bounds);
        if (!(this.frame instanceof PublicCloneable)) return abstractBlock;
        PublicCloneable publicCloneable = (PublicCloneable)((Object)this.frame);
        abstractBlock.frame = (BlockFrame)publicCloneable.clone();
        return abstractBlock;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.bounds, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.bounds = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
    }
}

