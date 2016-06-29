package org.jfree.chart.renderer.xy;

import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import org.jfree.text.*;
import java.awt.geom.*;
import org.jfree.chart.labels.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYBarRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = 770559577251370036L;
    private double base;
    private boolean useYInterval;
    private double margin;
    private boolean drawBarOutline;
    private GradientPaintTransformer gradientPaintTransformer;
    private transient Shape legendBar;
    private ItemLabelPosition positiveItemLabelPositionFallback;
    private ItemLabelPosition negativeItemLabelPositionFallback;
    
    public XYBarRenderer() {
        this(0.0);
    }
    
    public XYBarRenderer(final double margin) {
        this.margin = margin;
        this.base = 0.0;
        this.useYInterval = false;
        this.gradientPaintTransformer = new StandardGradientPaintTransformer();
        this.drawBarOutline = true;
        this.legendBar = new Rectangle2D.Double(-3.0, -5.0, 6.0, 10.0);
    }
    
    public double getBase() {
        return this.base;
    }
    
    public void setBase(final double base) {
        this.base = base;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getUseYInterval() {
        return this.useYInterval;
    }
    
    public void setUseYInterval(final boolean useYInterval) {
        if (this.useYInterval != useYInterval) {
            this.useYInterval = useYInterval;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public double getMargin() {
        return this.margin;
    }
    
    public void setMargin(final double margin) {
        this.margin = margin;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean isDrawBarOutline() {
        return this.drawBarOutline;
    }
    
    public void setDrawBarOutline(final boolean drawBarOutline) {
        this.drawBarOutline = drawBarOutline;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public GradientPaintTransformer getGradientPaintTransformer() {
        return this.gradientPaintTransformer;
    }
    
    public void setGradientPaintTransformer(final GradientPaintTransformer gradientPaintTransformer) {
        this.gradientPaintTransformer = gradientPaintTransformer;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Shape getLegendBar() {
        return this.legendBar;
    }
    
    public void setLegendBar(final Shape legendBar) {
        if (legendBar == null) {
            throw new IllegalArgumentException("Null 'bar' argument.");
        }
        this.legendBar = legendBar;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public ItemLabelPosition getPositiveItemLabelPositionFallback() {
        return this.positiveItemLabelPositionFallback;
    }
    
    public void setPositiveItemLabelPositionFallback(final ItemLabelPosition positiveItemLabelPositionFallback) {
        this.positiveItemLabelPositionFallback = positiveItemLabelPositionFallback;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public ItemLabelPosition getNegativeItemLabelPositionFallback() {
        return this.negativeItemLabelPositionFallback;
    }
    
    public void setNegativeItemLabelPositionFallback(final ItemLabelPosition negativeItemLabelPositionFallback) {
        this.negativeItemLabelPositionFallback = negativeItemLabelPositionFallback;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        final XYBarRenderer$XYBarRendererState xyBarRenderer$XYBarRendererState = new XYBarRenderer$XYBarRendererState(this, plotRenderingInfo);
        xyBarRenderer$XYBarRendererState.setG2Base(xyPlot.getRangeAxisForDataset(xyPlot.indexOf(xyDataset)).valueToJava2D(this.base, rectangle2D, xyPlot.getRangeAxisEdge()));
        return xyBarRenderer$XYBarRendererState;
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        LegendItem legendItem = null;
        final XYPlot plot = this.getPlot();
        if (plot != null) {
            final XYDataset dataset = plot.getDataset(n);
            if (dataset != null) {
                final String generateLabel;
                final String s = generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, n2);
                String generateLabel2 = null;
                if (this.getLegendItemToolTipGenerator() != null) {
                    generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, n2);
                }
                String generateLabel3 = null;
                if (this.getLegendItemURLGenerator() != null) {
                    generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, n2);
                }
                final Shape legendBar = this.legendBar;
                final Paint seriesPaint = this.getSeriesPaint(n2);
                final Paint seriesOutlinePaint = this.getSeriesOutlinePaint(n2);
                final Stroke seriesOutlineStroke = this.getSeriesOutlineStroke(n2);
                if (this.drawBarOutline) {
                    legendItem = new LegendItem(s, generateLabel, generateLabel2, generateLabel3, legendBar, seriesPaint, seriesOutlineStroke, seriesOutlinePaint);
                }
                else {
                    legendItem = new LegendItem(s, generateLabel, generateLabel2, generateLabel3, legendBar, seriesPaint);
                }
                if (this.getGradientPaintTransformer() != null) {
                    legendItem.setFillPaintTransformer(this.getGradientPaintTransformer());
                }
            }
        }
        return legendItem;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
        double n4;
        double n5;
        if (this.useYInterval) {
            n4 = intervalXYDataset.getStartYValue(n, n2);
            n5 = intervalXYDataset.getEndYValue(n, n2);
        }
        else {
            n4 = this.base;
            n5 = intervalXYDataset.getYValue(n, n2);
        }
        if (Double.isNaN(n4) || Double.isNaN(n5)) {
            return;
        }
        if (n4 <= n5) {
            if (!valueAxis2.getRange().intersects(n4, n5)) {
                return;
            }
        }
        else if (!valueAxis2.getRange().intersects(n5, n4)) {
            return;
        }
        final double valueToJava2D = valueAxis2.valueToJava2D(n4, rectangle2D, xyPlot.getRangeAxisEdge());
        final double valueToJava2D2 = valueAxis2.valueToJava2D(n5, rectangle2D, xyPlot.getRangeAxisEdge());
        final double min = Math.min(valueToJava2D, valueToJava2D2);
        final double max = Math.max(valueToJava2D, valueToJava2D2);
        final double startXValue = intervalXYDataset.getStartXValue(n, n2);
        if (Double.isNaN(startXValue)) {
            return;
        }
        final double endXValue = intervalXYDataset.getEndXValue(n, n2);
        if (Double.isNaN(endXValue)) {
            return;
        }
        if (startXValue <= endXValue) {
            if (!valueAxis.getRange().intersects(startXValue, endXValue)) {
                return;
            }
        }
        else if (!valueAxis.getRange().intersects(endXValue, startXValue)) {
            return;
        }
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        double valueToJava2D3 = valueAxis.valueToJava2D(startXValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D4 = valueAxis.valueToJava2D(endXValue, rectangle2D, domainAxisEdge);
        double max2 = Math.max(1.0, Math.abs(valueToJava2D4 - valueToJava2D3));
        if (this.getMargin() > 0.0) {
            final double n6 = max2 * this.getMargin();
            max2 -= n6;
            valueToJava2D3 += n6 / 2.0;
        }
        Rectangle2D rectangle2D2 = null;
        final PlotOrientation orientation = xyPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double max3 = Math.max(min, rectangle2D.getMinX());
            rectangle2D2 = new Rectangle2D.Double(max3, Math.min(valueToJava2D3, valueToJava2D4), Math.min(max, rectangle2D.getMaxX()) - max3, max2);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            final double max4 = Math.max(min, rectangle2D.getMinY());
            rectangle2D2 = new Rectangle2D.Double(Math.min(valueToJava2D3, valueToJava2D4), max4, max2, Math.min(max, rectangle2D.getMaxY()) - max4);
        }
        Paint paint = this.getItemPaint(n, n2);
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            paint = this.getGradientPaintTransformer().transform((GradientPaint)paint, rectangle2D2);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(rectangle2D2);
        if (this.isDrawBarOutline() && Math.abs(valueToJava2D4 - valueToJava2D3) > 3.0) {
            final Stroke itemOutlineStroke = this.getItemOutlineStroke(n, n2);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(n, n2);
            if (itemOutlineStroke != null && itemOutlinePaint != null) {
                graphics2D.setStroke(itemOutlineStroke);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(rectangle2D2);
            }
        }
        if (this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, xyDataset, n, n2, xyPlot, this.getItemLabelGenerator(n, n2), rectangle2D2, n5 < 0.0);
        }
        final double n7 = (startXValue + endXValue) / 2.0;
        final double yValue = xyDataset.getYValue(n, n2);
        this.updateCrosshairValues(crosshairState, n7, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueAxis.valueToJava2D(n7, rectangle2D, domainAxisEdge), valueAxis2.valueToJava2D(yValue, rectangle2D, xyPlot.getRangeAxisEdge()), xyPlot.getOrientation());
        if (plotRenderingInfo != null) {
            final EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
            if (entityCollection != null) {
                String generateToolTip = null;
                final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
                }
                String generateURL = null;
                if (this.getURLGenerator() != null) {
                    generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
                }
                entityCollection.add(new XYItemEntity(rectangle2D2, xyDataset, n, n2, generateToolTip, generateURL));
            }
        }
    }
    
    protected void drawItemLabel(final Graphics2D graphics2D, final XYDataset xyDataset, final int n, final int n2, final XYPlot xyPlot, final XYItemLabelGenerator xyItemLabelGenerator, final Rectangle2D rectangle2D, final boolean b) {
        final String generateLabel = xyItemLabelGenerator.generateLabel(xyDataset, n, n2);
        if (generateLabel == null) {
            return;
        }
        graphics2D.setFont(this.getItemLabelFont(n, n2));
        graphics2D.setPaint(this.getItemLabelPaint(n, n2));
        ItemLabelPosition itemLabelPosition;
        if (!b) {
            itemLabelPosition = this.getPositiveItemLabelPosition(n, n2);
        }
        else {
            itemLabelPosition = this.getNegativeItemLabelPosition(n, n2);
        }
        Point2D point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, xyPlot.getOrientation());
        if (this.isInternalAnchor(itemLabelPosition.getItemLabelAnchor())) {
            final Shape calculateRotatedStringBounds = TextUtilities.calculateRotatedStringBounds(generateLabel, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
            if (calculateRotatedStringBounds != null && !rectangle2D.contains(calculateRotatedStringBounds.getBounds2D())) {
                if (!b) {
                    itemLabelPosition = this.getPositiveItemLabelPositionFallback();
                }
                else {
                    itemLabelPosition = this.getNegativeItemLabelPositionFallback();
                }
                if (itemLabelPosition != null) {
                    point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, xyPlot.getOrientation());
                }
            }
        }
        if (itemLabelPosition != null) {
            TextUtilities.drawRotatedString(generateLabel, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
        }
    }
    
    private Point2D calculateLabelAnchorPoint(final ItemLabelAnchor itemLabelAnchor, final Rectangle2D rectangle2D, final PlotOrientation plotOrientation) {
        Point2D point2D = null;
        final double itemLabelAnchorOffset = this.getItemLabelAnchorOffset();
        final double n = rectangle2D.getX() - itemLabelAnchorOffset;
        final double x = rectangle2D.getX();
        final double n2 = rectangle2D.getX() + itemLabelAnchorOffset;
        final double centerX = rectangle2D.getCenterX();
        final double n3 = rectangle2D.getMaxX() - itemLabelAnchorOffset;
        final double maxX = rectangle2D.getMaxX();
        final double n4 = rectangle2D.getMaxX() + itemLabelAnchorOffset;
        final double n5 = rectangle2D.getMaxY() + itemLabelAnchorOffset;
        final double maxY = rectangle2D.getMaxY();
        final double n6 = rectangle2D.getMaxY() - itemLabelAnchorOffset;
        final double centerY = rectangle2D.getCenterY();
        final double n7 = rectangle2D.getMinY() + itemLabelAnchorOffset;
        final double minY = rectangle2D.getMinY();
        final double n8 = rectangle2D.getMinY() - itemLabelAnchorOffset;
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) {
            point2D = new Point2D.Double(centerX, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) {
            point2D = new Point2D.Double(n3, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) {
            point2D = new Point2D.Double(n3, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) {
            point2D = new Point2D.Double(n3, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) {
            point2D = new Point2D.Double(n3, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) {
            point2D = new Point2D.Double(n3, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) {
            point2D = new Point2D.Double(centerX, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) {
            point2D = new Point2D.Double(n2, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) {
            point2D = new Point2D.Double(n2, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) {
            point2D = new Point2D.Double(n2, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) {
            point2D = new Point2D.Double(n2, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) {
            point2D = new Point2D.Double(n2, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) {
            point2D = new Point2D.Double(centerX, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE1) {
            point2D = new Point2D.Double(maxX, n8);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE2) {
            point2D = new Point2D.Double(n4, minY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE3) {
            point2D = new Point2D.Double(n4, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE4) {
            point2D = new Point2D.Double(n4, maxY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE5) {
            point2D = new Point2D.Double(maxX, n5);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE6) {
            point2D = new Point2D.Double(centerX, n5);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE7) {
            point2D = new Point2D.Double(x, n5);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE8) {
            point2D = new Point2D.Double(n, maxY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE9) {
            point2D = new Point2D.Double(n, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE10) {
            point2D = new Point2D.Double(n, minY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE11) {
            point2D = new Point2D.Double(x, n8);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE12) {
            point2D = new Point2D.Double(centerX, n8);
        }
        return point2D;
    }
    
    private boolean isInternalAnchor(final ItemLabelAnchor itemLabelAnchor) {
        return itemLabelAnchor == ItemLabelAnchor.CENTER || itemLabelAnchor == ItemLabelAnchor.INSIDE1 || itemLabelAnchor == ItemLabelAnchor.INSIDE2 || itemLabelAnchor == ItemLabelAnchor.INSIDE3 || itemLabelAnchor == ItemLabelAnchor.INSIDE4 || itemLabelAnchor == ItemLabelAnchor.INSIDE5 || itemLabelAnchor == ItemLabelAnchor.INSIDE6 || itemLabelAnchor == ItemLabelAnchor.INSIDE7 || itemLabelAnchor == ItemLabelAnchor.INSIDE8 || itemLabelAnchor == ItemLabelAnchor.INSIDE9 || itemLabelAnchor == ItemLabelAnchor.INSIDE10 || itemLabelAnchor == ItemLabelAnchor.INSIDE11 || itemLabelAnchor == ItemLabelAnchor.INSIDE12;
    }
    
    public Range findDomainBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            return DatasetUtilities.findDomainBounds(xyDataset, true);
        }
        return null;
    }
    
    public Object clone() {
        final XYBarRenderer xyBarRenderer = (XYBarRenderer)super.clone();
        if (this.gradientPaintTransformer != null) {
            xyBarRenderer.gradientPaintTransformer = (GradientPaintTransformer)ObjectUtilities.clone(this.gradientPaintTransformer);
        }
        xyBarRenderer.legendBar = ShapeUtilities.clone(this.legendBar);
        return xyBarRenderer;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYBarRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYBarRenderer xyBarRenderer = (XYBarRenderer)o;
        return this.base == xyBarRenderer.base && this.drawBarOutline == xyBarRenderer.drawBarOutline && this.margin == xyBarRenderer.margin && this.useYInterval == xyBarRenderer.useYInterval && ObjectUtilities.equal(this.gradientPaintTransformer, xyBarRenderer.gradientPaintTransformer) && ShapeUtilities.equal(this.legendBar, xyBarRenderer.legendBar) && ObjectUtilities.equal(this.positiveItemLabelPositionFallback, xyBarRenderer.positiveItemLabelPositionFallback) && ObjectUtilities.equal(this.negativeItemLabelPositionFallback, xyBarRenderer.negativeItemLabelPositionFallback);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendBar = SerialUtilities.readShape(objectInputStream);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendBar, objectOutputStream);
    }
}
