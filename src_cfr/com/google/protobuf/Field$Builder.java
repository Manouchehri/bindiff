/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
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
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Field$Builder
extends GeneratedMessage$Builder
implements FieldOrBuilder {
    private int bitField0_;
    private int kind_ = 0;
    private int cardinality_ = 0;
    private int number_;
    private Object name_ = "";
    private Object typeUrl_ = "";
    private int oneofIndex_;
    private boolean packed_;
    private List options_ = Collections.emptyList();
    private RepeatedFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
    }

    private Field$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Field$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getOptionsFieldBuilder();
    }

    @Override
    public Field$Builder clear() {
        super.clear();
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    @Override
    public Field getDefaultInstanceForType() {
        return Field.getDefaultInstance();
    }

    @Override
    public Field build() {
        Field field = this.buildPartial();
        if (field.isInitialized()) return field;
        throw Field$Builder.newUninitializedMessageException(field);
    }

    @Override
    public Field buildPartial() {
        Field field = new Field(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        Field.access$302(field, this.kind_);
        Field.access$402(field, this.cardinality_);
        Field.access$502(field, this.number_);
        Field.access$602(field, this.name_);
        Field.access$702(field, this.typeUrl_);
        Field.access$802(field, this.oneofIndex_);
        Field.access$902(field, this.packed_);
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 128) == 128) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -129;
            }
            Field.access$1002(field, this.options_);
        } else {
            Field.access$1002(field, this.optionsBuilder_.build());
        }
        Field.access$1102(field, n3);
        this.onBuilt();
        return field;
    }

    @Override
    public Field$Builder mergeFrom(Message message) {
        if (message instanceof Field) {
            return this.mergeFrom((Field)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Field$Builder mergeFrom(Field field) {
        if (field == Field.getDefaultInstance()) {
            return this;
        }
        if (Field.access$300(field) != 0) {
            this.setKindValue(field.getKindValue());
        }
        if (Field.access$400(field) != 0) {
            this.setCardinalityValue(field.getCardinalityValue());
        }
        if (field.getNumber() != 0) {
            this.setNumber(field.getNumber());
        }
        if (!field.getName().isEmpty()) {
            this.name_ = Field.access$600(field);
            this.onChanged();
        }
        if (!field.getTypeUrl().isEmpty()) {
            this.typeUrl_ = Field.access$700(field);
            this.onChanged();
        }
        if (field.getOneofIndex() != 0) {
            this.setOneofIndex(field.getOneofIndex());
        }
        if (field.getPacked()) {
            this.setPacked(field.getPacked());
        }
        if (this.optionsBuilder_ == null) {
            if (!Field.access$1000(field).isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = Field.access$1000(field);
                    this.bitField0_ &= -129;
                } else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(Field.access$1000(field));
                }
                this.onChanged();
            }
        } else if (!Field.access$1000(field).isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = Field.access$1000(field);
                this.bitField0_ &= -129;
                this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null;
            } else {
                this.optionsBuilder_.addAllMessages(Field.access$1000(field));
            }
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Field$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Field field = null;
        try {
            try {
                field = (Field)Field.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                field = (Field)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (field == null) return this;
            this.mergeFrom(field);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (field == null) throw var5_7;
            this.mergeFrom(field);
            throw var5_7;
        }
    }

    @Override
    public int getKindValue() {
        return this.kind_;
    }

    public Field$Builder setKindValue(int n2) {
        this.kind_ = n2;
        this.onChanged();
        return this;
    }

    @Override
    public Field$Kind getKind() {
        Field$Kind field$Kind;
        Field$Kind field$Kind2 = Field$Kind.valueOf(this.kind_);
        if (field$Kind2 == null) {
            field$Kind = Field$Kind.UNRECOGNIZED;
            return field$Kind;
        }
        field$Kind = field$Kind2;
        return field$Kind;
    }

    public Field$Builder setKind(Field$Kind field$Kind) {
        if (field$Kind == null) {
            throw new NullPointerException();
        }
        this.kind_ = field$Kind.getNumber();
        this.onChanged();
        return this;
    }

    public Field$Builder clearKind() {
        this.kind_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public Field$Builder setCardinalityValue(int n2) {
        this.cardinality_ = n2;
        this.onChanged();
        return this;
    }

    @Override
    public Field$Cardinality getCardinality() {
        Field$Cardinality field$Cardinality;
        Field$Cardinality field$Cardinality2 = Field$Cardinality.valueOf(this.cardinality_);
        if (field$Cardinality2 == null) {
            field$Cardinality = Field$Cardinality.UNRECOGNIZED;
            return field$Cardinality;
        }
        field$Cardinality = field$Cardinality2;
        return field$Cardinality;
    }

    public Field$Builder setCardinality(Field$Cardinality field$Cardinality) {
        if (field$Cardinality == null) {
            throw new NullPointerException();
        }
        this.cardinality_ = field$Cardinality.getNumber();
        this.onChanged();
        return this;
    }

    public Field$Builder clearCardinality() {
        this.cardinality_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public int getNumber() {
        return this.number_;
    }

    public Field$Builder setNumber(int n2) {
        this.number_ = n2;
        this.onChanged();
        return this;
    }

    public Field$Builder clearNumber() {
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Field$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public Field$Builder clearName() {
        this.name_ = Field.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public Field$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public String getTypeUrl() {
        Object object = this.typeUrl_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.typeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getTypeUrlBytes() {
        ByteString byteString;
        Object object = this.typeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.typeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Field$Builder setTypeUrl(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = string;
        this.onChanged();
        return this;
    }

    public Field$Builder clearTypeUrl() {
        this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
        this.onChanged();
        return this;
    }

    public Field$Builder setTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public Field$Builder setOneofIndex(int n2) {
        this.oneofIndex_ = n2;
        this.onChanged();
        return this;
    }

    public Field$Builder clearOneofIndex() {
        this.oneofIndex_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean getPacked() {
        return this.packed_;
    }

    public Field$Builder setPacked(boolean bl2) {
        this.packed_ = bl2;
        this.onChanged();
        return this;
    }

    public Field$Builder clearPacked() {
        this.packed_ = false;
        this.onChanged();
        return this;
    }

    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 128) == 128) return;
        this.options_ = new ArrayList(this.options_);
        this.bitField0_ |= 128;
    }

    @Override
    public List getOptionsList() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.options_);
    }

    @Override
    public int getOptionsCount() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_.getCount();
        return this.options_.size();
    }

    @Override
    public Option getOptions(int n2) {
        if (this.optionsBuilder_ != null) return (Option)this.optionsBuilder_.getMessage(n2);
        return (Option)this.options_.get(n2);
    }

    public Field$Builder setOptions(int n2, Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.setMessage(n2, option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.set(n2, option);
        this.onChanged();
        return this;
    }

    public Field$Builder setOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.setMessage(n2, option$Builder.build());
        return this;
    }

    public Field$Builder addOptions(Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.addMessage(option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.add(option);
        this.onChanged();
        return this;
    }

    public Field$Builder addOptions(int n2, Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.addMessage(n2, option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.add(n2, option);
        this.onChanged();
        return this;
    }

    public Field$Builder addOptions(Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(option$Builder.build());
        return this;
    }

    public Field$Builder addOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(n2, option$Builder.build());
        return this;
    }

    public Field$Builder addAllOptions(Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Field$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    public Field$Builder removeOptions(int n2) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.remove(n2);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.remove(n2);
        return this;
    }

    public Option$Builder getOptionsBuilder(int n2) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n2);
    }

    @Override
    public OptionOrBuilder getOptionsOrBuilder(int n2) {
        if (this.optionsBuilder_ != null) return (OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(n2);
        return (OptionOrBuilder)this.options_.get(n2);
    }

    @Override
    public List getOptionsOrBuilderList() {
        if (this.optionsBuilder_ == null) return Collections.unmodifiableList(this.options_);
        return this.optionsBuilder_.getMessageOrBuilderList();
    }

    public Option$Builder addOptionsBuilder() {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
    }

    public Option$Builder addOptionsBuilder(int n2) {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(n2, Option.getDefaultInstance());
    }

    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 128) == 128, this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public final Field$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Field$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Field$Builder(Field$1 field$1) {
        this();
    }

    /* synthetic */ Field$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Field$1 field$1) {
        this(generatedMessage$BuilderParent);
    }
}

