package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
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

public final class DescriptorProtos$UninterpretedOption extends GeneratedMessage implements DescriptorProtos$UninterpretedOptionOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 2;
   private List name_;
   public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
   private volatile Object identifierValue_;
   public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
   private long positiveIntValue_;
   public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
   private long negativeIntValue_;
   public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
   private double doubleValue_;
   public static final int STRING_VALUE_FIELD_NUMBER = 7;
   private ByteString stringValue_;
   public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
   private volatile Object aggregateValue_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$UninterpretedOption DEFAULT_INSTANCE = new DescriptorProtos$UninterpretedOption();
   public static final Parser PARSER = new DescriptorProtos$UninterpretedOption$1();

   private DescriptorProtos$UninterpretedOption(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$UninterpretedOption() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = Collections.emptyList();
      this.identifierValue_ = "";
      this.positiveIntValue_ = 0L;
      this.negativeIntValue_ = 0L;
      this.doubleValue_ = 0.0D;
      this.stringValue_ = ByteString.EMPTY;
      this.aggregateValue_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$UninterpretedOption(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
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
            case 18:
               if(!(var3 & true)) {
                  this.name_ = new ArrayList();
                  var3 |= true;
               }

               this.name_.add(var1.readMessage(DescriptorProtos$UninterpretedOption$NamePart.PARSER, var2));
               break;
            case 26:
               var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.identifierValue_ = var7;
               break;
            case 32:
               this.bitField0_ |= 2;
               this.positiveIntValue_ = var1.readUInt64();
               break;
            case 40:
               this.bitField0_ |= 4;
               this.negativeIntValue_ = var1.readInt64();
               break;
            case 49:
               this.bitField0_ |= 8;
               this.doubleValue_ = var1.readDouble();
               break;
            case 58:
               this.bitField0_ |= 16;
               this.stringValue_ = var1.readBytes();
               break;
            case 66:
               var7 = var1.readBytes();
               this.bitField0_ |= 32;
               this.aggregateValue_ = var7;
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var13) {
         throw new RuntimeException(var13.setUnfinishedMessage(this));
      } catch (IOException var14) {
         throw new RuntimeException((new InvalidProtocolBufferException(var14.getMessage())).setUnfinishedMessage(this));
      } finally {
         if(var3 & true) {
            this.name_ = Collections.unmodifiableList(this.name_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$21300();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$21400().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
   }

   public List getNameList() {
      return this.name_;
   }

   public List getNameOrBuilderList() {
      return this.name_;
   }

   public int getNameCount() {
      return this.name_.size();
   }

   public DescriptorProtos$UninterpretedOption$NamePart getName(int var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart)this.name_.get(var1);
   }

   public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.name_.get(var1);
   }

   public boolean hasIdentifierValue() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getIdentifierValue() {
      Object var1 = this.identifierValue_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.identifierValue_ = var3;
         }

         return var3;
      }
   }

   public ByteString getIdentifierValueBytes() {
      Object var1 = this.identifierValue_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.identifierValue_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasPositiveIntValue() {
      return (this.bitField0_ & 2) == 2;
   }

   public long getPositiveIntValue() {
      return this.positiveIntValue_;
   }

   public boolean hasNegativeIntValue() {
      return (this.bitField0_ & 4) == 4;
   }

   public long getNegativeIntValue() {
      return this.negativeIntValue_;
   }

   public boolean hasDoubleValue() {
      return (this.bitField0_ & 8) == 8;
   }

   public double getDoubleValue() {
      return this.doubleValue_;
   }

   public boolean hasStringValue() {
      return (this.bitField0_ & 16) == 16;
   }

   public ByteString getStringValue() {
      return this.stringValue_;
   }

   public boolean hasAggregateValue() {
      return (this.bitField0_ & 32) == 32;
   }

   public String getAggregateValue() {
      Object var1 = this.aggregateValue_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.aggregateValue_ = var3;
         }

         return var3;
      }
   }

   public ByteString getAggregateValueBytes() {
      Object var1 = this.aggregateValue_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.aggregateValue_ = var2;
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
         for(int var2 = 0; var2 < this.getNameCount(); ++var2) {
            if(!this.getName(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      for(int var2 = 0; var2 < this.name_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.name_.get(var2));
      }

      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(3, this.getIdentifierValueBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeUInt64(4, this.positiveIntValue_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeInt64(5, this.negativeIntValue_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeDouble(6, this.doubleValue_);
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBytes(7, this.stringValue_);
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeBytes(8, this.getAggregateValueBytes());
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         for(int var2 = 0; var2 < this.name_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.name_.get(var2));
         }

         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeBytesSize(3, this.getIdentifierValueBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBytesSize(7, this.stringValue_);
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeBytesSize(8, this.getAggregateValueBytes());
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(ByteString var0) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(byte[] var0) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(InputStream var0) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$UninterpretedOption$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$UninterpretedOption$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$UninterpretedOption$Builder newBuilder(DescriptorProtos$UninterpretedOption var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$UninterpretedOption$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$UninterpretedOption$Builder((DescriptorProtos$1)null):(new DescriptorProtos$UninterpretedOption$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$UninterpretedOption$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$UninterpretedOption$Builder var2 = new DescriptorProtos$UninterpretedOption$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$UninterpretedOption getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static List access$22702(DescriptorProtos$UninterpretedOption var0, List var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static Object access$22802(DescriptorProtos$UninterpretedOption var0, Object var1) {
      return var0.identifierValue_ = var1;
   }

   // $FF: synthetic method
   static long access$22902(DescriptorProtos$UninterpretedOption var0, long var1) {
      return var0.positiveIntValue_ = var1;
   }

   // $FF: synthetic method
   static long access$23002(DescriptorProtos$UninterpretedOption var0, long var1) {
      return var0.negativeIntValue_ = var1;
   }

   // $FF: synthetic method
   static double access$23102(DescriptorProtos$UninterpretedOption var0, double var1) {
      return var0.doubleValue_ = var1;
   }

   // $FF: synthetic method
   static ByteString access$23202(DescriptorProtos$UninterpretedOption var0, ByteString var1) {
      return var0.stringValue_ = var1;
   }

   // $FF: synthetic method
   static Object access$23302(DescriptorProtos$UninterpretedOption var0, Object var1) {
      return var0.aggregateValue_ = var1;
   }

   // $FF: synthetic method
   static int access$23402(DescriptorProtos$UninterpretedOption var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$22700(DescriptorProtos$UninterpretedOption var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static Object access$22800(DescriptorProtos$UninterpretedOption var0) {
      return var0.identifierValue_;
   }

   // $FF: synthetic method
   static Object access$23300(DescriptorProtos$UninterpretedOption var0) {
      return var0.aggregateValue_;
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
