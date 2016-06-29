package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.BinaryPredicates;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

final class BinaryPredicates$Or implements BinaryPredicate, Serializable {
   final Iterable predicates;
   private static final long serialVersionUID = -1352468805830701672L;

   BinaryPredicates$Or(Iterable var1) {
      this.predicates = Preconditions.checkContentsNotNull(var1);
   }

   public boolean apply(@Nullable Object var1, @Nullable Object var2) {
      Iterator var3 = this.predicates.iterator();

      BinaryPredicate var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (BinaryPredicate)var3.next();
      } while(!var4.apply(var1, var2));

      return true;
   }

   public boolean equals(@Nullable Object var1) {
      return var1 instanceof BinaryPredicates$Or?BinaryPredicates.access$000(this.predicates, ((BinaryPredicates$Or)var1).predicates):false;
   }

   public int hashCode() {
      return BinaryPredicates.access$100(this.predicates);
   }
}
