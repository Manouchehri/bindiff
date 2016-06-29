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
import com.google.protobuf.Message;
import com.google.protobuf.StringValue;
import com.google.protobuf.StringValue$1;
import com.google.protobuf.StringValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class StringValue$Builder extends GeneratedMessage$Builder implements StringValueOrBuilder {
   private Object value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
   }

   private StringValue$Builder() {
      this.value_ = "";
      this.maybeForceBuilderInitialization();
   }

   private StringValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.value_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public StringValue$Builder clear() {
      super.clear();
      this.value_ = "";
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
   }

   public StringValue getDefaultInstanceForType() {
      return StringValue.getDefaultInstance();
   }

   public StringValue build() {
      StringValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public StringValue buildPartial() {
      StringValue var1 = new StringValue(this, (StringValue$1)null);
      StringValue.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public StringValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof StringValue) {
         return this.mergeFrom((StringValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public StringValue$Builder mergeFrom(StringValue var1) {
      if(var1 == StringValue.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getValue().isEmpty()) {
            this.value_ = StringValue.access$300(var1);
            this.onChanged();
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public StringValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      StringValue var3 = null;

      try {
         var3 = (StringValue)StringValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (StringValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public String getValue() {
      Object var1 = this.value_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.value_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getValueBytes() {
      Object var1 = this.value_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.value_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public StringValue$Builder setValue(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.value_ = var1;
         this.onChanged();
         return this;
      }
   }

   public StringValue$Builder clearValue() {
      this.value_ = StringValue.getDefaultInstance().getValue();
      this.onChanged();
      return this;
   }

   public StringValue$Builder setValueBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.value_ = var1;
         this.onChanged();
         return this;
      }
   }

   public final StringValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final StringValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   StringValue$Builder(StringValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   StringValue$Builder(GeneratedMessage$BuilderParent var1, StringValue$1 var2) {
      this(var1);
   }
}
