package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$1;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.Value$Builder;
import com.google.protobuf.ValueOrBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListValue$Builder extends GeneratedMessage$Builder implements ListValueOrBuilder {
   private int bitField0_;
   private List values_;
   private RepeatedFieldBuilder valuesBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return StructProto.internal_static_google_protobuf_ListValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
   }

   private ListValue$Builder() {
      this.values_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private ListValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.values_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getValuesFieldBuilder();
      }

   }

   public ListValue$Builder clear() {
      super.clear();
      if(this.valuesBuilder_ == null) {
         this.values_ = Collections.emptyList();
         this.bitField0_ &= -2;
      } else {
         this.valuesBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return StructProto.internal_static_google_protobuf_ListValue_descriptor;
   }

   public ListValue getDefaultInstanceForType() {
      return ListValue.getDefaultInstance();
   }

   public ListValue build() {
      ListValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public ListValue buildPartial() {
      ListValue var1 = new ListValue(this, (ListValue$1)null);
      int var2 = this.bitField0_;
      if(this.valuesBuilder_ == null) {
         if((this.bitField0_ & 1) == 1) {
            this.values_ = Collections.unmodifiableList(this.values_);
            this.bitField0_ &= -2;
         }

         ListValue.access$302(var1, this.values_);
      } else {
         ListValue.access$302(var1, this.valuesBuilder_.build());
      }

      this.onBuilt();
      return var1;
   }

   public ListValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof ListValue) {
         return this.mergeFrom((ListValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public ListValue$Builder mergeFrom(ListValue var1) {
      if(var1 == ListValue.getDefaultInstance()) {
         return this;
      } else {
         if(this.valuesBuilder_ == null) {
            if(!ListValue.access$300(var1).isEmpty()) {
               if(this.values_.isEmpty()) {
                  this.values_ = ListValue.access$300(var1);
                  this.bitField0_ &= -2;
               } else {
                  this.ensureValuesIsMutable();
                  this.values_.addAll(ListValue.access$300(var1));
               }

               this.onChanged();
            }
         } else if(!ListValue.access$300(var1).isEmpty()) {
            if(this.valuesBuilder_.isEmpty()) {
               this.valuesBuilder_.dispose();
               this.valuesBuilder_ = null;
               this.values_ = ListValue.access$300(var1);
               this.bitField0_ &= -2;
               this.valuesBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getValuesFieldBuilder():null;
            } else {
               this.valuesBuilder_.addAllMessages(ListValue.access$300(var1));
            }
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public ListValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      ListValue var3 = null;

      try {
         var3 = (ListValue)ListValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (ListValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensureValuesIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.values_ = new ArrayList(this.values_);
         this.bitField0_ |= 1;
      }

   }

   public List getValuesList() {
      return this.valuesBuilder_ == null?Collections.unmodifiableList(this.values_):this.valuesBuilder_.getMessageList();
   }

   public int getValuesCount() {
      return this.valuesBuilder_ == null?this.values_.size():this.valuesBuilder_.getCount();
   }

   public Value getValues(int var1) {
      return this.valuesBuilder_ == null?(Value)this.values_.get(var1):(Value)this.valuesBuilder_.getMessage(var1);
   }

   public ListValue$Builder setValues(int var1, Value var2) {
      if(this.valuesBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureValuesIsMutable();
         this.values_.set(var1, var2);
         this.onChanged();
      } else {
         this.valuesBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public ListValue$Builder setValues(int var1, Value$Builder var2) {
      if(this.valuesBuilder_ == null) {
         this.ensureValuesIsMutable();
         this.values_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.valuesBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public ListValue$Builder addValues(Value var1) {
      if(this.valuesBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureValuesIsMutable();
         this.values_.add(var1);
         this.onChanged();
      } else {
         this.valuesBuilder_.addMessage(var1);
      }

      return this;
   }

   public ListValue$Builder addValues(int var1, Value var2) {
      if(this.valuesBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureValuesIsMutable();
         this.values_.add(var1, var2);
         this.onChanged();
      } else {
         this.valuesBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public ListValue$Builder addValues(Value$Builder var1) {
      if(this.valuesBuilder_ == null) {
         this.ensureValuesIsMutable();
         this.values_.add(var1.build());
         this.onChanged();
      } else {
         this.valuesBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public ListValue$Builder addValues(int var1, Value$Builder var2) {
      if(this.valuesBuilder_ == null) {
         this.ensureValuesIsMutable();
         this.values_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.valuesBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public ListValue$Builder addAllValues(Iterable var1) {
      if(this.valuesBuilder_ == null) {
         this.ensureValuesIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.values_);
         this.onChanged();
      } else {
         this.valuesBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public ListValue$Builder clearValues() {
      if(this.valuesBuilder_ == null) {
         this.values_ = Collections.emptyList();
         this.bitField0_ &= -2;
         this.onChanged();
      } else {
         this.valuesBuilder_.clear();
      }

      return this;
   }

   public ListValue$Builder removeValues(int var1) {
      if(this.valuesBuilder_ == null) {
         this.ensureValuesIsMutable();
         this.values_.remove(var1);
         this.onChanged();
      } else {
         this.valuesBuilder_.remove(var1);
      }

      return this;
   }

   public Value$Builder getValuesBuilder(int var1) {
      return (Value$Builder)this.getValuesFieldBuilder().getBuilder(var1);
   }

   public ValueOrBuilder getValuesOrBuilder(int var1) {
      return this.valuesBuilder_ == null?(ValueOrBuilder)this.values_.get(var1):(ValueOrBuilder)this.valuesBuilder_.getMessageOrBuilder(var1);
   }

   public List getValuesOrBuilderList() {
      return this.valuesBuilder_ != null?this.valuesBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.values_);
   }

   public Value$Builder addValuesBuilder() {
      return (Value$Builder)this.getValuesFieldBuilder().addBuilder(Value.getDefaultInstance());
   }

   public Value$Builder addValuesBuilder(int var1) {
      return (Value$Builder)this.getValuesFieldBuilder().addBuilder(var1, Value.getDefaultInstance());
   }

   public List getValuesBuilderList() {
      return this.getValuesFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getValuesFieldBuilder() {
      if(this.valuesBuilder_ == null) {
         this.valuesBuilder_ = new RepeatedFieldBuilder(this.values_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
         this.values_ = null;
      }

      return this.valuesBuilder_;
   }

   public final ListValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final ListValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   ListValue$Builder(ListValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   ListValue$Builder(GeneratedMessage$BuilderParent var1, ListValue$1 var2) {
      this(var1);
   }
}
