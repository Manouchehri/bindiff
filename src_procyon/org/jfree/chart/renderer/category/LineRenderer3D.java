package org.jfree.chart.renderer.category;

import org.jfree.chart.*;
import org.jfree.chart.event.*;
import java.awt.image.*;
import java.awt.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class LineRenderer3D extends LineAndShapeRenderer implements Serializable, Effect3D
{
    private static final long serialVersionUID = 5467931468380928736L;
    public static final double DEFAULT_X_OFFSET = 12.0;
    public static final double DEFAULT_Y_OFFSET = 8.0;
    public static final Paint DEFAULT_WALL_PAINT;
    private double xOffset;
    private double yOffset;
    private transient Paint wallPaint;
    
    public LineRenderer3D() {
        super(true, false);
        this.xOffset = 12.0;
        this.yOffset = 8.0;
        this.wallPaint = LineRenderer3D.DEFAULT_WALL_PAINT;
    }
    
    public double getXOffset() {
        return this.xOffset;
    }
    
    public double getYOffset() {
        return this.yOffset;
    }
    
    public void setXOffset(final double xOffset) {
        this.xOffset = xOffset;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setYOffset(final double yOffset) {
        this.yOffset = yOffset;
        this.notifyListeners(new RendererChangeEvent(this));
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
        graphics2D.setPaint(categoryPlot.getDomainGridlinePaint());
        graphics2D.setStroke(categoryPlot.getDomainGridlineStroke());
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
        graphics2D.setPaint(categoryPlot.getRangeGridlinePaint());
        graphics2D.setStroke(categoryPlot.getRangeGridlineStroke());
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
        }
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double categoryMiddle = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), double1, categoryPlot.getDomainAxisEdge());
        final double doubleValue = value.doubleValue();
        final double valueToJava2D = valueAxis.valueToJava2D(doubleValue, double1, categoryPlot.getRangeAxisEdge());
        Shape shape = this.getItemShape(n, n2);
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D, categoryMiddle);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, categoryMiddle, valueToJava2D);
        }
        if (this.getItemLineVisible(n, n2) && n2 != 0) {
            final Number value2 = categoryDataset.getValue(n, n2 - 1);
            if (value2 != null) {
                final double doubleValue2 = value2.doubleValue();
                final double categoryMiddle2 = categoryAxis.getCategoryMiddle(n2 - 1, this.getColumnCount(), double1, categoryPlot.getDomainAxisEdge());
                final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue2, double1, categoryPlot.getRangeAxisEdge());
                final double n4 = categoryMiddle2 + this.getXOffset();
                final double n5 = valueToJava2D2 - this.getYOffset();
                final double n6 = categoryMiddle + this.getXOffset();
                final double n7 = valueToJava2D - this.getYOffset();
                final GeneralPath generalPath = new GeneralPath();
                if (orientation == PlotOrientation.HORIZONTAL) {
                    generalPath.moveTo((float)valueToJava2D2, (float)categoryMiddle2);
                    generalPath.lineTo((float)valueToJava2D, (float)categoryMiddle);
                    generalPath.lineTo((float)n7, (float)n6);
                    generalPath.lineTo((float)n5, (float)n4);
                    generalPath.lineTo((float)valueToJava2D2, (float)categoryMiddle2);
                    generalPath.closePath();
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    generalPath.moveTo((float)categoryMiddle2, (float)valueToJava2D2);
                    generalPath.lineTo((float)categoryMiddle, (float)valueToJava2D);
                    generalPath.lineTo((float)n6, (float)n7);
                    generalPath.lineTo((float)n4, (float)n5);
                    generalPath.lineTo((float)categoryMiddle2, (float)valueToJava2D2);
                    generalPath.closePath();
                }
                graphics2D.setPaint(this.getItemPaint(n, n2));
                graphics2D.fill(generalPath);
                graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
                graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                graphics2D.draw(generalPath);
            }
        }
        if (this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, categoryMiddle, valueToJava2D, doubleValue < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            this.addItemEntity(entityCollection, categoryDataset, n, n2, shape);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LineRenderer3D)) {
            return false;
        }
        final LineRenderer3D lineRenderer3D = (LineRenderer3D)o;
        return this.xOffset == lineRenderer3D.xOffset && this.yOffset == lineRenderer3D.yOffset && PaintUtilities.equal(this.wallPaint, lineRenderer3D.wallPaint) && super.equals(o);
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
