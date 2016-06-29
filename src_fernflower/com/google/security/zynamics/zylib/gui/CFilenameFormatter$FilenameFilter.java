package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter$1;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

class CFilenameFormatter$FilenameFilter extends DocumentFilter {
   // $FF: synthetic field
   final CFilenameFormatter this$0;

   private CFilenameFormatter$FilenameFilter(CFilenameFormatter var1) {
      this.this$0 = var1;
   }

   public void insertString(FilterBypass var1, int var2, String var3, AttributeSet var4) {
      if(CFilenameFormatter.access$100(this.this$0, var3, 0)) {
         super.insertString(var1, var2, var3, var4);
      }

   }

   public void replace(FilterBypass var1, int var2, int var3, String var4, AttributeSet var5) {
      if(CFilenameFormatter.access$100(this.this$0, var4, var3)) {
         super.replace(var1, var2, var3, var4, var5);
      }

   }

   // $FF: synthetic method
   CFilenameFormatter$FilenameFilter(CFilenameFormatter var1, CFilenameFormatter$1 var2) {
      this(var1);
   }
}
