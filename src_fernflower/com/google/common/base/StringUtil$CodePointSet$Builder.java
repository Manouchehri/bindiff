package com.google.common.base;

import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CodePointSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class StringUtil$CodePointSet$Builder {
   Set codePoints = new HashSet();

   StringUtil$CodePointSet$Builder addCodePoint(int var1) {
      this.codePoints.add(Integer.valueOf(var1));
      return this;
   }

   StringUtil$CodePointSet$Builder addRange(int var1, int var2) {
      for(int var3 = var1; var3 <= var2; ++var3) {
         this.codePoints.add(Integer.valueOf(var3));
      }

      return this;
   }

   StringUtil$CodePointSet$Builder addSet(StringUtil$CodePointSet var1) {
      Iterator var2 = var1.elements.iterator();

      while(var2.hasNext()) {
         int var3 = ((Integer)var2.next()).intValue();
         this.codePoints.add(Integer.valueOf(var3));
      }

      return this;
   }

   StringUtil$CodePointSet create() {
      return new StringUtil$CodePointSet(this.codePoints, (StringUtil$1)null);
   }
}
