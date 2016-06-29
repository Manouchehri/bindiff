package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$1;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$JavaType;

public class MapEntryLite$Builder extends AbstractMessageLite$Builder {
   private final MapEntryLite$Metadata metadata;
   private Object key;
   private Object value;

   private MapEntryLite$Builder(MapEntryLite$Metadata var1) {
      this.metadata = var1;
      this.key = MapEntryLite.access$300(var1.defaultInstance);
      this.value = MapEntryLite.access$400(var1.defaultInstance);
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public MapEntryLite$Builder setKey(Object var1) {
      this.key = var1;
      return this;
   }

   public MapEntryLite$Builder setValue(Object var1) {
      this.value = var1;
      return this;
   }

   public MapEntryLite$Builder clearKey() {
      this.key = MapEntryLite.access$300(this.metadata.defaultInstance);
      return this;
   }

   public MapEntryLite$Builder clearValue() {
      this.value = MapEntryLite.access$400(this.metadata.defaultInstance);
      return this;
   }

   public MapEntryLite$Builder clear() {
      this.key = MapEntryLite.access$300(this.metadata.defaultInstance);
      this.value = MapEntryLite.access$400(this.metadata.defaultInstance);
      return this;
   }

   public MapEntryLite build() {
      MapEntryLite var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public MapEntryLite buildPartial() {
      return new MapEntryLite(this.metadata, this.key, this.value, (MapEntryLite$1)null);
   }

   public MessageLite getDefaultInstanceForType() {
      return this.metadata.defaultInstance;
   }

   public boolean isInitialized() {
      return this.metadata.valueType.getJavaType() == WireFormat$JavaType.MESSAGE?((MessageLite)this.value).isInitialized():true;
   }

   private MapEntryLite$Builder(MapEntryLite$Metadata var1, Object var2, Object var3) {
      this.metadata = var1;
      this.key = var2;
      this.value = var3;
   }

   public MapEntryLite$Builder clone() {
      return new MapEntryLite$Builder(this.metadata, this.key, this.value);
   }

   public MapEntryLite$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      MapEntryLite var3 = new MapEntryLite(this.metadata, var1, var2, (MapEntryLite$1)null);
      this.key = MapEntryLite.access$300(var3);
      this.value = MapEntryLite.access$400(var3);
      return this;
   }

   // $FF: synthetic method
   MapEntryLite$Builder(MapEntryLite$Metadata var1, MapEntryLite$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   MapEntryLite$Builder(MapEntryLite$Metadata var1, Object var2, Object var3, MapEntryLite$1 var4) {
      this(var1, var2, var3);
   }
}
