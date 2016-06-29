package com.google.protobuf;

import com.google.protobuf.Api$1;
import com.google.protobuf.Api$Builder;
import com.google.protobuf.ApiOrBuilder;
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
import com.google.protobuf.Method;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessage implements ApiOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int METHODS_FIELD_NUMBER = 2;
   private List methods_;
   public static final int OPTIONS_FIELD_NUMBER = 3;
   private List options_;
   public static final int VERSION_FIELD_NUMBER = 4;
   private volatile Object version_;
   public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
   private SourceContext sourceContext_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Api DEFAULT_INSTANCE = new Api();
   public static final Parser PARSER = new Api$1();

   private Api(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Api() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.methods_ = Collections.emptyList();
      this.options_ = Collections.emptyList();
      this.version_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Api(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            ByteString var15;
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 10:
               var15 = var1.readBytes();
               this.name_ = var15;
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.methods_ = new ArrayList();
                  var3 |= 2;
               }

               this.methods_.add(var1.readMessage(Method.PARSER, var2));
               break;
            case 26:
               if((var3 & 4) != 4) {
                  this.options_ = new ArrayList();
                  var3 |= 4;
               }

               this.options_.add(var1.readMessage(Option.PARSER, var2));
               break;
            case 34:
               var15 = var1.readBytes();
               this.version_ = var15;
               break;
            case 42:
               SourceContext$Builder var6 = null;
               if(this.sourceContext_ != null) {
                  var6 = this.sourceContext_.toBuilder();
               }

               this.sourceContext_ = (SourceContext)var1.readMessage(SourceContext.PARSER, var2);
               if(var6 != null) {
                  var6.mergeFrom(this.sourceContext_);
                  this.sourceContext_ = var6.buildPartial();
               }
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
         if((var3 & 2) == 2) {
            this.methods_ = Collections.unmodifiableList(this.methods_);
         }

         if((var3 & 4) == 4) {
            this.options_ = Collections.unmodifiableList(this.options_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return ApiProto.internal_static_google_protobuf_Api_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
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

   public List getMethodsList() {
      return this.methods_;
   }

   public List getMethodsOrBuilderList() {
      return this.methods_;
   }

   public int getMethodsCount() {
      return this.methods_.size();
   }

   public Method getMethods(int var1) {
      return (Method)this.methods_.get(var1);
   }

   public MethodOrBuilder getMethodsOrBuilder(int var1) {
      return (MethodOrBuilder)this.methods_.get(var1);
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

   public String getVersion() {
      Object var1 = this.version_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.version_ = var3;
         }

         return var3;
      }
   }

   public ByteString getVersionBytes() {
      Object var1 = this.version_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.version_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasSourceContext() {
      return this.sourceContext_ != null;
   }

   public SourceContext getSourceContext() {
      return this.sourceContext_ == null?SourceContext.getDefaultInstance():this.sourceContext_;
   }

   public SourceContextOrBuilder getSourceContextOrBuilder() {
      return this.getSourceContext();
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

      int var2;
      for(var2 = 0; var2 < this.methods_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.methods_.get(var2));
      }

      for(var2 = 0; var2 < this.options_.size(); ++var2) {
         var1.writeMessage(3, (MessageLite)this.options_.get(var2));
      }

      if(!this.getVersionBytes().isEmpty()) {
         var1.writeBytes(4, this.getVersionBytes());
      }

      if(this.sourceContext_ != null) {
         var1.writeMessage(5, this.getSourceContext());
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

         int var2;
         for(var2 = 0; var2 < this.methods_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.methods_.get(var2));
         }

         for(var2 = 0; var2 < this.options_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(var2));
         }

         if(!this.getVersionBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(4, this.getVersionBytes());
         }

         if(this.sourceContext_ != null) {
            var1 += CodedOutputStream.computeMessageSize(5, this.getSourceContext());
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Api parseFrom(ByteString var0) {
      return (Api)PARSER.parseFrom(var0);
   }

   public static Api parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Api)PARSER.parseFrom(var0, var1);
   }

   public static Api parseFrom(byte[] var0) {
      return (Api)PARSER.parseFrom(var0);
   }

   public static Api parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Api)PARSER.parseFrom(var0, var1);
   }

   public static Api parseFrom(InputStream var0) {
      return (Api)PARSER.parseFrom(var0);
   }

   public static Api parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Api)PARSER.parseFrom(var0, var1);
   }

   public static Api parseDelimitedFrom(InputStream var0) {
      return (Api)PARSER.parseDelimitedFrom(var0);
   }

   public static Api parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Api)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Api parseFrom(CodedInputStream var0) {
      return (Api)PARSER.parseFrom(var0);
   }

   public static Api parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Api)PARSER.parseFrom(var0, var1);
   }

   public Api$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Api$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Api$Builder newBuilder(Api var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Api$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Api$Builder((Api$1)null):(new Api$Builder((Api$1)null)).mergeFrom(this);
   }

   protected Api$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Api$Builder var2 = new Api$Builder(var1, (Api$1)null);
      return var2;
   }

   public static Api getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Api getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Api(GeneratedMessage$Builder var1, Api$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Api var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static List access$402(Api var0, List var1) {
      return var0.methods_ = var1;
   }

   // $FF: synthetic method
   static List access$502(Api var0, List var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static Object access$602(Api var0, Object var1) {
      return var0.version_ = var1;
   }

   // $FF: synthetic method
   static SourceContext access$702(Api var0, SourceContext var1) {
      return var0.sourceContext_ = var1;
   }

   // $FF: synthetic method
   static int access$802(Api var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Api var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$400(Api var0) {
      return var0.methods_;
   }

   // $FF: synthetic method
   static List access$500(Api var0) {
      return var0.options_;
   }

   // $FF: synthetic method
   static Object access$600(Api var0) {
      return var0.version_;
   }

   // $FF: synthetic method
   Api(CodedInputStream var1, ExtensionRegistryLite var2, Api$1 var3) {
      this(var1, var2);
   }
}
