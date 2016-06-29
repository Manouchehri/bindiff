package org.jfree.chart.entity;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.URLTagFragmentGenerator;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class ChartEntity implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -4445994133561919083L;
   private transient Shape area;
   private String toolTipText;
   private String urlText;

   public ChartEntity(Shape var1) {
      this(var1, (String)null);
   }

   public ChartEntity(Shape var1, String var2) {
      this(var1, var2, (String)null);
   }

   public ChartEntity(Shape var1, String var2, String var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'area\' argument.");
      } else {
         this.area = var1;
         this.toolTipText = var2;
         this.urlText = var3;
      }
   }

   public Shape getArea() {
      return this.area;
   }

   public void setArea(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'area\' argument.");
      } else {
         this.area = var1;
      }
   }

   public String getToolTipText() {
      return this.toolTipText;
   }

   public void setToolTipText(String var1) {
      this.toolTipText = var1;
   }

   public String getURLText() {
      return this.urlText;
   }

   public void setURLText(String var1) {
      this.urlText = var1;
   }

   public String getShapeType() {
      return this.area instanceof Rectangle2D?"rect":"poly";
   }

   public String getShapeCoords() {
      return this.area instanceof Rectangle2D?this.getRectCoords((Rectangle2D)this.area):this.getPolyCoords(this.area);
   }

   private String getRectCoords(Rectangle2D var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'rectangle\' argument.");
      } else {
         int var2 = (int)var1.getX();
         int var3 = (int)var1.getY();
         int var4 = var2 + (int)var1.getWidth();
         int var5 = var3 + (int)var1.getHeight();
         if(var4 == var2) {
            ++var4;
         }

         if(var5 == var3) {
            ++var5;
         }

         return var2 + "," + var3 + "," + var4 + "," + var5;
      }
   }

   private String getPolyCoords(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         StringBuffer var2 = new StringBuffer();
         boolean var3 = true;
         float[] var4 = new float[6];

         for(PathIterator var5 = var1.getPathIterator((AffineTransform)null, 1.0D); !var5.isDone(); var5.next()) {
            var5.currentSegment(var4);
            if(var3) {
               var3 = false;
               var2.append((int)var4[0]);
               var2.append(",").append((int)var4[1]);
            } else {
               var2.append(",");
               var2.append((int)var4[0]);
               var2.append(",");
               var2.append((int)var4[1]);
            }
         }

         return var2.toString();
      }
   }

   public String getImageMapAreaTag(ToolTipTagFragmentGenerator var1, URLTagFragmentGenerator var2) {
      StringBuffer var3 = new StringBuffer();
      boolean var4 = this.urlText == null?false:!this.urlText.equals("");
      boolean var5 = this.toolTipText == null?false:!this.toolTipText.equals("");
      if(var4 || var5) {
         var3.append("<area shape=\"" + this.getShapeType() + "\"" + " coords=\"" + this.getShapeCoords() + "\"");
         if(var5) {
            var3.append(var1.generateToolTipFragment(this.toolTipText));
         }

         if(var4) {
            var3.append(var2.generateURLFragment(this.urlText));
         }

         if(!var5) {
            var3.append(" alt=\"\"");
         }

         var3.append("/>");
      }

      return var3.toString();
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer("ChartEntity: ");
      var1.append("tooltip = ");
      var1.append(this.toolTipText);
      return var1.toString();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof ChartEntity) {
         ChartEntity var2 = (ChartEntity)var1;
         return !this.area.equals(var2.area)?false:(!ObjectUtilities.equal(this.toolTipText, var2.toolTipText)?false:ObjectUtilities.equal(this.urlText, var2.urlText));
      } else {
         return false;
      }
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.area, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.area = SerialUtilities.readShape(var1);
   }
}
