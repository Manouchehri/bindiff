package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Serialization$1;
import com.google.common.collect.Serialization$FieldSetter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class Serialization {
   static int readCount(ObjectInputStream var0) {
      return var0.readInt();
   }

   static void writeMap(Map var0, ObjectOutputStream var1) {
      var1.writeInt(var0.size());
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeObject(var3.getValue());
      }

   }

   static void populateMap(Map var0, ObjectInputStream var1) {
      int var2 = var1.readInt();
      populateMap(var0, var1, var2);
   }

   static void populateMap(Map var0, ObjectInputStream var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         Object var5 = var1.readObject();
         var0.put(var4, var5);
      }

   }

   static void writeMultiset(Multiset var0, ObjectOutputStream var1) {
      int var2 = var0.entrySet().size();
      var1.writeInt(var2);
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Multiset$Entry var4 = (Multiset$Entry)var3.next();
         var1.writeObject(var4.getElement());
         var1.writeInt(var4.getCount());
      }

   }

   static void populateMultiset(Multiset var0, ObjectInputStream var1) {
      int var2 = var1.readInt();
      populateMultiset(var0, var1, var2);
   }

   static void populateMultiset(Multiset var0, ObjectInputStream var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         int var5 = var1.readInt();
         var0.add(var4, var5);
      }

   }

   static void writeMultimap(Multimap var0, ObjectOutputStream var1) {
      var1.writeInt(var0.asMap().size());
      Iterator var2 = var0.asMap().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeInt(((Collection)var3.getValue()).size());
         Iterator var4 = ((Collection)var3.getValue()).iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            var1.writeObject(var5);
         }
      }

   }

   static void populateMultimap(Multimap var0, ObjectInputStream var1) {
      int var2 = var1.readInt();
      populateMultimap(var0, var1, var2);
   }

   static void populateMultimap(Multimap var0, ObjectInputStream var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         Collection var5 = var0.get(var4);
         int var6 = var1.readInt();

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var1.readObject();
            var5.add(var8);
         }
      }

   }

   static Serialization$FieldSetter getFieldSetter(Class var0, String var1) {
      try {
         Field var2 = var0.getDeclaredField(var1);
         return new Serialization$FieldSetter(var2, (Serialization$1)null);
      } catch (NoSuchFieldException var3) {
         throw new AssertionError(var3);
      }
   }
}
