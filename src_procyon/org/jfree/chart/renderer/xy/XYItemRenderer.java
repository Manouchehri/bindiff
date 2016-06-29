package org.jfree.chart.renderer.xy;

import java.awt.geom.*;
import org.jfree.data.xy.*;
import org.jfree.chart.urls.*;
import java.awt.*;
import org.jfree.chart.annotations.*;
import org.jfree.ui.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.chart.event.*;

public interface XYItemRenderer extends LegendItemSource
{
    XYItemRendererState initialise(final Graphics2D p0, final Rectangle2D p1, final XYPlot p2, final XYDataset p3, final PlotRenderingInfo p4);
    
    int getPassCount();
    
    boolean getItemVisible(final int p0, final int p1);
    
    boolean isSeriesVisible(final int p0);
    
    Boolean getSeriesVisible();
    
    void setSeriesVisible(final Boolean p0);
    
    void setSeriesVisible(final Boolean p0, final boolean p1);
    
    Boolean getSeriesVisible(final int p0);
    
    void setSeriesVisible(final int p0, final Boolean p1);
    
    void setSeriesVisible(final int p0, final Boolean p1, final boolean p2);
    
    boolean getBaseSeriesVisible();
    
    void setBaseSeriesVisible(final boolean p0);
    
    void setBaseSeriesVisible(final boolean p0, final boolean p1);
    
    boolean isSeriesVisibleInLegend(final int p0);
    
    Boolean getSeriesVisibleInLegend();
    
    void setSeriesVisibleInLegend(final Boolean p0);
    
    void setSeriesVisibleInLegend(final Boolean p0, final boolean p1);
    
    Boolean getSeriesVisibleInLegend(final int p0);
    
    void setSeriesVisibleInLegend(final int p0, final Boolean p1);
    
    void setSeriesVisibleInLegend(final int p0, final Boolean p1, final boolean p2);
    
    boolean getBaseSeriesVisibleInLegend();
    
    void setBaseSeriesVisibleInLegend(final boolean p0);
    
    void setBaseSeriesVisibleInLegend(final boolean p0, final boolean p1);
    
    Paint getItemPaint(final int p0, final int p1);
    
    Paint getSeriesPaint(final int p0);
    
    void setPaint(final Paint p0);
    
    void setSeriesPaint(final int p0, final Paint p1);
    
    Paint getBasePaint();
    
    void setBasePaint(final Paint p0);
    
    Paint getItemOutlinePaint(final int p0, final int p1);
    
    Paint getSeriesOutlinePaint(final int p0);
    
    void setSeriesOutlinePaint(final int p0, final Paint p1);
    
    void setOutlinePaint(final Paint p0);
    
    Paint getBaseOutlinePaint();
    
    void setBaseOutlinePaint(final Paint p0);
    
    Stroke getItemStroke(final int p0, final int p1);
    
    Stroke getSeriesStroke(final int p0);
    
    void setStroke(final Stroke p0);
    
    void setSeriesStroke(final int p0, final Stroke p1);
    
    Stroke getBaseStroke();
    
    void setBaseStroke(final Stroke p0);
    
    Stroke getItemOutlineStroke(final int p0, final int p1);
    
    Stroke getSeriesOutlineStroke(final int p0);
    
    void setOutlineStroke(final Stroke p0);
    
    void setSeriesOutlineStroke(final int p0, final Stroke p1);
    
    Stroke getBaseOutlineStroke();
    
    void setBaseOutlineStroke(final Stroke p0);
    
    Shape getItemShape(final int p0, final int p1);
    
    Shape getSeriesShape(final int p0);
    
    void setShape(final Shape p0);
    
    void setSeriesShape(final int p0, final Shape p1);
    
    Shape getBaseShape();
    
    void setBaseShape(final Shape p0);
    
    boolean isItemLabelVisible(final int p0, final int p1);
    
    boolean isSeriesItemLabelsVisible(final int p0);
    
    void setItemLabelsVisible(final boolean p0);
    
    void setItemLabelsVisible(final Boolean p0);
    
    void setItemLabelsVisible(final Boolean p0, final boolean p1);
    
    void setSeriesItemLabelsVisible(final int p0, final boolean p1);
    
    void setSeriesItemLabelsVisible(final int p0, final Boolean p1);
    
    void setSeriesItemLabelsVisible(final int p0, final Boolean p1, final boolean p2);
    
    Boolean getBaseItemLabelsVisible();
    
    void setBaseItemLabelsVisible(final boolean p0);
    
    void setBaseItemLabelsVisible(final Boolean p0);
    
    void setBaseItemLabelsVisible(final Boolean p0, final boolean p1);
    
    XYItemLabelGenerator getItemLabelGenerator(final int p0, final int p1);
    
    XYItemLabelGenerator getSeriesItemLabelGenerator(final int p0);
    
    void setItemLabelGenerator(final XYItemLabelGenerator p0);
    
    void setSeriesItemLabelGenerator(final int p0, final XYItemLabelGenerator p1);
    
    XYItemLabelGenerator getBaseItemLabelGenerator();
    
    void setBaseItemLabelGenerator(final XYItemLabelGenerator p0);
    
    XYToolTipGenerator getToolTipGenerator(final int p0, final int p1);
    
    XYToolTipGenerator getSeriesToolTipGenerator(final int p0);
    
    void setToolTipGenerator(final XYToolTipGenerator p0);
    
    void setSeriesToolTipGenerator(final int p0, final XYToolTipGenerator p1);
    
    XYToolTipGenerator getBaseToolTipGenerator();
    
    void setBaseToolTipGenerator(final XYToolTipGenerator p0);
    
    XYURLGenerator getURLGenerator();
    
    void setURLGenerator(final XYURLGenerator p0);
    
    Font getItemLabelFont(final int p0, final int p1);
    
    Font getItemLabelFont();
    
    void setItemLabelFont(final Font p0);
    
    Font getSeriesItemLabelFont(final int p0);
    
    void setSeriesItemLabelFont(final int p0, final Font p1);
    
    Font getBaseItemLabelFont();
    
    void setBaseItemLabelFont(final Font p0);
    
    Paint getItemLabelPaint(final int p0, final int p1);
    
    Paint getItemLabelPaint();
    
    void setItemLabelPaint(final Paint p0);
    
    Paint getSeriesItemLabelPaint(final int p0);
    
    void setSeriesItemLabelPaint(final int p0, final Paint p1);
    
    Paint getBaseItemLabelPaint();
    
    void setBaseItemLabelPaint(final Paint p0);
    
    ItemLabelPosition getPositiveItemLabelPosition(final int p0, final int p1);
    
    ItemLabelPosition getPositiveItemLabelPosition();
    
    void setPositiveItemLabelPosition(final ItemLabelPosition p0);
    
    void setPositiveItemLabelPosition(final ItemLabelPosition p0, final boolean p1);
    
    ItemLabelPosition getSeriesPositiveItemLabelPosition(final int p0);
    
    void setSeriesPositiveItemLabelPosition(final int p0, final ItemLabelPosition p1);
    
    void setSeriesPositiveItemLabelPosition(final int p0, final ItemLabelPosition p1, final boolean p2);
    
    ItemLabelPosition getBasePositiveItemLabelPosition();
    
    void setBasePositiveItemLabelPosition(final ItemLabelPosition p0);
    
    void setBasePositiveItemLabelPosition(final ItemLabelPosition p0, final boolean p1);
    
    ItemLabelPosition getNegativeItemLabelPosition(final int p0, final int p1);
    
    ItemLabelPosition getNegativeItemLabelPosition();
    
    void setNegativeItemLabelPosition(final ItemLabelPosition p0);
    
    void setNegativeItemLabelPosition(final ItemLabelPosition p0, final boolean p1);
    
    ItemLabelPosition getSeriesNegativeItemLabelPosition(final int p0);
    
    void setSeriesNegativeItemLabelPosition(final int p0, final ItemLabelPosition p1);
    
    void setSeriesNegativeItemLabelPosition(final int p0, final ItemLabelPosition p1, final boolean p2);
    
    ItemLabelPosition getBaseNegativeItemLabelPosition();
    
    void setBaseNegativeItemLabelPosition(final ItemLabelPosition p0);
    
    void setBaseNegativeItemLabelPosition(final ItemLabelPosition p0, final boolean p1);
    
    void addAnnotation(final XYAnnotation p0);
    
    void addAnnotation(final XYAnnotation p0, final Layer p1);
    
    boolean removeAnnotation(final XYAnnotation p0);
    
    void removeAnnotations();
    
    void drawAnnotations(final Graphics2D p0, final Rectangle2D p1, final ValueAxis p2, final ValueAxis p3, final Layer p4, final PlotRenderingInfo p5);
    
    void drawItem(final Graphics2D p0, final XYItemRendererState p1, final Rectangle2D p2, final PlotRenderingInfo p3, final XYPlot p4, final ValueAxis p5, final ValueAxis p6, final XYDataset p7, final int p8, final int p9, final CrosshairState p10, final int p11);
    
    LegendItem getLegendItem(final int p0, final int p1);
    
    XYSeriesLabelGenerator getLegendItemLabelGenerator();
    
    void setLegendItemLabelGenerator(final XYSeriesLabelGenerator p0);
    
    void fillDomainGridBand(final Graphics2D p0, final XYPlot p1, final ValueAxis p2, final Rectangle2D p3, final double p4, final double p5);
    
    void fillRangeGridBand(final Graphics2D p0, final XYPlot p1, final ValueAxis p2, final Rectangle2D p3, final double p4, final double p5);
    
    void drawDomainGridLine(final Graphics2D p0, final XYPlot p1, final ValueAxis p2, final Rectangle2D p3, final double p4);
    
    void drawRangeLine(final Graphics2D p0, final XYPlot p1, final ValueAxis p2, final Rectangle2D p3, final double p4, final Paint p5, final Stroke p6);
    
    void drawDomainMarker(final Graphics2D p0, final XYPlot p1, final ValueAxis p2, final Marker p3, final Rectangle2D p4);
    
    void drawRangeMarker(final Graphics2D p0, final XYPlot p1, final ValueAxis p2, final Marker p3, final Rectangle2D p4);
    
    XYPlot getPlot();
    
    void setPlot(final XYPlot p0);
    
    Range findDomainBounds(final XYDataset p0);
    
    Range findRangeBounds(final XYDataset p0);
    
    void addChangeListener(final RendererChangeListener p0);
    
    void removeChangeListener(final RendererChangeListener p0);
}
