package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$MethodDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$ServiceDescriptor extends Descriptors$GenericDescriptor {
   private final int index;
   private DescriptorProtos$ServiceDescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private Descriptors$MethodDescriptor[] methods;

   public int getIndex() {
      return this.index;
   }

   public DescriptorProtos$ServiceDescriptorProto toProto() {
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

   public DescriptorProtos$ServiceOptions getOptions() {
      return this.proto.getOptions();
   }

   public List getMethods() {
      return Collections.unmodifiableList(Arrays.asList(this.methods));
   }

   public Descriptors$MethodDescriptor findMethodByName(String var1) {
      Descriptors$DescriptorPool var10000 = Descriptors$FileDescriptor.access$1400(this.file);
      String var3 = String.valueOf(String.valueOf(this.fullName));
      String var4 = String.valueOf(String.valueOf(var1));
      Descriptors$GenericDescriptor var2 = var10000.findSymbol((new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString());
      return var2 != null && var2 instanceof Descriptors$MethodDescriptor?(Descriptors$MethodDescriptor)var2:null;
   }

   private Descriptors$ServiceDescriptor(DescriptorProtos$ServiceDescriptorProto var1, Descriptors$FileDescriptor var2, int var3) {
      this.index = var3;
      this.proto = var1;
      this.fullName = Descriptors.access$1600(var2, (Descriptors$Descriptor)null, var1.getName());
      this.file = var2;
      this.methods = new Descriptors$MethodDescriptor[var1.getMethodCount()];

      for(int var4 = 0; var4 < var1.getMethodCount(); ++var4) {
         this.methods[var4] = new Descriptors$MethodDescriptor(var1.getMethod(var4), var2, this, var4, (Descriptors$1)null);
      }

      Descriptors$FileDescriptor.access$1400(var2).addSymbol(this);
   }

   private void crossLink() {
      Descriptors$MethodDescriptor[] var1 = this.methods;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Descriptors$MethodDescriptor var4 = var1[var3];
         Descriptors$MethodDescriptor.access$2800(var4);
      }

   }

   private void setProto(DescriptorProtos$ServiceDescriptorProto var1) {
      this.proto = var1;

      for(int var2 = 0; var2 < this.methods.length; ++var2) {
         Descriptors$MethodDescriptor.access$2900(this.methods[var2], var1.getMethod(var2));
      }

   }

   // $FF: synthetic method
   Descriptors$ServiceDescriptor(DescriptorProtos$ServiceDescriptorProto var1, Descriptors$FileDescriptor var2, int var3, Descriptors$1 var4) {
      this(var1, var2, var3);
   }

   // $FF: synthetic method
   static void access$800(Descriptors$ServiceDescriptor var0) {
      var0.crossLink();
   }

   // $FF: synthetic method
   static void access$1200(Descriptors$ServiceDescriptor var0, DescriptorProtos$ServiceDescriptorProto var1) {
      var0.setProto(var1);
   }
}
