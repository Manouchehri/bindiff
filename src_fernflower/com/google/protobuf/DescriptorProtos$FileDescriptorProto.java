package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
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

public final class DescriptorProtos$FileDescriptorProto extends GeneratedMessage implements DescriptorProtos$FileDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int PACKAGE_FIELD_NUMBER = 2;
   private volatile Object package_;
   public static final int DEPENDENCY_FIELD_NUMBER = 3;
   private LazyStringList dependency_;
   public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
   private List publicDependency_;
   public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
   private List weakDependency_;
   public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
   private List messageType_;
   public static final int ENUM_TYPE_FIELD_NUMBER = 5;
   private List enumType_;
   public static final int SERVICE_FIELD_NUMBER = 6;
   private List service_;
   public static final int EXTENSION_FIELD_NUMBER = 7;
   private List extension_;
   public static final int OPTIONS_FIELD_NUMBER = 8;
   private DescriptorProtos$FileOptions options_;
   public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
   private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
   public static final int SYNTAX_FIELD_NUMBER = 12;
   private volatile Object syntax_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$FileDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$FileDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$FileDescriptorProto$1();

   private DescriptorProtos$FileDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$FileDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.package_ = "";
      this.dependency_ = LazyStringArrayList.EMPTY;
      this.publicDependency_ = Collections.emptyList();
      this.weakDependency_ = Collections.emptyList();
      this.messageType_ = Collections.emptyList();
      this.enumType_ = Collections.emptyList();
      this.service_ = Collections.emptyList();
      this.extension_ = Collections.emptyList();
      this.syntax_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$FileDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(true) {
            while(!var5) {
               int var6 = var1.readTag();
               ByteString var7;
               int var8;
               int var17;
               switch(var6) {
               case 0:
                  var5 = true;
                  continue;
               case 10:
                  var7 = var1.readBytes();
                  this.bitField0_ |= 1;
                  this.name_ = var7;
                  continue;
               case 18:
                  var7 = var1.readBytes();
                  this.bitField0_ |= 2;
                  this.package_ = var7;
                  continue;
               case 26:
                  var7 = var1.readBytes();
                  if((var3 & 4) != 4) {
                     this.dependency_ = new LazyStringArrayList();
                     var3 |= 4;
                  }

                  this.dependency_.add(var7);
                  continue;
               case 34:
                  if((var3 & 32) != 32) {
                     this.messageType_ = new ArrayList();
                     var3 |= 32;
                  }

                  this.messageType_.add(var1.readMessage(DescriptorProtos$DescriptorProto.PARSER, var2));
                  continue;
               case 42:
                  if((var3 & 64) != 64) {
                     this.enumType_ = new ArrayList();
                     var3 |= 64;
                  }

                  this.enumType_.add(var1.readMessage(DescriptorProtos$EnumDescriptorProto.PARSER, var2));
                  continue;
               case 50:
                  if((var3 & 128) != 128) {
                     this.service_ = new ArrayList();
                     var3 |= 128;
                  }

                  this.service_.add(var1.readMessage(DescriptorProtos$ServiceDescriptorProto.PARSER, var2));
                  continue;
               case 58:
                  if((var3 & 256) != 256) {
                     this.extension_ = new ArrayList();
                     var3 |= 256;
                  }

                  this.extension_.add(var1.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, var2));
                  continue;
               case 66:
                  DescriptorProtos$FileOptions$Builder var19 = null;
                  if((this.bitField0_ & 4) == 4) {
                     var19 = this.options_.toBuilder();
                  }

                  this.options_ = (DescriptorProtos$FileOptions)var1.readMessage(DescriptorProtos$FileOptions.PARSER, var2);
                  if(var19 != null) {
                     var19.mergeFrom(this.options_);
                     this.options_ = var19.buildPartial();
                  }

                  this.bitField0_ |= 4;
                  continue;
               case 74:
                  DescriptorProtos$SourceCodeInfo$Builder var18 = null;
                  if((this.bitField0_ & 8) == 8) {
                     var18 = this.sourceCodeInfo_.toBuilder();
                  }

                  this.sourceCodeInfo_ = (DescriptorProtos$SourceCodeInfo)var1.readMessage(DescriptorProtos$SourceCodeInfo.PARSER, var2);
                  if(var18 != null) {
                     var18.mergeFrom(this.sourceCodeInfo_);
                     this.sourceCodeInfo_ = var18.buildPartial();
                  }

                  this.bitField0_ |= 8;
                  continue;
               case 80:
                  if((var3 & 8) != 8) {
                     this.publicDependency_ = new ArrayList();
                     var3 |= 8;
                  }

                  this.publicDependency_.add(Integer.valueOf(var1.readInt32()));
                  continue;
               case 82:
                  var17 = var1.readRawVarint32();
                  var8 = var1.pushLimit(var17);
                  if((var3 & 8) != 8 && var1.getBytesUntilLimit() > 0) {
                     this.publicDependency_ = new ArrayList();
                     var3 |= 8;
                  }
                  break;
               case 88:
                  if((var3 & 16) != 16) {
                     this.weakDependency_ = new ArrayList();
                     var3 |= 16;
                  }

                  this.weakDependency_.add(Integer.valueOf(var1.readInt32()));
                  continue;
               case 90:
                  var17 = var1.readRawVarint32();
                  var8 = var1.pushLimit(var17);
                  if((var3 & 16) != 16 && var1.getBytesUntilLimit() > 0) {
                     this.weakDependency_ = new ArrayList();
                     var3 |= 16;
                  }

                  while(var1.getBytesUntilLimit() > 0) {
                     this.weakDependency_.add(Integer.valueOf(var1.readInt32()));
                  }

                  var1.popLimit(var8);
                  continue;
               case 98:
                  var7 = var1.readBytes();
                  this.bitField0_ |= 16;
                  this.syntax_ = var7;
                  continue;
               default:
                  if(!this.parseUnknownField(var1, var4, var2, var6)) {
                     var5 = true;
                  }
                  continue;
               }

               while(var1.getBytesUntilLimit() > 0) {
                  this.publicDependency_.add(Integer.valueOf(var1.readInt32()));
               }

               var1.popLimit(var8);
            }

            return;
         }
      } catch (InvalidProtocolBufferException var14) {
         throw new RuntimeException(var14.setUnfinishedMessage(this));
      } catch (IOException var15) {
         throw new RuntimeException((new InvalidProtocolBufferException(var15.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 4) == 4) {
            this.dependency_ = this.dependency_.getUnmodifiableView();
         }

         if((var3 & 32) == 32) {
            this.messageType_ = Collections.unmodifiableList(this.messageType_);
         }

         if((var3 & 64) == 64) {
            this.enumType_ = Collections.unmodifiableList(this.enumType_);
         }

         if((var3 & 128) == 128) {
            this.service_ = Collections.unmodifiableList(this.service_);
         }

         if((var3 & 256) == 256) {
            this.extension_ = Collections.unmodifiableList(this.extension_);
         }

         if((var3 & 8) == 8) {
            this.publicDependency_ = Collections.unmodifiableList(this.publicDependency_);
         }

         if((var3 & 16) == 16) {
            this.weakDependency_ = Collections.unmodifiableList(this.weakDependency_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }
   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
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

   public boolean hasPackage() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getPackage() {
      Object var1 = this.package_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.package_ = var3;
         }

         return var3;
      }
   }

   public ByteString getPackageBytes() {
      Object var1 = this.package_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.package_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public ProtocolStringList getDependencyList() {
      return this.dependency_;
   }

   public int getDependencyCount() {
      return this.dependency_.size();
   }

   public String getDependency(int var1) {
      return (String)this.dependency_.get(var1);
   }

   public ByteString getDependencyBytes(int var1) {
      return this.dependency_.getByteString(var1);
   }

   public List getPublicDependencyList() {
      return this.publicDependency_;
   }

   public int getPublicDependencyCount() {
      return this.publicDependency_.size();
   }

   public int getPublicDependency(int var1) {
      return ((Integer)this.publicDependency_.get(var1)).intValue();
   }

   public List getWeakDependencyList() {
      return this.weakDependency_;
   }

   public int getWeakDependencyCount() {
      return this.weakDependency_.size();
   }

   public int getWeakDependency(int var1) {
      return ((Integer)this.weakDependency_.get(var1)).intValue();
   }

   public List getMessageTypeList() {
      return this.messageType_;
   }

   public List getMessageTypeOrBuilderList() {
      return this.messageType_;
   }

   public int getMessageTypeCount() {
      return this.messageType_.size();
   }

   public DescriptorProtos$DescriptorProto getMessageType(int var1) {
      return (DescriptorProtos$DescriptorProto)this.messageType_.get(var1);
   }

   public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int var1) {
      return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageType_.get(var1);
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

   public List getServiceList() {
      return this.service_;
   }

   public List getServiceOrBuilderList() {
      return this.service_;
   }

   public int getServiceCount() {
      return this.service_.size();
   }

   public DescriptorProtos$ServiceDescriptorProto getService(int var1) {
      return (DescriptorProtos$ServiceDescriptorProto)this.service_.get(var1);
   }

   public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int var1) {
      return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.service_.get(var1);
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

   public boolean hasOptions() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$FileOptions getOptions() {
      return this.options_ == null?DescriptorProtos$FileOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$FileOptions.getDefaultInstance():this.options_;
   }

   public boolean hasSourceCodeInfo() {
      return (this.bitField0_ & 8) == 8;
   }

   public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
      return this.sourceCodeInfo_ == null?DescriptorProtos$SourceCodeInfo.getDefaultInstance():this.sourceCodeInfo_;
   }

   public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
      return this.sourceCodeInfo_ == null?DescriptorProtos$SourceCodeInfo.getDefaultInstance():this.sourceCodeInfo_;
   }

   public boolean hasSyntax() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getSyntax() {
      Object var1 = this.syntax_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.syntax_ = var3;
         }

         return var3;
      }
   }

   public ByteString getSyntaxBytes() {
      Object var1 = this.syntax_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.syntax_ = var2;
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
         int var2;
         for(var2 = 0; var2 < this.getMessageTypeCount(); ++var2) {
            if(!this.getMessageType(var2).isInitialized()) {
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

         for(var2 = 0; var2 < this.getServiceCount(); ++var2) {
            if(!this.getService(var2).isInitialized()) {
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

      if((this.bitField0_ & 2) == 2) {
         var1.writeBytes(2, this.getPackageBytes());
      }

      int var2;
      for(var2 = 0; var2 < this.dependency_.size(); ++var2) {
         var1.writeBytes(3, this.dependency_.getByteString(var2));
      }

      for(var2 = 0; var2 < this.messageType_.size(); ++var2) {
         var1.writeMessage(4, (MessageLite)this.messageType_.get(var2));
      }

      for(var2 = 0; var2 < this.enumType_.size(); ++var2) {
         var1.writeMessage(5, (MessageLite)this.enumType_.get(var2));
      }

      for(var2 = 0; var2 < this.service_.size(); ++var2) {
         var1.writeMessage(6, (MessageLite)this.service_.get(var2));
      }

      for(var2 = 0; var2 < this.extension_.size(); ++var2) {
         var1.writeMessage(7, (MessageLite)this.extension_.get(var2));
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeMessage(8, this.getOptions());
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeMessage(9, this.getSourceCodeInfo());
      }

      for(var2 = 0; var2 < this.publicDependency_.size(); ++var2) {
         var1.writeInt32(10, ((Integer)this.publicDependency_.get(var2)).intValue());
      }

      for(var2 = 0; var2 < this.weakDependency_.size(); ++var2) {
         var1.writeInt32(11, ((Integer)this.weakDependency_.get(var2)).intValue());
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBytes(12, this.getSyntaxBytes());
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
            var1 += CodedOutputStream.computeBytesSize(2, this.getPackageBytes());
         }

         int var2 = 0;

         int var3;
         for(var3 = 0; var3 < this.dependency_.size(); ++var3) {
            var2 += CodedOutputStream.computeBytesSizeNoTag(this.dependency_.getByteString(var3));
         }

         var1 += var2;
         var1 += 1 * this.getDependencyList().size();

         for(var2 = 0; var2 < this.messageType_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(4, (MessageLite)this.messageType_.get(var2));
         }

         for(var2 = 0; var2 < this.enumType_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(5, (MessageLite)this.enumType_.get(var2));
         }

         for(var2 = 0; var2 < this.service_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.service_.get(var2));
         }

         for(var2 = 0; var2 < this.extension_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(7, (MessageLite)this.extension_.get(var2));
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeMessageSize(8, this.getOptions());
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeMessageSize(9, this.getSourceCodeInfo());
         }

         var2 = 0;

         for(var3 = 0; var3 < this.publicDependency_.size(); ++var3) {
            var2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.publicDependency_.get(var3)).intValue());
         }

         var1 += var2;
         var1 += 1 * this.getPublicDependencyList().size();
         var2 = 0;

         for(var3 = 0; var3 < this.weakDependency_.size(); ++var3) {
            var2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.weakDependency_.get(var3)).intValue());
         }

         var1 += var2;
         var1 += 1 * this.getWeakDependencyList().size();
         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBytesSize(12, this.getSyntaxBytes());
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$FileDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$FileDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$FileDescriptorProto$Builder newBuilder(DescriptorProtos$FileDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$FileDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$FileDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$FileDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$FileDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$FileDescriptorProto$Builder var2 = new DescriptorProtos$FileDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$FileDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$1202(DescriptorProtos$FileDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static Object access$1302(DescriptorProtos$FileDescriptorProto var0, Object var1) {
      return var0.package_ = var1;
   }

   // $FF: synthetic method
   static LazyStringList access$1402(DescriptorProtos$FileDescriptorProto var0, LazyStringList var1) {
      return var0.dependency_ = var1;
   }

   // $FF: synthetic method
   static List access$1502(DescriptorProtos$FileDescriptorProto var0, List var1) {
      return var0.publicDependency_ = var1;
   }

   // $FF: synthetic method
   static List access$1602(DescriptorProtos$FileDescriptorProto var0, List var1) {
      return var0.weakDependency_ = var1;
   }

   // $FF: synthetic method
   static List access$1702(DescriptorProtos$FileDescriptorProto var0, List var1) {
      return var0.messageType_ = var1;
   }

   // $FF: synthetic method
   static List access$1802(DescriptorProtos$FileDescriptorProto var0, List var1) {
      return var0.enumType_ = var1;
   }

   // $FF: synthetic method
   static List access$1902(DescriptorProtos$FileDescriptorProto var0, List var1) {
      return var0.service_ = var1;
   }

   // $FF: synthetic method
   static List access$2002(DescriptorProtos$FileDescriptorProto var0, List var1) {
      return var0.extension_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$FileOptions access$2102(DescriptorProtos$FileDescriptorProto var0, DescriptorProtos$FileOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$SourceCodeInfo access$2202(DescriptorProtos$FileDescriptorProto var0, DescriptorProtos$SourceCodeInfo var1) {
      return var0.sourceCodeInfo_ = var1;
   }

   // $FF: synthetic method
   static Object access$2302(DescriptorProtos$FileDescriptorProto var0, Object var1) {
      return var0.syntax_ = var1;
   }

   // $FF: synthetic method
   static int access$2402(DescriptorProtos$FileDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$1200(DescriptorProtos$FileDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static Object access$1300(DescriptorProtos$FileDescriptorProto var0) {
      return var0.package_;
   }

   // $FF: synthetic method
   static LazyStringList access$1400(DescriptorProtos$FileDescriptorProto var0) {
      return var0.dependency_;
   }

   // $FF: synthetic method
   static List access$1500(DescriptorProtos$FileDescriptorProto var0) {
      return var0.publicDependency_;
   }

   // $FF: synthetic method
   static List access$1600(DescriptorProtos$FileDescriptorProto var0) {
      return var0.weakDependency_;
   }

   // $FF: synthetic method
   static List access$1700(DescriptorProtos$FileDescriptorProto var0) {
      return var0.messageType_;
   }

   // $FF: synthetic method
   static List access$1800(DescriptorProtos$FileDescriptorProto var0) {
      return var0.enumType_;
   }

   // $FF: synthetic method
   static List access$1900(DescriptorProtos$FileDescriptorProto var0) {
      return var0.service_;
   }

   // $FF: synthetic method
   static List access$2000(DescriptorProtos$FileDescriptorProto var0) {
      return var0.extension_;
   }

   // $FF: synthetic method
   static Object access$2300(DescriptorProtos$FileDescriptorProto var0) {
      return var0.syntax_;
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
