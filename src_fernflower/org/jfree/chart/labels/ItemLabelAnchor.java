package org.jfree.chart.labels;

import java.io.Serializable;

public final class ItemLabelAnchor implements Serializable {
   private static final long serialVersionUID = -1233101616128695658L;
   public static final ItemLabelAnchor CENTER = new ItemLabelAnchor("ItemLabelAnchor.CENTER");
   public static final ItemLabelAnchor INSIDE1 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE1");
   public static final ItemLabelAnchor INSIDE2 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE2");
   public static final ItemLabelAnchor INSIDE3 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE3");
   public static final ItemLabelAnchor INSIDE4 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE4");
   public static final ItemLabelAnchor INSIDE5 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE5");
   public static final ItemLabelAnchor INSIDE6 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE6");
   public static final ItemLabelAnchor INSIDE7 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE7");
   public static final ItemLabelAnchor INSIDE8 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE8");
   public static final ItemLabelAnchor INSIDE9 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE9");
   public static final ItemLabelAnchor INSIDE10 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE10");
   public static final ItemLabelAnchor INSIDE11 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE11");
   public static final ItemLabelAnchor INSIDE12 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE12");
   public static final ItemLabelAnchor OUTSIDE1 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE1");
   public static final ItemLabelAnchor OUTSIDE2 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE2");
   public static final ItemLabelAnchor OUTSIDE3 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE3");
   public static final ItemLabelAnchor OUTSIDE4 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE4");
   public static final ItemLabelAnchor OUTSIDE5 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE5");
   public static final ItemLabelAnchor OUTSIDE6 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE6");
   public static final ItemLabelAnchor OUTSIDE7 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE7");
   public static final ItemLabelAnchor OUTSIDE8 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE8");
   public static final ItemLabelAnchor OUTSIDE9 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE9");
   public static final ItemLabelAnchor OUTSIDE10 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE10");
   public static final ItemLabelAnchor OUTSIDE11 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE11");
   public static final ItemLabelAnchor OUTSIDE12 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE12");
   private String name;

   private ItemLabelAnchor(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ItemLabelAnchor)) {
         return false;
      } else {
         ItemLabelAnchor var2 = (ItemLabelAnchor)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      ItemLabelAnchor var1 = null;
      if(this.equals(CENTER)) {
         var1 = CENTER;
      } else if(this.equals(INSIDE1)) {
         var1 = INSIDE1;
      } else if(this.equals(INSIDE2)) {
         var1 = INSIDE2;
      } else if(this.equals(INSIDE3)) {
         var1 = INSIDE3;
      } else if(this.equals(INSIDE4)) {
         var1 = INSIDE4;
      } else if(this.equals(INSIDE5)) {
         var1 = INSIDE5;
      } else if(this.equals(INSIDE6)) {
         var1 = INSIDE6;
      } else if(this.equals(INSIDE7)) {
         var1 = INSIDE7;
      } else if(this.equals(INSIDE8)) {
         var1 = INSIDE8;
      } else if(this.equals(INSIDE9)) {
         var1 = INSIDE9;
      } else if(this.equals(INSIDE10)) {
         var1 = INSIDE10;
      } else if(this.equals(INSIDE11)) {
         var1 = INSIDE11;
      } else if(this.equals(INSIDE12)) {
         var1 = INSIDE12;
      } else if(this.equals(OUTSIDE1)) {
         var1 = OUTSIDE1;
      } else if(this.equals(OUTSIDE2)) {
         var1 = OUTSIDE2;
      } else if(this.equals(OUTSIDE3)) {
         var1 = OUTSIDE3;
      } else if(this.equals(OUTSIDE4)) {
         var1 = OUTSIDE4;
      } else if(this.equals(OUTSIDE5)) {
         var1 = OUTSIDE5;
      } else if(this.equals(OUTSIDE6)) {
         var1 = OUTSIDE6;
      } else if(this.equals(OUTSIDE7)) {
         var1 = OUTSIDE7;
      } else if(this.equals(OUTSIDE8)) {
         var1 = OUTSIDE8;
      } else if(this.equals(OUTSIDE9)) {
         var1 = OUTSIDE9;
      } else if(this.equals(OUTSIDE10)) {
         var1 = OUTSIDE10;
      } else if(this.equals(OUTSIDE11)) {
         var1 = OUTSIDE11;
      } else if(this.equals(OUTSIDE12)) {
         var1 = OUTSIDE12;
      }

      return var1;
   }
}
