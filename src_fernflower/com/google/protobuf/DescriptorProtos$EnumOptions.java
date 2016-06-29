package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumOptions$1;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
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

public final class DescriptorProtos$EnumOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$EnumOptionsOrBuilder {
   private int bitField0_;
   public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
   private boolean allowAlias_;
   public static final int DEPRECATED_FIELD_NUMBER = 3;
   private boolean deprecated_;
   public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
   private List uninterpretedOption_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$EnumOptions DEFAULT_INSTANCE = new DescriptorProtos$EnumOptions();
   public static final Parser PARSER = new DescriptorProtos$EnumOptions$1();

   private DescriptorProtos$EnumOptions(GeneratedMessage$ExtendableBuilder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$EnumOptions() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.allowAlias_ = false;
      this.deprecated_ = false;
      this.uninterpretedOption_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$EnumOptions(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 16:
               this.bitField0_ |= 1;
               this.allowAlias_ = var1.readBool();
               break;
            case 24:
               this.bitField0_ |= 2;
               this.deprecated_ = var1.readBool();
               break;
            case 7994:
               if((var3 & 4) != 4) {
                  this.uninterpretedOption_ = new ArrayList();
                  var3 |= 4;
               }

               this.uninterpretedOption_.add(var1.readMessage(DescriptorProtos$UninterpretedOption.PARSER, var2));
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var12) {
         throw new RuntimeException(var12.setUnfinishedMessage(this));
      } catch (IOException var13) {
         throw new RuntimeException((new InvalidProtocolBufferException(var13.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 4) == 4) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$17600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$17700().ensureFieldAccessorsInitialized(DescriptorProtos$EnumOptions.class, DescriptorProtos$EnumOptions$Builder.class);
   }

   public boolean hasAllowAlias() {
      return (this.bitField0_ & 1) == 1;
   }

   public boolean getAllowAlias() {
      return this.allowAlias_;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
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
         var1.writeBool(2, this.allowAlias_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBool(3, this.deprecated_);
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
            var1 += CodedOutputStream.computeBoolSize(2, this.allowAlias_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
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

   public static DescriptorProtos$EnumOptions parseFrom(ByteString var0) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumOptions parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumOptions parseFrom(byte[] var0) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumOptions parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumOptions parseFrom(InputStream var0) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumOptions parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumOptions parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$EnumOptions)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$EnumOptions parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumOptions)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$EnumOptions parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumOptions parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumOptions)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$EnumOptions$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$EnumOptions$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$EnumOptions$Builder newBuilder(DescriptorProtos$EnumOptions var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$EnumOptions$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$EnumOptions$Builder((DescriptorProtos$1)null):(new DescriptorProtos$EnumOptions$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$EnumOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$EnumOptions$Builder var2 = new DescriptorProtos$EnumOptions$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$EnumOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$EnumOptions getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumOptions(GeneratedMessage$ExtendableBuilder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static boolean access$18102(DescriptorProtos$EnumOptions var0, boolean var1) {
      return var0.allowAlias_ = var1;
   }

   // $FF: synthetic method
   static boolean access$18202(DescriptorProtos$EnumOptions var0, boolean var1) {
      return var0.deprecated_ = var1;
   }

   // $FF: synthetic method
   static List access$18302(DescriptorProtos$EnumOptions var0, List var1) {
      return var0.uninterpretedOption_ = var1;
   }

   // $FF: synthetic method
   static int access$18402(DescriptorProtos$EnumOptions var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$18300(DescriptorProtos$EnumOptions var0) {
      return var0.uninterpretedOption_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumOptions(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
