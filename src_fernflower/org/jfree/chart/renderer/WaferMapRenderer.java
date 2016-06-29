package org.jfree.chart.renderer;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D.Double;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.data.general.WaferMapDataset;

public class WaferMapRenderer extends AbstractRenderer {
   private Map paintIndex;
   private WaferMapPlot plot;
   private int paintLimit;
   private static final int DEFAULT_PAINT_LIMIT = 35;
   public static final int POSITION_INDEX = 0;
   public static final int VALUE_INDEX = 1;
   private int paintIndexMethod;

   public WaferMapRenderer() {
      this((Integer)null, (Integer)null);
   }

   public WaferMapRenderer(int var1, int var2) {
      this(new Integer(var1), new Integer(var2));
   }

   public WaferMapRenderer(Integer var1, Integer var2) {
      this.paintIndex = new HashMap();
      if(var1 == null) {
         this.paintLimit = 35;
      } else {
         this.paintLimit = var1.intValue();
      }

      this.paintIndexMethod = 1;
      if(var2 != null && this.isMethodValid(var2.intValue())) {
         this.paintIndexMethod = var2.intValue();
      }

   }

   private boolean isMethodValid(int var1) {
      switch(var1) {
      case 0:
         return true;
      case 1:
         return true;
      default:
         return false;
      }
   }

   public DrawingSupplier getDrawingSupplier() {
      DrawingSupplier var1 = null;
      WaferMapPlot var2 = this.getPlot();
      if(var2 != null) {
         var1 = var2.getDrawingSupplier();
      }

      return var1;
   }

   public WaferMapPlot getPlot() {
      return this.plot;
   }

   public void setPlot(WaferMapPlot var1) {
      this.plot = var1;
      this.makePaintIndex();
   }

   public Paint getChipColor(Number var1) {
      return this.getSeriesPaint(this.getPaintIndex(var1));
   }

   private int getPaintIndex(Number var1) {
      return ((Integer)this.paintIndex.get(var1)).intValue();
   }

   private void makePaintIndex() {
      if(this.plot != null) {
         WaferMapDataset var1 = this.plot.getDataset();
         Number var2 = var1.getMinValue();
         Number var3 = var1.getMaxValue();
         Set var4 = var1.getUniqueValues();
         if(var4.size() <= this.paintLimit) {
            int var5 = 0;
            Iterator var6 = var4.iterator();

            while(var6.hasNext()) {
               this.paintIndex.put(var6.next(), new Integer(var5++));
            }
         } else {
            switch(this.paintIndexMethod) {
            case 0:
               this.makePositionIndex(var4);
               break;
            case 1:
               this.makeValueIndex(var3, var2, var4);
            }
         }

      }
   }

   private void makePositionIndex(Set var1) {
      int var2 = (int)Math.ceil((double)var1.size() / (double)this.paintLimit);
      int var3 = 0;
      int var4 = 0;
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         this.paintIndex.put(var5.next(), new Integer(var4));
         ++var3;
         if(var3 % var2 == 0) {
            ++var4;
         }

         if(var4 > this.paintLimit) {
            var4 = this.paintLimit;
         }
      }

   }

   private void makeValueIndex(Number var1, Number var2, Set var3) {
      double var4 = var1.doubleValue() - var2.doubleValue();
      double var6 = var4 / (double)this.paintLimit;
      int var8 = 0;
      double var9 = var2.doubleValue() + var6;
      Iterator var11 = var3.iterator();

      while(var11.hasNext()) {
         Number var12 = (Number)var11.next();

         while(var12.doubleValue() > var9) {
            var9 += var6;
            ++var8;
            if(var8 > this.paintLimit) {
               var8 = this.paintLimit;
            }
         }

         this.paintIndex.put(var12, new Integer(var8));
      }

   }

   public LegendItemCollection getLegendCollection() {
      LegendItemCollection var1 = new LegendItemCollection();
      if(this.paintIndex != null && this.paintIndex.size() > 0) {
         if(this.paintIndex.size() <= this.paintLimit) {
            Iterator var2 = this.paintIndex.entrySet().iterator();

            while(var2.hasNext()) {
               Entry var3 = (Entry)var2.next();
               String var4 = var3.getKey().toString();
               Double var6 = new Double(1.0D, 1.0D, 1.0D, 1.0D);
               Paint var7 = this.getSeriesPaint(((Integer)var3.getValue()).intValue());
               Color var8 = Color.black;
               Stroke var9 = DEFAULT_STROKE;
               var1.add(new LegendItem(var4, var4, (String)null, (String)null, var6, var7, var9, var8));
            }
         } else {
            HashSet var11 = new HashSet();
            Iterator var12 = this.paintIndex.entrySet().iterator();

            while(var12.hasNext()) {
               Entry var13 = (Entry)var12.next();
               if(var11.add(var13.getValue())) {
                  String var5 = this.getMinPaintValue((Integer)var13.getValue()).toString() + " - " + this.getMaxPaintValue((Integer)var13.getValue()).toString();
                  Double var14 = new Double(1.0D, 1.0D, 1.0D, 1.0D);
                  Paint var15 = this.getSeriesPaint(((Integer)var13.getValue()).intValue());
                  Color var16 = Color.black;
                  Stroke var10 = DEFAULT_STROKE;
                  var1.add(new LegendItem(var5, var5, (String)null, (String)null, var14, var15, var10, var16));
               }
            }
         }
      }

      return var1;
   }

   private Number getMinPaintValue(Integer var1) {
      double var2 = java.lang.Double.POSITIVE_INFINITY;
      Iterator var4 = this.paintIndex.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         if(((Integer)var5.getValue()).equals(var1) && ((Number)var5.getKey()).doubleValue() < var2) {
            var2 = ((Number)var5.getKey()).doubleValue();
         }
      }

      return new java.lang.Double(var2);
   }

   private Number getMaxPaintValue(Integer var1) {
      double var2 = java.lang.Double.NEGATIVE_INFINITY;
      Iterator var4 = this.paintIndex.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         if(((Integer)var5.getValue()).equals(var1) && ((Number)var5.getKey()).doubleValue() > var2) {
            var2 = ((Number)var5.getKey()).doubleValue();
         }
      }

      return new java.lang.Double(var2);
   }
}
