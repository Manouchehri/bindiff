package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractSortedSetMultimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

class Multimaps$CustomSortedSetMultimap extends AbstractSortedSetMultimap {
   transient Supplier factory;
   transient Comparator valueComparator;
   @GwtIncompatible("not needed in emulated source")
   private static final long serialVersionUID = 0L;

   Multimaps$CustomSortedSetMultimap(Map var1, Supplier var2) {
      super(var1);
      this.factory = (Supplier)Preconditions.checkNotNull(var2);
      this.valueComparator = ((SortedSet)var2.get()).comparator();
   }

   protected SortedSet createCollection() {
      return (SortedSet)this.factory.get();
   }

   public Comparator valueComparator() {
      return this.valueComparator;
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.factory);
      var1.writeObject(this.backingMap());
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.factory = (Supplier)var1.readObject();
      this.valueComparator = ((SortedSet)this.factory.get()).comparator();
      Map var2 = (Map)var1.readObject();
      this.setMap(var2);
   }
}
