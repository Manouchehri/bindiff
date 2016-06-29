package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;

public final class Descriptors$MethodDescriptor extends Descriptors$GenericDescriptor {
   private final int index;
   private DescriptorProtos$MethodDescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private final Descriptors$ServiceDescriptor service;
   private Descriptors$Descriptor inputType;
   private Descriptors$Descriptor outputType;

   public int getIndex() {
      return this.index;
   }

   public DescriptorProtos$MethodDescriptorProto toProto() {
      return this.proto;
   }

   public String getName() {
      return this.proto.getName();
   }

   public String getFullName() {
      return this.fullName;
   }

   public Descriptors$FileDescriptor getFile() {
      return this.file;
   }

   public Descriptors$ServiceDescriptor getService() {
      return this.service;
   }

   public Descriptors$Descriptor getInputType() {
      return this.inputType;
   }

   public Descriptors$Descriptor getOutputType() {
      return this.outputType;
   }

   public DescriptorProtos$MethodOptions getOptions() {
      return this.proto.getOptions();
   }

   private Descriptors$MethodDescriptor(DescriptorProtos$MethodDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$ServiceDescriptor var3, int var4) {
      this.index = var4;
      this.proto = var1;
      this.file = var2;
      this.service = var3;
      String var5 = String.valueOf(String.valueOf(var3.getFullName()));
      String var6 = String.valueOf(String.valueOf(var1.getName()));
      this.fullName = (new StringBuilder(1 + var5.length() + var6.length())).append(var5).append(".").append(var6).toString();
      Descriptors$FileDescriptor.access$1400(var2).addSymbol(this);
   }

   private void crossLink() {
      Descriptors$GenericDescriptor var1 = Descriptors$FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getInputType(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
      if(!(var1 instanceof Descriptors$Descriptor)) {
         String var4 = String.valueOf(String.valueOf(this.proto.getInputType()));
         throw new Descriptors$DescriptorValidationException(this, (new StringBuilder(25 + var4.length())).append("\"").append(var4).append("\" is not a message type.").toString(), (Descriptors$1)null);
      } else {
         this.inputType = (Descriptors$Descriptor)var1;
         Descriptors$GenericDescriptor var2 = Descriptors$FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getOutputType(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
         if(!(var2 instanceof Descriptors$Descriptor)) {
            String var3 = String.valueOf(String.valueOf(this.proto.getOutputType()));
            throw new Descriptors$DescriptorValidationException(this, (new StringBuilder(25 + var3.length())).append("\"").append(var3).append("\" is not a message type.").toString(), (Descriptors$1)null);
         } else {
            this.outputType = (Descriptors$Descriptor)var2;
         }
      }
   }

   private void setProto(DescriptorProtos$MethodDescriptorProto var1) {
      this.proto = var1;
   }

   // $FF: synthetic method
   Descriptors$MethodDescriptor(DescriptorProtos$MethodDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$ServiceDescriptor var3, int var4, Descriptors$1 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static void access$2800(Descriptors$MethodDescriptor var0) {
      var0.crossLink();
   }

   // $FF: synthetic method
   static void access$2900(Descriptors$MethodDescriptor var0, DescriptorProtos$MethodDescriptorProto var1) {
      var0.setProto(var1);
   }
}
