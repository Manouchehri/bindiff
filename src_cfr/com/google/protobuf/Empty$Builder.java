/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Empty;
import com.google.protobuf.Empty$1;
import com.google.protobuf.EmptyOrBuilder;
import com.google.protobuf.EmptyProto;
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

public final class Empty$Builder
extends GeneratedMessage$Builder
implements EmptyOrBuilder {
    public static final Descriptors$Descriptor getDescriptor() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
    }

    private Empty$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Empty$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Empty$Builder clear() {
        super.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }

    @Override
    public Empty getDefaultInstanceForType() {
        return Empty.getDefaultInstance();
    }

    @Override
    public Empty build() {
        Empty empty = this.buildPartial();
        if (empty.isInitialized()) return empty;
        throw Empty$Builder.newUninitializedMessageException(empty);
    }

    @Override
    public Empty buildPartial() {
        Empty empty = new Empty(this, null);
        this.onBuilt();
        return empty;
    }

    @Override
    public Empty$Builder mergeFrom(Message message) {
        if (message instanceof Empty) {
            return this.mergeFrom((Empty)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Empty$Builder mergeFrom(Empty empty) {
        if (empty == Empty.getDefaultInstance()) {
            return this;
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Empty$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Empty empty = null;
        try {
            try {
                empty = (Empty)Empty.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                empty = (Empty)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (empty == null) return this;
            this.mergeFrom(empty);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (empty == null) throw var5_7;
            this.mergeFrom(empty);
            throw var5_7;
        }
    }

    @Override
    public final Empty$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Empty$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Empty$Builder(Empty$1 empty$1) {
        this();
    }

    /* synthetic */ Empty$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Empty$1 empty$1) {
        this(generatedMessage$BuilderParent);
    }
}

