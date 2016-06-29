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
import com.google.protobuf.Int64Value;
import com.google.protobuf.Int64Value$1;
import com.google.protobuf.Int64ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class Int64Value$Builder
extends GeneratedMessage$Builder
implements Int64ValueOrBuilder {
    private long value_;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
    }

    private Int64Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Int64Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Int64Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    @Override
    public Int64Value getDefaultInstanceForType() {
        return Int64Value.getDefaultInstance();
    }

    @Override
    public Int64Value build() {
        Int64Value int64Value = this.buildPartial();
        if (int64Value.isInitialized()) return int64Value;
        throw Int64Value$Builder.newUninitializedMessageException(int64Value);
    }

    @Override
    public Int64Value buildPartial() {
        Int64Value int64Value = new Int64Value(this, null);
        Int64Value.access$302(int64Value, this.value_);
        this.onBuilt();
        return int64Value;
    }

    @Override
    public Int64Value$Builder mergeFrom(Message message) {
        if (message instanceof Int64Value) {
            return this.mergeFrom((Int64Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Int64Value$Builder mergeFrom(Int64Value int64Value) {
        if (int64Value == Int64Value.getDefaultInstance()) {
            return this;
        }
        if (int64Value.getValue() != 0) {
            this.setValue(int64Value.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Int64Value$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Int64Value int64Value = null;
        try {
            try {
                int64Value = (Int64Value)Int64Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                int64Value = (Int64Value)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (int64Value == null) return this;
            this.mergeFrom(int64Value);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (int64Value == null) throw var5_7;
            this.mergeFrom(int64Value);
            throw var5_7;
        }
    }

    @Override
    public long getValue() {
        return this.value_;
    }

    public Int64Value$Builder setValue(long l2) {
        this.value_ = l2;
        this.onChanged();
        return this;
    }

    public Int64Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public final Int64Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Int64Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Int64Value$Builder(Int64Value$1 int64Value$1) {
        this();
    }

    /* synthetic */ Int64Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Int64Value$1 int64Value$1) {
        this(generatedMessage$BuilderParent);
    }
}

