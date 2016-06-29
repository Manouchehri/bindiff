package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.Message$Builder;
import java.util.Iterator;
import java.util.List;

class GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
   protected final Class type;
   protected final java.lang.reflect.Method getMethod;
   protected final java.lang.reflect.Method getMethodBuilder;
   protected final java.lang.reflect.Method getRepeatedMethod;
   protected final java.lang.reflect.Method getRepeatedMethodBuilder;
   protected final java.lang.reflect.Method setRepeatedMethod;
   protected final java.lang.reflect.Method addRepeatedMethod;
   protected final java.lang.reflect.Method getCountMethod;
   protected final java.lang.reflect.Method getCountMethodBuilder;
   protected final java.lang.reflect.Method clearMethod;

   GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4) {
      // $FF: Couldn't be decompiled
   }

   public Object get(GeneratedMessage var1) {
      return GeneratedMessage.access$1200(this.getMethod, var1, new Object[0]);
   }

   public Object get(GeneratedMessage$Builder var1) {
      return GeneratedMessage.access$1200(this.getMethodBuilder, var1, new Object[0]);
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
      return GeneratedMessage.access$1200(this.getRepeatedMethod, var1, new Object[]{Integer.valueOf(var2)});
   }

   public Object getRepeated(GeneratedMessage$Builder var1, int var2) {
      return GeneratedMessage.access$1200(this.getRepeatedMethodBuilder, var1, new Object[]{Integer.valueOf(var2)});
   }

   public Object getRepeatedRaw(GeneratedMessage var1, int var2) {
      return this.getRepeated(var1, var2);
   }

   public Object getRepeatedRaw(GeneratedMessage$Builder var1, int var2) {
      return this.getRepeated(var1, var2);
   }

   public void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3) {
      GeneratedMessage.access$1200(this.setRepeatedMethod, var1, new Object[]{Integer.valueOf(var2), var3});
   }

   public void addRepeated(GeneratedMessage$Builder var1, Object var2) {
      GeneratedMessage.access$1200(this.addRepeatedMethod, var1, new Object[]{var2});
   }

   public boolean has(GeneratedMessage var1) {
      throw new UnsupportedOperationException("hasField() called on a repeated field.");
   }

   public boolean has(GeneratedMessage$Builder var1) {
      throw new UnsupportedOperationException("hasField() called on a repeated field.");
   }

   public int getRepeatedCount(GeneratedMessage var1) {
      return ((Integer)GeneratedMessage.access$1200(this.getCountMethod, var1, new Object[0])).intValue();
   }

   public int getRepeatedCount(GeneratedMessage$Builder var1) {
      return ((Integer)GeneratedMessage.access$1200(this.getCountMethodBuilder, var1, new Object[0])).intValue();
   }

   public void clear(GeneratedMessage$Builder var1) {
      GeneratedMessage.access$1200(this.clearMethod, var1, new Object[0]);
   }

   public Message$Builder newBuilder() {
      throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
   }

   public Message$Builder getBuilder(GeneratedMessage$Builder var1) {
      throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
   }

   public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
   }
}
