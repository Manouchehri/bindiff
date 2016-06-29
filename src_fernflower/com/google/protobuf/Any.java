package com.google.protobuf;

import com.google.protobuf.Any$1;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
import com.google.protobuf.ByteString;
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
import java.io.IOException;
import java.io.InputStream;

public final class Any extends GeneratedMessage implements AnyOrBuilder {
   public static final int TYPE_URL_FIELD_NUMBER = 1;
   private volatile Object typeUrl_;
   public static final int VALUE_FIELD_NUMBER = 2;
   private ByteString value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Any DEFAULT_INSTANCE = new Any();
   public static final Parser PARSER = new Any$1();

   private Any(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Any() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.typeUrl_ = "";
      this.value_ = ByteString.EMPTY;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Any(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               ByteString var6 = var1.readBytes();
               this.typeUrl_ = var6;
               break;
            case 18:
               this.value_ = var1.readBytes();
               break;
            default:
               if(!var1.skipField(var5)) {
                  var4 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var12) {
         throw new RuntimeException(var12.setUnfinishedMessage(this));
      } catch (IOException var13) {
         throw new RuntimeException((new InvalidProtocolBufferException(var13.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return AnyProto.internal_static_google_protobuf_Any_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
   }

   public String getTypeUrl() {
      Object var1 = this.typeUrl_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.typeUrl_ = var3;
         }

         return var3;
      }
   }

   public ByteString getTypeUrlBytes() {
      Object var1 = this.typeUrl_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.typeUrl_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
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
      if(!this.getTypeUrlBytes().isEmpty()) {
         var1.writeBytes(1, this.getTypeUrlBytes());
      }

      if(!this.value_.isEmpty()) {
         var1.writeBytes(2, this.value_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.getTypeUrlBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getTypeUrlBytes());
         }

         if(!this.value_.isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(2, this.value_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Any)) {
         return super.equals(var1);
      } else {
         Any var2 = (Any)var1;
         boolean var3 = true;
         var3 = var3 && this.getTypeUrl().equals(var2.getTypeUrl());
         var3 = var3 && this.getValue().equals(var2.getValue());
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
         var2 = 53 * var2 + this.getTypeUrl().hashCode();
         var2 = 37 * var2 + 2;
         var2 = 53 * var2 + this.getValue().hashCode();
         var2 = 29 * var2 + this.unknownFields.hashCode();
         this.memoizedHashCode = var2;
         return var2;
      }
   }

   public static Any parseFrom(ByteString var0) {
      return (Any)PARSER.parseFrom(var0);
   }

   public static Any parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Any)PARSER.parseFrom(var0, var1);
   }

   public static Any parseFrom(byte[] var0) {
      return (Any)PARSER.parseFrom(var0);
   }

   public static Any parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Any)PARSER.parseFrom(var0, var1);
   }

   public static Any parseFrom(InputStream var0) {
      return (Any)PARSER.parseFrom(var0);
   }

   public static Any parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Any)PARSER.parseFrom(var0, var1);
   }

   public static Any parseDelimitedFrom(InputStream var0) {
      return (Any)PARSER.parseDelimitedFrom(var0);
   }

   public static Any parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Any)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Any parseFrom(CodedInputStream var0) {
      return (Any)PARSER.parseFrom(var0);
   }

   public static Any parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Any)PARSER.parseFrom(var0, var1);
   }

   public Any$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Any$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Any$Builder newBuilder(Any var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Any$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Any$Builder((Any$1)null):(new Any$Builder((Any$1)null)).mergeFrom(this);
   }

   protected Any$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Any$Builder var2 = new Any$Builder(var1, (Any$1)null);
      return var2;
   }

   public static Any getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Any getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Any(GeneratedMessage$Builder var1, Any$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Any var0, Object var1) {
      return var0.typeUrl_ = var1;
   }

   // $FF: synthetic method
   static ByteString access$402(Any var0, ByteString var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Any var0) {
      return var0.typeUrl_;
   }

   // $FF: synthetic method
   Any(CodedInputStream var1, ExtensionRegistryLite var2, Any$1 var3) {
      this(var1, var2);
   }
}
