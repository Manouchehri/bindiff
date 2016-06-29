package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$FieldSettersHolder;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public class ImmutableListMultimap extends ImmutableMultimap implements ListMultimap {
   @LazyInit
   private transient ImmutableListMultimap inverse;
   @GwtIncompatible("Not needed in emulated source")
   private static final long serialVersionUID = 0L;

   public static ImmutableListMultimap of() {
      return EmptyImmutableListMultimap.INSTANCE;
   }

   public static ImmutableListMultimap of(Object var0, Object var1) {
      ImmutableListMultimap$Builder var2 = builder();
      var2.put(var0, var1);
      return var2.build();
   }

   public static ImmutableListMultimap of(Object var0, Object var1, Object var2, Object var3) {
      ImmutableListMultimap$Builder var4 = builder();
      var4.put(var0, var1);
      var4.put(var2, var3);
      return var4.build();
   }

   public static ImmutableListMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      ImmutableListMultimap$Builder var6 = builder();
      var6.put(var0, var1);
      var6.put(var2, var3);
      var6.put(var4, var5);
      return var6.build();
   }

   public static ImmutableListMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      ImmutableListMultimap$Builder var8 = builder();
      var8.put(var0, var1);
      var8.put(var2, var3);
      var8.put(var4, var5);
      var8.put(var6, var7);
      return var8.build();
   }

   public static ImmutableListMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      ImmutableListMultimap$Builder var10 = builder();
      var10.put(var0, var1);
      var10.put(var2, var3);
      var10.put(var4, var5);
      var10.put(var6, var7);
      var10.put(var8, var9);
      return var10.build();
   }

   public static ImmutableListMultimap$Builder builder() {
      return new ImmutableListMultimap$Builder();
   }

   public static ImmutableListMultimap copyOf(Multimap var0) {
      if(var0.isEmpty()) {
         return of();
      } else {
         if(var0 instanceof ImmutableListMultimap) {
            ImmutableListMultimap var1 = (ImmutableListMultimap)var0;
            if(!var1.isPartialView()) {
               return var1;
            }
         }

         ImmutableMap$Builder var6 = new ImmutableMap$Builder(var0.asMap().size());
         int var2 = 0;
         Iterator var3 = var0.asMap().entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            ImmutableList var5 = ImmutableList.copyOf((Collection)var4.getValue());
            if(!var5.isEmpty()) {
               var6.put(var4.getKey(), var5);
               var2 += var5.size();
            }
         }

         return new ImmutableListMultimap(var6.build(), var2);
      }
   }

   @Beta
   public static ImmutableListMultimap copyOf(Iterable var0) {
      return (new ImmutableListMultimap$Builder()).putAll(var0).build();
   }

   ImmutableListMultimap(ImmutableMap var1, int var2) {
      super(var1, var2);
   }

   public ImmutableList get(@Nullable Object var1) {
      ImmutableList var2 = (ImmutableList)this.map.get(var1);
      return var2 == null?ImmutableList.of():var2;
   }

   public ImmutableListMultimap inverse() {
      ImmutableListMultimap var1 = this.inverse;
      return var1 == null?(this.inverse = this.invert()):var1;
   }

   private ImmutableListMultimap invert() {
      ImmutableListMultimap$Builder var1 = builder();
      UnmodifiableIterator var2 = this.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getValue(), var3.getKey());
      }

      ImmutableListMultimap var4 = var1.build();
      var4.inverse = this;
      return var4;
   }

   @Deprecated
   public ImmutableList removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public ImmutableList replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      Serialization.writeMultimap(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = var1.readInt();
      if(var2 < 0) {
         throw new InvalidObjectException((new StringBuilder(29)).append("Invalid key count ").append(var2).toString());
      } else {
         ImmutableMap$Builder var3 = ImmutableMap.builder();
         int var4 = 0;

         for(int var5 = 0; var5 < var2; ++var5) {
            Object var6 = var1.readObject();
            int var7 = var1.readInt();
            if(var7 <= 0) {
               throw new InvalidObjectException((new StringBuilder(31)).append("Invalid value count ").append(var7).toString());
            }

            ImmutableList$Builder var8 = ImmutableList.builder();

            for(int var9 = 0; var9 < var7; ++var9) {
               var8.add(var1.readObject());
            }

            var3.put(var6, var8.build());
            var4 += var7;
         }

         ImmutableMap var11;
         try {
            var11 = var3.build();
         } catch (IllegalArgumentException var10) {
            throw (InvalidObjectException)(new InvalidObjectException(var10.getMessage())).initCause(var10);
         }

         ImmutableMultimap$FieldSettersHolder.MAP_FIELD_SETTER.set(this, var11);
         ImmutableMultimap$FieldSettersHolder.SIZE_FIELD_SETTER.set(this, var4);
      }
   }
}
