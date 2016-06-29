package com.google.protobuf;

import com.google.protobuf.BoolValue$1;
import com.google.protobuf.BoolValue$Builder;
import com.google.protobuf.BoolValueOrBuilder;
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
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class BoolValue extends GeneratedMessage implements BoolValueOrBuilder {
   public static final int VALUE_FIELD_NUMBER = 1;
   private boolean value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BoolValue DEFAULT_INSTANCE = new BoolValue();
   public static final Parser PARSER = new BoolValue$1();

   private BoolValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BoolValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.value_ = false;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private BoolValue(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.value_ = var1.readBool();
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
      return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
   }

   public boolean getValue() {
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
      if(this.value_) {
         var1.writeBool(1, this.value_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.value_) {
            var1 += CodedOutputStream.computeBoolSize(1, this.value_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BoolValue parseFrom(ByteString var0) {
      return (BoolValue)PARSER.parseFrom(var0);
   }

   public static BoolValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BoolValue)PARSER.parseFrom(var0, var1);
   }

   public static BoolValue parseFrom(byte[] var0) {
      return (BoolValue)PARSER.parseFrom(var0);
   }

   public static BoolValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BoolValue)PARSER.parseFrom(var0, var1);
   }

   public static BoolValue parseFrom(InputStream var0) {
      return (BoolValue)PARSER.parseFrom(var0);
   }

   public static BoolValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BoolValue)PARSER.parseFrom(var0, var1);
   }

   public static BoolValue parseDelimitedFrom(InputStream var0) {
      return (BoolValue)PARSER.parseDelimitedFrom(var0);
   }

   public static BoolValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BoolValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BoolValue parseFrom(CodedInputStream var0) {
      return (BoolValue)PARSER.parseFrom(var0);
   }

   public static BoolValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BoolValue)PARSER.parseFrom(var0, var1);
   }

   public BoolValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BoolValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BoolValue$Builder newBuilder(BoolValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BoolValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BoolValue$Builder((BoolValue$1)null):(new BoolValue$Builder((BoolValue$1)null)).mergeFrom(this);
   }

   protected BoolValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BoolValue$Builder var2 = new BoolValue$Builder(var1, (BoolValue$1)null);
      return var2;
   }

   public static BoolValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BoolValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   BoolValue(GeneratedMessage$Builder var1, BoolValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static boolean access$302(BoolValue var0, boolean var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   BoolValue(CodedInputStream var1, ExtensionRegistryLite var2, BoolValue$1 var3) {
      this(var1, var2);
   }
}
