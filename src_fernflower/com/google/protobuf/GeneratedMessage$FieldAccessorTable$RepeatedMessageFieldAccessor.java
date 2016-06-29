package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;

final class GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor {
   private final java.lang.reflect.Method newBuilderMethod;
   private final java.lang.reflect.Method getBuilderMethodBuilder;

   GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4) {
      super(var1, var2, var3, var4);
      this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
      String var5 = String.valueOf(String.valueOf(var2));
      this.getBuilderMethodBuilder = GeneratedMessage.access$1100(var4, (new StringBuilder(10 + var5.length())).append("get").append(var5).append("Builder").toString(), new Class[]{Integer.TYPE});
   }

   private Object coerceType(Object var1) {
      return this.type.isInstance(var1)?var1:((Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, (Object)null, new Object[0])).mergeFrom((Message)var1).build();
   }

   public void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3) {
      super.setRepeated(var1, var2, this.coerceType(var3));
   }

   public void addRepeated(GeneratedMessage$Builder var1, Object var2) {
      super.addRepeated(var1, this.coerceType(var2));
   }

   public Message$Builder newBuilder() {
      return (Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, (Object)null, new Object[0]);
   }

   public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder var1, int var2) {
      return (Message$Builder)GeneratedMessage.access$1200(this.getBuilderMethodBuilder, var1, new Object[]{Integer.valueOf(var2)});
   }
}
