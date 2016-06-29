package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public final class HashMultimap extends AbstractSetMultimap {
   private static final int DEFAULT_VALUES_PER_KEY = 2;
   @VisibleForTesting
   transient int expectedValuesPerKey = 2;
   @GwtIncompatible("Not needed in emulated source")
   private static final long serialVersionUID = 0L;

   public static HashMultimap create() {
      return new HashMultimap();
   }

   public static HashMultimap create(int var0, int var1) {
      return new HashMultimap(var0, var1);
   }

   public static HashMultimap create(Multimap var0) {
      return new HashMultimap(var0);
   }

   private HashMultimap() {
      super(new HashMap());
   }

   private HashMultimap(int var1, int var2) {
      super(Maps.newHashMapWithExpectedSize(var1));
      Preconditions.checkArgument(var2 >= 0);
      this.expectedValuesPerKey = var2;
   }

   private HashMultimap(Multimap var1) {
      super(Maps.newHashMapWithExpectedSize(var1.keySet().size()));
      this.putAll(var1);
   }

   Set createCollection() {
      return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      Serialization.writeMultimap(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.expectedValuesPerKey = 2;
      int var2 = Serialization.readCount(var1);
      HashMap var3 = Maps.newHashMap();
      this.setMap(var3);
      Serialization.populateMultimap(this, var1, var2);
   }
}
