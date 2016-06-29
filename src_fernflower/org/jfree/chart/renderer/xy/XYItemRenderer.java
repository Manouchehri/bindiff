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

public interface XYItemRenderer extends LegendItemSource {
   XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5);

   int getPassCount();

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

   Paint getSeriesPaint(int var1);

   void setPaint(Paint var1);

   void setSeriesPaint(int var1, Paint var2);

   Paint getBasePaint();

   void setBasePaint(Paint var1);

   Paint getItemOutlinePaint(int var1, int var2);

   Paint getSeriesOutlinePaint(int var1);

   void setSeriesOutlinePaint(int var1, Paint var2);

   void setOutlinePaint(Paint var1);

   Paint getBaseOutlinePaint();

   void setBaseOutlinePaint(Paint var1);

   Stroke getItemStroke(int var1, int var2);

   Stroke getSeriesStroke(int var1);

   void setStroke(Stroke var1);

   void setSeriesStroke(int var1, Stroke var2);

   Stroke getBaseStroke();

   void setBaseStroke(Stroke var1);

   Stroke getItemOutlineStroke(int var1, int var2);

   Stroke getSeriesOutlineStroke(int var1);

   void setOutlineStroke(Stroke var1);

   void setSeriesOutlineStroke(int var1, Stroke var2);

   Stroke getBaseOutlineStroke();

   void setBaseOutlineStroke(Stroke var1);

   Shape getItemShape(int var1, int var2);

   Shape getSeriesShape(int var1);

   void setShape(Shape var1);

   void setSeriesShape(int var1, Shape var2);

   Shape getBaseShape();

   void setBaseShape(Shape var1);

   boolean isItemLabelVisible(int var1, int var2);

   boolean isSeriesItemLabelsVisible(int var1);

   void setItemLabelsVisible(boolean var1);

   void setItemLabelsVisible(Boolean var1);

   void setItemLabelsVisible(Boolean var1, boolean var2);

   void setSeriesItemLabelsVisible(int var1, boolean var2);

   void setSeriesItemLabelsVisible(int var1, Boolean var2);

   void setSeriesItemLabelsVisible(int var1, Boolean var2, boolean var3);

   Boolean getBaseItemLabelsVisible();

   void setBaseItemLabelsVisible(boolean var1);

   void setBaseItemLabelsVisible(Boolean var1);

   void setBaseItemLabelsVisible(Boolean var1, boolean var2);

   XYItemLabelGenerator getItemLabelGenerator(int var1, int var2);

   XYItemLabelGenerator getSeriesItemLabelGenerator(int var1);

   void setItemLabelGenerator(XYItemLabelGenerator var1);

   void setSeriesItemLabelGenerator(int var1, XYItemLabelGenerator var2);

   XYItemLabelGenerator getBaseItemLabelGenerator();

   void setBaseItemLabelGenerator(XYItemLabelGenerator var1);

   XYToolTipGenerator getToolTipGenerator(int var1, int var2);

   XYToolTipGenerator getSeriesToolTipGenerator(int var1);

   void setToolTipGenerator(XYToolTipGenerator var1);

   void setSeriesToolTipGenerator(int var1, XYToolTipGenerator var2);

   XYToolTipGenerator getBaseToolTipGenerator();

   void setBaseToolTipGenerator(XYToolTipGenerator var1);

   XYURLGenerator getURLGenerator();

   void setURLGenerator(XYURLGenerator var1);

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

   void addAnnotation(XYAnnotation var1);

   void addAnnotation(XYAnnotation var1, Layer var2);

   boolean removeAnnotation(XYAnnotation var1);

   void removeAnnotations();

   void drawAnnotations(Graphics2D var1, Rectangle2D var2, ValueAxis var3, ValueAxis var4, Layer var5, PlotRenderingInfo var6);

   void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12);

   LegendItem getLegendItem(int var1, int var2);

   XYSeriesLabelGenerator getLegendItemLabelGenerator();

   void setLegendItemLabelGenerator(XYSeriesLabelGenerator var1);

   void fillDomainGridBand(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, double var7);

   void fillRangeGridBand(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, double var7);

   void drawDomainGridLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5);

   void drawRangeLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, Paint var7, Stroke var8);

   void drawDomainMarker(Graphics2D var1, XYPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5);

   void drawRangeMarker(Graphics2D var1, XYPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5);

   XYPlot getPlot();

   void setPlot(XYPlot var1);

   Range findDomainBounds(XYDataset var1);

   Range findRangeBounds(XYDataset var1);

   void addChangeListener(RendererChangeListener var1);

   void removeChangeListener(RendererChangeListener var1);
}
