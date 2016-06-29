package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSetOrBuilder;
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

public final class DescriptorProtos$FileDescriptorSet extends GeneratedMessage implements DescriptorProtos$FileDescriptorSetOrBuilder {
   public static final int FILE_FIELD_NUMBER = 1;
   private List file_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$FileDescriptorSet DEFAULT_INSTANCE = new DescriptorProtos$FileDescriptorSet();
   public static final Parser PARSER = new DescriptorProtos$FileDescriptorSet$1();

   private DescriptorProtos$FileDescriptorSet(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$FileDescriptorSet() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.file_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$FileDescriptorSet(CodedInputStream var1, ExtensionRegistryLite var2) {
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
                  this.file_ = new ArrayList();
                  var3 |= true;
               }

               this.file_.add(var1.readMessage(DescriptorProtos$FileDescriptorProto.PARSER, var2));
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var11) {
         throw new RuntimeException(var11.setUnfinishedMessage(this));
      } catch (IOException var12) {
         throw new RuntimeException((new InvalidProtocolBufferException(var12.getMessage())).setUnfinishedMessage(this));
      } finally {
         if(var3 & true) {
            this.file_ = Collections.unmodifiableList(this.file_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
   }

   public List getFileList() {
      return this.file_;
   }

   public List getFileOrBuilderList() {
      return this.file_;
   }

   public int getFileCount() {
      return this.file_.size();
   }

   public DescriptorProtos$FileDescriptorProto getFile(int var1) {
      return (DescriptorProtos$FileDescriptorProto)this.file_.get(var1);
   }

   public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int var1) {
      return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.file_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.getFileCount(); ++var2) {
            if(!this.getFile(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      for(int var2 = 0; var2 < this.file_.size(); ++var2) {
         var1.writeMessage(1, (MessageLite)this.file_.get(var2));
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         for(int var2 = 0; var2 < this.file_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.file_.get(var2));
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(ByteString var0) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(byte[] var0) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(InputStream var0) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$FileDescriptorSet$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$FileDescriptorSet$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$FileDescriptorSet$Builder newBuilder(DescriptorProtos$FileDescriptorSet var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$FileDescriptorSet$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$FileDescriptorSet$Builder((DescriptorProtos$1)null):(new DescriptorProtos$FileDescriptorSet$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$FileDescriptorSet$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$FileDescriptorSet$Builder var2 = new DescriptorProtos$FileDescriptorSet$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$FileDescriptorSet getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorSet(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static List access$502(DescriptorProtos$FileDescriptorSet var0, List var1) {
      return var0.file_ = var1;
   }

   // $FF: synthetic method
   static List access$500(DescriptorProtos$FileDescriptorSet var0) {
      return var0.file_;
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorSet(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
