package org.jfree.chart.plot;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;

public class PlotRenderingInfo implements Serializable, Cloneable {
   private static final long serialVersionUID = 8446720134379617220L;
   private ChartRenderingInfo owner;
   private transient Rectangle2D plotArea;
   private transient Rectangle2D dataArea;
   private List subplotInfo;

   public PlotRenderingInfo(ChartRenderingInfo var1) {
      this.owner = var1;
      this.dataArea = new Double();
      this.subplotInfo = new ArrayList();
   }

   public ChartRenderingInfo getOwner() {
      return this.owner;
   }

   public Rectangle2D getPlotArea() {
      return this.plotArea;
   }

   public void setPlotArea(Rectangle2D var1) {
      this.plotArea = var1;
   }

   public Rectangle2D getDataArea() {
      return this.dataArea;
   }

   public void setDataArea(Rectangle2D var1) {
      this.dataArea = var1;
   }

   public int getSubplotCount() {
      return this.subplotInfo.size();
   }

   public void addSubplotInfo(PlotRenderingInfo var1) {
      this.subplotInfo.add(var1);
   }

   public PlotRenderingInfo getSubplotInfo(int var1) {
      return (PlotRenderingInfo)this.subplotInfo.get(var1);
   }

   public int getSubplotIndex(Point2D var1) {
      int var2 = this.getSubplotCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         PlotRenderingInfo var4 = this.getSubplotInfo(var3);
         Rectangle2D var5 = var4.getDataArea();
         if(var5.contains(var1)) {
            return var3;
         }
      }

      return -1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PlotRenderingInfo)) {
         return false;
      } else {
         PlotRenderingInfo var2 = (PlotRenderingInfo)var1;
         return !ObjectUtilities.equal(this.dataArea, var2.dataArea)?false:(!ObjectUtilities.equal(this.plotArea, var2.plotArea)?false:ObjectUtilities.equal(this.subplotInfo, var2.subplotInfo));
      }
   }

   public Object clone() {
      PlotRenderingInfo var1 = (PlotRenderingInfo)super.clone();
      if(this.plotArea != null) {
         var1.plotArea = (Rectangle2D)this.plotArea.clone();
      }

      if(this.dataArea != null) {
         var1.dataArea = (Rectangle2D)this.dataArea.clone();
      }

      var1.subplotInfo = new ArrayList(this.subplotInfo.size());

      for(int var2 = 0; var2 < this.subplotInfo.size(); ++var2) {
         PlotRenderingInfo var3 = (PlotRenderingInfo)this.subplotInfo.get(var2);
         var1.subplotInfo.add(var3.clone());
      }

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.dataArea, var1);
      SerialUtilities.writeShape(this.plotArea, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.dataArea = (Rectangle2D)SerialUtilities.readShape(var1);
      this.plotArea = (Rectangle2D)SerialUtilities.readShape(var1);
   }
}
