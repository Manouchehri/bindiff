package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue$1;
import com.google.protobuf.BytesValue$Builder;
import com.google.protobuf.BytesValueOrBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class BytesValue extends GeneratedMessage implements BytesValueOrBuilder {
   public static final int VALUE_FIELD_NUMBER = 1;
   private ByteString value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BytesValue DEFAULT_INSTANCE = new BytesValue();
   public static final Parser PARSER = new BytesValue$1();

   private BytesValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BytesValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.value_ = ByteString.EMPTY;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private BytesValue(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 10:
               this.value_ = var1.readBytes();
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
      return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
   }

   public ByteString getValue() {
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
      if(!this.value_.isEmpty()) {
         var1.writeBytes(1, this.value_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.value_.isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.value_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BytesValue parseFrom(ByteString var0) {
      return (BytesValue)PARSER.parseFrom(var0);
   }

   public static BytesValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BytesValue)PARSER.parseFrom(var0, var1);
   }

   public static BytesValue parseFrom(byte[] var0) {
      return (BytesValue)PARSER.parseFrom(var0);
   }

   public static BytesValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BytesValue)PARSER.parseFrom(var0, var1);
   }

   public static BytesValue parseFrom(InputStream var0) {
      return (BytesValue)PARSER.parseFrom(var0);
   }

   public static BytesValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BytesValue)PARSER.parseFrom(var0, var1);
   }

   public static BytesValue parseDelimitedFrom(InputStream var0) {
      return (BytesValue)PARSER.parseDelimitedFrom(var0);
   }

   public static BytesValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BytesValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BytesValue parseFrom(CodedInputStream var0) {
      return (BytesValue)PARSER.parseFrom(var0);
   }

   public static BytesValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BytesValue)PARSER.parseFrom(var0, var1);
   }

   public BytesValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BytesValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BytesValue$Builder newBuilder(BytesValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BytesValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BytesValue$Builder((BytesValue$1)null):(new BytesValue$Builder((BytesValue$1)null)).mergeFrom(this);
   }

   protected BytesValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BytesValue$Builder var2 = new BytesValue$Builder(var1, (BytesValue$1)null);
      return var2;
   }

   public static BytesValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BytesValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   BytesValue(GeneratedMessage$Builder var1, BytesValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static ByteString access$302(BytesValue var0, ByteString var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   BytesValue(CodedInputStream var1, ExtensionRegistryLite var2, BytesValue$1 var3) {
      this(var1, var2);
   }
}
