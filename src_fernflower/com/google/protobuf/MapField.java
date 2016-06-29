package com.google.protobuf;

import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField$Converter;
import com.google.protobuf.MapField$ImmutableMessageConverter;
import com.google.protobuf.MapField$StorageMode;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MapFieldLite$MutatabilityAwareMap;
import com.google.protobuf.Message;
import com.google.protobuf.MutabilityOracle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapField implements MutabilityOracle {
   private volatile boolean isMutable;
   private volatile MapField$StorageMode mode;
   private MapFieldLite$MutatabilityAwareMap mapData;
   private List listData;
   private final MapField$Converter converter;

   private MapField(MapField$Converter var1, MapField$StorageMode var2, Map var3) {
      this.converter = var1;
      this.isMutable = true;
      this.mode = var2;
      this.mapData = new MapFieldLite$MutatabilityAwareMap(this, var3);
      this.listData = null;
   }

   private MapField(MapEntry var1, MapField$StorageMode var2, Map var3) {
      this((MapField$Converter)(new MapField$ImmutableMessageConverter(var1)), var2, var3);
   }

   public static MapField emptyMapField(MapEntry var0) {
      return new MapField(var0, MapField$StorageMode.MAP, Collections.emptyMap());
   }

   public static MapField newMapField(MapEntry var0) {
      return new MapField(var0, MapField$StorageMode.MAP, new LinkedHashMap());
   }

   private Message convertKeyAndValueToMessage(Object var1, Object var2) {
      return this.converter.convertKeyAndValueToMessage(var1, var2);
   }

   private void convertMessageToKeyAndValue(Message var1, Map var2) {
      this.converter.convertMessageToKeyAndValue(var1, var2);
   }

   private List convertMapToList(MapFieldLite$MutatabilityAwareMap var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.add(this.convertKeyAndValueToMessage(var4.getKey(), var4.getValue()));
      }

      return var2;
   }

   private MapFieldLite$MutatabilityAwareMap convertListToMap(List var1) {
      LinkedHashMap var2 = new LinkedHashMap();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Message var4 = (Message)var3.next();
         this.convertMessageToKeyAndValue(var4, var2);
      }

      return new MapFieldLite$MutatabilityAwareMap(this, var2);
   }

   public Map getMap() {
      if(this.mode == MapField$StorageMode.LIST) {
         synchronized(this) {
            if(this.mode == MapField$StorageMode.LIST) {
               this.mapData = this.convertListToMap(this.listData);
               this.mode = MapField$StorageMode.BOTH;
            }
         }
      }

      return Collections.unmodifiableMap(this.mapData);
   }

   public Map getMutableMap() {
      if(this.mode != MapField$StorageMode.MAP) {
         if(this.mode == MapField$StorageMode.LIST) {
            this.mapData = this.convertListToMap(this.listData);
         }

         this.listData = null;
         this.mode = MapField$StorageMode.MAP;
      }

      return this.mapData;
   }

   public void mergeFrom(MapField var1) {
      this.getMutableMap().putAll(MapFieldLite.copy(var1.getMap()));
   }

   public void clear() {
      this.mapData = new MapFieldLite$MutatabilityAwareMap(this, new LinkedHashMap());
      this.mode = MapField$StorageMode.MAP;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof MapField)) {
         return false;
      } else {
         MapField var2 = (MapField)var1;
         return MapFieldLite.equals(this.getMap(), var2.getMap());
      }
   }

   public int hashCode() {
      return MapFieldLite.calculateHashCodeForMap(this.getMap());
   }

   public MapField copy() {
      return new MapField(this.converter, MapField$StorageMode.MAP, MapFieldLite.copy(this.getMap()));
   }

   List getList() {
      if(this.mode == MapField$StorageMode.MAP) {
         synchronized(this) {
            if(this.mode == MapField$StorageMode.MAP) {
               this.listData = this.convertMapToList(this.mapData);
               this.mode = MapField$StorageMode.BOTH;
            }
         }
      }

      return Collections.unmodifiableList(this.listData);
   }

   List getMutableList() {
      if(this.mode != MapField$StorageMode.LIST) {
         if(this.mode == MapField$StorageMode.MAP) {
            this.listData = this.convertMapToList(this.mapData);
         }

         this.mapData = null;
         this.mode = MapField$StorageMode.LIST;
      }

      return this.listData;
   }

   Message getMapEntryMessageDefaultInstance() {
      return this.converter.getMessageDefaultInstance();
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
}
