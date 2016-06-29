package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.SingleFieldBuilder;

public final class DescriptorProtos$FieldDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private int number_;
   private int label_;
   private int type_;
   private Object typeName_;
   private Object extendee_;
   private Object defaultValue_;
   private int oneofIndex_;
   private DescriptorProtos$FieldOptions options_;
   private SingleFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$6100();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$6200().ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
   }

   private DescriptorProtos$FieldDescriptorProto$Builder() {
      this.name_ = "";
      this.label_ = 1;
      this.type_ = 1;
      this.typeName_ = "";
      this.extendee_ = "";
      this.defaultValue_ = "";
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.label_ = 1;
      this.type_ = 1;
      this.typeName_ = "";
      this.extendee_ = "";
      this.defaultValue_ = "";
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getOptionsFieldBuilder();
      }

   }

   public DescriptorProtos$FieldDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      this.number_ = 0;
      this.bitField0_ &= -3;
      this.label_ = 1;
      this.bitField0_ &= -5;
      this.type_ = 1;
      this.bitField0_ &= -9;
      this.typeName_ = "";
      this.bitField0_ &= -17;
      this.extendee_ = "";
      this.bitField0_ &= -33;
      this.defaultValue_ = "";
      this.bitField0_ &= -65;
      this.oneofIndex_ = 0;
      this.bitField0_ &= -129;
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -257;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$6100();
   }

   public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$FieldDescriptorProto build() {
      DescriptorProtos$FieldDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$FieldDescriptorProto buildPartial() {
      DescriptorProtos$FieldDescriptorProto var1 = new DescriptorProtos$FieldDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$FieldDescriptorProto.access$6602(var1, this.name_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$FieldDescriptorProto.access$6702(var1, this.number_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      DescriptorProtos$FieldDescriptorProto.access$6802(var1, this.label_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      DescriptorProtos$FieldDescriptorProto.access$6902(var1, this.type_);
      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      DescriptorProtos$FieldDescriptorProto.access$7002(var1, this.typeName_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      DescriptorProtos$FieldDescriptorProto.access$7102(var1, this.extendee_);
      if((var2 & 64) == 64) {
         var3 |= 64;
      }

      DescriptorProtos$FieldDescriptorProto.access$7202(var1, this.defaultValue_);
      if((var2 & 128) == 128) {
         var3 |= 128;
      }

      DescriptorProtos$FieldDescriptorProto.access$7302(var1, this.oneofIndex_);
      if((var2 & 256) == 256) {
         var3 |= 256;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$FieldDescriptorProto.access$7402(var1, this.options_);
      } else {
         DescriptorProtos$FieldDescriptorProto.access$7402(var1, (DescriptorProtos$FieldOptions)this.optionsBuilder_.build());
      }

      DescriptorProtos$FieldDescriptorProto.access$7502(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$FieldDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$FieldDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(DescriptorProtos$FieldDescriptorProto var1) {
      if(var1 == DescriptorProtos$FieldDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$FieldDescriptorProto.access$6600(var1);
            this.onChanged();
         }

         if(var1.hasNumber()) {
            this.setNumber(var1.getNumber());
         }

         if(var1.hasLabel()) {
            this.setLabel(var1.getLabel());
         }

         if(var1.hasType()) {
            this.setType(var1.getType());
         }

         if(var1.hasTypeName()) {
            this.bitField0_ |= 16;
            this.typeName_ = DescriptorProtos$FieldDescriptorProto.access$7000(var1);
            this.onChanged();
         }

         if(var1.hasExtendee()) {
            this.bitField0_ |= 32;
            this.extendee_ = DescriptorProtos$FieldDescriptorProto.access$7100(var1);
            this.onChanged();
         }

         if(var1.hasDefaultValue()) {
            this.bitField0_ |= 64;
            this.defaultValue_ = DescriptorProtos$FieldDescriptorProto.access$7200(var1);
            this.onChanged();
         }

         if(var1.hasOneofIndex()) {
            this.setOneofIndex(var1.getOneofIndex());
         }

         if(var1.hasOptions()) {
            this.mergeOptions(var1.getOptions());
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasOptions() || this.getOptions().isInitialized();
   }

   public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$FieldDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$FieldDescriptorProto)var9.getUnfinishedMessage();
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

   public DescriptorProtos$FieldDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasNumber() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getNumber() {
      return this.number_;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setNumber(int var1) {
      this.bitField0_ |= 2;
      this.number_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearNumber() {
      this.bitField0_ &= -3;
      this.number_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasLabel() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
      DescriptorProtos$FieldDescriptorProto$Label var1 = DescriptorProtos$FieldDescriptorProto$Label.valueOf(this.label_);
      return var1 == null?DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL:var1;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setLabel(DescriptorProtos$FieldDescriptorProto$Label var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.label_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearLabel() {
      this.bitField0_ &= -5;
      this.label_ = 1;
      this.onChanged();
      return this;
   }

   public boolean hasType() {
      return (this.bitField0_ & 8) == 8;
   }

   public DescriptorProtos$FieldDescriptorProto$Type getType() {
      DescriptorProtos$FieldDescriptorProto$Type var1 = DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.type_);
      return var1 == null?DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE:var1;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setType(DescriptorProtos$FieldDescriptorProto$Type var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.type_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearType() {
      this.bitField0_ &= -9;
      this.type_ = 1;
      this.onChanged();
      return this;
   }

   public boolean hasTypeName() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getTypeName() {
      Object var1 = this.typeName_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.typeName_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getTypeNameBytes() {
      Object var1 = this.typeName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.typeName_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setTypeName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 16;
         this.typeName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearTypeName() {
      this.bitField0_ &= -17;
      this.typeName_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getTypeName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setTypeNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 16;
         this.typeName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasExtendee() {
      return (this.bitField0_ & 32) == 32;
   }

   public String getExtendee() {
      Object var1 = this.extendee_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.extendee_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getExtendeeBytes() {
      Object var1 = this.extendee_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.extendee_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setExtendee(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.extendee_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearExtendee() {
      this.bitField0_ &= -33;
      this.extendee_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getExtendee();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setExtendeeBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.extendee_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasDefaultValue() {
      return (this.bitField0_ & 64) == 64;
   }

   public String getDefaultValue() {
      Object var1 = this.defaultValue_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.defaultValue_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getDefaultValueBytes() {
      Object var1 = this.defaultValue_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.defaultValue_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValue(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 64;
         this.defaultValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearDefaultValue() {
      this.bitField0_ &= -65;
      this.defaultValue_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getDefaultValue();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValueBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 64;
         this.defaultValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasOneofIndex() {
      return (this.bitField0_ & 128) == 128;
   }

   public int getOneofIndex() {
      return this.oneofIndex_;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setOneofIndex(int var1) {
      this.bitField0_ |= 128;
      this.oneofIndex_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearOneofIndex() {
      this.bitField0_ &= -129;
      this.oneofIndex_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 256) == 256;
   }

   public DescriptorProtos$FieldOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$FieldOptions.getDefaultInstance():this.options_):(DescriptorProtos$FieldOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setOptions(DescriptorProtos$FieldOptions var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.options_ = var1;
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 256;
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder setOptions(DescriptorProtos$FieldOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 256;
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder mergeOptions(DescriptorProtos$FieldOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 256) == 256 && this.options_ != null && this.options_ != DescriptorProtos$FieldOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$FieldOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
         } else {
            this.options_ = var1;
         }

         this.onChanged();
      } else {
         this.optionsBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 256;
      return this;
   }

   public DescriptorProtos$FieldDescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -257;
      return this;
   }

   public DescriptorProtos$FieldOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 256;
      this.onChanged();
      return (DescriptorProtos$FieldOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$FieldOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$FieldOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$FieldOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$FieldDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
