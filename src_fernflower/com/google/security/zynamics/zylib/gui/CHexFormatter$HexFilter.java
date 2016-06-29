package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CHexFormatter;
import com.google.security.zynamics.zylib.gui.CHexFormatter$1;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

class CHexFormatter$HexFilter extends DocumentFilter {
   // $FF: synthetic field
   final CHexFormatter this$0;

   private CHexFormatter$HexFilter(CHexFormatter var1) {
      this.this$0 = var1;
   }

   public void insertString(FilterBypass var1, int var2, String var3, AttributeSet var4) {
      if(CHexFormatter.access$100(this.this$0, var3, 0)) {
         super.insertString(var1, var2, var3, var4);
      }

   }

   public void replace(FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) {
      if(CHexFormatter.access$100(this.this$0, var4, var3)) {
         super.replace(var1, var2, var3, var4, var5);
      }

   }

   // $FF: synthetic method
   CHexFormatter$HexFilter(CHexFormatter var1, CHexFormatter$1 var2) {
      this(var1);
   }
}
