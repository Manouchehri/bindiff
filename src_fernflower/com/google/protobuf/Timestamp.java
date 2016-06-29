package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp$1;
import com.google.protobuf.Timestamp$Builder;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.TimestampProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Timestamp extends GeneratedMessage implements TimestampOrBuilder {
   public static final int SECONDS_FIELD_NUMBER = 1;
   private long seconds_;
   public static final int NANOS_FIELD_NUMBER = 2;
   private int nanos_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Timestamp DEFAULT_INSTANCE = new Timestamp();
   public static final Parser PARSER = new Timestamp$1();

   private Timestamp(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Timestamp() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.seconds_ = 0L;
      this.nanos_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Timestamp(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 8:
               this.seconds_ = var1.readInt64();
               break;
            case 16:
               this.nanos_ = var1.readInt32();
               break;
            default:
               if(!var1.skipField(var5)) {
                  var4 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var11) {
         throw new RuntimeException(var11.setUnfinishedMessage(this));
      } catch (IOException var12) {
         throw new RuntimeException((new InvalidProtocolBufferException(var12.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
   }

   public long getSeconds() {
      return this.seconds_;
   }

   public int getNanos() {
      return this.nanos_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if(this.seconds_ != 0L) {
         var1.writeInt64(1, this.seconds_);
      }

      if(this.nanos_ != 0) {
         var1.writeInt32(2, this.nanos_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.seconds_ != 0L) {
            var1 += CodedOutputStream.computeInt64Size(1, this.seconds_);
         }

         if(this.nanos_ != 0) {
            var1 += CodedOutputStream.computeInt32Size(2, this.nanos_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Timestamp)) {
         return super.equals(var1);
      } else {
         Timestamp var2 = (Timestamp)var1;
         boolean var3 = true;
         var3 = var3 && this.getSeconds() == var2.getSeconds();
         var3 = var3 && this.getNanos() == var2.getNanos();
         return var3;
      }
   }

   public int hashCode() {
      if(this.memoizedHashCode != 0) {
         return this.memoizedHashCode;
      } else {
         byte var1 = 41;
         int var2 = 19 * var1 + this.getDescriptorForType().hashCode();
         var2 = 37 * var2 + 1;
         var2 = 53 * var2 + Internal.hashLong(this.getSeconds());
         var2 = 37 * var2 + 2;
         var2 = 53 * var2 + this.getNanos();
         var2 = 29 * var2 + this.unknownFields.hashCode();
         this.memoizedHashCode = var2;
         return var2;
      }
   }

   public static Timestamp parseFrom(ByteString var0) {
      return (Timestamp)PARSER.parseFrom(var0);
   }

   public static Timestamp parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Timestamp)PARSER.parseFrom(var0, var1);
   }

   public static Timestamp parseFrom(byte[] var0) {
      return (Timestamp)PARSER.parseFrom(var0);
   }

   public static Timestamp parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Timestamp)PARSER.parseFrom(var0, var1);
   }

   public static Timestamp parseFrom(InputStream var0) {
      return (Timestamp)PARSER.parseFrom(var0);
   }

   public static Timestamp parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Timestamp)PARSER.parseFrom(var0, var1);
   }

   public static Timestamp parseDelimitedFrom(InputStream var0) {
      return (Timestamp)PARSER.parseDelimitedFrom(var0);
   }

   public static Timestamp parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Timestamp)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Timestamp parseFrom(CodedInputStream var0) {
      return (Timestamp)PARSER.parseFrom(var0);
   }

   public static Timestamp parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Timestamp)PARSER.parseFrom(var0, var1);
   }

   public Timestamp$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Timestamp$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Timestamp$Builder newBuilder(Timestamp var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Timestamp$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Timestamp$Builder((Timestamp$1)null):(new Timestamp$Builder((Timestamp$1)null)).mergeFrom(this);
   }

   protected Timestamp$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Timestamp$Builder var2 = new Timestamp$Builder(var1, (Timestamp$1)null);
      return var2;
   }

   public static Timestamp getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Timestamp getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Timestamp(GeneratedMessage$Builder var1, Timestamp$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$302(Timestamp var0, long var1) {
      return var0.seconds_ = var1;
   }

   // $FF: synthetic method
   static int access$402(Timestamp var0, int var1) {
      return var0.nanos_ = var1;
   }

   // $FF: synthetic method
   Timestamp(CodedInputStream var1, ExtensionRegistryLite var2, Timestamp$1 var3) {
      this(var1, var2);
   }
}
