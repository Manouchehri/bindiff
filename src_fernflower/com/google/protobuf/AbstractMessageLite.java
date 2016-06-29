package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public abstract class AbstractMessageLite implements MessageLite {
   protected int memoizedHashCode = 0;

   public ByteString toByteString() {
      try {
         ByteString$CodedBuilder var1 = ByteString.newCodedBuilder(this.getSerializedSize());
         this.writeTo(var1.getCodedOutput());
         return var1.build();
      } catch (IOException var2) {
         throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", var2);
      }
   }

   public byte[] toByteArray() {
      try {
         byte[] var1 = new byte[this.getSerializedSize()];
         CodedOutputStream var2 = CodedOutputStream.newInstance(var1);
         this.writeTo(var2);
         var2.checkNoSpaceLeft();
         return var1;
      } catch (IOException var3) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var3);
      }
   }

   public void writeTo(OutputStream var1) {
      int var2 = CodedOutputStream.computePreferredBufferSize(this.getSerializedSize());
      CodedOutputStream var3 = CodedOutputStream.newInstance(var1, var2);
      this.writeTo(var3);
      var3.flush();
   }

   public void writeDelimitedTo(OutputStream var1) {
      int var2 = this.getSerializedSize();
      int var3 = CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(var2) + var2);
      CodedOutputStream var4 = CodedOutputStream.newInstance(var1, var3);
      var4.writeRawVarint32(var2);
      this.writeTo(var4);
      var4.flush();
   }

   UninitializedMessageException newUninitializedMessageException() {
      return new UninitializedMessageException(this);
   }

   protected static void checkByteStringIsUtf8(ByteString var0) {
      if(!var0.isValidUtf8()) {
         throw new IllegalArgumentException("Byte string is not UTF-8.");
      }
   }

   protected static void addAll(Iterable var0, Collection var1) {
      AbstractMessageLite$Builder.addAll(var0, var1);
   }
}
