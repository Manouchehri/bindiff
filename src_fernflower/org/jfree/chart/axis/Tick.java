package org.jfree.chart.axis;

import java.io.Serializable;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public abstract class Tick implements Serializable, Cloneable {
   private static final long serialVersionUID = 6668230383875149773L;
   private String text;
   private TextAnchor textAnchor;
   private TextAnchor rotationAnchor;
   private double angle;

   public Tick(String var1, TextAnchor var2, TextAnchor var3, double var4) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'textAnchor\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'rotationAnchor\' argument.");
      } else {
         this.text = var1;
         this.textAnchor = var2;
         this.rotationAnchor = var3;
         this.angle = var4;
      }
   }

   public String getText() {
      return this.text;
   }

   public TextAnchor getTextAnchor() {
      return this.textAnchor;
   }

   public TextAnchor getRotationAnchor() {
      return this.rotationAnchor;
   }

   public double getAngle() {
      return this.angle;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 instanceof Tick) {
         Tick var2 = (Tick)var1;
         return !ObjectUtilities.equal(this.text, var2.text)?false:(!ObjectUtilities.equal(this.textAnchor, var2.textAnchor)?false:(!ObjectUtilities.equal(this.rotationAnchor, var2.rotationAnchor)?false:this.angle == var2.angle));
      } else {
         return false;
      }
   }

   public Object clone() {
      Tick var1 = (Tick)super.clone();
      return var1;
   }

   public String toString() {
      return this.text;
   }
}
