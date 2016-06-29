package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Builder;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Type;
import com.google.protobuf.Type$1;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Type$Builder extends GeneratedMessage$Builder implements TypeOrBuilder {
   private int bitField0_;
   private Object name_;
   private List fields_;
   private RepeatedFieldBuilder fieldsBuilder_;
   private LazyStringList oneofs_;
   private List options_;
   private RepeatedFieldBuilder optionsBuilder_;
   private SourceContext sourceContext_;
   private SingleFieldBuilder sourceContextBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Type_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
   }

   private Type$Builder() {
      this.name_ = "";
      this.fields_ = Collections.emptyList();
      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.options_ = Collections.emptyList();
      this.sourceContext_ = null;
      this.maybeForceBuilderInitialization();
   }

   private Type$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.fields_ = Collections.emptyList();
      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.options_ = Collections.emptyList();
      this.sourceContext_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getFieldsFieldBuilder();
         this.getOptionsFieldBuilder();
      }

   }

   public Type$Builder clear() {
      super.clear();
      this.name_ = "";
      if(this.fieldsBuilder_ == null) {
         this.fields_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.fieldsBuilder_.clear();
      }

      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -5;
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -9;
      } else {
         this.optionsBuilder_.clear();
      }

      if(this.sourceContextBuilder_ == null) {
         this.sourceContext_ = null;
      } else {
         this.sourceContext_ = null;
         this.sourceContextBuilder_ = null;
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_Type_descriptor;
   }

   public Type getDefaultInstanceForType() {
      return Type.getDefaultInstance();
   }

   public Type build() {
      Type var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Type buildPartial() {
      Type var1 = new Type(this, (Type$1)null);
      int var2 = this.bitField0_;
      byte var3 = 0;
      Type.access$302(var1, this.name_);
      if(this.fieldsBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.fields_ = Collections.unmodifiableList(this.fields_);
            this.bitField0_ &= -3;
         }

         Type.access$402(var1, this.fields_);
      } else {
         Type.access$402(var1, this.fieldsBuilder_.build());
      }

      if((this.bitField0_ & 4) == 4) {
         this.oneofs_ = this.oneofs_.getUnmodifiableView();
         this.bitField0_ &= -5;
      }

      Type.access$502(var1, this.oneofs_);
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 8) == 8) {
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -9;
         }

         Type.access$602(var1, this.options_);
      } else {
         Type.access$602(var1, this.optionsBuilder_.build());
      }

      if(this.sourceContextBuilder_ == null) {
         Type.access$702(var1, this.sourceContext_);
      } else {
         Type.access$702(var1, (SourceContext)this.sourceContextBuilder_.build());
      }

      Type.access$802(var1, var3);
      this.onBuilt();
      return var1;
   }

   public Type$Builder mergeFrom(Message var1) {
      if(var1 instanceof Type) {
         return this.mergeFrom((Type)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Type$Builder mergeFrom(Type var1) {
      if(var1 == Type.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getName().isEmpty()) {
            this.name_ = Type.access$300(var1);
            this.onChanged();
         }

         if(this.fieldsBuilder_ == null) {
            if(!Type.access$400(var1).isEmpty()) {
               if(this.fields_.isEmpty()) {
                  this.fields_ = Type.access$400(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureFieldsIsMutable();
                  this.fields_.addAll(Type.access$400(var1));
               }

               this.onChanged();
            }
         } else if(!Type.access$400(var1).isEmpty()) {
            if(this.fieldsBuilder_.isEmpty()) {
               this.fieldsBuilder_.dispose();
               this.fieldsBuilder_ = null;
               this.fields_ = Type.access$400(var1);
               this.bitField0_ &= -3;
               this.fieldsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getFieldsFieldBuilder():null;
            } else {
               this.fieldsBuilder_.addAllMessages(Type.access$400(var1));
            }
         }

         if(!Type.access$500(var1).isEmpty()) {
            if(this.oneofs_.isEmpty()) {
               this.oneofs_ = Type.access$500(var1);
               this.bitField0_ &= -5;
            } else {
               this.ensureOneofsIsMutable();
               this.oneofs_.addAll(Type.access$500(var1));
            }

            this.onChanged();
         }

         if(this.optionsBuilder_ == null) {
            if(!Type.access$600(var1).isEmpty()) {
               if(this.options_.isEmpty()) {
                  this.options_ = Type.access$600(var1);
                  this.bitField0_ &= -9;
               } else {
                  this.ensureOptionsIsMutable();
                  this.options_.addAll(Type.access$600(var1));
               }

               this.onChanged();
            }
         } else if(!Type.access$600(var1).isEmpty()) {
            if(this.optionsBuilder_.isEmpty()) {
               this.optionsBuilder_.dispose();
               this.optionsBuilder_ = null;
               this.options_ = Type.access$600(var1);
               this.bitField0_ &= -9;
               this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOptionsFieldBuilder():null;
            } else {
               this.optionsBuilder_.addAllMessages(Type.access$600(var1));
            }
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

   public Type$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Type var3 = null;

      try {
         var3 = (Type)Type.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Type)var9.getUnfinishedMessage();
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

   public Type$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Type$Builder clearName() {
      this.name_ = Type.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public Type$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureFieldsIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.fields_ = new ArrayList(this.fields_);
         this.bitField0_ |= 2;
      }

   }

   public List getFieldsList() {
      return this.fieldsBuilder_ == null?Collections.unmodifiableList(this.fields_):this.fieldsBuilder_.getMessageList();
   }

   public int getFieldsCount() {
      return this.fieldsBuilder_ == null?this.fields_.size():this.fieldsBuilder_.getCount();
   }

   public Field getFields(int var1) {
      return this.fieldsBuilder_ == null?(Field)this.fields_.get(var1):(Field)this.fieldsBuilder_.getMessage(var1);
   }

   public Type$Builder setFields(int var1, Field var2) {
      if(this.fieldsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureFieldsIsMutable();
         this.fields_.set(var1, var2);
         this.onChanged();
      } else {
         this.fieldsBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public Type$Builder setFields(int var1, Field$Builder var2) {
      if(this.fieldsBuilder_ == null) {
         this.ensureFieldsIsMutable();
         this.fields_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.fieldsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Type$Builder addFields(Field var1) {
      if(this.fieldsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureFieldsIsMutable();
         this.fields_.add(var1);
         this.onChanged();
      } else {
         this.fieldsBuilder_.addMessage(var1);
      }

      return this;
   }

   public Type$Builder addFields(int var1, Field var2) {
      if(this.fieldsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureFieldsIsMutable();
         this.fields_.add(var1, var2);
         this.onChanged();
      } else {
         this.fieldsBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public Type$Builder addFields(Field$Builder var1) {
      if(this.fieldsBuilder_ == null) {
         this.ensureFieldsIsMutable();
         this.fields_.add(var1.build());
         this.onChanged();
      } else {
         this.fieldsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Type$Builder addFields(int var1, Field$Builder var2) {
      if(this.fieldsBuilder_ == null) {
         this.ensureFieldsIsMutable();
         this.fields_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.fieldsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Type$Builder addAllFields(Iterable var1) {
      if(this.fieldsBuilder_ == null) {
         this.ensureFieldsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.fields_);
         this.onChanged();
      } else {
         this.fieldsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Type$Builder clearFields() {
      if(this.fieldsBuilder_ == null) {
         this.fields_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.fieldsBuilder_.clear();
      }

      return this;
   }

   public Type$Builder removeFields(int var1) {
      if(this.fieldsBuilder_ == null) {
         this.ensureFieldsIsMutable();
         this.fields_.remove(var1);
         this.onChanged();
      } else {
         this.fieldsBuilder_.remove(var1);
      }

      return this;
   }

   public Field$Builder getFieldsBuilder(int var1) {
      return (Field$Builder)this.getFieldsFieldBuilder().getBuilder(var1);
   }

   public FieldOrBuilder getFieldsOrBuilder(int var1) {
      return this.fieldsBuilder_ == null?(FieldOrBuilder)this.fields_.get(var1):(FieldOrBuilder)this.fieldsBuilder_.getMessageOrBuilder(var1);
   }

   public List getFieldsOrBuilderList() {
      return this.fieldsBuilder_ != null?this.fieldsBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.fields_);
   }

   public Field$Builder addFieldsBuilder() {
      return (Field$Builder)this.getFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
   }

   public Field$Builder addFieldsBuilder(int var1) {
      return (Field$Builder)this.getFieldsFieldBuilder().addBuilder(var1, Field.getDefaultInstance());
   }

   public List getFieldsBuilderList() {
      return this.getFieldsFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getFieldsFieldBuilder() {
      if(this.fieldsBuilder_ == null) {
         this.fieldsBuilder_ = new RepeatedFieldBuilder(this.fields_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.fields_ = null;
      }

      return this.fieldsBuilder_;
   }

   private void ensureOneofsIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.oneofs_ = new LazyStringArrayList(this.oneofs_);
         this.bitField0_ |= 4;
      }

   }

   public ProtocolStringList getOneofsList() {
      return this.oneofs_.getUnmodifiableView();
   }

   public int getOneofsCount() {
      return this.oneofs_.size();
   }

   public String getOneofs(int var1) {
      return (String)this.oneofs_.get(var1);
   }

   public ByteString getOneofsBytes(int var1) {
      return this.oneofs_.getByteString(var1);
   }

   public Type$Builder setOneofs(int var1, String var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensureOneofsIsMutable();
         this.oneofs_.set(var1, (Object)var2);
         this.onChanged();
         return this;
      }
   }

   public Type$Builder addOneofs(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureOneofsIsMutable();
         this.oneofs_.add((Object)var1);
         this.onChanged();
         return this;
      }
   }

   public Type$Builder addAllOneofs(Iterable var1) {
      this.ensureOneofsIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.oneofs_);
      this.onChanged();
      return this;
   }

   public Type$Builder clearOneofs() {
      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= -5;
      this.onChanged();
      return this;
   }

   public Type$Builder addOneofsBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureOneofsIsMutable();
         this.oneofs_.add(var1);
         this.onChanged();
         return this;
      }
   }

   private void ensureOptionsIsMutable() {
      if((this.bitField0_ & 8) != 8) {
         this.options_ = new ArrayList(this.options_);
         this.bitField0_ |= 8;
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

   public Type$Builder setOptions(int var1, Option var2) {
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

   public Type$Builder setOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Type$Builder addOptions(Option var1) {
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

   public Type$Builder addOptions(int var1, Option var2) {
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

   public Type$Builder addOptions(Option$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Type$Builder addOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Type$Builder addAllOptions(Iterable var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.options_);
         this.onChanged();
      } else {
         this.optionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Type$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -9;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Type$Builder removeOptions(int var1) {
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
         this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 8) == 8, this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public boolean hasSourceContext() {
      return this.sourceContextBuilder_ != null || this.sourceContext_ != null;
   }

   public SourceContext getSourceContext() {
      return this.sourceContextBuilder_ == null?(this.sourceContext_ == null?SourceContext.getDefaultInstance():this.sourceContext_):(SourceContext)this.sourceContextBuilder_.getMessage();
   }

   public Type$Builder setSourceContext(SourceContext var1) {
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

   public Type$Builder setSourceContext(SourceContext$Builder var1) {
      if(this.sourceContextBuilder_ == null) {
         this.sourceContext_ = var1.build();
         this.onChanged();
      } else {
         this.sourceContextBuilder_.setMessage(var1.build());
      }

      return this;
   }

   public Type$Builder mergeSourceContext(SourceContext var1) {
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

   public Type$Builder clearSourceContext() {
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

   public final Type$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Type$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Type$Builder(Type$1 var1) {
      this();
   }

   // $FF: synthetic method
   Type$Builder(GeneratedMessage$BuilderParent var1, Type$1 var2) {
      this(var1);
   }
}
