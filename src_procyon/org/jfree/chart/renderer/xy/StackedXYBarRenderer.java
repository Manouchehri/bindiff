package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.entity.*;

public class StackedXYBarRenderer extends XYBarRenderer
{
    private static final long serialVersionUID = -7049101055533436444L;
    private boolean renderAsPercentages;
    static Class class$org$jfree$data$xy$IntervalXYDataset;
    static Class class$org$jfree$data$xy$TableXYDataset;
    
    public StackedXYBarRenderer() {
        this(0.0);
    }
    
    public StackedXYBarRenderer(final double n) {
        super(n);
        this.renderAsPercentages = false;
        final ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        this.setBasePositiveItemLabelPosition(itemLabelPosition);
        this.setBaseNegativeItemLabelPosition(itemLabelPosition);
        this.setPositiveItemLabelPositionFallback(null);
        this.setNegativeItemLabelPositionFallback(null);
    }
    
    public boolean getRenderAsPercentages() {
        return this.renderAsPercentages;
    }
    
    public void setRenderAsPercentages(final boolean renderAsPercentages) {
        this.renderAsPercentages = renderAsPercentages;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public int getPassCount() {
        return 2;
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        return new XYBarRenderer$XYBarRendererState(this, plotRenderingInfo);
    }
    
    public Range findRangeBounds(final XYDataset xyDataset) {
        if (xyDataset == null) {
            return null;
        }
        if (this.renderAsPercentages) {
            return new Range(0.0, 1.0);
        }
        return DatasetUtilities.findStackedRangeBounds((TableXYDataset)xyDataset);
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!(xyDataset instanceof IntervalXYDataset) || !(xyDataset instanceof TableXYDataset)) {
            String s = "dataset (type " + xyDataset.getClass().getName() + ") has wrong type:";
            boolean b = false;
            if (!((StackedXYBarRenderer.class$org$jfree$data$xy$IntervalXYDataset == null) ? (StackedXYBarRenderer.class$org$jfree$data$xy$IntervalXYDataset = class$("org.jfree.data.xy.IntervalXYDataset")) : StackedXYBarRenderer.class$org$jfree$data$xy$IntervalXYDataset).isAssignableFrom(xyDataset.getClass())) {
                s += " it is no IntervalXYDataset";
                b = true;
            }
            if (!((StackedXYBarRenderer.class$org$jfree$data$xy$TableXYDataset == null) ? (StackedXYBarRenderer.class$org$jfree$data$xy$TableXYDataset = class$("org.jfree.data.xy.TableXYDataset")) : StackedXYBarRenderer.class$org$jfree$data$xy$TableXYDataset).isAssignableFrom(xyDataset.getClass())) {
                if (b) {
                    s += " and";
                }
                s += " it is no TableXYDataset";
            }
            throw new IllegalArgumentException(s);
        }
        final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
        double yValue = intervalXYDataset.getYValue(n, n2);
        if (Double.isNaN(yValue)) {
            return;
        }
        double calculateStackTotal = 0.0;
        if (this.renderAsPercentages) {
            calculateStackTotal = DatasetUtilities.calculateStackTotal((TableXYDataset)xyDataset, n2);
            yValue /= calculateStackTotal;
        }
        double n4 = 0.0;
        double n5 = 0.0;
        for (int i = 0; i < n; ++i) {
            double yValue2 = xyDataset.getYValue(i, n2);
            if (!Double.isNaN(yValue2)) {
                if (this.renderAsPercentages) {
                    yValue2 /= calculateStackTotal;
                }
                if (yValue2 > 0.0) {
                    n4 += yValue2;
                }
                else {
                    n5 += yValue2;
                }
            }
        }
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        double n6;
        double n7;
        if (yValue > 0.0) {
            n6 = valueAxis2.valueToJava2D(n4, rectangle2D, rangeAxisEdge);
            n7 = valueAxis2.valueToJava2D(n4 + yValue, rectangle2D, rangeAxisEdge);
        }
        else {
            n6 = valueAxis2.valueToJava2D(n5, rectangle2D, rangeAxisEdge);
            n7 = valueAxis2.valueToJava2D(n5 + yValue, rectangle2D, rangeAxisEdge);
        }
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final double startXValue = intervalXYDataset.getStartXValue(n, n2);
        if (Double.isNaN(startXValue)) {
            return;
        }
        double valueToJava2D = valueAxis.valueToJava2D(startXValue, rectangle2D, domainAxisEdge);
        final double endXValue = intervalXYDataset.getEndXValue(n, n2);
        if (Double.isNaN(endXValue)) {
            return;
        }
        final double valueToJava2D2 = valueAxis.valueToJava2D(endXValue, rectangle2D, domainAxisEdge);
        double max = Math.max(1.0, Math.abs(valueToJava2D2 - valueToJava2D));
        final double abs = Math.abs(n7 - n6);
        if (this.getMargin() > 0.0) {
            final double n8 = max * this.getMargin();
            max -= n8;
            valueToJava2D += n8 / 2.0;
        }
        Rectangle2D rectangle2D2 = null;
        final PlotOrientation orientation = xyPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            rectangle2D2 = new Rectangle2D.Double(Math.min(n6, n7), valueToJava2D2, abs, max);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            rectangle2D2 = new Rectangle2D.Double(valueToJava2D, Math.min(n6, n7), max, abs);
        }
        if (n3 == 0) {
            Paint paint = this.getItemPaint(n, n2);
            if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
                paint = this.getGradientPaintTransformer().transform((GradientPaint)paint, rectangle2D2);
            }
            graphics2D.setPaint(paint);
            graphics2D.fill(rectangle2D2);
            if (this.isDrawBarOutline() && Math.abs(valueToJava2D2 - valueToJava2D) > 3.0) {
                graphics2D.setStroke(this.getItemStroke(n, n2));
                graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                graphics2D.draw(rectangle2D2);
            }
            if (plotRenderingInfo != null) {
                final EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
                if (entityCollection != null) {
                    this.addEntity(entityCollection, rectangle2D2, xyDataset, n, n2, rectangle2D2.getCenterX(), rectangle2D2.getCenterY());
                }
            }
        }
        else if (n3 == 1 && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, xyDataset, n, n2, xyPlot, this.getItemLabelGenerator(n, n2), rectangle2D2, yValue < 0.0);
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StackedXYBarRenderer && this.renderAsPercentages == ((StackedXYBarRenderer)o).renderAsPercentages && super.equals(o));
    }
    
    public int hashCode() {
        return super.hashCode() * 37 + (this.renderAsPercentages ? 1 : 0);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
