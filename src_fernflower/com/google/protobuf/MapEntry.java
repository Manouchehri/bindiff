package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat$FieldType;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class MapEntry extends AbstractMessage {
   private final MapEntry$Metadata metadata;
   private final MapEntryLite data;

   private MapEntry(Descriptors$Descriptor var1, WireFormat$FieldType var2, Object var3, WireFormat$FieldType var4, Object var5) {
      this.data = MapEntryLite.newDefaultInstance(var2, var3, var4, var5);
      this.metadata = new MapEntry$Metadata(var1, this);
   }

   private MapEntry(MapEntry$Metadata var1, MapEntryLite var2) {
      this.metadata = var1;
      this.data = var2;
   }

   public static MapEntry newDefaultInstance(Descriptors$Descriptor var0, WireFormat$FieldType var1, Object var2, WireFormat$FieldType var3, Object var4) {
      return new MapEntry(var0, var1, var2, var3, var4);
   }

   public Object getKey() {
      return this.data.getKey();
   }

   public Object getValue() {
      return this.data.getValue();
   }

   public int getSerializedSize() {
      return this.data.getSerializedSize();
   }

   public void writeTo(CodedOutputStream var1) {
      this.data.writeTo(var1);
   }

   public boolean isInitialized() {
      return this.data.isInitialized();
   }

   public Parser getParserForType() {
      return this.metadata.parser;
   }

   public MapEntry$Builder newBuilderForType() {
      return new MapEntry$Builder(this.metadata, (MapEntry$1)null);
   }

   public MapEntry$Builder toBuilder() {
      return new MapEntry$Builder(this.metadata, this.data, (MapEntry$1)null);
   }

   public MapEntry getDefaultInstanceForType() {
      return this.metadata.defaultInstance;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return this.metadata.descriptor;
   }

   public Map getAllFields() {
      TreeMap var1 = new TreeMap();
      Iterator var2 = this.metadata.descriptor.getFields().iterator();

      while(var2.hasNext()) {
         Descriptors$FieldDescriptor var3 = (Descriptors$FieldDescriptor)var2.next();
         if(this.hasField(var3)) {
            var1.put(var3, this.getField(var3));
         }
      }

      return Collections.unmodifiableMap(var1);
   }

   private void checkFieldDescriptor(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.metadata.descriptor) {
         String var2 = String.valueOf(String.valueOf(var1.getFullName()));
         String var3 = String.valueOf(String.valueOf(this.metadata.descriptor.getFullName()));
         throw new RuntimeException((new StringBuilder(42 + var2.length() + var3.length())).append("Wrong FieldDescriptor \"").append(var2).append("\" used in message \"").append(var3).toString());
      }
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      this.checkFieldDescriptor(var1);
      return true;
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      this.checkFieldDescriptor(var1);
      Object var2 = var1.getNumber() == 1?this.getKey():this.getValue();
      if(var1.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
         var2 = var1.getEnumType().findValueByNumberCreatingIfUnknown(((Integer)var2).intValue());
      }

      return var2;
   }

   public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
   }

   public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
   }

   public UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   // $FF: synthetic method
   static MapEntryLite access$000(MapEntry var0) {
      return var0.data;
   }

   // $FF: synthetic method
   MapEntry(MapEntry$Metadata var1, MapEntryLite var2, MapEntry$1 var3) {
      this(var1, var2);
   }
}
