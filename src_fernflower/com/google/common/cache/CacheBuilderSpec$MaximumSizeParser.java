package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$LongParser;

class CacheBuilderSpec$MaximumSizeParser extends CacheBuilderSpec$LongParser {
   protected void parseLong(CacheBuilderSpec var1, long var2) {
      Preconditions.checkArgument(var1.maximumSize == null, "maximum size was already set to ", new Object[]{var1.maximumSize});
      Preconditions.checkArgument(var1.maximumWeight == null, "maximum weight was already set to ", new Object[]{var1.maximumWeight});
      var1.maximumSize = Long.valueOf(var2);
   }
}
