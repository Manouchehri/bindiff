package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap$1;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public final class LinkedHashMultimap extends AbstractSetMultimap {
   private static final int DEFAULT_KEY_CAPACITY = 16;
   private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
   @VisibleForTesting
   static final double VALUE_SET_LOAD_FACTOR = 1.0D;
   @VisibleForTesting
   transient int valueSetCapacity = 2;
   private transient LinkedHashMultimap$ValueEntry multimapHeaderEntry;
   @GwtIncompatible("java serialization not supported")
   private static final long serialVersionUID = 1L;

   public static LinkedHashMultimap create() {
      return new LinkedHashMultimap(16, 2);
   }

   public static LinkedHashMultimap create(int var0, int var1) {
      return new LinkedHashMultimap(Maps.capacity(var0), Maps.capacity(var1));
   }

   public static LinkedHashMultimap create(Multimap var0) {
      LinkedHashMultimap var1 = create(var0.keySet().size(), 2);
      var1.putAll(var0);
      return var1;
   }

   private static void succeedsInValueSet(LinkedHashMultimap$ValueSetLink var0, LinkedHashMultimap$ValueSetLink var1) {
      var0.setSuccessorInValueSet(var1);
      var1.setPredecessorInValueSet(var0);
   }

   private static void succeedsInMultimap(LinkedHashMultimap$ValueEntry var0, LinkedHashMultimap$ValueEntry var1) {
      var0.setSuccessorInMultimap(var1);
      var1.setPredecessorInMultimap(var0);
   }

   private static void deleteFromValueSet(LinkedHashMultimap$ValueSetLink var0) {
      succeedsInValueSet(var0.getPredecessorInValueSet(), var0.getSuccessorInValueSet());
   }

   private static void deleteFromMultimap(LinkedHashMultimap$ValueEntry var0) {
      succeedsInMultimap(var0.getPredecessorInMultimap(), var0.getSuccessorInMultimap());
   }

   private LinkedHashMultimap(int var1, int var2) {
      super(new LinkedHashMap(var1));
      CollectPreconditions.checkNonnegative(var2, "expectedValuesPerKey");
      this.valueSetCapacity = var2;
      this.multimapHeaderEntry = new LinkedHashMultimap$ValueEntry((Object)null, (Object)null, 0, (LinkedHashMultimap$ValueEntry)null);
      succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
   }

   Set createCollection() {
      return new LinkedHashSet(this.valueSetCapacity);
   }

   Collection createCollection(Object var1) {
      return new LinkedHashMultimap$ValueSet(this, var1, this.valueSetCapacity);
   }

   public Set replaceValues(@Nullable Object var1, Iterable var2) {
      return super.replaceValues(var1, var2);
   }

   public Set entries() {
      return super.entries();
   }

   public Collection values() {
      return super.values();
   }

   Iterator entryIterator() {
      return new LinkedHashMultimap$1(this);
   }

   Iterator valueIterator() {
      return Maps.valueIterator(this.entryIterator());
   }

   public void clear() {
      super.clear();
      succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.keySet().size());
      Iterator var2 = this.keySet().iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.writeObject(var3);
      }

      var1.writeInt(this.size());
      var2 = this.entries().iterator();

      while(var2.hasNext()) {
         Entry var4 = (Entry)var2.next();
         var1.writeObject(var4.getKey());
         var1.writeObject(var4.getValue());
      }

   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.multimapHeaderEntry = new LinkedHashMultimap$ValueEntry((Object)null, (Object)null, 0, (LinkedHashMultimap$ValueEntry)null);
      succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
      this.valueSetCapacity = 2;
      int var2 = var1.readInt();
      LinkedHashMap var3 = new LinkedHashMap();

      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         Object var5 = var1.readObject();
         var3.put(var5, this.createCollection(var5));
      }

      var4 = var1.readInt();

      for(int var8 = 0; var8 < var4; ++var8) {
         Object var6 = var1.readObject();
         Object var7 = var1.readObject();
         ((Collection)var3.get(var6)).add(var7);
      }

      this.setMap(var3);
   }

   // $FF: synthetic method
   static void access$200(LinkedHashMultimap$ValueSetLink var0, LinkedHashMultimap$ValueSetLink var1) {
      succeedsInValueSet(var0, var1);
   }

   // $FF: synthetic method
   static LinkedHashMultimap$ValueEntry access$300(LinkedHashMultimap var0) {
      return var0.multimapHeaderEntry;
   }

   // $FF: synthetic method
   static void access$400(LinkedHashMultimap$ValueEntry var0, LinkedHashMultimap$ValueEntry var1) {
      succeedsInMultimap(var0, var1);
   }

   // $FF: synthetic method
   static void access$500(LinkedHashMultimap$ValueSetLink var0) {
      deleteFromValueSet(var0);
   }

   // $FF: synthetic method
   static void access$600(LinkedHashMultimap$ValueEntry var0) {
      deleteFromMultimap(var0);
   }
}
