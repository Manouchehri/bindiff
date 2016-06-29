package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$EnumDescriptorProto extends GeneratedMessage implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int VALUE_FIELD_NUMBER = 2;
   private List value_;
   public static final int OPTIONS_FIELD_NUMBER = 3;
   private DescriptorProtos$EnumOptions options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$EnumDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$EnumDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$EnumDescriptorProto$1();

   private DescriptorProtos$EnumDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$EnumDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.value_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$EnumDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
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
                  this.value_ = new ArrayList();
                  var3 |= 2;
               }

               this.value_.add(var1.readMessage(DescriptorProtos$EnumValueDescriptorProto.PARSER, var2));
               break;
            case 26:
               DescriptorProtos$EnumOptions$Builder var7 = null;
               if((this.bitField0_ & 2) == 2) {
                  var7 = this.options_.toBuilder();
               }

               this.options_ = (DescriptorProtos$EnumOptions)var1.readMessage(DescriptorProtos$EnumOptions.PARSER, var2);
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
            this.value_ = Collections.unmodifiableList(this.value_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$8500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$8600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
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

   public List getValueList() {
      return this.value_;
   }

   public List getValueOrBuilderList() {
      return this.value_;
   }

   public int getValueCount() {
      return this.value_.size();
   }

   public DescriptorProtos$EnumValueDescriptorProto getValue(int var1) {
      return (DescriptorProtos$EnumValueDescriptorProto)this.value_.get(var1);
   }

   public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int var1) {
      return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.value_.get(var1);
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 2) == 2;
   }

   public DescriptorProtos$EnumOptions getOptions() {
      return this.options_ == null?DescriptorProtos$EnumOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$EnumOptions.getDefaultInstance():this.options_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.getValueCount(); ++var2) {
            if(!this.getValue(var2).isInitialized()) {
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

      for(int var2 = 0; var2 < this.value_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.value_.get(var2));
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

         for(int var2 = 0; var2 < this.value_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.value_.get(var2));
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeMessageSize(3, this.getOptions());
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder(DescriptorProtos$EnumDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$EnumDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$EnumDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$EnumDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$EnumDescriptorProto$Builder var2 = new DescriptorProtos$EnumDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$EnumDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$9002(DescriptorProtos$EnumDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static List access$9102(DescriptorProtos$EnumDescriptorProto var0, List var1) {
      return var0.value_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$EnumOptions access$9202(DescriptorProtos$EnumDescriptorProto var0, DescriptorProtos$EnumOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$9302(DescriptorProtos$EnumDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$9000(DescriptorProtos$EnumDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$9100(DescriptorProtos$EnumDescriptorProto var0) {
      return var0.value_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
