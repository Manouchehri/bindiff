package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldDescriptorProto extends GeneratedMessage implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int NUMBER_FIELD_NUMBER = 3;
   private int number_;
   public static final int LABEL_FIELD_NUMBER = 4;
   private int label_;
   public static final int TYPE_FIELD_NUMBER = 5;
   private int type_;
   public static final int TYPE_NAME_FIELD_NUMBER = 6;
   private volatile Object typeName_;
   public static final int EXTENDEE_FIELD_NUMBER = 2;
   private volatile Object extendee_;
   public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
   private volatile Object defaultValue_;
   public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
   private int oneofIndex_;
   public static final int OPTIONS_FIELD_NUMBER = 8;
   private DescriptorProtos$FieldOptions options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$FieldDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$FieldDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$FieldDescriptorProto$1();

   private DescriptorProtos$FieldDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$FieldDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.number_ = 0;
      this.label_ = 1;
      this.type_ = 1;
      this.typeName_ = "";
      this.extendee_ = "";
      this.defaultValue_ = "";
      this.oneofIndex_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$FieldDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            ByteString var17;
            int var19;
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               var17 = var1.readBytes();
               this.bitField0_ |= 1;
               this.name_ = var17;
               break;
            case 18:
               var17 = var1.readBytes();
               this.bitField0_ |= 32;
               this.extendee_ = var17;
               break;
            case 24:
               this.bitField0_ |= 2;
               this.number_ = var1.readInt32();
               break;
            case 32:
               var19 = var1.readEnum();
               DescriptorProtos$FieldDescriptorProto$Label var18 = DescriptorProtos$FieldDescriptorProto$Label.valueOf(var19);
               if(var18 == null) {
                  var4.mergeVarintField(4, var19);
               } else {
                  this.bitField0_ |= 4;
                  this.label_ = var19;
               }
               break;
            case 40:
               var19 = var1.readEnum();
               DescriptorProtos$FieldDescriptorProto$Type var8 = DescriptorProtos$FieldDescriptorProto$Type.valueOf(var19);
               if(var8 == null) {
                  var4.mergeVarintField(5, var19);
               } else {
                  this.bitField0_ |= 8;
                  this.type_ = var19;
               }
               break;
            case 50:
               var17 = var1.readBytes();
               this.bitField0_ |= 16;
               this.typeName_ = var17;
               break;
            case 58:
               var17 = var1.readBytes();
               this.bitField0_ |= 64;
               this.defaultValue_ = var17;
               break;
            case 66:
               DescriptorProtos$FieldOptions$Builder var7 = null;
               if((this.bitField0_ & 256) == 256) {
                  var7 = this.options_.toBuilder();
               }

               this.options_ = (DescriptorProtos$FieldOptions)var1.readMessage(DescriptorProtos$FieldOptions.PARSER, var2);
               if(var7 != null) {
                  var7.mergeFrom(this.options_);
                  this.options_ = var7.buildPartial();
               }

               this.bitField0_ |= 256;
               break;
            case 72:
               this.bitField0_ |= 128;
               this.oneofIndex_ = var1.readInt32();
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
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$6100();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$6200().ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) == 1;
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

   public boolean hasNumber() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getNumber() {
      return this.number_;
   }

   public boolean hasLabel() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
      DescriptorProtos$FieldDescriptorProto$Label var1 = DescriptorProtos$FieldDescriptorProto$Label.valueOf(this.label_);
      return var1 == null?DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL:var1;
   }

   public boolean hasType() {
      return (this.bitField0_ & 8) == 8;
   }

   public DescriptorProtos$FieldDescriptorProto$Type getType() {
      DescriptorProtos$FieldDescriptorProto$Type var1 = DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.type_);
      return var1 == null?DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE:var1;
   }

   public boolean hasTypeName() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getTypeName() {
      Object var1 = this.typeName_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.typeName_ = var3;
         }

         return var3;
      }
   }

   public ByteString getTypeNameBytes() {
      Object var1 = this.typeName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.typeName_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasExtendee() {
      return (this.bitField0_ & 32) == 32;
   }

   public String getExtendee() {
      Object var1 = this.extendee_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.extendee_ = var3;
         }

         return var3;
      }
   }

   public ByteString getExtendeeBytes() {
      Object var1 = this.extendee_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.extendee_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasDefaultValue() {
      return (this.bitField0_ & 64) == 64;
   }

   public String getDefaultValue() {
      Object var1 = this.defaultValue_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.defaultValue_ = var3;
         }

         return var3;
      }
   }

   public ByteString getDefaultValueBytes() {
      Object var1 = this.defaultValue_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.defaultValue_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasOneofIndex() {
      return (this.bitField0_ & 128) == 128;
   }

   public int getOneofIndex() {
      return this.oneofIndex_;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 256) == 256;
   }

   public DescriptorProtos$FieldOptions getOptions() {
      return this.options_ == null?DescriptorProtos$FieldOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$FieldOptions.getDefaultInstance():this.options_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(this.hasOptions() && !this.getOptions().isInitialized()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getNameBytes());
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeBytes(2, this.getExtendeeBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeInt32(3, this.number_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeEnum(4, this.label_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeEnum(5, this.type_);
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBytes(6, this.getTypeNameBytes());
      }

      if((this.bitField0_ & 64) == 64) {
         var1.writeBytes(7, this.getDefaultValueBytes());
      }

      if((this.bitField0_ & 256) == 256) {
         var1.writeMessage(8, this.getOptions());
      }

      if((this.bitField0_ & 128) == 128) {
         var1.writeInt32(9, this.oneofIndex_);
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
            var1 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeBytesSize(2, this.getExtendeeBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeInt32Size(3, this.number_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeEnumSize(4, this.label_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeEnumSize(5, this.type_);
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBytesSize(6, this.getTypeNameBytes());
         }

         if((this.bitField0_ & 64) == 64) {
            var1 += CodedOutputStream.computeBytesSize(7, this.getDefaultValueBytes());
         }

         if((this.bitField0_ & 256) == 256) {
            var1 += CodedOutputStream.computeMessageSize(8, this.getOptions());
         }

         if((this.bitField0_ & 128) == 128) {
            var1 += CodedOutputStream.computeInt32Size(9, this.oneofIndex_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder(DescriptorProtos$FieldDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$FieldDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$FieldDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$FieldDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$FieldDescriptorProto$Builder var2 = new DescriptorProtos$FieldDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$FieldDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$FieldDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$6602(DescriptorProtos$FieldDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static int access$6702(DescriptorProtos$FieldDescriptorProto var0, int var1) {
      return var0.number_ = var1;
   }

   // $FF: synthetic method
   static int access$6802(DescriptorProtos$FieldDescriptorProto var0, int var1) {
      return var0.label_ = var1;
   }

   // $FF: synthetic method
   static int access$6902(DescriptorProtos$FieldDescriptorProto var0, int var1) {
      return var0.type_ = var1;
   }

   // $FF: synthetic method
   static Object access$7002(DescriptorProtos$FieldDescriptorProto var0, Object var1) {
      return var0.typeName_ = var1;
   }

   // $FF: synthetic method
   static Object access$7102(DescriptorProtos$FieldDescriptorProto var0, Object var1) {
      return var0.extendee_ = var1;
   }

   // $FF: synthetic method
   static Object access$7202(DescriptorProtos$FieldDescriptorProto var0, Object var1) {
      return var0.defaultValue_ = var1;
   }

   // $FF: synthetic method
   static int access$7302(DescriptorProtos$FieldDescriptorProto var0, int var1) {
      return var0.oneofIndex_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$FieldOptions access$7402(DescriptorProtos$FieldDescriptorProto var0, DescriptorProtos$FieldOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$7502(DescriptorProtos$FieldDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$6600(DescriptorProtos$FieldDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static Object access$7000(DescriptorProtos$FieldDescriptorProto var0) {
      return var0.typeName_;
   }

   // $FF: synthetic method
   static Object access$7100(DescriptorProtos$FieldDescriptorProto var0) {
      return var0.extendee_;
   }

   // $FF: synthetic method
   static Object access$7200(DescriptorProtos$FieldDescriptorProto var0) {
      return var0.defaultValue_;
   }

   // $FF: synthetic method
   DescriptorProtos$FieldDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
