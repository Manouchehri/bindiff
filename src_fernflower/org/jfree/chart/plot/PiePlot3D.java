package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;

public class PiePlot3D extends PiePlot implements Serializable {
   private static final long serialVersionUID = 3408984188945161432L;
   private double depthFactor;

   public PiePlot3D() {
      this((PieDataset)null);
   }

   public PiePlot3D(PieDataset var1) {
      super(var1);
      this.depthFactor = 0.2D;
      this.setCircular(false, false);
   }

   public double getDepthFactor() {
      return this.depthFactor;
   }

   public void setDepthFactor(double var1) {
      this.depthFactor = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      Rectangle2D var7 = (Rectangle2D)var2.clone();
      if(var5 != null) {
         var5.setPlotArea(var2);
         var5.setDataArea(var2);
      }

      Shape var8 = var1.getClip();
      var1.clip(var2);
      double var9 = this.getInteriorGap();
      double var11 = 0.0D;
      if(this.getLabelGenerator() != null) {
         var11 = this.getLabelGap() + this.getMaximumLabelWidth() + this.getLabelLinkMargin();
      }

      double var13 = var2.getWidth() * (var9 + var11);
      double var15 = var2.getHeight() * var9;
      double var17 = var2.getX() + var13 / 2.0D;
      double var19 = var2.getY() + var15 / 2.0D;
      double var21 = var2.getWidth() - var13;
      double var23 = var2.getHeight() - var15;
      if(this.isCircular()) {
         double var25 = Math.min(var21, var23) / 2.0D;
         var17 = (var17 + var17 + var21) / 2.0D - var25;
         var19 = (var19 + var19 + var23) / 2.0D - var25;
         var21 = 2.0D * var25;
         var23 = 2.0D * var25;
      }

      PiePlotState var81 = this.initialise(var1, var2, this, (Integer)null, var5);
      double var26 = var21 * this.getLabelLinkMargin();
      double var28 = var23 * this.getLabelLinkMargin();
      Double var30 = new Double(var17 + var26 / 2.0D, var19 + var28 / 2.0D, var21 - var26, var23 - var28);
      var81.setExplodedPieArea(var30);
      double var31 = this.getMaximumExplodePercent();
      double var33 = var31 / (1.0D + var31);
      double var35 = var30.getWidth() * var33;
      double var37 = var30.getHeight() * var33;
      Double var39 = new Double(var30.getX() + var35 / 2.0D, var30.getY() + var37 / 2.0D, var30.getWidth() - var35, var30.getHeight() - var37);
      int var40 = (int)(var39.getHeight() * this.depthFactor);
      Double var41 = new Double(var17, var19, var21, var23 - (double)var40);
      var81.setLinkArea(var41);
      var81.setPieArea(var39);
      var81.setPieCenterX(var39.getCenterX());
      var81.setPieCenterY(var39.getCenterY() - (double)var40 / 2.0D);
      var81.setPieWRadius(var39.getWidth() / 2.0D);
      var81.setPieHRadius((var39.getHeight() - (double)var40) / 2.0D);
      this.drawBackground(var1, var2);
      PieDataset var42 = this.getDataset();
      if(DatasetUtilities.isEmptyOrNull(this.getDataset())) {
         this.drawNoDataMessage(var1, var2);
         var1.setClip(var8);
         this.drawOutline(var1, var2);
      } else if((double)var42.getKeys().size() > var2.getWidth()) {
         String var83 = "Too many elements";
         Font var84 = new Font("dialog", 1, 10);
         var1.setFont(var84);
         FontMetrics var45 = var1.getFontMetrics(var84);
         int var85 = var45.stringWidth(var83);
         var1.drawString(var83, (int)(var2.getX() + (var2.getWidth() - (double)var85) / 2.0D), (int)(var2.getY() + var2.getHeight() / 2.0D));
      } else {
         if(this.isCircular()) {
            double var43 = Math.min(var2.getWidth(), var2.getHeight()) / 2.0D;
            new Double(var2.getCenterX() - var43, var2.getCenterY() - var43, 2.0D * var43, 2.0D * var43);
         }

         List var82 = var42.getKeys();
         if(var82.size() != 0) {
            double var44 = var39.getX();
            double var46 = var39.getY();
            Composite var48 = var1.getComposite();
            var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
            double var49 = DatasetUtilities.calculatePieDatasetTotal(var42);
            double var51 = 0.0D;
            if(var40 >= 0) {
               ArrayList var53 = new ArrayList();
               Iterator var58 = var82.iterator();

               while(var58.hasNext()) {
                  Comparable var59 = (Comparable)var58.next();
                  Number var60 = var42.getValue(var59);
                  if(var60 == null) {
                     var53.add((Object)null);
                  } else {
                     double var61 = var60.doubleValue();
                     if(var61 <= 0.0D) {
                        var53.add((Object)null);
                     } else {
                        double var63 = this.getStartAngle();
                        double var65 = this.getDirection().getFactor();
                        double var67 = var63 + var65 * var51 * 360.0D / var49;
                        double var69 = var63 + var65 * (var51 + var61) * 360.0D / var49;
                        if(Math.abs(var69 - var67) > this.getMinimumArcAngleToDraw()) {
                           var53.add(new java.awt.geom.Arc2D.Double(var44, var46 + (double)var40, var39.getWidth(), var39.getHeight() - (double)var40, var67, var69 - var67, 2));
                        } else {
                           var53.add((Object)null);
                        }

                        var51 += var61;
                     }
                  }
               }

               Shape var86 = var1.getClip();
               java.awt.geom.Ellipse2D.Double var87 = new java.awt.geom.Ellipse2D.Double(var39.getX(), var39.getY(), var39.getWidth(), var39.getHeight() - (double)var40);
               java.awt.geom.Ellipse2D.Double var88 = new java.awt.geom.Ellipse2D.Double(var39.getX(), var39.getY() + (double)var40, var39.getWidth(), var39.getHeight() - (double)var40);
               Double var62 = new Double(var87.getX(), var87.getCenterY(), var39.getWidth(), var88.getMaxY() - var87.getCenterY());
               Double var89 = new Double(var39.getX(), var87.getY(), var39.getWidth(), var88.getCenterY() - var87.getY());
               Area var64 = new Area(var87);
               var64.add(new Area(var62));
               Area var90 = new Area(var88);
               var90.add(new Area(var89));
               Area var66 = new Area(var64);
               var66.intersect(var90);
               Area var91 = new Area(var66);
               var91.subtract(new Area(var87));
               Area var68 = new Area(var66);
               var68.subtract(new Area(var88));
               new java.awt.geom.Arc2D.Double(var44, var46 + (double)var40, var39.getWidth(), var39.getHeight() - (double)var40, 0.0D, 360.0D, 2);
               int var71 = var53.size();

               java.awt.geom.Arc2D.Double var54;
               Paint var55;
               Paint var56;
               Stroke var57;
               int var72;
               for(var72 = 0; var72 < var71; ++var72) {
                  var54 = (java.awt.geom.Arc2D.Double)var53.get(var72);
                  if(var54 != null) {
                     Comparable var73 = this.getSectionKey(var72);
                     var55 = this.lookupSectionPaint(var73, true);
                     var56 = this.lookupSectionOutlinePaint(var73);
                     var57 = this.lookupSectionOutlineStroke(var73);
                     var1.setPaint(var55);
                     var1.fill(var54);
                     var1.setPaint(var56);
                     var1.setStroke(var57);
                     var1.draw(var54);
                     var1.setPaint(var55);
                     Point2D var74 = var54.getStartPoint();
                     int[] var92 = new int[]{(int)var54.getCenterX(), (int)var54.getCenterX(), (int)var74.getX(), (int)var74.getX()};
                     int[] var70 = new int[]{(int)var54.getCenterY(), (int)var54.getCenterY() - var40, (int)var74.getY() - var40, (int)var74.getY()};
                     Polygon var75 = new Polygon(var92, var70, 4);
                     var1.setPaint(Color.lightGray);
                     var1.fill(var75);
                     var1.setPaint(var56);
                     var1.setStroke(var57);
                     var1.draw(var75);
                     var1.setPaint(var55);
                  }
               }

               var1.setPaint(Color.gray);
               var1.fill(var68);
               var1.fill(var91);
               var72 = 0;

               Arc2D var93;
               Comparable var95;
               for(var58 = var53.iterator(); var58.hasNext(); ++var72) {
                  var93 = (Arc2D)var58.next();
                  if(var93 != null) {
                     var95 = this.getSectionKey(var72);
                     var55 = this.lookupSectionPaint(var95, true);
                     var56 = this.lookupSectionOutlinePaint(var95);
                     var57 = this.lookupSectionOutlineStroke(var95);
                     this.drawSide(var1, var39, var93, var91, var68, var55, var56, var57, false, true);
                  }
               }

               var72 = 0;

               for(var58 = var53.iterator(); var58.hasNext(); ++var72) {
                  var93 = (Arc2D)var58.next();
                  if(var93 != null) {
                     var95 = this.getSectionKey(var72);
                     var55 = this.lookupSectionPaint(var95);
                     var56 = this.lookupSectionOutlinePaint(var95);
                     var57 = this.lookupSectionOutlineStroke(var95);
                     this.drawSide(var1, var39, var93, var91, var68, var55, var56, var57, true, false);
                  }
               }

               var1.setClip(var86);

               for(int var96 = 0; var96 < var71; ++var96) {
                  var54 = (java.awt.geom.Arc2D.Double)var53.get(var96);
                  if(var54 != null) {
                     java.awt.geom.Arc2D.Double var94 = new java.awt.geom.Arc2D.Double(var44, var46, var39.getWidth(), var39.getHeight() - (double)var40, var54.getAngleStart(), var54.getAngleExtent(), 2);
                     Comparable var97 = (Comparable)var82.get(var96);
                     var55 = this.lookupSectionPaint(var97, true);
                     var56 = this.lookupSectionOutlinePaint(var97);
                     var57 = this.lookupSectionOutlineStroke(var97);
                     var1.setPaint(var55);
                     var1.fill(var94);
                     var1.setStroke(var57);
                     var1.setPaint(var56);
                     var1.draw(var94);
                     if(var5 != null) {
                        EntityCollection var76 = var5.getOwner().getEntityCollection();
                        if(var76 != null) {
                           String var77 = null;
                           PieToolTipGenerator var78 = this.getToolTipGenerator();
                           if(var78 != null) {
                              var77 = var78.generateToolTip(var42, var97);
                           }

                           String var79 = null;
                           if(this.getURLGenerator() != null) {
                              var79 = this.getURLGenerator().generateURL(var42, var97, this.getPieIndex());
                           }

                           PieSectionEntity var80 = new PieSectionEntity(var94, var42, this.getPieIndex(), var96, var97, var77, var79);
                           var76.add(var80);
                        }
                     }

                     List var98 = var42.getKeys();
                     Double var99 = new Double(var7.getX(), var7.getY(), var7.getWidth(), var7.getHeight() - (double)var40);
                     this.drawLabels(var1, var98, var49, var99, var41, var81);
                  }
               }

               var1.setClip(var8);
               var1.setComposite(var48);
               this.drawOutline(var1, var7);
            }
         }
      }
   }

   protected void drawSide(Graphics2D var1, Rectangle2D var2, Arc2D var3, Area var4, Area var5, Paint var6, Paint var7, Stroke var8, boolean var9, boolean var10) {
      double var11 = var3.getAngleStart();
      double var13 = var3.getAngleExtent();
      double var15 = var11 + var13;
      var1.setStroke(var8);
      Area var17;
      Area var18;
      if(var13 < 0.0D) {
         if(this.isAngleAtFront(var11)) {
            if(!this.isAngleAtBack(var15)) {
               if(var13 > -180.0D) {
                  if(var9) {
                     var17 = new Area(new Double(var3.getEndPoint().getX(), var2.getY(), var3.getStartPoint().getX() - var3.getEndPoint().getX(), var2.getHeight()));
                     var17.intersect(var4);
                     var1.setPaint(var6);
                     var1.fill(var17);
                     var1.setPaint(var7);
                     var1.draw(var17);
                  }
               } else {
                  var17 = new Area(new Double(var2.getX(), var2.getY(), var3.getStartPoint().getX() - var2.getX(), var2.getHeight()));
                  var17.intersect(var4);
                  var18 = new Area(new Double(var3.getEndPoint().getX(), var2.getY(), var2.getMaxX() - var3.getEndPoint().getX(), var2.getHeight()));
                  var18.intersect(var4);
                  var1.setPaint(var6);
                  if(var9) {
                     var1.fill(var17);
                     var1.fill(var18);
                  }

                  if(var10) {
                     var1.fill(var5);
                  }

                  var1.setPaint(var7);
                  if(var9) {
                     var1.draw(var17);
                     var1.draw(var18);
                  }

                  if(var10) {
                     var1.draw(var5);
                  }
               }
            } else {
               if(var10) {
                  var17 = new Area(new Double(var2.getX(), var2.getY(), var3.getEndPoint().getX() - var2.getX(), var2.getHeight()));
                  var17.intersect(var5);
                  var1.setPaint(var6);
                  var1.fill(var17);
                  var1.setPaint(var7);
                  var1.draw(var17);
               }

               if(var9) {
                  var17 = new Area(new Double(var2.getX(), var2.getY(), var3.getStartPoint().getX() - var2.getX(), var2.getHeight()));
                  var17.intersect(var4);
                  var1.setPaint(var6);
                  var1.fill(var17);
                  var1.setPaint(var7);
                  var1.draw(var17);
               }
            }
         } else if(!this.isAngleAtFront(var15)) {
            if(var13 > -180.0D) {
               if(var10) {
                  var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var3.getEndPoint().getX() - var3.getStartPoint().getX(), var2.getHeight()));
                  var17.intersect(var5);
                  var1.setPaint(var6);
                  var1.fill(var17);
                  var1.setPaint(var7);
                  var1.draw(var17);
               }
            } else {
               var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var2.getMaxX() - var3.getStartPoint().getX(), var2.getHeight()));
               var17.intersect(var5);
               var18 = new Area(new Double(var2.getX(), var2.getY(), var3.getEndPoint().getX() - var2.getX(), var2.getHeight()));
               var18.intersect(var5);
               var1.setPaint(var6);
               if(var10) {
                  var1.fill(var17);
                  var1.fill(var18);
               }

               if(var9) {
                  var1.fill(var4);
               }

               var1.setPaint(var7);
               if(var10) {
                  var1.draw(var17);
                  var1.draw(var18);
               }

               if(var9) {
                  var1.draw(var4);
               }
            }
         } else {
            if(var10) {
               var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var2.getMaxX() - var3.getStartPoint().getX(), var2.getHeight()));
               var17.intersect(var5);
               var1.setPaint(var6);
               var1.fill(var17);
               var1.setPaint(var7);
               var1.draw(var17);
            }

            if(var9) {
               var17 = new Area(new Double(var3.getEndPoint().getX(), var2.getY(), var2.getMaxX() - var3.getEndPoint().getX(), var2.getHeight()));
               var17.intersect(var4);
               var1.setPaint(var6);
               var1.fill(var17);
               var1.setPaint(var7);
               var1.draw(var17);
            }
         }
      } else if(var13 > 0.0D) {
         if(this.isAngleAtFront(var11)) {
            if(!this.isAngleAtBack(var15)) {
               if(var13 < 180.0D) {
                  if(var9) {
                     var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var3.getEndPoint().getX() - var3.getStartPoint().getX(), var2.getHeight()));
                     var17.intersect(var4);
                     var1.setPaint(var6);
                     var1.fill(var17);
                     var1.setPaint(var7);
                     var1.draw(var17);
                  }
               } else {
                  var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var2.getMaxX() - var3.getStartPoint().getX(), var2.getHeight()));
                  var17.intersect(var4);
                  var18 = new Area(new Double(var2.getX(), var2.getY(), var3.getEndPoint().getX() - var2.getX(), var2.getHeight()));
                  var18.intersect(var4);
                  var1.setPaint(var6);
                  if(var9) {
                     var1.fill(var17);
                     var1.fill(var18);
                  }

                  if(var10) {
                     var1.fill(var5);
                  }

                  var1.setPaint(var7);
                  if(var9) {
                     var1.draw(var17);
                     var1.draw(var18);
                  }

                  if(var10) {
                     var1.draw(var5);
                  }
               }
            } else {
               if(var10) {
                  var17 = new Area(new Double(var3.getEndPoint().getX(), var2.getY(), var2.getMaxX() - var3.getEndPoint().getX(), var2.getHeight()));
                  var17.intersect(var5);
                  var1.setPaint(var6);
                  var1.fill(var17);
                  var1.setPaint(var7);
                  var1.draw(var17);
               }

               if(var9) {
                  var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var2.getMaxX() - var3.getStartPoint().getX(), var2.getHeight()));
                  var17.intersect(var4);
                  var1.setPaint(var6);
                  var1.fill(var17);
                  var1.setPaint(var7);
                  var1.draw(var17);
               }
            }
         } else if(!this.isAngleAtFront(var15)) {
            if(var13 < 180.0D) {
               if(var10) {
                  var17 = new Area(new Double(var3.getEndPoint().getX(), var2.getY(), var3.getStartPoint().getX() - var3.getEndPoint().getX(), var2.getHeight()));
                  var17.intersect(var5);
                  var1.setPaint(var6);
                  var1.fill(var17);
                  var1.setPaint(var7);
                  var1.draw(var17);
               }
            } else {
               var17 = new Area(new Double(var3.getStartPoint().getX(), var2.getY(), var2.getX() - var3.getStartPoint().getX(), var2.getHeight()));
               var17.intersect(var5);
               var18 = new Area(new Double(var3.getEndPoint().getX(), var2.getY(), var2.getMaxX() - var3.getEndPoint().getX(), var2.getHeight()));
               var18.intersect(var5);
               var1.setPaint(var6);
               if(var10) {
                  var1.fill(var17);
                  var1.fill(var18);
               }

               if(var9) {
                  var1.fill(var4);
               }

               var1.setPaint(var7);
               if(var10) {
                  var1.draw(var17);
                  var1.draw(var18);
               }

               if(var9) {
                  var1.draw(var4);
               }
            }
         } else {
            if(var10) {
               var17 = new Area(new Double(var2.getX(), var2.getY(), var3.getStartPoint().getX() - var2.getX(), var2.getHeight()));
               var17.intersect(var5);
               var1.setPaint(var6);
               var1.fill(var17);
               var1.setPaint(var7);
               var1.draw(var17);
            }

            if(var9) {
               var17 = new Area(new Double(var2.getX(), var2.getY(), var3.getEndPoint().getX() - var2.getX(), var2.getHeight()));
               var17.intersect(var4);
               var1.setPaint(var6);
               var1.fill(var17);
               var1.setPaint(var7);
               var1.draw(var17);
            }
         }
      }

   }

   public String getPlotType() {
      return localizationResources.getString("Pie_3D_Plot");
   }

   private boolean isAngleAtFront(double var1) {
      return Math.sin(Math.toRadians(var1)) < 0.0D;
   }

   private boolean isAngleAtBack(double var1) {
      return Math.sin(Math.toRadians(var1)) > 0.0D;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof PiePlot3D)) {
         return false;
      } else {
         PiePlot3D var2 = (PiePlot3D)var1;
         return this.depthFactor != var2.depthFactor?false:super.equals(var1);
      }
   }
}
