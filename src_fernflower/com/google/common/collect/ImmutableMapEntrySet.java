package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet$EntrySetSerializedForm;
import com.google.common.collect.ImmutableSet;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
abstract class ImmutableMapEntrySet extends ImmutableSet {
   abstract ImmutableMap map();

   public int size() {
      return this.map().size();
   }

   public boolean contains(@Nullable Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = this.map().get(var2.getKey());
         return var3 != null && var3.equals(var2.getValue());
      }
   }

   boolean isPartialView() {
      return this.map().isPartialView();
   }

   @GwtIncompatible("not used in GWT")
   boolean isHashCodeFast() {
      return this.map().isHashCodeFast();
   }

   public int hashCode() {
      return this.map().hashCode();
   }

   @GwtIncompatible("serialization")
   Object writeReplace() {
      return new ImmutableMapEntrySet$EntrySetSerializedForm(this.map());
   }
}
