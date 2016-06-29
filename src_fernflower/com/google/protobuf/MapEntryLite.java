package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite$1;
import com.google.protobuf.MapEntryLite$Builder;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.io.IOException;

public class MapEntryLite extends AbstractMessageLite {
   private static final int KEY_FIELD_NUMBER = 1;
   private static final int VALUE_FIELD_NUMBER = 2;
   private final MapEntryLite$Metadata metadata;
   private final Object key;
   private final Object value;
   private volatile int cachedSerializedSize;

   private MapEntryLite(WireFormat$FieldType var1, Object var2, WireFormat$FieldType var3, Object var4) {
      this.cachedSerializedSize = -1;
      this.metadata = new MapEntryLite$Metadata(this, var1, var3);
      this.key = var2;
      this.value = var4;
   }

   private MapEntryLite(MapEntryLite$Metadata var1, Object var2, Object var3) {
      this.cachedSerializedSize = -1;
      this.metadata = var1;
      this.key = var2;
      this.value = var3;
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public static MapEntryLite newDefaultInstance(WireFormat$FieldType var0, Object var1, WireFormat$FieldType var2, Object var3) {
      return new MapEntryLite(var0, var1, var2, var3);
   }

   public void writeTo(CodedOutputStream var1) {
      this.writeField(1, this.metadata.keyType, this.key, var1);
      this.writeField(2, this.metadata.valueType, this.value, var1);
   }

   private void writeField(int var1, WireFormat$FieldType var2, Object var3, CodedOutputStream var4) {
      var4.writeTag(var1, var2.getWireType());
      FieldSet.writeElementNoTag(var4, var2, var3);
   }

   public int getSerializedSize() {
      if(this.cachedSerializedSize != -1) {
         return this.cachedSerializedSize;
      } else {
         byte var1 = 0;
         int var2 = var1 + this.getFieldSize(1, this.metadata.keyType, this.key);
         var2 += this.getFieldSize(2, this.metadata.valueType, this.value);
         this.cachedSerializedSize = var2;
         return var2;
      }
   }

   private int getFieldSize(int var1, WireFormat$FieldType var2, Object var3) {
      return CodedOutputStream.computeTagSize(var1) + FieldSet.computeElementSizeNoTag(var2, var3);
   }

   private MapEntryLite(MapEntryLite$Metadata var1, CodedInputStream var2, ExtensionRegistryLite var3) {
      this.cachedSerializedSize = -1;

      try {
         Object var4 = var1.defaultInstance.key;
         Object var5 = var1.defaultInstance.value;

         while(true) {
            int var6 = var2.readTag();
            if(var6 == 0) {
               break;
            }

            if(var6 == WireFormat.makeTag(1, var1.keyType.getWireType())) {
               var4 = this.mergeField(var2, var3, var1.keyType, var4);
            } else if(var6 == WireFormat.makeTag(2, var1.valueType.getWireType())) {
               var5 = this.mergeField(var2, var3, var1.valueType, var5);
            } else if(!var2.skipField(var6)) {
               break;
            }
         }

         this.metadata = var1;
         this.key = var4;
         this.value = var5;
      } catch (InvalidProtocolBufferException var7) {
         throw var7.setUnfinishedMessage(this);
      } catch (IOException var8) {
         throw (new InvalidProtocolBufferException(var8.getMessage())).setUnfinishedMessage(this);
      }
   }

   private Object mergeField(CodedInputStream var1, ExtensionRegistryLite var2, WireFormat$FieldType var3, Object var4) {
      switch(MapEntryLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[var3.ordinal()]) {
      case 1:
         MessageLite$Builder var5 = ((MessageLite)var4).toBuilder();
         var1.readMessage(var5, var2);
         return var5.buildPartial();
      case 2:
         return Integer.valueOf(var1.readEnum());
      case 3:
         throw new RuntimeException("Groups are not allowed in maps.");
      default:
         return FieldSet.readPrimitiveField(var1, var3, true);
      }
   }

   public Parser getParserForType() {
      return this.metadata.parser;
   }

   public MapEntryLite$Builder newBuilderForType() {
      return new MapEntryLite$Builder(this.metadata, (MapEntryLite$1)null);
   }

   public MapEntryLite$Builder toBuilder() {
      return new MapEntryLite$Builder(this.metadata, this.key, this.value, (MapEntryLite$1)null);
   }

   public MapEntryLite getDefaultInstanceForType() {
      return this.metadata.defaultInstance;
   }

   public boolean isInitialized() {
      return this.metadata.valueType.getJavaType() == WireFormat$JavaType.MESSAGE?((MessageLite)this.value).isInitialized():true;
   }

   // $FF: synthetic method
   MapEntryLite(MapEntryLite$Metadata var1, CodedInputStream var2, ExtensionRegistryLite var3, MapEntryLite$1 var4) {
      this(var1, var2, var3);
   }

   // $FF: synthetic method
   static Object access$300(MapEntryLite var0) {
      return var0.key;
   }

   // $FF: synthetic method
   static Object access$400(MapEntryLite var0) {
      return var0.value;
   }

   // $FF: synthetic method
   MapEntryLite(MapEntryLite$Metadata var1, Object var2, Object var3, MapEntryLite$1 var4) {
      this(var1, var2, var3);
   }
}
