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
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32Value$1;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class UInt32Value$Builder
extends GeneratedMessage$Builder
implements UInt32ValueOrBuilder {
    private int value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt32Value.class, UInt32Value$Builder.class);
    }

    private UInt32Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private UInt32Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public UInt32Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }

    @Override
    public UInt32Value getDefaultInstanceForType() {
        return UInt32Value.getDefaultInstance();
    }

    @Override
    public UInt32Value build() {
        UInt32Value uInt32Value = this.buildPartial();
        if (uInt32Value.isInitialized()) return uInt32Value;
        throw UInt32Value$Builder.newUninitializedMessageException(uInt32Value);
    }

    @Override
    public UInt32Value buildPartial() {
        UInt32Value uInt32Value = new UInt32Value(this, null);
        UInt32Value.access$302(uInt32Value, this.value_);
        this.onBuilt();
        return uInt32Value;
    }

    @Override
    public UInt32Value$Builder mergeFrom(Message message) {
        if (message instanceof UInt32Value) {
            return this.mergeFrom((UInt32Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public UInt32Value$Builder mergeFrom(UInt32Value uInt32Value) {
        if (uInt32Value == UInt32Value.getDefaultInstance()) {
            return this;
        }
        if (uInt32Value.getValue() != 0) {
            this.setValue(uInt32Value.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public UInt32Value$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UInt32Value uInt32Value = null;
        try {
            try {
                uInt32Value = (UInt32Value)UInt32Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                uInt32Value = (UInt32Value)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (uInt32Value == null) return this;
            this.mergeFrom(uInt32Value);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (uInt32Value == null) throw var5_7;
            this.mergeFrom(uInt32Value);
            throw var5_7;
        }
    }

    @Override
    public int getValue() {
        return this.value_;
    }

    public UInt32Value$Builder setValue(int n2) {
        this.value_ = n2;
        this.onChanged();
        return this;
    }

    public UInt32Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public final UInt32Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final UInt32Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ UInt32Value$Builder(UInt32Value$1 uInt32Value$1) {
        this();
    }

    /* synthetic */ UInt32Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, UInt32Value$1 uInt32Value$1) {
        this(generatedMessage$BuilderParent);
    }
}

