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
import com.google.protobuf.Timestamp;
import com.google.protobuf.Timestamp$1;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.TimestampProto;
import com.google.protobuf.UnknownFieldSet;

public final class Timestamp$Builder
extends GeneratedMessage$Builder
implements TimestampOrBuilder {
    private long seconds_;
    private int nanos_;

    public static final Descriptors$Descriptor getDescriptor() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
    }

    private Timestamp$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Timestamp$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Timestamp$Builder clear() {
        super.clear();
        this.seconds_ = 0;
        this.nanos_ = 0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    @Override
    public Timestamp getDefaultInstanceForType() {
        return Timestamp.getDefaultInstance();
    }

    @Override
    public Timestamp build() {
        Timestamp timestamp = this.buildPartial();
        if (timestamp.isInitialized()) return timestamp;
        throw Timestamp$Builder.newUninitializedMessageException(timestamp);
    }

    @Override
    public Timestamp buildPartial() {
        Timestamp timestamp = new Timestamp(this, null);
        Timestamp.access$302(timestamp, this.seconds_);
        Timestamp.access$402(timestamp, this.nanos_);
        this.onBuilt();
        return timestamp;
    }

    @Override
    public Timestamp$Builder mergeFrom(Message message) {
        if (message instanceof Timestamp) {
            return this.mergeFrom((Timestamp)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Timestamp$Builder mergeFrom(Timestamp timestamp) {
        if (timestamp == Timestamp.getDefaultInstance()) {
            return this;
        }
        if (timestamp.getSeconds() != 0) {
            this.setSeconds(timestamp.getSeconds());
        }
        if (timestamp.getNanos() != 0) {
            this.setNanos(timestamp.getNanos());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Timestamp$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Timestamp timestamp = null;
        try {
            try {
                timestamp = (Timestamp)Timestamp.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                timestamp = (Timestamp)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (timestamp == null) return this;
            this.mergeFrom(timestamp);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (timestamp == null) throw var5_7;
            this.mergeFrom(timestamp);
            throw var5_7;
        }
    }

    @Override
    public long getSeconds() {
        return this.seconds_;
    }

    public Timestamp$Builder setSeconds(long l2) {
        this.seconds_ = l2;
        this.onChanged();
        return this;
    }

    public Timestamp$Builder clearSeconds() {
        this.seconds_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public int getNanos() {
        return this.nanos_;
    }

    public Timestamp$Builder setNanos(int n2) {
        this.nanos_ = n2;
        this.onChanged();
        return this;
    }

    public Timestamp$Builder clearNanos() {
        this.nanos_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public final Timestamp$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Timestamp$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Timestamp$Builder(Timestamp$1 timestamp$1) {
        this();
    }

    /* synthetic */ Timestamp$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Timestamp$1 timestamp$1) {
        this(generatedMessage$BuilderParent);
    }
}

