/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BoolValue$1;
import com.google.protobuf.BoolValueOrBuilder;
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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class BoolValue$Builder
extends GeneratedMessage$Builder
implements BoolValueOrBuilder {
    private boolean value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
    }

    private BoolValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BoolValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public BoolValue$Builder clear() {
        super.clear();
        this.value_ = false;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    @Override
    public BoolValue getDefaultInstanceForType() {
        return BoolValue.getDefaultInstance();
    }

    @Override
    public BoolValue build() {
        BoolValue boolValue = this.buildPartial();
        if (boolValue.isInitialized()) return boolValue;
        throw BoolValue$Builder.newUninitializedMessageException(boolValue);
    }

    @Override
    public BoolValue buildPartial() {
        BoolValue boolValue = new BoolValue(this, null);
        BoolValue.access$302(boolValue, this.value_);
        this.onBuilt();
        return boolValue;
    }

    @Override
    public BoolValue$Builder mergeFrom(Message message) {
        if (message instanceof BoolValue) {
            return this.mergeFrom((BoolValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BoolValue$Builder mergeFrom(BoolValue boolValue) {
        if (boolValue == BoolValue.getDefaultInstance()) {
            return this;
        }
        if (boolValue.getValue()) {
            this.setValue(boolValue.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public BoolValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BoolValue boolValue = null;
        try {
            try {
                boolValue = (BoolValue)BoolValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                boolValue = (BoolValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (boolValue == null) return this;
            this.mergeFrom(boolValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (boolValue == null) throw var5_7;
            this.mergeFrom(boolValue);
            throw var5_7;
        }
    }

    @Override
    public boolean getValue() {
        return this.value_;
    }

    public BoolValue$Builder setValue(boolean bl2) {
        this.value_ = bl2;
        this.onChanged();
        return this;
    }

    public BoolValue$Builder clearValue() {
        this.value_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public final BoolValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final BoolValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ BoolValue$Builder(BoolValue$1 boolValue$1) {
        this();
    }

    /* synthetic */ BoolValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BoolValue$1 boolValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

