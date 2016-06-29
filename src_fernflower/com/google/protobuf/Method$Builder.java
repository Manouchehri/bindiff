package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ApiProto;
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
import com.google.protobuf.Method;
import com.google.protobuf.Method$1;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Method$Builder extends GeneratedMessage$Builder implements MethodOrBuilder {
   private int bitField0_;
   private Object name_;
   private Object requestTypeUrl_;
   private boolean requestStreaming_;
   private Object responseTypeUrl_;
   private boolean responseStreaming_;
   private List options_;
   private RepeatedFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return ApiProto.internal_static_google_protobuf_Method_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
   }

   private Method$Builder() {
      this.name_ = "";
      this.requestTypeUrl_ = "";
      this.responseTypeUrl_ = "";
      this.options_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private Method$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.requestTypeUrl_ = "";
      this.responseTypeUrl_ = "";
      this.options_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getOptionsFieldBuilder();
      }

   }

   public Method$Builder clear() {
      super.clear();
      this.name_ = "";
      this.requestTypeUrl_ = "";
      this.requestStreaming_ = false;
      this.responseTypeUrl_ = "";
      this.responseStreaming_ = false;
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -33;
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return ApiProto.internal_static_google_protobuf_Method_descriptor;
   }

   public Method getDefaultInstanceForType() {
      return Method.getDefaultInstance();
   }

   public Method build() {
      Method var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Method buildPartial() {
      Method var1 = new Method(this, (Method$1)null);
      int var2 = this.bitField0_;
      byte var3 = 0;
      Method.access$302(var1, this.name_);
      Method.access$402(var1, this.requestTypeUrl_);
      Method.access$502(var1, this.requestStreaming_);
      Method.access$602(var1, this.responseTypeUrl_);
      Method.access$702(var1, this.responseStreaming_);
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 32) == 32) {
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -33;
         }

         Method.access$802(var1, this.options_);
      } else {
         Method.access$802(var1, this.optionsBuilder_.build());
      }

      Method.access$902(var1, var3);
      this.onBuilt();
      return var1;
   }

   public Method$Builder mergeFrom(Message var1) {
      if(var1 instanceof Method) {
         return this.mergeFrom((Method)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Method$Builder mergeFrom(Method var1) {
      if(var1 == Method.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getName().isEmpty()) {
            this.name_ = Method.access$300(var1);
            this.onChanged();
         }

         if(!var1.getRequestTypeUrl().isEmpty()) {
            this.requestTypeUrl_ = Method.access$400(var1);
            this.onChanged();
         }

         if(var1.getRequestStreaming()) {
            this.setRequestStreaming(var1.getRequestStreaming());
         }

         if(!var1.getResponseTypeUrl().isEmpty()) {
            this.responseTypeUrl_ = Method.access$600(var1);
            this.onChanged();
         }

         if(var1.getResponseStreaming()) {
            this.setResponseStreaming(var1.getResponseStreaming());
         }

         if(this.optionsBuilder_ == null) {
            if(!Method.access$800(var1).isEmpty()) {
               if(this.options_.isEmpty()) {
                  this.options_ = Method.access$800(var1);
                  this.bitField0_ &= -33;
               } else {
                  this.ensureOptionsIsMutable();
                  this.options_.addAll(Method.access$800(var1));
               }

               this.onChanged();
            }
         } else if(!Method.access$800(var1).isEmpty()) {
            if(this.optionsBuilder_.isEmpty()) {
               this.optionsBuilder_.dispose();
               this.optionsBuilder_ = null;
               this.options_ = Method.access$800(var1);
               this.bitField0_ &= -33;
               this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOptionsFieldBuilder():null;
            } else {
               this.optionsBuilder_.addAllMessages(Method.access$800(var1));
            }
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Method$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Method var3 = null;

      try {
         var3 = (Method)Method.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Method)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public String getName() {
      Object var1 = this.name_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public Method$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Method$Builder clearName() {
      this.name_ = Method.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public Method$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public String getRequestTypeUrl() {
      Object var1 = this.requestTypeUrl_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.requestTypeUrl_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getRequestTypeUrlBytes() {
      Object var1 = this.requestTypeUrl_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.requestTypeUrl_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public Method$Builder setRequestTypeUrl(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.requestTypeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Method$Builder clearRequestTypeUrl() {
      this.requestTypeUrl_ = Method.getDefaultInstance().getRequestTypeUrl();
      this.onChanged();
      return this;
   }

   public Method$Builder setRequestTypeUrlBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.requestTypeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean getRequestStreaming() {
      return this.requestStreaming_;
   }

   public Method$Builder setRequestStreaming(boolean var1) {
      this.requestStreaming_ = var1;
      this.onChanged();
      return this;
   }

   public Method$Builder clearRequestStreaming() {
      this.requestStreaming_ = false;
      this.onChanged();
      return this;
   }

   public String getResponseTypeUrl() {
      Object var1 = this.responseTypeUrl_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.responseTypeUrl_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getResponseTypeUrlBytes() {
      Object var1 = this.responseTypeUrl_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.responseTypeUrl_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public Method$Builder setResponseTypeUrl(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.responseTypeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Method$Builder clearResponseTypeUrl() {
      this.responseTypeUrl_ = Method.getDefaultInstance().getResponseTypeUrl();
      this.onChanged();
      return this;
   }

   public Method$Builder setResponseTypeUrlBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.responseTypeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean getResponseStreaming() {
      return this.responseStreaming_;
   }

   public Method$Builder setResponseStreaming(boolean var1) {
      this.responseStreaming_ = var1;
      this.onChanged();
      return this;
   }

   public Method$Builder clearResponseStreaming() {
      this.responseStreaming_ = false;
      this.onChanged();
      return this;
   }

   private void ensureOptionsIsMutable() {
      if((this.bitField0_ & 32) != 32) {
         this.options_ = new ArrayList(this.options_);
         this.bitField0_ |= 32;
      }

   }

   public List getOptionsList() {
      return this.optionsBuilder_ == null?Collections.unmodifiableList(this.options_):this.optionsBuilder_.getMessageList();
   }

   public int getOptionsCount() {
      return this.optionsBuilder_ == null?this.options_.size():this.optionsBuilder_.getCount();
   }

   public Option getOptions(int var1) {
      return this.optionsBuilder_ == null?(Option)this.options_.get(var1):(Option)this.optionsBuilder_.getMessage(var1);
   }

   public Method$Builder setOptions(int var1, Option var2) {
      if(this.optionsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2);
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public Method$Builder setOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Method$Builder addOptions(Option var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureOptionsIsMutable();
         this.options_.add(var1);
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1);
      }

      return this;
   }

   public Method$Builder addOptions(int var1, Option var2) {
      if(this.optionsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2);
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public Method$Builder addOptions(Option$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Method$Builder addOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Method$Builder addAllOptions(Iterable var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.options_);
         this.onChanged();
      } else {
         this.optionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Method$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -33;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Method$Builder removeOptions(int var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.remove(var1);
         this.onChanged();
      } else {
         this.optionsBuilder_.remove(var1);
      }

      return this;
   }

   public Option$Builder getOptionsBuilder(int var1) {
      return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(var1);
   }

   public OptionOrBuilder getOptionsOrBuilder(int var1) {
      return this.optionsBuilder_ == null?(OptionOrBuilder)this.options_.get(var1):(OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(var1);
   }

   public List getOptionsOrBuilderList() {
      return this.optionsBuilder_ != null?this.optionsBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.options_);
   }

   public Option$Builder addOptionsBuilder() {
      return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
   }

   public Option$Builder addOptionsBuilder(int var1) {
      return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(var1, Option.getDefaultInstance());
   }

   public List getOptionsBuilderList() {
      return this.getOptionsFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 32) == 32, this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public final Method$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Method$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Method$Builder(Method$1 var1) {
      this();
   }

   // $FF: synthetic method
   Method$Builder(GeneratedMessage$BuilderParent var1, Method$1 var2) {
      this(var1);
   }
}
