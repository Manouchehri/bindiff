package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.EnumValue$1;
import com.google.protobuf.EnumValue$Builder;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessage implements EnumValueOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int NUMBER_FIELD_NUMBER = 2;
   private int number_;
   public static final int OPTIONS_FIELD_NUMBER = 3;
   private List options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
   public static final Parser PARSER = new EnumValue$1();

   private EnumValue(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private EnumValue() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.number_ = 0;
      this.options_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private EnumValue(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 10:
               ByteString var6 = var1.readBytes();
               this.name_ = var6;
               break;
            case 16:
               this.number_ = var1.readInt32();
               break;
            case 26:
               if((var3 & 4) != 4) {
                  this.options_ = new ArrayList();
                  var3 |= 4;
               }

               this.options_.add(var1.readMessage(Option.PARSER, var2));
               break;
            default:
               if(!var1.skipField(var5)) {
                  var4 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var12) {
         throw new RuntimeException(var12.setUnfinishedMessage(this));
      } catch (IOException var13) {
         throw new RuntimeException((new InvalidProtocolBufferException(var13.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 4) == 4) {
            this.options_ = Collections.unmodifiableList(this.options_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
   }

   public String getName() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
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

   public int getNumber() {
      return this.number_;
   }

   public List getOptionsList() {
      return this.options_;
   }

   public List getOptionsOrBuilderList() {
      return this.options_;
   }

   public int getOptionsCount() {
      return this.options_.size();
   }

   public Option getOptions(int var1) {
      return (Option)this.options_.get(var1);
   }

   public OptionOrBuilder getOptionsOrBuilder(int var1) {
      return (OptionOrBuilder)this.options_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if(!this.getNameBytes().isEmpty()) {
         var1.writeBytes(1, this.getNameBytes());
      }

      if(this.number_ != 0) {
         var1.writeInt32(2, this.number_);
      }

      for(int var2 = 0; var2 < this.options_.size(); ++var2) {
         var1.writeMessage(3, (MessageLite)this.options_.get(var2));
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(!this.getNameBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
         }

         if(this.number_ != 0) {
            var1 += CodedOutputStream.computeInt32Size(2, this.number_);
         }

         for(int var2 = 0; var2 < this.options_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(var2));
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static EnumValue parseFrom(ByteString var0) {
      return (EnumValue)PARSER.parseFrom(var0);
   }

   public static EnumValue parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (EnumValue)PARSER.parseFrom(var0, var1);
   }

   public static EnumValue parseFrom(byte[] var0) {
      return (EnumValue)PARSER.parseFrom(var0);
   }

   public static EnumValue parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (EnumValue)PARSER.parseFrom(var0, var1);
   }

   public static EnumValue parseFrom(InputStream var0) {
      return (EnumValue)PARSER.parseFrom(var0);
   }

   public static EnumValue parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (EnumValue)PARSER.parseFrom(var0, var1);
   }

   public static EnumValue parseDelimitedFrom(InputStream var0) {
      return (EnumValue)PARSER.parseDelimitedFrom(var0);
   }

   public static EnumValue parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (EnumValue)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static EnumValue parseFrom(CodedInputStream var0) {
      return (EnumValue)PARSER.parseFrom(var0);
   }

   public static EnumValue parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (EnumValue)PARSER.parseFrom(var0, var1);
   }

   public EnumValue$Builder newBuilderForType() {
      return newBuilder();
   }

   public static EnumValue$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static EnumValue$Builder newBuilder(EnumValue var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public EnumValue$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new EnumValue$Builder((EnumValue$1)null):(new EnumValue$Builder((EnumValue$1)null)).mergeFrom(this);
   }

   protected EnumValue$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      EnumValue$Builder var2 = new EnumValue$Builder(var1, (EnumValue$1)null);
      return var2;
   }

   public static EnumValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public EnumValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   EnumValue(GeneratedMessage$Builder var1, EnumValue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(EnumValue var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static int access$402(EnumValue var0, int var1) {
      return var0.number_ = var1;
   }

   // $FF: synthetic method
   static List access$502(EnumValue var0, List var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$602(EnumValue var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(EnumValue var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static List access$500(EnumValue var0) {
      return var0.options_;
   }

   // $FF: synthetic method
   EnumValue(CodedInputStream var1, ExtensionRegistryLite var2, EnumValue$1 var3) {
      this(var1, var2);
   }
}
