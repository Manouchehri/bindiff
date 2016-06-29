package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;

public class LazyField extends LazyFieldLite {
   private final MessageLite defaultInstance;

   public LazyField(MessageLite var1, ExtensionRegistryLite var2, ByteString var3) {
      super(var2, var3);
      this.defaultInstance = var1;
   }

   public boolean containsDefaultInstance() {
      return super.containsDefaultInstance() || this.value == this.defaultInstance;
   }

   public MessageLite getValue() {
      return this.getValue(this.defaultInstance);
   }

   public int hashCode() {
      return this.getValue().hashCode();
   }

   public boolean equals(Object var1) {
      return this.getValue().equals(var1);
   }

   public String toString() {
      return this.getValue().toString();
   }
}
