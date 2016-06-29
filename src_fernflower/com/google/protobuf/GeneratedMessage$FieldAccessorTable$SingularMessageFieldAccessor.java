package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;

final class GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
   private final java.lang.reflect.Method newBuilderMethod;
   private final java.lang.reflect.Method getBuilderMethodBuilder;

   GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4, String var5) {
      super(var1, var2, var3, var4, var5);
      this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
      String var6 = String.valueOf(String.valueOf(var2));
      this.getBuilderMethodBuilder = GeneratedMessage.access$1100(var4, (new StringBuilder(10 + var6.length())).append("get").append(var6).append("Builder").toString(), new Class[0]);
   }

   private Object coerceType(Object var1) {
      return this.type.isInstance(var1)?var1:((Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, (Object)null, new Object[0])).mergeFrom((Message)var1).buildPartial();
   }

   public void set(GeneratedMessage$Builder var1, Object var2) {
      super.set(var1, this.coerceType(var2));
   }

   public Message$Builder newBuilder() {
      return (Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, (Object)null, new Object[0]);
   }

   public Message$Builder getBuilder(GeneratedMessage$Builder var1) {
      return (Message$Builder)GeneratedMessage.access$1200(this.getBuilderMethodBuilder, var1, new Object[0]);
   }
}
