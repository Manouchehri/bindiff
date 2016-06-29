package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import java.awt.geom.*;
import org.jfree.data.*;
import org.jfree.data.xy.*;
import org.jfree.data.general.*;
import org.jfree.chart.axis.*;
import java.util.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class StackedXYAreaRenderer extends XYAreaRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 5217394318178570889L;
    private transient Paint shapePaint;
    private transient Stroke shapeStroke;
    
    public StackedXYAreaRenderer() {
        this(4);
    }
    
    public StackedXYAreaRenderer(final int n) {
        this(n, null, null);
    }
    
    public StackedXYAreaRenderer(final int n, final XYToolTipGenerator xyToolTipGenerator, final XYURLGenerator xyurlGenerator) {
        super(n, xyToolTipGenerator, xyurlGenerator);
        this.shapePaint = null;
        this.shapeStroke = null;
    }
    
    public Paint getShapePaint() {
        return this.shapePaint;
    }
    
    public void setShapePaint(final Paint shapePaint) {
        this.shapePaint = shapePaint;
        this.fireChangeEvent();
    }
    
    public Stroke getShapeStroke() {
        return this.shapeStroke;
    }
    
    public void setShapeStroke(final Stroke shapeStroke) {
        this.shapeStroke = shapeStroke;
        this.fireChangeEvent();
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        return new StackedXYAreaRenderer$StackedXYAreaRendererState(plotRenderingInfo);
    }
    
    public int getPassCount() {
        return 2;
    }
    
    public Range findRangeBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            return DatasetUtilities.findStackedRangeBounds((TableXYDataset)xyDataset);
        }
        return null;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final StackedXYAreaRenderer$StackedXYAreaRendererState stackedXYAreaRenderer$StackedXYAreaRendererState = (StackedXYAreaRenderer$StackedXYAreaRendererState)xyItemRendererState;
        final TableXYDataset tableXYDataset = (TableXYDataset)xyDataset;
        final int itemCount = tableXYDataset.getItemCount();
        final double xValue = xyDataset.getXValue(n, n2);
        double yValue = xyDataset.getYValue(n, n2);
        boolean b = false;
        if (Double.isNaN(yValue)) {
            yValue = 0.0;
            b = true;
        }
        final double previousHeight = this.getPreviousHeight(tableXYDataset, n, n2);
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue + previousHeight, rectangle2D, xyPlot.getRangeAxisEdge());
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        if (n3 == 0) {
            if (n2 == 0) {
                stackedXYAreaRenderer$StackedXYAreaRendererState.setSeriesArea(new Polygon());
                stackedXYAreaRenderer$StackedXYAreaRendererState.setLastSeriesPoints(stackedXYAreaRenderer$StackedXYAreaRendererState.getCurrentSeriesPoints());
                stackedXYAreaRenderer$StackedXYAreaRendererState.setCurrentSeriesPoints(new Stack());
                final double valueToJava2D3 = valueAxis2.valueToJava2D(previousHeight, rectangle2D, xyPlot.getRangeAxisEdge());
                if (orientation == PlotOrientation.VERTICAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)valueToJava2D, (int)valueToJava2D3);
                }
                else if (orientation == PlotOrientation.HORIZONTAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)valueToJava2D3, (int)valueToJava2D);
                }
            }
            if (orientation == PlotOrientation.VERTICAL) {
                final Point point = new Point((int)valueToJava2D, (int)valueToJava2D2);
                stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)point.getX(), (int)point.getY());
                stackedXYAreaRenderer$StackedXYAreaRendererState.getCurrentSeriesPoints().push(point);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)valueToJava2D2, (int)valueToJava2D);
            }
            if (this.getPlotLines() && n2 > 0) {
                final double xValue2 = xyDataset.getXValue(n, n2 - 1);
                final double yValue2 = xyDataset.getYValue(n, n2 - 1);
                final double previousHeight2 = this.getPreviousHeight(tableXYDataset, n, n2 - 1);
                final double valueToJava2D4 = valueAxis.valueToJava2D(xValue2, rectangle2D, xyPlot.getDomainAxisEdge());
                final double valueToJava2D5 = valueAxis2.valueToJava2D(yValue2 + previousHeight2, rectangle2D, xyPlot.getRangeAxisEdge());
                if (orientation == PlotOrientation.VERTICAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getLine().setLine(valueToJava2D4, valueToJava2D5, valueToJava2D, valueToJava2D2);
                }
                else if (orientation == PlotOrientation.HORIZONTAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getLine().setLine(valueToJava2D5, valueToJava2D4, valueToJava2D2, valueToJava2D);
                }
                graphics2D.draw(stackedXYAreaRenderer$StackedXYAreaRendererState.getLine());
            }
            if (this.getPlotArea() && n2 > 0 && n2 == itemCount - 1) {
                final double valueToJava2D6 = valueAxis2.valueToJava2D(previousHeight, rectangle2D, xyPlot.getRangeAxisEdge());
                if (orientation == PlotOrientation.VERTICAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)valueToJava2D, (int)valueToJava2D6);
                }
                else if (orientation == PlotOrientation.HORIZONTAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)valueToJava2D6, (int)valueToJava2D);
                }
                if (n != 0) {
                    final Stack lastSeriesPoints = stackedXYAreaRenderer$StackedXYAreaRendererState.getLastSeriesPoints();
                    while (!lastSeriesPoints.empty()) {
                        final Point point2 = lastSeriesPoints.pop();
                        stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)point2.getX(), (int)point2.getY());
                    }
                }
                graphics2D.setPaint(itemPaint);
                graphics2D.setStroke(itemStroke);
                graphics2D.fill(stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea());
                if (this.isOutline()) {
                    graphics2D.setStroke(this.getSeriesOutlineStroke(n));
                    graphics2D.setPaint(this.getSeriesOutlinePaint(n));
                    graphics2D.draw(stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea());
                }
            }
            this.updateCrosshairValues(crosshairState, xValue, previousHeight + yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, valueToJava2D2, orientation);
        }
        else if (n3 == 1) {
            Shape shape = null;
            if (this.getPlotShapes()) {
                shape = this.getItemShape(n, n2);
                if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
                    shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D, valueToJava2D2);
                }
                else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                    shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D2, valueToJava2D);
                }
                if (!b) {
                    if (this.getShapePaint() != null) {
                        graphics2D.setPaint(this.getShapePaint());
                    }
                    else {
                        graphics2D.setPaint(itemPaint);
                    }
                    if (this.getShapeStroke() != null) {
                        graphics2D.setStroke(this.getShapeStroke());
                    }
                    else {
                        graphics2D.setStroke(itemStroke);
                    }
                    graphics2D.draw(shape);
                }
            }
            else if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
                shape = new Rectangle2D.Double(valueToJava2D - 3.0, valueToJava2D2 - 3.0, 6.0, 6.0);
            }
            else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                shape = new Rectangle2D.Double(valueToJava2D2 - 3.0, valueToJava2D - 3.0, 6.0, 6.0);
            }
            if (xyItemRendererState.getInfo() != null) {
                final EntityCollection entityCollection = xyItemRendererState.getEntityCollection();
                if (entityCollection != null && shape != null && !b) {
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
                }
            }
        }
    }
    
    protected double getPreviousHeight(final TableXYDataset tableXYDataset, final int n, final int n2) {
        double n3 = 0.0;
        for (int i = 0; i < n; ++i) {
            final double yValue = tableXYDataset.getYValue(i, n2);
            if (!Double.isNaN(yValue)) {
                n3 += yValue;
            }
        }
        return n3;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StackedXYAreaRenderer) || !super.equals(o)) {
            return false;
        }
        final StackedXYAreaRenderer stackedXYAreaRenderer = (StackedXYAreaRenderer)o;
        return PaintUtilities.equal(this.shapePaint, stackedXYAreaRenderer.shapePaint) && ObjectUtilities.equal(this.shapeStroke, stackedXYAreaRenderer.shapeStroke);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.shapePaint = SerialUtilities.readPaint(objectInputStream);
        this.shapeStroke = SerialUtilities.readStroke(objectInputStream);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.shapePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.shapeStroke, objectOutputStream);
    }
}
