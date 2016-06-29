package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.UnitType;

public class RingPlot extends PiePlot implements Serializable, Cloneable {
   private static final long serialVersionUID = 1556064784129676620L;
   private boolean separatorsVisible;
   private transient Stroke separatorStroke;
   private transient Paint separatorPaint;
   private double innerSeparatorExtension;
   private double outerSeparatorExtension;
   private double sectionDepth;

   public RingPlot() {
      this((PieDataset)null);
   }

   public RingPlot(PieDataset var1) {
      super(var1);
      this.separatorsVisible = true;
      this.separatorStroke = new BasicStroke(0.5F);
      this.separatorPaint = Color.gray;
      this.innerSeparatorExtension = 0.2D;
      this.outerSeparatorExtension = 0.2D;
      this.sectionDepth = 0.2D;
   }

   public boolean getSeparatorsVisible() {
      return this.separatorsVisible;
   }

   public void setSeparatorsVisible(boolean var1) {
      this.separatorsVisible = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getSeparatorStroke() {
      return this.separatorStroke;
   }

   public void setSeparatorStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.separatorStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getSeparatorPaint() {
      return this.separatorPaint;
   }

   public void setSeparatorPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.separatorPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getInnerSeparatorExtension() {
      return this.innerSeparatorExtension;
   }

   public void setInnerSeparatorExtension(double var1) {
      this.innerSeparatorExtension = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getOuterSeparatorExtension() {
      return this.outerSeparatorExtension;
   }

   public void setOuterSeparatorExtension(double var1) {
      this.outerSeparatorExtension = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getSectionDepth() {
      return this.sectionDepth;
   }

   public void setSectionDepth(double var1) {
      this.sectionDepth = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public PiePlotState initialise(Graphics2D var1, Rectangle2D var2, PiePlot var3, Integer var4, PlotRenderingInfo var5) {
      PiePlotState var6 = super.initialise(var1, var2, var3, var4, var5);
      var6.setPassesRequired(3);
      return var6;
   }

   protected void drawItem(Graphics2D var1, int var2, Rectangle2D var3, PiePlotState var4, int var5) {
      PieDataset var6 = this.getDataset();
      Number var7 = var6.getValue(var2);
      if(var7 != null) {
         double var8 = var7.doubleValue();
         double var10 = 0.0D;
         double var12 = 0.0D;
         Rotation var14 = this.getDirection();
         if(var14 == Rotation.CLOCKWISE) {
            var10 = var4.getLatestAngle();
            var12 = var10 - var8 / var4.getTotal() * 360.0D;
         } else {
            if(var14 != Rotation.ANTICLOCKWISE) {
               throw new IllegalStateException("Rotation type not recognised.");
            }

            var10 = var4.getLatestAngle();
            var12 = var10 + var8 / var4.getTotal() * 360.0D;
         }

         double var15 = var12 - var10;
         if(Math.abs(var15) > this.getMinimumArcAngleToDraw()) {
            Comparable var17 = this.getSectionKey(var2);
            double var18 = 0.0D;
            double var20 = this.getMaximumExplodePercent();
            if(var20 > 0.0D) {
               var18 = this.getExplodePercent(var17) / var20;
            }

            Rectangle2D var22 = this.getArcBounds(var4.getPieArea(), var4.getExplodedPieArea(), var10, var15, var18);
            Double var23 = new Double(var22, var10, var15, 0);
            double var24 = this.sectionDepth / 2.0D;
            RectangleInsets var26 = new RectangleInsets(UnitType.RELATIVE, var24, var24, var24, var24);
            java.awt.geom.Rectangle2D.Double var27 = new java.awt.geom.Rectangle2D.Double();
            var27.setRect(var22);
            var26.trim(var27);
            Double var28 = new Double(var27, var10 + var15, -var15, 0);
            GeneralPath var29 = new GeneralPath();
            var29.moveTo((float)var23.getStartPoint().getX(), (float)var23.getStartPoint().getY());
            var29.append(var23.getPathIterator((AffineTransform)null), false);
            var29.append(var28.getPathIterator((AffineTransform)null), true);
            var29.closePath();
            java.awt.geom.Line2D.Double var30 = new java.awt.geom.Line2D.Double(var28.getEndPoint(), var23.getStartPoint());
            Paint var31;
            if(var5 == 0) {
               var31 = this.getShadowPaint();
               double var32 = this.getShadowXOffset();
               double var34 = this.getShadowYOffset();
               if(var31 != null) {
                  Shape var36 = ShapeUtilities.createTranslatedShape(var29, (double)((float)var32), (double)((float)var34));
                  var1.setPaint(var31);
                  var1.fill(var36);
               }
            } else if(var5 == 1) {
               var31 = this.lookupSectionPaint(var17, true);
               var1.setPaint(var31);
               var1.fill(var29);
               Paint var41 = this.lookupSectionOutlinePaint(var17);
               Stroke var33 = this.lookupSectionOutlineStroke(var17);
               if(var41 != null && var33 != null) {
                  var1.setPaint(var41);
                  var1.setStroke(var33);
                  var1.draw(var29);
               }

               if(var4.getInfo() != null) {
                  EntityCollection var42 = var4.getEntityCollection();
                  if(var42 != null) {
                     String var35 = null;
                     PieToolTipGenerator var43 = this.getToolTipGenerator();
                     if(var43 != null) {
                        var35 = var43.generateToolTip(var6, var17);
                     }

                     String var37 = null;
                     PieURLGenerator var38 = this.getURLGenerator();
                     if(var38 != null) {
                        var37 = var38.generateURL(var6, var17, this.getPieIndex());
                     }

                     PieSectionEntity var39 = new PieSectionEntity(var29, var6, this.getPieIndex(), var2, var17, var35, var37);
                     var42.add(var39);
                  }
               }
            } else if(var5 == 2 && this.separatorsVisible) {
               Line2D var40 = this.extendLine(var30, this.innerSeparatorExtension, this.outerSeparatorExtension);
               var1.setStroke(this.separatorStroke);
               var1.setPaint(this.separatorPaint);
               var1.draw(var40);
            }
         }

         var4.setLatestAngle(var12);
      }
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof RingPlot)) {
         return false;
      } else {
         RingPlot var2 = (RingPlot)var1;
         return this.separatorsVisible != var2.separatorsVisible?false:(!ObjectUtilities.equal(this.separatorStroke, var2.separatorStroke)?false:(!PaintUtilities.equal(this.separatorPaint, var2.separatorPaint)?false:(this.innerSeparatorExtension != var2.innerSeparatorExtension?false:(this.outerSeparatorExtension != var2.outerSeparatorExtension?false:(this.sectionDepth != var2.sectionDepth?false:super.equals(var1))))));
      }
   }

   private Line2D extendLine(Line2D var1, double var2, double var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'line\' argument.");
      } else {
         double var6 = var1.getX1();
         double var8 = var1.getX2();
         double var10 = var8 - var6;
         double var12 = var1.getY1();
         double var14 = var1.getY2();
         double var16 = var14 - var12;
         var6 -= var2 * var10;
         var12 -= var2 * var16;
         var8 += var4 * var10;
         var14 += var4 * var16;
         return new java.awt.geom.Line2D.Double(var6, var12, var8, var14);
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.separatorStroke, var1);
      SerialUtilities.writePaint(this.separatorPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.separatorStroke = SerialUtilities.readStroke(var1);
      this.separatorPaint = SerialUtilities.readPaint(var1);
   }
}
