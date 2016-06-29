package org.jfree.text;

import java.io.Serializable;

public final class TextBlockAnchor implements Serializable {
   private static final long serialVersionUID = -3045058380983401544L;
   public static final TextBlockAnchor TOP_LEFT = new TextBlockAnchor("TextBlockAnchor.TOP_LEFT");
   public static final TextBlockAnchor TOP_CENTER = new TextBlockAnchor("TextBlockAnchor.TOP_CENTER");
   public static final TextBlockAnchor TOP_RIGHT = new TextBlockAnchor("TextBlockAnchor.TOP_RIGHT");
   public static final TextBlockAnchor CENTER_LEFT = new TextBlockAnchor("TextBlockAnchor.CENTER_LEFT");
   public static final TextBlockAnchor CENTER = new TextBlockAnchor("TextBlockAnchor.CENTER");
   public static final TextBlockAnchor CENTER_RIGHT = new TextBlockAnchor("TextBlockAnchor.CENTER_RIGHT");
   public static final TextBlockAnchor BOTTOM_LEFT = new TextBlockAnchor("TextBlockAnchor.BOTTOM_LEFT");
   public static final TextBlockAnchor BOTTOM_CENTER = new TextBlockAnchor("TextBlockAnchor.BOTTOM_CENTER");
   public static final TextBlockAnchor BOTTOM_RIGHT = new TextBlockAnchor("TextBlockAnchor.BOTTOM_RIGHT");
   private String name;

   private TextBlockAnchor(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof TextBlockAnchor)) {
         return false;
      } else {
         TextBlockAnchor var2 = (TextBlockAnchor)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(TOP_CENTER)?TOP_CENTER:(this.equals(TOP_LEFT)?TOP_LEFT:(this.equals(TOP_RIGHT)?TOP_RIGHT:(this.equals(CENTER)?CENTER:(this.equals(CENTER_LEFT)?CENTER_LEFT:(this.equals(CENTER_RIGHT)?CENTER_RIGHT:(this.equals(BOTTOM_CENTER)?BOTTOM_CENTER:(this.equals(BOTTOM_LEFT)?BOTTOM_LEFT:(this.equals(BOTTOM_RIGHT)?BOTTOM_RIGHT:null))))))));
   }
}
