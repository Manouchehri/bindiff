package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.Field$1;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.FieldOrBuilder;
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
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Field$Builder extends GeneratedMessage$Builder implements FieldOrBuilder {
   private int bitField0_;
   private int kind_;
   private int cardinality_;
   private int number_;
   private Object name_;
   private Object typeUrl_;
   private int oneofIndex_;
   private boolean packed_;
   private List options_;
   private RepeatedFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Field_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
   }

   private Field$Builder() {
      this.kind_ = 0;
      this.cardinality_ = 0;
      this.name_ = "";
      this.typeUrl_ = "";
      this.options_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private Field$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.kind_ = 0;
      this.cardinality_ = 0;
      this.name_ = "";
      this.typeUrl_ = "";
      this.options_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getOptionsFieldBuilder();
      }

   }

   public Field$Builder clear() {
      super.clear();
      this.kind_ = 0;
      this.cardinality_ = 0;
      this.number_ = 0;
      this.name_ = "";
      this.typeUrl_ = "";
      this.oneofIndex_ = 0;
      this.packed_ = false;
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -129;
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_Field_descriptor;
   }

   public Field getDefaultInstanceForType() {
      return Field.getDefaultInstance();
   }

   public Field build() {
      Field var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Field buildPartial() {
      Field var1 = new Field(this, (Field$1)null);
      int var2 = this.bitField0_;
      byte var3 = 0;
      Field.access$302(var1, this.kind_);
      Field.access$402(var1, this.cardinality_);
      Field.access$502(var1, this.number_);
      Field.access$602(var1, this.name_);
      Field.access$702(var1, this.typeUrl_);
      Field.access$802(var1, this.oneofIndex_);
      Field.access$902(var1, this.packed_);
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 128) == 128) {
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -129;
         }

         Field.access$1002(var1, this.options_);
      } else {
         Field.access$1002(var1, this.optionsBuilder_.build());
      }

      Field.access$1102(var1, var3);
      this.onBuilt();
      return var1;
   }

   public Field$Builder mergeFrom(Message var1) {
      if(var1 instanceof Field) {
         return this.mergeFrom((Field)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Field$Builder mergeFrom(Field var1) {
      if(var1 == Field.getDefaultInstance()) {
         return this;
      } else {
         if(Field.access$300(var1) != 0) {
            this.setKindValue(var1.getKindValue());
         }

         if(Field.access$400(var1) != 0) {
            this.setCardinalityValue(var1.getCardinalityValue());
         }

         if(var1.getNumber() != 0) {
            this.setNumber(var1.getNumber());
         }

         if(!var1.getName().isEmpty()) {
            this.name_ = Field.access$600(var1);
            this.onChanged();
         }

         if(!var1.getTypeUrl().isEmpty()) {
            this.typeUrl_ = Field.access$700(var1);
            this.onChanged();
         }

         if(var1.getOneofIndex() != 0) {
            this.setOneofIndex(var1.getOneofIndex());
         }

         if(var1.getPacked()) {
            this.setPacked(var1.getPacked());
         }

         if(this.optionsBuilder_ == null) {
            if(!Field.access$1000(var1).isEmpty()) {
               if(this.options_.isEmpty()) {
                  this.options_ = Field.access$1000(var1);
                  this.bitField0_ &= -129;
               } else {
                  this.ensureOptionsIsMutable();
                  this.options_.addAll(Field.access$1000(var1));
               }

               this.onChanged();
            }
         } else if(!Field.access$1000(var1).isEmpty()) {
            if(this.optionsBuilder_.isEmpty()) {
               this.optionsBuilder_.dispose();
               this.optionsBuilder_ = null;
               this.options_ = Field.access$1000(var1);
               this.bitField0_ &= -129;
               this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOptionsFieldBuilder():null;
            } else {
               this.optionsBuilder_.addAllMessages(Field.access$1000(var1));
            }
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Field$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Field var3 = null;

      try {
         var3 = (Field)Field.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Field)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public int getKindValue() {
      return this.kind_;
   }

   public Field$Builder setKindValue(int var1) {
      this.kind_ = var1;
      this.onChanged();
      return this;
   }

   public Field$Kind getKind() {
      Field$Kind var1 = Field$Kind.valueOf(this.kind_);
      return var1 == null?Field$Kind.UNRECOGNIZED:var1;
   }

   public Field$Builder setKind(Field$Kind var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.kind_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public Field$Builder clearKind() {
      this.kind_ = 0;
      this.onChanged();
      return this;
   }

   public int getCardinalityValue() {
      return this.cardinality_;
   }

   public Field$Builder setCardinalityValue(int var1) {
      this.cardinality_ = var1;
      this.onChanged();
      return this;
   }

   public Field$Cardinality getCardinality() {
      Field$Cardinality var1 = Field$Cardinality.valueOf(this.cardinality_);
      return var1 == null?Field$Cardinality.UNRECOGNIZED:var1;
   }

   public Field$Builder setCardinality(Field$Cardinality var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.cardinality_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public Field$Builder clearCardinality() {
      this.cardinality_ = 0;
      this.onChanged();
      return this;
   }

   public int getNumber() {
      return this.number_;
   }

   public Field$Builder setNumber(int var1) {
      this.number_ = var1;
      this.onChanged();
      return this;
   }

   public Field$Builder clearNumber() {
      this.number_ = 0;
      this.onChanged();
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

   public Field$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Field$Builder clearName() {
      this.name_ = Field.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public Field$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
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

   public Field$Builder setTypeUrl(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.typeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Field$Builder clearTypeUrl() {
      this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
      this.onChanged();
      return this;
   }

   public Field$Builder setTypeUrlBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.typeUrl_ = var1;
         this.onChanged();
         return this;
      }
   }

   public int getOneofIndex() {
      return this.oneofIndex_;
   }

   public Field$Builder setOneofIndex(int var1) {
      this.oneofIndex_ = var1;
      this.onChanged();
      return this;
   }

   public Field$Builder clearOneofIndex() {
      this.oneofIndex_ = 0;
      this.onChanged();
      return this;
   }

   public boolean getPacked() {
      return this.packed_;
   }

   public Field$Builder setPacked(boolean var1) {
      this.packed_ = var1;
      this.onChanged();
      return this;
   }

   public Field$Builder clearPacked() {
      this.packed_ = false;
      this.onChanged();
      return this;
   }

   private void ensureOptionsIsMutable() {
      if((this.bitField0_ & 128) != 128) {
         this.options_ = new ArrayList(this.options_);
         this.bitField0_ |= 128;
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

   public Field$Builder setOptions(int var1, Option var2) {
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

   public Field$Builder setOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public Field$Builder addOptions(Option var1) {
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

   public Field$Builder addOptions(int var1, Option var2) {
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

   public Field$Builder addOptions(Option$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public Field$Builder addOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public Field$Builder addAllOptions(Iterable var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.options_);
         this.onChanged();
      } else {
         this.optionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public Field$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -129;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Field$Builder removeOptions(int var1) {
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
         this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 128) == 128, this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public final Field$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Field$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Field$Builder(Field$1 var1) {
      this();
   }

   // $FF: synthetic method
   Field$Builder(GeneratedMessage$BuilderParent var1, Field$1 var2) {
      this(var1);
   }
}
