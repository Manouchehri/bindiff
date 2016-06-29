package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDecFormatter;
import com.google.security.zynamics.zylib.gui.CDecFormatter$1;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

class CDecFormatter$DecFilter extends DocumentFilter {
   // $FF: synthetic field
   final CDecFormatter this$0;

   private CDecFormatter$DecFilter(CDecFormatter var1) {
      this.this$0 = var1;
   }

   public void insertString(FilterBypass var1, int var2, String var3, AttributeSet var4) {
      if(CDecFormatter.access$100(this.this$0, var3, 0)) {
         super.insertString(var1, var2, var3, var4);
      }

   }

   public void replace(FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) {
      if(CDecFormatter.access$100(this.this$0, var4, var3)) {
         super.replace(var1, var2, var3, var4, var5);
      }

   }

   // $FF: synthetic method
   CDecFormatter$DecFilter(CDecFormatter var1, CDecFormatter$1 var2) {
      this(var1);
   }
}
