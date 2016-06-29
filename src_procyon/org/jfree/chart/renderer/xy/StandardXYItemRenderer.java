package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.image.*;
import org.jfree.chart.entity.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class StandardXYItemRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -3271351259436865995L;
    public static final int SHAPES = 1;
    public static final int LINES = 2;
    public static final int SHAPES_AND_LINES = 3;
    public static final int IMAGES = 4;
    public static final int DISCONTINUOUS = 8;
    public static final int DISCONTINUOUS_LINES = 10;
    private boolean baseShapesVisible;
    private boolean plotLines;
    private boolean plotImages;
    private boolean plotDiscontinuous;
    private UnitType gapThresholdType;
    private double gapThreshold;
    private Boolean shapesFilled;
    private BooleanList seriesShapesFilled;
    private boolean baseShapesFilled;
    private boolean drawSeriesLineAsPath;
    private transient Shape legendLine;
    
    public StandardXYItemRenderer() {
        this(2, null);
    }
    
    public StandardXYItemRenderer(final int n) {
        this(n, null);
    }
    
    public StandardXYItemRenderer(final int n, final XYToolTipGenerator xyToolTipGenerator) {
        this(n, xyToolTipGenerator, null);
    }
    
    public StandardXYItemRenderer(final int n, final XYToolTipGenerator toolTipGenerator, final XYURLGenerator urlGenerator) {
        this.gapThresholdType = UnitType.RELATIVE;
        this.gapThreshold = 1.0;
        this.setToolTipGenerator(toolTipGenerator);
        this.setURLGenerator(urlGenerator);
        if ((n & 0x1) != 0x0) {
            this.baseShapesVisible = true;
        }
        if ((n & 0x2) != 0x0) {
            this.plotLines = true;
        }
        if ((n & 0x4) != 0x0) {
            this.plotImages = true;
        }
        if ((n & 0x8) != 0x0) {
            this.plotDiscontinuous = true;
        }
        this.shapesFilled = null;
        this.seriesShapesFilled = new BooleanList();
        this.baseShapesFilled = true;
        this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        this.drawSeriesLineAsPath = false;
    }
    
    public boolean getBaseShapesVisible() {
        return this.baseShapesVisible;
    }
    
    public void setBaseShapesVisible(final boolean baseShapesVisible) {
        if (this.baseShapesVisible != baseShapesVisible) {
            this.baseShapesVisible = baseShapesVisible;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public boolean getItemShapeFilled(final int n, final int n2) {
        if (this.shapesFilled != null) {
            return this.shapesFilled;
        }
        final Boolean boolean1 = this.seriesShapesFilled.getBoolean(n);
        if (boolean1 != null) {
            return boolean1;
        }
        return this.baseShapesFilled;
    }
    
    public Boolean getShapesFilled() {
        return this.shapesFilled;
    }
    
    public void setShapesFilled(final boolean b) {
        this.setShapesFilled(BooleanUtilities.valueOf(b));
    }
    
    public void setShapesFilled(final Boolean shapesFilled) {
        this.shapesFilled = shapesFilled;
        this.fireChangeEvent();
    }
    
    public Boolean getSeriesShapesFilled(final int n) {
        return this.seriesShapesFilled.getBoolean(n);
    }
    
    public void setSeriesShapesFilled(final int n, final Boolean b) {
        this.seriesShapesFilled.setBoolean(n, b);
        this.fireChangeEvent();
    }
    
    public boolean getBaseShapesFilled() {
        return this.baseShapesFilled;
    }
    
    public void setBaseShapesFilled(final boolean baseShapesFilled) {
        this.baseShapesFilled = baseShapesFilled;
    }
    
    public boolean getPlotLines() {
        return this.plotLines;
    }
    
    public void setPlotLines(final boolean plotLines) {
        if (this.plotLines != plotLines) {
            this.plotLines = plotLines;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public UnitType getGapThresholdType() {
        return this.gapThresholdType;
    }
    
    public void setGapThresholdType(final UnitType gapThresholdType) {
        if (gapThresholdType == null) {
            throw new IllegalArgumentException("Null 'thresholdType' argument.");
        }
        this.gapThresholdType = gapThresholdType;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getGapThreshold() {
        return this.gapThreshold;
    }
    
    public void setGapThreshold(final double gapThreshold) {
        this.gapThreshold = gapThreshold;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getPlotImages() {
        return this.plotImages;
    }
    
    public void setPlotImages(final boolean plotImages) {
        if (this.plotImages != plotImages) {
            this.plotImages = plotImages;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public boolean getPlotDiscontinuous() {
        return this.plotDiscontinuous;
    }
    
    public void setPlotDiscontinuous(final boolean plotDiscontinuous) {
        if (this.plotDiscontinuous != plotDiscontinuous) {
            this.plotDiscontinuous = plotDiscontinuous;
            this.fireChangeEvent();
        }
    }
    
    public boolean getDrawSeriesLineAsPath() {
        return this.drawSeriesLineAsPath;
    }
    
    public void setDrawSeriesLineAsPath(final boolean drawSeriesLineAsPath) {
        this.drawSeriesLineAsPath = drawSeriesLineAsPath;
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
    
    public LegendItem getLegendItem(final int n, final int n2) {
        final XYPlot plot = this.getPlot();
        if (plot == null) {
            return null;
        }
        LegendItem legendItem = null;
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
            final Shape seriesShape = this.getSeriesShape(n2);
            final boolean itemShapeFilled = this.getItemShapeFilled(n2, 0);
            final Paint seriesPaint;
            final Paint paint = seriesPaint = this.getSeriesPaint(n2);
            final Stroke seriesStroke = this.getSeriesStroke(n2);
            legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, this.baseShapesVisible, seriesShape, itemShapeFilled, paint, !itemShapeFilled, paint, seriesStroke, this.plotLines, this.legendLine, seriesStroke, seriesPaint);
        }
        return legendItem;
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        final StandardXYItemRenderer$State standardXYItemRenderer$State = new StandardXYItemRenderer$State(plotRenderingInfo);
        standardXYItemRenderer$State.seriesPath = new GeneralPath();
        StandardXYItemRenderer$State.access$002(standardXYItemRenderer$State, -1);
        return standardXYItemRenderer$State;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int seriesIndex, final int n, final CrosshairState crosshairState, final int n2) {
        boolean itemVisible = this.getItemVisible(seriesIndex, n);
        Shape shape = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final Paint itemPaint = this.getItemPaint(seriesIndex, n);
        final Stroke itemStroke = this.getItemStroke(seriesIndex, n);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        final double xValue = xyDataset.getXValue(seriesIndex, n);
        final double yValue = xyDataset.getYValue(seriesIndex, n);
        if (Double.isNaN(xValue) || Double.isNaN(yValue)) {
            itemVisible = false;
        }
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
        if (this.getPlotLines()) {
            if (this.drawSeriesLineAsPath) {
                final StandardXYItemRenderer$State standardXYItemRenderer$State = (StandardXYItemRenderer$State)xyItemRendererState;
                if (standardXYItemRenderer$State.getSeriesIndex() != seriesIndex) {
                    standardXYItemRenderer$State.seriesPath.reset();
                    StandardXYItemRenderer$State.access$102(standardXYItemRenderer$State, false);
                    standardXYItemRenderer$State.setSeriesIndex(seriesIndex);
                }
                if (itemVisible && !Double.isNaN(valueToJava2D) && !Double.isNaN(valueToJava2D2)) {
                    float n3 = (float)valueToJava2D;
                    float n4 = (float)valueToJava2D2;
                    if (orientation == PlotOrientation.HORIZONTAL) {
                        n3 = (float)valueToJava2D2;
                        n4 = (float)valueToJava2D;
                    }
                    if (standardXYItemRenderer$State.isLastPointGood()) {
                        standardXYItemRenderer$State.seriesPath.lineTo(n3, n4);
                    }
                    else {
                        standardXYItemRenderer$State.seriesPath.moveTo(n3, n4);
                    }
                    standardXYItemRenderer$State.setLastPointGood(true);
                }
                else {
                    standardXYItemRenderer$State.setLastPointGood(false);
                }
                if (n == xyDataset.getItemCount(seriesIndex) - 1 && StandardXYItemRenderer$State.access$000(standardXYItemRenderer$State) == seriesIndex) {
                    graphics2D.setStroke(this.getSeriesStroke(seriesIndex));
                    graphics2D.setPaint(this.getSeriesPaint(seriesIndex));
                    graphics2D.draw(standardXYItemRenderer$State.seriesPath);
                }
            }
            else if (n != 0 && itemVisible) {
                final double xValue2 = xyDataset.getXValue(seriesIndex, n - 1);
                final double yValue2 = xyDataset.getYValue(seriesIndex, n - 1);
                if (!Double.isNaN(xValue2) && !Double.isNaN(yValue2)) {
                    int n5 = 1;
                    if (this.getPlotDiscontinuous()) {
                        final int itemCount = xyDataset.getItemCount(seriesIndex);
                        final double xValue3 = xyDataset.getXValue(seriesIndex, 0);
                        final double xValue4 = xyDataset.getXValue(seriesIndex, itemCount - 1);
                        if (this.gapThresholdType == UnitType.ABSOLUTE) {
                            n5 = ((Math.abs(xValue - xValue2) <= this.gapThreshold) ? 1 : 0);
                        }
                        else {
                            n5 = ((Math.abs(xValue - xValue2) <= (xValue4 - xValue3) / itemCount * this.getGapThreshold()) ? 1 : 0);
                        }
                    }
                    if (n5 != 0) {
                        final double valueToJava2D3 = valueAxis.valueToJava2D(xValue2, rectangle2D, domainAxisEdge);
                        final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue2, rectangle2D, rangeAxisEdge);
                        if (Double.isNaN(valueToJava2D3) || Double.isNaN(valueToJava2D4) || Double.isNaN(valueToJava2D) || Double.isNaN(valueToJava2D2)) {
                            return;
                        }
                        if (orientation == PlotOrientation.HORIZONTAL) {
                            xyItemRendererState.workingLine.setLine(valueToJava2D4, valueToJava2D3, valueToJava2D2, valueToJava2D);
                        }
                        else if (orientation == PlotOrientation.VERTICAL) {
                            xyItemRendererState.workingLine.setLine(valueToJava2D3, valueToJava2D4, valueToJava2D, valueToJava2D2);
                        }
                        if (xyItemRendererState.workingLine.intersects(rectangle2D)) {
                            graphics2D.draw(xyItemRendererState.workingLine);
                        }
                    }
                }
            }
        }
        if (!itemVisible) {
            return;
        }
        if (this.getBaseShapesVisible()) {
            Shape shape2 = this.getItemShape(seriesIndex, n);
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, valueToJava2D2, valueToJava2D);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, valueToJava2D, valueToJava2D2);
            }
            if (shape2.intersects(rectangle2D)) {
                if (this.getItemShapeFilled(seriesIndex, n)) {
                    graphics2D.fill(shape2);
                }
                else {
                    graphics2D.draw(shape2);
                }
            }
            shape = shape2;
        }
        if (this.getPlotImages()) {
            final Image image = this.getImage(xyPlot, seriesIndex, n, valueToJava2D, valueToJava2D2);
            if (image != null) {
                final Point imageHotspot = this.getImageHotspot(xyPlot, seriesIndex, n, valueToJava2D, valueToJava2D2, image);
                graphics2D.drawImage(image, (int)(valueToJava2D - imageHotspot.getX()), (int)(valueToJava2D2 - imageHotspot.getY()), null);
                shape = new Rectangle2D.Double(valueToJava2D - imageHotspot.getX(), valueToJava2D2 - imageHotspot.getY(), image.getWidth(null), image.getHeight(null));
            }
        }
        if (this.isItemLabelVisible(seriesIndex, n)) {
            double n6 = valueToJava2D;
            double n7 = valueToJava2D2;
            if (orientation == PlotOrientation.HORIZONTAL) {
                n6 = valueToJava2D2;
                n7 = valueToJava2D;
            }
            this.drawItemLabel(graphics2D, orientation, xyDataset, seriesIndex, n, n6, n7, yValue < 0.0);
        }
        this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, valueToJava2D2, orientation);
        if (entityCollection != null) {
            this.addEntity(entityCollection, shape, xyDataset, seriesIndex, n, valueToJava2D, valueToJava2D2);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardXYItemRenderer)) {
            return false;
        }
        final StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)o;
        return this.baseShapesVisible == standardXYItemRenderer.baseShapesVisible && this.plotLines == standardXYItemRenderer.plotLines && this.plotImages == standardXYItemRenderer.plotImages && this.plotDiscontinuous == standardXYItemRenderer.plotDiscontinuous && this.gapThresholdType == standardXYItemRenderer.gapThresholdType && this.gapThreshold == standardXYItemRenderer.gapThreshold && ObjectUtilities.equal(this.shapesFilled, standardXYItemRenderer.shapesFilled) && this.seriesShapesFilled.equals(standardXYItemRenderer.seriesShapesFilled) && this.baseShapesFilled == standardXYItemRenderer.baseShapesFilled && this.drawSeriesLineAsPath == standardXYItemRenderer.drawSeriesLineAsPath && ShapeUtilities.equal(this.legendLine, standardXYItemRenderer.legendLine) && super.equals(o);
    }
    
    public Object clone() {
        final StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)super.clone();
        standardXYItemRenderer.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
        standardXYItemRenderer.legendLine = ShapeUtilities.clone(this.legendLine);
        return standardXYItemRenderer;
    }
    
    protected Image getImage(final Plot plot, final int n, final int n2, final double n3, final double n4) {
        return null;
    }
    
    protected Point getImageHotspot(final Plot plot, final int n, final int n2, final double n3, final double n4, final Image image) {
        return new Point(image.getWidth(null) / 2, image.getHeight(null) / 2);
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
