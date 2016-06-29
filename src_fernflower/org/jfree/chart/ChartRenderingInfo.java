package org.jfree.chart;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class ChartRenderingInfo implements Serializable, Cloneable {
   private static final long serialVersionUID = 2751952018173406822L;
   private transient Rectangle2D chartArea;
   private PlotRenderingInfo plotInfo;
   private EntityCollection entities;

   public ChartRenderingInfo() {
      this(new StandardEntityCollection());
   }

   public ChartRenderingInfo(EntityCollection var1) {
      this.chartArea = new Double();
      this.plotInfo = new PlotRenderingInfo(this);
      this.entities = var1;
   }

   public Rectangle2D getChartArea() {
      return this.chartArea;
   }

   public void setChartArea(Rectangle2D var1) {
      this.chartArea.setRect(var1);
   }

   public EntityCollection getEntityCollection() {
      return this.entities;
   }

   public void setEntityCollection(EntityCollection var1) {
      this.entities = var1;
   }

   public void clear() {
      this.chartArea.setRect(0.0D, 0.0D, 0.0D, 0.0D);
      this.plotInfo = new PlotRenderingInfo(this);
      if(this.entities != null) {
         this.entities.clear();
      }

   }

   public PlotRenderingInfo getPlotInfo() {
      return this.plotInfo;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ChartRenderingInfo)) {
         return false;
      } else {
         ChartRenderingInfo var2 = (ChartRenderingInfo)var1;
         return !ObjectUtilities.equal(this.chartArea, var2.chartArea)?false:(!ObjectUtilities.equal(this.plotInfo, var2.plotInfo)?false:ObjectUtilities.equal(this.entities, var2.entities));
      }
   }

   public Object clone() {
      ChartRenderingInfo var1 = (ChartRenderingInfo)super.clone();
      if(this.chartArea != null) {
         var1.chartArea = (Rectangle2D)this.chartArea.clone();
      }

      if(this.entities instanceof PublicCloneable) {
         PublicCloneable var2 = (PublicCloneable)this.entities;
         var1.entities = (EntityCollection)var2.clone();
      }

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.chartArea, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.chartArea = (Rectangle2D)SerialUtilities.readShape(var1);
   }
}
