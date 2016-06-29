package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$Builder;
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
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$DescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private List field_;
   private RepeatedFieldBuilder fieldBuilder_;
   private List extension_;
   private RepeatedFieldBuilder extensionBuilder_;
   private List nestedType_;
   private RepeatedFieldBuilder nestedTypeBuilder_;
   private List enumType_;
   private RepeatedFieldBuilder enumTypeBuilder_;
   private List extensionRange_;
   private RepeatedFieldBuilder extensionRangeBuilder_;
   private List oneofDecl_;
   private RepeatedFieldBuilder oneofDeclBuilder_;
   private DescriptorProtos$MessageOptions options_;
   private SingleFieldBuilder optionsBuilder_;
   private List reservedRange_;
   private RepeatedFieldBuilder reservedRangeBuilder_;
   private LazyStringList reservedName_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$2600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$2700().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
   }

   private DescriptorProtos$DescriptorProto$Builder() {
      this.name_ = "";
      this.field_ = Collections.emptyList();
      this.extension_ = Collections.emptyList();
      this.nestedType_ = Collections.emptyList();
      this.enumType_ = Collections.emptyList();
      this.extensionRange_ = Collections.emptyList();
      this.oneofDecl_ = Collections.emptyList();
      this.options_ = null;
      this.reservedRange_ = Collections.emptyList();
      this.reservedName_ = LazyStringArrayList.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$DescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.field_ = Collections.emptyList();
      this.extension_ = Collections.emptyList();
      this.nestedType_ = Collections.emptyList();
      this.enumType_ = Collections.emptyList();
      this.extensionRange_ = Collections.emptyList();
      this.oneofDecl_ = Collections.emptyList();
      this.options_ = null;
      this.reservedRange_ = Collections.emptyList();
      this.reservedName_ = LazyStringArrayList.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getFieldFieldBuilder();
         this.getExtensionFieldBuilder();
         this.getNestedTypeFieldBuilder();
         this.getEnumTypeFieldBuilder();
         this.getExtensionRangeFieldBuilder();
         this.getOneofDeclFieldBuilder();
         this.getOptionsFieldBuilder();
         this.getReservedRangeFieldBuilder();
      }

   }

   public DescriptorProtos$DescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      if(this.fieldBuilder_ == null) {
         this.field_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.fieldBuilder_.clear();
      }

      if(this.extensionBuilder_ == null) {
         this.extension_ = Collections.emptyList();
         this.bitField0_ &= -5;
      } else {
         this.extensionBuilder_.clear();
      }

      if(this.nestedTypeBuilder_ == null) {
         this.nestedType_ = Collections.emptyList();
         this.bitField0_ &= -9;
      } else {
         this.nestedTypeBuilder_.clear();
      }

      if(this.enumTypeBuilder_ == null) {
         this.enumType_ = Collections.emptyList();
         this.bitField0_ &= -17;
      } else {
         this.enumTypeBuilder_.clear();
      }

      if(this.extensionRangeBuilder_ == null) {
         this.extensionRange_ = Collections.emptyList();
         this.bitField0_ &= -33;
      } else {
         this.extensionRangeBuilder_.clear();
      }

      if(this.oneofDeclBuilder_ == null) {
         this.oneofDecl_ = Collections.emptyList();
         this.bitField0_ &= -65;
      } else {
         this.oneofDeclBuilder_.clear();
      }

      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -129;
      if(this.reservedRangeBuilder_ == null) {
         this.reservedRange_ = Collections.emptyList();
         this.bitField0_ &= -257;
      } else {
         this.reservedRangeBuilder_.clear();
      }

      this.reservedName_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -513;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$2600();
   }

   public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$DescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$DescriptorProto build() {
      DescriptorProtos$DescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$DescriptorProto buildPartial() {
      DescriptorProtos$DescriptorProto var1 = new DescriptorProtos$DescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$DescriptorProto.access$4902(var1, this.name_);
      if(this.fieldBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.field_ = Collections.unmodifiableList(this.field_);
            this.bitField0_ &= -3;
         }

         DescriptorProtos$DescriptorProto.access$5002(var1, this.field_);
      } else {
         DescriptorProtos$DescriptorProto.access$5002(var1, this.fieldBuilder_.build());
      }

      if(this.extensionBuilder_ == null) {
         if((this.bitField0_ & 4) == 4) {
            this.extension_ = Collections.unmodifiableList(this.extension_);
            this.bitField0_ &= -5;
         }

         DescriptorProtos$DescriptorProto.access$5102(var1, this.extension_);
      } else {
         DescriptorProtos$DescriptorProto.access$5102(var1, this.extensionBuilder_.build());
      }

      if(this.nestedTypeBuilder_ == null) {
         if((this.bitField0_ & 8) == 8) {
            this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
            this.bitField0_ &= -9;
         }

         DescriptorProtos$DescriptorProto.access$5202(var1, this.nestedType_);
      } else {
         DescriptorProtos$DescriptorProto.access$5202(var1, this.nestedTypeBuilder_.build());
      }

      if(this.enumTypeBuilder_ == null) {
         if((this.bitField0_ & 16) == 16) {
            this.enumType_ = Collections.unmodifiableList(this.enumType_);
            this.bitField0_ &= -17;
         }

         DescriptorProtos$DescriptorProto.access$5302(var1, this.enumType_);
      } else {
         DescriptorProtos$DescriptorProto.access$5302(var1, this.enumTypeBuilder_.build());
      }

      if(this.extensionRangeBuilder_ == null) {
         if((this.bitField0_ & 32) == 32) {
            this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
            this.bitField0_ &= -33;
         }

         DescriptorProtos$DescriptorProto.access$5402(var1, this.extensionRange_);
      } else {
         DescriptorProtos$DescriptorProto.access$5402(var1, this.extensionRangeBuilder_.build());
      }

      if(this.oneofDeclBuilder_ == null) {
         if((this.bitField0_ & 64) == 64) {
            this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
            this.bitField0_ &= -65;
         }

         DescriptorProtos$DescriptorProto.access$5502(var1, this.oneofDecl_);
      } else {
         DescriptorProtos$DescriptorProto.access$5502(var1, this.oneofDeclBuilder_.build());
      }

      if((var2 & 128) == 128) {
         var3 |= 2;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$DescriptorProto.access$5602(var1, this.options_);
      } else {
         DescriptorProtos$DescriptorProto.access$5602(var1, (DescriptorProtos$MessageOptions)this.optionsBuilder_.build());
      }

      if(this.reservedRangeBuilder_ == null) {
         if((this.bitField0_ & 256) == 256) {
            this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
            this.bitField0_ &= -257;
         }

         DescriptorProtos$DescriptorProto.access$5702(var1, this.reservedRange_);
      } else {
         DescriptorProtos$DescriptorProto.access$5702(var1, this.reservedRangeBuilder_.build());
      }

      if((this.bitField0_ & 512) == 512) {
         this.reservedName_ = this.reservedName_.getUnmodifiableView();
         this.bitField0_ &= -513;
      }

      DescriptorProtos$DescriptorProto.access$5802(var1, this.reservedName_);
      DescriptorProtos$DescriptorProto.access$5902(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$DescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$DescriptorProto) {
         return this.mergeFrom((DescriptorProtos$DescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$DescriptorProto$Builder mergeFrom(DescriptorProtos$DescriptorProto var1) {
      if(var1 == DescriptorProtos$DescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$DescriptorProto.access$4900(var1);
            this.onChanged();
         }

         if(this.fieldBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5000(var1).isEmpty()) {
               if(this.field_.isEmpty()) {
                  this.field_ = DescriptorProtos$DescriptorProto.access$5000(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureFieldIsMutable();
                  this.field_.addAll(DescriptorProtos$DescriptorProto.access$5000(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5000(var1).isEmpty()) {
            if(this.fieldBuilder_.isEmpty()) {
               this.fieldBuilder_.dispose();
               this.fieldBuilder_ = null;
               this.field_ = DescriptorProtos$DescriptorProto.access$5000(var1);
               this.bitField0_ &= -3;
               this.fieldBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getFieldFieldBuilder():null;
            } else {
               this.fieldBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5000(var1));
            }
         }

         if(this.extensionBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5100(var1).isEmpty()) {
               if(this.extension_.isEmpty()) {
                  this.extension_ = DescriptorProtos$DescriptorProto.access$5100(var1);
                  this.bitField0_ &= -5;
               } else {
                  this.ensureExtensionIsMutable();
                  this.extension_.addAll(DescriptorProtos$DescriptorProto.access$5100(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5100(var1).isEmpty()) {
            if(this.extensionBuilder_.isEmpty()) {
               this.extensionBuilder_.dispose();
               this.extensionBuilder_ = null;
               this.extension_ = DescriptorProtos$DescriptorProto.access$5100(var1);
               this.bitField0_ &= -5;
               this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getExtensionFieldBuilder():null;
            } else {
               this.extensionBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5100(var1));
            }
         }

         if(this.nestedTypeBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5200(var1).isEmpty()) {
               if(this.nestedType_.isEmpty()) {
                  this.nestedType_ = DescriptorProtos$DescriptorProto.access$5200(var1);
                  this.bitField0_ &= -9;
               } else {
                  this.ensureNestedTypeIsMutable();
                  this.nestedType_.addAll(DescriptorProtos$DescriptorProto.access$5200(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5200(var1).isEmpty()) {
            if(this.nestedTypeBuilder_.isEmpty()) {
               this.nestedTypeBuilder_.dispose();
               this.nestedTypeBuilder_ = null;
               this.nestedType_ = DescriptorProtos$DescriptorProto.access$5200(var1);
               this.bitField0_ &= -9;
               this.nestedTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getNestedTypeFieldBuilder():null;
            } else {
               this.nestedTypeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5200(var1));
            }
         }

         if(this.enumTypeBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5300(var1).isEmpty()) {
               if(this.enumType_.isEmpty()) {
                  this.enumType_ = DescriptorProtos$DescriptorProto.access$5300(var1);
                  this.bitField0_ &= -17;
               } else {
                  this.ensureEnumTypeIsMutable();
                  this.enumType_.addAll(DescriptorProtos$DescriptorProto.access$5300(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5300(var1).isEmpty()) {
            if(this.enumTypeBuilder_.isEmpty()) {
               this.enumTypeBuilder_.dispose();
               this.enumTypeBuilder_ = null;
               this.enumType_ = DescriptorProtos$DescriptorProto.access$5300(var1);
               this.bitField0_ &= -17;
               this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getEnumTypeFieldBuilder():null;
            } else {
               this.enumTypeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5300(var1));
            }
         }

         if(this.extensionRangeBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5400(var1).isEmpty()) {
               if(this.extensionRange_.isEmpty()) {
                  this.extensionRange_ = DescriptorProtos$DescriptorProto.access$5400(var1);
                  this.bitField0_ &= -33;
               } else {
                  this.ensureExtensionRangeIsMutable();
                  this.extensionRange_.addAll(DescriptorProtos$DescriptorProto.access$5400(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5400(var1).isEmpty()) {
            if(this.extensionRangeBuilder_.isEmpty()) {
               this.extensionRangeBuilder_.dispose();
               this.extensionRangeBuilder_ = null;
               this.extensionRange_ = DescriptorProtos$DescriptorProto.access$5400(var1);
               this.bitField0_ &= -33;
               this.extensionRangeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getExtensionRangeFieldBuilder():null;
            } else {
               this.extensionRangeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5400(var1));
            }
         }

         if(this.oneofDeclBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5500(var1).isEmpty()) {
               if(this.oneofDecl_.isEmpty()) {
                  this.oneofDecl_ = DescriptorProtos$DescriptorProto.access$5500(var1);
                  this.bitField0_ &= -65;
               } else {
                  this.ensureOneofDeclIsMutable();
                  this.oneofDecl_.addAll(DescriptorProtos$DescriptorProto.access$5500(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5500(var1).isEmpty()) {
            if(this.oneofDeclBuilder_.isEmpty()) {
               this.oneofDeclBuilder_.dispose();
               this.oneofDeclBuilder_ = null;
               this.oneofDecl_ = DescriptorProtos$DescriptorProto.access$5500(var1);
               this.bitField0_ &= -65;
               this.oneofDeclBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOneofDeclFieldBuilder():null;
            } else {
               this.oneofDeclBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5500(var1));
            }
         }

         if(var1.hasOptions()) {
            this.mergeOptions(var1.getOptions());
         }

         if(this.reservedRangeBuilder_ == null) {
            if(!DescriptorProtos$DescriptorProto.access$5700(var1).isEmpty()) {
               if(this.reservedRange_.isEmpty()) {
                  this.reservedRange_ = DescriptorProtos$DescriptorProto.access$5700(var1);
                  this.bitField0_ &= -257;
               } else {
                  this.ensureReservedRangeIsMutable();
                  this.reservedRange_.addAll(DescriptorProtos$DescriptorProto.access$5700(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$DescriptorProto.access$5700(var1).isEmpty()) {
            if(this.reservedRangeBuilder_.isEmpty()) {
               this.reservedRangeBuilder_.dispose();
               this.reservedRangeBuilder_ = null;
               this.reservedRange_ = DescriptorProtos$DescriptorProto.access$5700(var1);
               this.bitField0_ &= -257;
               this.reservedRangeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getReservedRangeFieldBuilder():null;
            } else {
               this.reservedRangeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5700(var1));
            }
         }

         if(!DescriptorProtos$DescriptorProto.access$5800(var1).isEmpty()) {
            if(this.reservedName_.isEmpty()) {
               this.reservedName_ = DescriptorProtos$DescriptorProto.access$5800(var1);
               this.bitField0_ &= -513;
            } else {
               this.ensureReservedNameIsMutable();
               this.reservedName_.addAll(DescriptorProtos$DescriptorProto.access$5800(var1));
            }

            this.onChanged();
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      int var1;
      for(var1 = 0; var1 < this.getFieldCount(); ++var1) {
         if(!this.getField(var1).isInitialized()) {
            return false;
         }
      }

      for(var1 = 0; var1 < this.getExtensionCount(); ++var1) {
         if(!this.getExtension(var1).isInitialized()) {
            return false;
         }
      }

      for(var1 = 0; var1 < this.getNestedTypeCount(); ++var1) {
         if(!this.getNestedType(var1).isInitialized()) {
            return false;
         }
      }

      for(var1 = 0; var1 < this.getEnumTypeCount(); ++var1) {
         if(!this.getEnumType(var1).isInitialized()) {
            return false;
         }
      }

      if(this.hasOptions() && !this.getOptions().isInitialized()) {
         return false;
      } else {
         return true;
      }
   }

   public DescriptorProtos$DescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$DescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$DescriptorProto)var9.getUnfinishedMessage();
         throw var9;
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

   public DescriptorProtos$DescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$DescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$DescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureFieldIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.field_ = new ArrayList(this.field_);
         this.bitField0_ |= 2;
      }

   }

   public List getFieldList() {
      return this.fieldBuilder_ == null?Collections.unmodifiableList(this.field_):this.fieldBuilder_.getMessageList();
   }

   public int getFieldCount() {
      return this.fieldBuilder_ == null?this.field_.size():this.fieldBuilder_.getCount();
   }

   public DescriptorProtos$FieldDescriptorProto getField(int var1) {
      return this.fieldBuilder_ == null?(DescriptorProtos$FieldDescriptorProto)this.field_.get(var1):(DescriptorProtos$FieldDescriptorProto)this.fieldBuilder_.getMessage(var1);
   }

   public DescriptorProtos$DescriptorProto$Builder setField(int var1, DescriptorProtos$FieldDescriptorProto var2) {
      if(this.fieldBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureFieldIsMutable();
         this.field_.set(var1, var2);
         this.onChanged();
      } else {
         this.fieldBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setField(int var1, DescriptorProtos$FieldDescriptorProto$Builder var2) {
      if(this.fieldBuilder_ == null) {
         this.ensureFieldIsMutable();
         this.field_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.fieldBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addField(DescriptorProtos$FieldDescriptorProto var1) {
      if(this.fieldBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureFieldIsMutable();
         this.field_.add(var1);
         this.onChanged();
      } else {
         this.fieldBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addField(int var1, DescriptorProtos$FieldDescriptorProto var2) {
      if(this.fieldBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureFieldIsMutable();
         this.field_.add(var1, var2);
         this.onChanged();
      } else {
         this.fieldBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addField(DescriptorProtos$FieldDescriptorProto$Builder var1) {
      if(this.fieldBuilder_ == null) {
         this.ensureFieldIsMutable();
         this.field_.add(var1.build());
         this.onChanged();
      } else {
         this.fieldBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addField(int var1, DescriptorProtos$FieldDescriptorProto$Builder var2) {
      if(this.fieldBuilder_ == null) {
         this.ensureFieldIsMutable();
         this.field_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.fieldBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllField(Iterable var1) {
      if(this.fieldBuilder_ == null) {
         this.ensureFieldIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.field_);
         this.onChanged();
      } else {
         this.fieldBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearField() {
      if(this.fieldBuilder_ == null) {
         this.field_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.fieldBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeField(int var1) {
      if(this.fieldBuilder_ == null) {
         this.ensureFieldIsMutable();
         this.field_.remove(var1);
         this.onChanged();
      } else {
         this.fieldBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder getFieldBuilder(int var1) {
      return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int var1) {
      return this.fieldBuilder_ == null?(DescriptorProtos$FieldDescriptorProtoOrBuilder)this.field_.get(var1):(DescriptorProtos$FieldDescriptorProtoOrBuilder)this.fieldBuilder_.getMessageOrBuilder(var1);
   }

   public List getFieldOrBuilderList() {
      return this.fieldBuilder_ != null?this.fieldBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.field_);
   }

   public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder() {
      return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().addBuilder(DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder(int var1) {
      return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().addBuilder(var1, DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
   }

   public List getFieldBuilderList() {
      return this.getFieldFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getFieldFieldBuilder() {
      if(this.fieldBuilder_ == null) {
         this.fieldBuilder_ = new RepeatedFieldBuilder(this.field_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.field_ = null;
      }

      return this.fieldBuilder_;
   }

   private void ensureExtensionIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.extension_ = new ArrayList(this.extension_);
         this.bitField0_ |= 4;
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

   public DescriptorProtos$DescriptorProto$Builder setExtension(int var1, DescriptorProtos$FieldDescriptorProto var2) {
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

   public DescriptorProtos$DescriptorProto$Builder setExtension(int var1, DescriptorProtos$FieldDescriptorProto$Builder var2) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.extensionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto var1) {
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

   public DescriptorProtos$DescriptorProto$Builder addExtension(int var1, DescriptorProtos$FieldDescriptorProto var2) {
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

   public DescriptorProtos$DescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto$Builder var1) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.add(var1.build());
         this.onChanged();
      } else {
         this.extensionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addExtension(int var1, DescriptorProtos$FieldDescriptorProto$Builder var2) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         this.extension_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.extensionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllExtension(Iterable var1) {
      if(this.extensionBuilder_ == null) {
         this.ensureExtensionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.extension_);
         this.onChanged();
      } else {
         this.extensionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearExtension() {
      if(this.extensionBuilder_ == null) {
         this.extension_ = Collections.emptyList();
         this.bitField0_ &= -5;
         this.onChanged();
      } else {
         this.extensionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeExtension(int var1) {
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
         this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
         this.extension_ = null;
      }

      return this.extensionBuilder_;
   }

   private void ensureNestedTypeIsMutable() {
      if((this.bitField0_ & 8) != 8) {
         this.nestedType_ = new ArrayList(this.nestedType_);
         this.bitField0_ |= 8;
      }

   }

   public List getNestedTypeList() {
      return this.nestedTypeBuilder_ == null?Collections.unmodifiableList(this.nestedType_):this.nestedTypeBuilder_.getMessageList();
   }

   public int getNestedTypeCount() {
      return this.nestedTypeBuilder_ == null?this.nestedType_.size():this.nestedTypeBuilder_.getCount();
   }

   public DescriptorProtos$DescriptorProto getNestedType(int var1) {
      return this.nestedTypeBuilder_ == null?(DescriptorProtos$DescriptorProto)this.nestedType_.get(var1):(DescriptorProtos$DescriptorProto)this.nestedTypeBuilder_.getMessage(var1);
   }

   public DescriptorProtos$DescriptorProto$Builder setNestedType(int var1, DescriptorProtos$DescriptorProto var2) {
      if(this.nestedTypeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureNestedTypeIsMutable();
         this.nestedType_.set(var1, var2);
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setNestedType(int var1, DescriptorProtos$DescriptorProto$Builder var2) {
      if(this.nestedTypeBuilder_ == null) {
         this.ensureNestedTypeIsMutable();
         this.nestedType_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addNestedType(DescriptorProtos$DescriptorProto var1) {
      if(this.nestedTypeBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureNestedTypeIsMutable();
         this.nestedType_.add(var1);
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addNestedType(int var1, DescriptorProtos$DescriptorProto var2) {
      if(this.nestedTypeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureNestedTypeIsMutable();
         this.nestedType_.add(var1, var2);
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addNestedType(DescriptorProtos$DescriptorProto$Builder var1) {
      if(this.nestedTypeBuilder_ == null) {
         this.ensureNestedTypeIsMutable();
         this.nestedType_.add(var1.build());
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addNestedType(int var1, DescriptorProtos$DescriptorProto$Builder var2) {
      if(this.nestedTypeBuilder_ == null) {
         this.ensureNestedTypeIsMutable();
         this.nestedType_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllNestedType(Iterable var1) {
      if(this.nestedTypeBuilder_ == null) {
         this.ensureNestedTypeIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.nestedType_);
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearNestedType() {
      if(this.nestedTypeBuilder_ == null) {
         this.nestedType_ = Collections.emptyList();
         this.bitField0_ &= -9;
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeNestedType(int var1) {
      if(this.nestedTypeBuilder_ == null) {
         this.ensureNestedTypeIsMutable();
         this.nestedType_.remove(var1);
         this.onChanged();
      } else {
         this.nestedTypeBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder getNestedTypeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int var1) {
      return this.nestedTypeBuilder_ == null?(DescriptorProtos$DescriptorProtoOrBuilder)this.nestedType_.get(var1):(DescriptorProtos$DescriptorProtoOrBuilder)this.nestedTypeBuilder_.getMessageOrBuilder(var1);
   }

   public List getNestedTypeOrBuilderList() {
      return this.nestedTypeBuilder_ != null?this.nestedTypeBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.nestedType_);
   }

   public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder() {
      return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().addBuilder(var1, DescriptorProtos$DescriptorProto.getDefaultInstance());
   }

   public List getNestedTypeBuilderList() {
      return this.getNestedTypeFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getNestedTypeFieldBuilder() {
      if(this.nestedTypeBuilder_ == null) {
         this.nestedTypeBuilder_ = new RepeatedFieldBuilder(this.nestedType_, (this.bitField0_ & 8) == 8, this.getParentForChildren(), this.isClean());
         this.nestedType_ = null;
      }

      return this.nestedTypeBuilder_;
   }

   private void ensureEnumTypeIsMutable() {
      if((this.bitField0_ & 16) != 16) {
         this.enumType_ = new ArrayList(this.enumType_);
         this.bitField0_ |= 16;
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

   public DescriptorProtos$DescriptorProto$Builder setEnumType(int var1, DescriptorProtos$EnumDescriptorProto var2) {
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

   public DescriptorProtos$DescriptorProto$Builder setEnumType(int var1, DescriptorProtos$EnumDescriptorProto$Builder var2) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.enumTypeBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto var1) {
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

   public DescriptorProtos$DescriptorProto$Builder addEnumType(int var1, DescriptorProtos$EnumDescriptorProto var2) {
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

   public DescriptorProtos$DescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto$Builder var1) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.add(var1.build());
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addEnumType(int var1, DescriptorProtos$EnumDescriptorProto$Builder var2) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         this.enumType_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllEnumType(Iterable var1) {
      if(this.enumTypeBuilder_ == null) {
         this.ensureEnumTypeIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.enumType_);
         this.onChanged();
      } else {
         this.enumTypeBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearEnumType() {
      if(this.enumTypeBuilder_ == null) {
         this.enumType_ = Collections.emptyList();
         this.bitField0_ &= -17;
         this.onChanged();
      } else {
         this.enumTypeBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeEnumType(int var1) {
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
         this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 16) == 16, this.getParentForChildren(), this.isClean());
         this.enumType_ = null;
      }

      return this.enumTypeBuilder_;
   }

   private void ensureExtensionRangeIsMutable() {
      if((this.bitField0_ & 32) != 32) {
         this.extensionRange_ = new ArrayList(this.extensionRange_);
         this.bitField0_ |= 32;
      }

   }

   public List getExtensionRangeList() {
      return this.extensionRangeBuilder_ == null?Collections.unmodifiableList(this.extensionRange_):this.extensionRangeBuilder_.getMessageList();
   }

   public int getExtensionRangeCount() {
      return this.extensionRangeBuilder_ == null?this.extensionRange_.size():this.extensionRangeBuilder_.getCount();
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int var1) {
      return this.extensionRangeBuilder_ == null?(DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRange_.get(var1):(DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRangeBuilder_.getMessage(var1);
   }

   public DescriptorProtos$DescriptorProto$Builder setExtensionRange(int var1, DescriptorProtos$DescriptorProto$ExtensionRange var2) {
      if(this.extensionRangeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.set(var1, var2);
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setExtensionRange(int var1, DescriptorProtos$DescriptorProto$ExtensionRange$Builder var2) {
      if(this.extensionRangeBuilder_ == null) {
         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange var1) {
      if(this.extensionRangeBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.add(var1);
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addExtensionRange(int var1, DescriptorProtos$DescriptorProto$ExtensionRange var2) {
      if(this.extensionRangeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.add(var1, var2);
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange$Builder var1) {
      if(this.extensionRangeBuilder_ == null) {
         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.add(var1.build());
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addExtensionRange(int var1, DescriptorProtos$DescriptorProto$ExtensionRange$Builder var2) {
      if(this.extensionRangeBuilder_ == null) {
         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllExtensionRange(Iterable var1) {
      if(this.extensionRangeBuilder_ == null) {
         this.ensureExtensionRangeIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.extensionRange_);
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearExtensionRange() {
      if(this.extensionRangeBuilder_ == null) {
         this.extensionRange_ = Collections.emptyList();
         this.bitField0_ &= -33;
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeExtensionRange(int var1) {
      if(this.extensionRangeBuilder_ == null) {
         this.ensureExtensionRangeIsMutable();
         this.extensionRange_.remove(var1);
         this.onChanged();
      } else {
         this.extensionRangeBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder getExtensionRangeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int var1) {
      return this.extensionRangeBuilder_ == null?(DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRange_.get(var1):(DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRangeBuilder_.getMessageOrBuilder(var1);
   }

   public List getExtensionRangeOrBuilderList() {
      return this.extensionRangeBuilder_ != null?this.extensionRangeBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.extensionRange_);
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder() {
      return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance());
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().addBuilder(var1, DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance());
   }

   public List getExtensionRangeBuilderList() {
      return this.getExtensionRangeFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getExtensionRangeFieldBuilder() {
      if(this.extensionRangeBuilder_ == null) {
         this.extensionRangeBuilder_ = new RepeatedFieldBuilder(this.extensionRange_, (this.bitField0_ & 32) == 32, this.getParentForChildren(), this.isClean());
         this.extensionRange_ = null;
      }

      return this.extensionRangeBuilder_;
   }

   private void ensureOneofDeclIsMutable() {
      if((this.bitField0_ & 64) != 64) {
         this.oneofDecl_ = new ArrayList(this.oneofDecl_);
         this.bitField0_ |= 64;
      }

   }

   public List getOneofDeclList() {
      return this.oneofDeclBuilder_ == null?Collections.unmodifiableList(this.oneofDecl_):this.oneofDeclBuilder_.getMessageList();
   }

   public int getOneofDeclCount() {
      return this.oneofDeclBuilder_ == null?this.oneofDecl_.size():this.oneofDeclBuilder_.getCount();
   }

   public DescriptorProtos$OneofDescriptorProto getOneofDecl(int var1) {
      return this.oneofDeclBuilder_ == null?(DescriptorProtos$OneofDescriptorProto)this.oneofDecl_.get(var1):(DescriptorProtos$OneofDescriptorProto)this.oneofDeclBuilder_.getMessage(var1);
   }

   public DescriptorProtos$DescriptorProto$Builder setOneofDecl(int var1, DescriptorProtos$OneofDescriptorProto var2) {
      if(this.oneofDeclBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.set(var1, var2);
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setOneofDecl(int var1, DescriptorProtos$OneofDescriptorProto$Builder var2) {
      if(this.oneofDeclBuilder_ == null) {
         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addOneofDecl(DescriptorProtos$OneofDescriptorProto var1) {
      if(this.oneofDeclBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.add(var1);
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addOneofDecl(int var1, DescriptorProtos$OneofDescriptorProto var2) {
      if(this.oneofDeclBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.add(var1, var2);
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addOneofDecl(DescriptorProtos$OneofDescriptorProto$Builder var1) {
      if(this.oneofDeclBuilder_ == null) {
         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.add(var1.build());
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addOneofDecl(int var1, DescriptorProtos$OneofDescriptorProto$Builder var2) {
      if(this.oneofDeclBuilder_ == null) {
         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllOneofDecl(Iterable var1) {
      if(this.oneofDeclBuilder_ == null) {
         this.ensureOneofDeclIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.oneofDecl_);
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearOneofDecl() {
      if(this.oneofDeclBuilder_ == null) {
         this.oneofDecl_ = Collections.emptyList();
         this.bitField0_ &= -65;
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeOneofDecl(int var1) {
      if(this.oneofDeclBuilder_ == null) {
         this.ensureOneofDeclIsMutable();
         this.oneofDecl_.remove(var1);
         this.onChanged();
      } else {
         this.oneofDeclBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$OneofDescriptorProto$Builder getOneofDeclBuilder(int var1) {
      return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int var1) {
      return this.oneofDeclBuilder_ == null?(DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(var1):(DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDeclBuilder_.getMessageOrBuilder(var1);
   }

   public List getOneofDeclOrBuilderList() {
      return this.oneofDeclBuilder_ != null?this.oneofDeclBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.oneofDecl_);
   }

   public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder() {
      return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().addBuilder(DescriptorProtos$OneofDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder(int var1) {
      return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().addBuilder(var1, DescriptorProtos$OneofDescriptorProto.getDefaultInstance());
   }

   public List getOneofDeclBuilderList() {
      return this.getOneofDeclFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getOneofDeclFieldBuilder() {
      if(this.oneofDeclBuilder_ == null) {
         this.oneofDeclBuilder_ = new RepeatedFieldBuilder(this.oneofDecl_, (this.bitField0_ & 64) == 64, this.getParentForChildren(), this.isClean());
         this.oneofDecl_ = null;
      }

      return this.oneofDeclBuilder_;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 128) == 128;
   }

   public DescriptorProtos$MessageOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$MessageOptions.getDefaultInstance():this.options_):(DescriptorProtos$MessageOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$DescriptorProto$Builder setOptions(DescriptorProtos$MessageOptions var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.options_ = var1;
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 128;
      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setOptions(DescriptorProtos$MessageOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 128;
      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder mergeOptions(DescriptorProtos$MessageOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 128) == 128 && this.options_ != null && this.options_ != DescriptorProtos$MessageOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$MessageOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
         } else {
            this.options_ = var1;
         }

         this.onChanged();
      } else {
         this.optionsBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 128;
      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -129;
      return this;
   }

   public DescriptorProtos$MessageOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 128;
      this.onChanged();
      return (DescriptorProtos$MessageOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$MessageOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$MessageOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$MessageOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   private void ensureReservedRangeIsMutable() {
      if((this.bitField0_ & 256) != 256) {
         this.reservedRange_ = new ArrayList(this.reservedRange_);
         this.bitField0_ |= 256;
      }

   }

   public List getReservedRangeList() {
      return this.reservedRangeBuilder_ == null?Collections.unmodifiableList(this.reservedRange_):this.reservedRangeBuilder_.getMessageList();
   }

   public int getReservedRangeCount() {
      return this.reservedRangeBuilder_ == null?this.reservedRange_.size():this.reservedRangeBuilder_.getCount();
   }

   public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int var1) {
      return this.reservedRangeBuilder_ == null?(DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRange_.get(var1):(DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRangeBuilder_.getMessage(var1);
   }

   public DescriptorProtos$DescriptorProto$Builder setReservedRange(int var1, DescriptorProtos$DescriptorProto$ReservedRange var2) {
      if(this.reservedRangeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureReservedRangeIsMutable();
         this.reservedRange_.set(var1, var2);
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder setReservedRange(int var1, DescriptorProtos$DescriptorProto$ReservedRange$Builder var2) {
      if(this.reservedRangeBuilder_ == null) {
         this.ensureReservedRangeIsMutable();
         this.reservedRange_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addReservedRange(DescriptorProtos$DescriptorProto$ReservedRange var1) {
      if(this.reservedRangeBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureReservedRangeIsMutable();
         this.reservedRange_.add(var1);
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addReservedRange(int var1, DescriptorProtos$DescriptorProto$ReservedRange var2) {
      if(this.reservedRangeBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureReservedRangeIsMutable();
         this.reservedRange_.add(var1, var2);
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addReservedRange(DescriptorProtos$DescriptorProto$ReservedRange$Builder var1) {
      if(this.reservedRangeBuilder_ == null) {
         this.ensureReservedRangeIsMutable();
         this.reservedRange_.add(var1.build());
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addReservedRange(int var1, DescriptorProtos$DescriptorProto$ReservedRange$Builder var2) {
      if(this.reservedRangeBuilder_ == null) {
         this.ensureReservedRangeIsMutable();
         this.reservedRange_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addAllReservedRange(Iterable var1) {
      if(this.reservedRangeBuilder_ == null) {
         this.ensureReservedRangeIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.reservedRange_);
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearReservedRange() {
      if(this.reservedRangeBuilder_ == null) {
         this.reservedRange_ = Collections.emptyList();
         this.bitField0_ &= -257;
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder removeReservedRange(int var1) {
      if(this.reservedRangeBuilder_ == null) {
         this.ensureReservedRangeIsMutable();
         this.reservedRange_.remove(var1);
         this.onChanged();
      } else {
         this.reservedRangeBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder getReservedRangeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int var1) {
      return this.reservedRangeBuilder_ == null?(DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRange_.get(var1):(DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRangeBuilder_.getMessageOrBuilder(var1);
   }

   public List getReservedRangeOrBuilderList() {
      return this.reservedRangeBuilder_ != null?this.reservedRangeBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.reservedRange_);
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder() {
      return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance());
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder(int var1) {
      return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().addBuilder(var1, DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance());
   }

   public List getReservedRangeBuilderList() {
      return this.getReservedRangeFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getReservedRangeFieldBuilder() {
      if(this.reservedRangeBuilder_ == null) {
         this.reservedRangeBuilder_ = new RepeatedFieldBuilder(this.reservedRange_, (this.bitField0_ & 256) == 256, this.getParentForChildren(), this.isClean());
         this.reservedRange_ = null;
      }

      return this.reservedRangeBuilder_;
   }

   private void ensureReservedNameIsMutable() {
      if((this.bitField0_ & 512) != 512) {
         this.reservedName_ = new LazyStringArrayList(this.reservedName_);
         this.bitField0_ |= 512;
      }

   }

   public ProtocolStringList getReservedNameList() {
      return this.reservedName_.getUnmodifiableView();
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

   public DescriptorProtos$DescriptorProto$Builder setReservedName(int var1, String var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensureReservedNameIsMutable();
         this.reservedName_.set(var1, (Object)var2);
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$DescriptorProto$Builder addReservedName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureReservedNameIsMutable();
         this.reservedName_.add((Object)var1);
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$DescriptorProto$Builder addAllReservedName(Iterable var1) {
      this.ensureReservedNameIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.reservedName_);
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder clearReservedName() {
      this.reservedName_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -513;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$Builder addReservedNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureReservedNameIsMutable();
         this.reservedName_.add(var1);
         this.onChanged();
         return this;
      }
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
