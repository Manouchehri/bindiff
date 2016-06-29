package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;

final class GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
   private final java.lang.reflect.Method getBytesMethod;
   private final java.lang.reflect.Method getBytesMethodBuilder;
   private final java.lang.reflect.Method setBytesMethodBuilder;

   GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4, String var5) {
      super(var1, var2, var3, var4, var5);
      String var6 = String.valueOf(String.valueOf(var2));
      this.getBytesMethod = GeneratedMessage.access$1100(var3, (new StringBuilder(8 + var6.length())).append("get").append(var6).append("Bytes").toString(), new Class[0]);
      String var7 = String.valueOf(String.valueOf(var2));
      this.getBytesMethodBuilder = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var7.length())).append("get").append(var7).append("Bytes").toString(), new Class[0]);
      String var8 = String.valueOf(String.valueOf(var2));
      this.setBytesMethodBuilder = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var8.length())).append("set").append(var8).append("Bytes").toString(), new Class[]{ByteString.class});
   }

   public Object getRaw(GeneratedMessage var1) {
      return GeneratedMessage.access$1200(this.getBytesMethod, var1, new Object[0]);
   }

   public Object getRaw(GeneratedMessage$Builder var1) {
      return GeneratedMessage.access$1200(this.getBytesMethodBuilder, var1, new Object[0]);
   }

   public void set(GeneratedMessage$Builder var1, Object var2) {
      if(var2 instanceof ByteString) {
         GeneratedMessage.access$1200(this.setBytesMethodBuilder, var1, new Object[]{var2});
      } else {
         super.set(var1, var2);
      }

   }
}
