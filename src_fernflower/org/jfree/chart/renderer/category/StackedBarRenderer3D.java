package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.PublicCloneable;

public class StackedBarRenderer3D extends BarRenderer3D implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -5832945916493247123L;
   private boolean renderAsPercentages;

   public StackedBarRenderer3D() {
      this(false);
   }

   public StackedBarRenderer3D(double var1, double var3) {
      super(var1, var3);
   }

   public StackedBarRenderer3D(boolean var1) {
      this.renderAsPercentages = var1;
   }

   public StackedBarRenderer3D(double var1, double var3, boolean var5) {
      super(var1, var3);
      this.renderAsPercentages = var5;
   }

   public boolean getRenderAsPercentages() {
      return this.renderAsPercentages;
   }

   public void setRenderAsPercentages(boolean var1) {
      this.renderAsPercentages = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Range findRangeBounds(CategoryDataset var1) {
      return this.renderAsPercentages?new Range(0.0D, 1.0D):DatasetUtilities.findStackedRangeBounds(var1);
   }

   protected void calculateBarWidth(CategoryPlot var1, Rectangle2D var2, int var3, CategoryItemRendererState var4) {
      CategoryAxis var5 = this.getDomainAxis(var1, var3);
      CategoryDataset var6 = var1.getDataset(var3);
      if(var6 != null) {
         PlotOrientation var7 = var1.getOrientation();
         double var8 = 0.0D;
         if(var7 == PlotOrientation.HORIZONTAL) {
            var8 = var2.getHeight();
         } else if(var7 == PlotOrientation.VERTICAL) {
            var8 = var2.getWidth();
         }

         double var10 = var8 * this.getMaximumBarWidth();
         int var12 = var6.getColumnCount();
         double var13 = 0.0D;
         if(var12 > 1) {
            var13 = var5.getCategoryMargin();
         }

         double var15 = var8 * (1.0D - var5.getLowerMargin() - var5.getUpperMargin() - var13);
         if(var12 > 0) {
            var4.setBarWidth(Math.min(var15 / (double)var12, var10));
         } else {
            var4.setBarWidth(Math.min(var15, var10));
         }
      }

   }

   protected static List createStackedValueList(CategoryDataset var0, Comparable var1, double var2, boolean var4) {
      ArrayList var5 = new ArrayList();
      double var6 = var2;
      double var8 = var2;
      double var10 = 0.0D;
      if(var4) {
         var10 = DataUtilities.calculateColumnTotal(var0, var0.getColumnIndex(var1));
      }

      int var12 = -1;
      int var13 = var0.getRowCount();

      for(int var14 = 0; var14 < var13; ++var14) {
         Number var15 = var0.getValue(var0.getRowKey(var14), var1);
         if(var15 != null) {
            double var16 = var15.doubleValue();
            if(var4) {
               var16 /= var10;
            }

            if(var16 >= 0.0D) {
               if(var12 < 0) {
                  var5.add(new Object[]{null, new Double(var2)});
                  var12 = 0;
               }

               var6 += var16;
               var5.add(new Object[]{new Integer(var14), new Double(var6)});
            } else if(var16 < 0.0D) {
               if(var12 < 0) {
                  var5.add(new Object[]{null, new Double(var2)});
                  var12 = 0;
               }

               var8 += var16;
               var5.add(0, new Object[]{new Integer(-var14), new Double(var8)});
               ++var12;
            }
         }
      }

      return var5;
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(var8 >= var7.getRowCount() - 1) {
         Comparable var11 = var7.getColumnKey(var9);
         List var12 = createStackedValueList(var7, var7.getColumnKey(var9), this.getBase(), this.renderAsPercentages);
         java.awt.geom.Rectangle2D.Double var13 = new java.awt.geom.Rectangle2D.Double(var3.getX(), var3.getY() + this.getYOffset(), var3.getWidth() - this.getXOffset(), var3.getHeight() - this.getYOffset());
         PlotOrientation var14 = var4.getOrientation();
         if(var14 == PlotOrientation.HORIZONTAL) {
            this.drawStackHorizontal(var12, var11, var1, var2, var13, var4, var5, var6, var7);
         } else {
            this.drawStackVertical(var12, var11, var1, var2, var13, var4, var5, var6, var7);
         }

      }
   }

   protected void drawStackHorizontal(List var1, Comparable var2, Graphics2D var3, CategoryItemRendererState var4, Rectangle2D var5, CategoryPlot var6, CategoryAxis var7, ValueAxis var8, CategoryDataset var9) {
      int var10 = var9.getColumnIndex(var2);
      double var11 = var7.getCategoryMiddle(var10, var9.getColumnCount(), var5, var6.getDomainAxisEdge()) - var4.getBarWidth() / 2.0D;
      double var13 = var4.getBarWidth();
      ArrayList var15 = new ArrayList();
      boolean var16 = var8.isInverted();
      int var17 = var1.size() - 1;

      int var18;
      boolean var22;
      for(var18 = 0; var18 < var17; ++var18) {
         int var19 = var16?var17 - var18 - 1:var18;
         Object[] var20 = (Object[])((Object[])var1.get(var19));
         Object[] var21 = (Object[])((Object[])var1.get(var19 + 1));
         var22 = false;
         int var38;
         if(var21[0] == null) {
            var38 = -((Integer)var20[0]).intValue();
         } else {
            var38 = ((Integer)var21[0]).intValue();
            if(var38 < 0) {
               var38 = -((Integer)var20[0]).intValue();
            }
         }

         double var23 = ((Double)var20[1]).doubleValue();
         double var25 = var8.valueToJava2D(var23, var5, var6.getRangeAxisEdge());
         double var27 = ((Double)var21[1]).doubleValue();
         double var29 = var8.valueToJava2D(var27, var5, var6.getRangeAxisEdge());
         Shape[] var31 = this.createHorizontalBlock(var11, var13, var25, var29, var16);
         Paint var32 = this.getItemPaint(var38, var10);
         Paint var33 = this.getItemOutlinePaint(var38, var10);
         var3.setStroke(this.getItemOutlineStroke(var38, var10));

         for(int var34 = 0; var34 < 6; ++var34) {
            var3.setPaint(var32);
            var3.fill(var31[var34]);
            var3.setPaint(var33);
            var3.draw(var31[var34]);
         }

         var15.add(new Object[]{new Integer(var38), var31[5].getBounds2D(), BooleanUtilities.valueOf(var23 < this.getBase())});
         EntityCollection var40 = var4.getEntityCollection();
         if(var40 != null) {
            this.addItemEntity(var40, var9, var38, var10, var31[5]);
         }
      }

      for(var18 = 0; var18 < var15.size(); ++var18) {
         Object[] var35 = (Object[])((Object[])var15.get(var18));
         int var36 = ((Integer)var35[0]).intValue();
         Rectangle2D var37 = (Rectangle2D)var35[1];
         var22 = ((Boolean)var35[2]).booleanValue();
         CategoryItemLabelGenerator var39 = this.getItemLabelGenerator(var36, var10);
         if(var39 != null && this.isItemLabelVisible(var36, var10)) {
            this.drawItemLabel(var3, var9, var36, var10, var6, var39, var37, var22);
         }
      }

   }

   private Shape[] createHorizontalBlock(double var1, double var3, double var5, double var7, boolean var9) {
      Shape[] var10 = new Shape[6];
      java.awt.geom.Point2D.Double var11 = new java.awt.geom.Point2D.Double(var5, var1);
      java.awt.geom.Point2D.Double var12 = new java.awt.geom.Point2D.Double(var5, var1 + var3);
      java.awt.geom.Point2D.Double var13 = new java.awt.geom.Point2D.Double(var12.getX() + this.getXOffset(), var12.getY() - this.getYOffset());
      java.awt.geom.Point2D.Double var14 = new java.awt.geom.Point2D.Double(var11.getX() + this.getXOffset(), var11.getY() - this.getYOffset());
      java.awt.geom.Point2D.Double var15 = new java.awt.geom.Point2D.Double(var7, var1);
      java.awt.geom.Point2D.Double var16 = new java.awt.geom.Point2D.Double(var7, var1 + var3);
      java.awt.geom.Point2D.Double var17 = new java.awt.geom.Point2D.Double(var16.getX() + this.getXOffset(), var16.getY() - this.getYOffset());
      java.awt.geom.Point2D.Double var18 = new java.awt.geom.Point2D.Double(var15.getX() + this.getXOffset(), var15.getY() - this.getYOffset());
      GeneralPath var19 = new GeneralPath();
      var19.moveTo((float)var16.getX(), (float)var16.getY());
      var19.lineTo((float)var12.getX(), (float)var12.getY());
      var19.lineTo((float)var13.getX(), (float)var13.getY());
      var19.lineTo((float)var17.getX(), (float)var17.getY());
      var19.closePath();
      GeneralPath var20 = new GeneralPath();
      var20.moveTo((float)var15.getX(), (float)var15.getY());
      var20.lineTo((float)var11.getX(), (float)var11.getY());
      var20.lineTo((float)var14.getX(), (float)var14.getY());
      var20.lineTo((float)var18.getX(), (float)var18.getY());
      var20.closePath();
      GeneralPath var21 = new GeneralPath();
      var21.moveTo((float)var17.getX(), (float)var17.getY());
      var21.lineTo((float)var13.getX(), (float)var13.getY());
      var21.lineTo((float)var14.getX(), (float)var14.getY());
      var21.lineTo((float)var18.getX(), (float)var18.getY());
      var21.closePath();
      GeneralPath var22 = new GeneralPath();
      var22.moveTo((float)var15.getX(), (float)var15.getY());
      var22.lineTo((float)var16.getX(), (float)var16.getY());
      var22.lineTo((float)var12.getX(), (float)var12.getY());
      var22.lineTo((float)var11.getX(), (float)var11.getY());
      var22.closePath();
      GeneralPath var23 = new GeneralPath();
      var23.moveTo((float)var15.getX(), (float)var15.getY());
      var23.lineTo((float)var16.getX(), (float)var16.getY());
      var23.lineTo((float)var17.getX(), (float)var17.getY());
      var23.lineTo((float)var18.getX(), (float)var18.getY());
      var23.closePath();
      GeneralPath var24 = new GeneralPath();
      var24.moveTo((float)var11.getX(), (float)var11.getY());
      var24.lineTo((float)var12.getX(), (float)var12.getY());
      var24.lineTo((float)var13.getX(), (float)var13.getY());
      var24.lineTo((float)var14.getX(), (float)var14.getY());
      var24.closePath();
      var10[0] = var19;
      var10[1] = var21;
      if(var9) {
         var10[2] = var24;
         var10[3] = var23;
      } else {
         var10[2] = var23;
         var10[3] = var24;
      }

      var10[4] = var20;
      var10[5] = var22;
      return var10;
   }

   protected void drawStackVertical(List var1, Comparable var2, Graphics2D var3, CategoryItemRendererState var4, Rectangle2D var5, CategoryPlot var6, CategoryAxis var7, ValueAxis var8, CategoryDataset var9) {
      int var10 = var9.getColumnIndex(var2);
      double var11 = var7.getCategoryMiddle(var10, var9.getColumnCount(), var5, var6.getDomainAxisEdge()) - var4.getBarWidth() / 2.0D;
      double var13 = var4.getBarWidth();
      ArrayList var15 = new ArrayList();
      boolean var16 = var8.isInverted();
      int var17 = var1.size() - 1;

      int var18;
      boolean var22;
      for(var18 = 0; var18 < var17; ++var18) {
         int var19 = var16?var17 - var18 - 1:var18;
         Object[] var20 = (Object[])((Object[])var1.get(var19));
         Object[] var21 = (Object[])((Object[])var1.get(var19 + 1));
         var22 = false;
         int var38;
         if(var21[0] == null) {
            var38 = -((Integer)var20[0]).intValue();
         } else {
            var38 = ((Integer)var21[0]).intValue();
            if(var38 < 0) {
               var38 = -((Integer)var20[0]).intValue();
            }
         }

         double var23 = ((Double)var20[1]).doubleValue();
         double var25 = var8.valueToJava2D(var23, var5, var6.getRangeAxisEdge());
         double var27 = ((Double)var21[1]).doubleValue();
         double var29 = var8.valueToJava2D(var27, var5, var6.getRangeAxisEdge());
         Shape[] var31 = this.createVerticalBlock(var11, var13, var25, var29, var16);
         Paint var32 = this.getItemPaint(var38, var10);
         Paint var33 = this.getItemOutlinePaint(var38, var10);
         var3.setStroke(this.getItemOutlineStroke(var38, var10));

         for(int var34 = 0; var34 < 6; ++var34) {
            var3.setPaint(var32);
            var3.fill(var31[var34]);
            var3.setPaint(var33);
            var3.draw(var31[var34]);
         }

         var15.add(new Object[]{new Integer(var38), var31[5].getBounds2D(), BooleanUtilities.valueOf(var23 < this.getBase())});
         EntityCollection var40 = var4.getEntityCollection();
         if(var40 != null) {
            this.addItemEntity(var40, var9, var38, var10, var31[5]);
         }
      }

      for(var18 = 0; var18 < var15.size(); ++var18) {
         Object[] var35 = (Object[])((Object[])var15.get(var18));
         int var36 = ((Integer)var35[0]).intValue();
         Rectangle2D var37 = (Rectangle2D)var35[1];
         var22 = ((Boolean)var35[2]).booleanValue();
         CategoryItemLabelGenerator var39 = this.getItemLabelGenerator(var36, var10);
         if(var39 != null && this.isItemLabelVisible(var36, var10)) {
            this.drawItemLabel(var3, var9, var36, var10, var6, var39, var37, var22);
         }
      }

   }

   private Shape[] createVerticalBlock(double var1, double var3, double var5, double var7, boolean var9) {
      Shape[] var10 = new Shape[6];
      java.awt.geom.Point2D.Double var11 = new java.awt.geom.Point2D.Double(var1, var5);
      java.awt.geom.Point2D.Double var12 = new java.awt.geom.Point2D.Double(var1 + var3, var5);
      java.awt.geom.Point2D.Double var13 = new java.awt.geom.Point2D.Double(var12.getX() + this.getXOffset(), var12.getY() - this.getYOffset());
      java.awt.geom.Point2D.Double var14 = new java.awt.geom.Point2D.Double(var11.getX() + this.getXOffset(), var11.getY() - this.getYOffset());
      java.awt.geom.Point2D.Double var15 = new java.awt.geom.Point2D.Double(var1, var7);
      java.awt.geom.Point2D.Double var16 = new java.awt.geom.Point2D.Double(var1 + var3, var7);
      java.awt.geom.Point2D.Double var17 = new java.awt.geom.Point2D.Double(var16.getX() + this.getXOffset(), var16.getY() - this.getYOffset());
      java.awt.geom.Point2D.Double var18 = new java.awt.geom.Point2D.Double(var15.getX() + this.getXOffset(), var15.getY() - this.getYOffset());
      GeneralPath var19 = new GeneralPath();
      var19.moveTo((float)var16.getX(), (float)var16.getY());
      var19.lineTo((float)var12.getX(), (float)var12.getY());
      var19.lineTo((float)var13.getX(), (float)var13.getY());
      var19.lineTo((float)var17.getX(), (float)var17.getY());
      var19.closePath();
      GeneralPath var20 = new GeneralPath();
      var20.moveTo((float)var15.getX(), (float)var15.getY());
      var20.lineTo((float)var11.getX(), (float)var11.getY());
      var20.lineTo((float)var14.getX(), (float)var14.getY());
      var20.lineTo((float)var18.getX(), (float)var18.getY());
      var20.closePath();
      GeneralPath var21 = new GeneralPath();
      var21.moveTo((float)var17.getX(), (float)var17.getY());
      var21.lineTo((float)var13.getX(), (float)var13.getY());
      var21.lineTo((float)var14.getX(), (float)var14.getY());
      var21.lineTo((float)var18.getX(), (float)var18.getY());
      var21.closePath();
      GeneralPath var22 = new GeneralPath();
      var22.moveTo((float)var15.getX(), (float)var15.getY());
      var22.lineTo((float)var16.getX(), (float)var16.getY());
      var22.lineTo((float)var12.getX(), (float)var12.getY());
      var22.lineTo((float)var11.getX(), (float)var11.getY());
      var22.closePath();
      GeneralPath var23 = new GeneralPath();
      var23.moveTo((float)var15.getX(), (float)var15.getY());
      var23.lineTo((float)var16.getX(), (float)var16.getY());
      var23.lineTo((float)var17.getX(), (float)var17.getY());
      var23.lineTo((float)var18.getX(), (float)var18.getY());
      var23.closePath();
      GeneralPath var24 = new GeneralPath();
      var24.moveTo((float)var11.getX(), (float)var11.getY());
      var24.lineTo((float)var12.getX(), (float)var12.getY());
      var24.lineTo((float)var13.getX(), (float)var13.getY());
      var24.lineTo((float)var14.getX(), (float)var14.getY());
      var24.closePath();
      var10[0] = var24;
      var10[1] = var21;
      var10[2] = var20;
      var10[3] = var19;
      var10[4] = var23;
      var10[5] = var22;
      if(var9) {
         var10[0] = var23;
         var10[4] = var24;
      }

      return var10;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StackedBarRenderer3D)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         StackedBarRenderer3D var2 = (StackedBarRenderer3D)var1;
         return this.renderAsPercentages == var2.getRenderAsPercentages();
      }
   }
}
