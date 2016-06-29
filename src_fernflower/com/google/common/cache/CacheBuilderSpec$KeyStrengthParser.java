package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import com.google.common.cache.LocalCache$Strength;
import javax.annotation.Nullable;

class CacheBuilderSpec$KeyStrengthParser implements CacheBuilderSpec$ValueParser {
   private final LocalCache$Strength strength;

   public CacheBuilderSpec$KeyStrengthParser(LocalCache$Strength var1) {
      this.strength = var1;
   }

   public void parse(CacheBuilderSpec var1, String var2, @Nullable String var3) {
      Preconditions.checkArgument(var3 == null, "key %s does not take values", new Object[]{var2});
      Preconditions.checkArgument(var1.keyStrength == null, "%s was already set to %s", new Object[]{var2, var1.keyStrength});
      var1.keyStrength = this.strength;
   }
}
