package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public final class HashMultiset extends AbstractMapBasedMultiset {
   @GwtIncompatible("Not needed in emulated source.")
   private static final long serialVersionUID = 0L;

   public static HashMultiset create() {
      return new HashMultiset();
   }

   public static HashMultiset create(int var0) {
      return new HashMultiset(var0);
   }

   public static HashMultiset create(Iterable var0) {
      HashMultiset var1 = create(Multisets.inferDistinctElements(var0));
      Iterables.addAll(var1, var0);
      return var1;
   }

   private HashMultiset() {
      super(new HashMap());
   }

   private HashMultiset(int var1) {
      super(Maps.newHashMapWithExpectedSize(var1));
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      Serialization.writeMultiset(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = Serialization.readCount(var1);
      this.setBackingMap(Maps.newHashMap());
      Serialization.populateMultiset(this, var1, var2);
   }
}
