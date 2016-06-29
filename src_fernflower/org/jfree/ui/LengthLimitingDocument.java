package org.jfree.ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class LengthLimitingDocument extends PlainDocument {
   private int maxlen;

   public LengthLimitingDocument() {
      this(-1);
   }

   public LengthLimitingDocument(int var1) {
      this.maxlen = var1;
   }

   public void setMaxLength(int var1) {
      this.maxlen = var1;
   }

   public int getMaxLength() {
      return this.maxlen;
   }

   public void insertString(int var1, String var2, AttributeSet var3) {
      if(var2 != null) {
         if(this.maxlen < 0) {
            super.insertString(var1, var2, var3);
         }

         char[] var4 = var2.toCharArray();
         StringBuffer var5 = new StringBuffer();
         var5.append(var4, 0, Math.min(this.maxlen, var4.length));
         super.insertString(var1, var5.toString(), var3);
      }
   }
}
