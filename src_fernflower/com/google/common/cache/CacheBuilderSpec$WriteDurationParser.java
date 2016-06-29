package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$DurationParser;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$WriteDurationParser extends CacheBuilderSpec$DurationParser {
   protected void parseDuration(CacheBuilderSpec var1, long var2, TimeUnit var4) {
      Preconditions.checkArgument(var1.writeExpirationTimeUnit == null, "expireAfterWrite already set");
      var1.writeExpirationDuration = var2;
      var1.writeExpirationTimeUnit = var4;
   }
}
