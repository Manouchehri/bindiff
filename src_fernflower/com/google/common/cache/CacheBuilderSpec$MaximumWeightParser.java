package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$LongParser;

class CacheBuilderSpec$MaximumWeightParser extends CacheBuilderSpec$LongParser {
   protected void parseLong(CacheBuilderSpec var1, long var2) {
      Preconditions.checkArgument(var1.maximumWeight == null, "maximum weight was already set to ", new Object[]{var1.maximumWeight});
      Preconditions.checkArgument(var1.maximumSize == null, "maximum size was already set to ", new Object[]{var1.maximumSize});
      var1.maximumWeight = Long.valueOf(var2);
   }
}
