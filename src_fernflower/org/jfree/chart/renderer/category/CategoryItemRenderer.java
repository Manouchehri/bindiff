package org.jfree.chart.renderer.category;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;

public interface CategoryItemRenderer extends LegendItemSource {
   int getPassCount();

   CategoryPlot getPlot();

   void setPlot(CategoryPlot var1);

   void addChangeListener(RendererChangeListener var1);

   void removeChangeListener(RendererChangeListener var1);

   Range findRangeBounds(CategoryDataset var1);

   CategoryItemRendererState initialise(Graphics2D var1, Rectangle2D var2, CategoryPlot var3, int var4, PlotRenderingInfo var5);

   boolean getItemVisible(int var1, int var2);

   boolean isSeriesVisible(int var1);

   Boolean getSeriesVisible();

   void setSeriesVisible(Boolean var1);

   void setSeriesVisible(Boolean var1, boolean var2);

   Boolean getSeriesVisible(int var1);

   void setSeriesVisible(int var1, Boolean var2);

   void setSeriesVisible(int var1, Boolean var2, boolean var3);

   boolean getBaseSeriesVisible();

   void setBaseSeriesVisible(boolean var1);

   void setBaseSeriesVisible(boolean var1, boolean var2);

   boolean isSeriesVisibleInLegend(int var1);

   Boolean getSeriesVisibleInLegend();

   void setSeriesVisibleInLegend(Boolean var1);

   void setSeriesVisibleInLegend(Boolean var1, boolean var2);

   Boolean getSeriesVisibleInLegend(int var1);

   void setSeriesVisibleInLegend(int var1, Boolean var2);

   void setSeriesVisibleInLegend(int var1, Boolean var2, boolean var3);

   boolean getBaseSeriesVisibleInLegend();

   void setBaseSeriesVisibleInLegend(boolean var1);

   void setBaseSeriesVisibleInLegend(boolean var1, boolean var2);

   Paint getItemPaint(int var1, int var2);

   void setPaint(Paint var1);

   Paint getSeriesPaint(int var1);

   void setSeriesPaint(int var1, Paint var2);

   Paint getBasePaint();

   void setBasePaint(Paint var1);

   Paint getItemOutlinePaint(int var1, int var2);

   void setOutlinePaint(Paint var1);

   Paint getSeriesOutlinePaint(int var1);

   void setSeriesOutlinePaint(int var1, Paint var2);

   Paint getBaseOutlinePaint();

   void setBaseOutlinePaint(Paint var1);

   Stroke getItemStroke(int var1, int var2);

   void setStroke(Stroke var1);

   Stroke getSeriesStroke(int var1);

   void setSeriesStroke(int var1, Stroke var2);

   Stroke getBaseStroke();

   void setBaseStroke(Stroke var1);

   Stroke getItemOutlineStroke(int var1, int var2);

   void setOutlineStroke(Stroke var1);

   Stroke getSeriesOutlineStroke(int var1);

   void setSeriesOutlineStroke(int var1, Stroke var2);

   Stroke getBaseOutlineStroke();

   void setBaseOutlineStroke(Stroke var1);

   Shape getItemShape(int var1, int var2);

   void setShape(Shape var1);

   Shape getSeriesShape(int var1);

   void setSeriesShape(int var1, Shape var2);

   Shape getBaseShape();

   void setBaseShape(Shape var1);

   boolean isItemLabelVisible(int var1, int var2);

   void setItemLabelsVisible(boolean var1);

   void setItemLabelsVisible(Boolean var1);

   void setItemLabelsVisible(Boolean var1, boolean var2);

   boolean isSeriesItemLabelsVisible(int var1);

   void setSeriesItemLabelsVisible(int var1, boolean var2);

   void setSeriesItemLabelsVisible(int var1, Boolean var2);

   void setSeriesItemLabelsVisible(int var1, Boolean var2, boolean var3);

   Boolean getBaseItemLabelsVisible();

   void setBaseItemLabelsVisible(boolean var1);

   void setBaseItemLabelsVisible(Boolean var1);

   void setBaseItemLabelsVisible(Boolean var1, boolean var2);

   CategoryItemLabelGenerator getItemLabelGenerator(int var1, int var2);

   void setItemLabelGenerator(CategoryItemLabelGenerator var1);

   CategoryItemLabelGenerator getSeriesItemLabelGenerator(int var1);

   void setSeriesItemLabelGenerator(int var1, CategoryItemLabelGenerator var2);

   CategoryItemLabelGenerator getBaseItemLabelGenerator();

   void setBaseItemLabelGenerator(CategoryItemLabelGenerator var1);

   CategoryToolTipGenerator getToolTipGenerator(int var1, int var2);

   CategoryToolTipGenerator getToolTipGenerator();

   void setToolTipGenerator(CategoryToolTipGenerator var1);

   CategoryToolTipGenerator getSeriesToolTipGenerator(int var1);

   void setSeriesToolTipGenerator(int var1, CategoryToolTipGenerator var2);

   CategoryToolTipGenerator getBaseToolTipGenerator();

   void setBaseToolTipGenerator(CategoryToolTipGenerator var1);

   Font getItemLabelFont(int var1, int var2);

   Font getItemLabelFont();

   void setItemLabelFont(Font var1);

   Font getSeriesItemLabelFont(int var1);

   void setSeriesItemLabelFont(int var1, Font var2);

   Font getBaseItemLabelFont();

   void setBaseItemLabelFont(Font var1);

   Paint getItemLabelPaint(int var1, int var2);

   Paint getItemLabelPaint();

   void setItemLabelPaint(Paint var1);

   Paint getSeriesItemLabelPaint(int var1);

   void setSeriesItemLabelPaint(int var1, Paint var2);

   Paint getBaseItemLabelPaint();

   void setBaseItemLabelPaint(Paint var1);

   ItemLabelPosition getPositiveItemLabelPosition(int var1, int var2);

   ItemLabelPosition getPositiveItemLabelPosition();

   void setPositiveItemLabelPosition(ItemLabelPosition var1);

   void setPositiveItemLabelPosition(ItemLabelPosition var1, boolean var2);

   ItemLabelPosition getSeriesPositiveItemLabelPosition(int var1);

   void setSeriesPositiveItemLabelPosition(int var1, ItemLabelPosition var2);

   void setSeriesPositiveItemLabelPosition(int var1, ItemLabelPosition var2, boolean var3);

   ItemLabelPosition getBasePositiveItemLabelPosition();

   void setBasePositiveItemLabelPosition(ItemLabelPosition var1);

   void setBasePositiveItemLabelPosition(ItemLabelPosition var1, boolean var2);

   ItemLabelPosition getNegativeItemLabelPosition(int var1, int var2);

   ItemLabelPosition getNegativeItemLabelPosition();

   void setNegativeItemLabelPosition(ItemLabelPosition var1);

   void setNegativeItemLabelPosition(ItemLabelPosition var1, boolean var2);

   ItemLabelPosition getSeriesNegativeItemLabelPosition(int var1);

   void setSeriesNegativeItemLabelPosition(int var1, ItemLabelPosition var2);

   void setSeriesNegativeItemLabelPosition(int var1, ItemLabelPosition var2, boolean var3);

   ItemLabelPosition getBaseNegativeItemLabelPosition();

   void setBaseNegativeItemLabelPosition(ItemLabelPosition var1);

   void setBaseNegativeItemLabelPosition(ItemLabelPosition var1, boolean var2);

   CategoryURLGenerator getItemURLGenerator(int var1, int var2);

   void setItemURLGenerator(CategoryURLGenerator var1);

   CategoryURLGenerator getSeriesItemURLGenerator(int var1);

   void setSeriesItemURLGenerator(int var1, CategoryURLGenerator var2);

   CategoryURLGenerator getBaseItemURLGenerator();

   void setBaseItemURLGenerator(CategoryURLGenerator var1);

   LegendItem getLegendItem(int var1, int var2);

   void drawBackground(Graphics2D var1, CategoryPlot var2, Rectangle2D var3);

   void drawOutline(Graphics2D var1, CategoryPlot var2, Rectangle2D var3);

   void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10);

   void drawDomainGridline(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, double var4);

   void drawRangeGridline(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Rectangle2D var4, double var5);

   void drawDomainMarker(Graphics2D var1, CategoryPlot var2, CategoryAxis var3, CategoryMarker var4, Rectangle2D var5);

   void drawRangeMarker(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5);
}
