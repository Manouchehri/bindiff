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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.StringValue$1;
import com.google.protobuf.StringValue$Builder;
import com.google.protobuf.StringValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class StringValue extends GeneratedMessage implements StringValueOrBuilder {
   public static final int VALUE_FIELD_NUMBER = 1;
   private volatile Object value_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final StringValue DEFAULT_INSTANCE = new StringValue();
   public static final Parser PARSER = new StringValue$1();

   private StringValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private StringValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.value_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private StringValue(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.value_ = var6;
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
      return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
   }

   public String getValue() {
      Object var1 = this.value_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.value_ = var3;
         }

         return var3;
      }
   }

   public ByteString getValueBytes() {
      Object var1 = this.value_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.value_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
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
      if(!this.getValueBytes().isEmpty()) {
         var1.writeBytes(1, this.getValueBytes());
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.getValueBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getValueBytes());
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static StringValue parseFrom(ByteString var0) {
      return (StringValue)PARSER.parseFrom(var0);
   }

   public static StringValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (StringValue)PARSER.parseFrom(var0, var1);
   }

   public static StringValue parseFrom(byte[] var0) {
      return (StringValue)PARSER.parseFrom(var0);
   }

   public static StringValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (StringValue)PARSER.parseFrom(var0, var1);
   }

   public static StringValue parseFrom(InputStream var0) {
      return (StringValue)PARSER.parseFrom(var0);
   }

   public static StringValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (StringValue)PARSER.parseFrom(var0, var1);
   }

   public static StringValue parseDelimitedFrom(InputStream var0) {
      return (StringValue)PARSER.parseDelimitedFrom(var0);
   }

   public static StringValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (StringValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static StringValue parseFrom(CodedInputStream var0) {
      return (StringValue)PARSER.parseFrom(var0);
   }

   public static StringValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (StringValue)PARSER.parseFrom(var0, var1);
   }

   public StringValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static StringValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static StringValue$Builder newBuilder(StringValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public StringValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new StringValue$Builder((StringValue$1)null):(new StringValue$Builder((StringValue$1)null)).mergeFrom(this);
   }

   protected StringValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      StringValue$Builder var2 = new StringValue$Builder(var1, (StringValue$1)null);
      return var2;
   }

   public static StringValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public StringValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   StringValue(GeneratedMessage$Builder var1, StringValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(StringValue var0, Object var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(StringValue var0) {
      return var0.value_;
   }

   // $FF: synthetic method
   StringValue(CodedInputStream var1, ExtensionRegistryLite var2, StringValue$1 var3) {
      this(var1, var2);
   }
}
