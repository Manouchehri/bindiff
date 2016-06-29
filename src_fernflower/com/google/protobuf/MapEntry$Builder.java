package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Builder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapEntry$Builder extends AbstractMessage$Builder {
   private final MapEntry$Metadata metadata;
   private MapEntryLite data;
   private MapEntryLite$Builder dataBuilder;

   private MapEntry$Builder(MapEntry$Metadata var1) {
      this.metadata = var1;
      this.data = MapEntry.access$000(var1.defaultInstance);
      this.dataBuilder = null;
   }

   private MapEntry$Builder(MapEntry$Metadata var1, MapEntryLite var2) {
      this.metadata = var1;
      this.data = var2;
      this.dataBuilder = null;
   }

   public Object getKey() {
      return this.dataBuilder == null?this.data.getKey():this.dataBuilder.getKey();
   }

   public Object getValue() {
      return this.dataBuilder == null?this.data.getValue():this.dataBuilder.getValue();
   }

   private void ensureMutable() {
      if(this.dataBuilder == null) {
         this.dataBuilder = this.data.toBuilder();
      }

   }

   public MapEntry$Builder setKey(Object var1) {
      this.ensureMutable();
      this.dataBuilder.setKey(var1);
      return this;
   }

   public MapEntry$Builder clearKey() {
      this.ensureMutable();
      this.dataBuilder.clearKey();
      return this;
   }

   public MapEntry$Builder setValue(Object var1) {
      this.ensureMutable();
      this.dataBuilder.setValue(var1);
      return this;
   }

   public MapEntry$Builder clearValue() {
      this.ensureMutable();
      this.dataBuilder.clearValue();
      return this;
   }

   public MapEntry build() {
      MapEntry var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public MapEntry buildPartial() {
      if(this.dataBuilder != null) {
         this.data = this.dataBuilder.buildPartial();
         this.dataBuilder = null;
      }

      return new MapEntry(this.metadata, this.data, (MapEntry$1)null);
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return this.metadata.descriptor;
   }

   private void checkFieldDescriptor(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.metadata.descriptor) {
         String var2 = String.valueOf(String.valueOf(var1.getFullName()));
         String var3 = String.valueOf(String.valueOf(this.metadata.descriptor.getFullName()));
         throw new RuntimeException((new StringBuilder(42 + var2.length() + var3.length())).append("Wrong FieldDescriptor \"").append(var2).append("\" used in message \"").append(var3).toString());
      }
   }

   public Message$Builder newBuilderForField(Descriptors$FieldDescriptor var1) {
      this.checkFieldDescriptor(var1);
      if(var1.getNumber() == 2 && var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         return ((Message)this.data.getValue()).newBuilderForType();
      } else {
         String var2 = String.valueOf(String.valueOf(var1.getFullName()));
         throw new RuntimeException((new StringBuilder(32 + var2.length())).append("\"").append(var2).append("\" is not a message value field.").toString());
      }
   }

   public MapEntry$Builder setField(Descriptors$FieldDescriptor var1, Object var2) {
      this.checkFieldDescriptor(var1);
      if(var1.getNumber() == 1) {
         this.setKey(var2);
      } else {
         if(var1.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
            var2 = Integer.valueOf(((Descriptors$EnumValueDescriptor)var2).getNumber());
         }

         this.setValue(var2);
      }

      return this;
   }

   public MapEntry$Builder clearField(Descriptors$FieldDescriptor var1) {
      this.checkFieldDescriptor(var1);
      if(var1.getNumber() == 1) {
         this.clearKey();
      } else {
         this.clearValue();
      }

      return this;
   }

   public MapEntry$Builder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
   }

   public MapEntry$Builder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
   }

   public MapEntry$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public MapEntry getDefaultInstanceForType() {
      return this.metadata.defaultInstance;
   }

   public boolean isInitialized() {
      return this.dataBuilder != null?this.dataBuilder.isInitialized():this.data.isInitialized();
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

   public MapEntry$Builder clone() {
      return this.dataBuilder == null?new MapEntry$Builder(this.metadata, this.data):new MapEntry$Builder(this.metadata, this.dataBuilder.build());
   }

   // $FF: synthetic method
   MapEntry$Builder(MapEntry$Metadata var1, MapEntry$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   MapEntry$Builder(MapEntry$Metadata var1, MapEntryLite var2, MapEntry$1 var3) {
      this(var1, var2);
   }
}
