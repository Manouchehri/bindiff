package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.UnknownFieldSetLite$1;
import com.google.protobuf.UnknownFieldSetLite$Builder;

public final class UnknownFieldSetLite {
   private static final UnknownFieldSetLite DEFAULT_INSTANCE;
   private final ByteString byteString;

   public static UnknownFieldSetLite getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static UnknownFieldSetLite$Builder newBuilder() {
      return new UnknownFieldSetLite$Builder((UnknownFieldSetLite$1)null);
   }

   static UnknownFieldSetLite concat(UnknownFieldSetLite var0, UnknownFieldSetLite var1) {
      return new UnknownFieldSetLite(var0.byteString.concat(var1.byteString));
   }

   private UnknownFieldSetLite(ByteString var1) {
      this.byteString = var1;
   }

   public void writeTo(CodedOutputStream var1) {
      var1.writeRawBytes(this.byteString);
   }

   public int getSerializedSize() {
      return this.byteString.size();
   }

   public boolean equals(Object var1) {
      return this == var1?true:(var1 instanceof UnknownFieldSetLite?this.byteString.equals(((UnknownFieldSetLite)var1).byteString):false);
   }

   public int hashCode() {
      return this.byteString.hashCode();
   }

   // $FF: synthetic method
   UnknownFieldSetLite(ByteString var1, UnknownFieldSetLite$1 var2) {
      this(var1);
   }

   static {
      DEFAULT_INSTANCE = new UnknownFieldSetLite(ByteString.EMPTY);
   }
}
