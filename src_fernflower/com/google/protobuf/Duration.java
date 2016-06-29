package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Duration$1;
import com.google.protobuf.Duration$Builder;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Duration extends GeneratedMessage implements DurationOrBuilder {
   public static final int SECONDS_FIELD_NUMBER = 1;
   private long seconds_;
   public static final int NANOS_FIELD_NUMBER = 2;
   private int nanos_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Duration DEFAULT_INSTANCE = new Duration();
   public static final Parser PARSER = new Duration$1();

   private Duration(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Duration() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.seconds_ = 0L;
      this.nanos_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Duration(CodedInputStream var1, ExtensionRegistryLite var2) {
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
      return DurationProto.internal_static_google_protobuf_Duration_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
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
      } else if(!(var1 instanceof Duration)) {
         return super.equals(var1);
      } else {
         Duration var2 = (Duration)var1;
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

   public static Duration parseFrom(ByteString var0) {
      return (Duration)PARSER.parseFrom(var0);
   }

   public static Duration parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Duration)PARSER.parseFrom(var0, var1);
   }

   public static Duration parseFrom(byte[] var0) {
      return (Duration)PARSER.parseFrom(var0);
   }

   public static Duration parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Duration)PARSER.parseFrom(var0, var1);
   }

   public static Duration parseFrom(InputStream var0) {
      return (Duration)PARSER.parseFrom(var0);
   }

   public static Duration parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Duration)PARSER.parseFrom(var0, var1);
   }

   public static Duration parseDelimitedFrom(InputStream var0) {
      return (Duration)PARSER.parseDelimitedFrom(var0);
   }

   public static Duration parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Duration)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Duration parseFrom(CodedInputStream var0) {
      return (Duration)PARSER.parseFrom(var0);
   }

   public static Duration parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Duration)PARSER.parseFrom(var0, var1);
   }

   public Duration$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Duration$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Duration$Builder newBuilder(Duration var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Duration$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Duration$Builder((Duration$1)null):(new Duration$Builder((Duration$1)null)).mergeFrom(this);
   }

   protected Duration$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Duration$Builder var2 = new Duration$Builder(var1, (Duration$1)null);
      return var2;
   }

   public static Duration getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Duration getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Duration(GeneratedMessage$Builder var1, Duration$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$302(Duration var0, long var1) {
      return var0.seconds_ = var1;
   }

   // $FF: synthetic method
   static int access$402(Duration var0, int var1) {
      return var0.nanos_ = var1;
   }

   // $FF: synthetic method
   Duration(CodedInputStream var1, ExtensionRegistryLite var2, Duration$1 var3) {
      this(var1, var2);
   }
}
