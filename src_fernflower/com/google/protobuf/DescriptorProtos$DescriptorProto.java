package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto extends GeneratedMessage implements DescriptorProtos$DescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int FIELD_FIELD_NUMBER = 2;
   private List field_;
   public static final int EXTENSION_FIELD_NUMBER = 6;
   private List extension_;
   public static final int NESTED_TYPE_FIELD_NUMBER = 3;
   private List nestedType_;
   public static final int ENUM_TYPE_FIELD_NUMBER = 4;
   private List enumType_;
   public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
   private List extensionRange_;
   public static final int ONEOF_DECL_FIELD_NUMBER = 8;
   private List oneofDecl_;
   public static final int OPTIONS_FIELD_NUMBER = 7;
   private DescriptorProtos$MessageOptions options_;
   public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
   private List reservedRange_;
   public static final int RESERVED_NAME_FIELD_NUMBER = 10;
   private LazyStringList reservedName_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$DescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$DescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$DescriptorProto$1();

   private DescriptorProtos$DescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$DescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.field_ = Collections.emptyList();
      this.extension_ = Collections.emptyList();
      this.nestedType_ = Collections.emptyList();
      this.enumType_ = Collections.emptyList();
      this.extensionRange_ = Collections.emptyList();
      this.oneofDecl_ = Collections.emptyList();
      this.reservedRange_ = Collections.emptyList();
      this.reservedName_ = LazyStringArrayList.EMPTY;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$DescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            ByteString var7;
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.name_ = var7;
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.field_ = new ArrayList();
                  var3 |= 2;
               }

               this.field_.add(var1.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, var2));
               break;
            case 26:
               if((var3 & 8) != 8) {
                  this.nestedType_ = new ArrayList();
                  var3 |= 8;
               }

               this.nestedType_.add(var1.readMessage(PARSER, var2));
               break;
            case 34:
               if((var3 & 16) != 16) {
                  this.enumType_ = new ArrayList();
                  var3 |= 16;
               }

               this.enumType_.add(var1.readMessage(DescriptorProtos$EnumDescriptorProto.PARSER, var2));
               break;
            case 42:
               if((var3 & 32) != 32) {
                  this.extensionRange_ = new ArrayList();
                  var3 |= 32;
               }

               this.extensionRange_.add(var1.readMessage(DescriptorProtos$DescriptorProto$ExtensionRange.PARSER, var2));
               break;
            case 50:
               if((var3 & 4) != 4) {
                  this.extension_ = new ArrayList();
                  var3 |= 4;
               }

               this.extension_.add(var1.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, var2));
               break;
            case 58:
               DescriptorProtos$MessageOptions$Builder var16 = null;
               if((this.bitField0_ & 2) == 2) {
                  var16 = this.options_.toBuilder();
               }

               this.options_ = (DescriptorProtos$MessageOptions)var1.readMessage(DescriptorProtos$MessageOptions.PARSER, var2);
               if(var16 != null) {
                  var16.mergeFrom(this.options_);
                  this.options_ = var16.buildPartial();
               }

               this.bitField0_ |= 2;
               break;
            case 66:
               if((var3 & 64) != 64) {
                  this.oneofDecl_ = new ArrayList();
                  var3 |= 64;
               }

               this.oneofDecl_.add(var1.readMessage(DescriptorProtos$OneofDescriptorProto.PARSER, var2));
               break;
            case 74:
               if((var3 & 256) != 256) {
                  this.reservedRange_ = new ArrayList();
                  var3 |= 256;
               }

               this.reservedRange_.add(var1.readMessage(DescriptorProtos$DescriptorProto$ReservedRange.PARSER, var2));
               break;
            case 82:
               var7 = var1.readBytes();
               if((var3 & 512) != 512) {
                  this.reservedName_ = new LazyStringArrayList();
                  var3 |= 512;
               }

               this.reservedName_.add(var7);
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
            this.field_ = Collections.unmodifiableList(this.field_);
         }

         if((var3 & 8) == 8) {
            this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
         }

         if((var3 & 16) == 16) {
            this.enumType_ = Collections.unmodifiableList(this.enumType_);
         }

         if((var3 & 32) == 32) {
            this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
         }

         if((var3 & 4) == 4) {
            this.extension_ = Collections.unmodifiableList(this.extension_);
         }

         if((var3 & 64) == 64) {
            this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
         }

         if((var3 & 256) == 256) {
            this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
         }

         if((var3 & 512) == 512) {
            this.reservedName_ = this.reservedName_.getUnmodifiableView();
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$2600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$2700().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
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

   public List getFieldList() {
      return this.field_;
   }

   public List getFieldOrBuilderList() {
      return this.field_;
   }

   public int getFieldCount() {
      return this.field_.size();
   }

   public DescriptorProtos$FieldDescriptorProto getField(int var1) {
      return (DescriptorProtos$FieldDescriptorProto)this.field_.get(var1);
   }

   public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int var1) {
      return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.field_.get(var1);
   }

   public List getExtensionList() {
      return this.extension_;
   }

   public List getExtensionOrBuilderList() {
      return this.extension_;
   }

   public int getExtensionCount() {
      return this.extension_.size();
   }

   public DescriptorProtos$FieldDescriptorProto getExtension(int var1) {
      return (DescriptorProtos$FieldDescriptorProto)this.extension_.get(var1);
   }

   public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int var1) {
      return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extension_.get(var1);
   }

   public List getNestedTypeList() {
      return this.nestedType_;
   }

   public List getNestedTypeOrBuilderList() {
      return this.nestedType_;
   }

   public int getNestedTypeCount() {
      return this.nestedType_.size();
   }

   public DescriptorProtos$DescriptorProto getNestedType(int var1) {
      return (DescriptorProtos$DescriptorProto)this.nestedType_.get(var1);
   }

   public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int var1) {
      return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedType_.get(var1);
   }

   public List getEnumTypeList() {
      return this.enumType_;
   }

   public List getEnumTypeOrBuilderList() {
      return this.enumType_;
   }

   public int getEnumTypeCount() {
      return this.enumType_.size();
   }

   public DescriptorProtos$EnumDescriptorProto getEnumType(int var1) {
      return (DescriptorProtos$EnumDescriptorProto)this.enumType_.get(var1);
   }

   public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int var1) {
      return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumType_.get(var1);
   }

   public List getExtensionRangeList() {
      return this.extensionRange_;
   }

   public List getExtensionRangeOrBuilderList() {
      return this.extensionRange_;
   }

   public int getExtensionRangeCount() {
      return this.extensionRange_.size();
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRange_.get(var1);
   }

   public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRange_.get(var1);
   }

   public List getOneofDeclList() {
      return this.oneofDecl_;
   }

   public List getOneofDeclOrBuilderList() {
      return this.oneofDecl_;
   }

   public int getOneofDeclCount() {
      return this.oneofDecl_.size();
   }

   public DescriptorProtos$OneofDescriptorProto getOneofDecl(int var1) {
      return (DescriptorProtos$OneofDescriptorProto)this.oneofDecl_.get(var1);
   }

   public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int var1) {
      return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(var1);
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 2) == 2;
   }

   public DescriptorProtos$MessageOptions getOptions() {
      return this.options_ == null?DescriptorProtos$MessageOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$MessageOptions.getDefaultInstance():this.options_;
   }

   public List getReservedRangeList() {
      return this.reservedRange_;
   }

   public List getReservedRangeOrBuilderList() {
      return this.reservedRange_;
   }

   public int getReservedRangeCount() {
      return this.reservedRange_.size();
   }

   public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int var1) {
      return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRange_.get(var1);
   }

   public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRange_.get(var1);
   }

   public ProtocolStringList getReservedNameList() {
      return this.reservedName_;
   }

   public int getReservedNameCount() {
      return this.reservedName_.size();
   }

   public String getReservedName(int var1) {
      return (String)this.reservedName_.get(var1);
   }

   public ByteString getReservedNameBytes(int var1) {
      return this.reservedName_.getByteString(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         int var2;
         for(var2 = 0; var2 < this.getFieldCount(); ++var2) {
            if(!this.getField(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         for(var2 = 0; var2 < this.getExtensionCount(); ++var2) {
            if(!this.getExtension(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         for(var2 = 0; var2 < this.getNestedTypeCount(); ++var2) {
            if(!this.getNestedType(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         for(var2 = 0; var2 < this.getEnumTypeCount(); ++var2) {
            if(!this.getEnumType(var2).isInitialized()) {
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

      int var2;
      for(var2 = 0; var2 < this.field_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.field_.get(var2));
      }

      for(var2 = 0; var2 < this.nestedType_.size(); ++var2) {
         var1.writeMessage(3, (MessageLite)this.nestedType_.get(var2));
      }

      for(var2 = 0; var2 < this.enumType_.size(); ++var2) {
         var1.writeMessage(4, (MessageLite)this.enumType_.get(var2));
      }

      for(var2 = 0; var2 < this.extensionRange_.size(); ++var2) {
         var1.writeMessage(5, (MessageLite)this.extensionRange_.get(var2));
      }

      for(var2 = 0; var2 < this.extension_.size(); ++var2) {
         var1.writeMessage(6, (MessageLite)this.extension_.get(var2));
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeMessage(7, this.getOptions());
      }

      for(var2 = 0; var2 < this.oneofDecl_.size(); ++var2) {
         var1.writeMessage(8, (MessageLite)this.oneofDecl_.get(var2));
      }

      for(var2 = 0; var2 < this.reservedRange_.size(); ++var2) {
         var1.writeMessage(9, (MessageLite)this.reservedRange_.get(var2));
      }

      for(var2 = 0; var2 < this.reservedName_.size(); ++var2) {
         var1.writeBytes(10, this.reservedName_.getByteString(var2));
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

         int var2;
         for(var2 = 0; var2 < this.field_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.field_.get(var2));
         }

         for(var2 = 0; var2 < this.nestedType_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.nestedType_.get(var2));
         }

         for(var2 = 0; var2 < this.enumType_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(4, (MessageLite)this.enumType_.get(var2));
         }

         for(var2 = 0; var2 < this.extensionRange_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(5, (MessageLite)this.extensionRange_.get(var2));
         }

         for(var2 = 0; var2 < this.extension_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.extension_.get(var2));
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeMessageSize(7, this.getOptions());
         }

         for(var2 = 0; var2 < this.oneofDecl_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(8, (MessageLite)this.oneofDecl_.get(var2));
         }

         for(var2 = 0; var2 < this.reservedRange_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(9, (MessageLite)this.reservedRange_.get(var2));
         }

         var2 = 0;

         for(int var3 = 0; var3 < this.reservedName_.size(); ++var3) {
            var2 += CodedOutputStream.computeBytesSizeNoTag(this.reservedName_.getByteString(var3));
         }

         var1 += var2;
         var1 += 1 * this.getReservedNameList().size();
         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$DescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$DescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$DescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$DescriptorProto$Builder newBuilder(DescriptorProtos$DescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$DescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$DescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$DescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$DescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$DescriptorProto$Builder var2 = new DescriptorProtos$DescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$DescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$4902(DescriptorProtos$DescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static List access$5002(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.field_ = var1;
   }

   // $FF: synthetic method
   static List access$5102(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.extension_ = var1;
   }

   // $FF: synthetic method
   static List access$5202(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.nestedType_ = var1;
   }

   // $FF: synthetic method
   static List access$5302(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.enumType_ = var1;
   }

   // $FF: synthetic method
   static List access$5402(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.extensionRange_ = var1;
   }

   // $FF: synthetic method
   static List access$5502(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.oneofDecl_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$MessageOptions access$5602(DescriptorProtos$DescriptorProto var0, DescriptorProtos$MessageOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static List access$5702(DescriptorProtos$DescriptorProto var0, List var1) {
      return var0.reservedRange_ = var1;
   }

   // $FF: synthetic method
   static LazyStringList access$5802(DescriptorProtos$DescriptorProto var0, LazyStringList var1) {
      return var0.reservedName_ = var1;
   }

   // $FF: synthetic method
   static int access$5902(DescriptorProtos$DescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$4900(DescriptorProtos$DescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$5000(DescriptorProtos$DescriptorProto var0) {
      return var0.field_;
   }

   // $FF: synthetic method
   static List access$5100(DescriptorProtos$DescriptorProto var0) {
      return var0.extension_;
   }

   // $FF: synthetic method
   static List access$5200(DescriptorProtos$DescriptorProto var0) {
      return var0.nestedType_;
   }

   // $FF: synthetic method
   static List access$5300(DescriptorProtos$DescriptorProto var0) {
      return var0.enumType_;
   }

   // $FF: synthetic method
   static List access$5400(DescriptorProtos$DescriptorProto var0) {
      return var0.extensionRange_;
   }

   // $FF: synthetic method
   static List access$5500(DescriptorProtos$DescriptorProto var0) {
      return var0.oneofDecl_;
   }

   // $FF: synthetic method
   static List access$5700(DescriptorProtos$DescriptorProto var0) {
      return var0.reservedRange_;
   }

   // $FF: synthetic method
   static LazyStringList access$5800(DescriptorProtos$DescriptorProto var0) {
      return var0.reservedName_;
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
