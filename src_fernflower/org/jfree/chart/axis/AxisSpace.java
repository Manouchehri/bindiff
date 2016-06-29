package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class AxisSpace implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -2490732595134766305L;
   private double top = 0.0D;
   private double bottom = 0.0D;
   private double left = 0.0D;
   private double right = 0.0D;

   public double getTop() {
      return this.top;
   }

   public void setTop(double var1) {
      this.top = var1;
   }

   public double getBottom() {
      return this.bottom;
   }

   public void setBottom(double var1) {
      this.bottom = var1;
   }

   public double getLeft() {
      return this.left;
   }

   public void setLeft(double var1) {
      this.left = var1;
   }

   public double getRight() {
      return this.right;
   }

   public void setRight(double var1) {
      this.right = var1;
   }

   public void add(double var1, RectangleEdge var3) {
      if(var3 == null) {
         throw new IllegalArgumentException("Null \'edge\' argument.");
      } else {
         if(var3 == RectangleEdge.TOP) {
            this.top += var1;
         } else if(var3 == RectangleEdge.BOTTOM) {
            this.bottom += var1;
         } else if(var3 == RectangleEdge.LEFT) {
            this.left += var1;
         } else {
            if(var3 != RectangleEdge.RIGHT) {
               throw new IllegalStateException("Unrecognised \'edge\' argument.");
            }

            this.right += var1;
         }

      }
   }

   public void ensureAtLeast(AxisSpace var1) {
      this.top = Math.max(this.top, var1.top);
      this.bottom = Math.max(this.bottom, var1.bottom);
      this.left = Math.max(this.left, var1.left);
      this.right = Math.max(this.right, var1.right);
   }

   public void ensureAtLeast(double var1, RectangleEdge var3) {
      if(var3 == RectangleEdge.TOP) {
         if(this.top < var1) {
            this.top = var1;
         }
      } else if(var3 == RectangleEdge.BOTTOM) {
         if(this.bottom < var1) {
            this.bottom = var1;
         }
      } else if(var3 == RectangleEdge.LEFT) {
         if(this.left < var1) {
            this.left = var1;
         }
      } else {
         if(var3 != RectangleEdge.RIGHT) {
            throw new IllegalStateException("AxisSpace.ensureAtLeast(): unrecognised AxisLocation.");
         }

         if(this.right < var1) {
            this.right = var1;
         }
      }

   }

   public Rectangle2D shrink(Rectangle2D var1, Rectangle2D var2) {
      if(var2 == null) {
         var2 = new Double();
      }

      ((Rectangle2D)var2).setRect(var1.getX() + this.left, var1.getY() + this.top, var1.getWidth() - this.left - this.right, var1.getHeight() - this.top - this.bottom);
      return (Rectangle2D)var2;
   }

   public Rectangle2D expand(Rectangle2D var1, Rectangle2D var2) {
      if(var2 == null) {
         var2 = new Double();
      }

      ((Rectangle2D)var2).setRect(var1.getX() - this.left, var1.getY() - this.top, var1.getWidth() + this.left + this.right, var1.getHeight() + this.top + this.bottom);
      return (Rectangle2D)var2;
   }

   public Rectangle2D reserved(Rectangle2D var1, RectangleEdge var2) {
      Double var3 = null;
      if(var2 == RectangleEdge.TOP) {
         var3 = new Double(var1.getX(), var1.getY(), var1.getWidth(), this.top);
      } else if(var2 == RectangleEdge.BOTTOM) {
         var3 = new Double(var1.getX(), var1.getMaxY() - this.top, var1.getWidth(), this.bottom);
      } else if(var2 == RectangleEdge.LEFT) {
         var3 = new Double(var1.getX(), var1.getY(), this.left, var1.getHeight());
      } else if(var2 == RectangleEdge.RIGHT) {
         var3 = new Double(var1.getMaxX() - this.right, var1.getY(), this.right, var1.getHeight());
      }

      return var3;
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AxisSpace)) {
         return false;
      } else {
         AxisSpace var2 = (AxisSpace)var1;
         return this.top != var2.top?false:(this.bottom != var2.bottom?false:(this.left != var2.left?false:this.right == var2.right));
      }
   }

   public int hashCode() {
      byte var1 = 23;
      long var2 = java.lang.Double.doubleToLongBits(this.top);
      int var4 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.bottom);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.left);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.right);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      return var4;
   }

   public String toString() {
      return super.toString() + "[left=" + this.left + ",right=" + this.right + ",top=" + this.top + ",bottom=" + this.bottom + "]";
   }
}
