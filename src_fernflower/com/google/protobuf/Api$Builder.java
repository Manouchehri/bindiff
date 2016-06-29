package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Api;
import com.google.protobuf.Api$1;
import com.google.protobuf.ApiOrBuilder;
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
import com.google.protobuf.Method$Builder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Api$Builder extends GeneratedMessage$Builder implements ApiOrBuilder {
   private int bitField0_;
   private Object name_;
   private List methods_;
   private RepeatedFieldBuilder methodsBuilder_;
   private List options_;
   private RepeatedFieldBuilder optionsBuilder_;
   private Object version_;
   private SourceContext sourceContext_;
   private SingleFieldBuilder sourceContextBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return ApiProto.internal_static_google_protobuf_Api_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
   }

   private Api$Builder() {
      this.name_ = "";
      this.methods_ = Collections.emptyList();
      this.options_ = Collections.emptyList();
      this.version_ = "";
      this.sourceContext_ = null;
      this.maybeForceBuilderInitialization();
   }

   private Api$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.methods_ = Collections.emptyList();
      this.options_ = Collections.emptyList();
      this.version_ = "";
      this.sourceContext_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getMethodsFieldBuilder();
         this.getOptionsFieldBuilder();
      }

   }

   public Api$Builder clear() {
      super.clear();
      this.name_ = "";
      if(this.methodsBuilder_ == null) {
         this.methods_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.methodsBuilder_.clear();
      }

      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -5;
      } else {
         this.optionsBuilder_.clear();
      }

      this.version_ = "";
      if(this.sourceContextBuilder_ == null) {
         this.sourceContext_ = null;
      } else {
         this.sourceContext_ = null;
         this.sourceContextBuilder_ = null;
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return ApiProto.internal_static_google_protobuf_Api_descriptor;
   }

   public Api getDefaultInstanceForType() {
      return Api.getDefaultInstance();
   }

   public Api build() {
      Api var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Api buildPartial() {
      Api var1 = new Api(this, (Api$1)null);
      int var2 = this.bitField0_;
      byte var3 = 0;
      Api.access$302(var1, this.name_);
      if(this.methodsBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.methods_ = Collections.unmodifiableList(this.methods_);
            this.bitField0_ &= -3;
         }

         Api.access$402(var1, this.methods_);
      } else {
         Api.access$402(var1, this.methodsBuilder_.build());
      }

      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 4) == 4) {
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
         }

         Api.access$502(var1, this.options_);
      } else {
         Api.access$502(var1, this.optionsBuilder_.build());
      }

      Api.access$602(var1, this.version_);
      if(this.sourceContextBuilder_ == null) {
         Api.access$702(var1, this.sourceContext_);
      } else {
         Api.access$702(var1, (SourceContext)this.sourceContextBuilder_.build());
      }

      Api.access$802(var1, var3);
      this.onBuilt();
      return var1;
   }

   public Api$Builder mergeFrom(Message var1) {
      if(var1 instanceof Api) {
         return this.mergeFrom((Api)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Api$Builder mergeFrom(Api var1) {
      if(var1 == Api.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getName().isEmpty()) {
            this.name_ = Api.access$300(var1);
            this.onChanged();
         }

         if(this.methodsBuilder_ == null) {
            if(!Api.access$400(var1).isEmpty()) {
               if(this.methods_.isEmpty()) {
                  this.methods_ = Api.access$400(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureMethodsIsMutable();
                  this.methods_.addAll(Api.access$400(var1));
               }

               this.onChanged();
            }
         } else if(!Api.access$400(var1).isEmpty()) {
            if(this.methodsBuilder_.isEmpty()) {
               this.methodsBuilder_.dispose();
               this.methodsBuilder_ = null;
               this.methods_ = Api.access$400(var1);
               this.bitField0_ &= -3;
               this.methodsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getMethodsFieldBuilder():null;
            } else {
               this.methodsBuilder_.addAllMessages(Api.access$400(var1));
            }
         }

         if(this.optionsBuilder_ == null) {
            if(!Api.access$500(var1).isEmpty()) {
               if(this.options_.isEmpty()) {
                  this.options_ = Api.access$500(var1);
                  this.bitField0_ &= -5;
               } else {
                  this.ensureOptionsIsMutable();
                  this.options_.addAll(Api.access$500(var1));
               }

               this.onChanged();
            }
         } else if(!Api.access$500(var1).isEmpty()) {
            if(this.optionsBuilder_.isEmpty()) {
               this.optionsBuilder_.dispose();
               this.optionsBuilder_ = null;
               this.options_ = Api.access$500(var1);
               this.bitField0_ &= -5;
               this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOptionsFieldBuilder():null;
            } else {
               this.optionsBuilder_.addAllMessages(Api.access$500(var1));
            }
         }

         if(!var1.getVersion().isEmpty()) {
            this.version_ = Api.access$600(var1);
            this.onChanged();
         }

         if(var1.hasSourceContext()) {
            this.mergeSourceContext(var1.getSourceContext());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Api$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Api var3 = null;

      try {
         var3 = (Api)Api.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Api)var9.getUnfinishedMessage();
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

   public Api$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Api$Builder clearName() {
      this.name_ = Api.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public Api$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureMethodsIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.methods_ = new ArrayList(this.methods_);
         this.bitField0_ |= 2;
      }

   }

   public List getMethodsList() {
      return this.methodsBuilder_ == null?Collections.unmodifiableList(this.methods_):this.methodsBuilder_.getMessageList();
   }

   public int getMethodsCount() {
      return this.methodsBuilder_ == null?this.methods_.size():this.methodsBuilder_.getCount();
   }

   public Method getMethods(int var1) {
      return this.methodsBuilder_ == null?(Method)this.methods_.get(var1):(Method)this.methodsBuilder_.getMessage(var1);
   }

   public Api$Builder setMethods(int var1, Method var2) {
      if(this.methodsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureMethodsIsMutable();
         this.methods_.set(var1, var2);
         this.onChanged();
      } else {
         this.methodsBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public Api$Builder setMethods(int var1, Method$Builder var2) {
      if(this.methodsBuilder_ == null) {
         this.ensureMethodsIsMutable();
         this.methods_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.methodsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Api$Builder addMethods(Method var1) {
      if(this.methodsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureMethodsIsMutable();
         this.methods_.add(var1);
         this.onChanged();
      } else {
         this.methodsBuilder_.addMessage(var1);
      }

      return this;
   }

   public Api$Builder addMethods(int var1, Method var2) {
      if(this.methodsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureMethodsIsMutable();
         this.methods_.add(var1, var2);
         this.onChanged();
      } else {
         this.methodsBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public Api$Builder addMethods(Method$Builder var1) {
      if(this.methodsBuilder_ == null) {
         this.ensureMethodsIsMutable();
         this.methods_.add(var1.build());
         this.onChanged();
      } else {
         this.methodsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Api$Builder addMethods(int var1, Method$Builder var2) {
      if(this.methodsBuilder_ == null) {
         this.ensureMethodsIsMutable();
         this.methods_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.methodsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Api$Builder addAllMethods(Iterable var1) {
      if(this.methodsBuilder_ == null) {
         this.ensureMethodsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.methods_);
         this.onChanged();
      } else {
         this.methodsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Api$Builder clearMethods() {
      if(this.methodsBuilder_ == null) {
         this.methods_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.methodsBuilder_.clear();
      }

      return this;
   }

   public Api$Builder removeMethods(int var1) {
      if(this.methodsBuilder_ == null) {
         this.ensureMethodsIsMutable();
         this.methods_.remove(var1);
         this.onChanged();
      } else {
         this.methodsBuilder_.remove(var1);
      }

      return this;
   }

   public Method$Builder getMethodsBuilder(int var1) {
      return (Method$Builder)this.getMethodsFieldBuilder().getBuilder(var1);
   }

   public MethodOrBuilder getMethodsOrBuilder(int var1) {
      return this.methodsBuilder_ == null?(MethodOrBuilder)this.methods_.get(var1):(MethodOrBuilder)this.methodsBuilder_.getMessageOrBuilder(var1);
   }

   public List getMethodsOrBuilderList() {
      return this.methodsBuilder_ != null?this.methodsBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.methods_);
   }

   public Method$Builder addMethodsBuilder() {
      return (Method$Builder)this.getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
   }

   public Method$Builder addMethodsBuilder(int var1) {
      return (Method$Builder)this.getMethodsFieldBuilder().addBuilder(var1, Method.getDefaultInstance());
   }

   public List getMethodsBuilderList() {
      return this.getMethodsFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getMethodsFieldBuilder() {
      if(this.methodsBuilder_ == null) {
         this.methodsBuilder_ = new RepeatedFieldBuilder(this.methods_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.methods_ = null;
      }

      return this.methodsBuilder_;
   }

   private void ensureOptionsIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.options_ = new ArrayList(this.options_);
         this.bitField0_ |= 4;
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

   public Api$Builder setOptions(int var1, Option var2) {
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

   public Api$Builder setOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Api$Builder addOptions(Option var1) {
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

   public Api$Builder addOptions(int var1, Option var2) {
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

   public Api$Builder addOptions(Option$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Api$Builder addOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Api$Builder addAllOptions(Iterable var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.options_);
         this.onChanged();
      } else {
         this.optionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Api$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -5;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Api$Builder removeOptions(int var1) {
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
         this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public String getVersion() {
      Object var1 = this.version_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.version_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getVersionBytes() {
      Object var1 = this.version_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.version_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public Api$Builder setVersion(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.version_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Api$Builder clearVersion() {
      this.version_ = Api.getDefaultInstance().getVersion();
      this.onChanged();
      return this;
   }

   public Api$Builder setVersionBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.version_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasSourceContext() {
      return this.sourceContextBuilder_ != null || this.sourceContext_ != null;
   }

   public SourceContext getSourceContext() {
      return this.sourceContextBuilder_ == null?(this.sourceContext_ == null?SourceContext.getDefaultInstance():this.sourceContext_):(SourceContext)this.sourceContextBuilder_.getMessage();
   }

   public Api$Builder setSourceContext(SourceContext var1) {
      if(this.sourceContextBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.sourceContext_ = var1;
         this.onChanged();
      } else {
         this.sourceContextBuilder_.setMessage(var1);
      }

      return this;
   }

   public Api$Builder setSourceContext(SourceContext$Builder var1) {
      if(this.sourceContextBuilder_ == null) {
         this.sourceContext_ = var1.build();
         this.onChanged();
      } else {
         this.sourceContextBuilder_.setMessage(var1.build());
      }

      return this;
   }

   public Api$Builder mergeSourceContext(SourceContext var1) {
      if(this.sourceContextBuilder_ == null) {
         if(this.sourceContext_ != null) {
            this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(var1).buildPartial();
         } else {
            this.sourceContext_ = var1;
         }

         this.onChanged();
      } else {
         this.sourceContextBuilder_.mergeFrom(var1);
      }

      return this;
   }

   public Api$Builder clearSourceContext() {
      if(this.sourceContextBuilder_ == null) {
         this.sourceContext_ = null;
         this.onChanged();
      } else {
         this.sourceContext_ = null;
         this.sourceContextBuilder_ = null;
      }

      return this;
   }

   public SourceContext$Builder getSourceContextBuilder() {
      this.onChanged();
      return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
   }

   public SourceContextOrBuilder getSourceContextOrBuilder() {
      return (SourceContextOrBuilder)(this.sourceContextBuilder_ != null?(SourceContextOrBuilder)this.sourceContextBuilder_.getMessageOrBuilder():(this.sourceContext_ == null?SourceContext.getDefaultInstance():this.sourceContext_));
   }

   private SingleFieldBuilder getSourceContextFieldBuilder() {
      if(this.sourceContextBuilder_ == null) {
         this.sourceContextBuilder_ = new SingleFieldBuilder(this.getSourceContext(), this.getParentForChildren(), this.isClean());
         this.sourceContext_ = null;
      }

      return this.sourceContextBuilder_;
   }

   public final Api$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Api$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Api$Builder(Api$1 var1) {
      this();
   }

   // $FF: synthetic method
   Api$Builder(GeneratedMessage$BuilderParent var1, Api$1 var2) {
      this(var1);
   }
}
