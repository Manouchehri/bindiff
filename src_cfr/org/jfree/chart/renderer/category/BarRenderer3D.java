/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
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
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class BarRenderer3D
extends BarRenderer
implements Serializable,
Cloneable,
Effect3D,
PublicCloneable {
    private static final long serialVersionUID = 7686976503536003636L;
    public static final double DEFAULT_X_OFFSET = 12.0;
    public static final double DEFAULT_Y_OFFSET = 8.0;
    public static final Paint DEFAULT_WALL_PAINT = new Color(221, 221, 221);
    private double xOffset;
    private double yOffset;
    private transient Paint wallPaint;

    public BarRenderer3D() {
        this(12.0, 8.0);
    }

    public BarRenderer3D(double d2, double d3) {
        this.xOffset = d2;
        this.yOffset = d3;
        this.wallPaint = DEFAULT_WALL_PAINT;
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER);
        this.setPositiveItemLabelPosition(itemLabelPosition);
        ItemLabelPosition itemLabelPosition2 = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER);
        this.setNegativeItemLabelPosition(itemLabelPosition2);
    }

    @Override
    public double getXOffset() {
        return this.xOffset;
    }

    @Override
    public double getYOffset() {
        return this.yOffset;
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
    public CategoryItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, CategoryPlot categoryPlot, int n2, PlotRenderingInfo plotRenderingInfo) {
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        return super.initialise(graphics2D, double_, categoryPlot, n2, plotRenderingInfo);
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
        double d3;
        Line2D.Double double_ = null;
        Line2D.Double double_2 = null;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d3 = d2;
            double d4 = d2 - this.getYOffset();
            double d5 = rectangle2D.getMinX();
            double d6 = d5 + this.getXOffset();
            double d7 = rectangle2D.getMaxX();
            double_ = new Line2D.Double(d5, d3, d6, d4);
            double_2 = new Line2D.Double(d6, d4, d7, d4);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d3 = d2;
            double d8 = d2 + this.getXOffset();
            double d9 = rectangle2D.getMaxY();
            double d10 = d9 - this.getYOffset();
            double d11 = rectangle2D.getMinY();
            double_ = new Line2D.Double(d3, d9, d8, d10);
            double_2 = new Line2D.Double(d8, d10, d8, d11);
        }
        Paint paint = categoryPlot.getDomainGridlinePaint();
        Stroke stroke = categoryPlot.getDomainGridlineStroke();
        graphics2D.setPaint(paint != null ? paint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke(stroke != null ? stroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(double_);
        graphics2D.draw(double_2);
    }

    @Override
    public void drawRangeGridline(Graphics2D graphics2D, CategoryPlot categoryPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2) {
        double d3;
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        Line2D.Double double_2 = null;
        Line2D.Double double_3 = null;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d3 = valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            double d4 = d3 + this.getXOffset();
            double d5 = rectangle2D.getMaxY();
            double d6 = d5 - this.getYOffset();
            double d7 = rectangle2D.getMinY();
            double_2 = new Line2D.Double(d3, d5, d4, d6);
            double_3 = new Line2D.Double(d4, d6, d4, d7);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d3 = valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            double d8 = d3 - this.getYOffset();
            double d9 = rectangle2D.getMinX();
            double d10 = d9 + this.getXOffset();
            double d11 = rectangle2D.getMaxX();
            double_2 = new Line2D.Double(d9, d3, d10, d8);
            double_3 = new Line2D.Double(d10, d8, d11, d8);
        }
        Paint paint = categoryPlot.getRangeGridlinePaint();
        Stroke stroke = categoryPlot.getRangeGridlineStroke();
        graphics2D.setPaint(paint != null ? paint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke(stroke != null ? stroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(double_2);
        graphics2D.draw(double_3);
    }

    @Override
    public void drawRangeMarker(Graphics2D graphics2D, CategoryPlot categoryPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        float f2;
        float f3;
        if (!(marker instanceof ValueMarker)) {
            super.drawRangeMarker(graphics2D, categoryPlot, valueAxis, marker, rectangle2D);
            return;
        }
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
            f3 = (float)valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            f2 = (float)double_.getMaxY();
            generalPath = new GeneralPath();
            generalPath.moveTo(f3, f2);
            generalPath.lineTo((float)((double)f3 + this.getXOffset()), f2 - (float)this.getYOffset());
            generalPath.lineTo((float)((double)f3 + this.getXOffset()), (float)(double_.getMinY() - this.getYOffset()));
            generalPath.lineTo(f3, (float)double_.getMinY());
            generalPath.closePath();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            f3 = (float)valueAxis.valueToJava2D(d2, double_, categoryPlot.getRangeAxisEdge());
            f2 = (float)rectangle2D.getX();
            generalPath = new GeneralPath();
            generalPath.moveTo(f2, f3);
            generalPath.lineTo(f2 + (float)this.xOffset, f3 - (float)this.yOffset);
            generalPath.lineTo((float)(double_.getMaxX() + this.xOffset), f3 - (float)this.yOffset);
            generalPath.lineTo((float)double_.getMaxX(), f3);
            generalPath.closePath();
        }
        graphics2D.setPaint(marker.getPaint());
        graphics2D.fill(generalPath);
        graphics2D.setPaint(marker.getOutlinePaint());
        graphics2D.draw(generalPath);
        String string = marker.getLabel();
        RectangleAnchor rectangleAnchor = marker.getLabelAnchor();
        if (string == null) return;
        Font font = marker.getLabelFont();
        graphics2D.setFont(font);
        graphics2D.setPaint(marker.getLabelPaint());
        Point2D point2D = this.calculateRangeMarkerTextAnchorPoint(graphics2D, plotOrientation, rectangle2D, generalPath.getBounds2D(), marker.getLabelOffset(), LengthAdjustmentType.EXPAND, rectangleAnchor);
        TextUtilities.drawAlignedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), marker.getLabelTextAnchor());
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        CategoryItemLabelGenerator categoryItemLabelGenerator;
        EntityCollection entityCollection;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d3 = this.calculateBarW0(categoryPlot, plotOrientation, double_, categoryAxis, categoryItemRendererState, n2, n3);
        double[] arrd = this.calculateBarL0L1(d2);
        if (arrd == null) {
            return;
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        double d4 = valueAxis.valueToJava2D(arrd[0], double_, rectangleEdge);
        double d5 = valueAxis.valueToJava2D(arrd[1], double_, rectangleEdge);
        double d6 = Math.min(d4, d5);
        double d7 = Math.abs(d5 - d4);
        Rectangle2D.Double double_2 = null;
        double_2 = plotOrientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(d6, d3, d7, categoryItemRendererState.getBarWidth()) : new Rectangle2D.Double(d3, d6, categoryItemRendererState.getBarWidth(), d7);
        Paint paint = this.getItemPaint(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.fill(double_2);
        double d8 = double_2.getMinX();
        double d9 = d8 + this.getXOffset();
        double d10 = double_2.getMaxX();
        double d11 = d10 + this.getXOffset();
        double d12 = double_2.getMinY() - this.getYOffset();
        double d13 = double_2.getMinY();
        double d14 = double_2.getMaxY() - this.getYOffset();
        double d15 = double_2.getMaxY();
        GeneralPath generalPath = null;
        GeneralPath generalPath2 = null;
        if (d7 > 0.0) {
            generalPath = new GeneralPath();
            generalPath.moveTo((float)d10, (float)d15);
            generalPath.lineTo((float)d10, (float)d13);
            generalPath.lineTo((float)d11, (float)d12);
            generalPath.lineTo((float)d11, (float)d14);
            generalPath.closePath();
            if (paint instanceof Color) {
                graphics2D.setPaint(((Color)paint).darker());
            }
            graphics2D.fill(generalPath);
        }
        generalPath2 = new GeneralPath();
        generalPath2.moveTo((float)d8, (float)d13);
        generalPath2.lineTo((float)d9, (float)d12);
        generalPath2.lineTo((float)d11, (float)d12);
        generalPath2.lineTo((float)d10, (float)d13);
        generalPath2.closePath();
        graphics2D.fill(generalPath2);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
            graphics2D.draw(double_2);
            if (generalPath != null) {
                graphics2D.draw(generalPath);
            }
            if (generalPath2 != null) {
                graphics2D.draw(generalPath2);
            }
        }
        if ((categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, categoryItemLabelGenerator, double_2, d2 < 0.0);
        }
        if ((entityCollection = categoryItemRendererState.getEntityCollection()) == null) return;
        GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo((float)d8, (float)d15);
        generalPath3.lineTo((float)d8, (float)d13);
        generalPath3.lineTo((float)d9, (float)d12);
        generalPath3.lineTo((float)d11, (float)d12);
        generalPath3.lineTo((float)d11, (float)d14);
        generalPath3.lineTo((float)d10, (float)d15);
        generalPath3.closePath();
        this.addItemEntity(entityCollection, categoryDataset, n2, n3, generalPath3);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BarRenderer3D)) {
            return false;
        }
        BarRenderer3D barRenderer3D = (BarRenderer3D)object;
        if (this.xOffset != barRenderer3D.xOffset) {
            return false;
        }
        if (this.yOffset != barRenderer3D.yOffset) {
            return false;
        }
        if (PaintUtilities.equal(this.wallPaint, barRenderer3D.wallPaint)) return super.equals(object);
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

