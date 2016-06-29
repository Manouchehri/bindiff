package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableSetMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$FieldSettersHolder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSetMultimap$Builder;
import com.google.common.collect.ImmutableSetMultimap$EntrySet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public class ImmutableSetMultimap extends ImmutableMultimap implements SetMultimap {
   private final transient ImmutableSet emptySet;
   @LazyInit
   private transient ImmutableSetMultimap inverse;
   private transient ImmutableSet entries;
   @GwtIncompatible("not needed in emulated source.")
   private static final long serialVersionUID = 0L;

   public static ImmutableSetMultimap of() {
      return EmptyImmutableSetMultimap.INSTANCE;
   }

   public static ImmutableSetMultimap of(Object var0, Object var1) {
      ImmutableSetMultimap$Builder var2 = builder();
      var2.put(var0, var1);
      return var2.build();
   }

   public static ImmutableSetMultimap of(Object var0, Object var1, Object var2, Object var3) {
      ImmutableSetMultimap$Builder var4 = builder();
      var4.put(var0, var1);
      var4.put(var2, var3);
      return var4.build();
   }

   public static ImmutableSetMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      ImmutableSetMultimap$Builder var6 = builder();
      var6.put(var0, var1);
      var6.put(var2, var3);
      var6.put(var4, var5);
      return var6.build();
   }

   public static ImmutableSetMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      ImmutableSetMultimap$Builder var8 = builder();
      var8.put(var0, var1);
      var8.put(var2, var3);
      var8.put(var4, var5);
      var8.put(var6, var7);
      return var8.build();
   }

   public static ImmutableSetMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      ImmutableSetMultimap$Builder var10 = builder();
      var10.put(var0, var1);
      var10.put(var2, var3);
      var10.put(var4, var5);
      var10.put(var6, var7);
      var10.put(var8, var9);
      return var10.build();
   }

   public static ImmutableSetMultimap$Builder builder() {
      return new ImmutableSetMultimap$Builder();
   }

   public static ImmutableSetMultimap copyOf(Multimap var0) {
      return copyOf(var0, (Comparator)null);
   }

   private static ImmutableSetMultimap copyOf(Multimap var0, Comparator var1) {
      Preconditions.checkNotNull(var0);
      if(var0.isEmpty() && var1 == null) {
         return of();
      } else {
         if(var0 instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap var2 = (ImmutableSetMultimap)var0;
            if(!var2.isPartialView()) {
               return var2;
            }
         }

         ImmutableMap$Builder var9 = new ImmutableMap$Builder(var0.asMap().size());
         int var3 = 0;
         Iterator var4 = var0.asMap().entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            Object var6 = var5.getKey();
            Collection var7 = (Collection)var5.getValue();
            ImmutableSet var8 = valueSet(var1, var7);
            if(!var8.isEmpty()) {
               var9.put(var6, var8);
               var3 += var8.size();
            }
         }

         return new ImmutableSetMultimap(var9.build(), var3, var1);
      }
   }

   @Beta
   public static ImmutableSetMultimap copyOf(Iterable var0) {
      return (new ImmutableSetMultimap$Builder()).putAll(var0).build();
   }

   ImmutableSetMultimap(ImmutableMap var1, int var2, @Nullable Comparator var3) {
      super(var1, var2);
      this.emptySet = emptySet(var3);
   }

   public ImmutableSet get(@Nullable Object var1) {
      ImmutableSet var2 = (ImmutableSet)this.map.get(var1);
      return (ImmutableSet)MoreObjects.firstNonNull(var2, this.emptySet);
   }

   public ImmutableSetMultimap inverse() {
      ImmutableSetMultimap var1 = this.inverse;
      return var1 == null?(this.inverse = this.invert()):var1;
   }

   private ImmutableSetMultimap invert() {
      ImmutableSetMultimap$Builder var1 = builder();
      UnmodifiableIterator var2 = this.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getValue(), var3.getKey());
      }

      ImmutableSetMultimap var4 = var1.build();
      var4.inverse = this;
      return var4;
   }

   @Deprecated
   public ImmutableSet removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public ImmutableSet replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   public ImmutableSet entries() {
      ImmutableSet var1 = this.entries;
      return var1 == null?(this.entries = new ImmutableSetMultimap$EntrySet(this)):var1;
   }

   private static ImmutableSet valueSet(@Nullable Comparator var0, Collection var1) {
      return (ImmutableSet)(var0 == null?ImmutableSet.copyOf(var1):ImmutableSortedSet.copyOf(var0, var1));
   }

   private static ImmutableSet emptySet(@Nullable Comparator var0) {
      return (ImmutableSet)(var0 == null?ImmutableSet.of():ImmutableSortedSet.emptySet(var0));
   }

   private static ImmutableSet$Builder valuesBuilder(@Nullable Comparator var0) {
      return (ImmutableSet$Builder)(var0 == null?new ImmutableSet$Builder():new ImmutableSortedSet$Builder(var0));
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.valueComparator());
      Serialization.writeMultimap(this, var1);
   }

   @Nullable
   Comparator valueComparator() {
      return this.emptySet instanceof ImmutableSortedSet?((ImmutableSortedSet)this.emptySet).comparator():null;
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      Comparator var2 = (Comparator)var1.readObject();
      int var3 = var1.readInt();
      if(var3 < 0) {
         throw new InvalidObjectException((new StringBuilder(29)).append("Invalid key count ").append(var3).toString());
      } else {
         ImmutableMap$Builder var4 = ImmutableMap.builder();
         int var5 = 0;

         for(int var6 = 0; var6 < var3; ++var6) {
            Object var7 = var1.readObject();
            int var8 = var1.readInt();
            if(var8 <= 0) {
               throw new InvalidObjectException((new StringBuilder(31)).append("Invalid value count ").append(var8).toString());
            }

            ImmutableSet$Builder var9 = valuesBuilder(var2);

            for(int var10 = 0; var10 < var8; ++var10) {
               var9.add(var1.readObject());
            }

            ImmutableSet var14 = var9.build();
            if(var14.size() != var8) {
               String var11 = String.valueOf(var7);
               throw new InvalidObjectException((new StringBuilder(40 + String.valueOf(var11).length())).append("Duplicate key-value pairs exist for key ").append(var11).toString());
            }

            var4.put(var7, var14);
            var5 += var8;
         }

         ImmutableMap var13;
         try {
            var13 = var4.build();
         } catch (IllegalArgumentException var12) {
            throw (InvalidObjectException)(new InvalidObjectException(var12.getMessage())).initCause(var12);
         }

         ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set(this, var13);
         ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set(this, var5);
         ImmutableMultimap$FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(var2));
      }
   }

   // $FF: synthetic method
   static ImmutableSetMultimap access$000(Multimap var0, Comparator var1) {
      return copyOf(var0, var1);
   }
}
