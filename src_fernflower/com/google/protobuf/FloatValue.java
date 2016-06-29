package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue$1;
import com.google.protobuf.FloatValue$Builder;
import com.google.protobuf.FloatValueOrBuilder;
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

public final class FloatValue extends GeneratedMessage implements FloatValueOrBuilder {
   public static final int VALUE_FIELD_NUMBER = 1;
   private float value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final FloatValue DEFAULT_INSTANCE = new FloatValue();
   public static final Parser PARSER = new FloatValue$1();

   private FloatValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private FloatValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.value_ = 0.0F;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private FloatValue(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 13:
               this.value_ = var1.readFloat();
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
      return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
   }

   public float getValue() {
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
      if(this.value_ != 0.0F) {
         var1.writeFloat(1, this.value_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.value_ != 0.0F) {
            var1 += CodedOutputStream.computeFloatSize(1, this.value_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static FloatValue parseFrom(ByteString var0) {
      return (FloatValue)PARSER.parseFrom(var0);
   }

   public static FloatValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (FloatValue)PARSER.parseFrom(var0, var1);
   }

   public static FloatValue parseFrom(byte[] var0) {
      return (FloatValue)PARSER.parseFrom(var0);
   }

   public static FloatValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (FloatValue)PARSER.parseFrom(var0, var1);
   }

   public static FloatValue parseFrom(InputStream var0) {
      return (FloatValue)PARSER.parseFrom(var0);
   }

   public static FloatValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (FloatValue)PARSER.parseFrom(var0, var1);
   }

   public static FloatValue parseDelimitedFrom(InputStream var0) {
      return (FloatValue)PARSER.parseDelimitedFrom(var0);
   }

   public static FloatValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (FloatValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static FloatValue parseFrom(CodedInputStream var0) {
      return (FloatValue)PARSER.parseFrom(var0);
   }

   public static FloatValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (FloatValue)PARSER.parseFrom(var0, var1);
   }

   public FloatValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static FloatValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static FloatValue$Builder newBuilder(FloatValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public FloatValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new FloatValue$Builder((FloatValue$1)null):(new FloatValue$Builder((FloatValue$1)null)).mergeFrom(this);
   }

   protected FloatValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      FloatValue$Builder var2 = new FloatValue$Builder(var1, (FloatValue$1)null);
      return var2;
   }

   public static FloatValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public FloatValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   FloatValue(GeneratedMessage$Builder var1, FloatValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static float access$302(FloatValue var0, float var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   FloatValue(CodedInputStream var1, ExtensionRegistryLite var2, FloatValue$1 var3) {
      this(var1, var2);
   }
}
