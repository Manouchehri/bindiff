package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.MapFieldLite$MutatabilityAwareMap;
import com.google.protobuf.MutabilityOracle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapFieldLite implements MutabilityOracle {
   private MapFieldLite$MutatabilityAwareMap mapData;
   private boolean isMutable;
   private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite(Collections.emptyMap());

   private MapFieldLite(Map var1) {
      this.mapData = new MapFieldLite$MutatabilityAwareMap(this, var1);
      this.isMutable = true;
   }

   public static MapFieldLite emptyMapField() {
      return EMPTY_MAP_FIELD;
   }

   public static MapFieldLite newMapField() {
      return new MapFieldLite(new LinkedHashMap());
   }

   public Map getMap() {
      return Collections.unmodifiableMap(this.mapData);
   }

   public Map getMutableMap() {
      return this.mapData;
   }

   public void mergeFrom(MapFieldLite var1) {
      this.mapData.putAll(copy((Map)var1.mapData));
   }

   public void clear() {
      this.mapData.clear();
   }

   private static boolean equals(Object var0, Object var1) {
      return var0 instanceof byte[] && var1 instanceof byte[]?Arrays.equals((byte[])((byte[])var0), (byte[])((byte[])var1)):var0.equals(var1);
   }

   static boolean equals(Map var0, Map var1) {
      if(var0 == var1) {
         return true;
      } else if(var0.size() != var1.size()) {
         return false;
      } else {
         Iterator var2 = var0.entrySet().iterator();

         Entry var3;
         do {
            if(!var2.hasNext()) {
               return true;
            }

            var3 = (Entry)var2.next();
            if(!var1.containsKey(var3.getKey())) {
               return false;
            }
         } while(equals(var3.getValue(), var1.get(var3.getKey())));

         return false;
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof MapFieldLite)) {
         return false;
      } else {
         MapFieldLite var2 = (MapFieldLite)var1;
         return equals((Map)this.mapData, (Map)var2.mapData);
      }
   }

   private static int calculateHashCodeForObject(Object var0) {
      return var0 instanceof byte[]?LiteralByteString.hashCode((byte[])((byte[])var0)):(var0 instanceof Internal$EnumLite?Internal.hashEnum((Internal$EnumLite)var0):var0.hashCode());
   }

   static int calculateHashCodeForMap(Map var0) {
      int var1 = 0;

      Entry var3;
      for(Iterator var2 = var0.entrySet().iterator(); var2.hasNext(); var1 += calculateHashCodeForObject(var3.getKey()) ^ calculateHashCodeForObject(var3.getValue())) {
         var3 = (Entry)var2.next();
      }

      return var1;
   }

   public int hashCode() {
      return calculateHashCodeForMap(this.mapData);
   }

   private static Object copy(Object var0) {
      if(var0 instanceof byte[]) {
         byte[] var1 = (byte[])((byte[])var0);
         return Arrays.copyOf(var1, var1.length);
      } else {
         return var0;
      }
   }

   static Map copy(Map var0) {
      LinkedHashMap var1 = new LinkedHashMap();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getKey(), copy(var3.getValue()));
      }

      return var1;
   }

   public MapFieldLite copy() {
      return new MapFieldLite(copy((Map)this.mapData));
   }

   public void makeImmutable() {
      this.isMutable = false;
   }

   public boolean isMutable() {
      return this.isMutable;
   }

   public void ensureMutable() {
      if(!this.isMutable()) {
         throw new UnsupportedOperationException();
      }
   }

   static {
      EMPTY_MAP_FIELD.makeImmutable();
   }
}
