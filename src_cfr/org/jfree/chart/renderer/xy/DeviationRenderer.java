/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer$State;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

public class DeviationRenderer
extends XYLineAndShapeRenderer {
    private float alpha;

    public DeviationRenderer() {
        this(true, true);
    }

    public DeviationRenderer(boolean bl2, boolean bl3) {
        super(bl2, bl3);
        super.setDrawSeriesLineAsPath(true);
        this.alpha = 0.5f;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float f2) {
        if (f2 < 0.0f) throw new IllegalArgumentException("Requires 'alpha' in the range 0.0 to 1.0.");
        if (f2 > 1.0f) {
            throw new IllegalArgumentException("Requires 'alpha' in the range 0.0 to 1.0.");
        }
        this.alpha = f2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void setDrawSeriesLineAsPath(boolean bl2) {
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        DeviationRenderer$State deviationRenderer$State = new DeviationRenderer$State(plotRenderingInfo);
        deviationRenderer$State.seriesPath = new GeneralPath();
        return deviationRenderer$State;
    }

    @Override
    public int getPassCount() {
        return 3;
    }

    @Override
    protected boolean isItemPass(int n2) {
        if (n2 != 2) return false;
        return true;
    }

    @Override
    protected boolean isLinePass(int n2) {
        if (n2 != 1) return false;
        return true;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        Object object;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        if (n4 == 0) {
            object = (IntervalXYDataset)xYDataset;
            DeviationRenderer$State deviationRenderer$State = (DeviationRenderer$State)xYItemRendererState;
            double d2 = object.getXValue(n2, n3);
            double d3 = object.getStartYValue(n2, n3);
            double d4 = object.getEndYValue(n2, n3);
            RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
            RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
            double d5 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
            double d6 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2);
            double d7 = valueAxis2.valueToJava2D(d4, rectangle2D, rectangleEdge2);
            PlotOrientation plotOrientation = xYPlot.getOrientation();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                deviationRenderer$State.lowerCoordinates.add(new double[]{d6, d5});
                deviationRenderer$State.upperCoordinates.add(new double[]{d7, d5});
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                deviationRenderer$State.lowerCoordinates.add(new double[]{d5, d6});
                deviationRenderer$State.upperCoordinates.add(new double[]{d5, d7});
            }
            if (n3 == xYDataset.getItemCount(n2) - 1) {
                int n5;
                Composite composite = graphics2D.getComposite();
                graphics2D.setComposite(AlphaComposite.getInstance(3, this.alpha));
                graphics2D.setPaint(this.getItemFillPaint(n2, n3));
                GeneralPath generalPath = new GeneralPath();
                double[] arrd = (double[])deviationRenderer$State.lowerCoordinates.get(0);
                generalPath.moveTo((float)arrd[0], (float)arrd[1]);
                for (n5 = 1; n5 < deviationRenderer$State.lowerCoordinates.size(); ++n5) {
                    arrd = (double[])deviationRenderer$State.lowerCoordinates.get(n5);
                    generalPath.lineTo((float)arrd[0], (float)arrd[1]);
                }
                n5 = deviationRenderer$State.upperCoordinates.size();
                arrd = (double[])deviationRenderer$State.upperCoordinates.get(n5 - 1);
                generalPath.lineTo((float)arrd[0], (float)arrd[1]);
                for (int i2 = n5 - 2; i2 >= 0; --i2) {
                    arrd = (double[])deviationRenderer$State.upperCoordinates.get(i2);
                    generalPath.lineTo((float)arrd[0], (float)arrd[1]);
                }
                generalPath.closePath();
                graphics2D.fill(generalPath);
                graphics2D.setComposite(composite);
                deviationRenderer$State.lowerCoordinates.clear();
                deviationRenderer$State.upperCoordinates.clear();
            }
        }
        if (this.isLinePass(n4)) {
            if (n3 == 0) {
                object = (DeviationRenderer$State)xYItemRendererState;
                object.seriesPath.reset();
                object.setLastPointGood(false);
            }
            if (!this.getItemLineVisible(n2, n3)) return;
            this.drawPrimaryLineAsPath(xYItemRendererState, graphics2D, xYPlot, xYDataset, n4, n2, n3, valueAxis, valueAxis2, rectangle2D);
            return;
        }
        if (!this.isItemPass(n4)) return;
        object = null;
        if (plotRenderingInfo != null) {
            object = plotRenderingInfo.getOwner().getEntityCollection();
        }
        this.drawSecondaryPass(graphics2D, xYPlot, xYDataset, n4, n2, n3, valueAxis, rectangle2D, valueAxis2, crosshairState, (EntityCollection)object);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DeviationRenderer)) {
            return false;
        }
        DeviationRenderer deviationRenderer = (DeviationRenderer)object;
        if (this.alpha == deviationRenderer.alpha) return super.equals(object);
        return false;
    }
}

