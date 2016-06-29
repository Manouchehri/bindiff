package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Message$Builder;

class GeneratedMessage$FieldAccessorTable$SingularFieldAccessor implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
   protected final Class type;
   protected final java.lang.reflect.Method getMethod;
   protected final java.lang.reflect.Method getMethodBuilder;
   protected final java.lang.reflect.Method setMethod;
   protected final java.lang.reflect.Method hasMethod;
   protected final java.lang.reflect.Method hasMethodBuilder;
   protected final java.lang.reflect.Method clearMethod;
   protected final java.lang.reflect.Method caseMethod;
   protected final java.lang.reflect.Method caseMethodBuilder;
   protected final Descriptors$FieldDescriptor field;
   protected final boolean isOneofField;
   protected final boolean hasHasMethod;

   GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4, String var5) {
      // $FF: Couldn't be decompiled
   }

   private int getOneofFieldNumber(GeneratedMessage var1) {
      return ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethod, var1, new Object[0])).getNumber();
   }

   private int getOneofFieldNumber(GeneratedMessage$Builder var1) {
      return ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethodBuilder, var1, new Object[0])).getNumber();
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
      GeneratedMessage.access$1200(this.setMethod, var1, new Object[]{var2});
   }

   public Object getRepeated(GeneratedMessage var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
   }

   public Object getRepeatedRaw(GeneratedMessage var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
   }

   public Object getRepeated(GeneratedMessage$Builder var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
   }

   public Object getRepeatedRaw(GeneratedMessage$Builder var1, int var2) {
      throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
   }

   public void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3) {
      throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
   }

   public void addRepeated(GeneratedMessage$Builder var1, Object var2) {
      throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
   }

   public boolean has(GeneratedMessage var1) {
      return !this.hasHasMethod?(this.isOneofField?this.getOneofFieldNumber(var1) == this.field.getNumber():!this.get(var1).equals(this.field.getDefaultValue())):((Boolean)GeneratedMessage.access$1200(this.hasMethod, var1, new Object[0])).booleanValue();
   }

   public boolean has(GeneratedMessage$Builder var1) {
      return !this.hasHasMethod?(this.isOneofField?this.getOneofFieldNumber(var1) == this.field.getNumber():!this.get(var1).equals(this.field.getDefaultValue())):((Boolean)GeneratedMessage.access$1200(this.hasMethodBuilder, var1, new Object[0])).booleanValue();
   }

   public int getRepeatedCount(GeneratedMessage var1) {
      throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
   }

   public int getRepeatedCount(GeneratedMessage$Builder var1) {
      throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
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
