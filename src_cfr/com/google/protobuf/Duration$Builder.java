/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Duration;
import com.google.protobuf.Duration$1;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.DurationProto;
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

public final class Duration$Builder
extends GeneratedMessage$Builder
implements DurationOrBuilder {
    private long seconds_;
    private int nanos_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
    }

    private Duration$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Duration$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Duration$Builder clear() {
        super.clear();
        this.seconds_ = 0;
        this.nanos_ = 0;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }

    @Override
    public Duration getDefaultInstanceForType() {
        return Duration.getDefaultInstance();
    }

    @Override
    public Duration build() {
        Duration duration = this.buildPartial();
        if (duration.isInitialized()) return duration;
        throw Duration$Builder.newUninitializedMessageException(duration);
    }

    @Override
    public Duration buildPartial() {
        Duration duration = new Duration(this, null);
        Duration.access$302(duration, this.seconds_);
        Duration.access$402(duration, this.nanos_);
        this.onBuilt();
        return duration;
    }

    @Override
    public Duration$Builder mergeFrom(Message message) {
        if (message instanceof Duration) {
            return this.mergeFrom((Duration)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Duration$Builder mergeFrom(Duration duration) {
        if (duration == Duration.getDefaultInstance()) {
            return this;
        }
        if (duration.getSeconds() != 0) {
            this.setSeconds(duration.getSeconds());
        }
        if (duration.getNanos() != 0) {
            this.setNanos(duration.getNanos());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Duration$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Duration duration = null;
        try {
            try {
                duration = (Duration)Duration.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                duration = (Duration)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (duration == null) return this;
            this.mergeFrom(duration);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (duration == null) throw var5_7;
            this.mergeFrom(duration);
            throw var5_7;
        }
    }

    @Override
    public long getSeconds() {
        return this.seconds_;
    }

    public Duration$Builder setSeconds(long l2) {
        this.seconds_ = l2;
        this.onChanged();
        return this;
    }

    public Duration$Builder clearSeconds() {
        this.seconds_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public int getNanos() {
        return this.nanos_;
    }

    public Duration$Builder setNanos(int n2) {
        this.nanos_ = n2;
        this.onChanged();
        return this;
    }

    public Duration$Builder clearNanos() {
        this.nanos_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public final Duration$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Duration$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Duration$Builder(Duration$1 duration$1) {
        this();
    }

    /* synthetic */ Duration$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Duration$1 duration$1) {
        this(generatedMessage$BuilderParent);
    }
}

