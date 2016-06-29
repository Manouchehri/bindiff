package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$FileOptionsOrBuilder {
   private int bitField0_;
   private Object javaPackage_;
   private Object javaOuterClassname_;
   private boolean javaMultipleFiles_;
   private boolean javaGenerateEqualsAndHash_;
   private boolean javaStringCheckUtf8_;
   private int optimizeFor_;
   private Object goPackage_;
   private boolean ccGenericServices_;
   private boolean javaGenericServices_;
   private boolean pyGenericServices_;
   private boolean deprecated_;
   private boolean ccEnableArenas_;
   private Object objcClassPrefix_;
   private Object csharpNamespace_;
   private List uninterpretedOption_;
   private RepeatedFieldBuilder uninterpretedOptionBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$12800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$12900().ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
   }

   private DescriptorProtos$FileOptions$Builder() {
      this.javaPackage_ = "";
      this.javaOuterClassname_ = "";
      this.optimizeFor_ = 1;
      this.goPackage_ = "";
      this.objcClassPrefix_ = "";
      this.csharpNamespace_ = "";
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$FileOptions$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.javaPackage_ = "";
      this.javaOuterClassname_ = "";
      this.optimizeFor_ = 1;
      this.goPackage_ = "";
      this.objcClassPrefix_ = "";
      this.csharpNamespace_ = "";
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getUninterpretedOptionFieldBuilder();
      }

   }

   public DescriptorProtos$FileOptions$Builder clear() {
      super.clear();
      this.javaPackage_ = "";
      this.bitField0_ &= -2;
      this.javaOuterClassname_ = "";
      this.bitField0_ &= -3;
      this.javaMultipleFiles_ = false;
      this.bitField0_ &= -5;
      this.javaGenerateEqualsAndHash_ = false;
      this.bitField0_ &= -9;
      this.javaStringCheckUtf8_ = false;
      this.bitField0_ &= -17;
      this.optimizeFor_ = 1;
      this.bitField0_ &= -33;
      this.goPackage_ = "";
      this.bitField0_ &= -65;
      this.ccGenericServices_ = false;
      this.bitField0_ &= -129;
      this.javaGenericServices_ = false;
      this.bitField0_ &= -257;
      this.pyGenericServices_ = false;
      this.bitField0_ &= -513;
      this.deprecated_ = false;
      this.bitField0_ &= -1025;
      this.ccEnableArenas_ = false;
      this.bitField0_ &= -2049;
      this.objcClassPrefix_ = "";
      this.bitField0_ &= -4097;
      this.csharpNamespace_ = "";
      this.bitField0_ &= -8193;
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -16385;
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$12800();
   }

   public DescriptorProtos$FileOptions getDefaultInstanceForType() {
      return DescriptorProtos$FileOptions.getDefaultInstance();
   }

   public DescriptorProtos$FileOptions build() {
      DescriptorProtos$FileOptions var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$FileOptions buildPartial() {
      DescriptorProtos$FileOptions var1 = new DescriptorProtos$FileOptions(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$FileOptions.access$13302(var1, this.javaPackage_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$FileOptions.access$13402(var1, this.javaOuterClassname_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      DescriptorProtos$FileOptions.access$13502(var1, this.javaMultipleFiles_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      DescriptorProtos$FileOptions.access$13602(var1, this.javaGenerateEqualsAndHash_);
      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      DescriptorProtos$FileOptions.access$13702(var1, this.javaStringCheckUtf8_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      DescriptorProtos$FileOptions.access$13802(var1, this.optimizeFor_);
      if((var2 & 64) == 64) {
         var3 |= 64;
      }

      DescriptorProtos$FileOptions.access$13902(var1, this.goPackage_);
      if((var2 & 128) == 128) {
         var3 |= 128;
      }

      DescriptorProtos$FileOptions.access$14002(var1, this.ccGenericServices_);
      if((var2 & 256) == 256) {
         var3 |= 256;
      }

      DescriptorProtos$FileOptions.access$14102(var1, this.javaGenericServices_);
      if((var2 & 512) == 512) {
         var3 |= 512;
      }

      DescriptorProtos$FileOptions.access$14202(var1, this.pyGenericServices_);
      if((var2 & 1024) == 1024) {
         var3 |= 1024;
      }

      DescriptorProtos$FileOptions.access$14302(var1, this.deprecated_);
      if((var2 & 2048) == 2048) {
         var3 |= 2048;
      }

      DescriptorProtos$FileOptions.access$14402(var1, this.ccEnableArenas_);
      if((var2 & 4096) == 4096) {
         var3 |= 4096;
      }

      DescriptorProtos$FileOptions.access$14502(var1, this.objcClassPrefix_);
      if((var2 & 8192) == 8192) {
         var3 |= 8192;
      }

      DescriptorProtos$FileOptions.access$14602(var1, this.csharpNamespace_);
      if(this.uninterpretedOptionBuilder_ == null) {
         if((this.bitField0_ & 16384) == 16384) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            this.bitField0_ &= -16385;
         }

         DescriptorProtos$FileOptions.access$14702(var1, this.uninterpretedOption_);
      } else {
         DescriptorProtos$FileOptions.access$14702(var1, this.uninterpretedOptionBuilder_.build());
      }

      DescriptorProtos$FileOptions.access$14802(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$FileOptions$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$FileOptions) {
         return this.mergeFrom((DescriptorProtos$FileOptions)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder mergeFrom(DescriptorProtos$FileOptions var1) {
      if(var1 == DescriptorProtos$FileOptions.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasJavaPackage()) {
            this.bitField0_ |= 1;
            this.javaPackage_ = DescriptorProtos$FileOptions.access$13300(var1);
            this.onChanged();
         }

         if(var1.hasJavaOuterClassname()) {
            this.bitField0_ |= 2;
            this.javaOuterClassname_ = DescriptorProtos$FileOptions.access$13400(var1);
            this.onChanged();
         }

         if(var1.hasJavaMultipleFiles()) {
            this.setJavaMultipleFiles(var1.getJavaMultipleFiles());
         }

         if(var1.hasJavaGenerateEqualsAndHash()) {
            this.setJavaGenerateEqualsAndHash(var1.getJavaGenerateEqualsAndHash());
         }

         if(var1.hasJavaStringCheckUtf8()) {
            this.setJavaStringCheckUtf8(var1.getJavaStringCheckUtf8());
         }

         if(var1.hasOptimizeFor()) {
            this.setOptimizeFor(var1.getOptimizeFor());
         }

         if(var1.hasGoPackage()) {
            this.bitField0_ |= 64;
            this.goPackage_ = DescriptorProtos$FileOptions.access$13900(var1);
            this.onChanged();
         }

         if(var1.hasCcGenericServices()) {
            this.setCcGenericServices(var1.getCcGenericServices());
         }

         if(var1.hasJavaGenericServices()) {
            this.setJavaGenericServices(var1.getJavaGenericServices());
         }

         if(var1.hasPyGenericServices()) {
            this.setPyGenericServices(var1.getPyGenericServices());
         }

         if(var1.hasDeprecated()) {
            this.setDeprecated(var1.getDeprecated());
         }

         if(var1.hasCcEnableArenas()) {
            this.setCcEnableArenas(var1.getCcEnableArenas());
         }

         if(var1.hasObjcClassPrefix()) {
            this.bitField0_ |= 4096;
            this.objcClassPrefix_ = DescriptorProtos$FileOptions.access$14500(var1);
            this.onChanged();
         }

         if(var1.hasCsharpNamespace()) {
            this.bitField0_ |= 8192;
            this.csharpNamespace_ = DescriptorProtos$FileOptions.access$14600(var1);
            this.onChanged();
         }

         if(this.uninterpretedOptionBuilder_ == null) {
            if(!DescriptorProtos$FileOptions.access$14700(var1).isEmpty()) {
               if(this.uninterpretedOption_.isEmpty()) {
                  this.uninterpretedOption_ = DescriptorProtos$FileOptions.access$14700(var1);
                  this.bitField0_ &= -16385;
               } else {
                  this.ensureUninterpretedOptionIsMutable();
                  this.uninterpretedOption_.addAll(DescriptorProtos$FileOptions.access$14700(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FileOptions.access$14700(var1).isEmpty()) {
            if(this.uninterpretedOptionBuilder_.isEmpty()) {
               this.uninterpretedOptionBuilder_.dispose();
               this.uninterpretedOptionBuilder_ = null;
               this.uninterpretedOption_ = DescriptorProtos$FileOptions.access$14700(var1);
               this.bitField0_ &= -16385;
               this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getUninterpretedOptionFieldBuilder():null;
            } else {
               this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$FileOptions.access$14700(var1));
            }
         }

         this.mergeExtensionFields(var1);
         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      for(int var1 = 0; var1 < this.getUninterpretedOptionCount(); ++var1) {
         if(!this.getUninterpretedOption(var1).isInitialized()) {
            return false;
         }
      }

      if(!this.extensionsAreInitialized()) {
         return false;
      } else {
         return true;
      }
   }

   public DescriptorProtos$FileOptions$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$FileOptions var3 = null;

      try {
         var3 = (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$FileOptions)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasJavaPackage() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getJavaPackage() {
      Object var1 = this.javaPackage_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.javaPackage_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getJavaPackageBytes() {
      Object var1 = this.javaPackage_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.javaPackage_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FileOptions$Builder setJavaPackage(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.javaPackage_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder clearJavaPackage() {
      this.bitField0_ &= -2;
      this.javaPackage_ = DescriptorProtos$FileOptions.getDefaultInstance().getJavaPackage();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder setJavaPackageBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.javaPackage_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasJavaOuterClassname() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getJavaOuterClassname() {
      Object var1 = this.javaOuterClassname_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.javaOuterClassname_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getJavaOuterClassnameBytes() {
      Object var1 = this.javaOuterClassname_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.javaOuterClassname_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FileOptions$Builder setJavaOuterClassname(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.javaOuterClassname_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder clearJavaOuterClassname() {
      this.bitField0_ &= -3;
      this.javaOuterClassname_ = DescriptorProtos$FileOptions.getDefaultInstance().getJavaOuterClassname();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder setJavaOuterClassnameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.javaOuterClassname_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasJavaMultipleFiles() {
      return (this.bitField0_ & 4) == 4;
   }

   public boolean getJavaMultipleFiles() {
      return this.javaMultipleFiles_;
   }

   public DescriptorProtos$FileOptions$Builder setJavaMultipleFiles(boolean var1) {
      this.bitField0_ |= 4;
      this.javaMultipleFiles_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearJavaMultipleFiles() {
      this.bitField0_ &= -5;
      this.javaMultipleFiles_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasJavaGenerateEqualsAndHash() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getJavaGenerateEqualsAndHash() {
      return this.javaGenerateEqualsAndHash_;
   }

   public DescriptorProtos$FileOptions$Builder setJavaGenerateEqualsAndHash(boolean var1) {
      this.bitField0_ |= 8;
      this.javaGenerateEqualsAndHash_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearJavaGenerateEqualsAndHash() {
      this.bitField0_ &= -9;
      this.javaGenerateEqualsAndHash_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasJavaStringCheckUtf8() {
      return (this.bitField0_ & 16) == 16;
   }

   public boolean getJavaStringCheckUtf8() {
      return this.javaStringCheckUtf8_;
   }

   public DescriptorProtos$FileOptions$Builder setJavaStringCheckUtf8(boolean var1) {
      this.bitField0_ |= 16;
      this.javaStringCheckUtf8_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearJavaStringCheckUtf8() {
      this.bitField0_ &= -17;
      this.javaStringCheckUtf8_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasOptimizeFor() {
      return (this.bitField0_ & 32) == 32;
   }

   public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
      DescriptorProtos$FileOptions$OptimizeMode var1 = DescriptorProtos$FileOptions$OptimizeMode.valueOf(this.optimizeFor_);
      return var1 == null?DescriptorProtos$FileOptions$OptimizeMode.SPEED:var1;
   }

   public DescriptorProtos$FileOptions$Builder setOptimizeFor(DescriptorProtos$FileOptions$OptimizeMode var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.optimizeFor_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder clearOptimizeFor() {
      this.bitField0_ &= -33;
      this.optimizeFor_ = 1;
      this.onChanged();
      return this;
   }

   public boolean hasGoPackage() {
      return (this.bitField0_ & 64) == 64;
   }

   public String getGoPackage() {
      Object var1 = this.goPackage_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.goPackage_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getGoPackageBytes() {
      Object var1 = this.goPackage_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.goPackage_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FileOptions$Builder setGoPackage(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 64;
         this.goPackage_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder clearGoPackage() {
      this.bitField0_ &= -65;
      this.goPackage_ = DescriptorProtos$FileOptions.getDefaultInstance().getGoPackage();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder setGoPackageBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 64;
         this.goPackage_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasCcGenericServices() {
      return (this.bitField0_ & 128) == 128;
   }

   public boolean getCcGenericServices() {
      return this.ccGenericServices_;
   }

   public DescriptorProtos$FileOptions$Builder setCcGenericServices(boolean var1) {
      this.bitField0_ |= 128;
      this.ccGenericServices_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearCcGenericServices() {
      this.bitField0_ &= -129;
      this.ccGenericServices_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasJavaGenericServices() {
      return (this.bitField0_ & 256) == 256;
   }

   public boolean getJavaGenericServices() {
      return this.javaGenericServices_;
   }

   public DescriptorProtos$FileOptions$Builder setJavaGenericServices(boolean var1) {
      this.bitField0_ |= 256;
      this.javaGenericServices_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearJavaGenericServices() {
      this.bitField0_ &= -257;
      this.javaGenericServices_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasPyGenericServices() {
      return (this.bitField0_ & 512) == 512;
   }

   public boolean getPyGenericServices() {
      return this.pyGenericServices_;
   }

   public DescriptorProtos$FileOptions$Builder setPyGenericServices(boolean var1) {
      this.bitField0_ |= 512;
      this.pyGenericServices_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearPyGenericServices() {
      this.bitField0_ &= -513;
      this.pyGenericServices_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 1024) == 1024;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public DescriptorProtos$FileOptions$Builder setDeprecated(boolean var1) {
      this.bitField0_ |= 1024;
      this.deprecated_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearDeprecated() {
      this.bitField0_ &= -1025;
      this.deprecated_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasCcEnableArenas() {
      return (this.bitField0_ & 2048) == 2048;
   }

   public boolean getCcEnableArenas() {
      return this.ccEnableArenas_;
   }

   public DescriptorProtos$FileOptions$Builder setCcEnableArenas(boolean var1) {
      this.bitField0_ |= 2048;
      this.ccEnableArenas_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearCcEnableArenas() {
      this.bitField0_ &= -2049;
      this.ccEnableArenas_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasObjcClassPrefix() {
      return (this.bitField0_ & 4096) == 4096;
   }

   public String getObjcClassPrefix() {
      Object var1 = this.objcClassPrefix_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.objcClassPrefix_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getObjcClassPrefixBytes() {
      Object var1 = this.objcClassPrefix_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.objcClassPrefix_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FileOptions$Builder setObjcClassPrefix(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4096;
         this.objcClassPrefix_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder clearObjcClassPrefix() {
      this.bitField0_ &= -4097;
      this.objcClassPrefix_ = DescriptorProtos$FileOptions.getDefaultInstance().getObjcClassPrefix();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder setObjcClassPrefixBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4096;
         this.objcClassPrefix_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasCsharpNamespace() {
      return (this.bitField0_ & 8192) == 8192;
   }

   public String getCsharpNamespace() {
      Object var1 = this.csharpNamespace_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.csharpNamespace_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getCsharpNamespaceBytes() {
      Object var1 = this.csharpNamespace_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.csharpNamespace_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$FileOptions$Builder setCsharpNamespace(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8192;
         this.csharpNamespace_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FileOptions$Builder clearCsharpNamespace() {
      this.bitField0_ &= -8193;
      this.csharpNamespace_ = DescriptorProtos$FileOptions.getDefaultInstance().getCsharpNamespace();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FileOptions$Builder setCsharpNamespaceBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8192;
         this.csharpNamespace_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureUninterpretedOptionIsMutable() {
      if((this.bitField0_ & 16384) != 16384) {
         this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
         this.bitField0_ |= 16384;
      }

   }

   public List getUninterpretedOptionList() {
      return this.uninterpretedOptionBuilder_ == null?Collections.unmodifiableList(this.uninterpretedOption_):this.uninterpretedOptionBuilder_.getMessageList();
   }

   public int getUninterpretedOptionCount() {
      return this.uninterpretedOptionBuilder_ == null?this.uninterpretedOption_.size():this.uninterpretedOptionBuilder_.getCount();
   }

   public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1) {
      return this.uninterpretedOptionBuilder_ == null?(DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(var1):(DescriptorProtos$UninterpretedOption)this.uninterpretedOptionBuilder_.getMessage(var1);
   }

   public DescriptorProtos$FileOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder addAllUninterpretedOption(Iterable var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.uninterpretedOption_);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder clearUninterpretedOption() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -16385;
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FileOptions$Builder removeUninterpretedOption(int var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.remove(var1);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1) {
      return this.uninterpretedOptionBuilder_ == null?(DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(var1):(DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOptionBuilder_.getMessageOrBuilder(var1);
   }

   public List getUninterpretedOptionOrBuilderList() {
      return this.uninterpretedOptionBuilder_ != null?this.uninterpretedOptionBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.uninterpretedOption_);
   }

   public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
      return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption.getDefaultInstance());
   }

   public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(var1, DescriptorProtos$UninterpretedOption.getDefaultInstance());
   }

   public List getUninterpretedOptionBuilderList() {
      return this.getUninterpretedOptionFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 16384) == 16384, this.getParentForChildren(), this.isClean());
         this.uninterpretedOption_ = null;
      }

      return this.uninterpretedOptionBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$FileOptions$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$FileOptions$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
