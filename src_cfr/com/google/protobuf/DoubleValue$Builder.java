/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.DoubleValue$1;
import com.google.protobuf.DoubleValueOrBuilder;
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

public final class DoubleValue$Builder
extends GeneratedMessage$Builder
implements DoubleValueOrBuilder {
    private double value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
    }

    private DoubleValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DoubleValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public DoubleValue$Builder clear() {
        super.clear();
        this.value_ = 0.0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    @Override
    public DoubleValue getDefaultInstanceForType() {
        return DoubleValue.getDefaultInstance();
    }

    @Override
    public DoubleValue build() {
        DoubleValue doubleValue = this.buildPartial();
        if (doubleValue.isInitialized()) return doubleValue;
        throw DoubleValue$Builder.newUninitializedMessageException(doubleValue);
    }

    @Override
    public DoubleValue buildPartial() {
        DoubleValue doubleValue = new DoubleValue(this, null);
        DoubleValue.access$302(doubleValue, this.value_);
        this.onBuilt();
        return doubleValue;
    }

    @Override
    public DoubleValue$Builder mergeFrom(Message message) {
        if (message instanceof DoubleValue) {
            return this.mergeFrom((DoubleValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DoubleValue$Builder mergeFrom(DoubleValue doubleValue) {
        if (doubleValue == DoubleValue.getDefaultInstance()) {
            return this;
        }
        if (doubleValue.getValue() != 0.0) {
            this.setValue(doubleValue.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public DoubleValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DoubleValue doubleValue = null;
        try {
            try {
                doubleValue = (DoubleValue)DoubleValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                doubleValue = (DoubleValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (doubleValue == null) return this;
            this.mergeFrom(doubleValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (doubleValue == null) throw var5_7;
            this.mergeFrom(doubleValue);
            throw var5_7;
        }
    }

    @Override
    public double getValue() {
        return this.value_;
    }

    public DoubleValue$Builder setValue(double d2) {
        this.value_ = d2;
        this.onChanged();
        return this;
    }

    public DoubleValue$Builder clearValue() {
        this.value_ = 0.0;
        this.onChanged();
        return this;
    }

    @Override
    public final DoubleValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final DoubleValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ DoubleValue$Builder(DoubleValue$1 doubleValue$1) {
        this();
    }

    /* synthetic */ DoubleValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DoubleValue$1 doubleValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

