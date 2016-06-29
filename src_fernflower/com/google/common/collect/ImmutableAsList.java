package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableAsList$SerializedForm;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

@GwtCompatible(
   serializable = true,
   emulated = true
)
abstract class ImmutableAsList extends ImmutableList {
   abstract ImmutableCollection delegateCollection();

   public boolean contains(Object var1) {
      return this.delegateCollection().contains(var1);
   }

   public int size() {
      return this.delegateCollection().size();
   }

   public boolean isEmpty() {
      return this.delegateCollection().isEmpty();
   }

   boolean isPartialView() {
      return this.delegateCollection().isPartialView();
   }

   @GwtIncompatible("serialization")
   private void readObject(ObjectInputStream var1) {
      throw new InvalidObjectException("Use SerializedForm");
   }

   @GwtIncompatible("serialization")
   Object writeReplace() {
      return new ImmutableAsList$SerializedForm(this.delegateCollection());
   }
}
