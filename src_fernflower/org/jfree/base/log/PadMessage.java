package org.jfree.base.log;

import java.util.Arrays;

public class PadMessage {
   private final Object text;
   private final int length;

   public PadMessage(Object var1, int var2) {
      this.text = var1;
      this.length = var2;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append(this.text);
      if(var1.length() < this.length) {
         char[] var2 = new char[this.length - var1.length()];
         Arrays.fill(var2, ' ');
         var1.append(var2);
      }

      return var1.toString();
   }
}
