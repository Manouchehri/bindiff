package org.jfree.chart.renderer.xy;

import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;

public class DeviationRenderer extends XYLineAndShapeRenderer
{
    private float alpha;
    
    public DeviationRenderer() {
        this(true, true);
    }
    
    public DeviationRenderer(final boolean b, final boolean b2) {
        super(b, b2);
        super.setDrawSeriesLineAsPath(true);
        this.alpha = 0.5f;
    }
    
    public float getAlpha() {
        return this.alpha;
    }
    
    public void setAlpha(final float alpha) {
        if (alpha < 0.0f || alpha > 1.0f) {
            throw new IllegalArgumentException("Requires 'alpha' in the range 0.0 to 1.0.");
        }
        this.alpha = alpha;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setDrawSeriesLineAsPath(final boolean b) {
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        final DeviationRenderer$State deviationRenderer$State = new DeviationRenderer$State(plotRenderingInfo);
        deviationRenderer$State.seriesPath = new GeneralPath();
        return deviationRenderer$State;
    }
    
    public int getPassCount() {
        return 3;
    }
    
    protected boolean isItemPass(final int n) {
        return n == 2;
    }
    
    protected boolean isLinePass(final int n) {
        return n == 1;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        if (n3 == 0) {
            final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
            final DeviationRenderer$State deviationRenderer$State = (DeviationRenderer$State)xyItemRendererState;
            final double xValue = intervalXYDataset.getXValue(n, n2);
            final double startYValue = intervalXYDataset.getStartYValue(n, n2);
            final double endYValue = intervalXYDataset.getEndYValue(n, n2);
            final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
            final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
            final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
            final double valueToJava2D2 = valueAxis2.valueToJava2D(startYValue, rectangle2D, rangeAxisEdge);
            final double valueToJava2D3 = valueAxis2.valueToJava2D(endYValue, rectangle2D, rangeAxisEdge);
            final PlotOrientation orientation = xyPlot.getOrientation();
            if (orientation == PlotOrientation.HORIZONTAL) {
                deviationRenderer$State.lowerCoordinates.add(new double[] { valueToJava2D2, valueToJava2D });
                deviationRenderer$State.upperCoordinates.add(new double[] { valueToJava2D3, valueToJava2D });
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                deviationRenderer$State.lowerCoordinates.add(new double[] { valueToJava2D, valueToJava2D2 });
                deviationRenderer$State.upperCoordinates.add(new double[] { valueToJava2D, valueToJava2D3 });
            }
            if (n2 == xyDataset.getItemCount(n) - 1) {
                final Composite composite = graphics2D.getComposite();
                graphics2D.setComposite(AlphaComposite.getInstance(3, this.alpha));
                graphics2D.setPaint(this.getItemFillPaint(n, n2));
                final GeneralPath generalPath = new GeneralPath();
                final double[] array = deviationRenderer$State.lowerCoordinates.get(0);
                generalPath.moveTo((float)array[0], (float)array[1]);
                for (int i = 1; i < deviationRenderer$State.lowerCoordinates.size(); ++i) {
                    final double[] array2 = deviationRenderer$State.lowerCoordinates.get(i);
                    generalPath.lineTo((float)array2[0], (float)array2[1]);
                }
                final int size = deviationRenderer$State.upperCoordinates.size();
                final double[] array3 = deviationRenderer$State.upperCoordinates.get(size - 1);
                generalPath.lineTo((float)array3[0], (float)array3[1]);
                for (int j = size - 2; j >= 0; --j) {
                    final double[] array4 = deviationRenderer$State.upperCoordinates.get(j);
                    generalPath.lineTo((float)array4[0], (float)array4[1]);
                }
                generalPath.closePath();
                graphics2D.fill(generalPath);
                graphics2D.setComposite(composite);
                deviationRenderer$State.lowerCoordinates.clear();
                deviationRenderer$State.upperCoordinates.clear();
            }
        }
        if (this.isLinePass(n3)) {
            if (n2 == 0) {
                final DeviationRenderer$State deviationRenderer$State2 = (DeviationRenderer$State)xyItemRendererState;
                deviationRenderer$State2.seriesPath.reset();
                deviationRenderer$State2.setLastPointGood(false);
            }
            if (this.getItemLineVisible(n, n2)) {
                this.drawPrimaryLineAsPath(xyItemRendererState, graphics2D, xyPlot, xyDataset, n3, n, n2, valueAxis, valueAxis2, rectangle2D);
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
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof DeviationRenderer && this.alpha == ((DeviationRenderer)o).alpha && super.equals(o));
    }
}
