package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;

final class GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
   private Descriptors$EnumDescriptor enumDescriptor;
   private java.lang.reflect.Method valueOfMethod;
   private java.lang.reflect.Method getValueDescriptorMethod;
   private boolean supportUnknownEnumValue;
   private java.lang.reflect.Method getValueMethod;
   private java.lang.reflect.Method getValueMethodBuilder;
   private java.lang.reflect.Method setValueMethod;

   GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4, String var5) {
      super(var1, var2, var3, var4, var5);
      this.enumDescriptor = var1.getEnumType();
      this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors$EnumValueDescriptor.class});
      this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
      this.supportUnknownEnumValue = var1.getFile().supportsUnknownEnumValue();
      if(this.supportUnknownEnumValue) {
         String var6 = String.valueOf(String.valueOf(var2));
         this.getValueMethod = GeneratedMessage.access$1100(var3, (new StringBuilder(8 + var6.length())).append("get").append(var6).append("Value").toString(), new Class[0]);
         String var7 = String.valueOf(String.valueOf(var2));
         this.getValueMethodBuilder = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var7.length())).append("get").append(var7).append("Value").toString(), new Class[0]);
         String var8 = String.valueOf(String.valueOf(var2));
         this.setValueMethod = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var8.length())).append("set").append(var8).append("Value").toString(), new Class[]{Integer.TYPE});
      }

   }

   public Object get(GeneratedMessage var1) {
      if(this.supportUnknownEnumValue) {
         int var2 = ((Integer)GeneratedMessage.access$1200(this.getValueMethod, var1, new Object[0])).intValue();
         return this.enumDescriptor.findValueByNumberCreatingIfUnknown(var2);
      } else {
         return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(var1), new Object[0]);
      }
   }

   public Object get(GeneratedMessage$Builder var1) {
      if(this.supportUnknownEnumValue) {
         int var2 = ((Integer)GeneratedMessage.access$1200(this.getValueMethodBuilder, var1, new Object[0])).intValue();
         return this.enumDescriptor.findValueByNumberCreatingIfUnknown(var2);
      } else {
         return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(var1), new Object[0]);
      }
   }

   public void set(GeneratedMessage$Builder var1, Object var2) {
      if(this.supportUnknownEnumValue) {
         GeneratedMessage.access$1200(this.setValueMethod, var1, new Object[]{Integer.valueOf(((Descriptors$EnumValueDescriptor)var2).getNumber())});
      } else {
         super.set(var1, GeneratedMessage.access$1200(this.valueOfMethod, (Object)null, new Object[]{var2}));
      }
   }
}
