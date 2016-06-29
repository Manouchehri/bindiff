/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
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
import com.google.protobuf.UInt64Value;
import com.google.protobuf.UInt64Value$1;
import com.google.protobuf.UInt64ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class UInt64Value$Builder
extends GeneratedMessage$Builder
implements UInt64ValueOrBuilder {
    private long value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, UInt64Value$Builder.class);
    }

    private UInt64Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private UInt64Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public UInt64Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    @Override
    public UInt64Value getDefaultInstanceForType() {
        return UInt64Value.getDefaultInstance();
    }

    @Override
    public UInt64Value build() {
        UInt64Value uInt64Value = this.buildPartial();
        if (uInt64Value.isInitialized()) return uInt64Value;
        throw UInt64Value$Builder.newUninitializedMessageException(uInt64Value);
    }

    @Override
    public UInt64Value buildPartial() {
        UInt64Value uInt64Value = new UInt64Value(this, null);
        UInt64Value.access$302(uInt64Value, this.value_);
        this.onBuilt();
        return uInt64Value;
    }

    @Override
    public UInt64Value$Builder mergeFrom(Message message) {
        if (message instanceof UInt64Value) {
            return this.mergeFrom((UInt64Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public UInt64Value$Builder mergeFrom(UInt64Value uInt64Value) {
        if (uInt64Value == UInt64Value.getDefaultInstance()) {
            return this;
        }
        if (uInt64Value.getValue() != 0) {
            this.setValue(uInt64Value.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public UInt64Value$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UInt64Value uInt64Value = null;
        try {
            try {
                uInt64Value = (UInt64Value)UInt64Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                uInt64Value = (UInt64Value)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (uInt64Value == null) return this;
            this.mergeFrom(uInt64Value);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (uInt64Value == null) throw var5_7;
            this.mergeFrom(uInt64Value);
            throw var5_7;
        }
    }

    @Override
    public long getValue() {
        return this.value_;
    }

    public UInt64Value$Builder setValue(long l2) {
        this.value_ = l2;
        this.onChanged();
        return this;
    }

    public UInt64Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public final UInt64Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final UInt64Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ UInt64Value$Builder(UInt64Value$1 uInt64Value$1) {
        this();
    }

    /* synthetic */ UInt64Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, UInt64Value$1 uInt64Value$1) {
        this(generatedMessage$BuilderParent);
    }
}

