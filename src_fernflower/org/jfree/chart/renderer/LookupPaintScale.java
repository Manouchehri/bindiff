package org.jfree.chart.renderer;

import java.awt.Color;
import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.renderer.LookupPaintScale$PaintItem;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class LookupPaintScale implements Serializable, PaintScale, PublicCloneable {
   private double lowerBound;
   private double upperBound;
   private transient Paint defaultPaint;
   private List lookupTable;

   public LookupPaintScale() {
      this(0.0D, 1.0D, Color.lightGray);
   }

   public LookupPaintScale(double var1, double var3, Paint var5) {
      if(var1 >= var3) {
         throw new IllegalArgumentException("Requires lowerBound < upperBound.");
      } else if(var5 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.lowerBound = var1;
         this.upperBound = var3;
         this.defaultPaint = var5;
         this.lookupTable = new ArrayList();
      }
   }

   public Paint getDefaultPaint() {
      return this.defaultPaint;
   }

   public double getLowerBound() {
      return this.lowerBound;
   }

   public double getUpperBound() {
      return this.upperBound;
   }

   public void add(Number var1, Paint var2) {
      LookupPaintScale$PaintItem var3 = new LookupPaintScale$PaintItem(this, var1, var2);
      int var4 = Collections.binarySearch(this.lookupTable, var3);
      if(var4 >= 0) {
         this.lookupTable.set(var4, var3);
      } else {
         this.lookupTable.add(-(var4 + 1), var3);
      }

   }

   public Paint getPaint(double var1) {
      if(var1 < this.lowerBound) {
         return this.defaultPaint;
      } else if(var1 > this.upperBound) {
         return this.defaultPaint;
      } else {
         Paint var3 = this.defaultPaint;
         int var4 = this.lookupTable.size();
         boolean var5 = false;

         while(var4 > 0 && !var5) {
            --var4;
            LookupPaintScale$PaintItem var6 = (LookupPaintScale$PaintItem)this.lookupTable.get(var4);
            if(var1 >= var6.value.doubleValue()) {
               var3 = var6.paint;
               var5 = true;
            }
         }

         return var3;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LookupPaintScale)) {
         return false;
      } else {
         LookupPaintScale var2 = (LookupPaintScale)var1;
         return this.lowerBound != var2.lowerBound?false:(this.upperBound != var2.upperBound?false:(!PaintUtilities.equal(this.defaultPaint, var2.defaultPaint)?false:this.lookupTable.equals(var2.lookupTable)));
      }
   }

   public Object clone() {
      LookupPaintScale var1 = (LookupPaintScale)super.clone();
      var1.lookupTable = new ArrayList(this.lookupTable);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.defaultPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.defaultPaint = SerialUtilities.readPaint(var1);
   }
}
