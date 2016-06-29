package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Enums$StringConverter;
import com.google.common.base.Optional;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible(
   emulated = true
)
@Beta
public final class Enums {
   @GwtIncompatible("java.lang.ref.WeakReference")
   private static final Map enumConstantCache = new WeakHashMap();

   @GwtIncompatible("reflection")
   public static Field getField(Enum var0) {
      Class var1 = var0.getDeclaringClass();

      try {
         return var1.getDeclaredField(var0.name());
      } catch (NoSuchFieldException var3) {
         throw new AssertionError(var3);
      }
   }

   public static Optional getIfPresent(Class var0, String var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return Platform.getEnumIfPresent(var0, var1);
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   private static Map populateCache(Class var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = EnumSet.allOf(var0).iterator();

      while(var2.hasNext()) {
         Enum var3 = (Enum)var2.next();
         var1.put(var3.name(), new WeakReference(var3));
      }

      enumConstantCache.put(var0, var1);
      return var1;
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   static Map getEnumConstants(Class var0) {
      Map var1 = enumConstantCache;
      synchronized(enumConstantCache) {
         Map var2 = (Map)enumConstantCache.get(var0);
         if(var2 == null) {
            var2 = populateCache(var0);
         }

         return var2;
      }
   }

   public static Converter stringConverter(Class var0) {
      return new Enums$StringConverter(var0);
   }
}
