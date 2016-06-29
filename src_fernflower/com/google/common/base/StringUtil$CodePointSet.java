package com.google.common.base;

import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CodePointSet$Builder;
import java.util.Set;

class StringUtil$CodePointSet {
   boolean[] fastArray;
   Set elements;

   private StringUtil$CodePointSet(Set var1) {
      this.elements = var1;
      this.fastArray = new boolean[256];

      for(int var2 = 0; var2 < this.fastArray.length; ++var2) {
         this.fastArray[var2] = this.elements.contains(Integer.valueOf(var2));
      }

   }

   boolean contains(int var1) {
      return var1 < this.fastArray.length?this.fastArray[var1]:this.elements.contains(Integer.valueOf(var1));
   }

   StringUtil$CodePointSet or(StringUtil$CodePointSet var1) {
      return (new StringUtil$CodePointSet$Builder()).addSet(this).addSet(var1).create();
   }

   // $FF: synthetic method
   StringUtil$CodePointSet(Set var1, StringUtil$1 var2) {
      this(var1);
   }
}
