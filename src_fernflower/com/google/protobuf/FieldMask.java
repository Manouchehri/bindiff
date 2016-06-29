package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask$1;
import com.google.protobuf.FieldMask$Builder;
import com.google.protobuf.FieldMaskOrBuilder;
import com.google.protobuf.FieldMaskProto;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class FieldMask extends GeneratedMessage implements FieldMaskOrBuilder {
   public static final int PATHS_FIELD_NUMBER = 1;
   private LazyStringList paths_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
   public static final Parser PARSER = new FieldMask$1();

   private FieldMask(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private FieldMask() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.paths_ = LazyStringArrayList.EMPTY;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private FieldMask(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;

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
               if(!(var3 & true)) {
                  this.paths_ = new LazyStringArrayList();
                  var3 |= true;
               }

               this.paths_.add(var6);
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
         if(var3 & true) {
            this.paths_ = this.paths_.getUnmodifiableView();
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
   }

   public ProtocolStringList getPathsList() {
      return this.paths_;
   }

   public int getPathsCount() {
      return this.paths_.size();
   }

   public String getPaths(int var1) {
      return (String)this.paths_.get(var1);
   }

   public ByteString getPathsBytes(int var1) {
      return this.paths_.getByteString(var1);
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
      for(int var2 = 0; var2 < this.paths_.size(); ++var2) {
         var1.writeBytes(1, this.paths_.getByteString(var2));
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         byte var4 = 0;
         int var2 = 0;

         for(int var3 = 0; var3 < this.paths_.size(); ++var3) {
            var2 += CodedOutputStream.computeBytesSizeNoTag(this.paths_.getByteString(var3));
         }

         var1 = var4 + var2;
         var1 += 1 * this.getPathsList().size();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static FieldMask parseFrom(ByteString var0) {
      return (FieldMask)PARSER.parseFrom(var0);
   }

   public static FieldMask parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (FieldMask)PARSER.parseFrom(var0, var1);
   }

   public static FieldMask parseFrom(byte[] var0) {
      return (FieldMask)PARSER.parseFrom(var0);
   }

   public static FieldMask parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (FieldMask)PARSER.parseFrom(var0, var1);
   }

   public static FieldMask parseFrom(InputStream var0) {
      return (FieldMask)PARSER.parseFrom(var0);
   }

   public static FieldMask parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (FieldMask)PARSER.parseFrom(var0, var1);
   }

   public static FieldMask parseDelimitedFrom(InputStream var0) {
      return (FieldMask)PARSER.parseDelimitedFrom(var0);
   }

   public static FieldMask parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (FieldMask)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static FieldMask parseFrom(CodedInputStream var0) {
      return (FieldMask)PARSER.parseFrom(var0);
   }

   public static FieldMask parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (FieldMask)PARSER.parseFrom(var0, var1);
   }

   public FieldMask$Builder newBuilderForType() {
      return newBuilder();
   }

   public static FieldMask$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static FieldMask$Builder newBuilder(FieldMask var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public FieldMask$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new FieldMask$Builder((FieldMask$1)null):(new FieldMask$Builder((FieldMask$1)null)).mergeFrom(this);
   }

   protected FieldMask$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      FieldMask$Builder var2 = new FieldMask$Builder(var1, (FieldMask$1)null);
      return var2;
   }

   public static FieldMask getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public FieldMask getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   FieldMask(GeneratedMessage$Builder var1, FieldMask$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static LazyStringList access$302(FieldMask var0, LazyStringList var1) {
      return var0.paths_ = var1;
   }

   // $FF: synthetic method
   static LazyStringList access$300(FieldMask var0) {
      return var0.paths_;
   }

   // $FF: synthetic method
   FieldMask(CodedInputStream var1, ExtensionRegistryLite var2, FieldMask$1 var3) {
      this(var1, var2);
   }
}
