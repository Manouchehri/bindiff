package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field$1;
import com.google.protobuf.Field$Builder;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.FieldOrBuilder;
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

public final class Field extends GeneratedMessage implements FieldOrBuilder {
   private int bitField0_;
   public static final int KIND_FIELD_NUMBER = 1;
   private int kind_;
   public static final int CARDINALITY_FIELD_NUMBER = 2;
   private int cardinality_;
   public static final int NUMBER_FIELD_NUMBER = 3;
   private int number_;
   public static final int NAME_FIELD_NUMBER = 4;
   private volatile Object name_;
   public static final int TYPE_URL_FIELD_NUMBER = 6;
   private volatile Object typeUrl_;
   public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
   private int oneofIndex_;
   public static final int PACKED_FIELD_NUMBER = 8;
   private boolean packed_;
   public static final int OPTIONS_FIELD_NUMBER = 9;
   private List options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Field DEFAULT_INSTANCE = new Field();
   public static final Parser PARSER = new Field$1();

   private Field(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Field() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.kind_ = 0;
      this.cardinality_ = 0;
      this.number_ = 0;
      this.name_ = "";
      this.typeUrl_ = "";
      this.oneofIndex_ = 0;
      this.packed_ = false;
      this.options_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Field(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;

      try {
         boolean var4 = false;

         while(!var4) {
            int var5 = var1.readTag();
            ByteString var6;
            int var15;
            switch(var5) {
            case 0:
               var4 = true;
               break;
            case 8:
               var15 = var1.readEnum();
               this.kind_ = var15;
               break;
            case 16:
               var15 = var1.readEnum();
               this.cardinality_ = var15;
               break;
            case 24:
               this.number_ = var1.readInt32();
               break;
            case 34:
               var6 = var1.readBytes();
               this.name_ = var6;
               break;
            case 50:
               var6 = var1.readBytes();
               this.typeUrl_ = var6;
               break;
            case 56:
               this.oneofIndex_ = var1.readInt32();
               break;
            case 64:
               this.packed_ = var1.readBool();
               break;
            case 74:
               if((var3 & 128) != 128) {
                  this.options_ = new ArrayList();
                  var3 |= 128;
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
         if((var3 & 128) == 128) {
            this.options_ = Collections.unmodifiableList(this.options_);
         }

         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Field_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
   }

   public int getKindValue() {
      return this.kind_;
   }

   public Field$Kind getKind() {
      Field$Kind var1 = Field$Kind.valueOf(this.kind_);
      return var1 == null?Field$Kind.UNRECOGNIZED:var1;
   }

   public int getCardinalityValue() {
      return this.cardinality_;
   }

   public Field$Cardinality getCardinality() {
      Field$Cardinality var1 = Field$Cardinality.valueOf(this.cardinality_);
      return var1 == null?Field$Cardinality.UNRECOGNIZED:var1;
   }

   public int getNumber() {
      return this.number_;
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

   public String getTypeUrl() {
      Object var1 = this.typeUrl_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.typeUrl_ = var3;
         }

         return var3;
      }
   }

   public ByteString getTypeUrlBytes() {
      Object var1 = this.typeUrl_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.typeUrl_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public int getOneofIndex() {
      return this.oneofIndex_;
   }

   public boolean getPacked() {
      return this.packed_;
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
      if(this.kind_ != Field$Kind.TYPE_UNKNOWN.getNumber()) {
         var1.writeEnum(1, this.kind_);
      }

      if(this.cardinality_ != Field$Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
         var1.writeEnum(2, this.cardinality_);
      }

      if(this.number_ != 0) {
         var1.writeInt32(3, this.number_);
      }

      if(!this.getNameBytes().isEmpty()) {
         var1.writeBytes(4, this.getNameBytes());
      }

      if(!this.getTypeUrlBytes().isEmpty()) {
         var1.writeBytes(6, this.getTypeUrlBytes());
      }

      if(this.oneofIndex_ != 0) {
         var1.writeInt32(7, this.oneofIndex_);
      }

      if(this.packed_) {
         var1.writeBool(8, this.packed_);
      }

      for(int var2 = 0; var2 < this.options_.size(); ++var2) {
         var1.writeMessage(9, (MessageLite)this.options_.get(var2));
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.kind_ != Field$Kind.TYPE_UNKNOWN.getNumber()) {
            var1 += CodedOutputStream.computeEnumSize(1, this.kind_);
         }

         if(this.cardinality_ != Field$Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            var1 += CodedOutputStream.computeEnumSize(2, this.cardinality_);
         }

         if(this.number_ != 0) {
            var1 += CodedOutputStream.computeInt32Size(3, this.number_);
         }

         if(!this.getNameBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(4, this.getNameBytes());
         }

         if(!this.getTypeUrlBytes().isEmpty()) {
            var1 += CodedOutputStream.computeBytesSize(6, this.getTypeUrlBytes());
         }

         if(this.oneofIndex_ != 0) {
            var1 += CodedOutputStream.computeInt32Size(7, this.oneofIndex_);
         }

         if(this.packed_) {
            var1 += CodedOutputStream.computeBoolSize(8, this.packed_);
         }

         for(int var2 = 0; var2 < this.options_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(9, (MessageLite)this.options_.get(var2));
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static Field parseFrom(ByteString var0) {
      return (Field)PARSER.parseFrom(var0);
   }

   public static Field parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Field)PARSER.parseFrom(var0, var1);
   }

   public static Field parseFrom(byte[] var0) {
      return (Field)PARSER.parseFrom(var0);
   }

   public static Field parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Field)PARSER.parseFrom(var0, var1);
   }

   public static Field parseFrom(InputStream var0) {
      return (Field)PARSER.parseFrom(var0);
   }

   public static Field parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Field)PARSER.parseFrom(var0, var1);
   }

   public static Field parseDelimitedFrom(InputStream var0) {
      return (Field)PARSER.parseDelimitedFrom(var0);
   }

   public static Field parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Field)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Field parseFrom(CodedInputStream var0) {
      return (Field)PARSER.parseFrom(var0);
   }

   public static Field parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Field)PARSER.parseFrom(var0, var1);
   }

   public Field$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Field$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Field$Builder newBuilder(Field var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Field$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Field$Builder((Field$1)null):(new Field$Builder((Field$1)null)).mergeFrom(this);
   }

   protected Field$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Field$Builder var2 = new Field$Builder(var1, (Field$1)null);
      return var2;
   }

   public static Field getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Field getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Field(GeneratedMessage$Builder var1, Field$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int access$302(Field var0, int var1) {
      return var0.kind_ = var1;
   }

   // $FF: synthetic method
   static int access$402(Field var0, int var1) {
      return var0.cardinality_ = var1;
   }

   // $FF: synthetic method
   static int access$502(Field var0, int var1) {
      return var0.number_ = var1;
   }

   // $FF: synthetic method
   static Object access$602(Field var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static Object access$702(Field var0, Object var1) {
      return var0.typeUrl_ = var1;
   }

   // $FF: synthetic method
   static int access$802(Field var0, int var1) {
      return var0.oneofIndex_ = var1;
   }

   // $FF: synthetic method
   static boolean access$902(Field var0, boolean var1) {
      return var0.packed_ = var1;
   }

   // $FF: synthetic method
   static List access$1002(Field var0, List var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$1102(Field var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static int access$300(Field var0) {
      return var0.kind_;
   }

   // $FF: synthetic method
   static int access$400(Field var0) {
      return var0.cardinality_;
   }

   // $FF: synthetic method
   static Object access$600(Field var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   static Object access$700(Field var0) {
      return var0.typeUrl_;
   }

   // $FF: synthetic method
   static List access$1000(Field var0) {
      return var0.options_;
   }

   // $FF: synthetic method
   Field(CodedInputStream var1, ExtensionRegistryLite var2, Field$1 var3) {
      this(var1, var2);
   }
}
