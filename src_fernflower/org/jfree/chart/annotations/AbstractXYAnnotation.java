package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYAnnotationEntity;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.util.ObjectUtilities;

public abstract class AbstractXYAnnotation implements XYAnnotation {
   private String toolTipText = null;
   private String url = null;

   public String getToolTipText() {
      return this.toolTipText;
   }

   public void setToolTipText(String var1) {
      this.toolTipText = var1;
   }

   public String getURL() {
      return this.url;
   }

   public void setURL(String var1) {
      this.url = var1;
   }

   public abstract void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7);

   protected void addEntity(PlotRenderingInfo var1, Shape var2, int var3, String var4, String var5) {
      if(var1 != null) {
         EntityCollection var6 = var1.getOwner().getEntityCollection();
         if(var6 != null) {
            XYAnnotationEntity var7 = new XYAnnotationEntity(var2, var3, var4, var5);
            var6.add(var7);
         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractXYAnnotation)) {
         return false;
      } else {
         AbstractXYAnnotation var2 = (AbstractXYAnnotation)var1;
         return !ObjectUtilities.equal(this.toolTipText, var2.toolTipText)?false:ObjectUtilities.equal(this.url, var2.url);
      }
   }

   public int hashCode() {
      int var1 = 193;
      if(this.toolTipText != null) {
         var1 = 37 * var1 + this.toolTipText.hashCode();
      }

      if(this.url != null) {
         var1 = 37 * var1 + this.url.hashCode();
      }

      return var1;
   }
}
