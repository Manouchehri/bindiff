/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.Layer;

public interface XYItemRenderer
extends LegendItemSource {
    public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5);

    public int getPassCount();

    public boolean getItemVisible(int var1, int var2);

    public boolean isSeriesVisible(int var1);

    public Boolean getSeriesVisible();

    public void setSeriesVisible(Boolean var1);

    public void setSeriesVisible(Boolean var1, boolean var2);

    public Boolean getSeriesVisible(int var1);

    public void setSeriesVisible(int var1, Boolean var2);

    public void setSeriesVisible(int var1, Boolean var2, boolean var3);

    public boolean getBaseSeriesVisible();

    public void setBaseSeriesVisible(boolean var1);

    public void setBaseSeriesVisible(boolean var1, boolean var2);

    public boolean isSeriesVisibleInLegend(int var1);

    public Boolean getSeriesVisibleInLegend();

    public void setSeriesVisibleInLegend(Boolean var1);

    public void setSeriesVisibleInLegend(Boolean var1, boolean var2);

    public Boolean getSeriesVisibleInLegend(int var1);

    public void setSeriesVisibleInLegend(int var1, Boolean var2);

    public void setSeriesVisibleInLegend(int var1, Boolean var2, boolean var3);

    public boolean getBaseSeriesVisibleInLegend();

    public void setBaseSeriesVisibleInLegend(boolean var1);

    public void setBaseSeriesVisibleInLegend(boolean var1, boolean var2);

    public Paint getItemPaint(int var1, int var2);

    public Paint getSeriesPaint(int var1);

    public void setPaint(Paint var1);

    public void setSeriesPaint(int var1, Paint var2);

    public Paint getBasePaint();

    public void setBasePaint(Paint var1);

    public Paint getItemOutlinePaint(int var1, int var2);

    public Paint getSeriesOutlinePaint(int var1);

    public void setSeriesOutlinePaint(int var1, Paint var2);

    public void setOutlinePaint(Paint var1);

    public Paint getBaseOutlinePaint();

    public void setBaseOutlinePaint(Paint var1);

    public Stroke getItemStroke(int var1, int var2);

    public Stroke getSeriesStroke(int var1);

    public void setStroke(Stroke var1);

    public void setSeriesStroke(int var1, Stroke var2);

    public Stroke getBaseStroke();

    public void setBaseStroke(Stroke var1);

    public Stroke getItemOutlineStroke(int var1, int var2);

    public Stroke getSeriesOutlineStroke(int var1);

    public void setOutlineStroke(Stroke var1);

    public void setSeriesOutlineStroke(int var1, Stroke var2);

    public Stroke getBaseOutlineStroke();

    public void setBaseOutlineStroke(Stroke var1);

    public Shape getItemShape(int var1, int var2);

    public Shape getSeriesShape(int var1);

    public void setShape(Shape var1);

    public void setSeriesShape(int var1, Shape var2);

    public Shape getBaseShape();

    public void setBaseShape(Shape var1);

    public boolean isItemLabelVisible(int var1, int var2);

    public boolean isSeriesItemLabelsVisible(int var1);

    public void setItemLabelsVisible(boolean var1);

    public void setItemLabelsVisible(Boolean var1);

    public void setItemLabelsVisible(Boolean var1, boolean var2);

    public void setSeriesItemLabelsVisible(int var1, boolean var2);

    public void setSeriesItemLabelsVisible(int var1, Boolean var2);

    public void setSeriesItemLabelsVisible(int var1, Boolean var2, boolean var3);

    public Boolean getBaseItemLabelsVisible();

    public void setBaseItemLabelsVisible(boolean var1);

    public void setBaseItemLabelsVisible(Boolean var1);

    public void setBaseItemLabelsVisible(Boolean var1, boolean var2);

    public XYItemLabelGenerator getItemLabelGenerator(int var1, int var2);

    public XYItemLabelGenerator getSeriesItemLabelGenerator(int var1);

    public void setItemLabelGenerator(XYItemLabelGenerator var1);

    public void setSeriesItemLabelGenerator(int var1, XYItemLabelGenerator var2);

    public XYItemLabelGenerator getBaseItemLabelGenerator();

    public void setBaseItemLabelGenerator(XYItemLabelGenerator var1);

    public XYToolTipGenerator getToolTipGenerator(int var1, int var2);

    public XYToolTipGenerator getSeriesToolTipGenerator(int var1);

    public void setToolTipGenerator(XYToolTipGenerator var1);

    public void setSeriesToolTipGenerator(int var1, XYToolTipGenerator var2);

    public XYToolTipGenerator getBaseToolTipGenerator();

    public void setBaseToolTipGenerator(XYToolTipGenerator var1);

    public XYURLGenerator getURLGenerator();

    public void setURLGenerator(XYURLGenerator var1);

    public Font getItemLabelFont(int var1, int var2);

    public Font getItemLabelFont();

    public void setItemLabelFont(Font var1);

    public Font getSeriesItemLabelFont(int var1);

    public void setSeriesItemLabelFont(int var1, Font var2);

    public Font getBaseItemLabelFont();

    public void setBaseItemLabelFont(Font var1);

    public Paint getItemLabelPaint(int var1, int var2);

    public Paint getItemLabelPaint();

    public void setItemLabelPaint(Paint var1);

    public Paint getSeriesItemLabelPaint(int var1);

    public void setSeriesItemLabelPaint(int var1, Paint var2);

    public Paint getBaseItemLabelPaint();

    public void setBaseItemLabelPaint(Paint var1);

    public ItemLabelPosition getPositiveItemLabelPosition(int var1, int var2);

    public ItemLabelPosition getPositiveItemLabelPosition();

    public void setPositiveItemLabelPosition(ItemLabelPosition var1);

    public void setPositiveItemLabelPosition(ItemLabelPosition var1, boolean var2);

    public ItemLabelPosition getSeriesPositiveItemLabelPosition(int var1);

    public void setSeriesPositiveItemLabelPosition(int var1, ItemLabelPosition var2);

    public void setSeriesPositiveItemLabelPosition(int var1, ItemLabelPosition var2, boolean var3);

    public ItemLabelPosition getBasePositiveItemLabelPosition();

    public void setBasePositiveItemLabelPosition(ItemLabelPosition var1);

    public void setBasePositiveItemLabelPosition(ItemLabelPosition var1, boolean var2);

    public ItemLabelPosition getNegativeItemLabelPosition(int var1, int var2);

    public ItemLabelPosition getNegativeItemLabelPosition();

    public void setNegativeItemLabelPosition(ItemLabelPosition var1);

    public void setNegativeItemLabelPosition(ItemLabelPosition var1, boolean var2);

    public ItemLabelPosition getSeriesNegativeItemLabelPosition(int var1);

    public void setSeriesNegativeItemLabelPosition(int var1, ItemLabelPosition var2);

    public void setSeriesNegativeItemLabelPosition(int var1, ItemLabelPosition var2, boolean var3);

    public ItemLabelPosition getBaseNegativeItemLabelPosition();

    public void setBaseNegativeItemLabelPosition(ItemLabelPosition var1);

    public void setBaseNegativeItemLabelPosition(ItemLabelPosition var1, boolean var2);

    public void addAnnotation(XYAnnotation var1);

    public void addAnnotation(XYAnnotation var1, Layer var2);

    public boolean removeAnnotation(XYAnnotation var1);

    public void removeAnnotations();

    public void drawAnnotations(Graphics2D var1, Rectangle2D var2, ValueAxis var3, ValueAxis var4, Layer var5, PlotRenderingInfo var6);

    public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12);

    public LegendItem getLegendItem(int var1, int var2);

    public XYSeriesLabelGenerator getLegendItemLabelGenerator();

    public void setLegendItemLabelGenerator(XYSeriesLabelGenerator var1);

    public void fillDomainGridBand(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, double var7);

    public void fillRangeGridBand(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, double var7);

    public void drawDomainGridLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5);

    public void drawRangeLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, Paint var7, Stroke var8);

    public void drawDomainMarker(Graphics2D var1, XYPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5);

    public void drawRangeMarker(Graphics2D var1, XYPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5);

    public XYPlot getPlot();

    public void setPlot(XYPlot var1);

    public Range findDomainBounds(XYDataset var1);

    public Range findRangeBounds(XYDataset var1);

    public void addChangeListener(RendererChangeListener var1);

    public void removeChangeListener(RendererChangeListener var1);
}

