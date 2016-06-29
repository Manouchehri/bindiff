package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldOptions$1;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$FieldOptionsOrBuilder {
   private int bitField0_;
   public static final int CTYPE_FIELD_NUMBER = 1;
   private int ctype_;
   public static final int PACKED_FIELD_NUMBER = 2;
   private boolean packed_;
   public static final int JSTYPE_FIELD_NUMBER = 6;
   private int jstype_;
   public static final int LAZY_FIELD_NUMBER = 5;
   private boolean lazy_;
   public static final int DEPRECATED_FIELD_NUMBER = 3;
   private boolean deprecated_;
   public static final int WEAK_FIELD_NUMBER = 10;
   private boolean weak_;
   public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
   private List uninterpretedOption_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$FieldOptions DEFAULT_INSTANCE = new DescriptorProtos$FieldOptions();
   public static final Parser PARSER = new DescriptorProtos$FieldOptions$1();

   private DescriptorProtos$FieldOptions(GeneratedMessage$ExtendableBuilder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$FieldOptions() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.ctype_ = 0;
      this.packed_ = false;
      this.jstype_ = 0;
      this.lazy_ = false;
      this.deprecated_ = false;
      this.weak_ = false;
      this.uninterpretedOption_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$FieldOptions(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            int var7;
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 8:
               var7 = var1.readEnum();
               DescriptorProtos$FieldOptions$CType var17 = DescriptorProtos$FieldOptions$CType.valueOf(var7);
               if(var17 == null) {
                  var4.mergeVarintField(1, var7);
               } else {
                  this.bitField0_ |= 1;
                  this.ctype_ = var7;
               }
               break;
            case 16:
               this.bitField0_ |= 2;
               this.packed_ = var1.readBool();
               break;
            case 24:
               this.bitField0_ |= 16;
               this.deprecated_ = var1.readBool();
               break;
            case 40:
               this.bitField0_ |= 8;
               this.lazy_ = var1.readBool();
               break;
            case 48:
               var7 = var1.readEnum();
               DescriptorProtos$FieldOptions$JSType var8 = DescriptorProtos$FieldOptions$JSType.valueOf(var7);
               if(var8 == null) {
                  var4.mergeVarintField(6, var7);
               } else {
                  this.bitField0_ |= 4;
                  this.jstype_ = var7;
               }
               break;
            case 80:
               this.bitField0_ |= 32;
               this.weak_ = var1.readBool();
               break;
            case 7994:
               if((var3 & 64) != 64) {
                  this.uninterpretedOption_ = new ArrayList();
                  var3 |= 64;
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
         if((var3 & 64) == 64) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$16200();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$16300().ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
   }

   public boolean hasCtype() {
      return (this.bitField0_ & 1) == 1;
   }

   public DescriptorProtos$FieldOptions$CType getCtype() {
      DescriptorProtos$FieldOptions$CType var1 = DescriptorProtos$FieldOptions$CType.valueOf(this.ctype_);
      return var1 == null?DescriptorProtos$FieldOptions$CType.STRING:var1;
   }

   public boolean hasPacked() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getPacked() {
      return this.packed_;
   }

   public boolean hasJstype() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$FieldOptions$JSType getJstype() {
      DescriptorProtos$FieldOptions$JSType var1 = DescriptorProtos$FieldOptions$JSType.valueOf(this.jstype_);
      return var1 == null?DescriptorProtos$FieldOptions$JSType.JS_NORMAL:var1;
   }

   public boolean hasLazy() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getLazy() {
      return this.lazy_;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 16) == 16;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public boolean hasWeak() {
      return (this.bitField0_ & 32) == 32;
   }

   public boolean getWeak() {
      return this.weak_;
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
         var1.writeEnum(1, this.ctype_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBool(2, this.packed_);
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBool(3, this.deprecated_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeBool(5, this.lazy_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeEnum(6, this.jstype_);
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeBool(10, this.weak_);
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
            var1 += CodedOutputStream.computeEnumSize(1, this.ctype_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBoolSize(2, this.packed_);
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeBoolSize(5, this.lazy_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeEnumSize(6, this.jstype_);
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeBoolSize(10, this.weak_);
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

   public static DescriptorProtos$FieldOptions parseFrom(ByteString var0) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldOptions parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FieldOptions parseFrom(byte[] var0) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldOptions parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FieldOptions parseFrom(InputStream var0) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldOptions parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$FieldOptions)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldOptions)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$FieldOptions parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldOptions parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldOptions)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$FieldOptions$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$FieldOptions$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$FieldOptions$Builder newBuilder(DescriptorProtos$FieldOptions var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$FieldOptions$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$FieldOptions$Builder((DescriptorProtos$1)null):(new DescriptorProtos$FieldOptions$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$FieldOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$FieldOptions$Builder var2 = new DescriptorProtos$FieldOptions$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$FieldOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$FieldOptions(GeneratedMessage$ExtendableBuilder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int access$16702(DescriptorProtos$FieldOptions var0, int var1) {
      return var0.ctype_ = var1;
   }

   // $FF: synthetic method
   static boolean access$16802(DescriptorProtos$FieldOptions var0, boolean var1) {
      return var0.packed_ = var1;
   }

   // $FF: synthetic method
   static int access$16902(DescriptorProtos$FieldOptions var0, int var1) {
      return var0.jstype_ = var1;
   }

   // $FF: synthetic method
   static boolean access$17002(DescriptorProtos$FieldOptions var0, boolean var1) {
      return var0.lazy_ = var1;
   }

   // $FF: synthetic method
   static boolean access$17102(DescriptorProtos$FieldOptions var0, boolean var1) {
      return var0.deprecated_ = var1;
   }

   // $FF: synthetic method
   static boolean access$17202(DescriptorProtos$FieldOptions var0, boolean var1) {
      return var0.weak_ = var1;
   }

   // $FF: synthetic method
   static List access$17302(DescriptorProtos$FieldOptions var0, List var1) {
      return var0.uninterpretedOption_ = var1;
   }

   // $FF: synthetic method
   static int access$17402(DescriptorProtos$FieldOptions var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$17300(DescriptorProtos$FieldOptions var0) {
      return var0.uninterpretedOption_;
   }

   // $FF: synthetic method
   DescriptorProtos$FieldOptions(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
