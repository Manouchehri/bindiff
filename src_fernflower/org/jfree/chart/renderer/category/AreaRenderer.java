package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class AreaRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -4231878281385812757L;
   private AreaRendererEndType endType;

   public AreaRenderer() {
      this.endType = AreaRendererEndType.TAPER;
   }

   public AreaRendererEndType getEndType() {
      return this.endType;
   }

   public void setEndType(AreaRendererEndType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'type\' argument.");
      } else {
         this.endType = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public LegendItem getLegendItem(int var1, int var2) {
      CategoryPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else if(this.isSeriesVisible(var2) && this.isSeriesVisibleInLegend(var2)) {
         CategoryDataset var4 = var3.getDataset(var1);
         String var5 = this.getLegendItemLabelGenerator().generateLabel(var4, var2);
         String var7 = null;
         if(this.getLegendItemToolTipGenerator() != null) {
            var7 = this.getLegendItemToolTipGenerator().generateLabel(var4, var2);
         }

         String var8 = null;
         if(this.getLegendItemURLGenerator() != null) {
            var8 = this.getLegendItemURLGenerator().generateLabel(var4, var2);
         }

         Double var9 = new Double(-4.0D, -4.0D, 8.0D, 8.0D);
         Paint var10 = this.getSeriesPaint(var2);
         Paint var11 = this.getSeriesOutlinePaint(var2);
         Stroke var12 = this.getSeriesOutlineStroke(var2);
         return new LegendItem(var5, var5, var7, var8, var9, var10, var12, var11);
      } else {
         return null;
      }
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(this.getItemVisible(var8, var9)) {
         Number var11 = var7.getValue(var8, var9);
         if(var11 != null) {
            PlotOrientation var12 = var4.getOrientation();
            RectangleEdge var13 = var4.getDomainAxisEdge();
            int var14 = var7.getColumnCount();
            float var15 = (float)var5.getCategoryStart(var9, var14, var3, var13);
            float var16 = (float)var5.getCategoryMiddle(var9, var14, var3, var13);
            float var17 = (float)var5.getCategoryEnd(var9, var14, var3, var13);
            var15 = (float)Math.round(var15);
            var16 = (float)Math.round(var16);
            var17 = (float)Math.round(var17);
            if(this.endType == AreaRendererEndType.TRUNCATE) {
               if(var9 == 0) {
                  var15 = var16;
               } else if(var9 == this.getColumnCount() - 1) {
                  var17 = var16;
               }
            }

            double var18 = var11.doubleValue();
            double var20 = 0.0D;
            if(var9 > 0) {
               Number var22 = var7.getValue(var8, var9 - 1);
               if(var22 != null) {
                  var20 = (var22.doubleValue() + var18) / 2.0D;
               }
            }

            double var31 = 0.0D;
            if(var9 < var7.getColumnCount() - 1) {
               Number var24 = var7.getValue(var8, var9 + 1);
               if(var24 != null) {
                  var31 = (var24.doubleValue() + var18) / 2.0D;
               }
            }

            RectangleEdge var32 = var4.getRangeAxisEdge();
            float var25 = (float)var6.valueToJava2D(var20, var3, var32);
            float var26 = (float)var6.valueToJava2D(var18, var3, var32);
            float var27 = (float)var6.valueToJava2D(var31, var3, var32);
            float var28 = (float)var6.valueToJava2D(0.0D, var3, var32);
            var1.setPaint(this.getItemPaint(var8, var9));
            var1.setStroke(this.getItemStroke(var8, var9));
            GeneralPath var29 = new GeneralPath();
            if(var12 == PlotOrientation.VERTICAL) {
               var29.moveTo(var15, var28);
               var29.lineTo(var15, var25);
               var29.lineTo(var16, var26);
               var29.lineTo(var17, var27);
               var29.lineTo(var17, var28);
            } else if(var12 == PlotOrientation.HORIZONTAL) {
               var29.moveTo(var28, var15);
               var29.lineTo(var25, var15);
               var29.lineTo(var26, var16);
               var29.lineTo(var27, var17);
               var29.lineTo(var28, var17);
            }

            var29.closePath();
            var1.setPaint(this.getItemPaint(var8, var9));
            var1.fill(var29);
            if(this.isItemLabelVisible(var8, var9)) {
               this.drawItemLabel(var1, var12, var7, var8, var9, (double)var16, (double)var26, var11.doubleValue() < 0.0D);
            }

            EntityCollection var30 = var2.getEntityCollection();
            if(var30 != null) {
               this.addItemEntity(var30, var7, var8, var9, var29);
            }
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AreaRenderer)) {
         return false;
      } else {
         AreaRenderer var2 = (AreaRenderer)var1;
         return !this.endType.equals(var2.endType)?false:super.equals(var1);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
