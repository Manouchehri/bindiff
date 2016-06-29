package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import javax.annotation.Nullable;

class CacheBuilderSpec$RecordStatsParser implements CacheBuilderSpec$ValueParser {
   public void parse(CacheBuilderSpec var1, String var2, @Nullable String var3) {
      Preconditions.checkArgument(var3 == null, "recordStats does not take values");
      Preconditions.checkArgument(var1.recordStats == null, "recordStats already set");
      var1.recordStats = Boolean.valueOf(true);
   }
}
