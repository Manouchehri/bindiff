/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Any;
import com.google.protobuf.Any$1;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;

public final class Any$Builder
extends GeneratedMessage$Builder
implements AnyOrBuilder {
    private Object typeUrl_ = "";
    private ByteString value_ = ByteString.EMPTY;

    public static final Descriptors$Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
    }

    private Any$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Any$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Any$Builder clear() {
        super.clear();
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    @Override
    public Any getDefaultInstanceForType() {
        return Any.getDefaultInstance();
    }

    @Override
    public Any build() {
        Any any = this.buildPartial();
        if (any.isInitialized()) return any;
        throw Any$Builder.newUninitializedMessageException(any);
    }

    @Override
    public Any buildPartial() {
        Any any = new Any(this, null);
        Any.access$302(any, this.typeUrl_);
        Any.access$402(any, this.value_);
        this.onBuilt();
        return any;
    }

    @Override
    public Any$Builder mergeFrom(Message message) {
        if (message instanceof Any) {
            return this.mergeFrom((Any)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Any$Builder mergeFrom(Any any) {
        if (any == Any.getDefaultInstance()) {
            return this;
        }
        if (!any.getTypeUrl().isEmpty()) {
            this.typeUrl_ = Any.access$300(any);
            this.onChanged();
        }
        if (any.getValue() != ByteString.EMPTY) {
            this.setValue(any.getValue());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Any$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Any any = null;
        try {
            try {
                any = (Any)Any.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                any = (Any)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (any == null) return this;
            this.mergeFrom(any);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (any == null) throw var5_7;
            this.mergeFrom(any);
            throw var5_7;
        }
    }

    @Override
    public String getTypeUrl() {
        Object object = this.typeUrl_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.typeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getTypeUrlBytes() {
        ByteString byteString;
        Object object = this.typeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.typeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Any$Builder setTypeUrl(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = string;
        this.onChanged();
        return this;
    }

    public Any$Builder clearTypeUrl() {
        this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
        this.onChanged();
        return this;
    }

    public Any$Builder setTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public ByteString getValue() {
        return this.value_;
    }

    public Any$Builder setValue(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.value_ = byteString;
        this.onChanged();
        return this;
    }

    public Any$Builder clearValue() {
        this.value_ = Any.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }

    @Override
    public final Any$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Any$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Any$Builder(Any$1 any$1) {
        this();
    }

    /* synthetic */ Any$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Any$1 any$1) {
        this(generatedMessage$BuilderParent);
    }
}

