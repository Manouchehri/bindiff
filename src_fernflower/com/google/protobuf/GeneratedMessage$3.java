package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;

final class GeneratedMessage$3 extends GeneratedMessage$CachedDescriptorRetriever {
   // $FF: synthetic field
   final Class val$singularType;
   // $FF: synthetic field
   final String val$descriptorOuterClass;
   // $FF: synthetic field
   final String val$extensionName;

   GeneratedMessage$3(Class var1, String var2, String var3) {
      super((GeneratedMessage$1)null);
      this.val$singularType = var1;
      this.val$descriptorOuterClass = var2;
      this.val$extensionName = var3;
   }

   protected Descriptors$FieldDescriptor loadDescriptor() {
      try {
         Class var1 = this.val$singularType.getClassLoader().loadClass(this.val$descriptorOuterClass);
         Descriptors$FileDescriptor var4 = (Descriptors$FileDescriptor)var1.getField("descriptor").get((Object)null);
         return var4.findExtensionByName(this.val$extensionName);
      } catch (Exception var3) {
         String var2 = String.valueOf(String.valueOf(this.val$descriptorOuterClass));
         throw new RuntimeException((new StringBuilder(62 + var2.length())).append("Cannot load descriptors: ").append(var2).append(" is not a valid descriptor class name").toString(), var3);
      }
   }
}
