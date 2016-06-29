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
import java.util.LinkedHashMap;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public final class LinkedHashMultiset extends AbstractMapBasedMultiset {
   @GwtIncompatible("not needed in emulated source")
   private static final long serialVersionUID = 0L;

   public static LinkedHashMultiset create() {
      return new LinkedHashMultiset();
   }

   public static LinkedHashMultiset create(int var0) {
      return new LinkedHashMultiset(var0);
   }

   public static LinkedHashMultiset create(Iterable var0) {
      LinkedHashMultiset var1 = create(Multisets.inferDistinctElements(var0));
      Iterables.addAll(var1, var0);
      return var1;
   }

   private LinkedHashMultiset() {
      super(new LinkedHashMap());
   }

   private LinkedHashMultiset(int var1) {
      super(Maps.newLinkedHashMapWithExpectedSize(var1));
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
      this.setBackingMap(new LinkedHashMap());
      Serialization.populateMultiset(this, var1, var2);
   }
}
