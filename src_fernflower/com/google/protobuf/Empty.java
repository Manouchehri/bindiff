package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Empty$1;
import com.google.protobuf.Empty$Builder;
import com.google.protobuf.EmptyOrBuilder;
import com.google.protobuf.EmptyProto;
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

public final class Empty extends GeneratedMessage implements EmptyOrBuilder {
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Empty DEFAULT_INSTANCE = new Empty();
   public static final Parser PARSER = new Empty$1();

   private Empty(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Empty() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Empty(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();

      try {
         boolean var3 = false;

         while(!var3) {
            int var4 = var1.readTag();
            switch(var4) {
            case 0:
               var3 = true;
               break;
            default:
               if(!var1.skipField(var4)) {
                  var3 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var10) {
         throw new RuntimeException(var10.setUnfinishedMessage(this));
      } catch (IOException var11) {
         throw new RuntimeException((new InvalidProtocolBufferException(var11.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
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
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         byte var2 = 0;
         this.memoizedSerializedSize = var2;
         return var2;
      }
   }

   public static Empty parseFrom(ByteString var0) {
      return (Empty)PARSER.parseFrom(var0);
   }

   public static Empty parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Empty)PARSER.parseFrom(var0, var1);
   }

   public static Empty parseFrom(byte[] var0) {
      return (Empty)PARSER.parseFrom(var0);
   }

   public static Empty parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Empty)PARSER.parseFrom(var0, var1);
   }

   public static Empty parseFrom(InputStream var0) {
      return (Empty)PARSER.parseFrom(var0);
   }

   public static Empty parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Empty)PARSER.parseFrom(var0, var1);
   }

   public static Empty parseDelimitedFrom(InputStream var0) {
      return (Empty)PARSER.parseDelimitedFrom(var0);
   }

   public static Empty parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Empty)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Empty parseFrom(CodedInputStream var0) {
      return (Empty)PARSER.parseFrom(var0);
   }

   public static Empty parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Empty)PARSER.parseFrom(var0, var1);
   }

   public Empty$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Empty$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Empty$Builder newBuilder(Empty var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Empty$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Empty$Builder((Empty$1)null):(new Empty$Builder((Empty$1)null)).mergeFrom(this);
   }

   protected Empty$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Empty$Builder var2 = new Empty$Builder(var1, (Empty$1)null);
      return var2;
   }

   public static Empty getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Empty getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Empty(GeneratedMessage$Builder var1, Empty$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   Empty(CodedInputStream var1, ExtensionRegistryLite var2, Empty$1 var3) {
      this(var1, var2);
   }
}
