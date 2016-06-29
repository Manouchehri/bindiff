package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Serialization;
import com.google.common.collect.WellBehavedMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Iterator;

@GwtCompatible(
   emulated = true
)
public final class EnumMultiset extends AbstractMapBasedMultiset {
   private transient Class type;
   @GwtIncompatible("Not needed in emulated source")
   private static final long serialVersionUID = 0L;

   public static EnumMultiset create(Class var0) {
      return new EnumMultiset(var0);
   }

   public static EnumMultiset create(Iterable var0) {
      Iterator var1 = var0.iterator();
      Preconditions.checkArgument(var1.hasNext(), "EnumMultiset constructor passed empty Iterable");
      EnumMultiset var2 = new EnumMultiset(((Enum)var1.next()).getDeclaringClass());
      Iterables.addAll(var2, var0);
      return var2;
   }

   public static EnumMultiset create(Iterable var0, Class var1) {
      EnumMultiset var2 = create(var1);
      Iterables.addAll(var2, var0);
      return var2;
   }

   private EnumMultiset(Class var1) {
      super(WellBehavedMap.wrap(new EnumMap(var1)));
      this.type = var1;
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.type);
      Serialization.writeMultiset(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      Class var2 = (Class)var1.readObject();
      this.type = var2;
      this.setBackingMap(WellBehavedMap.wrap(new EnumMap(this.type)));
      Serialization.populateMultiset(this, var1);
   }
}
