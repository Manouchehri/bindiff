package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
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

public final class DescriptorProtos$SourceCodeInfo extends GeneratedMessage implements DescriptorProtos$SourceCodeInfoOrBuilder {
   public static final int LOCATION_FIELD_NUMBER = 1;
   private List location_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$SourceCodeInfo DEFAULT_INSTANCE = new DescriptorProtos$SourceCodeInfo();
   public static final Parser PARSER = new DescriptorProtos$SourceCodeInfo$1();

   private DescriptorProtos$SourceCodeInfo(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$SourceCodeInfo() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.location_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$SourceCodeInfo(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               if(!(var3 & true)) {
                  this.location_ = new ArrayList();
                  var3 |= true;
               }

               this.location_.add(var1.readMessage(DescriptorProtos$SourceCodeInfo$Location.PARSER, var2));
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
         if(var3 & true) {
            this.location_ = Collections.unmodifiableList(this.location_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$23600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$23700().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
   }

   public List getLocationList() {
      return this.location_;
   }

   public List getLocationOrBuilderList() {
      return this.location_;
   }

   public int getLocationCount() {
      return this.location_.size();
   }

   public DescriptorProtos$SourceCodeInfo$Location getLocation(int var1) {
      return (DescriptorProtos$SourceCodeInfo$Location)this.location_.get(var1);
   }

   public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int var1) {
      return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.location_.get(var1);
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
      for(int var2 = 0; var2 < this.location_.size(); ++var2) {
         var1.writeMessage(1, (MessageLite)this.location_.get(var2));
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         for(int var2 = 0; var2 < this.location_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.location_.get(var2));
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(ByteString var0) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] var0) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream var0) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$SourceCodeInfo parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$SourceCodeInfo$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$SourceCodeInfo$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$SourceCodeInfo$Builder newBuilder(DescriptorProtos$SourceCodeInfo var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$SourceCodeInfo$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$SourceCodeInfo$Builder((DescriptorProtos$1)null):(new DescriptorProtos$SourceCodeInfo$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$SourceCodeInfo$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$SourceCodeInfo$Builder var2 = new DescriptorProtos$SourceCodeInfo$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$SourceCodeInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static List access$25302(DescriptorProtos$SourceCodeInfo var0, List var1) {
      return var0.location_ = var1;
   }

   // $FF: synthetic method
   static List access$25300(DescriptorProtos$SourceCodeInfo var0) {
      return var0.location_;
   }

   // $FF: synthetic method
   DescriptorProtos$SourceCodeInfo(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
