package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$IntegerParser;

class CacheBuilderSpec$ConcurrencyLevelParser extends CacheBuilderSpec$IntegerParser {
   protected void parseInteger(CacheBuilderSpec var1, int var2) {
      Preconditions.checkArgument(var1.concurrencyLevel == null, "concurrency level was already set to ", new Object[]{var1.concurrencyLevel});
      var1.concurrencyLevel = Integer.valueOf(var2);
   }
}
