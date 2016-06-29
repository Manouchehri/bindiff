package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Enum;
import com.google.protobuf.Enum$1;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValue$Builder;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Enum$Builder extends GeneratedMessage$Builder implements EnumOrBuilder {
   private int bitField0_;
   private Object name_;
   private List enumvalue_;
   private RepeatedFieldBuilder enumvalueBuilder_;
   private List options_;
   private RepeatedFieldBuilder optionsBuilder_;
   private SourceContext sourceContext_;
   private SingleFieldBuilder sourceContextBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Enum_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
   }

   private Enum$Builder() {
      this.name_ = "";
      this.enumvalue_ = Collections.emptyList();
      this.options_ = Collections.emptyList();
      this.sourceContext_ = null;
      this.maybeForceBuilderInitialization();
   }

   private Enum$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.enumvalue_ = Collections.emptyList();
      this.options_ = Collections.emptyList();
      this.sourceContext_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getEnumvalueFieldBuilder();
         this.getOptionsFieldBuilder();
      }

   }

   public Enum$Builder clear() {
      super.clear();
      this.name_ = "";
      if(this.enumvalueBuilder_ == null) {
         this.enumvalue_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.enumvalueBuilder_.clear();
      }

      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -5;
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
      return TypeProto.internal_static_google_protobuf_Enum_descriptor;
   }

   public Enum getDefaultInstanceForType() {
      return Enum.getDefaultInstance();
   }

   public Enum build() {
      Enum var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Enum buildPartial() {
      Enum var1 = new Enum(this, (Enum$1)null);
      int var2 = this.bitField0_;
      byte var3 = 0;
      Enum.access$302(var1, this.name_);
      if(this.enumvalueBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            this.bitField0_ &= -3;
         }

         Enum.access$402(var1, this.enumvalue_);
      } else {
         Enum.access$402(var1, this.enumvalueBuilder_.build());
      }

      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 4) == 4) {
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
         }

         Enum.access$502(var1, this.options_);
      } else {
         Enum.access$502(var1, this.optionsBuilder_.build());
      }

      if(this.sourceContextBuilder_ == null) {
         Enum.access$602(var1, this.sourceContext_);
      } else {
         Enum.access$602(var1, (SourceContext)this.sourceContextBuilder_.build());
      }

      Enum.access$702(var1, var3);
      this.onBuilt();
      return var1;
   }

   public Enum$Builder mergeFrom(Message var1) {
      if(var1 instanceof Enum) {
         return this.mergeFrom((Enum)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Enum$Builder mergeFrom(Enum var1) {
      if(var1 == Enum.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getName().isEmpty()) {
            this.name_ = Enum.access$300(var1);
            this.onChanged();
         }

         if(this.enumvalueBuilder_ == null) {
            if(!Enum.access$400(var1).isEmpty()) {
               if(this.enumvalue_.isEmpty()) {
                  this.enumvalue_ = Enum.access$400(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureEnumvalueIsMutable();
                  this.enumvalue_.addAll(Enum.access$400(var1));
               }

               this.onChanged();
            }
         } else if(!Enum.access$400(var1).isEmpty()) {
            if(this.enumvalueBuilder_.isEmpty()) {
               this.enumvalueBuilder_.dispose();
               this.enumvalueBuilder_ = null;
               this.enumvalue_ = Enum.access$400(var1);
               this.bitField0_ &= -3;
               this.enumvalueBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getEnumvalueFieldBuilder():null;
            } else {
               this.enumvalueBuilder_.addAllMessages(Enum.access$400(var1));
            }
         }

         if(this.optionsBuilder_ == null) {
            if(!Enum.access$500(var1).isEmpty()) {
               if(this.options_.isEmpty()) {
                  this.options_ = Enum.access$500(var1);
                  this.bitField0_ &= -5;
               } else {
                  this.ensureOptionsIsMutable();
                  this.options_.addAll(Enum.access$500(var1));
               }

               this.onChanged();
            }
         } else if(!Enum.access$500(var1).isEmpty()) {
            if(this.optionsBuilder_.isEmpty()) {
               this.optionsBuilder_.dispose();
               this.optionsBuilder_ = null;
               this.options_ = Enum.access$500(var1);
               this.bitField0_ &= -5;
               this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOptionsFieldBuilder():null;
            } else {
               this.optionsBuilder_.addAllMessages(Enum.access$500(var1));
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

   public Enum$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Enum var3 = null;

      try {
         var3 = (Enum)Enum.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Enum)var9.getUnfinishedMessage();
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

   public Enum$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Enum$Builder clearName() {
      this.name_ = Enum.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public Enum$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureEnumvalueIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.enumvalue_ = new ArrayList(this.enumvalue_);
         this.bitField0_ |= 2;
      }

   }

   public List getEnumvalueList() {
      return this.enumvalueBuilder_ == null?Collections.unmodifiableList(this.enumvalue_):this.enumvalueBuilder_.getMessageList();
   }

   public int getEnumvalueCount() {
      return this.enumvalueBuilder_ == null?this.enumvalue_.size():this.enumvalueBuilder_.getCount();
   }

   public EnumValue getEnumvalue(int var1) {
      return this.enumvalueBuilder_ == null?(EnumValue)this.enumvalue_.get(var1):(EnumValue)this.enumvalueBuilder_.getMessage(var1);
   }

   public Enum$Builder setEnumvalue(int var1, EnumValue var2) {
      if(this.enumvalueBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureEnumvalueIsMutable();
         this.enumvalue_.set(var1, var2);
         this.onChanged();
      } else {
         this.enumvalueBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public Enum$Builder setEnumvalue(int var1, EnumValue$Builder var2) {
      if(this.enumvalueBuilder_ == null) {
         this.ensureEnumvalueIsMutable();
         this.enumvalue_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.enumvalueBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Enum$Builder addEnumvalue(EnumValue var1) {
      if(this.enumvalueBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureEnumvalueIsMutable();
         this.enumvalue_.add(var1);
         this.onChanged();
      } else {
         this.enumvalueBuilder_.addMessage(var1);
      }

      return this;
   }

   public Enum$Builder addEnumvalue(int var1, EnumValue var2) {
      if(this.enumvalueBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureEnumvalueIsMutable();
         this.enumvalue_.add(var1, var2);
         this.onChanged();
      } else {
         this.enumvalueBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public Enum$Builder addEnumvalue(EnumValue$Builder var1) {
      if(this.enumvalueBuilder_ == null) {
         this.ensureEnumvalueIsMutable();
         this.enumvalue_.add(var1.build());
         this.onChanged();
      } else {
         this.enumvalueBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Enum$Builder addEnumvalue(int var1, EnumValue$Builder var2) {
      if(this.enumvalueBuilder_ == null) {
         this.ensureEnumvalueIsMutable();
         this.enumvalue_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.enumvalueBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Enum$Builder addAllEnumvalue(Iterable var1) {
      if(this.enumvalueBuilder_ == null) {
         this.ensureEnumvalueIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.enumvalue_);
         this.onChanged();
      } else {
         this.enumvalueBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Enum$Builder clearEnumvalue() {
      if(this.enumvalueBuilder_ == null) {
         this.enumvalue_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.enumvalueBuilder_.clear();
      }

      return this;
   }

   public Enum$Builder removeEnumvalue(int var1) {
      if(this.enumvalueBuilder_ == null) {
         this.ensureEnumvalueIsMutable();
         this.enumvalue_.remove(var1);
         this.onChanged();
      } else {
         this.enumvalueBuilder_.remove(var1);
      }

      return this;
   }

   public EnumValue$Builder getEnumvalueBuilder(int var1) {
      return (EnumValue$Builder)this.getEnumvalueFieldBuilder().getBuilder(var1);
   }

   public EnumValueOrBuilder getEnumvalueOrBuilder(int var1) {
      return this.enumvalueBuilder_ == null?(EnumValueOrBuilder)this.enumvalue_.get(var1):(EnumValueOrBuilder)this.enumvalueBuilder_.getMessageOrBuilder(var1);
   }

   public List getEnumvalueOrBuilderList() {
      return this.enumvalueBuilder_ != null?this.enumvalueBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.enumvalue_);
   }

   public EnumValue$Builder addEnumvalueBuilder() {
      return (EnumValue$Builder)this.getEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
   }

   public EnumValue$Builder addEnumvalueBuilder(int var1) {
      return (EnumValue$Builder)this.getEnumvalueFieldBuilder().addBuilder(var1, EnumValue.getDefaultInstance());
   }

   public List getEnumvalueBuilderList() {
      return this.getEnumvalueFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getEnumvalueFieldBuilder() {
      if(this.enumvalueBuilder_ == null) {
         this.enumvalueBuilder_ = new RepeatedFieldBuilder(this.enumvalue_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.enumvalue_ = null;
      }

      return this.enumvalueBuilder_;
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

   public Enum$Builder setOptions(int var1, Option var2) {
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

   public Enum$Builder setOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Enum$Builder addOptions(Option var1) {
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

   public Enum$Builder addOptions(int var1, Option var2) {
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

   public Enum$Builder addOptions(Option$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Enum$Builder addOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Enum$Builder addAllOptions(Iterable var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.options_);
         this.onChanged();
      } else {
         this.optionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Enum$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -5;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Enum$Builder removeOptions(int var1) {
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

   public boolean hasSourceContext() {
      return this.sourceContextBuilder_ != null || this.sourceContext_ != null;
   }

   public SourceContext getSourceContext() {
      return this.sourceContextBuilder_ == null?(this.sourceContext_ == null?SourceContext.getDefaultInstance():this.sourceContext_):(SourceContext)this.sourceContextBuilder_.getMessage();
   }

   public Enum$Builder setSourceContext(SourceContext var1) {
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

   public Enum$Builder setSourceContext(SourceContext$Builder var1) {
      if(this.sourceContextBuilder_ == null) {
         this.sourceContext_ = var1.build();
         this.onChanged();
      } else {
         this.sourceContextBuilder_.setMessage(var1.build());
      }

      return this;
   }

   public Enum$Builder mergeSourceContext(SourceContext var1) {
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

   public Enum$Builder clearSourceContext() {
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

   public final Enum$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Enum$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Enum$Builder(Enum$1 var1) {
      this();
   }

   // $FF: synthetic method
   Enum$Builder(GeneratedMessage$BuilderParent var1, Enum$1 var2) {
      this(var1);
   }
}
