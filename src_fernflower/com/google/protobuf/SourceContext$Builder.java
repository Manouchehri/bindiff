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
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$1;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.UnknownFieldSet;

public final class SourceContext$Builder extends GeneratedMessage$Builder implements SourceContextOrBuilder {
   private Object fileName_;

   public static final Descriptors$Descriptor getDescriptor() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
   }

   private SourceContext$Builder() {
      this.fileName_ = "";
      this.maybeForceBuilderInitialization();
   }

   private SourceContext$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.fileName_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public SourceContext$Builder clear() {
      super.clear();
      this.fileName_ = "";
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
   }

   public SourceContext getDefaultInstanceForType() {
      return SourceContext.getDefaultInstance();
   }

   public SourceContext build() {
      SourceContext var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public SourceContext buildPartial() {
      SourceContext var1 = new SourceContext(this, (SourceContext$1)null);
      SourceContext.access$302(var1, this.fileName_);
      this.onBuilt();
      return var1;
   }

   public SourceContext$Builder mergeFrom(Message var1) {
      if(var1 instanceof SourceContext) {
         return this.mergeFrom((SourceContext)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public SourceContext$Builder mergeFrom(SourceContext var1) {
      if(var1 == SourceContext.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getFileName().isEmpty()) {
            this.fileName_ = SourceContext.access$300(var1);
            this.onChanged();
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public SourceContext$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      SourceContext var3 = null;

      try {
         var3 = (SourceContext)SourceContext.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (SourceContext)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public String getFileName() {
      Object var1 = this.fileName_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.fileName_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getFileNameBytes() {
      Object var1 = this.fileName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.fileName_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public SourceContext$Builder setFileName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.fileName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public SourceContext$Builder clearFileName() {
      this.fileName_ = SourceContext.getDefaultInstance().getFileName();
      this.onChanged();
      return this;
   }

   public SourceContext$Builder setFileNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.fileName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public final SourceContext$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final SourceContext$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   SourceContext$Builder(SourceContext$1 var1) {
      this();
   }

   // $FF: synthetic method
   SourceContext$Builder(GeneratedMessage$BuilderParent var1, SourceContext$1 var2) {
      this(var1);
   }
}
