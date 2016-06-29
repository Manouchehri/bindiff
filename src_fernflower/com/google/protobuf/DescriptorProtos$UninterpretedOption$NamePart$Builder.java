package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

public final class DescriptorProtos$UninterpretedOption$NamePart$Builder extends GeneratedMessage$Builder implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
   private int bitField0_;
   private Object namePart_;
   private boolean isExtension_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$21500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$21600().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
   }

   private DescriptorProtos$UninterpretedOption$NamePart$Builder() {
      this.namePart_ = "";
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.namePart_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder clear() {
      super.clear();
      this.namePart_ = "";
      this.bitField0_ &= -2;
      this.isExtension_ = false;
      this.bitField0_ &= -3;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$21500();
   }

   public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
      return DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
   }

   public DescriptorProtos$UninterpretedOption$NamePart build() {
      DescriptorProtos$UninterpretedOption$NamePart var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$UninterpretedOption$NamePart buildPartial() {
      DescriptorProtos$UninterpretedOption$NamePart var1 = new DescriptorProtos$UninterpretedOption$NamePart(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$UninterpretedOption$NamePart.access$22002(var1, this.namePart_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$UninterpretedOption$NamePart.access$22102(var1, this.isExtension_);
      DescriptorProtos$UninterpretedOption$NamePart.access$22202(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$UninterpretedOption$NamePart) {
         return this.mergeFrom((DescriptorProtos$UninterpretedOption$NamePart)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(DescriptorProtos$UninterpretedOption$NamePart var1) {
      if(var1 == DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasNamePart()) {
            this.bitField0_ |= 1;
            this.namePart_ = DescriptorProtos$UninterpretedOption$NamePart.access$22000(var1);
            this.onChanged();
         }

         if(var1.hasIsExtension()) {
            this.setIsExtension(var1.getIsExtension());
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasNamePart()?false:this.hasIsExtension();
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$UninterpretedOption$NamePart var3 = null;

      try {
         var3 = (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$UninterpretedOption$NamePart)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasNamePart() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getNamePart() {
      Object var1 = this.namePart_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.namePart_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getNamePartBytes() {
      Object var1 = this.namePart_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.namePart_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePart(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.namePart_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder clearNamePart() {
      this.bitField0_ &= -2;
      this.namePart_ = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance().getNamePart();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePartBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.namePart_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasIsExtension() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getIsExtension() {
      return this.isExtension_;
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder setIsExtension(boolean var1) {
      this.bitField0_ |= 2;
      this.isExtension_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder clearIsExtension() {
      this.bitField0_ &= -3;
      this.isExtension_ = false;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption$NamePart$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
