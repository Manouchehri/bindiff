/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.BytesValue$1;
import com.google.protobuf.BytesValueOrBuilder;
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

public final class BytesValue$Builder
extends GeneratedMessage$Builder
implements BytesValueOrBuilder {
    private ByteString value_ = ByteString.EMPTY;

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
    }

    private BytesValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BytesValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public BytesValue$Builder clear() {
        super.clear();
        this.value_ = ByteString.EMPTY;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    @Override
    public BytesValue getDefaultInstanceForType() {
        return BytesValue.getDefaultInstance();
    }

    @Override
    public BytesValue build() {
        BytesValue bytesValue = this.buildPartial();
        if (bytesValue.isInitialized()) return bytesValue;
        throw BytesValue$Builder.newUninitializedMessageException(bytesValue);
    }

    @Override
    public BytesValue buildPartial() {
        BytesValue bytesValue = new BytesValue(this, null);
        BytesValue.access$302(bytesValue, this.value_);
        this.onBuilt();
        return bytesValue;
    }

    @Override
    public BytesValue$Builder mergeFrom(Message message) {
        if (message instanceof BytesValue) {
            return this.mergeFrom((BytesValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BytesValue$Builder mergeFrom(BytesValue bytesValue) {
        if (bytesValue == BytesValue.getDefaultInstance()) {
            return this;
        }
        if (bytesValue.getValue() != ByteString.EMPTY) {
            this.setValue(bytesValue.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public BytesValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BytesValue bytesValue = null;
        try {
            try {
                bytesValue = (BytesValue)BytesValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                bytesValue = (BytesValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (bytesValue == null) return this;
            this.mergeFrom(bytesValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (bytesValue == null) throw var5_7;
            this.mergeFrom(bytesValue);
            throw var5_7;
        }
    }

    @Override
    public ByteString getValue() {
        return this.value_;
    }

    public BytesValue$Builder setValue(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.value_ = byteString;
        this.onChanged();
        return this;
    }

    public BytesValue$Builder clearValue() {
        this.value_ = BytesValue.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }

    @Override
    public final BytesValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final BytesValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ BytesValue$Builder(BytesValue$1 bytesValue$1) {
        this();
    }

    /* synthetic */ BytesValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BytesValue$1 bytesValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

