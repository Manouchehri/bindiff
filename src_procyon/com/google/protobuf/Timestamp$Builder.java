package com.google.protobuf;

import java.io.*;

public final class Timestamp$Builder extends GeneratedMessage$Builder implements TimestampOrBuilder
{
    private long seconds_;
    private int nanos_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
    }
    
    private Timestamp$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private Timestamp$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Timestamp$Builder clear() {
        super.clear();
        this.seconds_ = 0L;
        this.nanos_ = 0;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }
    
    public Timestamp getDefaultInstanceForType() {
        return Timestamp.getDefaultInstance();
    }
    
    public Timestamp build() {
        final Timestamp buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Timestamp buildPartial() {
        final Timestamp timestamp = new Timestamp(this, null);
        timestamp.seconds_ = this.seconds_;
        timestamp.nanos_ = this.nanos_;
        this.onBuilt();
        return timestamp;
    }
    
    public Timestamp$Builder mergeFrom(final Message message) {
        if (message instanceof Timestamp) {
            return this.mergeFrom((Timestamp)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Timestamp$Builder mergeFrom(final Timestamp timestamp) {
        if (timestamp == Timestamp.getDefaultInstance()) {
            return this;
        }
        if (timestamp.getSeconds() != 0L) {
            this.setSeconds(timestamp.getSeconds());
        }
        if (timestamp.getNanos() != 0) {
            this.setNanos(timestamp.getNanos());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Timestamp$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Timestamp timestamp = null;
        try {
            timestamp = (Timestamp)Timestamp.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            timestamp = (Timestamp)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (timestamp != null) {
                this.mergeFrom(timestamp);
            }
        }
        return this;
    }
    
    public long getSeconds() {
        return this.seconds_;
    }
    
    public Timestamp$Builder setSeconds(final long seconds_) {
        this.seconds_ = seconds_;
        this.onChanged();
        return this;
    }
    
    public Timestamp$Builder clearSeconds() {
        this.seconds_ = 0L;
        this.onChanged();
        return this;
    }
    
    public int getNanos() {
        return this.nanos_;
    }
    
    public Timestamp$Builder setNanos(final int nanos_) {
        this.nanos_ = nanos_;
        this.onChanged();
        return this;
    }
    
    public Timestamp$Builder clearNanos() {
        this.nanos_ = 0;
        this.onChanged();
        return this;
    }
    
    public final Timestamp$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Timestamp$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
