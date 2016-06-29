package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value$1;
import com.google.protobuf.Value$Builder;
import com.google.protobuf.Value$KindCase;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class Value extends GeneratedMessage implements ValueOrBuilder {
   private int kindCase_;
   private Object kind_;
   public static final int NULL_VALUE_FIELD_NUMBER = 1;
   public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
   public static final int STRING_VALUE_FIELD_NUMBER = 3;
   public static final int BOOL_VALUE_FIELD_NUMBER = 4;
   public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
   public static final int LIST_VALUE_FIELD_NUMBER = 6;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final Value DEFAULT_INSTANCE = new Value();
   public static final Parser PARSER = new Value$1();

   private Value(GeneratedMessage$Builder var1) {
      super(var1);
      this.kindCase_ = 0;
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private Value() {
      this.kindCase_ = 0;
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   public final UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private Value(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 8:
               int var17 = var1.readEnum();
               this.kindCase_ = 1;
               this.kind_ = Integer.valueOf(var17);
               break;
            case 17:
               this.kindCase_ = 2;
               this.kind_ = Double.valueOf(var1.readDouble());
               break;
            case 26:
               ByteString var16 = var1.readBytes();
               this.kindCase_ = 3;
               this.kind_ = var16;
               break;
            case 32:
               this.kindCase_ = 4;
               this.kind_ = Boolean.valueOf(var1.readBool());
               break;
            case 42:
               Struct$Builder var15 = null;
               if(this.kindCase_ == 5) {
                  var15 = ((Struct)this.kind_).toBuilder();
               }

               this.kind_ = var1.readMessage(Struct.PARSER, var2);
               if(var15 != null) {
                  var15.mergeFrom((Struct)this.kind_);
                  this.kind_ = var15.buildPartial();
               }

               this.kindCase_ = 5;
               break;
            case 50:
               ListValue$Builder var6 = null;
               if(this.kindCase_ == 6) {
                  var6 = ((ListValue)this.kind_).toBuilder();
               }

               this.kind_ = var1.readMessage(ListValue.PARSER, var2);
               if(var6 != null) {
                  var6.mergeFrom((ListValue)this.kind_);
                  this.kind_ = var6.buildPartial();
               }

               this.kindCase_ = 6;
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
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return StructProto.internal_static_google_protobuf_Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
   }

   public Value$KindCase getKindCase() {
      return Value$KindCase.valueOf(this.kindCase_);
   }

   public int getNullValueValue() {
      return this.kindCase_ == 1?((Integer)this.kind_).intValue():0;
   }

   public NullValue getNullValue() {
      if(this.kindCase_ == 1) {
         NullValue var1 = NullValue.valueOf(((Integer)this.kind_).intValue());
         return var1 == null?NullValue.UNRECOGNIZED:var1;
      } else {
         return NullValue.NULL_VALUE;
      }
   }

   public double getNumberValue() {
      return this.kindCase_ == 2?((Double)this.kind_).doubleValue():0.0D;
   }

   public String getStringValue() {
      Object var1 = "";
      if(this.kindCase_ == 3) {
         var1 = this.kind_;
      }

      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8() && this.kindCase_ == 3) {
            this.kind_ = var3;
         }

         return var3;
      }
   }

   public ByteString getStringValueBytes() {
      Object var1 = "";
      if(this.kindCase_ == 3) {
         var1 = this.kind_;
      }

      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         if(this.kindCase_ == 3) {
            this.kind_ = var2;
         }

         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean getBoolValue() {
      return this.kindCase_ == 4?((Boolean)this.kind_).booleanValue():false;
   }

   public Struct getStructValue() {
      return this.kindCase_ == 5?(Struct)this.kind_:Struct.getDefaultInstance();
   }

   public StructOrBuilder getStructValueOrBuilder() {
      return this.kindCase_ == 5?(Struct)this.kind_:Struct.getDefaultInstance();
   }

   public ListValue getListValue() {
      return this.kindCase_ == 6?(ListValue)this.kind_:ListValue.getDefaultInstance();
   }

   public ListValueOrBuilder getListValueOrBuilder() {
      return this.kindCase_ == 6?(ListValue)this.kind_:ListValue.getDefaultInstance();
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
      if(this.kindCase_ == 1) {
         var1.writeEnum(1, ((Integer)this.kind_).intValue());
      }

      if(this.kindCase_ == 2) {
         var1.writeDouble(2, ((Double)this.kind_).doubleValue());
      }

      if(this.kindCase_ == 3) {
         var1.writeBytes(3, this.getStringValueBytes());
      }

      if(this.kindCase_ == 4) {
         var1.writeBool(4, ((Boolean)this.kind_).booleanValue());
      }

      if(this.kindCase_ == 5) {
         var1.writeMessage(5, (Struct)this.kind_);
      }

      if(this.kindCase_ == 6) {
         var1.writeMessage(6, (ListValue)this.kind_);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if(this.kindCase_ == 1) {
            var1 += CodedOutputStream.computeEnumSize(1, ((Integer)this.kind_).intValue());
         }

         if(this.kindCase_ == 2) {
            var1 += CodedOutputStream.computeDoubleSize(2, ((Double)this.kind_).doubleValue());
         }

         if(this.kindCase_ == 3) {
            var1 += CodedOutputStream.computeBytesSize(3, this.getStringValueBytes());
         }

         if(this.kindCase_ == 4) {
            var1 += CodedOutputStream.computeBoolSize(4, ((Boolean)this.kind_).booleanValue());
         }

         if(this.kindCase_ == 5) {
            var1 += CodedOutputStream.computeMessageSize(5, (Struct)this.kind_);
         }

         if(this.kindCase_ == 6) {
            var1 += CodedOutputStream.computeMessageSize(6, (ListValue)this.kind_);
         }

         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Value)) {
         return super.equals(var1);
      } else {
         Value var2 = (Value)var1;
         boolean var3 = true;
         var3 = var3 && this.getNullValueValue() == var2.getNullValueValue();
         var3 = var3 && Double.doubleToLongBits(this.getNumberValue()) == Double.doubleToLongBits(var2.getNumberValue());
         var3 = var3 && this.getStringValue().equals(var2.getStringValue());
         var3 = var3 && this.getBoolValue() == var2.getBoolValue();
         var3 = var3 && this.getStructValue().equals(var2.getStructValue());
         var3 = var3 && this.getListValue().equals(var2.getListValue());
         return var3;
      }
   }

   public int hashCode() {
      if(this.memoizedHashCode != 0) {
         return this.memoizedHashCode;
      } else {
         byte var1 = 41;
         int var2 = 19 * var1 + this.getDescriptorForType().hashCode();
         var2 = 37 * var2 + 1;
         var2 = 53 * var2 + this.getNullValueValue();
         var2 = 37 * var2 + 2;
         var2 = 53 * var2 + Internal.hashLong(Double.doubleToLongBits(this.getNumberValue()));
         var2 = 37 * var2 + 3;
         var2 = 53 * var2 + this.getStringValue().hashCode();
         var2 = 37 * var2 + 4;
         var2 = 53 * var2 + Internal.hashBoolean(this.getBoolValue());
         var2 = 37 * var2 + 5;
         var2 = 53 * var2 + this.getStructValue().hashCode();
         var2 = 37 * var2 + 6;
         var2 = 53 * var2 + this.getListValue().hashCode();
         var2 = 29 * var2 + this.unknownFields.hashCode();
         this.memoizedHashCode = var2;
         return var2;
      }
   }

   public static Value parseFrom(ByteString var0) {
      return (Value)PARSER.parseFrom(var0);
   }

   public static Value parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (Value)PARSER.parseFrom(var0, var1);
   }

   public static Value parseFrom(byte[] var0) {
      return (Value)PARSER.parseFrom(var0);
   }

   public static Value parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (Value)PARSER.parseFrom(var0, var1);
   }

   public static Value parseFrom(InputStream var0) {
      return (Value)PARSER.parseFrom(var0);
   }

   public static Value parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Value)PARSER.parseFrom(var0, var1);
   }

   public static Value parseDelimitedFrom(InputStream var0) {
      return (Value)PARSER.parseDelimitedFrom(var0);
   }

   public static Value parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (Value)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static Value parseFrom(CodedInputStream var0) {
      return (Value)PARSER.parseFrom(var0);
   }

   public static Value parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (Value)PARSER.parseFrom(var0, var1);
   }

   public Value$Builder newBuilderForType() {
      return newBuilder();
   }

   public static Value$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Value$Builder newBuilder(Value var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public Value$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new Value$Builder((Value$1)null):(new Value$Builder((Value$1)null)).mergeFrom(this);
   }

   protected Value$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      Value$Builder var2 = new Value$Builder(var1, (Value$1)null);
      return var2;
   }

   public static Value getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Value getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Value(GeneratedMessage$Builder var1, Value$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$302(Value var0, Object var1) {
      return var0.kind_ = var1;
   }

   // $FF: synthetic method
   static int access$402(Value var0, int var1) {
      return var0.kindCase_ = var1;
   }

   // $FF: synthetic method
   static Object access$300(Value var0) {
      return var0.kind_;
   }

   // $FF: synthetic method
   Value(CodedInputStream var1, ExtensionRegistryLite var2, Value$1 var3) {
      this(var1, var2);
   }
}
