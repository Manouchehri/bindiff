package com.google.protobuf;

import com.google.protobuf.ApiProto;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Method$1;
import com.google.protobuf.Method$Builder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessage implements MethodOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
   private volatile Object requestTypeUrl_;
   public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
   private boolean requestStreaming_;
   public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
   private volatile Object responseTypeUrl_;
   public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
   private boolean responseStreaming_;
   public static final int OPTIONS_FIELD_NUMBER = 6;
   private List options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Method DEFAULT_INSTANCE = new Method();
   public static final Parser PARSER = new Method$1();

   private Method(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Method() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.requestTypeUrl_ = "";
      this.requestStreaming_ = false;
      this.responseTypeUrl_ = "";
      this.responseStreaming_ = false;
      this.options_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Method(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            ByteString var6;
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 10:
               var6 = var1.readBytes();
               this.name_ = var6;
               break;
            case 18:
               var6 = var1.readBytes();
               this.requestTypeUrl_ = var6;
               break;
            case 24:
               this.requestStreaming_ = var1.readBool();
               break;
            case 34:
               var6 = var1.readBytes();
               this.responseTypeUrl_ = var6;
               break;
            case 40:
               this.responseStreaming_ = var1.readBool();
               break;
            case 50:
               if((var3 & 32) != 32) {
                  this.options_ = new ArrayList();
                  var3 |= 32;
               }

               this.options_.add(var1.readMessage(Option.PARSER, var2));
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
         if((var3 & 32) == 32) {
            this.options_ = Collections.unmodifiableList(this.options_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return ApiProto.internal_static_google_protobuf_Method_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
   }

   public String getName() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      }
   }

   public ByteString getNameBytes() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.name_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public String getRequestTypeUrl() {
      Object var1 = this.requestTypeUrl_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.requestTypeUrl_ = var3;
         }

         return var3;
      }
   }

   public ByteString getRequestTypeUrlBytes() {
      Object var1 = this.requestTypeUrl_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.requestTypeUrl_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean getRequestStreaming() {
      return this.requestStreaming_;
   }

   public String getResponseTypeUrl() {
      Object var1 = this.responseTypeUrl_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.responseTypeUrl_ = var3;
         }

         return var3;
      }
   }

   public ByteString getResponseTypeUrlBytes() {
      Object var1 = this.responseTypeUrl_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.responseTypeUrl_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean getResponseStreaming() {
      return this.responseStreaming_;
   }

   public List getOptionsList() {
      return this.options_;
   }

   public List getOptionsOrBuilderList() {
      return this.options_;
   }

   public int getOptionsCount() {
      return this.options_.size();
   }

   public Option getOptions(int var1) {
      return (Option)this.options_.get(var1);
   }

   public OptionOrBuilder getOptionsOrBuilder(int var1) {
      return (OptionOrBuilder)this.options_.get(var1);
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
      if(!this.getNameBytes().isEmpty()) {
         var1.writeBytes(1, this.getNameBytes());
      }

      if(!this.getRequestTypeUrlBytes().isEmpty()) {
         var1.writeBytes(2, this.getRequestTypeUrlBytes());
      }

      if(this.requestStreaming_) {
         var1.writeBool(3, this.requestStreaming_);
      }

      if(!this.getResponseTypeUrlBytes().isEmpty()) {
         var1.writeBytes(4, this.getResponseTypeUrlBytes());
      }

      if(this.responseStreaming_) {
         var1.writeBool(5, this.responseStreaming_);
      }

      for(int var2 = 0; var2 < this.options_.size(); ++var2) {
         var1.writeMessage(6, (MessageLite)this.options_.get(var2));
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.getNameBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
         }

         if(!this.getRequestTypeUrlBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(2, this.getRequestTypeUrlBytes());
         }

         if(this.requestStreaming_) {
            var1 += CodedOutputStream.computeBoolSize(3, this.requestStreaming_);
         }

         if(!this.getResponseTypeUrlBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(4, this.getResponseTypeUrlBytes());
         }

         if(this.responseStreaming_) {
            var1 += CodedOutputStream.computeBoolSize(5, this.responseStreaming_);
         }

         for(int var2 = 0; var2 < this.options_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.options_.get(var2));
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Method parseFrom(ByteString var0) {
      return (Method)PARSER.parseFrom(var0);
   }

   public static Method parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Method)PARSER.parseFrom(var0, var1);
   }

   public static Method parseFrom(byte[] var0) {
      return (Method)PARSER.parseFrom(var0);
   }

   public static Method parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Method)PARSER.parseFrom(var0, var1);
   }

   public static Method parseFrom(InputStream var0) {
      return (Method)PARSER.parseFrom(var0);
   }

   public static Method parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Method)PARSER.parseFrom(var0, var1);
   }

   public static Method parseDelimitedFrom(InputStream var0) {
      return (Method)PARSER.parseDelimitedFrom(var0);
   }

   public static Method parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Method)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Method parseFrom(CodedInputStream var0) {
      return (Method)PARSER.parseFrom(var0);
   }

   public static Method parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Method)PARSER.parseFrom(var0, var1);
   }

   public Method$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Method$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Method$Builder newBuilder(Method var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Method$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Method$Builder((Method$1)null):(new Method$Builder((Method$1)null)).mergeFrom(this);
   }

   protected Method$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Method$Builder var2 = new Method$Builder(var1, (Method$1)null);
      return var2;
   }

   public static Method getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Method getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Method(GeneratedMessage$Builder var1, Method$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Method var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static Object access$402(Method var0, Object var1) {
      return var0.requestTypeUrl_ = var1;
   }

   // $FF: synthetic method
   static boolean access$502(Method var0, boolean var1) {
      return var0.requestStreaming_ = var1;
   }

   // $FF: synthetic method
   static Object access$602(Method var0, Object var1) {
      return var0.responseTypeUrl_ = var1;
   }

   // $FF: synthetic method
   static boolean access$702(Method var0, boolean var1) {
      return var0.responseStreaming_ = var1;
   }

   // $FF: synthetic method
   static List access$802(Method var0, List var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$902(Method var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Method var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static Object access$400(Method var0) {
      return var0.requestTypeUrl_;
   }

   // $FF: synthetic method
   static Object access$600(Method var0) {
      return var0.responseTypeUrl_;
   }

   // $FF: synthetic method
   static List access$800(Method var0) {
      return var0.options_;
   }

   // $FF: synthetic method
   Method(CodedInputStream var1, ExtensionRegistryLite var2, Method$1 var3) {
      this(var1, var2);
   }
}
