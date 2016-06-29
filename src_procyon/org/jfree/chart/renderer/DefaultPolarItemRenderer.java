package org.jfree.chart.renderer;

import org.jfree.util.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.text.*;
import java.util.*;
import org.jfree.chart.axis.*;
import java.awt.geom.*;
import org.jfree.chart.*;

public class DefaultPolarItemRenderer extends AbstractRenderer implements PolarItemRenderer
{
    private PolarPlot plot;
    private BooleanList seriesFilled;
    
    public DefaultPolarItemRenderer() {
        this.seriesFilled = new BooleanList();
    }
    
    public void setPlot(final PolarPlot plot) {
        this.plot = plot;
    }
    
    public PolarPlot getPlot() {
        return this.plot;
    }
    
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        final PolarPlot plot = this.getPlot();
        if (plot != null) {
            drawingSupplier = plot.getDrawingSupplier();
        }
        return drawingSupplier;
    }
    
    public boolean isSeriesFilled(final int n) {
        boolean booleanValue = false;
        final Boolean boolean1 = this.seriesFilled.getBoolean(n);
        if (boolean1 != null) {
            booleanValue = boolean1;
        }
        return booleanValue;
    }
    
    public void setSeriesFilled(final int n, final boolean b) {
        this.seriesFilled.setBoolean(n, BooleanUtilities.valueOf(b));
    }
    
    public void drawSeries(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final PolarPlot polarPlot, final XYDataset xyDataset, final int n) {
        final Polygon polygon = new Polygon();
        for (int itemCount = xyDataset.getItemCount(n), i = 0; i < itemCount; ++i) {
            final Point translateValueThetaRadiusToJava2D = polarPlot.translateValueThetaRadiusToJava2D(xyDataset.getXValue(n, i), xyDataset.getYValue(n, i), rectangle2D);
            polygon.addPoint(translateValueThetaRadiusToJava2D.x, translateValueThetaRadiusToJava2D.y);
        }
        graphics2D.setPaint(this.getSeriesPaint(n));
        graphics2D.setStroke(this.getSeriesStroke(n));
        if (this.isSeriesFilled(n)) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.5f));
            graphics2D.fill(polygon);
            graphics2D.setComposite(composite);
        }
        else {
            graphics2D.draw(polygon);
        }
    }
    
    public void drawAngularGridLines(final Graphics2D graphics2D, final PolarPlot polarPlot, final List list, final Rectangle2D rectangle2D) {
        graphics2D.setFont(polarPlot.getAngleLabelFont());
        graphics2D.setStroke(polarPlot.getAngleGridlineStroke());
        graphics2D.setPaint(polarPlot.getAngleGridlinePaint());
        final double lowerBound = polarPlot.getAxis().getLowerBound();
        final double maxRadius = polarPlot.getMaxRadius();
        final Point translateValueThetaRadiusToJava2D = polarPlot.translateValueThetaRadiusToJava2D(lowerBound, lowerBound, rectangle2D);
        for (final NumberTick numberTick : list) {
            final Point translateValueThetaRadiusToJava2D2 = polarPlot.translateValueThetaRadiusToJava2D(numberTick.getNumber().doubleValue(), maxRadius, rectangle2D);
            graphics2D.setPaint(polarPlot.getAngleGridlinePaint());
            graphics2D.drawLine(translateValueThetaRadiusToJava2D.x, translateValueThetaRadiusToJava2D.y, translateValueThetaRadiusToJava2D2.x, translateValueThetaRadiusToJava2D2.y);
            if (polarPlot.isAngleLabelsVisible()) {
                final int x = translateValueThetaRadiusToJava2D2.x;
                final int y = translateValueThetaRadiusToJava2D2.y;
                graphics2D.setPaint(polarPlot.getAngleLabelPaint());
                TextUtilities.drawAlignedString(numberTick.getText(), graphics2D, x, y, TextAnchor.CENTER);
            }
        }
    }
    
    public void drawRadialGridLines(final Graphics2D graphics2D, final PolarPlot polarPlot, final ValueAxis valueAxis, final List list, final Rectangle2D rectangle2D) {
        graphics2D.setFont(valueAxis.getTickLabelFont());
        graphics2D.setPaint(polarPlot.getRadiusGridlinePaint());
        graphics2D.setStroke(polarPlot.getRadiusGridlineStroke());
        final double lowerBound = valueAxis.getLowerBound();
        final Point translateValueThetaRadiusToJava2D = polarPlot.translateValueThetaRadiusToJava2D(lowerBound, lowerBound, rectangle2D);
        final Iterator<NumberTick> iterator = list.iterator();
        while (iterator.hasNext()) {
            final int n = polarPlot.translateValueThetaRadiusToJava2D(90.0, iterator.next().getNumber().doubleValue(), rectangle2D).x - translateValueThetaRadiusToJava2D.x;
            final int n2 = translateValueThetaRadiusToJava2D.x - n;
            final int n3 = translateValueThetaRadiusToJava2D.y - n;
            final int n4 = 2 * n;
            final Ellipse2D.Double double1 = new Ellipse2D.Double(n2, n3, n4, n4);
            graphics2D.setPaint(polarPlot.getRadiusGridlinePaint());
            graphics2D.draw(double1);
        }
    }
    
    public LegendItem getLegendItem(final int n) {
        LegendItem legendItem = null;
        final PolarPlot plot = this.getPlot();
        if (plot != null) {
            final XYDataset dataset = plot.getDataset();
            if (dataset != null) {
                final String string = dataset.getSeriesKey(n).toString();
                legendItem = new LegendItem(string, string, null, null, this.getSeriesShape(n), this.getSeriesPaint(n), this.getSeriesOutlineStroke(n), this.getSeriesOutlinePaint(n));
            }
        }
        return legendItem;
    }
    
    public boolean equals(final Object o) {
        return o != null && o instanceof DefaultPolarItemRenderer && this.seriesFilled.equals(((DefaultPolarItemRenderer)o).seriesFilled) && super.equals(o);
    }
    
    public Object clone() {
        final DefaultPolarItemRenderer defaultPolarItemRenderer = (DefaultPolarItemRenderer)super.clone();
        defaultPolarItemRenderer.seriesFilled = (BooleanList)this.seriesFilled.clone();
        return defaultPolarItemRenderer;
    }
}
