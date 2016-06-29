package com.google.protobuf;

import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Message;

final class Descriptors$DescriptorPool$PackageDescriptor extends Descriptors$GenericDescriptor {
   private final String name;
   private final String fullName;
   private final Descriptors$FileDescriptor file;

   public Message toProto() {
      return this.file.toProto();
   }

   public String getName() {
      return this.name;
   }

   public String getFullName() {
      return this.fullName;
   }

   public Descriptors$FileDescriptor getFile() {
      return this.file;
   }

   Descriptors$DescriptorPool$PackageDescriptor(String var1, String var2, Descriptors$FileDescriptor var3) {
      this.file = var3;
      this.fullName = var2;
      this.name = var1;
   }
}
