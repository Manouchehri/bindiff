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
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$1;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.UnknownFieldSet;

public final class SourceContext$Builder
extends GeneratedMessage$Builder
implements SourceContextOrBuilder {
    private Object fileName_ = "";

    public static final Descriptors$Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
    }

    private SourceContext$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private SourceContext$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public SourceContext$Builder clear() {
        super.clear();
        this.fileName_ = "";
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    @Override
    public SourceContext getDefaultInstanceForType() {
        return SourceContext.getDefaultInstance();
    }

    @Override
    public SourceContext build() {
        SourceContext sourceContext = this.buildPartial();
        if (sourceContext.isInitialized()) return sourceContext;
        throw SourceContext$Builder.newUninitializedMessageException(sourceContext);
    }

    @Override
    public SourceContext buildPartial() {
        SourceContext sourceContext = new SourceContext(this, null);
        SourceContext.access$302(sourceContext, this.fileName_);
        this.onBuilt();
        return sourceContext;
    }

    @Override
    public SourceContext$Builder mergeFrom(Message message) {
        if (message instanceof SourceContext) {
            return this.mergeFrom((SourceContext)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public SourceContext$Builder mergeFrom(SourceContext sourceContext) {
        if (sourceContext == SourceContext.getDefaultInstance()) {
            return this;
        }
        if (!sourceContext.getFileName().isEmpty()) {
            this.fileName_ = SourceContext.access$300(sourceContext);
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
    public SourceContext$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        SourceContext sourceContext = null;
        try {
            try {
                sourceContext = (SourceContext)SourceContext.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                sourceContext = (SourceContext)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (sourceContext == null) return this;
            this.mergeFrom(sourceContext);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (sourceContext == null) throw var5_7;
            this.mergeFrom(sourceContext);
            throw var5_7;
        }
    }

    @Override
    public String getFileName() {
        Object object = this.fileName_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.fileName_ = string;
        return string;
    }

    @Override
    public ByteString getFileNameBytes() {
        ByteString byteString;
        Object object = this.fileName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.fileName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public SourceContext$Builder setFileName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.fileName_ = string;
        this.onChanged();
        return this;
    }

    public SourceContext$Builder clearFileName() {
        this.fileName_ = SourceContext.getDefaultInstance().getFileName();
        this.onChanged();
        return this;
    }

    public SourceContext$Builder setFileNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.fileName_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public final SourceContext$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final SourceContext$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ SourceContext$Builder(SourceContext$1 sourceContext$1) {
        this();
    }

    /* synthetic */ SourceContext$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, SourceContext$1 sourceContext$1) {
        this(generatedMessage$BuilderParent);
    }
}

