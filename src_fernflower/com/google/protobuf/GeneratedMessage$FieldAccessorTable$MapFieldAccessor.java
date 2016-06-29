package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class GeneratedMessage$FieldAccessorTable$MapFieldAccessor implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
   private final Descriptors$FieldDescriptor field;
   private final Message mapEntryMessageDefaultInstance;

   GeneratedMessage$FieldAccessorTable$MapFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4) {
      this.field = var1;
      java.lang.reflect.Method var5 = GeneratedMessage.access$1100(var3, "getDefaultInstance", new Class[0]);
      MapField var6 = this.getMapField((GeneratedMessage)GeneratedMessage.access$1200(var5, (Object)null, new Object[0]));
      this.mapEntryMessageDefaultInstance = var6.getMapEntryMessageDefaultInstance();
   }

   private MapField getMapField(GeneratedMessage var1) {
      return var1.internalGetMapField(this.field.getNumber());
   }

   private MapField getMapField(GeneratedMessage$Builder var1) {
      return var1.internalGetMapField(this.field.getNumber());
   }

   private MapField getMutableMapField(GeneratedMessage$Builder var1) {
      return var1.internalGetMutableMapField(this.field.getNumber());
   }

   public Object get(GeneratedMessage var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < this.getRepeatedCount(var1); ++var3) {
         var2.add(this.getRepeated(var1, var3));
      }

      return Collections.unmodifiableList(var2);
   }

   public Object get(GeneratedMessage$Builder var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < this.getRepeatedCount(var1); ++var3) {
         var2.add(this.getRepeated(var1, var3));
      }

      return Collections.unmodifiableList(var2);
   }

   public Object getRaw(GeneratedMessage var1) {
      return this.get(var1);
   }

   public Object getRaw(GeneratedMessage$Builder var1) {
      return this.get(var1);
   }

   public void set(GeneratedMessage$Builder var1, Object var2) {
      this.clear(var1);
      Iterator var3 = ((List)var2).iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.addRepeated(var1, var4);
      }

   }

   public Object getRepeated(GeneratedMessage var1, int var2) {
      return this.getMapField(var1).getList().get(var2);
   }

   public Object getRepeated(GeneratedMessage$Builder var1, int var2) {
      return this.getMapField(var1).getList().get(var2);
   }

   public Object getRepeatedRaw(GeneratedMessage var1, int var2) {
      return this.getRepeated(var1, var2);
   }

   public Object getRepeatedRaw(GeneratedMessage$Builder var1, int var2) {
      return this.getRepeated(var1, var2);
   }

   public void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3) {
      this.getMutableMapField(var1).getMutableList().set(var2, (Message)var3);
   }

   public void addRepeated(GeneratedMessage$Builder var1, Object var2) {
      this.getMutableMapField(var1).getMutableList().add((Message)var2);
   }

   public boolean has(GeneratedMessage var1) {
      throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
   }

   public boolean has(GeneratedMessage$Builder var1) {
      throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
   }

   public int getRepeatedCount(GeneratedMessage var1) {
      return this.getMapField(var1).getList().size();
   }

   public int getRepeatedCount(GeneratedMessage$Builder var1) {
      return this.getMapField(var1).getList().size();
   }

   public void clear(GeneratedMessage$Builder var1) {
      this.getMutableMapField(var1).getMutableList().clear();
   }

   public Message$Builder newBuilder() {
      return this.mapEntryMessageDefaultInstance.newBuilderForType();
   }

   public Message$Builder getBuilder(GeneratedMessage$Builder var1) {
      throw new UnsupportedOperationException("Nested builder not supported for map fields.");
   }

   public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder var1, int var2) {
      throw new UnsupportedOperationException("Nested builder not supported for map fields.");
   }
}
