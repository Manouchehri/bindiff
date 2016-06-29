package com.google.protobuf;

import java.io.*;

public final class Empty extends GeneratedMessage implements EmptyOrBuilder
{
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Empty DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Empty(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Empty() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Empty(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
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
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        return this.memoizedSerializedSize = 0;
    }
    
    public static Empty parseFrom(final ByteString byteString) {
        return (Empty)Empty.PARSER.parseFrom(byteString);
    }
    
    public static Empty parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)Empty.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Empty parseFrom(final byte[] array) {
        return (Empty)Empty.PARSER.parseFrom(array);
    }
    
    public static Empty parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)Empty.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Empty parseFrom(final InputStream inputStream) {
        return (Empty)Empty.PARSER.parseFrom(inputStream);
    }
    
    public static Empty parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)Empty.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Empty parseDelimitedFrom(final InputStream inputStream) {
        return (Empty)Empty.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Empty parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)Empty.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Empty parseFrom(final CodedInputStream codedInputStream) {
        return (Empty)Empty.PARSER.parseFrom(codedInputStream);
    }
    
    public static Empty parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)Empty.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Empty$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Empty$Builder newBuilder() {
        return Empty.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Empty$Builder newBuilder(final Empty empty) {
        return Empty.DEFAULT_INSTANCE.toBuilder().mergeFrom(empty);
    }
    
    public Empty$Builder toBuilder() {
        return (this == Empty.DEFAULT_INSTANCE) ? new Empty$Builder((Empty$1)null) : new Empty$Builder((Empty$1)null).mergeFrom(this);
    }
    
    protected Empty$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Empty$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Empty getDefaultInstance() {
        return Empty.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Empty.PARSER;
    }
    
    public Empty getDefaultInstanceForType() {
        return Empty.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Empty();
        PARSER = new Empty$1();
    }
}
