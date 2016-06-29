package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptions$Builder;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto extends GeneratedMessage implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int METHOD_FIELD_NUMBER = 2;
   private List method_;
   public static final int OPTIONS_FIELD_NUMBER = 3;
   private DescriptorProtos$ServiceOptions options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$ServiceDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$ServiceDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$ServiceDescriptorProto$1();

   private DescriptorProtos$ServiceDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$ServiceDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.method_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$ServiceDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               ByteString var16 = var1.readBytes();
               this.bitField0_ |= 1;
               this.name_ = var16;
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.method_ = new ArrayList();
                  var3 |= 2;
               }

               this.method_.add(var1.readMessage(DescriptorProtos$MethodDescriptorProto.PARSER, var2));
               break;
            case 26:
               DescriptorProtos$ServiceOptions$Builder var7 = null;
               if((this.bitField0_ & 2) == 2) {
                  var7 = this.options_.toBuilder();
               }

               this.options_ = (DescriptorProtos$ServiceOptions)var1.readMessage(DescriptorProtos$ServiceOptions.PARSER, var2);
               if(var7 != null) {
                  var7.mergeFrom(this.options_);
                  this.options_ = var7.buildPartial();
               }

               this.bitField0_ |= 2;
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
         if((var3 & 2) == 2) {
            this.method_ = Collections.unmodifiableList(this.method_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$10500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$10600().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
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

   public List getMethodList() {
      return this.method_;
   }

   public List getMethodOrBuilderList() {
      return this.method_;
   }

   public int getMethodCount() {
      return this.method_.size();
   }

   public DescriptorProtos$MethodDescriptorProto getMethod(int var1) {
      return (DescriptorProtos$MethodDescriptorProto)this.method_.get(var1);
   }

   public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int var1) {
      return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.method_.get(var1);
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 2) == 2;
   }

   public DescriptorProtos$ServiceOptions getOptions() {
      return this.options_ == null?DescriptorProtos$ServiceOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$ServiceOptions.getDefaultInstance():this.options_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.getMethodCount(); ++var2) {
            if(!this.getMethod(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         if(this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
         } else {
            this.memoizedIsInitialized = 1;
            return true;
         }
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getNameBytes());
      }

      for(int var2 = 0; var2 < this.method_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.method_.get(var2));
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeMessage(3, this.getOptions());
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

         for(int var2 = 0; var2 < this.method_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.method_.get(var2));
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeMessageSize(3, this.getOptions());
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder(DescriptorProtos$ServiceDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$ServiceDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$ServiceDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$ServiceDescriptorProto$Builder var2 = new DescriptorProtos$ServiceDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$ServiceDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$ServiceDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$11002(DescriptorProtos$ServiceDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static List access$11102(DescriptorProtos$ServiceDescriptorProto var0, List var1) {
      return var0.method_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$ServiceOptions access$11202(DescriptorProtos$ServiceDescriptorProto var0, DescriptorProtos$ServiceOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$11302(DescriptorProtos$ServiceDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$11000(DescriptorProtos$ServiceDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$11100(DescriptorProtos$ServiceDescriptorProto var0) {
      return var0.method_;
   }

   // $FF: synthetic method
   DescriptorProtos$ServiceDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
