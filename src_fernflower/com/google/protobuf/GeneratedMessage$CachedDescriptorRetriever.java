package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;

abstract class GeneratedMessage$CachedDescriptorRetriever implements GeneratedMessage$ExtensionDescriptorRetriever {
   private volatile Descriptors$FieldDescriptor descriptor;

   private GeneratedMessage$CachedDescriptorRetriever() {
   }

   protected abstract Descriptors$FieldDescriptor loadDescriptor();

   public Descriptors$FieldDescriptor getDescriptor() {
      if(this.descriptor == null) {
         synchronized(this) {
            if(this.descriptor == null) {
               this.descriptor = this.loadDescriptor();
            }
         }
      }

      return this.descriptor;
   }

   // $FF: synthetic method
   GeneratedMessage$CachedDescriptorRetriever(GeneratedMessage$1 var1) {
      this();
   }
}
