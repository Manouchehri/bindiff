package org.jfree.chart.renderer.xy;

import org.jfree.chart.event.*;
import java.awt.*;
import org.jfree.data.xy.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYLineAndShapeRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -7435246895986425885L;
    private Boolean linesVisible;
    private BooleanList seriesLinesVisible;
    private boolean baseLinesVisible;
    private transient Shape legendLine;
    private Boolean shapesVisible;
    private BooleanList seriesShapesVisible;
    private boolean baseShapesVisible;
    private Boolean shapesFilled;
    private BooleanList seriesShapesFilled;
    private boolean baseShapesFilled;
    private boolean drawOutlines;
    private boolean useFillPaint;
    private boolean useOutlinePaint;
    private boolean drawSeriesLineAsPath;
    
    public XYLineAndShapeRenderer() {
        this(true, true);
    }
    
    public XYLineAndShapeRenderer(final boolean baseLinesVisible, final boolean baseShapesVisible) {
        this.linesVisible = null;
        this.seriesLinesVisible = new BooleanList();
        this.baseLinesVisible = baseLinesVisible;
        this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        this.shapesVisible = null;
        this.seriesShapesVisible = new BooleanList();
        this.baseShapesVisible = baseShapesVisible;
        this.shapesFilled = null;
        this.useFillPaint = false;
        this.seriesShapesFilled = new BooleanList();
        this.baseShapesFilled = true;
        this.drawOutlines = true;
        this.useOutlinePaint = false;
        this.drawSeriesLineAsPath = false;
    }
    
    public boolean getDrawSeriesLineAsPath() {
        return this.drawSeriesLineAsPath;
    }
    
    public void setDrawSeriesLineAsPath(final boolean drawSeriesLineAsPath) {
        if (this.drawSeriesLineAsPath != drawSeriesLineAsPath) {
            this.drawSeriesLineAsPath = drawSeriesLineAsPath;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public int getPassCount() {
        return 2;
    }
    
    public boolean getItemLineVisible(final int n, final int n2) {
        Boolean b = this.linesVisible;
        if (b == null) {
            b = this.getSeriesLinesVisible(n);
        }
        if (b != null) {
            return b;
        }
        return this.baseLinesVisible;
    }
    
    public Boolean getLinesVisible() {
        return this.linesVisible;
    }
    
    public void setLinesVisible(final Boolean linesVisible) {
        this.linesVisible = linesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setLinesVisible(final boolean b) {
        this.setLinesVisible(BooleanUtilities.valueOf(b));
    }
    
    public Boolean getSeriesLinesVisible(final int n) {
        return this.seriesLinesVisible.getBoolean(n);
    }
    
    public void setSeriesLinesVisible(final int n, final Boolean b) {
        this.seriesLinesVisible.setBoolean(n, b);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setSeriesLinesVisible(final int n, final boolean b) {
        this.setSeriesLinesVisible(n, BooleanUtilities.valueOf(b));
    }
    
    public boolean getBaseLinesVisible() {
        return this.baseLinesVisible;
    }
    
    public void setBaseLinesVisible(final boolean baseLinesVisible) {
        this.baseLinesVisible = baseLinesVisible;
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
    
    public boolean getItemShapeVisible(final int n, final int n2) {
        Boolean b = this.shapesVisible;
        if (b == null) {
            b = this.getSeriesShapesVisible(n);
        }
        if (b != null) {
            return b;
        }
        return this.baseShapesVisible;
    }
    
    public Boolean getShapesVisible() {
        return this.shapesVisible;
    }
    
    public void setShapesVisible(final Boolean shapesVisible) {
        this.shapesVisible = shapesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setShapesVisible(final boolean b) {
        this.setShapesVisible(BooleanUtilities.valueOf(b));
    }
    
    public Boolean getSeriesShapesVisible(final int n) {
        return this.seriesShapesVisible.getBoolean(n);
    }
    
    public void setSeriesShapesVisible(final int n, final boolean b) {
        this.setSeriesShapesVisible(n, BooleanUtilities.valueOf(b));
    }
    
    public void setSeriesShapesVisible(final int n, final Boolean b) {
        this.seriesShapesVisible.setBoolean(n, b);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getBaseShapesVisible() {
        return this.baseShapesVisible;
    }
    
    public void setBaseShapesVisible(final boolean baseShapesVisible) {
        this.baseShapesVisible = baseShapesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getItemShapeFilled(final int n, final int n2) {
        Boolean b = this.shapesFilled;
        if (b == null) {
            b = this.getSeriesShapesFilled(n);
        }
        if (b != null) {
            return b;
        }
        return this.baseShapesFilled;
    }
    
    public void setShapesFilled(final boolean b) {
        this.setShapesFilled(BooleanUtilities.valueOf(b));
    }
    
    public void setShapesFilled(final Boolean shapesFilled) {
        this.shapesFilled = shapesFilled;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Boolean getSeriesShapesFilled(final int n) {
        return this.seriesShapesFilled.getBoolean(n);
    }
    
    public void setSeriesShapesFilled(final int n, final boolean b) {
        this.setSeriesShapesFilled(n, BooleanUtilities.valueOf(b));
    }
    
    public void setSeriesShapesFilled(final int n, final Boolean b) {
        this.seriesShapesFilled.setBoolean(n, b);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getBaseShapesFilled() {
        return this.baseShapesFilled;
    }
    
    public void setBaseShapesFilled(final boolean baseShapesFilled) {
        this.baseShapesFilled = baseShapesFilled;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getDrawOutlines() {
        return this.drawOutlines;
    }
    
    public void setDrawOutlines(final boolean drawOutlines) {
        this.drawOutlines = drawOutlines;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getUseFillPaint() {
        return this.useFillPaint;
    }
    
    public void setUseFillPaint(final boolean useFillPaint) {
        this.useFillPaint = useFillPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getUseOutlinePaint() {
        return this.useOutlinePaint;
    }
    
    public void setUseOutlinePaint(final boolean useOutlinePaint) {
        this.useOutlinePaint = useOutlinePaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        final XYLineAndShapeRenderer$State xyLineAndShapeRenderer$State = new XYLineAndShapeRenderer$State(plotRenderingInfo);
        xyLineAndShapeRenderer$State.seriesPath = new GeneralPath();
        return xyLineAndShapeRenderer$State;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        if (this.isLinePass(n3)) {
            if (n2 == 0 && this.drawSeriesLineAsPath) {
                final XYLineAndShapeRenderer$State xyLineAndShapeRenderer$State = (XYLineAndShapeRenderer$State)xyItemRendererState;
                xyLineAndShapeRenderer$State.seriesPath.reset();
                XYLineAndShapeRenderer$State.access$002(xyLineAndShapeRenderer$State, false);
            }
            if (this.getItemLineVisible(n, n2)) {
                if (this.drawSeriesLineAsPath) {
                    this.drawPrimaryLineAsPath(xyItemRendererState, graphics2D, xyPlot, xyDataset, n3, n, n2, valueAxis, valueAxis2, rectangle2D);
                }
                else {
                    this.drawPrimaryLine(xyItemRendererState, graphics2D, xyPlot, xyDataset, n3, n, n2, valueAxis, valueAxis2, rectangle2D);
                }
            }
        }
        else if (this.isItemPass(n3)) {
            EntityCollection entityCollection = null;
            if (plotRenderingInfo != null) {
                entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
            }
            this.drawSecondaryPass(graphics2D, xyPlot, xyDataset, n3, n, n2, valueAxis, rectangle2D, valueAxis2, crosshairState, entityCollection);
        }
    }
    
    protected boolean isLinePass(final int n) {
        return n == 0;
    }
    
    protected boolean isItemPass(final int n) {
        return n == 1;
    }
    
    protected void drawPrimaryLine(final XYItemRendererState xyItemRendererState, final Graphics2D graphics2D, final XYPlot xyPlot, final XYDataset xyDataset, final int n, final int n2, final int n3, final ValueAxis valueAxis, final ValueAxis valueAxis2, final Rectangle2D rectangle2D) {
        if (n3 == 0) {
            return;
        }
        final double xValue = xyDataset.getXValue(n2, n3);
        final double yValue = xyDataset.getYValue(n2, n3);
        if (Double.isNaN(yValue) || Double.isNaN(xValue)) {
            return;
        }
        final double xValue2 = xyDataset.getXValue(n2, n3 - 1);
        final double yValue2 = xyDataset.getYValue(n2, n3 - 1);
        if (Double.isNaN(yValue2) || Double.isNaN(xValue2)) {
            return;
        }
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(xValue2, rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue2, rectangle2D, rangeAxisEdge);
        final double valueToJava2D3 = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
        if (Double.isNaN(valueToJava2D) || Double.isNaN(valueToJava2D2) || Double.isNaN(valueToJava2D3) || Double.isNaN(valueToJava2D4)) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            xyItemRendererState.workingLine.setLine(valueToJava2D2, valueToJava2D, valueToJava2D4, valueToJava2D3);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            xyItemRendererState.workingLine.setLine(valueToJava2D, valueToJava2D2, valueToJava2D3, valueToJava2D4);
        }
        if (xyItemRendererState.workingLine.intersects(rectangle2D)) {
            this.drawFirstPassShape(graphics2D, n, n2, n3, xyItemRendererState.workingLine);
        }
    }
    
    protected void drawFirstPassShape(final Graphics2D graphics2D, final int n, final int n2, final int n3, final Shape shape) {
        graphics2D.setStroke(this.getItemStroke(n2, n3));
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        graphics2D.draw(shape);
    }
    
    protected void drawPrimaryLineAsPath(final XYItemRendererState xyItemRendererState, final Graphics2D graphics2D, final XYPlot xyPlot, final XYDataset xyDataset, final int n, final int n2, final int n3, final ValueAxis valueAxis, final ValueAxis valueAxis2, final Rectangle2D rectangle2D) {
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double xValue = xyDataset.getXValue(n2, n3);
        final double yValue = xyDataset.getYValue(n2, n3);
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
        final XYLineAndShapeRenderer$State xyLineAndShapeRenderer$State = (XYLineAndShapeRenderer$State)xyItemRendererState;
        if (!Double.isNaN(valueToJava2D) && !Double.isNaN(valueToJava2D2)) {
            float n4 = (float)valueToJava2D;
            float n5 = (float)valueToJava2D2;
            if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                n4 = (float)valueToJava2D2;
                n5 = (float)valueToJava2D;
            }
            if (xyLineAndShapeRenderer$State.isLastPointGood()) {
                xyLineAndShapeRenderer$State.seriesPath.lineTo(n4, n5);
            }
            else {
                xyLineAndShapeRenderer$State.seriesPath.moveTo(n4, n5);
            }
            xyLineAndShapeRenderer$State.setLastPointGood(true);
        }
        else {
            xyLineAndShapeRenderer$State.setLastPointGood(false);
        }
        if (n3 == xyDataset.getItemCount(n2) - 1) {
            this.drawFirstPassShape(graphics2D, n, n2, n3, xyLineAndShapeRenderer$State.seriesPath);
        }
    }
    
    protected void drawSecondaryPass(final Graphics2D graphics2D, final XYPlot xyPlot, final XYDataset xyDataset, final int n, final int n2, final int n3, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final ValueAxis valueAxis2, final CrosshairState crosshairState, final EntityCollection collection) {
        Shape shape = null;
        final double xValue = xyDataset.getXValue(n2, n3);
        final double yValue = xyDataset.getYValue(n2, n3);
        if (Double.isNaN(yValue) || Double.isNaN(xValue)) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
        if (this.getItemShapeVisible(n2, n3)) {
            Shape shape2 = this.getItemShape(n2, n3);
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, valueToJava2D2, valueToJava2D);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, valueToJava2D, valueToJava2D2);
            }
            shape = shape2;
            if (shape2.intersects(rectangle2D)) {
                if (this.getItemShapeFilled(n2, n3)) {
                    if (this.useFillPaint) {
                        graphics2D.setPaint(this.getItemFillPaint(n2, n3));
                    }
                    else {
                        graphics2D.setPaint(this.getItemPaint(n2, n3));
                    }
                    graphics2D.fill(shape2);
                }
                if (this.drawOutlines) {
                    if (this.getUseOutlinePaint()) {
                        graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                    }
                    else {
                        graphics2D.setPaint(this.getItemPaint(n2, n3));
                    }
                    graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
                    graphics2D.draw(shape2);
                }
            }
        }
        if (this.isItemLabelVisible(n2, n3)) {
            double n4 = valueToJava2D;
            double n5 = valueToJava2D2;
            if (orientation == PlotOrientation.HORIZONTAL) {
                n4 = valueToJava2D2;
                n5 = valueToJava2D;
            }
            this.drawItemLabel(graphics2D, orientation, xyDataset, n2, n3, n4, n5, yValue < 0.0);
        }
        this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, valueToJava2D2, xyPlot.getOrientation());
        if (collection != null) {
            this.addEntity(collection, shape, xyDataset, n2, n3, valueToJava2D, valueToJava2D2);
        }
    }
    
    public LegendItem getLegendItem(final int datasetIndex, final int seriesIndex) {
        final XYPlot plot = this.getPlot();
        if (plot == null) {
            return null;
        }
        LegendItem legendItem = null;
        final XYDataset dataset = plot.getDataset(datasetIndex);
        if (dataset != null && this.getItemVisible(seriesIndex, 0)) {
            final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, seriesIndex);
            String generateLabel2 = null;
            if (this.getLegendItemToolTipGenerator() != null) {
                generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, seriesIndex);
            }
            String generateLabel3 = null;
            if (this.getLegendItemURLGenerator() != null) {
                generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, seriesIndex);
            }
            legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, this.getItemShapeVisible(seriesIndex, 0), this.getSeriesShape(seriesIndex), this.getItemShapeFilled(seriesIndex, 0), this.useFillPaint ? this.getSeriesFillPaint(seriesIndex) : this.getSeriesPaint(seriesIndex), this.drawOutlines, this.useOutlinePaint ? this.getSeriesOutlinePaint(seriesIndex) : this.getSeriesPaint(seriesIndex), this.getSeriesOutlineStroke(seriesIndex), this.getItemLineVisible(seriesIndex, 0), this.legendLine, this.getSeriesStroke(seriesIndex), this.getSeriesPaint(seriesIndex));
            legendItem.setSeriesIndex(seriesIndex);
            legendItem.setDatasetIndex(datasetIndex);
        }
        return legendItem;
    }
    
    public Object clone() {
        final XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer)super.clone();
        xyLineAndShapeRenderer.seriesLinesVisible = (BooleanList)this.seriesLinesVisible.clone();
        if (this.legendLine != null) {
            xyLineAndShapeRenderer.legendLine = ShapeUtilities.clone(this.legendLine);
        }
        xyLineAndShapeRenderer.seriesShapesVisible = (BooleanList)this.seriesShapesVisible.clone();
        xyLineAndShapeRenderer.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
        return xyLineAndShapeRenderer;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYLineAndShapeRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer)o;
        return ObjectUtilities.equal(this.linesVisible, xyLineAndShapeRenderer.linesVisible) && ObjectUtilities.equal(this.seriesLinesVisible, xyLineAndShapeRenderer.seriesLinesVisible) && this.baseLinesVisible == xyLineAndShapeRenderer.baseLinesVisible && ShapeUtilities.equal(this.legendLine, xyLineAndShapeRenderer.legendLine) && ObjectUtilities.equal(this.shapesVisible, xyLineAndShapeRenderer.shapesVisible) && ObjectUtilities.equal(this.seriesShapesVisible, xyLineAndShapeRenderer.seriesShapesVisible) && this.baseShapesVisible == xyLineAndShapeRenderer.baseShapesVisible && ObjectUtilities.equal(this.shapesFilled, xyLineAndShapeRenderer.shapesFilled) && ObjectUtilities.equal(this.seriesShapesFilled, xyLineAndShapeRenderer.seriesShapesFilled) && this.baseShapesFilled == xyLineAndShapeRenderer.baseShapesFilled && this.drawOutlines == xyLineAndShapeRenderer.drawOutlines && this.useOutlinePaint == xyLineAndShapeRenderer.useOutlinePaint && this.useFillPaint == xyLineAndShapeRenderer.useFillPaint && this.drawSeriesLineAsPath == xyLineAndShapeRenderer.drawSeriesLineAsPath;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendLine = SerialUtilities.readShape(objectInputStream);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendLine, objectOutputStream);
    }
}
