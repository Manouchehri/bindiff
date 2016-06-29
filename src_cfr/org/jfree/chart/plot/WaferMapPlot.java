/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.ui.RectangleInsets;

public class WaferMapPlot
extends Plot
implements Serializable,
Cloneable,
RendererChangeListener {
    private static final long serialVersionUID = 4668320403707308155L;
    public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[]{2.0f, 2.0f}, 0.0f);
    public static final Paint DEFAULT_GRIDLINE_PAINT = Color.lightGray;
    public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
    public static final Stroke DEFAULT_CROSSHAIR_STROKE = DEFAULT_GRIDLINE_STROKE;
    public static final Paint DEFAULT_CROSSHAIR_PAINT = Color.blue;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    private PlotOrientation orientation = PlotOrientation.VERTICAL;
    private WaferMapDataset dataset;
    private WaferMapRenderer renderer;

    public WaferMapPlot() {
        this(null);
    }

    public WaferMapPlot(WaferMapDataset waferMapDataset) {
        this(waferMapDataset, null);
    }

    public WaferMapPlot(WaferMapDataset waferMapDataset, WaferMapRenderer waferMapRenderer) {
        this.dataset = waferMapDataset;
        if (waferMapDataset != null) {
            waferMapDataset.addChangeListener(this);
        }
        this.renderer = waferMapRenderer;
        if (waferMapRenderer == null) return;
        waferMapRenderer.setPlot(this);
        waferMapRenderer.addChangeListener(this);
    }

    @Override
    public String getPlotType() {
        return "WMAP_Plot";
    }

    public WaferMapDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(WaferMapDataset waferMapDataset) {
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }
        this.dataset = waferMapDataset;
        if (waferMapDataset != null) {
            this.setDatasetGroup(waferMapDataset.getGroup());
            waferMapDataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, waferMapDataset));
    }

    public void setRenderer(WaferMapRenderer waferMapRenderer) {
        if (this.renderer != null) {
            this.renderer.removeChangeListener(this);
        }
        this.renderer = waferMapRenderer;
        if (waferMapRenderer != null) {
            waferMapRenderer.setPlot(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        boolean bl2 = rectangle2D.getWidth() <= 10.0;
        if (rectangle2D.getHeight() > 10.0) return;
        boolean bl3 = true;
        boolean bl4 = bl3;
        if (bl2) return;
        if (bl4) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        this.drawChipGrid(graphics2D, rectangle2D);
        this.drawWaferEdge(graphics2D, rectangle2D);
    }

    protected void drawChipGrid(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Shape shape = graphics2D.getClip();
        graphics2D.setClip(this.getWaferEdge(rectangle2D));
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        int n2 = 35;
        int n3 = 20;
        double d2 = 1.0;
        if (this.dataset != null) {
            n2 = this.dataset.getMaxChipX() + 2;
            n3 = this.dataset.getMaxChipY() + 2;
            d2 = this.dataset.getChipSpace();
        }
        double d3 = rectangle2D.getX();
        double d4 = rectangle2D.getY();
        double d5 = 1.0;
        double d6 = 1.0;
        if (rectangle2D.getWidth() != rectangle2D.getHeight()) {
            double d7 = 0.0;
            double d8 = 0.0;
            if (rectangle2D.getWidth() > rectangle2D.getHeight()) {
                d7 = rectangle2D.getWidth();
                d8 = rectangle2D.getHeight();
            } else {
                d7 = rectangle2D.getHeight();
                d8 = rectangle2D.getWidth();
            }
            if (rectangle2D.getWidth() == d8) {
                d4 += (d7 - d8) / 2.0;
                d5 = (rectangle2D.getWidth() - (d2 * (double)n2 - 1.0)) / (double)n2;
                d6 = (rectangle2D.getWidth() - (d2 * (double)n3 - 1.0)) / (double)n3;
            } else {
                d3 += (d7 - d8) / 2.0;
                d5 = (rectangle2D.getHeight() - (d2 * (double)n2 - 1.0)) / (double)n2;
                d6 = (rectangle2D.getHeight() - (d2 * (double)n3 - 1.0)) / (double)n3;
            }
        }
        int n4 = 1;
        do {
            if (n4 > n2) {
                graphics2D.setClip(shape);
                return;
            }
            double d9 = d3 - d5 + d5 * (double)n4 + d2 * (double)(n4 - 1);
            for (int i2 = 1; i2 <= n3; ++i2) {
                double d10 = d4 - d6 + d6 * (double)i2 + d2 * (double)(i2 - 1);
                double_.setFrame(d9, d10, d5, d6);
                graphics2D.setColor(Color.white);
                if (this.dataset.getChipValue(n4 - 1, n3 - i2 - 1) != null) {
                    graphics2D.setPaint(this.renderer.getChipColor(this.dataset.getChipValue(n4 - 1, n3 - i2 - 1)));
                }
                graphics2D.fill(double_);
                graphics2D.setColor(Color.lightGray);
                graphics2D.draw(double_);
            }
            ++n4;
        } while (true);
    }

    protected Ellipse2D getWaferEdge(Rectangle2D rectangle2D) {
        Ellipse2D.Double double_ = new Ellipse2D.Double();
        double d2 = rectangle2D.getWidth();
        double d3 = rectangle2D.getX();
        double d4 = rectangle2D.getY();
        if (rectangle2D.getWidth() != rectangle2D.getHeight()) {
            double d5 = 0.0;
            double d6 = 0.0;
            if (rectangle2D.getWidth() > rectangle2D.getHeight()) {
                d5 = rectangle2D.getWidth();
                d6 = rectangle2D.getHeight();
            } else {
                d5 = rectangle2D.getHeight();
                d6 = rectangle2D.getWidth();
            }
            d2 = d6;
            if (rectangle2D.getWidth() == d6) {
                d4 = rectangle2D.getY() + (d5 - d6) / 2.0;
            } else {
                d3 = rectangle2D.getX() + (d5 - d6) / 2.0;
            }
        }
        double_.setFrame(d3, d4, d2, d2);
        return double_;
    }

    protected void drawWaferEdge(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Ellipse2D ellipse2D = this.getWaferEdge(rectangle2D);
        graphics2D.setColor(Color.black);
        graphics2D.draw(ellipse2D);
        Arc2D.Double double_ = null;
        Rectangle2D rectangle2D2 = ellipse2D.getFrame();
        double d2 = rectangle2D2.getWidth() * 0.04;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            Rectangle2D.Double double_2 = new Rectangle2D.Double(rectangle2D2.getX() + rectangle2D2.getWidth() - d2 / 2.0, rectangle2D2.getY() + rectangle2D2.getHeight() / 2.0 - d2 / 2.0, d2, d2);
            double_ = new Arc2D.Double(double_2, 90.0, 180.0, 0);
        } else {
            Rectangle2D.Double double_3 = new Rectangle2D.Double(rectangle2D2.getX() + rectangle2D2.getWidth() / 2.0 - d2 / 2.0, rectangle2D2.getY() + rectangle2D2.getHeight() - d2 / 2.0, d2, d2);
            double_ = new Arc2D.Double(double_3, 0.0, 180.0, 0);
        }
        graphics2D.setColor(Color.white);
        graphics2D.fill(double_);
        graphics2D.setColor(Color.black);
        graphics2D.draw(double_);
    }

    @Override
    public LegendItemCollection getLegendItems() {
        return this.renderer.getLegendCollection();
    }

    @Override
    public void rendererChanged(RendererChangeEvent rendererChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
}

