package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Internal$EnumLite;

class GeneratedMessage$FieldAccessorTable$OneofAccessor {
   private final Descriptors$Descriptor descriptor;
   private final java.lang.reflect.Method caseMethod;
   private final java.lang.reflect.Method caseMethodBuilder;
   private final java.lang.reflect.Method clearMethod;

   GeneratedMessage$FieldAccessorTable$OneofAccessor(Descriptors$Descriptor var1, String var2, Class var3, Class var4) {
      // $FF: Couldn't be decompiled
   }

   public boolean has(GeneratedMessage var1) {
      return ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethod, var1, new Object[0])).getNumber() != 0;
   }

   public boolean has(GeneratedMessage$Builder var1) {
      return ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethodBuilder, var1, new Object[0])).getNumber() != 0;
   }

   public Descriptors$FieldDescriptor get(GeneratedMessage var1) {
      int var2 = ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethod, var1, new Object[0])).getNumber();
      return var2 > 0?this.descriptor.findFieldByNumber(var2):null;
   }

   public Descriptors$FieldDescriptor get(GeneratedMessage$Builder var1) {
      int var2 = ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethodBuilder, var1, new Object[0])).getNumber();
      return var2 > 0?this.descriptor.findFieldByNumber(var2):null;
   }

   public void clear(GeneratedMessage$Builder var1) {
      GeneratedMessage.access$1200(this.clearMethod, var1, new Object[0]);
   }
}
