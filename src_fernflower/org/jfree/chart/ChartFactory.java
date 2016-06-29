package org.jfree.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.Timeline;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;
import org.jfree.util.TableOrder;

public abstract class ChartFactory {
   public static JFreeChart createPieChart(String var0, PieDataset var1, boolean var2, boolean var3, boolean var4) {
      PiePlot var5 = new PiePlot(var1);
      var5.setLabelGenerator(new StandardPieSectionLabelGenerator());
      var5.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
      if(var3) {
         var5.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
      }

      if(var4) {
         var5.setURLGenerator(new StandardPieURLGenerator());
      }

      return new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var5, var2);
   }

   public static JFreeChart createPieChart(String var0, PieDataset var1, PieDataset var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9) {
      PiePlot var10 = new PiePlot(var1);
      var10.setLabelGenerator(new StandardPieSectionLabelGenerator());
      var10.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
      if(var6) {
         var10.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
      }

      if(var7) {
         var10.setURLGenerator(new StandardPieURLGenerator());
      }

      List var11 = var1.getKeys();
      DefaultPieDataset var12 = null;
      if(var9) {
         var12 = new DefaultPieDataset();
      }

      double var13 = 255.0D / (double)var3;
      Iterator var15 = var11.iterator();

      while(true) {
         Comparable var16;
         while(var15.hasNext()) {
            var16 = (Comparable)var15.next();
            Number var17 = var1.getValue(var16);
            Number var18 = var2.getValue(var16);
            if(var18 == null) {
               if(var4) {
                  var10.setSectionPaint(var16, Color.green);
               } else {
                  var10.setSectionPaint(var16, Color.red);
               }

               if(var9) {
                  var12.setValue(var16 + " (+100%)", var17);
               }
            } else {
               double var19 = (var17.doubleValue() / var18.doubleValue() - 1.0D) * 100.0D;
               double var21 = Math.abs(var19) >= (double)var3?255.0D:Math.abs(var19) * var13;
               if((!var4 || var17.doubleValue() <= var18.doubleValue()) && (var4 || var17.doubleValue() >= var18.doubleValue())) {
                  var10.setSectionPaint(var16, new Color((int)var21, 0, 0));
               } else {
                  var10.setSectionPaint(var16, new Color(0, (int)var21, 0));
               }

               if(var9) {
                  var12.setValue(var16 + " (" + (var19 >= 0.0D?"+":"") + NumberFormat.getPercentInstance().format(var19 / 100.0D) + ")", var17);
               }
            }
         }

         if(var9) {
            var10.setDataset(var12);
         }

         JFreeChart var23 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var10, var5);
         if(var8) {
            var16 = null;
            TextTitle var24 = new TextTitle("Bright " + (var4?"red":"green") + "=change >=-" + var3 + "%, Bright " + (!var4?"red":"green") + "=change >=+" + var3 + "%", new Font("SansSerif", 0, 10));
            var23.addSubtitle(var24);
         }

         return var23;
      }
   }

   public static JFreeChart createRingChart(String var0, PieDataset var1, boolean var2, boolean var3, boolean var4) {
      RingPlot var5 = new RingPlot(var1);
      var5.setLabelGenerator(new StandardPieSectionLabelGenerator());
      var5.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
      if(var3) {
         var5.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
      }

      if(var4) {
         var5.setURLGenerator(new StandardPieURLGenerator());
      }

      return new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var5, var2);
   }

   public static JFreeChart createMultiplePieChart(String var0, CategoryDataset var1, TableOrder var2, boolean var3, boolean var4, boolean var5) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         MultiplePiePlot var6 = new MultiplePiePlot(var1);
         var6.setDataExtractOrder(var2);
         var6.setBackgroundPaint((Paint)null);
         var6.setOutlineStroke((Stroke)null);
         PiePlot var8;
         if(var4) {
            StandardPieToolTipGenerator var7 = new StandardPieToolTipGenerator();
            var8 = (PiePlot)var6.getPieChart().getPlot();
            var8.setToolTipGenerator(var7);
         }

         if(var5) {
            StandardPieURLGenerator var9 = new StandardPieURLGenerator();
            var8 = (PiePlot)var6.getPieChart().getPlot();
            var8.setURLGenerator(var9);
         }

         JFreeChart var10 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var6, var3);
         return var10;
      }
   }

   public static JFreeChart createPieChart3D(String var0, PieDataset var1, boolean var2, boolean var3, boolean var4) {
      PiePlot3D var5 = new PiePlot3D(var1);
      var5.setInsets(new RectangleInsets(0.0D, 5.0D, 5.0D, 5.0D));
      if(var3) {
         var5.setToolTipGenerator(new StandardPieToolTipGenerator());
      }

      if(var4) {
         var5.setURLGenerator(new StandardPieURLGenerator());
      }

      return new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var5, var2);
   }

   public static JFreeChart createMultiplePieChart3D(String var0, CategoryDataset var1, TableOrder var2, boolean var3, boolean var4, boolean var5) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         MultiplePiePlot var6 = new MultiplePiePlot(var1);
         var6.setDataExtractOrder(var2);
         var6.setBackgroundPaint((Paint)null);
         var6.setOutlineStroke((Stroke)null);
         JFreeChart var7 = new JFreeChart(new PiePlot3D((PieDataset)null));
         TextTitle var8 = new TextTitle("Series Title", new Font("SansSerif", 1, 12));
         var8.setPosition(RectangleEdge.BOTTOM);
         var7.setTitle(var8);
         var7.removeLegend();
         var7.setBackgroundPaint((Paint)null);
         var6.setPieChart(var7);
         PiePlot var10;
         if(var4) {
            StandardPieToolTipGenerator var9 = new StandardPieToolTipGenerator();
            var10 = (PiePlot)var6.getPieChart().getPlot();
            var10.setToolTipGenerator(var9);
         }

         if(var5) {
            StandardPieURLGenerator var11 = new StandardPieURLGenerator();
            var10 = (PiePlot)var6.getPieChart().getPlot();
            var10.setURLGenerator(var11);
         }

         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var6, var3);
         return var12;
      }
   }

   public static JFreeChart createBarChart(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis var8 = new CategoryAxis(var1);
         NumberAxis var9 = new NumberAxis(var2);
         BarRenderer var10 = new BarRenderer();
         ItemLabelPosition var11;
         ItemLabelPosition var12;
         if(var4 == PlotOrientation.HORIZONTAL) {
            var11 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT);
            var10.setPositiveItemLabelPosition(var11);
            var12 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_RIGHT);
            var10.setNegativeItemLabelPosition(var12);
         } else if(var4 == PlotOrientation.VERTICAL) {
            var11 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
            var10.setPositiveItemLabelPosition(var11);
            var12 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
            var10.setNegativeItemLabelPosition(var12);
         }

         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var13 = new CategoryPlot(var3, var8, var9, var10);
         var13.setOrientation(var4);
         JFreeChart var14 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var13, var5);
         return var14;
      }
   }

   public static JFreeChart createStackedBarChart(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis var8 = new CategoryAxis(var1);
         NumberAxis var9 = new NumberAxis(var2);
         StackedBarRenderer var10 = new StackedBarRenderer();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createBarChart3D(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis3D var8 = new CategoryAxis3D(var1);
         NumberAxis3D var9 = new NumberAxis3D(var2);
         BarRenderer3D var10 = new BarRenderer3D();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         if(var4 == PlotOrientation.HORIZONTAL) {
            var11.setRowRenderingOrder(SortOrder.DESCENDING);
            var11.setColumnRenderingOrder(SortOrder.DESCENDING);
         }

         var11.setForegroundAlpha(0.75F);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createStackedBarChart3D(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis3D var8 = new CategoryAxis3D(var1);
         NumberAxis3D var9 = new NumberAxis3D(var2);
         StackedBarRenderer3D var10 = new StackedBarRenderer3D();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         if(var4 == PlotOrientation.HORIZONTAL) {
            var11.setColumnRenderingOrder(SortOrder.DESCENDING);
         }

         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createAreaChart(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis var8 = new CategoryAxis(var1);
         var8.setCategoryMargin(0.0D);
         NumberAxis var9 = new NumberAxis(var2);
         AreaRenderer var10 = new AreaRenderer();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createStackedAreaChart(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis var8 = new CategoryAxis(var1);
         NumberAxis var9 = new NumberAxis(var2);
         StackedAreaRenderer var10 = new StackedAreaRenderer();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createLineChart(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis var8 = new CategoryAxis(var1);
         NumberAxis var9 = new NumberAxis(var2);
         LineAndShapeRenderer var10 = new LineAndShapeRenderer(true, false);
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createLineChart3D(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis3D var8 = new CategoryAxis3D(var1);
         NumberAxis3D var9 = new NumberAxis3D(var2);
         LineRenderer3D var10 = new LineRenderer3D();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var11 = new CategoryPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createGanttChart(String var0, String var1, String var2, IntervalCategoryDataset var3, boolean var4, boolean var5, boolean var6) {
      CategoryAxis var7 = new CategoryAxis(var1);
      DateAxis var8 = new DateAxis(var2);
      GanttRenderer var9 = new GanttRenderer();
      if(var5) {
         var9.setBaseToolTipGenerator(new IntervalCategoryToolTipGenerator("{3} - {4}", DateFormat.getDateInstance()));
      }

      if(var6) {
         var9.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
      }

      CategoryPlot var10 = new CategoryPlot(var3, var7, var8, var9);
      var10.setOrientation(PlotOrientation.HORIZONTAL);
      JFreeChart var11 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var10, var4);
      return var11;
   }

   public static JFreeChart createWaterfallChart(String var0, String var1, String var2, CategoryDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         CategoryAxis var8 = new CategoryAxis(var1);
         var8.setCategoryMargin(0.0D);
         NumberAxis var9 = new NumberAxis(var2);
         WaterfallBarRenderer var10 = new WaterfallBarRenderer();
         ItemLabelPosition var11;
         if(var4 == PlotOrientation.HORIZONTAL) {
            var11 = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 1.5707963267948966D);
            var10.setPositiveItemLabelPosition(var11);
            var10.setNegativeItemLabelPosition(var11);
         } else if(var4 == PlotOrientation.VERTICAL) {
            var11 = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0D);
            var10.setPositiveItemLabelPosition(var11);
            var10.setNegativeItemLabelPosition(var11);
         }

         if(var6) {
            StandardCategoryToolTipGenerator var14 = new StandardCategoryToolTipGenerator();
            var10.setBaseToolTipGenerator(var14);
         }

         if(var7) {
            var10.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
         }

         CategoryPlot var15 = new CategoryPlot(var3, var8, var9, var10);
         var15.clearRangeMarkers();
         ValueMarker var12 = new ValueMarker(0.0D);
         var12.setPaint(Color.black);
         var15.addRangeMarker(var12, Layer.FOREGROUND);
         var15.setOrientation(var4);
         JFreeChart var13 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var15, var5);
         return var13;
      }
   }

   public static JFreeChart createPolarChart(String var0, XYDataset var1, boolean var2, boolean var3, boolean var4) {
      PolarPlot var5 = new PolarPlot();
      var5.setDataset(var1);
      NumberAxis var6 = new NumberAxis();
      var6.setAxisLineVisible(false);
      var6.setTickMarksVisible(false);
      var6.setTickLabelInsets(new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D));
      var5.setAxis(var6);
      var5.setRenderer(new DefaultPolarItemRenderer());
      JFreeChart var7 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var5, var2);
      return var7;
   }

   public static JFreeChart createScatterPlot(String var0, String var1, String var2, XYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         NumberAxis var9 = new NumberAxis(var2);
         var9.setAutoRangeIncludesZero(false);
         XYPlot var10 = new XYPlot(var3, var8, var9, (XYItemRenderer)null);
         StandardXYToolTipGenerator var11 = null;
         if(var6) {
            var11 = new StandardXYToolTipGenerator();
         }

         StandardXYURLGenerator var12 = null;
         if(var7) {
            var12 = new StandardXYURLGenerator();
         }

         XYLineAndShapeRenderer var13 = new XYLineAndShapeRenderer(false, true);
         var13.setBaseToolTipGenerator(var11);
         var13.setURLGenerator(var12);
         var10.setRenderer(var13);
         var10.setOrientation(var4);
         JFreeChart var14 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var10, var5);
         return var14;
      }
   }

   public static JFreeChart createXYBarChart(String var0, String var1, boolean var2, String var3, IntervalXYDataset var4, PlotOrientation var5, boolean var6, boolean var7, boolean var8) {
      if(var5 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         Object var9 = null;
         NumberAxis var10;
         if(var2) {
            var9 = new DateAxis(var1);
         } else {
            var10 = new NumberAxis(var1);
            var10.setAutoRangeIncludesZero(false);
            var9 = var10;
         }

         var10 = new NumberAxis(var3);
         XYBarRenderer var11 = new XYBarRenderer();
         if(var7) {
            StandardXYToolTipGenerator var12;
            if(var2) {
               var12 = StandardXYToolTipGenerator.getTimeSeriesInstance();
            } else {
               var12 = new StandardXYToolTipGenerator();
            }

            var11.setBaseToolTipGenerator(var12);
         }

         if(var8) {
            var11.setURLGenerator(new StandardXYURLGenerator());
         }

         XYPlot var14 = new XYPlot(var4, (ValueAxis)var9, var10, var11);
         var14.setOrientation(var5);
         JFreeChart var13 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var14, var6);
         return var13;
      }
   }

   public static JFreeChart createXYAreaChart(String var0, String var1, String var2, XYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         NumberAxis var9 = new NumberAxis(var2);
         XYPlot var10 = new XYPlot(var3, var8, var9, (XYItemRenderer)null);
         var10.setOrientation(var4);
         var10.setForegroundAlpha(0.5F);
         StandardXYToolTipGenerator var11 = null;
         if(var6) {
            var11 = new StandardXYToolTipGenerator();
         }

         StandardXYURLGenerator var12 = null;
         if(var7) {
            var12 = new StandardXYURLGenerator();
         }

         var10.setRenderer(new XYAreaRenderer(4, var11, var12));
         JFreeChart var13 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var10, var5);
         return var13;
      }
   }

   public static JFreeChart createStackedXYAreaChart(String var0, String var1, String var2, TableXYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         var8.setLowerMargin(0.0D);
         var8.setUpperMargin(0.0D);
         NumberAxis var9 = new NumberAxis(var2);
         StandardXYToolTipGenerator var10 = null;
         if(var6) {
            var10 = new StandardXYToolTipGenerator();
         }

         StandardXYURLGenerator var11 = null;
         if(var7) {
            var11 = new StandardXYURLGenerator();
         }

         StackedXYAreaRenderer2 var12 = new StackedXYAreaRenderer2(var10, var11);
         var12.setOutline(true);
         XYPlot var13 = new XYPlot(var3, var8, var9, var12);
         var13.setOrientation(var4);
         var13.setRangeAxis(var9);
         JFreeChart var14 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var13, var5);
         return var14;
      }
   }

   public static JFreeChart createXYLineChart(String var0, String var1, String var2, XYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         NumberAxis var9 = new NumberAxis(var2);
         XYLineAndShapeRenderer var10 = new XYLineAndShapeRenderer(true, false);
         XYPlot var11 = new XYPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
         }

         if(var7) {
            var10.setURLGenerator(new StandardXYURLGenerator());
         }

         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createXYStepChart(String var0, String var1, String var2, XYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         DateAxis var8 = new DateAxis(var1);
         NumberAxis var9 = new NumberAxis(var2);
         var9.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
         StandardXYToolTipGenerator var10 = null;
         if(var6) {
            var10 = new StandardXYToolTipGenerator();
         }

         StandardXYURLGenerator var11 = null;
         if(var7) {
            var11 = new StandardXYURLGenerator();
         }

         XYStepRenderer var12 = new XYStepRenderer(var10, var11);
         XYPlot var13 = new XYPlot(var3, var8, var9, (XYItemRenderer)null);
         var13.setRenderer(var12);
         var13.setOrientation(var4);
         var13.setDomainCrosshairVisible(false);
         var13.setRangeCrosshairVisible(false);
         JFreeChart var14 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var13, var5);
         return var14;
      }
   }

   public static JFreeChart createXYStepAreaChart(String var0, String var1, String var2, XYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         NumberAxis var9 = new NumberAxis(var2);
         StandardXYToolTipGenerator var10 = null;
         if(var6) {
            var10 = new StandardXYToolTipGenerator();
         }

         StandardXYURLGenerator var11 = null;
         if(var7) {
            var11 = new StandardXYURLGenerator();
         }

         XYStepAreaRenderer var12 = new XYStepAreaRenderer(3, var10, var11);
         XYPlot var13 = new XYPlot(var3, var8, var9, (XYItemRenderer)null);
         var13.setRenderer(var12);
         var13.setOrientation(var4);
         var13.setDomainCrosshairVisible(false);
         var13.setRangeCrosshairVisible(false);
         JFreeChart var14 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var13, var5);
         return var14;
      }
   }

   public static JFreeChart createTimeSeriesChart(String var0, String var1, String var2, XYDataset var3, boolean var4, boolean var5, boolean var6) {
      DateAxis var7 = new DateAxis(var1);
      var7.setLowerMargin(0.02D);
      var7.setUpperMargin(0.02D);
      NumberAxis var8 = new NumberAxis(var2);
      var8.setAutoRangeIncludesZero(false);
      XYPlot var9 = new XYPlot(var3, var7, var8, (XYItemRenderer)null);
      StandardXYToolTipGenerator var10 = null;
      if(var5) {
         var10 = StandardXYToolTipGenerator.getTimeSeriesInstance();
      }

      StandardXYURLGenerator var11 = null;
      if(var6) {
         var11 = new StandardXYURLGenerator();
      }

      XYLineAndShapeRenderer var12 = new XYLineAndShapeRenderer(true, false);
      var12.setBaseToolTipGenerator(var10);
      var12.setURLGenerator(var11);
      var9.setRenderer(var12);
      JFreeChart var13 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var9, var4);
      return var13;
   }

   public static JFreeChart createCandlestickChart(String var0, String var1, String var2, OHLCDataset var3, boolean var4) {
      DateAxis var5 = new DateAxis(var1);
      NumberAxis var6 = new NumberAxis(var2);
      XYPlot var7 = new XYPlot(var3, var5, var6, (XYItemRenderer)null);
      var7.setRenderer(new CandlestickRenderer());
      JFreeChart var8 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var7, var4);
      return var8;
   }

   public static JFreeChart createHighLowChart(String var0, String var1, String var2, OHLCDataset var3, boolean var4) {
      DateAxis var5 = new DateAxis(var1);
      NumberAxis var6 = new NumberAxis(var2);
      HighLowRenderer var7 = new HighLowRenderer();
      var7.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
      XYPlot var8 = new XYPlot(var3, var5, var6, var7);
      JFreeChart var9 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var8, var4);
      return var9;
   }

   public static JFreeChart createHighLowChart(String var0, String var1, String var2, OHLCDataset var3, Timeline var4, boolean var5) {
      DateAxis var6 = new DateAxis(var1);
      var6.setTimeline(var4);
      NumberAxis var7 = new NumberAxis(var2);
      HighLowRenderer var8 = new HighLowRenderer();
      var8.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
      XYPlot var9 = new XYPlot(var3, var6, var7, var8);
      JFreeChart var10 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var9, var5);
      return var10;
   }

   public static JFreeChart createBubbleChart(String var0, String var1, String var2, XYZDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         NumberAxis var9 = new NumberAxis(var2);
         var9.setAutoRangeIncludesZero(false);
         XYPlot var10 = new XYPlot(var3, var8, var9, (XYItemRenderer)null);
         XYBubbleRenderer var11 = new XYBubbleRenderer(2);
         if(var6) {
            var11.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
         }

         if(var7) {
            var11.setURLGenerator(new StandardXYZURLGenerator());
         }

         var10.setRenderer(var11);
         var10.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var10, var5);
         return var12;
      }
   }

   public static JFreeChart createHistogram(String var0, String var1, String var2, IntervalXYDataset var3, PlotOrientation var4, boolean var5, boolean var6, boolean var7) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         NumberAxis var8 = new NumberAxis(var1);
         var8.setAutoRangeIncludesZero(false);
         NumberAxis var9 = new NumberAxis(var2);
         XYBarRenderer var10 = new XYBarRenderer();
         if(var6) {
            var10.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
         }

         if(var7) {
            var10.setURLGenerator(new StandardXYURLGenerator());
         }

         XYPlot var11 = new XYPlot(var3, var8, var9, var10);
         var11.setOrientation(var4);
         JFreeChart var12 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var11, var5);
         return var12;
      }
   }

   public static JFreeChart createBoxAndWhiskerChart(String var0, String var1, String var2, BoxAndWhiskerCategoryDataset var3, boolean var4) {
      CategoryAxis var5 = new CategoryAxis(var1);
      NumberAxis var6 = new NumberAxis(var2);
      var6.setAutoRangeIncludesZero(false);
      BoxAndWhiskerRenderer var7 = new BoxAndWhiskerRenderer();
      var7.setToolTipGenerator(new BoxAndWhiskerToolTipGenerator());
      CategoryPlot var8 = new CategoryPlot(var3, var5, var6, var7);
      return new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var8, var4);
   }

   public static JFreeChart createBoxAndWhiskerChart(String var0, String var1, String var2, BoxAndWhiskerXYDataset var3, boolean var4) {
      DateAxis var5 = new DateAxis(var1);
      NumberAxis var6 = new NumberAxis(var2);
      var6.setAutoRangeIncludesZero(false);
      XYBoxAndWhiskerRenderer var7 = new XYBoxAndWhiskerRenderer(10.0D);
      XYPlot var8 = new XYPlot(var3, var5, var6, var7);
      return new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var8, var4);
   }

   public static JFreeChart createWindPlot(String var0, String var1, String var2, WindDataset var3, boolean var4, boolean var5, boolean var6) {
      DateAxis var7 = new DateAxis(var1);
      NumberAxis var8 = new NumberAxis(var2);
      var8.setRange(-12.0D, 12.0D);
      WindItemRenderer var9 = new WindItemRenderer();
      if(var5) {
         var9.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
      }

      if(var6) {
         var9.setURLGenerator(new StandardXYURLGenerator());
      }

      XYPlot var10 = new XYPlot(var3, var7, var8, var9);
      JFreeChart var11 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var10, var4);
      return var11;
   }

   public static JFreeChart createWaferMapChart(String var0, WaferMapDataset var1, PlotOrientation var2, boolean var3, boolean var4, boolean var5) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         WaferMapPlot var6 = new WaferMapPlot(var1);
         WaferMapRenderer var7 = new WaferMapRenderer();
         var6.setRenderer(var7);
         JFreeChart var8 = new JFreeChart(var0, JFreeChart.DEFAULT_TITLE_FONT, var6, var3);
         return var8;
      }
   }
}
