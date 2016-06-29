package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSet$SerializedForm;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.SingletonImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public abstract class ImmutableSet extends ImmutableCollection implements Set {
   static final int MAX_TABLE_SIZE = 1073741824;
   private static final double DESIRED_LOAD_FACTOR = 0.7D;
   private static final int CUTOFF = 751619276;

   public static ImmutableSet of() {
      return RegularImmutableSet.EMPTY;
   }

   public static ImmutableSet of(Object var0) {
      return new SingletonImmutableSet(var0);
   }

   public static ImmutableSet of(Object var0, Object var1) {
      return construct(2, new Object[]{var0, var1});
   }

   public static ImmutableSet of(Object var0, Object var1, Object var2) {
      return construct(3, new Object[]{var0, var1, var2});
   }

   public static ImmutableSet of(Object var0, Object var1, Object var2, Object var3) {
      return construct(4, new Object[]{var0, var1, var2, var3});
   }

   public static ImmutableSet of(Object var0, Object var1, Object var2, Object var3, Object var4) {
      return construct(5, new Object[]{var0, var1, var2, var3, var4});
   }

   public static ImmutableSet of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object... var6) {
      Object[] var8 = new Object[6 + var6.length];
      var8[0] = var0;
      var8[1] = var1;
      var8[2] = var2;
      var8[3] = var3;
      var8[4] = var4;
      var8[5] = var5;
      System.arraycopy(var6, 0, var8, 6, var6.length);
      return construct(var8.length, var8);
   }

   private static ImmutableSet construct(int var0, Object... var1) {
      switch(var0) {
      case 0:
         return of();
      case 1:
         Object var2 = var1[0];
         return of(var2);
      default:
         int var13 = chooseTableSize(var0);
         Object[] var3 = new Object[var13];
         int var4 = var13 - 1;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;

         for(; var7 < var0; ++var7) {
            Object var8 = ObjectArrays.checkElementNotNull(var1[var7], var7);
            int var9 = var8.hashCode();
            int var10 = Hashing.smear(var9);

            while(true) {
               int var11 = var10 & var4;
               Object var12 = var3[var11];
               if(var12 == null) {
                  var1[var6++] = var8;
                  var3[var11] = var8;
                  var5 += var9;
                  break;
               }

               if(var12.equals(var8)) {
                  break;
               }

               ++var10;
            }
         }

         Arrays.fill(var1, var6, var0, (Object)null);
         if(var6 == 1) {
            Object var15 = var1[0];
            return new SingletonImmutableSet(var15, var5);
         } else if(var13 != chooseTableSize(var6)) {
            return construct(var6, var1);
         } else {
            Object[] var14 = var6 < var1.length?ObjectArrays.arraysCopyOf(var1, var6):var1;
            return new RegularImmutableSet(var14, var5, var3, var4);
         }
      }
   }

   @VisibleForTesting
   static int chooseTableSize(int var0) {
      if(var0 >= 751619276) {
         Preconditions.checkArgument(var0 < 1073741824, "collection too large");
         return 1073741824;
      } else {
         int var1;
         for(var1 = Integer.highestOneBit(var0 - 1) << 1; (double)var1 * 0.7D < (double)var0; var1 <<= 1) {
            ;
         }

         return var1;
      }
   }

   public static ImmutableSet copyOf(Collection var0) {
      if(var0 instanceof ImmutableSet && !(var0 instanceof ImmutableSortedSet)) {
         ImmutableSet var1 = (ImmutableSet)var0;
         if(!var1.isPartialView()) {
            return var1;
         }
      } else if(var0 instanceof EnumSet) {
         return copyOfEnumSet((EnumSet)var0);
      }

      Object[] var2 = var0.toArray();
      return construct(var2.length, var2);
   }

   public static ImmutableSet copyOf(Iterable var0) {
      return var0 instanceof Collection?copyOf((Collection)var0):copyOf(var0.iterator());
   }

   public static ImmutableSet copyOf(Iterator var0) {
      if(!var0.hasNext()) {
         return of();
      } else {
         Object var1 = var0.next();
         return !var0.hasNext()?of(var1):(new ImmutableSet$Builder()).add(var1).addAll(var0).build();
      }
   }

   public static ImmutableSet copyOf(Object[] var0) {
      switch(var0.length) {
      case 0:
         return of();
      case 1:
         return of(var0[0]);
      default:
         return construct(var0.length, (Object[])var0.clone());
      }
   }

   private static ImmutableSet copyOfEnumSet(EnumSet var0) {
      return ImmutableEnumSet.asImmutable(EnumSet.copyOf(var0));
   }

   boolean isHashCodeFast() {
      return false;
   }

   public boolean equals(@Nullable Object var1) {
      return var1 == this?true:(var1 instanceof ImmutableSet && this.isHashCodeFast() && ((ImmutableSet)var1).isHashCodeFast() && this.hashCode() != var1.hashCode()?false:Sets.equalsImpl(this, var1));
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }

   public abstract UnmodifiableIterator iterator();

   Object writeReplace() {
      return new ImmutableSet$SerializedForm(this.toArray());
   }

   public static ImmutableSet$Builder builder() {
      return new ImmutableSet$Builder();
   }

   // $FF: synthetic method
   static ImmutableSet access$000(int var0, Object[] var1) {
      return construct(var0, var1);
   }
}
