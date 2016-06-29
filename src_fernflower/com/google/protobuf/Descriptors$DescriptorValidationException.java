package com.google.protobuf;

import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Message;

public class Descriptors$DescriptorValidationException extends Exception {
   private static final long serialVersionUID = 5750205775490483148L;
   private final String name;
   private final Message proto;
   private final String description;

   public String getProblemSymbolName() {
      return this.name;
   }

   public Message getProblemProto() {
      return this.proto;
   }

   public String getDescription() {
      return this.description;
   }

   private Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor var1, String var2) {
      String var3 = String.valueOf(String.valueOf(var1.getFullName()));
      String var4 = String.valueOf(String.valueOf(var2));
      super((new StringBuilder(2 + var3.length() + var4.length())).append(var3).append(": ").append(var4).toString());
      this.name = var1.getFullName();
      this.proto = var1.toProto();
      this.description = var2;
   }

   private Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor var1, String var2, Throwable var3) {
      this(var1, var2);
      this.initCause(var3);
   }

   private Descriptors$DescriptorValidationException(Descriptors$FileDescriptor var1, String var2) {
      String var3 = String.valueOf(String.valueOf(var1.getName()));
      String var4 = String.valueOf(String.valueOf(var2));
      super((new StringBuilder(2 + var3.length() + var4.length())).append(var3).append(": ").append(var4).toString());
      this.name = var1.getName();
      this.proto = var1.toProto();
      this.description = var2;
   }

   // $FF: synthetic method
   Descriptors$DescriptorValidationException(Descriptors$FileDescriptor var1, String var2, Descriptors$1 var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor var1, String var2, Descriptors$1 var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor var1, String var2, Throwable var3, Descriptors$1 var4) {
      this(var1, var2, var3);
   }
}
