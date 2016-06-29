package org.jfree.util;

import java.util.Iterator;

public class LineBreakIterator implements Iterator {
   public static final int DONE = -1;
   private char[] text;
   private int position;

   public LineBreakIterator() {
      this.setText("");
   }

   public LineBreakIterator(String var1) {
      this.setText(var1);
   }

   public synchronized int nextPosition() {
      if(this.text == null) {
         return -1;
      } else if(this.position == -1) {
         return -1;
      } else {
         int var1 = this.text.length;
         int var2 = this.position;

         boolean var3;
         char var4;
         int var5;
         do {
            if(var2 >= var1) {
               this.position = -1;
               return -1;
            }

            var3 = false;
            var4 = 0;

            for(var5 = var2; var5 < var1; ++var5) {
               var4 = this.text[var5];
               if(var4 == 10 || var4 == 13) {
                  var3 = true;
                  break;
               }
            }

            var2 = var5;
         } while(!var3);

         var2 = var5 + 1;
         if(var4 == 13 && var2 < var1 && this.text[var2] == 10) {
            ++var2;
         }

         this.position = var2;
         return this.position;
      }
   }

   public int nextWithEnd() {
      int var1 = this.position;
      if(var1 == -1) {
         return -1;
      } else if(var1 == this.text.length) {
         this.position = -1;
         return -1;
      } else {
         int var2 = this.nextPosition();
         return var2 == -1?this.text.length:var2;
      }
   }

   public String getText() {
      return new String(this.text);
   }

   public void setText(String var1) {
      this.position = 0;
      this.text = var1.toCharArray();
   }

   public boolean hasNext() {
      return this.position != -1;
   }

   public Object next() {
      if(this.position == -1) {
         return null;
      } else {
         int var1 = this.position;
         int var2 = this.nextWithEnd();
         if(var2 == -1) {
            return new String(this.text, var1, this.text.length - var1);
         } else {
            if(var2 > 0) {
               for(int var3 = var1; var2 > var3 && (this.text[var2 - 1] == 10 || this.text[var2 - 1] == 13); --var2) {
                  ;
               }
            }

            return new String(this.text, var1, var2 - var1);
         }
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("This iterator is read-only.");
   }
}
