/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.FloatValue$1;
import com.google.protobuf.FloatValueOrBuilder;
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

public final class FloatValue$Builder
extends GeneratedMessage$Builder
implements FloatValueOrBuilder {
    private float value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
    }

    private FloatValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private FloatValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public FloatValue$Builder clear() {
        super.clear();
        this.value_ = 0.0f;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }

    @Override
    public FloatValue getDefaultInstanceForType() {
        return FloatValue.getDefaultInstance();
    }

    @Override
    public FloatValue build() {
        FloatValue floatValue = this.buildPartial();
        if (floatValue.isInitialized()) return floatValue;
        throw FloatValue$Builder.newUninitializedMessageException(floatValue);
    }

    @Override
    public FloatValue buildPartial() {
        FloatValue floatValue = new FloatValue(this, null);
        FloatValue.access$302(floatValue, this.value_);
        this.onBuilt();
        return floatValue;
    }

    @Override
    public FloatValue$Builder mergeFrom(Message message) {
        if (message instanceof FloatValue) {
            return this.mergeFrom((FloatValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public FloatValue$Builder mergeFrom(FloatValue floatValue) {
        if (floatValue == FloatValue.getDefaultInstance()) {
            return this;
        }
        if (floatValue.getValue() != 0.0f) {
            this.setValue(floatValue.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public FloatValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        FloatValue floatValue = null;
        try {
            try {
                floatValue = (FloatValue)FloatValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                floatValue = (FloatValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (floatValue == null) return this;
            this.mergeFrom(floatValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (floatValue == null) throw var5_7;
            this.mergeFrom(floatValue);
            throw var5_7;
        }
    }

    @Override
    public float getValue() {
        return this.value_;
    }

    public FloatValue$Builder setValue(float f2) {
        this.value_ = f2;
        this.onChanged();
        return this;
    }

    public FloatValue$Builder clearValue() {
        this.value_ = 0.0f;
        this.onChanged();
        return this;
    }

    @Override
    public final FloatValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final FloatValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ FloatValue$Builder(FloatValue$1 floatValue$1) {
        this();
    }

    /* synthetic */ FloatValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, FloatValue$1 floatValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

