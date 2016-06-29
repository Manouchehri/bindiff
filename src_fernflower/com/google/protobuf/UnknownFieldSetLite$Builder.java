package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$Output;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.UnknownFieldSetLite$1;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.OutputStream;

public final class UnknownFieldSetLite$Builder {
   private ByteString$Output byteStringOutput;
   private CodedOutputStream output;
   private boolean built;

   private UnknownFieldSetLite$Builder() {
   }

   private void ensureInitializedButNotBuilt() {
      if(this.built) {
         throw new IllegalStateException("Do not reuse UnknownFieldSetLite Builders.");
      } else {
         if(this.output == null && this.byteStringOutput == null) {
            this.byteStringOutput = ByteString.newOutput(100);
            this.output = CodedOutputStream.newInstance((OutputStream)this.byteStringOutput);
         }

      }
   }

   public boolean mergeFieldFrom(int var1, CodedInputStream var2) {
      this.ensureInitializedButNotBuilt();
      int var3 = WireFormat.getTagFieldNumber(var1);
      switch(WireFormat.getTagWireType(var1)) {
      case 0:
         this.output.writeUInt64(var3, var2.readInt64());
         return true;
      case 1:
         this.output.writeFixed64(var3, var2.readFixed64());
         return true;
      case 2:
         this.output.writeBytes(var3, var2.readBytes());
         return true;
      case 3:
         UnknownFieldSetLite$Builder var4 = UnknownFieldSetLite.newBuilder();
         var4.mergeFrom(var2);
         var2.checkLastTagWas(WireFormat.makeTag(var3, 4));
         this.output.writeTag(var3, 3);
         var4.build().writeTo(this.output);
         this.output.writeTag(var3, 4);
         return true;
      case 4:
         return false;
      case 5:
         this.output.writeFixed32(var3, var2.readFixed32());
         return true;
      default:
         throw InvalidProtocolBufferException.invalidWireType();
      }
   }

   public UnknownFieldSetLite$Builder mergeVarintField(int var1, int var2) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         this.ensureInitializedButNotBuilt();

         try {
            this.output.writeUInt64(var1, (long)var2);
         } catch (IOException var4) {
            ;
         }

         return this;
      }
   }

   public UnknownFieldSetLite$Builder mergeLengthDelimitedField(int var1, ByteString var2) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Zero is not a valid field number.");
      } else {
         this.ensureInitializedButNotBuilt();

         try {
            this.output.writeBytes(var1, var2);
         } catch (IOException var4) {
            ;
         }

         return this;
      }
   }

   public UnknownFieldSetLite build() {
      if(this.built) {
         throw new IllegalStateException("Do not reuse UnknownFieldSetLite Builders.");
      } else {
         this.built = true;
         UnknownFieldSetLite var1;
         if(this.output == null) {
            var1 = UnknownFieldSetLite.getDefaultInstance();
         } else {
            try {
               this.output.flush();
            } catch (IOException var3) {
               ;
            }

            ByteString var2 = this.byteStringOutput.toByteString();
            if(var2.isEmpty()) {
               var1 = UnknownFieldSetLite.getDefaultInstance();
            } else {
               var1 = new UnknownFieldSetLite(var2, (UnknownFieldSetLite$1)null);
            }
         }

         this.output = null;
         this.byteStringOutput = null;
         return var1;
      }
   }

   private UnknownFieldSetLite$Builder mergeFrom(CodedInputStream var1) {
      int var2;
      do {
         var2 = var1.readTag();
      } while(var2 != 0 && this.mergeFieldFrom(var2, var1));

      return this;
   }

   // $FF: synthetic method
   UnknownFieldSetLite$Builder(UnknownFieldSetLite$1 var1) {
      this();
   }
}
