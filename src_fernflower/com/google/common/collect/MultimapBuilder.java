package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$1;
import com.google.common.collect.MultimapBuilder$2;
import com.google.common.collect.MultimapBuilder$3;
import com.google.common.collect.MultimapBuilder$4;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@Beta
@GwtCompatible
public abstract class MultimapBuilder {
   private static final int DEFAULT_EXPECTED_KEYS = 8;

   private MultimapBuilder() {
   }

   public static MultimapBuilder$MultimapBuilderWithKeys hashKeys() {
      return hashKeys(8);
   }

   public static MultimapBuilder$MultimapBuilderWithKeys hashKeys(int var0) {
      CollectPreconditions.checkNonnegative(var0, "expectedKeys");
      return new MultimapBuilder$1(var0);
   }

   public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys() {
      return linkedHashKeys(8);
   }

   public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys(int var0) {
      CollectPreconditions.checkNonnegative(var0, "expectedKeys");
      return new MultimapBuilder$2(var0);
   }

   public static MultimapBuilder$MultimapBuilderWithKeys treeKeys() {
      return treeKeys(Ordering.natural());
   }

   public static MultimapBuilder$MultimapBuilderWithKeys treeKeys(Comparator var0) {
      Preconditions.checkNotNull(var0);
      return new MultimapBuilder$3(var0);
   }

   public static MultimapBuilder$MultimapBuilderWithKeys enumKeys(Class var0) {
      Preconditions.checkNotNull(var0);
      return new MultimapBuilder$4(var0);
   }

   public abstract Multimap build();

   public Multimap build(Multimap var1) {
      Multimap var2 = this.build();
      var2.putAll(var1);
      return var2;
   }

   // $FF: synthetic method
   MultimapBuilder(MultimapBuilder$1 var1) {
      this();
   }
}
