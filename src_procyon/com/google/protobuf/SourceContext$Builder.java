package com.google.protobuf;

import java.io.*;

public final class SourceContext$Builder extends GeneratedMessage$Builder implements SourceContextOrBuilder
{
    private Object fileName_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
    }
    
    private SourceContext$Builder() {
        this.fileName_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private SourceContext$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.fileName_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public SourceContext$Builder clear() {
        super.clear();
        this.fileName_ = "";
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }
    
    public SourceContext getDefaultInstanceForType() {
        return SourceContext.getDefaultInstance();
    }
    
    public SourceContext build() {
        final SourceContext buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public SourceContext buildPartial() {
        final SourceContext sourceContext = new SourceContext(this, null);
        sourceContext.fileName_ = this.fileName_;
        this.onBuilt();
        return sourceContext;
    }
    
    public SourceContext$Builder mergeFrom(final Message message) {
        if (message instanceof SourceContext) {
            return this.mergeFrom((SourceContext)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public SourceContext$Builder mergeFrom(final SourceContext sourceContext) {
        if (sourceContext == SourceContext.getDefaultInstance()) {
            return this;
        }
        if (!sourceContext.getFileName().isEmpty()) {
            this.fileName_ = sourceContext.fileName_;
            this.onChanged();
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public SourceContext$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        SourceContext sourceContext = null;
        try {
            sourceContext = (SourceContext)SourceContext.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            sourceContext = (SourceContext)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (sourceContext != null) {
                this.mergeFrom(sourceContext);
            }
        }
        return this;
    }
    
    public String getFileName() {
        final Object fileName_ = this.fileName_;
        if (!(fileName_ instanceof String)) {
            final ByteString byteString = (ByteString)fileName_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.fileName_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)fileName_;
    }
    
    public ByteString getFileNameBytes() {
        final Object fileName_ = this.fileName_;
        if (fileName_ instanceof String) {
            return (ByteString)(this.fileName_ = ByteString.copyFromUtf8((String)fileName_));
        }
        return (ByteString)fileName_;
    }
    
    public SourceContext$Builder setFileName(final String fileName_) {
        if (fileName_ == null) {
            throw new NullPointerException();
        }
        this.fileName_ = fileName_;
        this.onChanged();
        return this;
    }
    
    public SourceContext$Builder clearFileName() {
        this.fileName_ = SourceContext.getDefaultInstance().getFileName();
        this.onChanged();
        return this;
    }
    
    public SourceContext$Builder setFileNameBytes(final ByteString fileName_) {
        if (fileName_ == null) {
            throw new NullPointerException();
        }
        this.fileName_ = fileName_;
        this.onChanged();
        return this;
    }
    
    public final SourceContext$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final SourceContext$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
