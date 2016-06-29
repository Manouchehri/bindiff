package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.data.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.util.*;
import java.awt.*;
import org.jfree.chart.entity.*;

public class XYStepAreaRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -7311560779702649635L;
    public static final int SHAPES = 1;
    public static final int AREA = 2;
    public static final int AREA_AND_SHAPES = 3;
    private boolean shapesVisible;
    private boolean shapesFilled;
    private boolean plotArea;
    private boolean showOutline;
    protected transient Polygon pArea;
    private double rangeBase;
    
    public XYStepAreaRenderer() {
        this(2);
    }
    
    public XYStepAreaRenderer(final int n) {
        this(n, null, null);
    }
    
    public XYStepAreaRenderer(final int n, final XYToolTipGenerator baseToolTipGenerator, final XYURLGenerator urlGenerator) {
        this.pArea = null;
        this.setBaseToolTipGenerator(baseToolTipGenerator);
        this.setURLGenerator(urlGenerator);
        if (n == 2) {
            this.plotArea = true;
        }
        else if (n == 1) {
            this.shapesVisible = true;
        }
        else if (n == 3) {
            this.plotArea = true;
            this.shapesVisible = true;
        }
        this.showOutline = false;
    }
    
    public boolean isOutline() {
        return this.showOutline;
    }
    
    public void setOutline(final boolean showOutline) {
        this.showOutline = showOutline;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getShapesVisible() {
        return this.shapesVisible;
    }
    
    public void setShapesVisible(final boolean shapesVisible) {
        this.shapesVisible = shapesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean isShapesFilled() {
        return this.shapesFilled;
    }
    
    public void setShapesFilled(final boolean shapesFilled) {
        this.shapesFilled = shapesFilled;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getPlotArea() {
        return this.plotArea;
    }
    
    public void setPlotArea(final boolean plotArea) {
        this.plotArea = plotArea;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getRangeBase() {
        return this.rangeBase;
    }
    
    public void setRangeBase(final double rangeBase) {
        this.rangeBase = rangeBase;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        return super.initialise(graphics2D, rectangle2D, xyPlot, xyDataset, plotRenderingInfo);
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final int itemCount = xyDataset.getItemCount(n);
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        final double xValue = xyDataset.getXValue(n, n2);
        final double yValue = xyDataset.getYValue(n, n2);
        final double n4 = xValue;
        final double n5 = Double.isNaN(yValue) ? this.getRangeBase() : yValue;
        double valueToJava2D = valueAxis.valueToJava2D(n4, rectangle2D, xyPlot.getDomainAxisEdge());
        final double restrictValueToDataArea = restrictValueToDataArea(valueAxis2.valueToJava2D(n5, rectangle2D, xyPlot.getRangeAxisEdge()), xyPlot, rectangle2D);
        if (this.pArea == null && !Double.isNaN(yValue)) {
            this.pArea = new Polygon();
            final double restrictValueToDataArea2 = restrictValueToDataArea(valueAxis2.valueToJava2D(this.getRangeBase(), rectangle2D, xyPlot.getRangeAxisEdge()), xyPlot, rectangle2D);
            if (orientation == PlotOrientation.VERTICAL) {
                this.pArea.addPoint((int)valueToJava2D, (int)restrictValueToDataArea2);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                this.pArea.addPoint((int)restrictValueToDataArea2, (int)valueToJava2D);
            }
        }
        restrictValueToDataArea(this.getRangeBase(), xyPlot, rectangle2D);
        if (n2 > 0) {
            final double xValue2 = xyDataset.getXValue(n, n2 - 1);
            final double n6 = Double.isNaN(yValue) ? yValue : xyDataset.getYValue(n, n2 - 1);
            final double n7 = xValue2;
            final double n8 = Double.isNaN(n6) ? this.getRangeBase() : n6;
            final double valueToJava2D2 = valueAxis.valueToJava2D(n7, rectangle2D, xyPlot.getDomainAxisEdge());
            double restrictValueToDataArea3 = restrictValueToDataArea(valueAxis2.valueToJava2D(n8, rectangle2D, xyPlot.getRangeAxisEdge()), xyPlot, rectangle2D);
            if (Double.isNaN(yValue)) {
                valueToJava2D = valueToJava2D2;
                restrictValueToDataArea3 = restrictValueToDataArea;
            }
            if (restrictValueToDataArea3 != restrictValueToDataArea) {
                if (orientation == PlotOrientation.VERTICAL) {
                    this.pArea.addPoint((int)valueToJava2D, (int)restrictValueToDataArea3);
                }
                else if (orientation == PlotOrientation.HORIZONTAL) {
                    this.pArea.addPoint((int)restrictValueToDataArea3, (int)valueToJava2D);
                }
            }
        }
        Shape shape = null;
        if (!Double.isNaN(yValue)) {
            if (orientation == PlotOrientation.VERTICAL) {
                this.pArea.addPoint((int)valueToJava2D, (int)restrictValueToDataArea);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                this.pArea.addPoint((int)restrictValueToDataArea, (int)valueToJava2D);
            }
            if (this.getShapesVisible()) {
                shape = this.getItemShape(n, n2);
                if (orientation == PlotOrientation.VERTICAL) {
                    shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D, restrictValueToDataArea);
                }
                else if (orientation == PlotOrientation.HORIZONTAL) {
                    shape = ShapeUtilities.createTranslatedShape(shape, restrictValueToDataArea, valueToJava2D);
                }
                if (this.isShapesFilled()) {
                    graphics2D.fill(shape);
                }
                else {
                    graphics2D.draw(shape);
                }
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape = new Rectangle2D.Double(valueToJava2D - 2.0, restrictValueToDataArea - 2.0, 4.0, 4.0);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                shape = new Rectangle2D.Double(restrictValueToDataArea - 2.0, valueToJava2D - 2.0, 4.0, 4.0);
            }
        }
        if (this.getPlotArea() && n2 > 0 && this.pArea != null && (n2 == itemCount - 1 || Double.isNaN(yValue))) {
            final double restrictValueToDataArea4 = restrictValueToDataArea(valueAxis2.valueToJava2D(this.getRangeBase(), rectangle2D, xyPlot.getRangeAxisEdge()), xyPlot, rectangle2D);
            if (orientation == PlotOrientation.VERTICAL) {
                this.pArea.addPoint((int)valueToJava2D, (int)restrictValueToDataArea4);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                this.pArea.addPoint((int)restrictValueToDataArea4, (int)valueToJava2D);
            }
            graphics2D.fill(this.pArea);
            if (this.isOutline()) {
                graphics2D.setStroke(xyPlot.getOutlineStroke());
                graphics2D.setPaint(xyPlot.getOutlinePaint());
                graphics2D.draw(this.pArea);
            }
            this.pArea = null;
        }
        if (!Double.isNaN(yValue)) {
            this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, restrictValueToDataArea, orientation);
        }
        if (xyItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = xyItemRendererState.getEntityCollection();
            if (entityCollection != null && shape != null) {
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
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYStepAreaRenderer)) {
            return false;
        }
        final XYStepAreaRenderer xyStepAreaRenderer = (XYStepAreaRenderer)o;
        return this.showOutline == xyStepAreaRenderer.showOutline && this.shapesVisible == xyStepAreaRenderer.shapesVisible && this.shapesFilled == xyStepAreaRenderer.shapesFilled && this.plotArea == xyStepAreaRenderer.plotArea && this.rangeBase == xyStepAreaRenderer.rangeBase && super.equals(o);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    protected static double restrictValueToDataArea(double n, final XYPlot xyPlot, final Rectangle2D rectangle2D) {
        double n2 = 0.0;
        double n3 = 0.0;
        if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
            n2 = rectangle2D.getMinY();
            n3 = rectangle2D.getMaxY();
        }
        else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            n2 = rectangle2D.getMinX();
            n3 = rectangle2D.getMaxX();
        }
        if (n < n2) {
            n = n2;
        }
        else if (n > n3) {
            n = n3;
        }
        return n;
    }
}
