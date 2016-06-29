package com.google.protobuf;

import java.io.*;

public final class SourceContext extends GeneratedMessage implements SourceContextOrBuilder
{
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private volatile Object fileName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final SourceContext DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private SourceContext(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private SourceContext() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.fileName_ = "";
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private SourceContext(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        try {
            int i = 0;
            while (i == 0) {
                final int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0: {
                        i = 1;
                        continue;
                    }
                    default: {
                        if (!codedInputStream.skipField(tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        this.fileName_ = codedInputStream.readBytes();
                        continue;
                    }
                }
            }
        }
        catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex.setUnfinishedMessage(this));
        }
        catch (IOException ex2) {
            throw new RuntimeException(new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
    }
    
    public String getFileName() {
        final Object fileName_ = this.fileName_;
        if (fileName_ instanceof String) {
            return (String)fileName_;
        }
        final ByteString byteString = (ByteString)fileName_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.fileName_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getFileNameBytes() {
        final Object fileName_ = this.fileName_;
        if (fileName_ instanceof String) {
            return (ByteString)(this.fileName_ = ByteString.copyFromUtf8((String)fileName_));
        }
        return (ByteString)fileName_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if (!this.getFileNameBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getFileNameBytes());
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (!this.getFileNameBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(1, this.getFileNameBytes());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static SourceContext parseFrom(final ByteString byteString) {
        return (SourceContext)SourceContext.PARSER.parseFrom(byteString);
    }
    
    public static SourceContext parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)SourceContext.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static SourceContext parseFrom(final byte[] array) {
        return (SourceContext)SourceContext.PARSER.parseFrom(array);
    }
    
    public static SourceContext parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)SourceContext.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static SourceContext parseFrom(final InputStream inputStream) {
        return (SourceContext)SourceContext.PARSER.parseFrom(inputStream);
    }
    
    public static SourceContext parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)SourceContext.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static SourceContext parseDelimitedFrom(final InputStream inputStream) {
        return (SourceContext)SourceContext.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static SourceContext parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)SourceContext.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static SourceContext parseFrom(final CodedInputStream codedInputStream) {
        return (SourceContext)SourceContext.PARSER.parseFrom(codedInputStream);
    }
    
    public static SourceContext parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)SourceContext.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public SourceContext$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static SourceContext$Builder newBuilder() {
        return SourceContext.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static SourceContext$Builder newBuilder(final SourceContext sourceContext) {
        return SourceContext.DEFAULT_INSTANCE.toBuilder().mergeFrom(sourceContext);
    }
    
    public SourceContext$Builder toBuilder() {
        return (this == SourceContext.DEFAULT_INSTANCE) ? new SourceContext$Builder((SourceContext$1)null) : new SourceContext$Builder((SourceContext$1)null).mergeFrom(this);
    }
    
    protected SourceContext$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new SourceContext$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static SourceContext getDefaultInstance() {
        return SourceContext.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return SourceContext.PARSER;
    }
    
    public SourceContext getDefaultInstanceForType() {
        return SourceContext.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new SourceContext();
        PARSER = new SourceContext$1();
    }
}
