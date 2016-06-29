package org.jfree.chart.block;

import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.data.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class AbstractBlock implements Serializable, Cloneable
{
    private static final long serialVersionUID = 7689852412141274563L;
    private String id;
    private RectangleInsets margin;
    private BlockFrame frame;
    private RectangleInsets padding;
    private double width;
    private double height;
    private transient Rectangle2D bounds;
    
    protected AbstractBlock() {
        this.id = null;
        this.width = 0.0;
        this.height = 0.0;
        this.bounds = new Rectangle2D.Float();
        this.margin = RectangleInsets.ZERO_INSETS;
        this.frame = BlockBorder.NONE;
        this.padding = RectangleInsets.ZERO_INSETS;
    }
    
    public String getID() {
        return this.id;
    }
    
    public void setID(final String id) {
        this.id = id;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(final double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(final double height) {
        this.height = height;
    }
    
    public RectangleInsets getMargin() {
        return this.margin;
    }
    
    public void setMargin(final RectangleInsets margin) {
        if (margin == null) {
            throw new IllegalArgumentException("Null 'margin' argument.");
        }
        this.margin = margin;
    }
    
    public void setMargin(final double n, final double n2, final double n3, final double n4) {
        this.setMargin(new RectangleInsets(n, n2, n3, n4));
    }
    
    public BlockBorder getBorder() {
        if (this.frame instanceof BlockBorder) {
            return (BlockBorder)this.frame;
        }
        return null;
    }
    
    public void setBorder(final BlockBorder frame) {
        this.setFrame(frame);
    }
    
    public void setBorder(final double n, final double n2, final double n3, final double n4) {
        this.setFrame(new BlockBorder(n, n2, n3, n4));
    }
    
    public BlockFrame getFrame() {
        return this.frame;
    }
    
    public void setFrame(final BlockFrame frame) {
        if (frame == null) {
            throw new IllegalArgumentException("Null 'frame' argument.");
        }
        this.frame = frame;
    }
    
    public RectangleInsets getPadding() {
        return this.padding;
    }
    
    public void setPadding(final RectangleInsets padding) {
        if (padding == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        this.padding = padding;
    }
    
    public void setPadding(final double n, final double n2, final double n3, final double n4) {
        this.setPadding(new RectangleInsets(n, n2, n3, n4));
    }
    
    public double getContentXOffset() {
        return this.margin.getLeft() + this.frame.getInsets().getLeft() + this.padding.getLeft();
    }
    
    public double getContentYOffset() {
        return this.margin.getTop() + this.frame.getInsets().getTop() + this.padding.getTop();
    }
    
    public Size2D arrange(final Graphics2D graphics2D) {
        return this.arrange(graphics2D, RectangleConstraint.NONE);
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        return rectangleConstraint.calculateConstrainedSize(new Size2D(this.getWidth(), this.getHeight()));
    }
    
    public Rectangle2D getBounds() {
        return this.bounds;
    }
    
    public void setBounds(final Rectangle2D bounds) {
        if (bounds == null) {
            throw new IllegalArgumentException("Null 'bounds' argument.");
        }
        this.bounds = bounds;
    }
    
    protected double trimToContentWidth(final double n) {
        return Math.max(this.padding.trimWidth(this.frame.getInsets().trimWidth(this.margin.trimWidth(n))), 0.0);
    }
    
    protected double trimToContentHeight(final double n) {
        return Math.max(this.padding.trimHeight(this.frame.getInsets().trimHeight(this.margin.trimHeight(n))), 0.0);
    }
    
    protected RectangleConstraint toContentConstraint(final RectangleConstraint rectangleConstraint) {
        if (rectangleConstraint == null) {
            throw new IllegalArgumentException("Null 'c' argument.");
        }
        if (rectangleConstraint.equals(RectangleConstraint.NONE)) {
            return rectangleConstraint;
        }
        return new RectangleConstraint(this.trimToContentWidth(rectangleConstraint.getWidth()), this.trimToContentWidth(rectangleConstraint.getWidthRange()), rectangleConstraint.getWidthConstraintType(), this.trimToContentHeight(rectangleConstraint.getHeight()), this.trimToContentHeight(rectangleConstraint.getHeightRange()), rectangleConstraint.getHeightConstraintType());
    }
    
    private Range trimToContentWidth(final Range range) {
        if (range == null) {
            return null;
        }
        double trimToContentWidth = 0.0;
        double trimToContentWidth2 = Double.POSITIVE_INFINITY;
        if (range.getLowerBound() > 0.0) {
            trimToContentWidth = this.trimToContentWidth(range.getLowerBound());
        }
        if (range.getUpperBound() < Double.POSITIVE_INFINITY) {
            trimToContentWidth2 = this.trimToContentWidth(range.getUpperBound());
        }
        return new Range(trimToContentWidth, trimToContentWidth2);
    }
    
    private Range trimToContentHeight(final Range range) {
        if (range == null) {
            return null;
        }
        double trimToContentHeight = 0.0;
        double trimToContentHeight2 = Double.POSITIVE_INFINITY;
        if (range.getLowerBound() > 0.0) {
            trimToContentHeight = this.trimToContentHeight(range.getLowerBound());
        }
        if (range.getUpperBound() < Double.POSITIVE_INFINITY) {
            trimToContentHeight2 = this.trimToContentHeight(range.getUpperBound());
        }
        return new Range(trimToContentHeight, trimToContentHeight2);
    }
    
    protected double calculateTotalWidth(final double n) {
        return this.margin.extendWidth(this.frame.getInsets().extendWidth(this.padding.extendWidth(n)));
    }
    
    protected double calculateTotalHeight(final double n) {
        return this.margin.extendHeight(this.frame.getInsets().extendHeight(this.padding.extendHeight(n)));
    }
    
    protected Rectangle2D trimMargin(final Rectangle2D rectangle2D) {
        this.margin.trim(rectangle2D);
        return rectangle2D;
    }
    
    protected Rectangle2D trimBorder(final Rectangle2D rectangle2D) {
        this.frame.getInsets().trim(rectangle2D);
        return rectangle2D;
    }
    
    protected Rectangle2D trimPadding(final Rectangle2D rectangle2D) {
        this.padding.trim(rectangle2D);
        return rectangle2D;
    }
    
    protected void drawBorder(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.frame.draw(graphics2D, rectangle2D);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractBlock)) {
            return false;
        }
        final AbstractBlock abstractBlock = (AbstractBlock)o;
        return ObjectUtilities.equal(this.id, abstractBlock.id) && this.frame.equals(abstractBlock.frame) && this.bounds.equals(abstractBlock.bounds) && this.margin.equals(abstractBlock.margin) && this.padding.equals(abstractBlock.padding) && this.height == abstractBlock.height && this.width == abstractBlock.width;
    }
    
    public Object clone() {
        final AbstractBlock abstractBlock = (AbstractBlock)super.clone();
        abstractBlock.bounds = (Rectangle2D)ShapeUtilities.clone(this.bounds);
        if (this.frame instanceof PublicCloneable) {
            abstractBlock.frame = (BlockFrame)((PublicCloneable)this.frame).clone();
        }
        return abstractBlock;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.bounds, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.bounds = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
    }
}
