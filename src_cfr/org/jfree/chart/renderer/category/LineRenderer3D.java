/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.ShapeUtilities;

public class LineRenderer3D
extends LineAndShapeRenderer
implements Serializable,
Effect3D {
    private static final long serialVersionUID = 5467931468380928736L;
    public static final double DEFAULT_X_OFFSET = 12.0;
    public static final double DEFAULT_Y_OFFSET = 8.0;
    public static final Paint DEFAULT_WALL_PAINT = new Color(221, 221, 221);
    private double xOffset = 12.0;
    private double yOffset = 8.0;
    private transient Paint wallPaint = DEFAULT_WALL_PAINT;

    public LineRenderer3D() {
        super(true, false);
    }

    @Override
    public double getXOffset() {
        return this.xOffset;
    }

    @Override
    public double getYOffset() {
        return this.yOffset;
    }

    public void setXOffset(double d2) {
        this.xOffset = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setYOffset(double d2) {
        this.yOffset = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getWallPaint() {
        return this.wallPaint;
    }

    public void setWallPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.wallPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawBackground(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D) {
        float f2 = (float)rectangle2D.getX();
        float f3 = f2 + (float)Math.abs(this.xOffset);
        float f4 = (float)rectangle2D.getMaxX();
        float f5 = f4 - (float)Math.abs(this.xOffset);
        float f6 = (float)rectangle2D.getMaxY();
        float f7 = f6 - (float)Math.abs(this.yOffset);
        float f8 = (float)rectangle2D.getMinY();
        float f9 = f8 + (float)Math.abs(this.yOffset);
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(f2, f6);
        generalPath.lineTo(f2, f9);
        generalPath.lineTo(f3, f8);
        generalPath.lineTo(f4, f8);
        generalPath.lineTo(f4, f7);
        generalPath.lineTo(f5, f6);
        generalPath.closePath();
        Paint paint = categoryPlot.getBackgroundPaint();
        if (paint != null) {
            graphics2D.setPaint(paint);
            graphics2D.fill(generalPath);
        }
        GeneralPath generalPath2 = new GeneralPath();
        generalPath2.moveTo(f2, f6);
        generalPath2.lineTo(f2, f9);
        generalPath2.lineTo(f3, f8);
        generalPath2.lineTo(f3, f7);
        generalPath2.closePath();
        graphics2D.setPaint(this.getWallPaint());
        graphics2D.fill(generalPath2);
        GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo(f2, f6);
        generalPath3.lineTo(f3, f7);
        generalPath3.lineTo(f4, f7);
        generalPath3.lineTo(f5, f6);
        generalPath3.closePath();
        graphics2D.setPaint(this.getWallPaint());
        graphics2D.fill(generalPath3);
        graphics2D.setPaint(Color.lightGray);
        Line2D.Double double_ = new Line2D.Double(f2, f6, f3, f7);
        graphics2D.draw(double_);
        double_.setLine(f3, f7, f3, f8);
        graphics2D.draw(double_);
        double_.setLine(f3, f7, f4, f7);
        graphics2D.draw(double_);
        Image image = categoryPlot.getBackgroundImage();
        if (image == null) return;
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(2, categoryPlot.getBackgroundAlpha()));
        graphics2D.drawImage(image, (int)f3, (int)f8, (int)(f4 - f3 + 1.0f), (int)(f7 - f8 + 1.0f), null);
        graphics2D.setComposite(composite);
    }

    @Override
    public void drawOutline(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D) {
        float f2 = (float)rectangle2D.getX();
        float f3 = f2 + (float)Math.abs(this.xOffset);
        float f4 = (float)rectangle2D.getMaxX();
        float f5 = f4 - (float)Math.abs(this.xOffset);
        float f6 = (float)rectangle2D.getMaxY();
        float f7 = f6 - (float)Math.abs(this.yOffset);
        float f8 = (float)rectangle2D.getMinY();
        float f9 = f8 + (float)Math.abs(this.yOffset);
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(f2, f6);
        generalPath.lineTo(f2, f9);
        generalPath.lineTo(f3, f8);
        generalPath.lineTo(f4, f8);
        generalPath.lineTo(f4, f7);
        generalPath.lineTo(f5, f6);
        generalPath.closePath();
        Stroke stroke = categoryPlot.getOutlineStroke();
        Paint paint = categoryPlot.getOutlinePaint();
        if (stroke == null) return;
        if (paint == null) return;
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(generalPath);
    }

    @Override
    public void drawDomainGridline(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D, double d2) {
        Line2D.Double double_ = null;
        Line2D.Double double_2 = null;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double d3 = d2;
            double d4 = d2 - this.getYOffset();
            double d5 = rectangle2D.getMinX();
            double d6 = d5 + this.getXOffset();
            double d7 = rectangle2D.getMaxX();
            double_ = new Line2D.Double(d5, d3, d6, d4);
            double_2 = new Line2D.Double(d6, d4, d7, d4);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double d8 = d2;
            double d9 = d2 + this.getXOffset();
            double d10 = rectangle2D.getMaxY();
            double d11 = d10 - this.getYOffset();
            double d12 = rectangle2D.getMinY();
            double_ = new Line2D.Double(d8, d10, d9, d11);
            double_2 = new Line2D.Double(d9, d11, d9, d12);
        }
        graphics2D.setPaint(categoryPlot.getDomainGridlinePaint());
        graphics2D.setStroke(categoryPlot.getDomainGridlineStroke());
        graphics2D.draw(double_);
        graphics2D.draw(double_2);
    }

    @Override
    public void drawRangeGridline(Graphics2D graphics2D, CategoryPlot categoryPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2) {
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        Line2D.Double double_2 = null;
        Line2D.Double double_3 = null;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double d3 = valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            double d4 = d3 + this.getXOffset();
            double d5 = rectangle2D.getMaxY();
            double d6 = d5 - this.getYOffset();
            double d7 = rectangle2D.getMinY();
            double_2 = new Line2D.Double(d3, d5, d4, d6);
            double_3 = new Line2D.Double(d4, d6, d4, d7);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double d8 = valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            double d9 = d8 - this.getYOffset();
            double d10 = rectangle2D.getMinX();
            double d11 = d10 + this.getXOffset();
            double d12 = rectangle2D.getMaxX();
            double_2 = new Line2D.Double(d10, d8, d11, d9);
            double_3 = new Line2D.Double(d11, d9, d12, d9);
        }
        graphics2D.setPaint(categoryPlot.getRangeGridlinePaint());
        graphics2D.setStroke(categoryPlot.getRangeGridlineStroke());
        graphics2D.draw(double_2);
        graphics2D.draw(double_3);
    }

    @Override
    public void drawRangeMarker(Graphics2D graphics2D, CategoryPlot categoryPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        if (!(marker instanceof ValueMarker)) return;
        ValueMarker valueMarker = (ValueMarker)marker;
        double d2 = valueMarker.getValue();
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        GeneralPath generalPath = null;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            float f2 = (float)valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            float f3 = (float)double_.getMaxY();
            generalPath = new GeneralPath();
            generalPath.moveTo(f2, f3);
            generalPath.lineTo((float)((double)f2 + this.getXOffset()), f3 - (float)this.getYOffset());
            generalPath.lineTo((float)((double)f2 + this.getXOffset()), (float)(double_.getMinY() - this.getYOffset()));
            generalPath.lineTo(f2, (float)double_.getMinY());
            generalPath.closePath();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            float f4 = (float)valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            float f5 = (float)rectangle2D.getX();
            generalPath = new GeneralPath();
            generalPath.moveTo(f5, f4);
            generalPath.lineTo(f5 + (float)this.xOffset, f4 - (float)this.yOffset);
            generalPath.lineTo((float)(double_.getMaxX() + this.xOffset), f4 - (float)this.yOffset);
            generalPath.lineTo((float)double_.getMaxX(), f4);
            generalPath.closePath();
        }
        graphics2D.setPaint(marker.getPaint());
        graphics2D.fill(generalPath);
        graphics2D.setPaint(marker.getOutlinePaint());
        graphics2D.draw(generalPath);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Object object;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), double_, categoryPlot.getDomainAxisEdge());
        double d3 = number.doubleValue();
        double d4 = valueAxis.valueToJava2D(d3, double_, categoryPlot.getRangeAxisEdge());
        Shape shape = this.getItemShape(n2, n3);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, d4, d2);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, d2, d4);
        }
        if (this.getItemLineVisible(n2, n3) && n3 != 0 && (object = categoryDataset.getValue(n2, n3 - 1)) != null) {
            double d5 = object.doubleValue();
            double d6 = categoryAxis.getCategoryMiddle(n3 - 1, this.getColumnCount(), double_, categoryPlot.getDomainAxisEdge());
            double d7 = valueAxis.valueToJava2D(d5, double_, categoryPlot.getRangeAxisEdge());
            double d8 = d6 + this.getXOffset();
            double d9 = d7 - this.getYOffset();
            double d10 = d2 + this.getXOffset();
            double d11 = d4 - this.getYOffset();
            GeneralPath generalPath = new GeneralPath();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                generalPath.moveTo((float)d7, (float)d6);
                generalPath.lineTo((float)d4, (float)d2);
                generalPath.lineTo((float)d11, (float)d10);
                generalPath.lineTo((float)d9, (float)d8);
                generalPath.lineTo((float)d7, (float)d6);
                generalPath.closePath();
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                generalPath.moveTo((float)d6, (float)d7);
                generalPath.lineTo((float)d2, (float)d4);
                generalPath.lineTo((float)d10, (float)d11);
                generalPath.lineTo((float)d8, (float)d9);
                generalPath.lineTo((float)d6, (float)d7);
                generalPath.closePath();
            }
            graphics2D.setPaint(this.getItemPaint(n2, n3));
            graphics2D.fill(generalPath);
            graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
            graphics2D.draw(generalPath);
        }
        if (this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d2, d4, d3 < 0.0);
        }
        if ((object = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity((EntityCollection)object, categoryDataset, n2, n3, shape);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LineRenderer3D)) {
            return false;
        }
        LineRenderer3D lineRenderer3D = (LineRenderer3D)object;
        if (this.xOffset != lineRenderer3D.xOffset) {
            return false;
        }
        if (this.yOffset != lineRenderer3D.yOffset) {
            return false;
        }
        if (PaintUtilities.equal(this.wallPaint, lineRenderer3D.wallPaint)) return super.equals(object);
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.wallPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.wallPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

