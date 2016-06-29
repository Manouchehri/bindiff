package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableMultiset$1;
import com.google.common.collect.ImmutableMultiset$EntrySetSerializedForm;
import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.Multiset$Entry;

final class ImmutableMultiset$EntrySet extends ImmutableSet$Indexed {
   private static final long serialVersionUID = 0L;
   // $FF: synthetic field
   final ImmutableMultiset this$0;

   private ImmutableMultiset$EntrySet(ImmutableMultiset var1) {
      this.this$0 = var1;
   }

   boolean isPartialView() {
      return this.this$0.isPartialView();
   }

   Multiset$Entry get(int var1) {
      return this.this$0.getEntry(var1);
   }

   public int size() {
      return this.this$0.elementSet().size();
   }

   public boolean contains(Object var1) {
      if(var1 instanceof Multiset$Entry) {
         Multiset$Entry var2 = (Multiset$Entry)var1;
         if(var2.getCount() <= 0) {
            return false;
         } else {
            int var3 = this.this$0.count(var2.getElement());
            return var3 == var2.getCount();
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.this$0.hashCode();
   }

   Object writeReplace() {
      return new ImmutableMultiset$EntrySetSerializedForm(this.this$0);
   }

   // $FF: synthetic method
   ImmutableMultiset$EntrySet(ImmutableMultiset var1, ImmutableMultiset$1 var2) {
      this(var1);
   }
}
