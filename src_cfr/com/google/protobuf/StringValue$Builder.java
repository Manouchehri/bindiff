/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
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
import com.google.protobuf.StringValue;
import com.google.protobuf.StringValue$1;
import com.google.protobuf.StringValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class StringValue$Builder
extends GeneratedMessage$Builder
implements StringValueOrBuilder {
    private Object value_ = "";

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
    }

    private StringValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private StringValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public StringValue$Builder clear() {
        super.clear();
        this.value_ = "";
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    @Override
    public StringValue getDefaultInstanceForType() {
        return StringValue.getDefaultInstance();
    }

    @Override
    public StringValue build() {
        StringValue stringValue = this.buildPartial();
        if (stringValue.isInitialized()) return stringValue;
        throw StringValue$Builder.newUninitializedMessageException(stringValue);
    }

    @Override
    public StringValue buildPartial() {
        StringValue stringValue = new StringValue(this, null);
        StringValue.access$302(stringValue, this.value_);
        this.onBuilt();
        return stringValue;
    }

    @Override
    public StringValue$Builder mergeFrom(Message message) {
        if (message instanceof StringValue) {
            return this.mergeFrom((StringValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public StringValue$Builder mergeFrom(StringValue stringValue) {
        if (stringValue == StringValue.getDefaultInstance()) {
            return this;
        }
        if (!stringValue.getValue().isEmpty()) {
            this.value_ = StringValue.access$300(stringValue);
            this.onChanged();
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public StringValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        StringValue stringValue = null;
        try {
            try {
                stringValue = (StringValue)StringValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                stringValue = (StringValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (stringValue == null) return this;
            this.mergeFrom(stringValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (stringValue == null) throw var5_7;
            this.mergeFrom(stringValue);
            throw var5_7;
        }
    }

    @Override
    public String getValue() {
        Object object = this.value_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.value_ = string;
        return string;
    }

    @Override
    public ByteString getValueBytes() {
        ByteString byteString;
        Object object = this.value_;
        if (!(object instanceof String)) return (ByteString)object;
        this.value_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public StringValue$Builder setValue(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.value_ = string;
        this.onChanged();
        return this;
    }

    public StringValue$Builder clearValue() {
        this.value_ = StringValue.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }

    public StringValue$Builder setValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.value_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public final StringValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final StringValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ StringValue$Builder(StringValue$1 stringValue$1) {
        this();
    }

    /* synthetic */ StringValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, StringValue$1 stringValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

