package com.google.common.collect;

import com.google.common.collect.CartesianList;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$CartesianSet$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$CartesianSet extends ForwardingCollection implements Set {
   private final transient ImmutableList axes;
   private final transient CartesianList delegate;

   static Set create(List var0) {
      ImmutableList$Builder var1 = new ImmutableList$Builder(var0.size());
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Set var3 = (Set)var2.next();
         ImmutableSet var4 = ImmutableSet.copyOf((Collection)var3);
         if(var4.isEmpty()) {
            return ImmutableSet.of();
         }

         var1.add((Object)var4);
      }

      ImmutableList var5 = var1.build();
      Sets$CartesianSet$1 var6 = new Sets$CartesianSet$1(var5);
      return new Sets$CartesianSet(var5, new CartesianList(var6));
   }

   private Sets$CartesianSet(ImmutableList var1, CartesianList var2) {
      this.axes = var1;
      this.delegate = var2;
   }

   protected Collection delegate() {
      return this.delegate;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Sets$CartesianSet) {
         Sets$CartesianSet var2 = (Sets$CartesianSet)var1;
         return this.axes.equals(var2.axes);
      } else {
         return super.equals(var1);
      }
   }

   public int hashCode() {
      int var1 = this.size() - 1;

      int var2;
      for(var2 = 0; var2 < this.axes.size(); ++var2) {
         var1 *= 31;
         var1 = ~(~var1);
      }

      var2 = 1;

      for(UnmodifiableIterator var3 = this.axes.iterator(); var3.hasNext(); var2 = ~(~var2)) {
         Set var4 = (Set)var3.next();
         var2 = 31 * var2 + this.size() / var4.size() * var4.hashCode();
      }

      var2 += var1;
      return ~(~var2);
   }
}
