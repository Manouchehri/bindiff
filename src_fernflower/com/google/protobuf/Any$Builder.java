package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Any$1;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import com.google.protobuf.UnknownFieldSet;

public final class Any$Builder extends GeneratedMessage$Builder implements AnyOrBuilder {
   private Object typeUrl_;
   private ByteString value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return AnyProto.internal_static_google_protobuf_Any_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
   }

   private Any$Builder() {
      this.typeUrl_ = "";
      this.value_ = ByteString.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private Any$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.typeUrl_ = "";
      this.value_ = ByteString.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Any$Builder clear() {
      super.clear();
      this.typeUrl_ = "";
      this.value_ = ByteString.EMPTY;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return AnyProto.internal_static_google_protobuf_Any_descriptor;
   }

   public Any getDefaultInstanceForType() {
      return Any.getDefaultInstance();
   }

   public Any build() {
      Any var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Any buildPartial() {
      Any var1 = new Any(this, (Any$1)null);
      Any.access$302(var1, this.typeUrl_);
      Any.access$402(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public Any$Builder mergeFrom(Message var1) {
      if(var1 instanceof Any) {
         return this.mergeFrom((Any)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Any$Builder mergeFrom(Any var1) {
      if(var1 == Any.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getTypeUrl().isEmpty()) {
            this.typeUrl_ = Any.access$300(var1);
            this.onChanged();
         }

         if(var1.getValue() != ByteString.EMPTY) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Any$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Any var3 = null;

      try {
         var3 = (Any)Any.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Any)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public String getTypeUrl() {
      Object var1 = this.typeUrl_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.typeUrl_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public Any$Builder setTypeUrl(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.typeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Any$Builder clearTypeUrl() {
      this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
      this.onChanged();
      return this;
   }

   public Any$Builder setTypeUrlBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.typeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public ByteString getValue() {
      return this.value_;
   }

   public Any$Builder setValue(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.value_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Any$Builder clearValue() {
      this.value_ = Any.getDefaultInstance().getValue();
      this.onChanged();
      return this;
   }

   public final Any$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Any$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Any$Builder(Any$1 var1) {
      this();
   }

   // $FF: synthetic method
   Any$Builder(GeneratedMessage$BuilderParent var1, Any$1 var2) {
      this(var1);
   }
}
