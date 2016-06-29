package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.CharsetCache$1;
import com.google.common.base.CharsetCache$DefaultLookup;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GoogleInternal
public final class CharsetCache {
   private static final CharsetCache INSTANCE = new CharsetCache(new CharsetCache$DefaultLookup((CharsetCache$1)null), 100);
   private final ConcurrentMap hitCache;
   private final Map missCache;
   private final Function lookupFunction;

   public static Charset forName(@Nullable String var0) {
      return INSTANCE.lookup(var0);
   }

   CharsetCache(Function var1, int var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 > 1);
      this.lookupFunction = var1;
      this.hitCache = new ConcurrentHashMap();
      CharsetCache$1 var3 = new CharsetCache$1(this, var2, 0.75F, true, var2);
      this.missCache = Collections.synchronizedMap(var3);
   }

   Charset lookup(String var1) {
      Preconditions.checkArgument(var1 != null, "Charset name may not be null");
      var1 = var1.toLowerCase();
      SoftReference var2 = (SoftReference)this.hitCache.get(var1);
      if(var2 != null) {
         Charset var3 = (Charset)var2.get();
         if(var3 != null) {
            return var3;
         }
      } else if(this.missCache.get(var1) != null) {
         throw new UnsupportedCharsetException(var1);
      }

      return this.lookupAndCache(var1);
   }

   private Charset lookupAndCache(String var1) {
      try {
         Charset var2 = (Charset)this.lookupFunction.apply(var1);
         SoftReference var3 = new SoftReference(var2);
         this.hitCache.put(var1, var3);
         Iterator var4 = var2.aliases().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            this.hitCache.put(var5.toLowerCase(), var3);
         }

         return var2;
      } catch (UnsupportedCharsetException var6) {
         this.missCache.put(var1, Boolean.TRUE);
         throw var6;
      }
   }
}
