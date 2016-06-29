package org.jfree.chart.plot;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class CombinedDomainXYPlot extends XYPlot implements Serializable, Cloneable, PlotChangeListener, PublicCloneable {
   private static final long serialVersionUID = -7765545541261907383L;
   private List subplots;
   private int totalWeight;
   private double gap;
   private transient Rectangle2D[] subplotAreas;

   public CombinedDomainXYPlot() {
      this(new NumberAxis());
   }

   public CombinedDomainXYPlot(ValueAxis var1) {
      super((XYDataset)null, var1, (ValueAxis)null, (XYItemRenderer)null);
      this.totalWeight = 0;
      this.gap = 5.0D;
      this.subplots = new ArrayList();
   }

   public String getPlotType() {
      return "Combined_Domain_XYPlot";
   }

   public void setOrientation(PlotOrientation var1) {
      super.setOrientation(var1);
      Iterator var2 = this.subplots.iterator();

      while(var2.hasNext()) {
         XYPlot var3 = (XYPlot)var2.next();
         var3.setOrientation(var1);
      }

   }

   public Range getDataRange(ValueAxis var1) {
      Range var2 = null;
      XYPlot var4;
      if(this.subplots != null) {
         for(Iterator var3 = this.subplots.iterator(); var3.hasNext(); var2 = Range.combine(var2, var4.getDataRange(var1))) {
            var4 = (XYPlot)var3.next();
         }
      }

      return var2;
   }

   public double getGap() {
      return this.gap;
   }

   public void setGap(double var1) {
      this.gap = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void add(XYPlot var1) {
      this.add(var1, 1);
   }

   public void add(XYPlot var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'subplot\' argument.");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("Require weight >= 1.");
      } else {
         var1.setParent(this);
         var1.setWeight(var2);
         var1.setInsets(new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D), false);
         var1.setDomainAxis((ValueAxis)null);
         var1.addChangeListener(this);
         this.subplots.add(var1);
         this.totalWeight += var2;
         ValueAxis var3 = this.getDomainAxis();
         if(var3 != null) {
            var3.configure();
         }

         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public void remove(XYPlot var1) {
      if(var1 == null) {
         throw new IllegalArgumentException(" Null \'subplot\' argument.");
      } else {
         int var2 = -1;
         int var3 = this.subplots.size();

         for(int var4 = 0; var2 == -1 && var4 < var3; ++var4) {
            if(this.subplots.get(var4) == var1) {
               var2 = var4;
            }
         }

         if(var2 != -1) {
            this.subplots.remove(var2);
            var1.setParent((Plot)null);
            var1.removeChangeListener(this);
            this.totalWeight -= var1.getWeight();
            ValueAxis var5 = this.getDomainAxis();
            if(var5 != null) {
               var5.configure();
            }

            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public List getSubplots() {
      return Collections.unmodifiableList(this.subplots);
   }

   protected AxisSpace calculateAxisSpace(Graphics2D var1, Rectangle2D var2) {
      AxisSpace var3 = new AxisSpace();
      PlotOrientation var4 = this.getOrientation();
      AxisSpace var5 = this.getFixedDomainAxisSpace();
      if(var5 != null) {
         if(var4 == PlotOrientation.HORIZONTAL) {
            var3.setLeft(var5.getLeft());
            var3.setRight(var5.getRight());
         } else if(var4 == PlotOrientation.VERTICAL) {
            var3.setTop(var5.getTop());
            var3.setBottom(var5.getBottom());
         }
      } else {
         ValueAxis var6 = this.getDomainAxis();
         RectangleEdge var7 = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), var4);
         if(var6 != null) {
            var3 = var6.reserveSpace(var1, this, var2, var7, var3);
         }
      }

      Rectangle2D var19 = var3.shrink(var2, (Rectangle2D)null);
      int var20 = this.subplots.size();
      this.subplotAreas = new Rectangle2D[var20];
      double var8 = var19.getX();
      double var10 = var19.getY();
      double var12 = 0.0D;
      if(var4 == PlotOrientation.HORIZONTAL) {
         var12 = var19.getWidth() - this.gap * (double)(var20 - 1);
      } else if(var4 == PlotOrientation.VERTICAL) {
         var12 = var19.getHeight() - this.gap * (double)(var20 - 1);
      }

      for(int var14 = 0; var14 < var20; ++var14) {
         XYPlot var15 = (XYPlot)this.subplots.get(var14);
         double var16;
         if(var4 == PlotOrientation.HORIZONTAL) {
            var16 = var12 * (double)var15.getWeight() / (double)this.totalWeight;
            this.subplotAreas[var14] = new Double(var8, var10, var16, var19.getHeight());
            var8 = var8 + var16 + this.gap;
         } else if(var4 == PlotOrientation.VERTICAL) {
            var16 = var12 * (double)var15.getWeight() / (double)this.totalWeight;
            this.subplotAreas[var14] = new Double(var8, var10, var19.getWidth(), var16);
            var10 = var10 + var16 + this.gap;
         }

         AxisSpace var18 = var15.calculateRangeAxisSpace(var1, this.subplotAreas[var14], (AxisSpace)null);
         var3.ensureAtLeast(var18);
      }

      return var3;
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      if(var5 != null) {
         var5.setPlotArea(var2);
      }

      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      AxisSpace var7 = this.calculateAxisSpace(var1, var2);
      Rectangle2D var8 = var7.shrink(var2, (Rectangle2D)null);
      this.setFixedRangeAxisSpaceForSubplots(var7);
      ValueAxis var9 = this.getDomainAxis();
      RectangleEdge var10 = this.getDomainAxisEdge();
      double var11 = RectangleEdge.coordinate(var8, var10);
      AxisState var13 = var9.draw(var1, var11, var2, var8, var10, var5);
      if(var4 == null) {
         var4 = new PlotState();
      }

      var4.getSharedAxisStates().put(var9, var13);

      for(int var14 = 0; var14 < this.subplots.size(); ++var14) {
         XYPlot var15 = (XYPlot)this.subplots.get(var14);
         PlotRenderingInfo var16 = null;
         if(var5 != null) {
            var16 = new PlotRenderingInfo(var5.getOwner());
            var5.addSubplotInfo(var16);
         }

         var15.draw(var1, this.subplotAreas[var14], var3, var4, var16);
      }

      if(var5 != null) {
         var5.setDataArea(var8);
      }

   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = this.getFixedLegendItems();
      if(var1 == null) {
         var1 = new LegendItemCollection();
         if(this.subplots != null) {
            Iterator var2 = this.subplots.iterator();

            while(var2.hasNext()) {
               XYPlot var3 = (XYPlot)var2.next();
               LegendItemCollection var4 = var3.getLegendItems();
               var1.addAll(var4);
            }
         }
      }

      return var1;
   }

   public void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      XYPlot var5 = this.findSubplot(var3, var4);
      if(var5 != null) {
         var5.zoomRangeAxes(var1, var3, var4);
      }

   }

   public void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      XYPlot var7 = this.findSubplot(var5, var6);
      if(var7 != null) {
         var7.zoomRangeAxes(var1, var3, var5, var6);
      }

   }

   public XYPlot findSubplot(PlotRenderingInfo var1, Point2D var2) {
      XYPlot var3 = null;
      int var4 = var1.getSubplotIndex(var2);
      if(var4 >= 0) {
         var3 = (XYPlot)this.subplots.get(var4);
      }

      return var3;
   }

   public void setRenderer(XYItemRenderer var1) {
      super.setRenderer(var1);
      Iterator var2 = this.subplots.iterator();

      while(var2.hasNext()) {
         XYPlot var3 = (XYPlot)var2.next();
         var3.setRenderer(var1);
      }

   }

   public void setFixedRangeAxisSpace(AxisSpace var1) {
      super.setFixedRangeAxisSpace(var1);
      this.setFixedRangeAxisSpaceForSubplots(var1);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   protected void setFixedRangeAxisSpaceForSubplots(AxisSpace var1) {
      Iterator var2 = this.subplots.iterator();

      while(var2.hasNext()) {
         XYPlot var3 = (XYPlot)var2.next();
         var3.setFixedRangeAxisSpace(var1);
      }

   }

   public void handleClick(int var1, int var2, PlotRenderingInfo var3) {
      Rectangle2D var4 = var3.getDataArea();
      if(var4.contains((double)var1, (double)var2)) {
         for(int var5 = 0; var5 < this.subplots.size(); ++var5) {
            XYPlot var6 = (XYPlot)this.subplots.get(var5);
            PlotRenderingInfo var7 = var3.getSubplotInfo(var5);
            var6.handleClick(var1, var2, var7);
         }
      }

   }

   public void plotChanged(PlotChangeEvent var1) {
      this.notifyListeners(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CombinedDomainXYPlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CombinedDomainXYPlot var2 = (CombinedDomainXYPlot)var1;
         return this.totalWeight != var2.totalWeight?false:(this.gap != var2.gap?false:ObjectUtilities.equal(this.subplots, var2.subplots));
      }
   }

   public Object clone() {
      CombinedDomainXYPlot var1 = (CombinedDomainXYPlot)super.clone();
      var1.subplots = (List)ObjectUtilities.deepClone(this.subplots);
      Iterator var2 = var1.subplots.iterator();

      while(var2.hasNext()) {
         Plot var3 = (Plot)var2.next();
         var3.setParent(var1);
      }

      ValueAxis var4 = var1.getDomainAxis();
      if(var4 != null) {
         var4.configure();
      }

      return var1;
   }
}
