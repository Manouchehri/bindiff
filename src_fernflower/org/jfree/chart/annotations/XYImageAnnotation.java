package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class XYImageAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -4364694501921559958L;
   private double x;
   private double y;
   private transient Image image;
   private RectangleAnchor anchor;

   public XYImageAnnotation(double var1, double var3, Image var5) {
      this(var1, var3, var5, RectangleAnchor.CENTER);
   }

   public XYImageAnnotation(double var1, double var3, Image var5, RectangleAnchor var6) {
      if(var5 == null) {
         throw new IllegalArgumentException("Null \'image\' argument.");
      } else if(var6 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.x = var1;
         this.y = var3;
         this.image = var5;
         this.anchor = var6;
      }
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }

   public Image getImage() {
      return this.image;
   }

   public RectangleAnchor getImageAnchor() {
      return this.anchor;
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      AxisLocation var9 = var2.getDomainAxisLocation();
      AxisLocation var10 = var2.getRangeAxisLocation();
      RectangleEdge var11 = Plot.resolveDomainAxisLocation(var9, var8);
      RectangleEdge var12 = Plot.resolveRangeAxisLocation(var10, var8);
      float var13 = (float)var4.valueToJava2D(this.x, var3, var11);
      float var14 = (float)var5.valueToJava2D(this.y, var3, var12);
      float var15 = 0.0F;
      float var16 = 0.0F;
      if(var8 == PlotOrientation.HORIZONTAL) {
         var15 = var14;
         var16 = var13;
      } else if(var8 == PlotOrientation.VERTICAL) {
         var15 = var13;
         var16 = var14;
      }

      int var17 = this.image.getWidth((ImageObserver)null);
      int var18 = this.image.getHeight((ImageObserver)null);
      Double var19 = new Double(0.0D, 0.0D, (double)var17, (double)var18);
      Point2D var20 = RectangleAnchor.coordinates(var19, this.anchor);
      var15 -= (float)var20.getX();
      var16 -= (float)var20.getY();
      var1.drawImage(this.image, (int)var15, (int)var16, (ImageObserver)null);
      String var21 = this.getToolTipText();
      String var22 = this.getURL();
      if(var21 != null || var22 != null) {
         this.addEntity(var7, new Float(var15, var16, (float)var17, (float)var18), var6, var21, var22);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYImageAnnotation)) {
         return false;
      } else {
         XYImageAnnotation var2 = (XYImageAnnotation)var1;
         return this.x != var2.x?false:(this.y != var2.y?false:(!ObjectUtilities.equal(this.image, var2.image)?false:this.anchor.equals(var2.anchor)));
      }
   }

   public int hashCode() {
      return this.image.hashCode();
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
   }
}
