package org.jfree.ui;

import java.io.Serializable;

public final class TextAnchor implements Serializable {
   private static final long serialVersionUID = 8219158940496719660L;
   public static final TextAnchor TOP_LEFT = new TextAnchor("TextAnchor.TOP_LEFT");
   public static final TextAnchor TOP_CENTER = new TextAnchor("TextAnchor.TOP_CENTER");
   public static final TextAnchor TOP_RIGHT = new TextAnchor("TextAnchor.TOP_RIGHT");
   public static final TextAnchor HALF_ASCENT_LEFT = new TextAnchor("TextAnchor.HALF_ASCENT_LEFT");
   public static final TextAnchor HALF_ASCENT_CENTER = new TextAnchor("TextAnchor.HALF_ASCENT_CENTER");
   public static final TextAnchor HALF_ASCENT_RIGHT = new TextAnchor("TextAnchor.HALF_ASCENT_RIGHT");
   public static final TextAnchor CENTER_LEFT = new TextAnchor("TextAnchor.CENTER_LEFT");
   public static final TextAnchor CENTER = new TextAnchor("TextAnchor.CENTER");
   public static final TextAnchor CENTER_RIGHT = new TextAnchor("TextAnchor.CENTER_RIGHT");
   public static final TextAnchor BASELINE_LEFT = new TextAnchor("TextAnchor.BASELINE_LEFT");
   public static final TextAnchor BASELINE_CENTER = new TextAnchor("TextAnchor.BASELINE_CENTER");
   public static final TextAnchor BASELINE_RIGHT = new TextAnchor("TextAnchor.BASELINE_RIGHT");
   public static final TextAnchor BOTTOM_LEFT = new TextAnchor("TextAnchor.BOTTOM_LEFT");
   public static final TextAnchor BOTTOM_CENTER = new TextAnchor("TextAnchor.BOTTOM_CENTER");
   public static final TextAnchor BOTTOM_RIGHT = new TextAnchor("TextAnchor.BOTTOM_RIGHT");
   private String name;

   private TextAnchor(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof TextAnchor)) {
         return false;
      } else {
         TextAnchor var2 = (TextAnchor)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      TextAnchor var1 = null;
      if(this.equals(TOP_LEFT)) {
         var1 = TOP_LEFT;
      } else if(this.equals(TOP_CENTER)) {
         var1 = TOP_CENTER;
      } else if(this.equals(TOP_RIGHT)) {
         var1 = TOP_RIGHT;
      } else if(this.equals(BOTTOM_LEFT)) {
         var1 = BOTTOM_LEFT;
      } else if(this.equals(BOTTOM_CENTER)) {
         var1 = BOTTOM_CENTER;
      } else if(this.equals(BOTTOM_RIGHT)) {
         var1 = BOTTOM_RIGHT;
      } else if(this.equals(BASELINE_LEFT)) {
         var1 = BASELINE_LEFT;
      } else if(this.equals(BASELINE_CENTER)) {
         var1 = BASELINE_CENTER;
      } else if(this.equals(BASELINE_RIGHT)) {
         var1 = BASELINE_RIGHT;
      } else if(this.equals(CENTER_LEFT)) {
         var1 = CENTER_LEFT;
      } else if(this.equals(CENTER)) {
         var1 = CENTER;
      } else if(this.equals(CENTER_RIGHT)) {
         var1 = CENTER_RIGHT;
      } else if(this.equals(HALF_ASCENT_LEFT)) {
         var1 = HALF_ASCENT_LEFT;
      } else if(this.equals(HALF_ASCENT_CENTER)) {
         var1 = HALF_ASCENT_CENTER;
      } else if(this.equals(HALF_ASCENT_RIGHT)) {
         var1 = HALF_ASCENT_RIGHT;
      }

      return var1;
   }
}
