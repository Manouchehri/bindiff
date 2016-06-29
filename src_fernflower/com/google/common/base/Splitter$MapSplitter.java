package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.CheckReturnValue;

@Beta
public final class Splitter$MapSplitter {
   private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
   private final Splitter outerSplitter;
   private final Splitter entrySplitter;

   private Splitter$MapSplitter(Splitter var1, Splitter var2) {
      this.outerSplitter = var1;
      this.entrySplitter = (Splitter)Preconditions.checkNotNull(var2);
   }

   @CheckReturnValue
   public Map split(CharSequence var1) {
      LinkedHashMap var2 = new LinkedHashMap();
      Iterator var3 = this.outerSplitter.split(var1).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         Iterator var5 = Splitter.access$000(this.entrySplitter, var4);
         Preconditions.checkArgument(var5.hasNext(), "Chunk [%s] is not a valid entry", new Object[]{var4});
         String var6 = (String)var5.next();
         Preconditions.checkArgument(!var2.containsKey(var6), "Duplicate key [%s] found.", new Object[]{var6});
         Preconditions.checkArgument(var5.hasNext(), "Chunk [%s] is not a valid entry", new Object[]{var4});
         String var7 = (String)var5.next();
         var2.put(var6, var7);
         Preconditions.checkArgument(!var5.hasNext(), "Chunk [%s] is not a valid entry", new Object[]{var4});
      }

      return Collections.unmodifiableMap(var2);
   }

   // $FF: synthetic method
   Splitter$MapSplitter(Splitter var1, Splitter var2, Splitter$1 var3) {
      this(var1, var2);
   }
}
