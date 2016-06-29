package org.jfree.chart.renderer.category;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.Icon;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer$1;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer$2;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;

public class MinMaxCategoryRenderer extends AbstractCategoryItemRenderer {
   private static final long serialVersionUID = 2935615937671064911L;
   private boolean plotLines = false;
   private transient Paint groupPaint;
   private transient Stroke groupStroke;
   private transient Icon minIcon;
   private transient Icon maxIcon;
   private transient Icon objectIcon;
   private int lastCategory;
   private double min;
   private double max;

   public MinMaxCategoryRenderer() {
      this.groupPaint = Color.black;
      this.groupStroke = new BasicStroke(1.0F);
      this.minIcon = this.getIcon(new Double(-4.0D, -4.0D, 8.0D, 8.0D, 0.0D, 360.0D, 0), (Paint)null, Color.black);
      this.maxIcon = this.getIcon(new Double(-4.0D, -4.0D, 8.0D, 8.0D, 0.0D, 360.0D, 0), (Paint)null, Color.black);
      this.objectIcon = this.getIcon(new java.awt.geom.Line2D.Double(-4.0D, 0.0D, 4.0D, 0.0D), false, true);
      this.lastCategory = -1;
   }

   public boolean isDrawLines() {
      return this.plotLines;
   }

   public void setDrawLines(boolean var1) {
      if(this.plotLines != var1) {
         this.plotLines = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public Paint getGroupPaint() {
      return this.groupPaint;
   }

   public void setGroupPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.groupPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Stroke getGroupStroke() {
      return this.groupStroke;
   }

   public void setGroupStroke(Stroke var1) {
      this.groupStroke = var1;
   }

   public Icon getObjectIcon() {
      return this.objectIcon;
   }

   public void setObjectIcon(Icon var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'icon\' argument.");
      } else {
         this.objectIcon = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Icon getMaxIcon() {
      return this.maxIcon;
   }

   public void setMaxIcon(Icon var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'icon\' argument.");
      } else {
         this.maxIcon = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public Icon getMinIcon() {
      return this.minIcon;
   }

   public void setMinIcon(Icon var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'icon\' argument.");
      } else {
         this.minIcon = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      Number var11 = var7.getValue(var8, var9);
      if(var11 != null) {
         double var12 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
         double var14 = var6.valueToJava2D(var11.doubleValue(), var3, var4.getRangeAxisEdge());
         var1.setPaint(this.getItemPaint(var8, var9));
         var1.setStroke(this.getItemStroke(var8, var9));
         java.awt.geom.Rectangle2D.Double var16 = null;
         var16 = new java.awt.geom.Rectangle2D.Double(var12 - 4.0D, var14 - 4.0D, 8.0D, 8.0D);
         PlotOrientation var17 = var4.getOrientation();
         if(var17 == PlotOrientation.VERTICAL) {
            this.objectIcon.paintIcon((Component)null, var1, (int)var12, (int)var14);
         } else {
            this.objectIcon.paintIcon((Component)null, var1, (int)var14, (int)var12);
         }

         if(this.lastCategory == var9) {
            if(this.min > var11.doubleValue()) {
               this.min = var11.doubleValue();
            }

            if(this.max < var11.doubleValue()) {
               this.max = var11.doubleValue();
            }

            if(var7.getRowCount() - 1 == var8) {
               var1.setPaint(this.groupPaint);
               var1.setStroke(this.groupStroke);
               double var18 = var6.valueToJava2D(this.min, var3, var4.getRangeAxisEdge());
               double var20 = var6.valueToJava2D(this.max, var3, var4.getRangeAxisEdge());
               if(var17 == PlotOrientation.VERTICAL) {
                  var1.draw(new java.awt.geom.Line2D.Double(var12, var18, var12, var20));
                  this.minIcon.paintIcon((Component)null, var1, (int)var12, (int)var18);
                  this.maxIcon.paintIcon((Component)null, var1, (int)var12, (int)var20);
               } else {
                  var1.draw(new java.awt.geom.Line2D.Double(var18, var12, var20, var12));
                  this.minIcon.paintIcon((Component)null, var1, (int)var18, (int)var12);
                  this.maxIcon.paintIcon((Component)null, var1, (int)var20, (int)var12);
               }
            }
         } else {
            this.lastCategory = var9;
            this.min = var11.doubleValue();
            this.max = var11.doubleValue();
         }

         if(this.plotLines && var9 != 0) {
            Number var27 = var7.getValue(var8, var9 - 1);
            if(var27 != null) {
               double var19 = var27.doubleValue();
               double var21 = var5.getCategoryMiddle(var9 - 1, this.getColumnCount(), var3, var4.getDomainAxisEdge());
               double var23 = var6.valueToJava2D(var19, var3, var4.getRangeAxisEdge());
               var1.setPaint(this.getItemPaint(var8, var9));
               var1.setStroke(this.getItemStroke(var8, var9));
               java.awt.geom.Line2D.Double var25;
               if(var17 == PlotOrientation.VERTICAL) {
                  var25 = new java.awt.geom.Line2D.Double(var21, var23, var12, var14);
               } else {
                  var25 = new java.awt.geom.Line2D.Double(var23, var21, var14, var12);
               }

               var1.draw(var25);
            }
         }

         if(var2.getInfo() != null) {
            EntityCollection var28 = var2.getEntityCollection();
            if(var28 != null && var16 != null) {
               String var29 = null;
               CategoryToolTipGenerator var30 = this.getToolTipGenerator(var8, var9);
               if(var30 != null) {
                  var29 = var30.generateToolTip(var7, var8, var9);
               }

               CategoryItemEntity var26 = new CategoryItemEntity(var16, var29, (String)null, var7, var8, var7.getColumnKey(var9), var9);
               var28.add(var26);
            }
         }
      }

   }

   private Icon getIcon(Shape var1, Paint var2, Paint var3) {
      int var4 = var1.getBounds().width;
      int var5 = var1.getBounds().height;
      GeneralPath var6 = new GeneralPath(var1);
      return new MinMaxCategoryRenderer$1(this, var6, var2, var3, var4, var5);
   }

   private Icon getIcon(Shape var1, boolean var2, boolean var3) {
      int var4 = var1.getBounds().width;
      int var5 = var1.getBounds().height;
      GeneralPath var6 = new GeneralPath(var1);
      return new MinMaxCategoryRenderer$2(this, var6, var2, var3, var4, var5);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.groupStroke, var1);
      SerialUtilities.writePaint(this.groupPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.groupStroke = SerialUtilities.readStroke(var1);
      this.groupPaint = SerialUtilities.readPaint(var1);
      this.minIcon = this.getIcon(new Double(-4.0D, -4.0D, 8.0D, 8.0D, 0.0D, 360.0D, 0), (Paint)null, Color.black);
      this.maxIcon = this.getIcon(new Double(-4.0D, -4.0D, 8.0D, 8.0D, 0.0D, 360.0D, 0), (Paint)null, Color.black);
      this.objectIcon = this.getIcon(new java.awt.geom.Line2D.Double(-4.0D, 0.0D, 4.0D, 0.0D), false, true);
   }
}
