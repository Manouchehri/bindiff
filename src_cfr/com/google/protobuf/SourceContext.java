/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
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
import com.google.protobuf.SourceContext$1;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class SourceContext
extends GeneratedMessage
implements SourceContextOrBuilder {
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private volatile Object fileName_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final SourceContext DEFAULT_INSTANCE = new SourceContext();
    public static final Parser PARSER = new SourceContext$1();

    private SourceContext(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private SourceContext() {
        this.fileName_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private SourceContext(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block9 : while (!bl3) {
                    ByteString byteString;
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block9;
                        }
                        default: {
                            if (codedInputStream.skipField(n2)) continue block9;
                            bl3 = true;
                            continue block9;
                        }
                        case 10: 
                    }
                    this.fileName_ = byteString = codedInputStream.readBytes();
                }
                Object var8_9 = null;
            }
            catch (InvalidProtocolBufferException var4_5) {
                throw new RuntimeException(var4_5.setUnfinishedMessage(this));
            }
            catch (IOException var4_6) {
                throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
    }

    @Override
    public String getFileName() {
        Object object = this.fileName_;
        if (object instanceof String) {
            return (String)object;
        }
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

    @Override
    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.getFileNameBytes().isEmpty()) return;
        codedOutputStream.writeBytes(1, this.getFileNameBytes());
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (!this.getFileNameBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getFileNameBytes());
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static SourceContext parseFrom(ByteString byteString) {
        return (SourceContext)PARSER.parseFrom(byteString);
    }

    public static SourceContext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SourceContext parseFrom(byte[] arrby) {
        return (SourceContext)PARSER.parseFrom(arrby);
    }

    public static SourceContext parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static SourceContext parseFrom(InputStream inputStream) {
        return (SourceContext)PARSER.parseFrom(inputStream);
    }

    public static SourceContext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static SourceContext parseDelimitedFrom(InputStream inputStream) {
        return (SourceContext)PARSER.parseDelimitedFrom(inputStream);
    }

    public static SourceContext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static SourceContext parseFrom(CodedInputStream codedInputStream) {
        return (SourceContext)PARSER.parseFrom(codedInputStream);
    }

    public static SourceContext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public SourceContext$Builder newBuilderForType() {
        return SourceContext.newBuilder();
    }

    public static SourceContext$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SourceContext$Builder newBuilder(SourceContext sourceContext) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(sourceContext);
    }

    @Override
    public SourceContext$Builder toBuilder() {
        SourceContext$Builder sourceContext$Builder;
        if (this == DEFAULT_INSTANCE) {
            sourceContext$Builder = new SourceContext$Builder(null);
            return sourceContext$Builder;
        }
        sourceContext$Builder = new SourceContext$Builder(null).mergeFrom(this);
        return sourceContext$Builder;
    }

    @Override
    protected SourceContext$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new SourceContext$Builder(generatedMessage$BuilderParent, null);
    }

    public static SourceContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public SourceContext getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ SourceContext(GeneratedMessage$Builder generatedMessage$Builder, SourceContext$1 sourceContext$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(SourceContext sourceContext, Object object) {
        sourceContext.fileName_ = object;
        return sourceContext.fileName_;
    }

    static /* synthetic */ Object access$300(SourceContext sourceContext) {
        return sourceContext.fileName_;
    }

    /* synthetic */ SourceContext(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, SourceContext$1 sourceContext$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

