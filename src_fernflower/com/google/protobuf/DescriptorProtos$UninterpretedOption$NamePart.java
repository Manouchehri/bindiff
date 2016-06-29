package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;

public final class DescriptorProtos$UninterpretedOption$NamePart extends GeneratedMessage implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
   private int bitField0_;
   public static final int NAME_PART_FIELD_NUMBER = 1;
   private volatile Object namePart_;
   public static final int IS_EXTENSION_FIELD_NUMBER = 2;
   private boolean isExtension_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$UninterpretedOption$NamePart DEFAULT_INSTANCE = new DescriptorProtos$UninterpretedOption$NamePart();
   public static final Parser PARSER = new DescriptorProtos$UninterpretedOption$NamePart$1();

   private DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$UninterpretedOption$NamePart() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.namePart_ = "";
      this.isExtension_ = false;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               ByteString var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.namePart_ = var7;
               break;
            case 16:
               this.bitField0_ |= 2;
               this.isExtension_ = var1.readBool();
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
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$21500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$21600().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
   }

   public boolean hasNamePart() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getNamePart() {
      Object var1 = this.namePart_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.namePart_ = var3;
         }

         return var3;
      }
   }

   public ByteString getNamePartBytes() {
      Object var1 = this.namePart_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.namePart_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasIsExtension() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getIsExtension() {
      return this.isExtension_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasNamePart()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else if(!this.hasIsExtension()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getNamePartBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBool(2, this.isExtension_);
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getNamePartBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBoolSize(2, this.isExtension_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteString var0) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(byte[] var0) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(InputStream var0) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$UninterpretedOption$NamePart parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilder(DescriptorProtos$UninterpretedOption$NamePart var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$UninterpretedOption$NamePart$Builder((DescriptorProtos$1)null):(new DescriptorProtos$UninterpretedOption$NamePart$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$UninterpretedOption$NamePart$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$UninterpretedOption$NamePart$Builder var2 = new DescriptorProtos$UninterpretedOption$NamePart$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$UninterpretedOption$NamePart getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$22002(DescriptorProtos$UninterpretedOption$NamePart var0, Object var1) {
      return var0.namePart_ = var1;
   }

   // $FF: synthetic method
   static boolean access$22102(DescriptorProtos$UninterpretedOption$NamePart var0, boolean var1) {
      return var0.isExtension_ = var1;
   }

   // $FF: synthetic method
   static int access$22202(DescriptorProtos$UninterpretedOption$NamePart var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$22000(DescriptorProtos$UninterpretedOption$NamePart var0) {
      return var0.namePart_;
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
