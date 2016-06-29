package org.jfree.chart.renderer.category;

import org.jfree.chart.event.*;
import org.jfree.data.category.*;
import org.jfree.data.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;

public interface CategoryItemRenderer extends LegendItemSource
{
    int getPassCount();
    
    CategoryPlot getPlot();
    
    void setPlot(final CategoryPlot p0);
    
    void addChangeListener(final RendererChangeListener p0);
    
    void removeChangeListener(final RendererChangeListener p0);
    
    Range findRangeBounds(final CategoryDataset p0);
    
    CategoryItemRendererState initialise(final Graphics2D p0, final Rectangle2D p1, final CategoryPlot p2, final int p3, final PlotRenderingInfo p4);
    
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
    
    void setPaint(final Paint p0);
    
    Paint getSeriesPaint(final int p0);
    
    void setSeriesPaint(final int p0, final Paint p1);
    
    Paint getBasePaint();
    
    void setBasePaint(final Paint p0);
    
    Paint getItemOutlinePaint(final int p0, final int p1);
    
    void setOutlinePaint(final Paint p0);
    
    Paint getSeriesOutlinePaint(final int p0);
    
    void setSeriesOutlinePaint(final int p0, final Paint p1);
    
    Paint getBaseOutlinePaint();
    
    void setBaseOutlinePaint(final Paint p0);
    
    Stroke getItemStroke(final int p0, final int p1);
    
    void setStroke(final Stroke p0);
    
    Stroke getSeriesStroke(final int p0);
    
    void setSeriesStroke(final int p0, final Stroke p1);
    
    Stroke getBaseStroke();
    
    void setBaseStroke(final Stroke p0);
    
    Stroke getItemOutlineStroke(final int p0, final int p1);
    
    void setOutlineStroke(final Stroke p0);
    
    Stroke getSeriesOutlineStroke(final int p0);
    
    void setSeriesOutlineStroke(final int p0, final Stroke p1);
    
    Stroke getBaseOutlineStroke();
    
    void setBaseOutlineStroke(final Stroke p0);
    
    Shape getItemShape(final int p0, final int p1);
    
    void setShape(final Shape p0);
    
    Shape getSeriesShape(final int p0);
    
    void setSeriesShape(final int p0, final Shape p1);
    
    Shape getBaseShape();
    
    void setBaseShape(final Shape p0);
    
    boolean isItemLabelVisible(final int p0, final int p1);
    
    void setItemLabelsVisible(final boolean p0);
    
    void setItemLabelsVisible(final Boolean p0);
    
    void setItemLabelsVisible(final Boolean p0, final boolean p1);
    
    boolean isSeriesItemLabelsVisible(final int p0);
    
    void setSeriesItemLabelsVisible(final int p0, final boolean p1);
    
    void setSeriesItemLabelsVisible(final int p0, final Boolean p1);
    
    void setSeriesItemLabelsVisible(final int p0, final Boolean p1, final boolean p2);
    
    Boolean getBaseItemLabelsVisible();
    
    void setBaseItemLabelsVisible(final boolean p0);
    
    void setBaseItemLabelsVisible(final Boolean p0);
    
    void setBaseItemLabelsVisible(final Boolean p0, final boolean p1);
    
    CategoryItemLabelGenerator getItemLabelGenerator(final int p0, final int p1);
    
    void setItemLabelGenerator(final CategoryItemLabelGenerator p0);
    
    CategoryItemLabelGenerator getSeriesItemLabelGenerator(final int p0);
    
    void setSeriesItemLabelGenerator(final int p0, final CategoryItemLabelGenerator p1);
    
    CategoryItemLabelGenerator getBaseItemLabelGenerator();
    
    void setBaseItemLabelGenerator(final CategoryItemLabelGenerator p0);
    
    CategoryToolTipGenerator getToolTipGenerator(final int p0, final int p1);
    
    CategoryToolTipGenerator getToolTipGenerator();
    
    void setToolTipGenerator(final CategoryToolTipGenerator p0);
    
    CategoryToolTipGenerator getSeriesToolTipGenerator(final int p0);
    
    void setSeriesToolTipGenerator(final int p0, final CategoryToolTipGenerator p1);
    
    CategoryToolTipGenerator getBaseToolTipGenerator();
    
    void setBaseToolTipGenerator(final CategoryToolTipGenerator p0);
    
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
    
    CategoryURLGenerator getItemURLGenerator(final int p0, final int p1);
    
    void setItemURLGenerator(final CategoryURLGenerator p0);
    
    CategoryURLGenerator getSeriesItemURLGenerator(final int p0);
    
    void setSeriesItemURLGenerator(final int p0, final CategoryURLGenerator p1);
    
    CategoryURLGenerator getBaseItemURLGenerator();
    
    void setBaseItemURLGenerator(final CategoryURLGenerator p0);
    
    LegendItem getLegendItem(final int p0, final int p1);
    
    void drawBackground(final Graphics2D p0, final CategoryPlot p1, final Rectangle2D p2);
    
    void drawOutline(final Graphics2D p0, final CategoryPlot p1, final Rectangle2D p2);
    
    void drawItem(final Graphics2D p0, final CategoryItemRendererState p1, final Rectangle2D p2, final CategoryPlot p3, final CategoryAxis p4, final ValueAxis p5, final CategoryDataset p6, final int p7, final int p8, final int p9);
    
    void drawDomainGridline(final Graphics2D p0, final CategoryPlot p1, final Rectangle2D p2, final double p3);
    
    void drawRangeGridline(final Graphics2D p0, final CategoryPlot p1, final ValueAxis p2, final Rectangle2D p3, final double p4);
    
    void drawDomainMarker(final Graphics2D p0, final CategoryPlot p1, final CategoryAxis p2, final CategoryMarker p3, final Rectangle2D p4);
    
    void drawRangeMarker(final Graphics2D p0, final CategoryPlot p1, final ValueAxis p2, final Marker p3, final Rectangle2D p4);
}
