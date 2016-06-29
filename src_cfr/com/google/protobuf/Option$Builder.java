/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$1;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;

public final class Option$Builder
extends GeneratedMessage$Builder
implements OptionOrBuilder {
    private Object name_ = "";
    private Any value_ = null;
    private SingleFieldBuilder valueBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
    }

    private Option$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Option$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Option$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.valueBuilder_ == null) {
            this.value_ = null;
            return this;
        }
        this.value_ = null;
        this.valueBuilder_ = null;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    @Override
    public Option getDefaultInstanceForType() {
        return Option.getDefaultInstance();
    }

    @Override
    public Option build() {
        Option option = this.buildPartial();
        if (option.isInitialized()) return option;
        throw Option$Builder.newUninitializedMessageException(option);
    }

    @Override
    public Option buildPartial() {
        Option option = new Option(this, null);
        Option.access$302(option, this.name_);
        if (this.valueBuilder_ == null) {
            Option.access$402(option, this.value_);
        } else {
            Option.access$402(option, (Any)this.valueBuilder_.build());
        }
        this.onBuilt();
        return option;
    }

    @Override
    public Option$Builder mergeFrom(Message message) {
        if (message instanceof Option) {
            return this.mergeFrom((Option)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Option$Builder mergeFrom(Option option) {
        if (option == Option.getDefaultInstance()) {
            return this;
        }
        if (!option.getName().isEmpty()) {
            this.name_ = Option.access$300(option);
            this.onChanged();
        }
        if (option.hasValue()) {
            this.mergeValue(option.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Option$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Option option = null;
        try {
            try {
                option = (Option)Option.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                option = (Option)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (option == null) return this;
            this.mergeFrom(option);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (option == null) throw var5_7;
            this.mergeFrom(option);
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

    public Option$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public Option$Builder clearName() {
        this.name_ = Option.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public Option$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasValue() {
        if (this.valueBuilder_ != null) return true;
        if (this.value_ != null) return true;
        return false;
    }

    @Override
    public Any getValue() {
        Any any;
        if (this.valueBuilder_ != null) return (Any)this.valueBuilder_.getMessage();
        if (this.value_ == null) {
            any = Any.getDefaultInstance();
            return any;
        }
        any = this.value_;
        return any;
    }

    public Option$Builder setValue(Any any) {
        if (this.valueBuilder_ != null) {
            this.valueBuilder_.setMessage(any);
            return this;
        }
        if (any == null) {
            throw new NullPointerException();
        }
        this.value_ = any;
        this.onChanged();
        return this;
    }

    public Option$Builder setValue(Any$Builder any$Builder) {
        if (this.valueBuilder_ == null) {
            this.value_ = any$Builder.build();
            this.onChanged();
            return this;
        }
        this.valueBuilder_.setMessage(any$Builder.build());
        return this;
    }

    public Option$Builder mergeValue(Any any) {
        if (this.valueBuilder_ != null) {
            this.valueBuilder_.mergeFrom(any);
            return this;
        }
        this.value_ = this.value_ != null ? Any.newBuilder(this.value_).mergeFrom(any).buildPartial() : any;
        this.onChanged();
        return this;
    }

    public Option$Builder clearValue() {
        if (this.valueBuilder_ == null) {
            this.value_ = null;
            this.onChanged();
            return this;
        }
        this.value_ = null;
        this.valueBuilder_ = null;
        return this;
    }

    public Any$Builder getValueBuilder() {
        this.onChanged();
        return (Any$Builder)this.getValueFieldBuilder().getBuilder();
    }

    @Override
    public AnyOrBuilder getValueOrBuilder() {
        Any any;
        if (this.valueBuilder_ != null) {
            return (AnyOrBuilder)this.valueBuilder_.getMessageOrBuilder();
        }
        if (this.value_ == null) {
            any = Any.getDefaultInstance();
            return any;
        }
        any = this.value_;
        return any;
    }

    private SingleFieldBuilder getValueFieldBuilder() {
        if (this.valueBuilder_ != null) return this.valueBuilder_;
        this.valueBuilder_ = new SingleFieldBuilder(this.getValue(), this.getParentForChildren(), this.isClean());
        this.value_ = null;
        return this.valueBuilder_;
    }

    @Override
    public final Option$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Option$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Option$Builder(Option$1 option$1) {
        this();
    }

    /* synthetic */ Option$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Option$1 option$1) {
        this(generatedMessage$BuilderParent);
    }
}

