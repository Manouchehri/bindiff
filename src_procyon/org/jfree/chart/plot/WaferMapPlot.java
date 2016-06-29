package org.jfree.chart.plot;

import java.io.*;
import java.util.*;
import org.jfree.chart.renderer.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import org.jfree.chart.*;
import org.jfree.chart.event.*;
import java.awt.*;

public class WaferMapPlot extends Plot implements Serializable, Cloneable, RendererChangeListener
{
    private static final long serialVersionUID = 4668320403707308155L;
    public static final Stroke DEFAULT_GRIDLINE_STROKE;
    public static final Paint DEFAULT_GRIDLINE_PAINT;
    public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
    public static final Stroke DEFAULT_CROSSHAIR_STROKE;
    public static final Paint DEFAULT_CROSSHAIR_PAINT;
    protected static ResourceBundle localizationResources;
    private PlotOrientation orientation;
    private WaferMapDataset dataset;
    private WaferMapRenderer renderer;
    
    public WaferMapPlot() {
        this(null);
    }
    
    public WaferMapPlot(final WaferMapDataset waferMapDataset) {
        this(waferMapDataset, null);
    }
    
    public WaferMapPlot(final WaferMapDataset dataset, final WaferMapRenderer renderer) {
        this.orientation = PlotOrientation.VERTICAL;
        this.dataset = dataset;
        if (dataset != null) {
            dataset.addChangeListener(this);
        }
        if ((this.renderer = renderer) != null) {
            renderer.setPlot(this);
            renderer.addChangeListener(this);
        }
    }
    
    public String getPlotType() {
        return "WMAP_Plot";
    }
    
    public WaferMapDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final WaferMapDataset dataset) {
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }
        if ((this.dataset = dataset) != null) {
            this.setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, dataset));
    }
    
    public void setRenderer(final WaferMapRenderer renderer) {
        if (this.renderer != null) {
            this.renderer.removeChangeListener(this);
        }
        if ((this.renderer = renderer) != null) {
            renderer.setPlot(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        final boolean b = plotArea.getWidth() <= 10.0;
        final boolean b2 = plotArea.getHeight() <= 10.0;
        if (b || b2) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        this.drawChipGrid(graphics2D, plotArea);
        this.drawWaferEdge(graphics2D, plotArea);
    }
    
    protected void drawChipGrid(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final Shape clip = graphics2D.getClip();
        graphics2D.setClip(this.getWaferEdge(rectangle2D));
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        int n = 35;
        int n2 = 20;
        double chipSpace = 1.0;
        if (this.dataset != null) {
            n = this.dataset.getMaxChipX() + 2;
            n2 = this.dataset.getMaxChipY() + 2;
            chipSpace = this.dataset.getChipSpace();
        }
        double x = rectangle2D.getX();
        double y = rectangle2D.getY();
        double n3 = 1.0;
        double n4 = 1.0;
        if (rectangle2D.getWidth() != rectangle2D.getHeight()) {
            double n5;
            double n6;
            if (rectangle2D.getWidth() > rectangle2D.getHeight()) {
                n5 = rectangle2D.getWidth();
                n6 = rectangle2D.getHeight();
            }
            else {
                n5 = rectangle2D.getHeight();
                n6 = rectangle2D.getWidth();
            }
            if (rectangle2D.getWidth() == n6) {
                y += (n5 - n6) / 2.0;
                n3 = (rectangle2D.getWidth() - (chipSpace * n - 1.0)) / n;
                n4 = (rectangle2D.getWidth() - (chipSpace * n2 - 1.0)) / n2;
            }
            else {
                x += (n5 - n6) / 2.0;
                n3 = (rectangle2D.getHeight() - (chipSpace * n - 1.0)) / n;
                n4 = (rectangle2D.getHeight() - (chipSpace * n2 - 1.0)) / n2;
            }
        }
        for (int i = 1; i <= n; ++i) {
            final double n7 = x - n3 + n3 * i + chipSpace * (i - 1);
            for (int j = 1; j <= n2; ++j) {
                double1.setFrame(n7, y - n4 + n4 * j + chipSpace * (j - 1), n3, n4);
                graphics2D.setColor(Color.white);
                if (this.dataset.getChipValue(i - 1, n2 - j - 1) != null) {
                    graphics2D.setPaint(this.renderer.getChipColor(this.dataset.getChipValue(i - 1, n2 - j - 1)));
                }
                graphics2D.fill(double1);
                graphics2D.setColor(Color.lightGray);
                graphics2D.draw(double1);
            }
        }
        graphics2D.setClip(clip);
    }
    
    protected Ellipse2D getWaferEdge(final Rectangle2D rectangle2D) {
        final Ellipse2D.Double double1 = new Ellipse2D.Double();
        double width = rectangle2D.getWidth();
        double x = rectangle2D.getX();
        double y = rectangle2D.getY();
        if (rectangle2D.getWidth() != rectangle2D.getHeight()) {
            double n;
            double n2;
            if (rectangle2D.getWidth() > rectangle2D.getHeight()) {
                n = rectangle2D.getWidth();
                n2 = rectangle2D.getHeight();
            }
            else {
                n = rectangle2D.getHeight();
                n2 = rectangle2D.getWidth();
            }
            width = n2;
            if (rectangle2D.getWidth() == n2) {
                y = rectangle2D.getY() + (n - n2) / 2.0;
            }
            else {
                x = rectangle2D.getX() + (n - n2) / 2.0;
            }
        }
        double1.setFrame(x, y, width, width);
        return double1;
    }
    
    protected void drawWaferEdge(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final Ellipse2D waferEdge = this.getWaferEdge(rectangle2D);
        graphics2D.setColor(Color.black);
        graphics2D.draw(waferEdge);
        final Rectangle2D frame = waferEdge.getFrame();
        final double n = frame.getWidth() * 0.04;
        Arc2D.Double double1;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            double1 = new Arc2D.Double(new Rectangle2D.Double(frame.getX() + frame.getWidth() - n / 2.0, frame.getY() + frame.getHeight() / 2.0 - n / 2.0, n, n), 90.0, 180.0, 0);
        }
        else {
            double1 = new Arc2D.Double(new Rectangle2D.Double(frame.getX() + frame.getWidth() / 2.0 - n / 2.0, frame.getY() + frame.getHeight() - n / 2.0, n, n), 0.0, 180.0, 0);
        }
        graphics2D.setColor(Color.white);
        graphics2D.fill(double1);
        graphics2D.setColor(Color.black);
        graphics2D.draw(double1);
    }
    
    public LegendItemCollection getLegendItems() {
        return this.renderer.getLegendCollection();
    }
    
    public void rendererChanged(final RendererChangeEvent rendererChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    static {
        DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[] { 2.0f, 2.0f }, 0.0f);
        DEFAULT_GRIDLINE_PAINT = Color.lightGray;
        DEFAULT_CROSSHAIR_STROKE = WaferMapPlot.DEFAULT_GRIDLINE_STROKE;
        DEFAULT_CROSSHAIR_PAINT = Color.blue;
        WaferMapPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
