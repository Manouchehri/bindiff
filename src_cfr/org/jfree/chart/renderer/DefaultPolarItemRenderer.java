/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;

public class DefaultPolarItemRenderer
extends AbstractRenderer
implements PolarItemRenderer {
    private PolarPlot plot;
    private BooleanList seriesFilled = new BooleanList();

    @Override
    public void setPlot(PolarPlot polarPlot) {
        this.plot = polarPlot;
    }

    @Override
    public PolarPlot getPlot() {
        return this.plot;
    }

    @Override
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        PolarPlot polarPlot = this.getPlot();
        if (polarPlot == null) return drawingSupplier;
        return polarPlot.getDrawingSupplier();
    }

    public boolean isSeriesFilled(int n2) {
        boolean bl2 = false;
        Boolean bl3 = this.seriesFilled.getBoolean(n2);
        if (bl3 == null) return bl2;
        return bl3;
    }

    public void setSeriesFilled(int n2, boolean bl2) {
        this.seriesFilled.setBoolean(n2, BooleanUtilities.valueOf(bl2));
    }

    @Override
    public void drawSeries(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, PolarPlot polarPlot, XYDataset xYDataset, int n2) {
        Polygon polygon = new Polygon();
        int n3 = xYDataset.getItemCount(n2);
        for (int i2 = 0; i2 < n3; ++i2) {
            double d2 = xYDataset.getXValue(n2, i2);
            double d3 = xYDataset.getYValue(n2, i2);
            Point point = polarPlot.translateValueThetaRadiusToJava2D(d2, d3, rectangle2D);
            polygon.addPoint(point.x, point.y);
        }
        graphics2D.setPaint(this.getSeriesPaint(n2));
        graphics2D.setStroke(this.getSeriesStroke(n2));
        if (this.isSeriesFilled(n2)) {
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.5f));
            graphics2D.fill(polygon);
            graphics2D.setComposite(composite);
            return;
        }
        graphics2D.draw(polygon);
    }

    @Override
    public void drawAngularGridLines(Graphics2D graphics2D, PolarPlot polarPlot, List list, Rectangle2D rectangle2D) {
        graphics2D.setFont(polarPlot.getAngleLabelFont());
        graphics2D.setStroke(polarPlot.getAngleGridlineStroke());
        graphics2D.setPaint(polarPlot.getAngleGridlinePaint());
        double d2 = polarPlot.getAxis().getLowerBound();
        double d3 = polarPlot.getMaxRadius();
        Point point = polarPlot.translateValueThetaRadiusToJava2D(d2, d2, rectangle2D);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            NumberTick numberTick = (NumberTick)iterator.next();
            Point point2 = polarPlot.translateValueThetaRadiusToJava2D(numberTick.getNumber().doubleValue(), d3, rectangle2D);
            graphics2D.setPaint(polarPlot.getAngleGridlinePaint());
            graphics2D.drawLine(point.x, point.y, point2.x, point2.y);
            if (!polarPlot.isAngleLabelsVisible()) continue;
            int n2 = point2.x;
            int n3 = point2.y;
            graphics2D.setPaint(polarPlot.getAngleLabelPaint());
            TextUtilities.drawAlignedString(numberTick.getText(), graphics2D, n2, n3, TextAnchor.CENTER);
        }
    }

    @Override
    public void drawRadialGridLines(Graphics2D graphics2D, PolarPlot polarPlot, ValueAxis valueAxis, List list, Rectangle2D rectangle2D) {
        graphics2D.setFont(valueAxis.getTickLabelFont());
        graphics2D.setPaint(polarPlot.getRadiusGridlinePaint());
        graphics2D.setStroke(polarPlot.getRadiusGridlineStroke());
        double d2 = valueAxis.getLowerBound();
        Point point = polarPlot.translateValueThetaRadiusToJava2D(d2, d2, rectangle2D);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            NumberTick numberTick = (NumberTick)iterator.next();
            Point point2 = polarPlot.translateValueThetaRadiusToJava2D(90.0, numberTick.getNumber().doubleValue(), rectangle2D);
            int n2 = point2.x - point.x;
            int n3 = point.x - n2;
            int n4 = point.y - n2;
            int n5 = 2 * n2;
            Ellipse2D.Double double_ = new Ellipse2D.Double(n3, n4, n5, n5);
            graphics2D.setPaint(polarPlot.getRadiusGridlinePaint());
            graphics2D.draw(double_);
        }
    }

    @Override
    public LegendItem getLegendItem(int n2) {
        String string;
        LegendItem legendItem = null;
        PolarPlot polarPlot = this.getPlot();
        if (polarPlot == null) return legendItem;
        XYDataset xYDataset = polarPlot.getDataset();
        if (xYDataset == null) return legendItem;
        String string2 = string = xYDataset.getSeriesKey(n2).toString();
        Shape shape = this.getSeriesShape(n2);
        Paint paint = this.getSeriesPaint(n2);
        Paint paint2 = this.getSeriesOutlinePaint(n2);
        Stroke stroke = this.getSeriesOutlineStroke(n2);
        return new LegendItem(string, string2, null, null, shape, paint, stroke, paint2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof DefaultPolarItemRenderer)) {
            return false;
        }
        DefaultPolarItemRenderer defaultPolarItemRenderer = (DefaultPolarItemRenderer)object;
        if (this.seriesFilled.equals(defaultPolarItemRenderer.seriesFilled)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        DefaultPolarItemRenderer defaultPolarItemRenderer = (DefaultPolarItemRenderer)super.clone();
        defaultPolarItemRenderer.seriesFilled = (BooleanList)this.seriesFilled.clone();
        return defaultPolarItemRenderer;
    }
}

