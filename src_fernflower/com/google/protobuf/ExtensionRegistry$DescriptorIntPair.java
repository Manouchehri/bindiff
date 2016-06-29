package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;

final class ExtensionRegistry$DescriptorIntPair {
   private final Descriptors$Descriptor descriptor;
   private final int number;

   ExtensionRegistry$DescriptorIntPair(Descriptors$Descriptor var1, int var2) {
      this.descriptor = var1;
      this.number = var2;
   }

   public int hashCode() {
      return this.descriptor.hashCode() * '\uffff' + this.number;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof ExtensionRegistry$DescriptorIntPair)) {
         return false;
      } else {
         ExtensionRegistry$DescriptorIntPair var2 = (ExtensionRegistry$DescriptorIntPair)var1;
         return this.descriptor == var2.descriptor && this.number == var2.number;
      }
   }

   // $FF: synthetic method
   static Descriptors$Descriptor access$000(ExtensionRegistry$DescriptorIntPair var0) {
      return var0.descriptor;
   }
}
