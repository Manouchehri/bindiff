package com.google.protobuf;

import java.io.*;

public final class FieldMask extends GeneratedMessage implements FieldMaskOrBuilder
{
    public static final int PATHS_FIELD_NUMBER = 1;
    private LazyStringList paths_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final FieldMask DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private FieldMask(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private FieldMask() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.paths_ = LazyStringArrayList.EMPTY;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private FieldMask(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
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
                        final ByteString bytes = codedInputStream.readBytes();
                        if ((n & 0x1) != 0x1) {
                            this.paths_ = new LazyStringArrayList();
                            n |= 0x1;
                        }
                        this.paths_.add(bytes);
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
            if ((n & 0x1) == 0x1) {
                this.paths_ = this.paths_.getUnmodifiableView();
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
    }
    
    public ProtocolStringList getPathsList() {
        return this.paths_;
    }
    
    public int getPathsCount() {
        return this.paths_.size();
    }
    
    public String getPaths(final int n) {
        return this.paths_.get(n);
    }
    
    public ByteString getPathsBytes(final int n) {
        return this.paths_.getByteString(n);
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
        for (int i = 0; i < this.paths_.size(); ++i) {
            codedOutputStream.writeBytes(1, this.paths_.getByteString(i));
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        final int n = 0;
        int n2 = 0;
        for (int i = 0; i < this.paths_.size(); ++i) {
            n2 += CodedOutputStream.computeBytesSizeNoTag(this.paths_.getByteString(i));
        }
        return this.memoizedSerializedSize = n + n2 + 1 * this.getPathsList().size();
    }
    
    public static FieldMask parseFrom(final ByteString byteString) {
        return (FieldMask)FieldMask.PARSER.parseFrom(byteString);
    }
    
    public static FieldMask parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)FieldMask.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static FieldMask parseFrom(final byte[] array) {
        return (FieldMask)FieldMask.PARSER.parseFrom(array);
    }
    
    public static FieldMask parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)FieldMask.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static FieldMask parseFrom(final InputStream inputStream) {
        return (FieldMask)FieldMask.PARSER.parseFrom(inputStream);
    }
    
    public static FieldMask parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)FieldMask.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static FieldMask parseDelimitedFrom(final InputStream inputStream) {
        return (FieldMask)FieldMask.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static FieldMask parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)FieldMask.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static FieldMask parseFrom(final CodedInputStream codedInputStream) {
        return (FieldMask)FieldMask.PARSER.parseFrom(codedInputStream);
    }
    
    public static FieldMask parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (FieldMask)FieldMask.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public FieldMask$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static FieldMask$Builder newBuilder() {
        return FieldMask.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static FieldMask$Builder newBuilder(final FieldMask fieldMask) {
        return FieldMask.DEFAULT_INSTANCE.toBuilder().mergeFrom(fieldMask);
    }
    
    public FieldMask$Builder toBuilder() {
        return (this == FieldMask.DEFAULT_INSTANCE) ? new FieldMask$Builder((FieldMask$1)null) : new FieldMask$Builder((FieldMask$1)null).mergeFrom(this);
    }
    
    protected FieldMask$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new FieldMask$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static FieldMask getDefaultInstance() {
        return FieldMask.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return FieldMask.PARSER;
    }
    
    public FieldMask getDefaultInstanceForType() {
        return FieldMask.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new FieldMask();
        PARSER = new FieldMask$1();
    }
}
