package com.google.common.base;

import com.google.common.base.StringUtil$CharEscaper;
import com.google.common.base.StringUtil$CharEscaperBuilder$CharArrayDecorator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class StringUtil$CharEscaperBuilder {
   private final Map map = new HashMap();
   private int max = -1;

   public StringUtil$CharEscaperBuilder addEscape(char var1, String var2) {
      this.map.put(Character.valueOf(var1), var2);
      if(var1 > this.max) {
         this.max = var1;
      }

      return this;
   }

   public char[][] toArray() {
      char[][] var1 = new char[this.max + 1][];

      Entry var3;
      for(Iterator var2 = this.map.entrySet().iterator(); var2.hasNext(); var1[((Character)var3.getKey()).charValue()] = ((String)var3.getValue()).toCharArray()) {
         var3 = (Entry)var2.next();
      }

      return var1;
   }

   public StringUtil$CharEscaper toEscaper() {
      return new StringUtil$CharEscaperBuilder$CharArrayDecorator(this.toArray());
   }
}
