package com.google.protobuf;

import java.io.*;

public final class Duration$Builder extends GeneratedMessage$Builder implements DurationOrBuilder
{
    private long seconds_;
    private int nanos_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
    }
    
    private Duration$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private Duration$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Duration$Builder clear() {
        super.clear();
        this.seconds_ = 0L;
        this.nanos_ = 0;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }
    
    public Duration getDefaultInstanceForType() {
        return Duration.getDefaultInstance();
    }
    
    public Duration build() {
        final Duration buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Duration buildPartial() {
        final Duration duration = new Duration(this, null);
        duration.seconds_ = this.seconds_;
        duration.nanos_ = this.nanos_;
        this.onBuilt();
        return duration;
    }
    
    public Duration$Builder mergeFrom(final Message message) {
        if (message instanceof Duration) {
            return this.mergeFrom((Duration)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Duration$Builder mergeFrom(final Duration duration) {
        if (duration == Duration.getDefaultInstance()) {
            return this;
        }
        if (duration.getSeconds() != 0L) {
            this.setSeconds(duration.getSeconds());
        }
        if (duration.getNanos() != 0) {
            this.setNanos(duration.getNanos());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Duration$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Duration duration = null;
        try {
            duration = (Duration)Duration.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            duration = (Duration)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (duration != null) {
                this.mergeFrom(duration);
            }
        }
        return this;
    }
    
    public long getSeconds() {
        return this.seconds_;
    }
    
    public Duration$Builder setSeconds(final long seconds_) {
        this.seconds_ = seconds_;
        this.onChanged();
        return this;
    }
    
    public Duration$Builder clearSeconds() {
        this.seconds_ = 0L;
        this.onChanged();
        return this;
    }
    
    public int getNanos() {
        return this.nanos_;
    }
    
    public Duration$Builder setNanos(final int nanos_) {
        this.nanos_ = nanos_;
        this.onChanged();
        return this;
    }
    
    public Duration$Builder clearNanos() {
        this.nanos_ = 0;
        this.onChanged();
        return this;
    }
    
    public final Duration$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Duration$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
