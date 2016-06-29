package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.DoubleValue$1;
import com.google.protobuf.DoubleValue$Builder;
import com.google.protobuf.DoubleValueOrBuilder;
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

public final class DoubleValue extends GeneratedMessage implements DoubleValueOrBuilder {
   public static final int VALUE_FIELD_NUMBER = 1;
   private double value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DoubleValue DEFAULT_INSTANCE = new DoubleValue();
   public static final Parser PARSER = new DoubleValue$1();

   private DoubleValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DoubleValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.value_ = 0.0D;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private DoubleValue(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 9:
               this.value_ = var1.readDouble();
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
      return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
   }

   public double getValue() {
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
      if(this.value_ != 0.0D) {
         var1.writeDouble(1, this.value_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.value_ != 0.0D) {
            var1 += CodedOutputStream.computeDoubleSize(1, this.value_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DoubleValue parseFrom(ByteString var0) {
      return (DoubleValue)PARSER.parseFrom(var0);
   }

   public static DoubleValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DoubleValue)PARSER.parseFrom(var0, var1);
   }

   public static DoubleValue parseFrom(byte[] var0) {
      return (DoubleValue)PARSER.parseFrom(var0);
   }

   public static DoubleValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DoubleValue)PARSER.parseFrom(var0, var1);
   }

   public static DoubleValue parseFrom(InputStream var0) {
      return (DoubleValue)PARSER.parseFrom(var0);
   }

   public static DoubleValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DoubleValue)PARSER.parseFrom(var0, var1);
   }

   public static DoubleValue parseDelimitedFrom(InputStream var0) {
      return (DoubleValue)PARSER.parseDelimitedFrom(var0);
   }

   public static DoubleValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DoubleValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DoubleValue parseFrom(CodedInputStream var0) {
      return (DoubleValue)PARSER.parseFrom(var0);
   }

   public static DoubleValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DoubleValue)PARSER.parseFrom(var0, var1);
   }

   public DoubleValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DoubleValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DoubleValue$Builder newBuilder(DoubleValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DoubleValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DoubleValue$Builder((DoubleValue$1)null):(new DoubleValue$Builder((DoubleValue$1)null)).mergeFrom(this);
   }

   protected DoubleValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DoubleValue$Builder var2 = new DoubleValue$Builder(var1, (DoubleValue$1)null);
      return var2;
   }

   public static DoubleValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DoubleValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DoubleValue(GeneratedMessage$Builder var1, DoubleValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static double access$302(DoubleValue var0, double var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   DoubleValue(CodedInputStream var1, ExtensionRegistryLite var2, DoubleValue$1 var3) {
      this(var1, var2);
   }
}
