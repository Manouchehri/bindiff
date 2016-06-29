package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.NullValue;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.Value$1;
import com.google.protobuf.Value$2;
import com.google.protobuf.Value$KindCase;
import com.google.protobuf.ValueOrBuilder;

public final class Value$Builder extends GeneratedMessage$Builder implements ValueOrBuilder {
   private int kindCase_;
   private Object kind_;
   private SingleFieldBuilder structValueBuilder_;
   private SingleFieldBuilder listValueBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return StructProto.internal_static_google_protobuf_Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
   }

   private Value$Builder() {
      this.kindCase_ = 0;
      this.maybeForceBuilderInitialization();
   }

   private Value$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.kindCase_ = 0;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Value$Builder clear() {
      super.clear();
      this.kindCase_ = 0;
      this.kind_ = null;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return StructProto.internal_static_google_protobuf_Value_descriptor;
   }

   public Value getDefaultInstanceForType() {
      return Value.getDefaultInstance();
   }

   public Value build() {
      Value var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Value buildPartial() {
      Value var1 = new Value(this, (Value$1)null);
      if(this.kindCase_ == 1) {
         Value.access$302(var1, this.kind_);
      }

      if(this.kindCase_ == 2) {
         Value.access$302(var1, this.kind_);
      }

      if(this.kindCase_ == 3) {
         Value.access$302(var1, this.kind_);
      }

      if(this.kindCase_ == 4) {
         Value.access$302(var1, this.kind_);
      }

      if(this.kindCase_ == 5) {
         if(this.structValueBuilder_ == null) {
            Value.access$302(var1, this.kind_);
         } else {
            Value.access$302(var1, this.structValueBuilder_.build());
         }
      }

      if(this.kindCase_ == 6) {
         if(this.listValueBuilder_ == null) {
            Value.access$302(var1, this.kind_);
         } else {
            Value.access$302(var1, this.listValueBuilder_.build());
         }
      }

      Value.access$402(var1, this.kindCase_);
      this.onBuilt();
      return var1;
   }

   public Value$Builder mergeFrom(Message var1) {
      if(var1 instanceof Value) {
         return this.mergeFrom((Value)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Value$Builder mergeFrom(Value var1) {
      if(var1 == Value.getDefaultInstance()) {
         return this;
      } else {
         switch(Value$2.$SwitchMap$com$google$protobuf$Value$KindCase[var1.getKindCase().ordinal()]) {
         case 1:
            this.setNullValueValue(var1.getNullValueValue());
            break;
         case 2:
            this.setNumberValue(var1.getNumberValue());
            break;
         case 3:
            this.kindCase_ = 3;
            this.kind_ = Value.access$300(var1);
            this.onChanged();
            break;
         case 4:
            this.setBoolValue(var1.getBoolValue());
            break;
         case 5:
            this.mergeStructValue(var1.getStructValue());
            break;
         case 6:
            this.mergeListValue(var1.getListValue());
         case 7:
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Value$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Value var3 = null;

      try {
         var3 = (Value)Value.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Value)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public Value$KindCase getKindCase() {
      return Value$KindCase.valueOf(this.kindCase_);
   }

   public Value$Builder clearKind() {
      this.kindCase_ = 0;
      this.kind_ = null;
      this.onChanged();
      return this;
   }

   public int getNullValueValue() {
      return this.kindCase_ == 1?((Integer)this.kind_).intValue():0;
   }

   public Value$Builder setNullValueValue(int var1) {
      this.kindCase_ = 1;
      this.kind_ = Integer.valueOf(var1);
      this.onChanged();
      return this;
   }

   public NullValue getNullValue() {
      if(this.kindCase_ == 1) {
         NullValue var1 = NullValue.valueOf(((Integer)this.kind_).intValue());
         return var1 == null?NullValue.UNRECOGNIZED:var1;
      } else {
         return NullValue.NULL_VALUE;
      }
   }

   public Value$Builder setNullValue(NullValue var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.kindCase_ = 1;
         this.kind_ = Integer.valueOf(var1.getNumber());
         this.onChanged();
         return this;
      }
   }

   public Value$Builder clearNullValue() {
      if(this.kindCase_ == 1) {
         this.kindCase_ = 0;
         this.kind_ = null;
         this.onChanged();
      }

      return this;
   }

   public double getNumberValue() {
      return this.kindCase_ == 2?((Double)this.kind_).doubleValue():0.0D;
   }

   public Value$Builder setNumberValue(double var1) {
      this.kindCase_ = 2;
      this.kind_ = Double.valueOf(var1);
      this.onChanged();
      return this;
   }

   public Value$Builder clearNumberValue() {
      if(this.kindCase_ == 2) {
         this.kindCase_ = 0;
         this.kind_ = null;
         this.onChanged();
      }

      return this;
   }

   public String getStringValue() {
      Object var1 = "";
      if(this.kindCase_ == 3) {
         var1 = this.kind_;
      }

      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(this.kindCase_ == 3 && var2.isValidUtf8()) {
            this.kind_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public Value$Builder setStringValue(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.kindCase_ = 3;
         this.kind_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Value$Builder clearStringValue() {
      if(this.kindCase_ == 3) {
         this.kindCase_ = 0;
         this.kind_ = null;
         this.onChanged();
      }

      return this;
   }

   public Value$Builder setStringValueBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.kindCase_ = 3;
         this.kind_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean getBoolValue() {
      return this.kindCase_ == 4?((Boolean)this.kind_).booleanValue():false;
   }

   public Value$Builder setBoolValue(boolean var1) {
      this.kindCase_ = 4;
      this.kind_ = Boolean.valueOf(var1);
      this.onChanged();
      return this;
   }

   public Value$Builder clearBoolValue() {
      if(this.kindCase_ == 4) {
         this.kindCase_ = 0;
         this.kind_ = null;
         this.onChanged();
      }

      return this;
   }

   public Struct getStructValue() {
      return this.structValueBuilder_ == null?(this.kindCase_ == 5?(Struct)this.kind_:Struct.getDefaultInstance()):(this.kindCase_ == 5?(Struct)this.structValueBuilder_.getMessage():Struct.getDefaultInstance());
   }

   public Value$Builder setStructValue(Struct var1) {
      if(this.structValueBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.kind_ = var1;
         this.onChanged();
      } else {
         this.structValueBuilder_.setMessage(var1);
      }

      this.kindCase_ = 5;
      return this;
   }

   public Value$Builder setStructValue(Struct$Builder var1) {
      if(this.structValueBuilder_ == null) {
         this.kind_ = var1.build();
         this.onChanged();
      } else {
         this.structValueBuilder_.setMessage(var1.build());
      }

      this.kindCase_ = 5;
      return this;
   }

   public Value$Builder mergeStructValue(Struct var1) {
      if(this.structValueBuilder_ == null) {
         if(this.kindCase_ == 5 && this.kind_ != Struct.getDefaultInstance()) {
            this.kind_ = Struct.newBuilder((Struct)this.kind_).mergeFrom(var1).buildPartial();
         } else {
            this.kind_ = var1;
         }

         this.onChanged();
      } else {
         if(this.kindCase_ == 5) {
            this.structValueBuilder_.mergeFrom(var1);
         }

         this.structValueBuilder_.setMessage(var1);
      }

      this.kindCase_ = 5;
      return this;
   }

   public Value$Builder clearStructValue() {
      if(this.structValueBuilder_ == null) {
         if(this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
         }
      } else {
         if(this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.kind_ = null;
         }

         this.structValueBuilder_.clear();
      }

      return this;
   }

   public Struct$Builder getStructValueBuilder() {
      return (Struct$Builder)this.getStructValueFieldBuilder().getBuilder();
   }

   public StructOrBuilder getStructValueOrBuilder() {
      return (StructOrBuilder)(this.kindCase_ == 5 && this.structValueBuilder_ != null?(StructOrBuilder)this.structValueBuilder_.getMessageOrBuilder():(this.kindCase_ == 5?(Struct)this.kind_:Struct.getDefaultInstance()));
   }

   private SingleFieldBuilder getStructValueFieldBuilder() {
      if(this.structValueBuilder_ == null) {
         if(this.kindCase_ != 5) {
            this.kind_ = Struct.getDefaultInstance();
         }

         this.structValueBuilder_ = new SingleFieldBuilder((Struct)this.kind_, this.getParentForChildren(), this.isClean());
         this.kind_ = null;
      }

      this.kindCase_ = 5;
      this.onChanged();
      return this.structValueBuilder_;
   }

   public ListValue getListValue() {
      return this.listValueBuilder_ == null?(this.kindCase_ == 6?(ListValue)this.kind_:ListValue.getDefaultInstance()):(this.kindCase_ == 6?(ListValue)this.listValueBuilder_.getMessage():ListValue.getDefaultInstance());
   }

   public Value$Builder setListValue(ListValue var1) {
      if(this.listValueBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.kind_ = var1;
         this.onChanged();
      } else {
         this.listValueBuilder_.setMessage(var1);
      }

      this.kindCase_ = 6;
      return this;
   }

   public Value$Builder setListValue(ListValue$Builder var1) {
      if(this.listValueBuilder_ == null) {
         this.kind_ = var1.build();
         this.onChanged();
      } else {
         this.listValueBuilder_.setMessage(var1.build());
      }

      this.kindCase_ = 6;
      return this;
   }

   public Value$Builder mergeListValue(ListValue var1) {
      if(this.listValueBuilder_ == null) {
         if(this.kindCase_ == 6 && this.kind_ != ListValue.getDefaultInstance()) {
            this.kind_ = ListValue.newBuilder((ListValue)this.kind_).mergeFrom(var1).buildPartial();
         } else {
            this.kind_ = var1;
         }

         this.onChanged();
      } else {
         if(this.kindCase_ == 6) {
            this.listValueBuilder_.mergeFrom(var1);
         }

         this.listValueBuilder_.setMessage(var1);
      }

      this.kindCase_ = 6;
      return this;
   }

   public Value$Builder clearListValue() {
      if(this.listValueBuilder_ == null) {
         if(this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
         }
      } else {
         if(this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
         }

         this.listValueBuilder_.clear();
      }

      return this;
   }

   public ListValue$Builder getListValueBuilder() {
      return (ListValue$Builder)this.getListValueFieldBuilder().getBuilder();
   }

   public ListValueOrBuilder getListValueOrBuilder() {
      return (ListValueOrBuilder)(this.kindCase_ == 6 && this.listValueBuilder_ != null?(ListValueOrBuilder)this.listValueBuilder_.getMessageOrBuilder():(this.kindCase_ == 6?(ListValue)this.kind_:ListValue.getDefaultInstance()));
   }

   private SingleFieldBuilder getListValueFieldBuilder() {
      if(this.listValueBuilder_ == null) {
         if(this.kindCase_ != 6) {
            this.kind_ = ListValue.getDefaultInstance();
         }

         this.listValueBuilder_ = new SingleFieldBuilder((ListValue)this.kind_, this.getParentForChildren(), this.isClean());
         this.kind_ = null;
      }

      this.kindCase_ = 6;
      this.onChanged();
      return this.listValueBuilder_;
   }

   public final Value$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Value$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Value$Builder(Value$1 var1) {
      this();
   }

   // $FF: synthetic method
   Value$Builder(GeneratedMessage$BuilderParent var1, Value$1 var2) {
      this(var1);
   }
}
