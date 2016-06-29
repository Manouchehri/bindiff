package org.jfree.chart.plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.TableOrder;

public class MultiplePiePlot extends Plot implements Serializable, Cloneable {
   private static final long serialVersionUID = -355377800470807389L;
   private JFreeChart pieChart;
   private CategoryDataset dataset;
   private TableOrder dataExtractOrder;
   private double limit;
   private Comparable aggregatedItemsKey;
   private transient Paint aggregatedItemsPaint;
   private transient Map sectionPaints;

   public MultiplePiePlot() {
      this((CategoryDataset)null);
   }

   public MultiplePiePlot(CategoryDataset var1) {
      this.limit = 0.0D;
      this.dataset = var1;
      PiePlot var2 = new PiePlot((PieDataset)null);
      this.pieChart = new JFreeChart(var2);
      this.pieChart.removeLegend();
      this.dataExtractOrder = TableOrder.BY_COLUMN;
      this.pieChart.setBackgroundPaint((Paint)null);
      TextTitle var3 = new TextTitle("Series Title", new Font("SansSerif", 1, 12));
      var3.setPosition(RectangleEdge.BOTTOM);
      this.pieChart.setTitle(var3);
      this.aggregatedItemsKey = "Other";
      this.aggregatedItemsPaint = Color.lightGray;
      this.sectionPaints = new HashMap();
   }

   public CategoryDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(CategoryDataset var1) {
      if(this.dataset != null) {
         this.dataset.removeChangeListener(this);
      }

      this.dataset = var1;
      if(var1 != null) {
         this.setDatasetGroup(var1.getGroup());
         var1.addChangeListener(this);
      }

      this.datasetChanged(new DatasetChangeEvent(this, var1));
   }

   public JFreeChart getPieChart() {
      return this.pieChart;
   }

   public void setPieChart(JFreeChart var1) {
      this.pieChart = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public TableOrder getDataExtractOrder() {
      return this.dataExtractOrder;
   }

   public void setDataExtractOrder(TableOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument");
      } else {
         this.dataExtractOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getLimit() {
      return this.limit;
   }

   public void setLimit(double var1) {
      this.limit = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Comparable getAggregatedItemsKey() {
      return this.aggregatedItemsKey;
   }

   public void setAggregatedItemsKey(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         this.aggregatedItemsKey = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getAggregatedItemsPaint() {
      return this.aggregatedItemsPaint;
   }

   public void setAggregatedItemsPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.aggregatedItemsPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public String getPlotType() {
      return "Multiple Pie Plot";
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      this.drawBackground(var1, var2);
      this.drawOutline(var1, var2);
      if(DatasetUtilities.isEmptyOrNull(this.dataset)) {
         this.drawNoDataMessage(var1, var2);
      } else {
         boolean var7 = false;
         int var28;
         if(this.dataExtractOrder == TableOrder.BY_ROW) {
            var28 = this.dataset.getRowCount();
         } else {
            var28 = this.dataset.getColumnCount();
         }

         int var8 = (int)Math.ceil(Math.sqrt((double)var28));
         int var9 = (int)Math.ceil((double)var28 / (double)var8);
         int var10;
         if(var8 > var9 && var2.getWidth() < var2.getHeight()) {
            var10 = var8;
            var8 = var9;
            var9 = var10;
         }

         this.prefetchSectionPaints();
         var10 = (int)var2.getX();
         int var11 = (int)var2.getY();
         int var12 = (int)var2.getWidth() / var8;
         int var13 = (int)var2.getHeight() / var9;
         int var14 = 0;
         int var15 = 0;
         int var16 = var9 * var8 - var28;
         int var17 = 0;
         Rectangle var18 = new Rectangle();

         for(int var19 = 0; var19 < var28; ++var19) {
            var18.setBounds(var10 + var17 + var12 * var15, var11 + var13 * var14, var12, var13);
            String var20 = null;
            if(this.dataExtractOrder == TableOrder.BY_ROW) {
               var20 = this.dataset.getRowKey(var19).toString();
            } else {
               var20 = this.dataset.getColumnKey(var19).toString();
            }

            this.pieChart.setTitle(var20);
            Object var21 = null;
            CategoryToPieDataset var22 = new CategoryToPieDataset(this.dataset, this.dataExtractOrder, var19);
            if(this.limit > 0.0D) {
               var21 = DatasetUtilities.createConsolidatedPieDataset(var22, this.aggregatedItemsKey, this.limit);
            } else {
               var21 = var22;
            }

            PiePlot var23 = (PiePlot)this.pieChart.getPlot();
            var23.setDataset((PieDataset)var21);
            var23.setPieIndex(var19);

            for(int var24 = 0; var24 < ((PieDataset)var21).getItemCount(); ++var24) {
               Comparable var25 = ((PieDataset)var21).getKey(var24);
               Paint var26;
               if(var25.equals(this.aggregatedItemsKey)) {
                  var26 = this.aggregatedItemsPaint;
               } else {
                  var26 = (Paint)this.sectionPaints.get(var25);
               }

               var23.setSectionPaint(var25, var26);
            }

            ChartRenderingInfo var27 = null;
            if(var5 != null) {
               var27 = new ChartRenderingInfo();
            }

            this.pieChart.draw(var1, var18, var27);
            if(var5 != null) {
               var5.getOwner().getEntityCollection().addAll(var27.getEntityCollection());
               var5.addSubplotInfo(var27.getPlotInfo());
            }

            ++var15;
            if(var15 == var8) {
               var15 = 0;
               ++var14;
               if(var14 == var9 - 1 && var16 != 0) {
                  var17 = var16 * var12 / 2;
               }
            }
         }

      }
   }

   private void prefetchSectionPaints() {
      PiePlot var1 = (PiePlot)this.getPieChart().getPlot();
      int var2;
      Comparable var3;
      Paint var4;
      if(this.dataExtractOrder == TableOrder.BY_ROW) {
         for(var2 = 0; var2 < this.dataset.getColumnCount(); ++var2) {
            var3 = this.dataset.getColumnKey(var2);
            var4 = var1.getSectionPaint(var3);
            if(var4 == null) {
               var4 = (Paint)this.sectionPaints.get(var3);
               if(var4 == null) {
                  var4 = this.getDrawingSupplier().getNextPaint();
               }
            }

            this.sectionPaints.put(var3, var4);
         }
      } else {
         for(var2 = 0; var2 < this.dataset.getRowCount(); ++var2) {
            var3 = this.dataset.getRowKey(var2);
            var4 = var1.getSectionPaint(var3);
            if(var4 == null) {
               var4 = (Paint)this.sectionPaints.get(var3);
               if(var4 == null) {
                  var4 = this.getDrawingSupplier().getNextPaint();
               }
            }

            this.sectionPaints.put(var3, var4);
         }
      }

   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = new LegendItemCollection();
      if(this.dataset != null) {
         List var2 = null;
         this.prefetchSectionPaints();
         if(this.dataExtractOrder == TableOrder.BY_ROW) {
            var2 = this.dataset.getColumnKeys();
         } else if(this.dataExtractOrder == TableOrder.BY_COLUMN) {
            var2 = this.dataset.getRowKeys();
         }

         if(var2 != null) {
            int var3 = 0;

            for(Iterator var4 = var2.iterator(); var4.hasNext(); ++var3) {
               Comparable var5 = (Comparable)var4.next();
               String var6 = var5.toString();
               Paint var8 = (Paint)this.sectionPaints.get(var5);
               LegendItem var9 = new LegendItem(var6, var6, (String)null, (String)null, Plot.DEFAULT_LEGEND_ITEM_CIRCLE, var8, Plot.DEFAULT_OUTLINE_STROKE, var8);
               var1.add(var9);
            }
         }

         if(this.limit > 0.0D) {
            var1.add(new LegendItem(this.aggregatedItemsKey.toString(), this.aggregatedItemsKey.toString(), (String)null, (String)null, Plot.DEFAULT_LEGEND_ITEM_CIRCLE, this.aggregatedItemsPaint, Plot.DEFAULT_OUTLINE_STROKE, this.aggregatedItemsPaint));
         }
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MultiplePiePlot)) {
         return false;
      } else {
         MultiplePiePlot var2 = (MultiplePiePlot)var1;
         return this.dataExtractOrder != var2.dataExtractOrder?false:(this.limit != var2.limit?false:(!this.aggregatedItemsKey.equals(var2.aggregatedItemsKey)?false:(!PaintUtilities.equal(this.aggregatedItemsPaint, var2.aggregatedItemsPaint)?false:(!ObjectUtilities.equal(this.pieChart, var2.pieChart)?false:super.equals(var1)))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.aggregatedItemsPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.aggregatedItemsPaint = SerialUtilities.readPaint(var1);
      this.sectionPaints = new HashMap();
   }
}
