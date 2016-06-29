package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$DurationParser;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$RefreshDurationParser extends CacheBuilderSpec$DurationParser {
   protected void parseDuration(CacheBuilderSpec var1, long var2, TimeUnit var4) {
      Preconditions.checkArgument(var1.refreshTimeUnit == null, "refreshAfterWrite already set");
      var1.refreshDuration = var2;
      var1.refreshTimeUnit = var4;
   }
}
