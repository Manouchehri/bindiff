package org.jfree.chart.labels;

import java.io.Serializable;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.ui.TextAnchor;

public class ItemLabelPosition implements Serializable {
   private static final long serialVersionUID = 5845390630157034499L;
   private ItemLabelAnchor itemLabelAnchor;
   private TextAnchor textAnchor;
   private TextAnchor rotationAnchor;
   private double angle;

   public ItemLabelPosition() {
      this(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0D);
   }

   public ItemLabelPosition(ItemLabelAnchor var1, TextAnchor var2) {
      this(var1, var2, TextAnchor.CENTER, 0.0D);
   }

   public ItemLabelPosition(ItemLabelAnchor var1, TextAnchor var2, TextAnchor var3, double var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'itemLabelAnchor\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'textAnchor\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'rotationAnchor\' argument.");
      } else {
         this.itemLabelAnchor = var1;
         this.textAnchor = var2;
         this.rotationAnchor = var3;
         this.angle = var4;
      }
   }

   public ItemLabelAnchor getItemLabelAnchor() {
      return this.itemLabelAnchor;
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
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ItemLabelPosition)) {
         return false;
      } else {
         ItemLabelPosition var2 = (ItemLabelPosition)var1;
         return !this.itemLabelAnchor.equals(var2.itemLabelAnchor)?false:(!this.textAnchor.equals(var2.textAnchor)?false:(!this.rotationAnchor.equals(var2.rotationAnchor)?false:this.angle == var2.angle));
      }
   }
}
