package com.google.protobuf;

import com.google.protobuf.Descriptors$GenericDescriptor;

final class Descriptors$DescriptorPool$DescriptorIntPair {
   private final Descriptors$GenericDescriptor descriptor;
   private final int number;

   Descriptors$DescriptorPool$DescriptorIntPair(Descriptors$GenericDescriptor var1, int var2) {
      this.descriptor = var1;
      this.number = var2;
   }

   public int hashCode() {
      return this.descriptor.hashCode() * '\uffff' + this.number;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Descriptors$DescriptorPool$DescriptorIntPair)) {
         return false;
      } else {
         Descriptors$DescriptorPool$DescriptorIntPair var2 = (Descriptors$DescriptorPool$DescriptorIntPair)var1;
         return this.descriptor == var2.descriptor && this.number == var2.number;
      }
   }
}
