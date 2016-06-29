package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.AbstractListMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public final class ArrayListMultimap extends AbstractListMultimap {
   private static final int DEFAULT_VALUES_PER_KEY = 3;
   @VisibleForTesting
   transient int expectedValuesPerKey;
   @GwtIncompatible("Not needed in emulated source.")
   private static final long serialVersionUID = 0L;

   public static ArrayListMultimap create() {
      return new ArrayListMultimap();
   }

   public static ArrayListMultimap create(int var0, int var1) {
      return new ArrayListMultimap(var0, var1);
   }

   public static ArrayListMultimap create(Multimap var0) {
      return new ArrayListMultimap(var0);
   }

   private ArrayListMultimap() {
      super(new HashMap());
      this.expectedValuesPerKey = 3;
   }

   private ArrayListMultimap(int var1, int var2) {
      super(Maps.newHashMapWithExpectedSize(var1));
      CollectPreconditions.checkNonnegative(var2, "expectedValuesPerKey");
      this.expectedValuesPerKey = var2;
   }

   private ArrayListMultimap(Multimap var1) {
      this(var1.keySet().size(), var1 instanceof ArrayListMultimap?((ArrayListMultimap)var1).expectedValuesPerKey:3);
      this.putAll(var1);
   }

   List createCollection() {
      return new ArrayList(this.expectedValuesPerKey);
   }

   public void trimToSize() {
      Iterator var1 = this.backingMap().values().iterator();

      while(var1.hasNext()) {
         Collection var2 = (Collection)var1.next();
         ArrayList var3 = (ArrayList)var2;
         var3.trimToSize();
      }

   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      Serialization.writeMultimap(this, var1);
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.expectedValuesPerKey = 3;
      int var2 = Serialization.readCount(var1);
      HashMap var3 = Maps.newHashMap();
      this.setMap(var3);
      Serialization.populateMultimap(this, var1, var2);
   }
}
