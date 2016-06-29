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
import com.google.protobuf.SourceContext$1;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class SourceContext extends GeneratedMessage implements SourceContextOrBuilder {
   public static final int FILE_NAME_FIELD_NUMBER = 1;
   private volatile Object fileName_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final SourceContext DEFAULT_INSTANCE = new SourceContext();
   public static final Parser PARSER = new SourceContext$1();

   private SourceContext(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private SourceContext() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.fileName_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private SourceContext(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.fileName_ = var6;
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
      return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
   }

   public String getFileName() {
      Object var1 = this.fileName_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.fileName_ = var3;
         }

         return var3;
      }
   }

   public ByteString getFileNameBytes() {
      Object var1 = this.fileName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.fileName_ = var2;
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
      if(!this.getFileNameBytes().isEmpty()) {
         var1.writeBytes(1, this.getFileNameBytes());
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.getFileNameBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getFileNameBytes());
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static SourceContext parseFrom(ByteString var0) {
      return (SourceContext)PARSER.parseFrom(var0);
   }

   public static SourceContext parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (SourceContext)PARSER.parseFrom(var0, var1);
   }

   public static SourceContext parseFrom(byte[] var0) {
      return (SourceContext)PARSER.parseFrom(var0);
   }

   public static SourceContext parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (SourceContext)PARSER.parseFrom(var0, var1);
   }

   public static SourceContext parseFrom(InputStream var0) {
      return (SourceContext)PARSER.parseFrom(var0);
   }

   public static SourceContext parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (SourceContext)PARSER.parseFrom(var0, var1);
   }

   public static SourceContext parseDelimitedFrom(InputStream var0) {
      return (SourceContext)PARSER.parseDelimitedFrom(var0);
   }

   public static SourceContext parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (SourceContext)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static SourceContext parseFrom(CodedInputStream var0) {
      return (SourceContext)PARSER.parseFrom(var0);
   }

   public static SourceContext parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (SourceContext)PARSER.parseFrom(var0, var1);
   }

   public SourceContext$Builder newBuilderForType() {
      return newBuilder();
   }

   public static SourceContext$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static SourceContext$Builder newBuilder(SourceContext var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public SourceContext$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new SourceContext$Builder((SourceContext$1)null):(new SourceContext$Builder((SourceContext$1)null)).mergeFrom(this);
   }

   protected SourceContext$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      SourceContext$Builder var2 = new SourceContext$Builder(var1, (SourceContext$1)null);
      return var2;
   }

   public static SourceContext getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public SourceContext getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   SourceContext(GeneratedMessage$Builder var1, SourceContext$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(SourceContext var0, Object var1) {
      return var0.fileName_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(SourceContext var0) {
      return var0.fileName_;
   }

   // $FF: synthetic method
   SourceContext(CodedInputStream var1, ExtensionRegistryLite var2, SourceContext$1 var3) {
      this(var1, var2);
   }
}
