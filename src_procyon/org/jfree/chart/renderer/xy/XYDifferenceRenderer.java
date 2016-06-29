package org.jfree.chart.renderer.xy;

import org.jfree.chart.event.*;
import org.jfree.data.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import java.awt.geom.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYDifferenceRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -8447915602375584857L;
    private transient Paint positivePaint;
    private transient Paint negativePaint;
    private boolean shapesVisible;
    private transient Shape legendLine;
    private boolean roundXCoordinates;
    
    public XYDifferenceRenderer() {
        this(Color.green, Color.red, false);
    }
    
    public XYDifferenceRenderer(final Paint positivePaint, final Paint negativePaint, final boolean shapesVisible) {
        if (positivePaint == null) {
            throw new IllegalArgumentException("Null 'positivePaint' argument.");
        }
        if (negativePaint == null) {
            throw new IllegalArgumentException("Null 'negativePaint' argument.");
        }
        this.positivePaint = positivePaint;
        this.negativePaint = negativePaint;
        this.shapesVisible = shapesVisible;
        this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        this.roundXCoordinates = false;
    }
    
    public Paint getPositivePaint() {
        return this.positivePaint;
    }
    
    public void setPositivePaint(final Paint positivePaint) {
        if (positivePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.positivePaint = positivePaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getNegativePaint() {
        return this.negativePaint;
    }
    
    public void setNegativePaint(final Paint negativePaint) {
        if (negativePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.negativePaint = negativePaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getShapesVisible() {
        return this.shapesVisible;
    }
    
    public void setShapesVisible(final boolean shapesVisible) {
        this.shapesVisible = shapesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Shape getLegendLine() {
        return this.legendLine;
    }
    
    public void setLegendLine(final Shape legendLine) {
        if (legendLine == null) {
            throw new IllegalArgumentException("Null 'line' argument.");
        }
        this.legendLine = legendLine;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getRoundXCoordinates() {
        return this.roundXCoordinates;
    }
    
    public void setRoundXCoordinates(final boolean roundXCoordinates) {
        this.roundXCoordinates = roundXCoordinates;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        return super.initialise(graphics2D, rectangle2D, xyPlot, xyDataset, plotRenderingInfo);
    }
    
    public int getPassCount() {
        return 2;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (n3 == 0) {
            this.drawItemPass0(graphics2D, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState);
        }
        else if (n3 == 1) {
            this.drawItemPass1(graphics2D, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState);
        }
    }
    
    protected void drawItemPass0(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState) {
        if (n == 0) {
            final PlotOrientation orientation = xyPlot.getOrientation();
            final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
            final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
            final double yValue = xyDataset.getYValue(0, n2);
            final double xValue = xyDataset.getXValue(1, n2);
            final double yValue2 = xyDataset.getYValue(1, n2);
            final double valueToJava2D = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
            double n3 = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
            if (this.roundXCoordinates) {
                n3 = Math.rint(n3);
            }
            final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue2, rectangle2D, rangeAxisEdge);
            if (n2 > 0) {
                final double xValue2 = xyDataset.getXValue(0, n2 - 1);
                final double yValue3 = xyDataset.getYValue(0, n2 - 1);
                final double yValue4 = xyDataset.getYValue(1, n2 - 1);
                double n4 = valueAxis.valueToJava2D(xValue2, rectangle2D, domainAxisEdge);
                if (this.roundXCoordinates) {
                    n4 = Math.rint(n4);
                }
                final double valueToJava2D3 = valueAxis2.valueToJava2D(yValue3, rectangle2D, rangeAxisEdge);
                final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue4, rectangle2D, rangeAxisEdge);
                final Shape positiveArea = this.getPositiveArea((float)n4, (float)valueToJava2D3, (float)valueToJava2D4, (float)n3, (float)valueToJava2D, (float)valueToJava2D2, orientation);
                if (positiveArea != null) {
                    graphics2D.setPaint(this.getPositivePaint());
                    graphics2D.fill(positiveArea);
                }
                final Shape negativeArea = this.getNegativeArea((float)n4, (float)valueToJava2D3, (float)valueToJava2D4, (float)n3, (float)valueToJava2D, (float)valueToJava2D2, orientation);
                if (negativeArea != null) {
                    graphics2D.setPaint(this.getNegativePaint());
                    graphics2D.fill(negativeArea);
                }
            }
        }
    }
    
    protected void drawItemPass1(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState) {
        Shape shape = null;
        Shape shape2 = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        if (n == 0) {
            final PlotOrientation orientation = xyPlot.getOrientation();
            final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
            final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
            final double xValue = xyDataset.getXValue(0, n2);
            final double yValue = xyDataset.getYValue(0, n2);
            final double xValue2 = xyDataset.getXValue(1, n2);
            final double yValue2 = xyDataset.getYValue(1, n2);
            final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
            final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
            final double valueToJava2D3 = valueAxis.valueToJava2D(xValue2, rectangle2D, domainAxisEdge);
            final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue2, rectangle2D, rangeAxisEdge);
            if (n2 > 0) {
                final double xValue3 = xyDataset.getXValue(0, n2 - 1);
                final double yValue3 = xyDataset.getYValue(0, n2 - 1);
                final double xValue4 = xyDataset.getXValue(1, n2 - 1);
                final double yValue4 = xyDataset.getYValue(1, n2 - 1);
                final double valueToJava2D5 = valueAxis.valueToJava2D(xValue3, rectangle2D, domainAxisEdge);
                final double valueToJava2D6 = valueAxis2.valueToJava2D(yValue3, rectangle2D, rangeAxisEdge);
                final double valueToJava2D7 = valueAxis.valueToJava2D(xValue4, rectangle2D, domainAxisEdge);
                final double valueToJava2D8 = valueAxis2.valueToJava2D(yValue4, rectangle2D, rangeAxisEdge);
                Line2D line2D = null;
                Line2D line2D2 = null;
                if (orientation == PlotOrientation.HORIZONTAL) {
                    line2D = new Line2D.Double(valueToJava2D2, valueToJava2D, valueToJava2D6, valueToJava2D5);
                    line2D2 = new Line2D.Double(valueToJava2D4, valueToJava2D3, valueToJava2D8, valueToJava2D7);
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    line2D = new Line2D.Double(valueToJava2D, valueToJava2D2, valueToJava2D5, valueToJava2D6);
                    line2D2 = new Line2D.Double(valueToJava2D3, valueToJava2D4, valueToJava2D7, valueToJava2D8);
                }
                if (line2D != null && line2D.intersects(rectangle2D)) {
                    graphics2D.setPaint(this.getItemPaint(n, n2));
                    graphics2D.setStroke(this.getItemStroke(n, n2));
                    graphics2D.draw(line2D);
                }
                if (line2D2 != null && line2D2.intersects(rectangle2D)) {
                    graphics2D.setPaint(this.getItemPaint(1, n2));
                    graphics2D.setStroke(this.getItemStroke(1, n2));
                    graphics2D.draw(line2D2);
                }
            }
            if (this.getShapesVisible()) {
                final Shape itemShape = this.getItemShape(n, n2);
                Shape shape3;
                if (orientation == PlotOrientation.HORIZONTAL) {
                    shape3 = ShapeUtilities.createTranslatedShape(itemShape, valueToJava2D2, valueToJava2D);
                }
                else {
                    shape3 = ShapeUtilities.createTranslatedShape(itemShape, valueToJava2D, valueToJava2D2);
                }
                if (shape3.intersects(rectangle2D)) {
                    graphics2D.setPaint(this.getItemPaint(n, n2));
                    graphics2D.fill(shape3);
                }
                shape = shape3;
                final Shape itemShape2 = this.getItemShape(n + 1, n2);
                Shape shape4;
                if (orientation == PlotOrientation.HORIZONTAL) {
                    shape4 = ShapeUtilities.createTranslatedShape(itemShape2, valueToJava2D4, valueToJava2D3);
                }
                else {
                    shape4 = ShapeUtilities.createTranslatedShape(itemShape2, valueToJava2D3, valueToJava2D4);
                }
                if (shape4.intersects(rectangle2D)) {
                    graphics2D.setPaint(this.getItemPaint(n + 1, n2));
                    graphics2D.fill(shape4);
                }
                shape2 = shape4;
            }
            if (entityCollection != null) {
                if (shape == null) {
                    shape = new Rectangle2D.Double(valueToJava2D - 2.0, valueToJava2D2 - 2.0, 4.0, 4.0);
                }
                String generateToolTip = null;
                final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
                }
                String generateURL = null;
                if (this.getURLGenerator() != null) {
                    generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
                }
                entityCollection.add(new XYItemEntity(shape, xyDataset, n, n2, generateToolTip, generateURL));
                if (shape2 == null) {
                    shape2 = new Rectangle2D.Double(valueToJava2D3 - 2.0, valueToJava2D4 - 2.0, 4.0, 4.0);
                }
                String generateToolTip2 = null;
                final XYToolTipGenerator toolTipGenerator2 = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator2 != null) {
                    generateToolTip2 = toolTipGenerator2.generateToolTip(xyDataset, n + 1, n2);
                }
                String generateURL2 = null;
                if (this.getURLGenerator() != null) {
                    generateURL2 = this.getURLGenerator().generateURL(xyDataset, n + 1, n2);
                }
                entityCollection.add(new XYItemEntity(shape2, xyDataset, n + 1, n2, generateToolTip2, generateURL2));
            }
            final int domainAxisIndex = xyPlot.getDomainAxisIndex(valueAxis);
            final int rangeAxisIndex = xyPlot.getRangeAxisIndex(valueAxis2);
            this.updateCrosshairValues(crosshairState, xValue2, yValue2, domainAxisIndex, rangeAxisIndex, valueToJava2D3, valueToJava2D4, orientation);
            this.updateCrosshairValues(crosshairState, xValue, yValue, domainAxisIndex, rangeAxisIndex, valueToJava2D, valueToJava2D2, orientation);
        }
    }
    
    protected Shape getPositiveArea(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final PlotOrientation plotOrientation) {
        boolean b = n2 >= n3;
        boolean b2 = n5 >= n6;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            b = (n3 >= n2);
            b2 = (n6 >= n5);
        }
        Shape shape;
        if (b) {
            if (b2) {
                shape = null;
            }
            else {
                final float[] intersection = this.getIntersection(n, n2, n4, n5, n, n3, n4, n6);
                final GeneralPath generalPath = new GeneralPath();
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    generalPath.moveTo(n5, n4);
                    generalPath.lineTo(intersection[1], intersection[0]);
                    generalPath.lineTo(n6, n4);
                    generalPath.closePath();
                }
                else if (plotOrientation == PlotOrientation.VERTICAL) {
                    generalPath.moveTo(n4, n5);
                    generalPath.lineTo(intersection[0], intersection[1]);
                    generalPath.lineTo(n4, n6);
                    generalPath.closePath();
                }
                shape = generalPath;
            }
        }
        else if (b2) {
            final float[] intersection2 = this.getIntersection(n, n2, n4, n5, n, n3, n4, n6);
            final GeneralPath generalPath2 = new GeneralPath();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                generalPath2.moveTo(n2, n);
                generalPath2.lineTo(intersection2[1], intersection2[0]);
                generalPath2.lineTo(n3, n);
                generalPath2.closePath();
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                generalPath2.moveTo(n, n2);
                generalPath2.lineTo(intersection2[0], intersection2[1]);
                generalPath2.lineTo(n, n3);
                generalPath2.closePath();
            }
            shape = generalPath2;
        }
        else {
            final GeneralPath generalPath3 = new GeneralPath();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                generalPath3.moveTo(n2, n);
                generalPath3.lineTo(n5, n4);
                generalPath3.lineTo(n6, n4);
                generalPath3.lineTo(n3, n);
                generalPath3.closePath();
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                generalPath3.moveTo(n, n2);
                generalPath3.lineTo(n4, n5);
                generalPath3.lineTo(n4, n6);
                generalPath3.lineTo(n, n3);
                generalPath3.closePath();
            }
            shape = generalPath3;
        }
        return shape;
    }
    
    protected Shape getNegativeArea(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final PlotOrientation plotOrientation) {
        Shape shape = null;
        boolean b = n2 >= n3;
        boolean b2 = n5 >= n6;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            b = (n3 >= n2);
            b2 = (n6 >= n5);
        }
        if (b) {
            if (b2) {
                final GeneralPath generalPath = new GeneralPath();
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    generalPath.moveTo(n2, n);
                    generalPath.lineTo(n5, n4);
                    generalPath.lineTo(n6, n4);
                    generalPath.lineTo(n3, n);
                    generalPath.closePath();
                }
                else if (plotOrientation == PlotOrientation.VERTICAL) {
                    generalPath.moveTo(n, n2);
                    generalPath.lineTo(n4, n5);
                    generalPath.lineTo(n4, n6);
                    generalPath.lineTo(n, n3);
                    generalPath.closePath();
                }
                shape = generalPath;
            }
            else {
                final float[] intersection = this.getIntersection(n, n2, n4, n5, n, n3, n4, n6);
                final GeneralPath generalPath2 = new GeneralPath();
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    generalPath2.moveTo(n2, n);
                    generalPath2.lineTo(intersection[1], intersection[0]);
                    generalPath2.lineTo(n3, n);
                    generalPath2.closePath();
                }
                else if (plotOrientation == PlotOrientation.VERTICAL) {
                    generalPath2.moveTo(n, n2);
                    generalPath2.lineTo(intersection[0], intersection[1]);
                    generalPath2.lineTo(n, n3);
                    generalPath2.closePath();
                }
                shape = generalPath2;
            }
        }
        else if (b2) {
            final float[] intersection2 = this.getIntersection(n, n2, n4, n5, n, n3, n4, n6);
            final GeneralPath generalPath3 = new GeneralPath();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                generalPath3.moveTo(n5, n4);
                generalPath3.lineTo(intersection2[1], intersection2[0]);
                generalPath3.lineTo(n6, n4);
                generalPath3.closePath();
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                generalPath3.moveTo(n4, n5);
                generalPath3.lineTo(intersection2[0], intersection2[1]);
                generalPath3.lineTo(n4, n6);
                generalPath3.closePath();
            }
            shape = generalPath3;
        }
        return shape;
    }
    
    private float[] getIntersection(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        final float n9 = ((n7 - n5) * (n2 - n6) - (n8 - n6) * (n - n5)) / ((n8 - n6) * (n3 - n) - (n7 - n5) * (n4 - n2));
        return new float[] { n + n9 * (n3 - n), n2 + n9 * (n4 - n2) };
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        LegendItem legendItem = null;
        final XYPlot plot = this.getPlot();
        if (plot != null) {
            final XYDataset dataset = plot.getDataset(n);
            if (dataset != null && this.getItemVisible(n2, 0)) {
                final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, n2);
                String generateLabel2 = null;
                if (this.getLegendItemToolTipGenerator() != null) {
                    generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, n2);
                }
                String generateLabel3 = null;
                if (this.getLegendItemURLGenerator() != null) {
                    generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, n2);
                }
                legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, new Line2D.Double(-7.0, 0.0, 7.0, 0.0), this.getSeriesStroke(n2), this.getSeriesPaint(n2));
            }
        }
        return legendItem;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYDifferenceRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYDifferenceRenderer xyDifferenceRenderer = (XYDifferenceRenderer)o;
        return PaintUtilities.equal(this.positivePaint, xyDifferenceRenderer.positivePaint) && PaintUtilities.equal(this.negativePaint, xyDifferenceRenderer.negativePaint) && this.shapesVisible == xyDifferenceRenderer.shapesVisible && ShapeUtilities.equal(this.legendLine, xyDifferenceRenderer.legendLine) && this.roundXCoordinates == xyDifferenceRenderer.roundXCoordinates;
    }
    
    public Object clone() {
        final XYDifferenceRenderer xyDifferenceRenderer = (XYDifferenceRenderer)super.clone();
        xyDifferenceRenderer.legendLine = ShapeUtilities.clone(this.legendLine);
        return xyDifferenceRenderer;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.positivePaint, objectOutputStream);
        SerialUtilities.writePaint(this.negativePaint, objectOutputStream);
        SerialUtilities.writeShape(this.legendLine, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.positivePaint = SerialUtilities.readPaint(objectInputStream);
        this.negativePaint = SerialUtilities.readPaint(objectInputStream);
        this.legendLine = SerialUtilities.readShape(objectInputStream);
    }
}
