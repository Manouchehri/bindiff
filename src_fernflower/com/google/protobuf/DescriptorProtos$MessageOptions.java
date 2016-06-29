package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MessageOptions$1;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
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

public final class DescriptorProtos$MessageOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$MessageOptionsOrBuilder {
   private int bitField0_;
   public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
   private boolean messageSetWireFormat_;
   public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
   private boolean noStandardDescriptorAccessor_;
   public static final int DEPRECATED_FIELD_NUMBER = 3;
   private boolean deprecated_;
   public static final int MAP_ENTRY_FIELD_NUMBER = 7;
   private boolean mapEntry_;
   public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
   private List uninterpretedOption_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$MessageOptions DEFAULT_INSTANCE = new DescriptorProtos$MessageOptions();
   public static final Parser PARSER = new DescriptorProtos$MessageOptions$1();

   private DescriptorProtos$MessageOptions(GeneratedMessage$ExtendableBuilder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$MessageOptions() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.messageSetWireFormat_ = false;
      this.noStandardDescriptorAccessor_ = false;
      this.deprecated_ = false;
      this.mapEntry_ = false;
      this.uninterpretedOption_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$MessageOptions(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 8:
               this.bitField0_ |= 1;
               this.messageSetWireFormat_ = var1.readBool();
               break;
            case 16:
               this.bitField0_ |= 2;
               this.noStandardDescriptorAccessor_ = var1.readBool();
               break;
            case 24:
               this.bitField0_ |= 4;
               this.deprecated_ = var1.readBool();
               break;
            case 56:
               this.bitField0_ |= 8;
               this.mapEntry_ = var1.readBool();
               break;
            case 7994:
               if((var3 & 16) != 16) {
                  this.uninterpretedOption_ = new ArrayList();
                  var3 |= 16;
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
         if((var3 & 16) == 16) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$15000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$15100().ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
   }

   public boolean hasMessageSetWireFormat() {
      return (this.bitField0_ & 1) == 1;
   }

   public boolean getMessageSetWireFormat() {
      return this.messageSetWireFormat_;
   }

   public boolean hasNoStandardDescriptorAccessor() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getNoStandardDescriptorAccessor() {
      return this.noStandardDescriptorAccessor_;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 4) == 4;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public boolean hasMapEntry() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getMapEntry() {
      return this.mapEntry_;
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
         var1.writeBool(1, this.messageSetWireFormat_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBool(2, this.noStandardDescriptorAccessor_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeBool(3, this.deprecated_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeBool(7, this.mapEntry_);
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
            var1 += CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeBoolSize(7, this.mapEntry_);
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

   public static DescriptorProtos$MessageOptions parseFrom(ByteString var0) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MessageOptions parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$MessageOptions parseFrom(byte[] var0) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MessageOptions parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$MessageOptions parseFrom(InputStream var0) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MessageOptions parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$MessageOptions parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$MessageOptions)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$MessageOptions parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MessageOptions)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$MessageOptions parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$MessageOptions parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$MessageOptions)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$MessageOptions$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$MessageOptions$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$MessageOptions$Builder newBuilder(DescriptorProtos$MessageOptions var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$MessageOptions$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$MessageOptions$Builder((DescriptorProtos$1)null):(new DescriptorProtos$MessageOptions$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$MessageOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$MessageOptions$Builder var2 = new DescriptorProtos$MessageOptions$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$MessageOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$MessageOptions(GeneratedMessage$ExtendableBuilder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static boolean access$15502(DescriptorProtos$MessageOptions var0, boolean var1) {
      return var0.messageSetWireFormat_ = var1;
   }

   // $FF: synthetic method
   static boolean access$15602(DescriptorProtos$MessageOptions var0, boolean var1) {
      return var0.noStandardDescriptorAccessor_ = var1;
   }

   // $FF: synthetic method
   static boolean access$15702(DescriptorProtos$MessageOptions var0, boolean var1) {
      return var0.deprecated_ = var1;
   }

   // $FF: synthetic method
   static boolean access$15802(DescriptorProtos$MessageOptions var0, boolean var1) {
      return var0.mapEntry_ = var1;
   }

   // $FF: synthetic method
   static List access$15902(DescriptorProtos$MessageOptions var0, List var1) {
      return var0.uninterpretedOption_ = var1;
   }

   // $FF: synthetic method
   static int access$16002(DescriptorProtos$MessageOptions var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$15900(DescriptorProtos$MessageOptions var0) {
      return var0.uninterpretedOption_;
   }

   // $FF: synthetic method
   DescriptorProtos$MessageOptions(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
