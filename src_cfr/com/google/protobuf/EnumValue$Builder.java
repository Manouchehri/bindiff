/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValue$1;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
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

public final class EnumValue$Builder
extends GeneratedMessage$Builder
implements EnumValueOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private int number_;
    private List options_ = Collections.emptyList();
    private RepeatedFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
    }

    private EnumValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private EnumValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getOptionsFieldBuilder();
    }

    @Override
    public EnumValue$Builder clear() {
        super.clear();
        this.name_ = "";
        this.number_ = 0;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    @Override
    public EnumValue getDefaultInstanceForType() {
        return EnumValue.getDefaultInstance();
    }

    @Override
    public EnumValue build() {
        EnumValue enumValue = this.buildPartial();
        if (enumValue.isInitialized()) return enumValue;
        throw EnumValue$Builder.newUninitializedMessageException(enumValue);
    }

    @Override
    public EnumValue buildPartial() {
        EnumValue enumValue = new EnumValue(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        EnumValue.access$302(enumValue, this.name_);
        EnumValue.access$402(enumValue, this.number_);
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -5;
            }
            EnumValue.access$502(enumValue, this.options_);
        } else {
            EnumValue.access$502(enumValue, this.optionsBuilder_.build());
        }
        EnumValue.access$602(enumValue, n3);
        this.onBuilt();
        return enumValue;
    }

    @Override
    public EnumValue$Builder mergeFrom(Message message) {
        if (message instanceof EnumValue) {
            return this.mergeFrom((EnumValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public EnumValue$Builder mergeFrom(EnumValue enumValue) {
        if (enumValue == EnumValue.getDefaultInstance()) {
            return this;
        }
        if (!enumValue.getName().isEmpty()) {
            this.name_ = EnumValue.access$300(enumValue);
            this.onChanged();
        }
        if (enumValue.getNumber() != 0) {
            this.setNumber(enumValue.getNumber());
        }
        if (this.optionsBuilder_ == null) {
            if (!EnumValue.access$500(enumValue).isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = EnumValue.access$500(enumValue);
                    this.bitField0_ &= -5;
                } else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(EnumValue.access$500(enumValue));
                }
                this.onChanged();
            }
        } else if (!EnumValue.access$500(enumValue).isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = EnumValue.access$500(enumValue);
                this.bitField0_ &= -5;
                this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null;
            } else {
                this.optionsBuilder_.addAllMessages(EnumValue.access$500(enumValue));
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
    public EnumValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        EnumValue enumValue = null;
        try {
            try {
                enumValue = (EnumValue)EnumValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                enumValue = (EnumValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (enumValue == null) return this;
            this.mergeFrom(enumValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (enumValue == null) throw var5_7;
            this.mergeFrom(enumValue);
            throw var5_7;
        }
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

    public EnumValue$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder clearName() {
        this.name_ = EnumValue.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public EnumValue$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public int getNumber() {
        return this.number_;
    }

    public EnumValue$Builder setNumber(int n2) {
        this.number_ = n2;
        this.onChanged();
        return this;
    }

    public EnumValue$Builder clearNumber() {
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.options_ = new ArrayList(this.options_);
        this.bitField0_ |= 4;
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

    public EnumValue$Builder setOptions(int n2, Option option) {
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

    public EnumValue$Builder setOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.setMessage(n2, option$Builder.build());
        return this;
    }

    public EnumValue$Builder addOptions(Option option) {
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

    public EnumValue$Builder addOptions(int n2, Option option) {
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

    public EnumValue$Builder addOptions(Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(option$Builder.build());
        return this;
    }

    public EnumValue$Builder addOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(n2, option$Builder.build());
        return this;
    }

    public EnumValue$Builder addAllOptions(Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public EnumValue$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    public EnumValue$Builder removeOptions(int n2) {
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
        this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public final EnumValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final EnumValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ EnumValue$Builder(EnumValue$1 enumValue$1) {
        this();
    }

    /* synthetic */ EnumValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, EnumValue$1 enumValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

