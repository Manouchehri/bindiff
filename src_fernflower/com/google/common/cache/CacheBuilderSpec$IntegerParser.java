package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;

abstract class CacheBuilderSpec$IntegerParser implements CacheBuilderSpec$ValueParser {
   protected abstract void parseInteger(CacheBuilderSpec var1, int var2);

   public void parse(CacheBuilderSpec var1, String var2, String var3) {
      Preconditions.checkArgument(var3 != null && !var3.isEmpty(), "value of key %s omitted", new Object[]{var2});

      try {
         this.parseInteger(var1, Integer.parseInt(var3));
      } catch (NumberFormatException var5) {
         throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s value set to %s, must be integer", new Object[]{var2, var3}), var5);
      }
   }
}
