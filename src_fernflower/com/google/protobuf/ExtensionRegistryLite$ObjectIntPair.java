package com.google.protobuf;

final class ExtensionRegistryLite$ObjectIntPair {
   private final Object object;
   private final int number;

   ExtensionRegistryLite$ObjectIntPair(Object var1, int var2) {
      this.object = var1;
      this.number = var2;
   }

   public int hashCode() {
      return System.identityHashCode(this.object) * '\uffff' + this.number;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof ExtensionRegistryLite$ObjectIntPair)) {
         return false;
      } else {
         ExtensionRegistryLite$ObjectIntPair var2 = (ExtensionRegistryLite$ObjectIntPair)var1;
         return this.object == var2.object && this.number == var2.number;
      }
   }
}
