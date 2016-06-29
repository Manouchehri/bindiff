package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileOptions$1;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$ExtendableMessage$ExtensionWriter;
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

public final class DescriptorProtos$FileOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$FileOptionsOrBuilder {
   private int bitField0_;
   public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
   private volatile Object javaPackage_;
   public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
   private volatile Object javaOuterClassname_;
   public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
   private boolean javaMultipleFiles_;
   public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
   private boolean javaGenerateEqualsAndHash_;
   public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
   private boolean javaStringCheckUtf8_;
   public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
   private int optimizeFor_;
   public static final int GO_PACKAGE_FIELD_NUMBER = 11;
   private volatile Object goPackage_;
   public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
   private boolean ccGenericServices_;
   public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
   private boolean javaGenericServices_;
   public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
   private boolean pyGenericServices_;
   public static final int DEPRECATED_FIELD_NUMBER = 23;
   private boolean deprecated_;
   public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
   private boolean ccEnableArenas_;
   public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
   private volatile Object objcClassPrefix_;
   public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
   private volatile Object csharpNamespace_;
   public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
   private List uninterpretedOption_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$FileOptions DEFAULT_INSTANCE = new DescriptorProtos$FileOptions();
   public static final Parser PARSER = new DescriptorProtos$FileOptions$1();

   private DescriptorProtos$FileOptions(GeneratedMessage$ExtendableBuilder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$FileOptions() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.javaPackage_ = "";
      this.javaOuterClassname_ = "";
      this.javaMultipleFiles_ = false;
      this.javaGenerateEqualsAndHash_ = false;
      this.javaStringCheckUtf8_ = false;
      this.optimizeFor_ = 1;
      this.goPackage_ = "";
      this.ccGenericServices_ = false;
      this.javaGenericServices_ = false;
      this.pyGenericServices_ = false;
      this.deprecated_ = false;
      this.ccEnableArenas_ = false;
      this.objcClassPrefix_ = "";
      this.csharpNamespace_ = "";
      this.uninterpretedOption_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$FileOptions(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.javaPackage_ = var7;
               break;
            case 66:
               var7 = var1.readBytes();
               this.bitField0_ |= 2;
               this.javaOuterClassname_ = var7;
               break;
            case 72:
               int var17 = var1.readEnum();
               DescriptorProtos$FileOptions$OptimizeMode var8 = DescriptorProtos$FileOptions$OptimizeMode.valueOf(var17);
               if(var8 == null) {
                  var4.mergeVarintField(9, var17);
               } else {
                  this.bitField0_ |= 32;
                  this.optimizeFor_ = var17;
               }
               break;
            case 80:
               this.bitField0_ |= 4;
               this.javaMultipleFiles_ = var1.readBool();
               break;
            case 90:
               var7 = var1.readBytes();
               this.bitField0_ |= 64;
               this.goPackage_ = var7;
               break;
            case 128:
               this.bitField0_ |= 128;
               this.ccGenericServices_ = var1.readBool();
               break;
            case 136:
               this.bitField0_ |= 256;
               this.javaGenericServices_ = var1.readBool();
               break;
            case 144:
               this.bitField0_ |= 512;
               this.pyGenericServices_ = var1.readBool();
               break;
            case 160:
               this.bitField0_ |= 8;
               this.javaGenerateEqualsAndHash_ = var1.readBool();
               break;
            case 184:
               this.bitField0_ |= 1024;
               this.deprecated_ = var1.readBool();
               break;
            case 216:
               this.bitField0_ |= 16;
               this.javaStringCheckUtf8_ = var1.readBool();
               break;
            case 248:
               this.bitField0_ |= 2048;
               this.ccEnableArenas_ = var1.readBool();
               break;
            case 290:
               var7 = var1.readBytes();
               this.bitField0_ |= 4096;
               this.objcClassPrefix_ = var7;
               break;
            case 298:
               var7 = var1.readBytes();
               this.bitField0_ |= 8192;
               this.csharpNamespace_ = var7;
               break;
            case 7994:
               if((var3 & 16384) != 16384) {
                  this.uninterpretedOption_ = new ArrayList();
                  var3 |= 16384;
               }

               this.uninterpretedOption_.add(var1.readMessage(DescriptorProtos$UninterpretedOption.PARSER, var2));
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var14) {
         throw new RuntimeException(var14.setUnfinishedMessage(this));
      } catch (IOException var15) {
         throw new RuntimeException((new InvalidProtocolBufferException(var15.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 16384) == 16384) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$12800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$12900().ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
   }

   public boolean hasJavaPackage() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getJavaPackage() {
      Object var1 = this.javaPackage_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.javaPackage_ = var3;
         }

         return var3;
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

   public boolean hasJavaOuterClassname() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getJavaOuterClassname() {
      Object var1 = this.javaOuterClassname_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.javaOuterClassname_ = var3;
         }

         return var3;
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

   public boolean hasJavaMultipleFiles() {
      return (this.bitField0_ & 4) == 4;
   }

   public boolean getJavaMultipleFiles() {
      return this.javaMultipleFiles_;
   }

   public boolean hasJavaGenerateEqualsAndHash() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getJavaGenerateEqualsAndHash() {
      return this.javaGenerateEqualsAndHash_;
   }

   public boolean hasJavaStringCheckUtf8() {
      return (this.bitField0_ & 16) == 16;
   }

   public boolean getJavaStringCheckUtf8() {
      return this.javaStringCheckUtf8_;
   }

   public boolean hasOptimizeFor() {
      return (this.bitField0_ & 32) == 32;
   }

   public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
      DescriptorProtos$FileOptions$OptimizeMode var1 = DescriptorProtos$FileOptions$OptimizeMode.valueOf(this.optimizeFor_);
      return var1 == null?DescriptorProtos$FileOptions$OptimizeMode.SPEED:var1;
   }

   public boolean hasGoPackage() {
      return (this.bitField0_ & 64) == 64;
   }

   public String getGoPackage() {
      Object var1 = this.goPackage_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.goPackage_ = var3;
         }

         return var3;
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

   public boolean hasCcGenericServices() {
      return (this.bitField0_ & 128) == 128;
   }

   public boolean getCcGenericServices() {
      return this.ccGenericServices_;
   }

   public boolean hasJavaGenericServices() {
      return (this.bitField0_ & 256) == 256;
   }

   public boolean getJavaGenericServices() {
      return this.javaGenericServices_;
   }

   public boolean hasPyGenericServices() {
      return (this.bitField0_ & 512) == 512;
   }

   public boolean getPyGenericServices() {
      return this.pyGenericServices_;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 1024) == 1024;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public boolean hasCcEnableArenas() {
      return (this.bitField0_ & 2048) == 2048;
   }

   public boolean getCcEnableArenas() {
      return this.ccEnableArenas_;
   }

   public boolean hasObjcClassPrefix() {
      return (this.bitField0_ & 4096) == 4096;
   }

   public String getObjcClassPrefix() {
      Object var1 = this.objcClassPrefix_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.objcClassPrefix_ = var3;
         }

         return var3;
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

   public boolean hasCsharpNamespace() {
      return (this.bitField0_ & 8192) == 8192;
   }

   public String getCsharpNamespace() {
      Object var1 = this.csharpNamespace_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.csharpNamespace_ = var3;
         }

         return var3;
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

   public List getUninterpretedOptionList() {
      return this.uninterpretedOption_;
   }

   public List getUninterpretedOptionOrBuilderList() {
      return this.uninterpretedOption_;
   }

   public int getUninterpretedOptionCount() {
      return this.uninterpretedOption_.size();
   }

   public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1) {
      return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(var1);
   }

   public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.getUninterpretedOptionCount(); ++var2) {
            if(!this.getUninterpretedOption(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         if(!this.extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
         } else {
            this.memoizedIsInitialized = 1;
            return true;
         }
      }
   }

   public void writeTo(CodedOutputStream var1) {
      GeneratedMessage$ExtendableMessage$ExtensionWriter var2 = this.newExtensionWriter();
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getJavaPackageBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBytes(8, this.getJavaOuterClassnameBytes());
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeEnum(9, this.optimizeFor_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeBool(10, this.javaMultipleFiles_);
      }

      if((this.bitField0_ & 64) == 64) {
         var1.writeBytes(11, this.getGoPackageBytes());
      }

      if((this.bitField0_ & 128) == 128) {
         var1.writeBool(16, this.ccGenericServices_);
      }

      if((this.bitField0_ & 256) == 256) {
         var1.writeBool(17, this.javaGenericServices_);
      }

      if((this.bitField0_ & 512) == 512) {
         var1.writeBool(18, this.pyGenericServices_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeBool(20, this.javaGenerateEqualsAndHash_);
      }

      if((this.bitField0_ & 1024) == 1024) {
         var1.writeBool(23, this.deprecated_);
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBool(27, this.javaStringCheckUtf8_);
      }

      if((this.bitField0_ & 2048) == 2048) {
         var1.writeBool(31, this.ccEnableArenas_);
      }

      if((this.bitField0_ & 4096) == 4096) {
         var1.writeBytes(36, this.getObjcClassPrefixBytes());
      }

      if((this.bitField0_ & 8192) == 8192) {
         var1.writeBytes(37, this.getCsharpNamespaceBytes());
      }

      for(int var3 = 0; var3 < this.uninterpretedOption_.size(); ++var3) {
         var1.writeMessage(999, (MessageLite)this.uninterpretedOption_.get(var3));
      }

      var2.writeUntil(536870912, var1);
      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getJavaPackageBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBytesSize(8, this.getJavaOuterClassnameBytes());
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeEnumSize(9, this.optimizeFor_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
         }

         if((this.bitField0_ & 64) == 64) {
            var1 += CodedOutputStream.computeBytesSize(11, this.getGoPackageBytes());
         }

         if((this.bitField0_ & 128) == 128) {
            var1 += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
         }

         if((this.bitField0_ & 256) == 256) {
            var1 += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
         }

         if((this.bitField0_ & 512) == 512) {
            var1 += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
         }

         if((this.bitField0_ & 1024) == 1024) {
            var1 += CodedOutputStream.computeBoolSize(23, this.deprecated_);
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBoolSize(27, this.javaStringCheckUtf8_);
         }

         if((this.bitField0_ & 2048) == 2048) {
            var1 += CodedOutputStream.computeBoolSize(31, this.ccEnableArenas_);
         }

         if((this.bitField0_ & 4096) == 4096) {
            var1 += CodedOutputStream.computeBytesSize(36, this.getObjcClassPrefixBytes());
         }

         if((this.bitField0_ & 8192) == 8192) {
            var1 += CodedOutputStream.computeBytesSize(37, this.getCsharpNamespaceBytes());
         }

         for(int var2 = 0; var2 < this.uninterpretedOption_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(var2));
         }

         var1 += this.extensionsSerializedSize();
         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$FileOptions parseFrom(ByteString var0) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileOptions parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileOptions parseFrom(byte[] var0) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileOptions parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileOptions parseFrom(InputStream var0) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileOptions parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$FileOptions)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileOptions)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$FileOptions parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileOptions parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileOptions)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$FileOptions$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$FileOptions$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$FileOptions$Builder newBuilder(DescriptorProtos$FileOptions var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$FileOptions$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$FileOptions$Builder((DescriptorProtos$1)null):(new DescriptorProtos$FileOptions$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$FileOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$FileOptions$Builder var2 = new DescriptorProtos$FileOptions$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$FileOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$FileOptions getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$FileOptions(GeneratedMessage$ExtendableBuilder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$13302(DescriptorProtos$FileOptions var0, Object var1) {
      return var0.javaPackage_ = var1;
   }

   // $FF: synthetic method
   static Object access$13402(DescriptorProtos$FileOptions var0, Object var1) {
      return var0.javaOuterClassname_ = var1;
   }

   // $FF: synthetic method
   static boolean access$13502(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.javaMultipleFiles_ = var1;
   }

   // $FF: synthetic method
   static boolean access$13602(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.javaGenerateEqualsAndHash_ = var1;
   }

   // $FF: synthetic method
   static boolean access$13702(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.javaStringCheckUtf8_ = var1;
   }

   // $FF: synthetic method
   static int access$13802(DescriptorProtos$FileOptions var0, int var1) {
      return var0.optimizeFor_ = var1;
   }

   // $FF: synthetic method
   static Object access$13902(DescriptorProtos$FileOptions var0, Object var1) {
      return var0.goPackage_ = var1;
   }

   // $FF: synthetic method
   static boolean access$14002(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.ccGenericServices_ = var1;
   }

   // $FF: synthetic method
   static boolean access$14102(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.javaGenericServices_ = var1;
   }

   // $FF: synthetic method
   static boolean access$14202(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.pyGenericServices_ = var1;
   }

   // $FF: synthetic method
   static boolean access$14302(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.deprecated_ = var1;
   }

   // $FF: synthetic method
   static boolean access$14402(DescriptorProtos$FileOptions var0, boolean var1) {
      return var0.ccEnableArenas_ = var1;
   }

   // $FF: synthetic method
   static Object access$14502(DescriptorProtos$FileOptions var0, Object var1) {
      return var0.objcClassPrefix_ = var1;
   }

   // $FF: synthetic method
   static Object access$14602(DescriptorProtos$FileOptions var0, Object var1) {
      return var0.csharpNamespace_ = var1;
   }

   // $FF: synthetic method
   static List access$14702(DescriptorProtos$FileOptions var0, List var1) {
      return var0.uninterpretedOption_ = var1;
   }

   // $FF: synthetic method
   static int access$14802(DescriptorProtos$FileOptions var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$13300(DescriptorProtos$FileOptions var0) {
      return var0.javaPackage_;
   }

   // $FF: synthetic method
   static Object access$13400(DescriptorProtos$FileOptions var0) {
      return var0.javaOuterClassname_;
   }

   // $FF: synthetic method
   static Object access$13900(DescriptorProtos$FileOptions var0) {
      return var0.goPackage_;
   }

   // $FF: synthetic method
   static Object access$14500(DescriptorProtos$FileOptions var0) {
      return var0.objcClassPrefix_;
   }

   // $FF: synthetic method
   static Object access$14600(DescriptorProtos$FileOptions var0) {
      return var0.csharpNamespace_;
   }

   // $FF: synthetic method
   static List access$14700(DescriptorProtos$FileOptions var0) {
      return var0.uninterpretedOption_;
   }

   // $FF: synthetic method
   DescriptorProtos$FileOptions(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
