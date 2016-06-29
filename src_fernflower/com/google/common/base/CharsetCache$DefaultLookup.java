package com.google.common.base;

import com.google.common.base.CharsetCache$1;
import com.google.common.base.Function;
import java.nio.charset.Charset;

class CharsetCache$DefaultLookup implements Function {
   private CharsetCache$DefaultLookup() {
   }

   public Charset apply(String var1) {
      return Charset.forName(var1);
   }

   // $FF: synthetic method
   CharsetCache$DefaultLookup(CharsetCache$1 var1) {
      this();
   }
}
