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
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int32Value$1;
import com.google.protobuf.Int32ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class Int32Value$Builder
extends GeneratedMessage$Builder
implements Int32ValueOrBuilder {
    private int value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
    }

    private Int32Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Int32Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Int32Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }

    @Override
    public Int32Value getDefaultInstanceForType() {
        return Int32Value.getDefaultInstance();
    }

    @Override
    public Int32Value build() {
        Int32Value int32Value = this.buildPartial();
        if (int32Value.isInitialized()) return int32Value;
        throw Int32Value$Builder.newUninitializedMessageException(int32Value);
    }

    @Override
    public Int32Value buildPartial() {
        Int32Value int32Value = new Int32Value(this, null);
        Int32Value.access$302(int32Value, this.value_);
        this.onBuilt();
        return int32Value;
    }

    @Override
    public Int32Value$Builder mergeFrom(Message message) {
        if (message instanceof Int32Value) {
            return this.mergeFrom((Int32Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Int32Value$Builder mergeFrom(Int32Value int32Value) {
        if (int32Value == Int32Value.getDefaultInstance()) {
            return this;
        }
        if (int32Value.getValue() != 0) {
            this.setValue(int32Value.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Int32Value$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Int32Value int32Value = null;
        try {
            try {
                int32Value = (Int32Value)Int32Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                int32Value = (Int32Value)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (int32Value == null) return this;
            this.mergeFrom(int32Value);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (int32Value == null) throw var5_7;
            this.mergeFrom(int32Value);
            throw var5_7;
        }
    }

    @Override
    public int getValue() {
        return this.value_;
    }

    public Int32Value$Builder setValue(int n2) {
        this.value_ = n2;
        this.onChanged();
        return this;
    }

    public Int32Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public final Int32Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Int32Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Int32Value$Builder(Int32Value$1 int32Value$1) {
        this();
    }

    /* synthetic */ Int32Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Int32Value$1 int32Value$1) {
        this(generatedMessage$BuilderParent);
    }
}

