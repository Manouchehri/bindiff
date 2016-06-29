package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder;
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
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$FileDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private Object package_;
   private LazyStringList dependency_;
   private List publicDependency_;
   private List weakDependency_;
   private List messageType_;
   private RepeatedFieldBuilder messageTypeBuilder_;
   private List enumType_;
   private RepeatedFieldBuilder enumTypeBuilder_;
   private List service_;
   private RepeatedFieldBuilder serviceBuilder_;
   private List extension_;
   private RepeatedFieldBuilder extensionBuilder_;
   private DescriptorProtos$FileOptions options_;
   private SingleFieldBuilder optionsBuilder_;
   private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
   private SingleFieldBuilder sourceCodeInfoBuilder_;
   private Object syntax_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
   }

   private DescriptorProtos$FileDescriptorProto$Builder() {
      this.name_ = "";
      this.package_ = "";
      this.dependency_ = LazyStringArrayList.EMPTY;
      this.publicDependency_ = Collections.emptyList();
      this.weakDependency_ = Collections.emptyList();
      this.messageType_ = Collections.emptyList();
      this.enumType_ = Collections.emptyList();
      this.service_ = Collections.emptyList();
      this.extension_ = Collections.emptyList();
      this.options_ = null;
      this.sourceCodeInfo_ = null;
      this.syntax_ = "";
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.package_ = "";
      this.dependency_ = LazyStringArrayList.EMPTY;
      this.publicDependency_ = Collections.emptyList();
      this.weakDependency_ = Collections.emptyList();
      this.messageType_ = Collections.emptyList();
      this.enumType_ = Collections.emptyList();
      this.service_ = Collections.emptyList();
      this.extension_ = Collections.emptyList();
      this.options_ = null;
      this.sourceCodeInfo_ = null;
      this.syntax_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getMessageTypeFieldBuilder();
         this.getEnumTypeFieldBuilder();
         this.getServiceFieldBuilder();
         this.getExtensionFieldBuilder();
         this.getOptionsFieldBuilder();
         this.getSourceCodeInfoFieldBuilder();
      }

   }

   public DescriptorProtos$FileDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      this.package_ = "";
      this.bitField0_ &= -3;
      this.dependency_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -5;
      this.publicDependency_ = Collections.emptyList();
      this.bitField0_ &= -9;
      this.weakDependency_ = Collections.emptyList();
      this.bitField0_ &= -17;
      if(this.messageTypeBuilder_ == null) {
         this.messageType_ = Collections.emptyList();
         this.bitField0_ &= -33;
      } else {
         this.messageTypeBuilder_.clear();
      }

      if(this.enumTypeBuilder_ == null) {
         this.enumType_ = Collections.emptyList();
         this.bitField0_ &= -65;
      } else {
         this.enumTypeBuilder_.clear();
      }

      if(this.serviceBuilder_ == null) {
         this.service_ = Collections.emptyList();
         this.bitField0_ &= -129;
      } else {
         this.serviceBuilder_.clear();
      }

      if(this.extensionBuilder_ == null) {
         this.extension_ = Collections.emptyList();
         this.bitField0_ &= -257;
      } else {
         this.extensionBuilder_.clear();
      }

      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -513;
      if(this.sourceCodeInfoBuilder_ == null) {
         this.sourceCodeInfo_ = null;
      } else {
         this.sourceCodeInfoBuilder_.clear();
      }

      this.bitField0_ &= -1025;
      this.syntax_ = "";
      this.bitField0_ &= -2049;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$700();
   }

   public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$FileDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$FileDescriptorProto build() {
      DescriptorProtos$FileDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$FileDescriptorProto buildPartial() {
      DescriptorProtos$FileDescriptorProto var1 = new DescriptorProtos$FileDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$FileDescriptorProto.access$1202(var1, this.name_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$FileDescriptorProto.access$1302(var1, this.package_);
      if((this.bitField0_ & 4) == 4) {
         this.dependency_ = this.dependency_.getUnmodifiableView();
         this.bitField0_ &= -5;
      }

      DescriptorProtos$FileDescriptorProto.access$1402(var1, this.dependency_);
      if((this.bitField0_ & 8) == 8) {
         this.publicDependency_ = Collections.unmodifiableList(this.publicDependency_);
         this.bitField0_ &= -9;
      }

      DescriptorProtos$FileDescriptorProto.access$1502(var1, this.publicDependency_);
      if((this.bitField0_ & 16) == 16) {
         this.weakDependency_ = Collections.unmodifiableList(this.weakDependency_);
         this.bitField0_ &= -17;
      }

      DescriptorProtos$FileDescriptorProto.access$1602(var1, this.weakDependency_);
      if(this.messageTypeBuilder_ == null) {
         if((this.bitField0_ & 32) == 32) {
            this.messageType_ = Collections.unmodifiableList(this.messageType_);
            this.bitField0_ &= -33;
         }

         DescriptorProtos$FileDescriptorProto.access$1702(var1, this.messageType_);
      } else {
         DescriptorProtos$FileDescriptorProto.access$1702(var1, this.messageTypeBuilder_.build());
      }

      if(this.enumTypeBuilder_ == null) {
         if((this.bitField0_ & 64) == 64) {
            this.enumType_ = Collections.unmodifiableList(this.enumType_);
            this.bitField0_ &= -65;
         }

         DescriptorProtos$FileDescriptorProto.access$1802(var1, this.enumType_);
      } else {
         DescriptorProtos$FileDescriptorProto.access$1802(var1, this.enumTypeBuilder_.build());
      }

      if(this.serviceBuilder_ == null) {
         if((this.bitField0_ & 128) == 128) {
            this.service_ = Collections.unmodifiableList(this.service_);
            this.bitField0_ &= -129;
         }

         DescriptorProtos$FileDescriptorProto.access$1902(var1, this.service_);
      } else {
         DescriptorProtos$FileDescriptorProto.access$1902(var1, this.serviceBuilder_.build());
      }

      if(this.extensionBuilder_ == null) {
         if((this.bitField0_ & 256) == 256) {
            this.extension_ = Collections.unmodifiableList(this.extension_);
            this.bitField0_ &= -257;
         }

         DescriptorProtos$FileDescriptorProto.access$2002(var1, this.extension_);
      } else {
         DescriptorProtos$FileDescriptorProto.access$2002(var1, this.extensionBuilder_.build());
      }

      if((var2 & 512) == 512) {
         var3 |= 4;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$FileDescriptorProto.access$2102(var1, this.options_);
      } else {
         DescriptorProtos$FileDescriptorProto.access$2102(var1, (DescriptorProtos$FileOptions)this.optionsBuilder_.build());
      }

      if((var2 & 1024) == 1024) {
         var3 |= 8;
      }

      if(this.sourceCodeInfoBuilder_ == null) {
         DescriptorProtos$FileDescriptorProto.access$2202(var1, this.sourceCodeInfo_);
      } else {
         DescriptorProtos$FileDescriptorProto.access$2202(var1, (DescriptorProtos$SourceCodeInfo)this.sourceCodeInfoBuilder_.build());
      }

      if((var2 & 2048) == 2048) {
         var3 |= 16;
      }

      DescriptorProtos$FileDescriptorProto.access$2302(var1, this.syntax_);
      DescriptorProtos$FileDescriptorProto.access$2402(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$FileDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$FileDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(DescriptorProtos$FileDescriptorProto var1) {
      if(var1 == DescriptorProtos$FileDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$FileDescriptorProto.access$1200(var1);
            this.onChanged();
         }

         if(var1.hasPackage()) {
            this.bitField0_ |= 2;
            this.package_ = DescriptorProtos$FileDescriptorProto.access$1300(var1);
            this.onChanged();
         }

         if(!DescriptorProtos$FileDescriptorProto.access$1400(var1).isEmpty()) {
            if(this.dependency_.isEmpty()) {
               this.dependency_ = DescriptorProtos$FileDescriptorProto.access$1400(var1);
               this.bitField0_ &= -5;
            } else {
               this.ensureDependencyIsMutable();
               this.dependency_.addAll(DescriptorProtos$FileDescriptorProto.access$1400(var1));
            }

            this.onChanged();
         }

         if(!DescriptorProtos$FileDescriptorProto.access$1500(var1).isEmpty()) {
            if(this.publicDependency_.isEmpty()) {
               this.publicDependency_ = DescriptorProtos$FileDescriptorProto.access$1500(var1);
               this.bitField0_ &= -9;
            } else {
               this.ensurePublicDependencyIsMutable();
               this.publicDependency_.addAll(DescriptorProtos$FileDescriptorProto.access$1500(var1));
            }

            this.onChanged();
         }

         if(!DescriptorProtos$FileDescriptorProto.access$1600(var1).isEmpty()) {
            if(this.weakDependency_.isEmpty()) {
               this.weakDependency_ = DescriptorProtos$FileDescriptorProto.access$1600(var1);
               this.bitField0_ &= -17;
            } else {
               this.ensureWeakDependencyIsMutable();
               this.weakDependency_.addAll(DescriptorProtos$FileDescriptorProto.access$1600(var1));
            }

            this.onChanged();
         }

         if(this.messageTypeBuilder_ == null) {
            if(!DescriptorProtos$FileDescriptorProto.access$1700(var1).isEmpty()) {
               if(this.messageType_.isEmpty()) {
                  this.messageType_ = DescriptorProtos$FileDescriptorProto.access$1700(var1);
                  this.bitField0_ &= -33;
               } else {
                  this.ensureMessageTypeIsMutable();
                  this.messageType_.addAll(DescriptorProtos$FileDescriptorProto.access$1700(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FileDescriptorProto.access$1700(var1).isEmpty()) {
            if(this.messageTypeBuilder_.isEmpty()) {
               this.messageTypeBuilder_.dispose();
               this.messageTypeBuilder_ = null;
               this.messageType_ = DescriptorProtos$FileDescriptorProto.access$1700(var1);
               this.bitField0_ &= -33;
               this.messageTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getMessageTypeFieldBuilder():null;
            } else {
               this.messageTypeBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$1700(var1));
            }
         }

         if(this.enumTypeBuilder_ == null) {
            if(!DescriptorProtos$FileDescriptorProto.access$1800(var1).isEmpty()) {
               if(this.enumType_.isEmpty()) {
                  this.enumType_ = DescriptorProtos$FileDescriptorProto.access$1800(var1);
                  this.bitField0_ &= -65;
               } else {
                  this.ensureEnumTypeIsMutable();
                  this.enumType_.addAll(DescriptorProtos$FileDescriptorProto.access$1800(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FileDescriptorProto.access$1800(var1).isEmpty()) {
            if(this.enumTypeBuilder_.isEmpty()) {
               this.enumTypeBuilder_.dispose();
               this.enumTypeBuilder_ = null;
               this.enumType_ = DescriptorProtos$FileDescriptorProto.access$1800(var1);
               this.bitField0_ &= -65;
               this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getEnumTypeFieldBuilder():null;
            } else {
               this.enumTypeBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$1800(var1));
            }
         }

         if(this.serviceBuilder_ == null) {
            if(!DescriptorProtos$FileDescriptorProto.access$1900(var1).isEmpty()) {
               if(this.service_.isEmpty()) {
                  this.service_ = DescriptorProtos$FileDescriptorProto.access$1900(var1);
                  this.bitField0_ &= -129;
               } else {
                  this.ensureServiceIsMutable();
                  this.service_.addAll(DescriptorProtos$FileDescriptorProto.access$1900(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FileDescriptorProto.access$1900(var1).isEmpty()) {
            if(this.serviceBuilder_.isEmpty()) {
               this.serviceBuilder_.dispose();
               this.serviceBuilder_ = null;
               this.service_ = DescriptorProtos$FileDescriptorProto.access$1900(var1);
               this.bitField0_ &= -129;
               this.serviceBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getServiceFieldBuilder():null;
            } else {
               this.serviceBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$1900(var1));
            }
         }

         if(this.extensionBuilder_ == null) {
            if(!DescriptorProtos$FileDescriptorProto.access$2000(var1).isEmpty()) {
               if(this.extension_.isEmpty()) {
                  this.extension_ = DescriptorProtos$FileDescriptorProto.access$2000(var1);
                  this.bitField0_ &= -257;
               } else {
                  this.ensureExtensionIsMutable();
                  this.extension_.addAll(DescriptorProtos$FileDescriptorProto.access$2000(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FileDescriptorProto.access$2000(var1).isEmpty()) {
            if(this.extensionBuilder_.isEmpty()) {
               this.extensionBuilder_.dispose();
               this.extensionBuilder_ = null;
               this.extension_ = DescriptorProtos$FileDescriptorProto.access$2000(var1);
               this.bitField0_ &= -257;
               this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getExtensionFieldBuilder():null;
            } else {
               this.extensionBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$2000(var1));
            }
         }

         if(var1.hasOptions()) {
            this.mergeOptions(var1.getOptions());
         }

         if(var1.hasSourceCodeInfo()) {
            this.mergeSourceCodeInfo(var1.getSourceCodeInfo());
         }

         if(var1.hasSyntax()) {
            this.bitField0_ |= 2048;
            this.syntax_ = DescriptorProtos$FileDescriptorProto.access$2300(var1);
            this.onChanged();
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      int var1;
      for(var1 = 0; var1 < this.getMessageTypeCount(); ++var1) {
         if(!this.getMessageType(var1).isInitialized()) {
            return false;
         }
      }

      for(var1 = 0; var1 < this.getEnumTypeCount(); ++var1) {
         if(!this.getEnumType(var1).isInitialized()) {
            return false;
         }
      }

      for(var1 = 0; var1 < this.getServiceCount(); ++var1) {
         if(!this.getService(var1).isInitialized()) {
            return false;
         }
      }

      for(var1 = 0; var1 < this.getExtensionCount(); ++var1) {
         if(!this.getExtension(var1).isInitialized()) {
            return false;
         }
      }

      if(this.hasOptions() && !this.getOptions().isInitialized()) {
         return false;
      } else {
         return true;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$FileDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (DescriptorProtos$FileDescriptorProto)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getName() {
      Object var1 = this.name_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public DescriptorProtos$FileDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasPackage() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getPackage() {
      Object var1 = this.package_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.package_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public DescriptorProtos$FileDescriptorProto$Builder setPackage(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.package_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearPackage() {
      this.bitField0_ &= -3;
      this.package_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getPackage();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setPackageBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.package_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureDependencyIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.dependency_ = new LazyStringArrayList(this.dependency_);
         this.bitField0_ |= 4;
      }

   }

   public ProtocolStringList getDependencyList() {
      return this.dependency_.getUnmodifiableView();
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

   public DescriptorProtos$FileDescriptorProto$Builder setDependency(int var1, String var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensureDependencyIsMutable();
         this.dependency_.set(var1, (Object)var2);
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder addDependency(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureDependencyIsMutable();
         this.dependency_.add((Object)var1);
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllDependency(Iterable var1) {
      this.ensureDependencyIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.dependency_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearDependency() {
      this.dependency_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -5;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addDependencyBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureDependencyIsMutable();
         this.dependency_.add(var1);
         this.onChanged();
         return this;
      }
   }

   private void ensurePublicDependencyIsMutable() {
      if((this.bitField0_ & 8) != 8) {
         this.publicDependency_ = new ArrayList(this.publicDependency_);
         this.bitField0_ |= 8;
      }

   }

   public List getPublicDependencyList() {
      return Collections.unmodifiableList(this.publicDependency_);
   }

   public int getPublicDependencyCount() {
      return this.publicDependency_.size();
   }

   public int getPublicDependency(int var1) {
      return ((Integer)this.publicDependency_.get(var1)).intValue();
   }

   public DescriptorProtos$FileDescriptorProto$Builder setPublicDependency(int var1, int var2) {
      this.ensurePublicDependencyIsMutable();
      this.publicDependency_.set(var1, Integer.valueOf(var2));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addPublicDependency(int var1) {
      this.ensurePublicDependencyIsMutable();
      this.publicDependency_.add(Integer.valueOf(var1));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllPublicDependency(Iterable var1) {
      this.ensurePublicDependencyIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.publicDependency_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearPublicDependency() {
      this.publicDependency_ = Collections.emptyList();
      this.bitField0_ &= -9;
      this.onChanged();
      return this;
   }

   private void ensureWeakDependencyIsMutable() {
      if((this.bitField0_ & 16) != 16) {
         this.weakDependency_ = new ArrayList(this.weakDependency_);
         this.bitField0_ |= 16;
      }

   }

   public List getWeakDependencyList() {
      return Collections.unmodifiableList(this.weakDependency_);
   }

   public int getWeakDependencyCount() {
      return this.weakDependency_.size();
   }

   public int getWeakDependency(int var1) {
      return ((Integer)this.weakDependency_.get(var1)).intValue();
   }

   public DescriptorProtos$FileDescriptorProto$Builder setWeakDependency(int var1, int var2) {
      this.ensureWeakDependencyIsMutable();
      this.weakDependency_.set(var1, Integer.valueOf(var2));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addWeakDependency(int var1) {
      this.ensureWeakDependencyIsMutable();
      this.weakDependency_.add(Integer.valueOf(var1));
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllWeakDependency(Iterable var1) {
      this.ensureWeakDependencyIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.weakDependency_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearWeakDependency() {
      this.weakDependency_ = Collections.emptyList();
      this.bitField0_ &= -17;
      this.onChanged();
      return this;
   }

   private void ensureMessageTypeIsMutable() {
      if((this.bitField0_ & 32) != 32) {
         this.messageType_ = new ArrayList(this.messageType_);
         this.bitField0_ |= 32;
      }

   }

   public List getMessageTypeList() {
      return this.messageTypeBuilder_ == null?Collections.unmodifiableList(this.messageType_):this.messageTypeBuilder_.getMessageList();
   }

   public int getMessageTypeCount() {
      return this.messageTypeBuilder_ == null?this.messageType_.size():this.messageTypeBuilder_.getCount();
   }

   public DescriptorProtos$DescriptorProto getMessageType(int var1) {
      return this.messageTypeBuilder_ == null?(DescriptorProtos$DescriptorProto)this.messageType_.get(var1):(DescriptorProtos$DescriptorProto)this.messageTypeBuilder_.getMessage(var1);
   }

   public DescriptorProtos$FileDescriptorProto$Builder setMessageType(int var1, DescriptorProtos$DescriptorProto var2) {
      if(this.messageTypeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureMessageTypeIsMutable();
         this.messageType_.set(var1, var2);
         this.onChanged();
      } else {
         this.messageTypeBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setMessageType(int var1, DescriptorProtos$DescriptorProto$Builder var2) {
      if(this.messageTypeBuilder_ == null) {
         this.ensureMessageTypeIsMutable();
         this.messageType_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.messageTypeBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addMessageType(DescriptorProtos$DescriptorProto var1) {
      if(this.messageTypeBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureMessageTypeIsMutable();
         this.messageType_.add(var1);
         this.onChanged();
      } else {
         this.messageTypeBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addMessageType(int var1, DescriptorProtos$DescriptorProto var2) {
      if(this.messageTypeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureMessageTypeIsMutable();
         this.messageType_.add(var1, var2);
         this.onChanged();
      } else {
         this.messageTypeBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addMessageType(DescriptorProtos$DescriptorProto$Builder var1) {
      if(this.messageTypeBuilder_ == null) {
         this.ensureMessageTypeIsMutable();
         this.messageType_.add(var1.build());
         this.onChanged();
      } else {
         this.messageTypeBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addMessageType(int var1, DescriptorProtos$DescriptorProto$Builder var2) {
      if(this.messageTypeBuilder_ == null) {
         this.ensureMessageTypeIsMutable();
         this.messageType_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.messageTypeBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllMessageType(Iterable var1) {
      if(this.messageTypeBuilder_ == null) {
         this.ensureMessageTypeIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.messageType_);
         this.onChanged();
      } else {
         this.messageTypeBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearMessageType() {
      if(this.messageTypeBuilder_ == null) {
         this.messageType_ = Collections.emptyList();
         this.bitField0_ &= -33;
         this.onChanged();
      } else {
         this.messageTypeBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder removeMessageType(int var1) {
      if(this.messageTypeBuilder_ == null) {
         this.ensureMessageTypeIsMutable();
         this.messageType_.remove(var1);
         this.onChanged();
      } else {
         this.messageTypeBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder getMessageTypeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int var1) {
      return this.messageTypeBuilder_ == null?(DescriptorProtos$DescriptorProtoOrBuilder)this.messageType_.get(var1):(DescriptorProtos$DescriptorProtoOrBuilder)this.messageTypeBuilder_.getMessageOrBuilder(var1);
   }

   public List getMessageTypeOrBuilderList() {
      return this.messageTypeBuilder_ != null?this.messageTypeBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.messageType_);
   }

   public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder() {
      return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().addBuilder(var1, DescriptorProtos$DescriptorProto.getDefaultInstance());
   }

   public List getMessageTypeBuilderList() {
      return this.getMessageTypeFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getMessageTypeFieldBuilder() {
      if(this.messageTypeBuilder_ == null) {
         this.messageTypeBuilder_ = new RepeatedFieldBuilder(this.messageType_, (this.bitField0_ & 32) == 32, this.getParentForChildren(), this.isClean());
         this.messageType_ = null;
      }

      return this.messageTypeBuilder_;
   }

   private void ensureEnumTypeIsMutable() {
      if((this.bitField0_ & 64) != 64) {
         this.enumType_ = new ArrayList(this.enumType_);
         this.bitField0_ |= 64;
      }

   }

   public List getEnumTypeList() {
      return this.enumTypeBuilder_ == null?Collections.unmodifiableList(this.enumType_):this.enumTypeBuilder_.getMessageList();
   }

   public int getEnumTypeCount() {
      return this.enumTypeBuilder_ == null?this.enumType_.size():this.enumTypeBuilder_.getCount();
   }

   public DescriptorProtos$EnumDescriptorProto getEnumType(int var1) {
      return this.enumTypeBuilder_ == null?(DescriptorProtos$EnumDescriptorProto)this.enumType_.get(var1):(DescriptorProtos$EnumDescriptorProto)this.enumTypeBuilder_.getMessage(var1);
   }

   public DescriptorProtos$FileDescriptorProto$Builder setEnumType(int var1, DescriptorProtos$EnumDescriptorProto var2) {
      if(this.enumTypeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureEnumTypeIsMutable();
         this.enumType_.set(var1, var2);
         this.onChanged();
      } else {
         this.enumTypeBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setEnumType(int var1, DescriptorProtos$EnumDescriptorProto$Builder var2) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.enumTypeBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto var1) {
      if(this.enumTypeBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureEnumTypeIsMutable();
         this.enumType_.add(var1);
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addEnumType(int var1, DescriptorProtos$EnumDescriptorProto var2) {
      if(this.enumTypeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureEnumTypeIsMutable();
         this.enumType_.add(var1, var2);
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto$Builder var1) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.add(var1.build());
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addEnumType(int var1, DescriptorProtos$EnumDescriptorProto$Builder var2) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllEnumType(Iterable var1) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.enumType_);
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearEnumType() {
      if(this.enumTypeBuilder_ == null) {
         this.enumType_ = Collections.emptyList();
         this.bitField0_ &= -65;
         this.onChanged();
      } else {
         this.enumTypeBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder removeEnumType(int var1) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.remove(var1);
         this.onChanged();
      } else {
         this.enumTypeBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder getEnumTypeBuilder(int var1) {
      return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int var1) {
      return this.enumTypeBuilder_ == null?(DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumType_.get(var1):(DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumTypeBuilder_.getMessageOrBuilder(var1);
   }

   public List getEnumTypeOrBuilderList() {
      return this.enumTypeBuilder_ != null?this.enumTypeBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.enumType_);
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder() {
      return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().addBuilder(DescriptorProtos$EnumDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder(int var1) {
      return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().addBuilder(var1, DescriptorProtos$EnumDescriptorProto.getDefaultInstance());
   }

   public List getEnumTypeBuilderList() {
      return this.getEnumTypeFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getEnumTypeFieldBuilder() {
      if(this.enumTypeBuilder_ == null) {
         this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 64) == 64, this.getParentForChildren(), this.isClean());
         this.enumType_ = null;
      }

      return this.enumTypeBuilder_;
   }

   private void ensureServiceIsMutable() {
      if((this.bitField0_ & 128) != 128) {
         this.service_ = new ArrayList(this.service_);
         this.bitField0_ |= 128;
      }

   }

   public List getServiceList() {
      return this.serviceBuilder_ == null?Collections.unmodifiableList(this.service_):this.serviceBuilder_.getMessageList();
   }

   public int getServiceCount() {
      return this.serviceBuilder_ == null?this.service_.size():this.serviceBuilder_.getCount();
   }

   public DescriptorProtos$ServiceDescriptorProto getService(int var1) {
      return this.serviceBuilder_ == null?(DescriptorProtos$ServiceDescriptorProto)this.service_.get(var1):(DescriptorProtos$ServiceDescriptorProto)this.serviceBuilder_.getMessage(var1);
   }

   public DescriptorProtos$FileDescriptorProto$Builder setService(int var1, DescriptorProtos$ServiceDescriptorProto var2) {
      if(this.serviceBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureServiceIsMutable();
         this.service_.set(var1, var2);
         this.onChanged();
      } else {
         this.serviceBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setService(int var1, DescriptorProtos$ServiceDescriptorProto$Builder var2) {
      if(this.serviceBuilder_ == null) {
         this.ensureServiceIsMutable();
         this.service_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.serviceBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addService(DescriptorProtos$ServiceDescriptorProto var1) {
      if(this.serviceBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureServiceIsMutable();
         this.service_.add(var1);
         this.onChanged();
      } else {
         this.serviceBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addService(int var1, DescriptorProtos$ServiceDescriptorProto var2) {
      if(this.serviceBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureServiceIsMutable();
         this.service_.add(var1, var2);
         this.onChanged();
      } else {
         this.serviceBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addService(DescriptorProtos$ServiceDescriptorProto$Builder var1) {
      if(this.serviceBuilder_ == null) {
         this.ensureServiceIsMutable();
         this.service_.add(var1.build());
         this.onChanged();
      } else {
         this.serviceBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addService(int var1, DescriptorProtos$ServiceDescriptorProto$Builder var2) {
      if(this.serviceBuilder_ == null) {
         this.ensureServiceIsMutable();
         this.service_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.serviceBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllService(Iterable var1) {
      if(this.serviceBuilder_ == null) {
         this.ensureServiceIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.service_);
         this.onChanged();
      } else {
         this.serviceBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearService() {
      if(this.serviceBuilder_ == null) {
         this.service_ = Collections.emptyList();
         this.bitField0_ &= -129;
         this.onChanged();
      } else {
         this.serviceBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder removeService(int var1) {
      if(this.serviceBuilder_ == null) {
         this.ensureServiceIsMutable();
         this.service_.remove(var1);
         this.onChanged();
      } else {
         this.serviceBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder getServiceBuilder(int var1) {
      return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int var1) {
      return this.serviceBuilder_ == null?(DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.service_.get(var1):(DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.serviceBuilder_.getMessageOrBuilder(var1);
   }

   public List getServiceOrBuilderList() {
      return this.serviceBuilder_ != null?this.serviceBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.service_);
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder() {
      return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().addBuilder(DescriptorProtos$ServiceDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder(int var1) {
      return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().addBuilder(var1, DescriptorProtos$ServiceDescriptorProto.getDefaultInstance());
   }

   public List getServiceBuilderList() {
      return this.getServiceFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getServiceFieldBuilder() {
      if(this.serviceBuilder_ == null) {
         this.serviceBuilder_ = new RepeatedFieldBuilder(this.service_, (this.bitField0_ & 128) == 128, this.getParentForChildren(), this.isClean());
         this.service_ = null;
      }

      return this.serviceBuilder_;
   }

   private void ensureExtensionIsMutable() {
      if((this.bitField0_ & 256) != 256) {
         this.extension_ = new ArrayList(this.extension_);
         this.bitField0_ |= 256;
      }

   }

   public List getExtensionList() {
      return this.extensionBuilder_ == null?Collections.unmodifiableList(this.extension_):this.extensionBuilder_.getMessageList();
   }

   public int getExtensionCount() {
      return this.extensionBuilder_ == null?this.extension_.size():this.extensionBuilder_.getCount();
   }

   public DescriptorProtos$FieldDescriptorProto getExtension(int var1) {
      return this.extensionBuilder_ == null?(DescriptorProtos$FieldDescriptorProto)this.extension_.get(var1):(DescriptorProtos$FieldDescriptorProto)this.extensionBuilder_.getMessage(var1);
   }

   public DescriptorProtos$FileDescriptorProto$Builder setExtension(int var1, DescriptorProtos$FieldDescriptorProto var2) {
      if(this.extensionBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureExtensionIsMutable();
         this.extension_.set(var1, var2);
         this.onChanged();
      } else {
         this.extensionBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setExtension(int var1, DescriptorProtos$FieldDescriptorProto$Builder var2) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.extensionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto var1) {
      if(this.extensionBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureExtensionIsMutable();
         this.extension_.add(var1);
         this.onChanged();
      } else {
         this.extensionBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addExtension(int var1, DescriptorProtos$FieldDescriptorProto var2) {
      if(this.extensionBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureExtensionIsMutable();
         this.extension_.add(var1, var2);
         this.onChanged();
      } else {
         this.extensionBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto$Builder var1) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.add(var1.build());
         this.onChanged();
      } else {
         this.extensionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addExtension(int var1, DescriptorProtos$FieldDescriptorProto$Builder var2) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.extensionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder addAllExtension(Iterable var1) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.extension_);
         this.onChanged();
      } else {
         this.extensionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearExtension() {
      if(this.extensionBuilder_ == null) {
         this.extension_ = Collections.emptyList();
         this.bitField0_ &= -257;
         this.onChanged();
      } else {
         this.extensionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder removeExtension(int var1) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.remove(var1);
         this.onChanged();
      } else {
         this.extensionBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder getExtensionBuilder(int var1) {
      return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int var1) {
      return this.extensionBuilder_ == null?(DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extension_.get(var1):(DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extensionBuilder_.getMessageOrBuilder(var1);
   }

   public List getExtensionOrBuilderList() {
      return this.extensionBuilder_ != null?this.extensionBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.extension_);
   }

   public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder() {
      return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().addBuilder(DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder(int var1) {
      return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().addBuilder(var1, DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
   }

   public List getExtensionBuilderList() {
      return this.getExtensionFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getExtensionFieldBuilder() {
      if(this.extensionBuilder_ == null) {
         this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 256) == 256, this.getParentForChildren(), this.isClean());
         this.extension_ = null;
      }

      return this.extensionBuilder_;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 512) == 512;
   }

   public DescriptorProtos$FileOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$FileOptions.getDefaultInstance():this.options_):(DescriptorProtos$FileOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$FileDescriptorProto$Builder setOptions(DescriptorProtos$FileOptions var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.options_ = var1;
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 512;
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setOptions(DescriptorProtos$FileOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 512;
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder mergeOptions(DescriptorProtos$FileOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 512) == 512 && this.options_ != null && this.options_ != DescriptorProtos$FileOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$FileOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
         } else {
            this.options_ = var1;
         }

         this.onChanged();
      } else {
         this.optionsBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 512;
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -513;
      return this;
   }

   public DescriptorProtos$FileOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 512;
      this.onChanged();
      return (DescriptorProtos$FileOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$FileOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$FileOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$FileOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public boolean hasSourceCodeInfo() {
      return (this.bitField0_ & 1024) == 1024;
   }

   public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
      return this.sourceCodeInfoBuilder_ == null?(this.sourceCodeInfo_ == null?DescriptorProtos$SourceCodeInfo.getDefaultInstance():this.sourceCodeInfo_):(DescriptorProtos$SourceCodeInfo)this.sourceCodeInfoBuilder_.getMessage();
   }

   public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(DescriptorProtos$SourceCodeInfo var1) {
      if(this.sourceCodeInfoBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.sourceCodeInfo_ = var1;
         this.onChanged();
      } else {
         this.sourceCodeInfoBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 1024;
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(DescriptorProtos$SourceCodeInfo$Builder var1) {
      if(this.sourceCodeInfoBuilder_ == null) {
         this.sourceCodeInfo_ = var1.build();
         this.onChanged();
      } else {
         this.sourceCodeInfoBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 1024;
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder mergeSourceCodeInfo(DescriptorProtos$SourceCodeInfo var1) {
      if(this.sourceCodeInfoBuilder_ == null) {
         if((this.bitField0_ & 1024) == 1024 && this.sourceCodeInfo_ != null && this.sourceCodeInfo_ != DescriptorProtos$SourceCodeInfo.getDefaultInstance()) {
            this.sourceCodeInfo_ = DescriptorProtos$SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(var1).buildPartial();
         } else {
            this.sourceCodeInfo_ = var1;
         }

         this.onChanged();
      } else {
         this.sourceCodeInfoBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 1024;
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearSourceCodeInfo() {
      if(this.sourceCodeInfoBuilder_ == null) {
         this.sourceCodeInfo_ = null;
         this.onChanged();
      } else {
         this.sourceCodeInfoBuilder_.clear();
      }

      this.bitField0_ &= -1025;
      return this;
   }

   public DescriptorProtos$SourceCodeInfo$Builder getSourceCodeInfoBuilder() {
      this.bitField0_ |= 1024;
      this.onChanged();
      return (DescriptorProtos$SourceCodeInfo$Builder)this.getSourceCodeInfoFieldBuilder().getBuilder();
   }

   public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
      return (DescriptorProtos$SourceCodeInfoOrBuilder)(this.sourceCodeInfoBuilder_ != null?(DescriptorProtos$SourceCodeInfoOrBuilder)this.sourceCodeInfoBuilder_.getMessageOrBuilder():(this.sourceCodeInfo_ == null?DescriptorProtos$SourceCodeInfo.getDefaultInstance():this.sourceCodeInfo_));
   }

   private SingleFieldBuilder getSourceCodeInfoFieldBuilder() {
      if(this.sourceCodeInfoBuilder_ == null) {
         this.sourceCodeInfoBuilder_ = new SingleFieldBuilder(this.getSourceCodeInfo(), this.getParentForChildren(), this.isClean());
         this.sourceCodeInfo_ = null;
      }

      return this.sourceCodeInfoBuilder_;
   }

   public boolean hasSyntax() {
      return (this.bitField0_ & 2048) == 2048;
   }

   public String getSyntax() {
      Object var1 = this.syntax_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.syntax_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public DescriptorProtos$FileDescriptorProto$Builder setSyntax(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2048;
         this.syntax_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorProto$Builder clearSyntax() {
      this.bitField0_ &= -2049;
      this.syntax_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getSyntax();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder setSyntaxBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2048;
         this.syntax_ = var1;
         this.onChanged();
         return this;
      }
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
