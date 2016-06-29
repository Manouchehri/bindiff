package org.jfree.chart.renderer.category;

import org.jfree.chart.*;
import org.jfree.chart.event.*;
import java.awt.image.*;
import java.awt.*;
import org.jfree.chart.plot.*;
import org.jfree.text.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.ui.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class BarRenderer3D extends BarRenderer implements Serializable, Cloneable, Effect3D, PublicCloneable
{
    private static final long serialVersionUID = 7686976503536003636L;
    public static final double DEFAULT_X_OFFSET = 12.0;
    public static final double DEFAULT_Y_OFFSET = 8.0;
    public static final Paint DEFAULT_WALL_PAINT;
    private double xOffset;
    private double yOffset;
    private transient Paint wallPaint;
    
    public BarRenderer3D() {
        this(12.0, 8.0);
    }
    
    public BarRenderer3D(final double xOffset, final double yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.wallPaint = BarRenderer3D.DEFAULT_WALL_PAINT;
        this.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER));
        this.setNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER));
    }
    
    public double getXOffset() {
        return this.xOffset;
    }
    
    public double getYOffset() {
        return this.yOffset;
    }
    
    public Paint getWallPaint() {
        return this.wallPaint;
    }
    
    public void setWallPaint(final Paint wallPaint) {
        if (wallPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.wallPaint = wallPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategoryItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final int n, final PlotRenderingInfo plotRenderingInfo) {
        return super.initialise(graphics2D, new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset()), categoryPlot, n, plotRenderingInfo);
    }
    
    public void drawBackground(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D) {
        final float n = (float)rectangle2D.getX();
        final float n2 = n + (float)Math.abs(this.xOffset);
        final float n3 = (float)rectangle2D.getMaxX();
        final float n4 = n3 - (float)Math.abs(this.xOffset);
        final float n5 = (float)rectangle2D.getMaxY();
        final float n6 = n5 - (float)Math.abs(this.yOffset);
        final float n7 = (float)rectangle2D.getMinY();
        final float n8 = n7 + (float)Math.abs(this.yOffset);
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(n, n5);
        generalPath.lineTo(n, n8);
        generalPath.lineTo(n2, n7);
        generalPath.lineTo(n3, n7);
        generalPath.lineTo(n3, n6);
        generalPath.lineTo(n4, n5);
        generalPath.closePath();
        final Paint backgroundPaint = categoryPlot.getBackgroundPaint();
        if (backgroundPaint != null) {
            graphics2D.setPaint(backgroundPaint);
            graphics2D.fill(generalPath);
        }
        final GeneralPath generalPath2 = new GeneralPath();
        generalPath2.moveTo(n, n5);
        generalPath2.lineTo(n, n8);
        generalPath2.lineTo(n2, n7);
        generalPath2.lineTo(n2, n6);
        generalPath2.closePath();
        graphics2D.setPaint(this.getWallPaint());
        graphics2D.fill(generalPath2);
        final GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo(n, n5);
        generalPath3.lineTo(n2, n6);
        generalPath3.lineTo(n3, n6);
        generalPath3.lineTo(n4, n5);
        generalPath3.closePath();
        graphics2D.setPaint(this.getWallPaint());
        graphics2D.fill(generalPath3);
        graphics2D.setPaint(Color.lightGray);
        final Line2D.Double double1 = new Line2D.Double(n, n5, n2, n6);
        graphics2D.draw(double1);
        double1.setLine(n2, n6, n2, n7);
        graphics2D.draw(double1);
        double1.setLine(n2, n6, n3, n6);
        graphics2D.draw(double1);
        final Image backgroundImage = categoryPlot.getBackgroundImage();
        if (backgroundImage != null) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(2, categoryPlot.getBackgroundAlpha()));
            graphics2D.drawImage(backgroundImage, (int)n2, (int)n7, (int)(n3 - n2 + 1.0f), (int)(n6 - n7 + 1.0f), null);
            graphics2D.setComposite(composite);
        }
    }
    
    public void drawOutline(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D) {
        final float n = (float)rectangle2D.getX();
        final float n2 = n + (float)Math.abs(this.xOffset);
        final float n3 = (float)rectangle2D.getMaxX();
        final float n4 = n3 - (float)Math.abs(this.xOffset);
        final float n5 = (float)rectangle2D.getMaxY();
        final float n6 = n5 - (float)Math.abs(this.yOffset);
        final float n7 = (float)rectangle2D.getMinY();
        final float n8 = n7 + (float)Math.abs(this.yOffset);
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(n, n5);
        generalPath.lineTo(n, n8);
        generalPath.lineTo(n2, n7);
        generalPath.lineTo(n3, n7);
        generalPath.lineTo(n3, n6);
        generalPath.lineTo(n4, n5);
        generalPath.closePath();
        final Stroke outlineStroke = categoryPlot.getOutlineStroke();
        final Paint outlinePaint = categoryPlot.getOutlinePaint();
        if (outlineStroke != null && outlinePaint != null) {
            graphics2D.setStroke(outlineStroke);
            graphics2D.setPaint(outlinePaint);
            graphics2D.draw(generalPath);
        }
    }
    
    public void drawDomainGridline(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final double n) {
        Shape shape = null;
        Shape shape2 = null;
        final PlotOrientation orientation = categoryPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double n2 = n - this.getYOffset();
            final double minX = rectangle2D.getMinX();
            final double n3 = minX + this.getXOffset();
            final double maxX = rectangle2D.getMaxX();
            shape = new Line2D.Double(minX, n, n3, n2);
            shape2 = new Line2D.Double(n3, n2, maxX, n2);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            final double n4 = n + this.getXOffset();
            final double maxY = rectangle2D.getMaxY();
            final double n5 = maxY - this.getYOffset();
            final double minY = rectangle2D.getMinY();
            shape = new Line2D.Double(n, maxY, n4, n5);
            shape2 = new Line2D.Double(n4, n5, n4, minY);
        }
        final Paint domainGridlinePaint = categoryPlot.getDomainGridlinePaint();
        final Stroke domainGridlineStroke = categoryPlot.getDomainGridlineStroke();
        graphics2D.setPaint((domainGridlinePaint != null) ? domainGridlinePaint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke((domainGridlineStroke != null) ? domainGridlineStroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(shape);
        graphics2D.draw(shape2);
    }
    
    public void drawRangeGridline(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n) {
        if (!valueAxis.getRange().contains(n)) {
            return;
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        Shape shape = null;
        Shape shape2 = null;
        final PlotOrientation orientation = categoryPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double valueToJava2D = valueAxis.valueToJava2D(n, double1, categoryPlot.getRangeAxisEdge());
            final double n2 = valueToJava2D + this.getXOffset();
            final double maxY = rectangle2D.getMaxY();
            final double n3 = maxY - this.getYOffset();
            final double minY = rectangle2D.getMinY();
            shape = new Line2D.Double(valueToJava2D, maxY, n2, n3);
            shape2 = new Line2D.Double(n2, n3, n2, minY);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            final double valueToJava2D2 = valueAxis.valueToJava2D(n, double1, categoryPlot.getRangeAxisEdge());
            final double n4 = valueToJava2D2 - this.getYOffset();
            final double minX = rectangle2D.getMinX();
            final double n5 = minX + this.getXOffset();
            final double maxX = rectangle2D.getMaxX();
            shape = new Line2D.Double(minX, valueToJava2D2, n5, n4);
            shape2 = new Line2D.Double(n5, n4, maxX, n4);
        }
        final Paint rangeGridlinePaint = categoryPlot.getRangeGridlinePaint();
        final Stroke rangeGridlineStroke = categoryPlot.getRangeGridlineStroke();
        graphics2D.setPaint((rangeGridlinePaint != null) ? rangeGridlinePaint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke((rangeGridlineStroke != null) ? rangeGridlineStroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(shape);
        graphics2D.draw(shape2);
    }
    
    public void drawRangeMarker(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final ValueAxis valueAxis, final Marker marker, final Rectangle2D rectangle2D) {
        if (marker instanceof ValueMarker) {
            final double value = ((ValueMarker)marker).getValue();
            if (!valueAxis.getRange().contains(value)) {
                return;
            }
            final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
            Path2D.Float float1 = null;
            final PlotOrientation orientation = categoryPlot.getOrientation();
            if (orientation == PlotOrientation.HORIZONTAL) {
                final float n = (float)valueAxis.valueToJava2D(value, double1, categoryPlot.getRangeAxisEdge());
                final float n2 = (float)double1.getMaxY();
                float1 = new GeneralPath();
                float1.moveTo(n, n2);
                float1.lineTo((float)(n + this.getXOffset()), n2 - (float)this.getYOffset());
                float1.lineTo((float)(n + this.getXOffset()), (float)(double1.getMinY() - this.getYOffset()));
                float1.lineTo(n, (float)double1.getMinY());
                float1.closePath();
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                final float n3 = (float)valueAxis.valueToJava2D(value, double1, categoryPlot.getRangeAxisEdge());
                final float n4 = (float)rectangle2D.getX();
                float1 = new GeneralPath();
                float1.moveTo(n4, n3);
                float1.lineTo(n4 + (float)this.xOffset, n3 - (float)this.yOffset);
                float1.lineTo((float)(double1.getMaxX() + this.xOffset), n3 - (float)this.yOffset);
                float1.lineTo((float)double1.getMaxX(), n3);
                float1.closePath();
            }
            graphics2D.setPaint(marker.getPaint());
            graphics2D.fill(float1);
            graphics2D.setPaint(marker.getOutlinePaint());
            graphics2D.draw(float1);
            final String label = marker.getLabel();
            final RectangleAnchor labelAnchor = marker.getLabelAnchor();
            if (label != null) {
                graphics2D.setFont(marker.getLabelFont());
                graphics2D.setPaint(marker.getLabelPaint());
                final Point2D calculateRangeMarkerTextAnchorPoint = this.calculateRangeMarkerTextAnchorPoint(graphics2D, orientation, rectangle2D, float1.getBounds2D(), marker.getLabelOffset(), LengthAdjustmentType.EXPAND, labelAnchor);
                TextUtilities.drawAlignedString(label, graphics2D, (float)calculateRangeMarkerTextAnchorPoint.getX(), (float)calculateRangeMarkerTextAnchorPoint.getY(), marker.getLabelTextAnchor());
            }
        }
        else {
            super.drawRangeMarker(graphics2D, categoryPlot, valueAxis, marker, rectangle2D);
        }
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final double doubleValue = value.doubleValue();
        final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double calculateBarW0 = this.calculateBarW0(categoryPlot, orientation, double1, categoryAxis, categoryItemRendererState, n, n2);
        final double[] calculateBarL0L1 = this.calculateBarL0L1(doubleValue);
        if (calculateBarL0L1 == null) {
            return;
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(calculateBarL0L1[0], double1, rangeAxisEdge);
        final double valueToJava2D2 = valueAxis.valueToJava2D(calculateBarL0L1[1], double1, rangeAxisEdge);
        final double min = Math.min(valueToJava2D, valueToJava2D2);
        final double abs = Math.abs(valueToJava2D2 - valueToJava2D);
        Rectangle2D.Double double2;
        if (orientation == PlotOrientation.HORIZONTAL) {
            double2 = new Rectangle2D.Double(min, calculateBarW0, abs, categoryItemRendererState.getBarWidth());
        }
        else {
            double2 = new Rectangle2D.Double(calculateBarW0, min, categoryItemRendererState.getBarWidth(), abs);
        }
        final Paint itemPaint = this.getItemPaint(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.fill(double2);
        final double minX = double2.getMinX();
        final double n4 = minX + this.getXOffset();
        final double maxX = double2.getMaxX();
        final double n5 = maxX + this.getXOffset();
        final double n6 = double2.getMinY() - this.getYOffset();
        final double minY = double2.getMinY();
        final double n7 = double2.getMaxY() - this.getYOffset();
        final double maxY = double2.getMaxY();
        Path2D.Float float1 = null;
        if (abs > 0.0) {
            float1 = new GeneralPath();
            float1.moveTo((float)maxX, (float)maxY);
            float1.lineTo((float)maxX, (float)minY);
            float1.lineTo((float)n5, (float)n6);
            float1.lineTo((float)n5, (float)n7);
            float1.closePath();
            if (itemPaint instanceof Color) {
                graphics2D.setPaint(((Color)itemPaint).darker());
            }
            graphics2D.fill(float1);
        }
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)minX, (float)minY);
        generalPath.lineTo((float)n4, (float)n6);
        generalPath.lineTo((float)n5, (float)n6);
        generalPath.lineTo((float)maxX, (float)minY);
        generalPath.closePath();
        graphics2D.fill(generalPath);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(double2);
            if (float1 != null) {
                graphics2D.draw(float1);
            }
            if (generalPath != null) {
                graphics2D.draw(generalPath);
            }
        }
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double2, doubleValue < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            final GeneralPath generalPath2 = new GeneralPath();
            generalPath2.moveTo((float)minX, (float)maxY);
            generalPath2.lineTo((float)minX, (float)minY);
            generalPath2.lineTo((float)n4, (float)n6);
            generalPath2.lineTo((float)n5, (float)n6);
            generalPath2.lineTo((float)n5, (float)n7);
            generalPath2.lineTo((float)maxX, (float)maxY);
            generalPath2.closePath();
            this.addItemEntity(entityCollection, categoryDataset, n, n2, generalPath2);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BarRenderer3D)) {
            return false;
        }
        final BarRenderer3D barRenderer3D = (BarRenderer3D)o;
        return this.xOffset == barRenderer3D.xOffset && this.yOffset == barRenderer3D.yOffset && PaintUtilities.equal(this.wallPaint, barRenderer3D.wallPaint) && super.equals(o);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.wallPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.wallPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_WALL_PAINT = new Color(221, 221, 221);
    }
}
