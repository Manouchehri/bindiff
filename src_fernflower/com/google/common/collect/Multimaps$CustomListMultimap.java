package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractListMultimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

class Multimaps$CustomListMultimap extends AbstractListMultimap {
   transient Supplier factory;
   @GwtIncompatible("java serialization not supported")
   private static final long serialVersionUID = 0L;

   Multimaps$CustomListMultimap(Map var1, Supplier var2) {
      super(var1);
      this.factory = (Supplier)Preconditions.checkNotNull(var2);
   }

   protected List createCollection() {
      return (List)this.factory.get();
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
      Map var2 = (Map)var1.readObject();
      this.setMap(var2);
   }
}
