package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import java.util.ArrayList;
import java.util.Collections;

final class GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor {
   private Descriptors$EnumDescriptor enumDescriptor;
   private final java.lang.reflect.Method valueOfMethod;
   private final java.lang.reflect.Method getValueDescriptorMethod;
   private boolean supportUnknownEnumValue;
   private java.lang.reflect.Method getRepeatedValueMethod;
   private java.lang.reflect.Method getRepeatedValueMethodBuilder;
   private java.lang.reflect.Method setRepeatedValueMethod;
   private java.lang.reflect.Method addRepeatedValueMethod;

   GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(Descriptors$FieldDescriptor var1, String var2, Class var3, Class var4) {
      super(var1, var2, var3, var4);
      this.enumDescriptor = var1.getEnumType();
      this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors$EnumValueDescriptor.class});
      this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
      this.supportUnknownEnumValue = var1.getFile().supportsUnknownEnumValue();
      if(this.supportUnknownEnumValue) {
         String var5 = String.valueOf(String.valueOf(var2));
         this.getRepeatedValueMethod = GeneratedMessage.access$1100(var3, (new StringBuilder(8 + var5.length())).append("get").append(var5).append("Value").toString(), new Class[]{Integer.TYPE});
         String var6 = String.valueOf(String.valueOf(var2));
         this.getRepeatedValueMethodBuilder = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var6.length())).append("get").append(var6).append("Value").toString(), new Class[]{Integer.TYPE});
         String var7 = String.valueOf(String.valueOf(var2));
         this.setRepeatedValueMethod = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var7.length())).append("set").append(var7).append("Value").toString(), new Class[]{Integer.TYPE, Integer.TYPE});
         String var8 = String.valueOf(String.valueOf(var2));
         this.addRepeatedValueMethod = GeneratedMessage.access$1100(var4, (new StringBuilder(8 + var8.length())).append("add").append(var8).append("Value").toString(), new Class[]{Integer.TYPE});
      }

   }

   public Object get(GeneratedMessage var1) {
      ArrayList var2 = new ArrayList();
      int var3 = this.getRepeatedCount(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.add(this.getRepeated(var1, var4));
      }

      return Collections.unmodifiableList(var2);
   }

   public Object get(GeneratedMessage$Builder var1) {
      ArrayList var2 = new ArrayList();
      int var3 = this.getRepeatedCount(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.add(this.getRepeated(var1, var4));
      }

      return Collections.unmodifiableList(var2);
   }

   public Object getRepeated(GeneratedMessage var1, int var2) {
      if(this.supportUnknownEnumValue) {
         int var3 = ((Integer)GeneratedMessage.access$1200(this.getRepeatedValueMethod, var1, new Object[]{Integer.valueOf(var2)})).intValue();
         return this.enumDescriptor.findValueByNumberCreatingIfUnknown(var3);
      } else {
         return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(var1, var2), new Object[0]);
      }
   }

   public Object getRepeated(GeneratedMessage$Builder var1, int var2) {
      if(this.supportUnknownEnumValue) {
         int var3 = ((Integer)GeneratedMessage.access$1200(this.getRepeatedValueMethodBuilder, var1, new Object[]{Integer.valueOf(var2)})).intValue();
         return this.enumDescriptor.findValueByNumberCreatingIfUnknown(var3);
      } else {
         return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(var1, var2), new Object[0]);
      }
   }

   public void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3) {
      if(this.supportUnknownEnumValue) {
         GeneratedMessage.access$1200(this.setRepeatedValueMethod, var1, new Object[]{Integer.valueOf(var2), Integer.valueOf(((Descriptors$EnumValueDescriptor)var3).getNumber())});
      } else {
         super.setRepeated(var1, var2, GeneratedMessage.access$1200(this.valueOfMethod, (Object)null, new Object[]{var3}));
      }
   }

   public void addRepeated(GeneratedMessage$Builder var1, Object var2) {
      if(this.supportUnknownEnumValue) {
         GeneratedMessage.access$1200(this.addRepeatedValueMethod, var1, new Object[]{Integer.valueOf(((Descriptors$EnumValueDescriptor)var2).getNumber())});
      } else {
         super.addRepeated(var1, GeneratedMessage.access$1200(this.valueOfMethod, (Object)null, new Object[]{var2}));
      }
   }
}
