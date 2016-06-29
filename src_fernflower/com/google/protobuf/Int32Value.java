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
import com.google.protobuf.Int32Value$1;
import com.google.protobuf.Int32Value$Builder;
import com.google.protobuf.Int32ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class Int32Value extends GeneratedMessage implements Int32ValueOrBuilder {
   public static final int VALUE_FIELD_NUMBER = 1;
   private int value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Int32Value DEFAULT_INSTANCE = new Int32Value();
   public static final Parser PARSER = new Int32Value$1();

   private Int32Value(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Int32Value() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.value_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Int32Value(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.value_ = var1.readInt32();
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
      return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
   }

   public int getValue() {
      return this.value_;
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
      if(this.value_ != 0) {
         var1.writeInt32(1, this.value_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.value_ != 0) {
            var1 += CodedOutputStream.computeInt32Size(1, this.value_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Int32Value parseFrom(ByteString var0) {
      return (Int32Value)PARSER.parseFrom(var0);
   }

   public static Int32Value parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Int32Value)PARSER.parseFrom(var0, var1);
   }

   public static Int32Value parseFrom(byte[] var0) {
      return (Int32Value)PARSER.parseFrom(var0);
   }

   public static Int32Value parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Int32Value)PARSER.parseFrom(var0, var1);
   }

   public static Int32Value parseFrom(InputStream var0) {
      return (Int32Value)PARSER.parseFrom(var0);
   }

   public static Int32Value parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Int32Value)PARSER.parseFrom(var0, var1);
   }

   public static Int32Value parseDelimitedFrom(InputStream var0) {
      return (Int32Value)PARSER.parseDelimitedFrom(var0);
   }

   public static Int32Value parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Int32Value)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Int32Value parseFrom(CodedInputStream var0) {
      return (Int32Value)PARSER.parseFrom(var0);
   }

   public static Int32Value parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Int32Value)PARSER.parseFrom(var0, var1);
   }

   public Int32Value$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Int32Value$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Int32Value$Builder newBuilder(Int32Value var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Int32Value$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Int32Value$Builder((Int32Value$1)null):(new Int32Value$Builder((Int32Value$1)null)).mergeFrom(this);
   }

   protected Int32Value$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Int32Value$Builder var2 = new Int32Value$Builder(var1, (Int32Value$1)null);
      return var2;
   }

   public static Int32Value getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Int32Value getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Int32Value(GeneratedMessage$Builder var1, Int32Value$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int access$302(Int32Value var0, int var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   Int32Value(CodedInputStream var1, ExtensionRegistryLite var2, Int32Value$1 var3) {
      this(var1, var2);
   }
}
