package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;

public final class DescriptorProtos$MethodDescriptorProto extends GeneratedMessage implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int INPUT_TYPE_FIELD_NUMBER = 2;
   private volatile Object inputType_;
   public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
   private volatile Object outputType_;
   public static final int OPTIONS_FIELD_NUMBER = 4;
   private DescriptorProtos$MethodOptions options_;
   public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
   private boolean clientStreaming_;
   public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
   private boolean serverStreaming_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$MethodDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$MethodDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$MethodDescriptorProto$1();

   private DescriptorProtos$MethodDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$MethodDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.inputType_ = "";
      this.outputType_ = "";
      this.clientStreaming_ = false;
      this.serverStreaming_ = false;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$MethodDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            ByteString var16;
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               var16 = var1.readBytes();
               this.bitField0_ |= 1;
               this.name_ = var16;
               break;
            case 18:
               var16 = var1.readBytes();
               this.bitField0_ |= 2;
               this.inputType_ = var16;
               break;
            case 26:
               var16 = var1.readBytes();
               this.bitField0_ |= 4;
               this.outputType_ = var16;
               break;
            case 34:
               DescriptorProtos$MethodOptions$Builder var7 = null;
               if((this.bitField0_ & 8) == 8) {
                  var7 = this.options_.toBuilder();
               }

               this.options_ = (DescriptorProtos$MethodOptions)var1.readMessage(DescriptorProtos$MethodOptions.PARSER, var2);
               if(var7 != null) {
                  var7.mergeFrom(this.options_);
                  this.options_ = var7.buildPartial();
               }

               this.bitField0_ |= 8;
               break;
            case 40:
               this.bitField0_ |= 16;
               this.clientStreaming_ = var1.readBool();
               break;
            case 48:
               this.bitField0_ |= 32;
               this.serverStreaming_ = var1.readBool();
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var13) {
         throw new RuntimeException(var13.setUnfinishedMessage(this));
      } catch (IOException var14) {
         throw new RuntimeException((new InvalidProtocolBufferException(var14.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$11500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$11600().ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) == 1;
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

   public boolean hasInputType() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getInputType() {
      Object var1 = this.inputType_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.inputType_ = var3;
         }

         return var3;
      }
   }

   public ByteString getInputTypeBytes() {
      Object var1 = this.inputType_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.inputType_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasOutputType() {
      return (this.bitField0_ & 4) == 4;
   }

   public String getOutputType() {
      Object var1 = this.outputType_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.outputType_ = var3;
         }

         return var3;
      }
   }

   public ByteString getOutputTypeBytes() {
      Object var1 = this.outputType_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.outputType_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 8) == 8;
   }

   public DescriptorProtos$MethodOptions getOptions() {
      return this.options_ == null?DescriptorProtos$MethodOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$MethodOptions.getDefaultInstance():this.options_;
   }

   public boolean hasClientStreaming() {
      return (this.bitField0_ & 16) == 16;
   }

   public boolean getClientStreaming() {
      return this.clientStreaming_;
   }

   public boolean hasServerStreaming() {
      return (this.bitField0_ & 32) == 32;
   }

   public boolean getServerStreaming() {
      return this.serverStreaming_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(this.hasOptions() && !this.getOptions().isInitialized()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getNameBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBytes(2, this.getInputTypeBytes());
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeBytes(3, this.getOutputTypeBytes());
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeMessage(4, this.getOptions());
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBool(5, this.clientStreaming_);
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeBool(6, this.serverStreaming_);
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBytesSize(2, this.getInputTypeBytes());
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeBytesSize(3, this.getOutputTypeBytes());
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeMessageSize(4, this.getOptions());
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBoolSize(5, this.clientStreaming_);
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeBoolSize(6, this.serverStreaming_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder(DescriptorProtos$MethodDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$MethodDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$MethodDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$MethodDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$MethodDescriptorProto$Builder var2 = new DescriptorProtos$MethodDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$MethodDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$MethodDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$12002(DescriptorProtos$MethodDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static Object access$12102(DescriptorProtos$MethodDescriptorProto var0, Object var1) {
      return var0.inputType_ = var1;
   }

   // $FF: synthetic method
   static Object access$12202(DescriptorProtos$MethodDescriptorProto var0, Object var1) {
      return var0.outputType_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$MethodOptions access$12302(DescriptorProtos$MethodDescriptorProto var0, DescriptorProtos$MethodOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static boolean access$12402(DescriptorProtos$MethodDescriptorProto var0, boolean var1) {
      return var0.clientStreaming_ = var1;
   }

   // $FF: synthetic method
   static boolean access$12502(DescriptorProtos$MethodDescriptorProto var0, boolean var1) {
      return var0.serverStreaming_ = var1;
   }

   // $FF: synthetic method
   static int access$12602(DescriptorProtos$MethodDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$12000(DescriptorProtos$MethodDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static Object access$12100(DescriptorProtos$MethodDescriptorProto var0) {
      return var0.inputType_;
   }

   // $FF: synthetic method
   static Object access$12200(DescriptorProtos$MethodDescriptorProto var0) {
      return var0.outputType_;
   }

   // $FF: synthetic method
   DescriptorProtos$MethodDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
