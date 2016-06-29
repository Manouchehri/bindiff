package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FileDescriptorSet extends GeneratedMessage implements DescriptorProtos$FileDescriptorSetOrBuilder
{
    public static final int FILE_FIELD_NUMBER = 1;
    private List file_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$FileDescriptorSet DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$FileDescriptorSet(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$FileDescriptorSet() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.file_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$FileDescriptorSet(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
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
                        if (!this.parseUnknownField(codedInputStream, builder, extensionRegistryLite, tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        if ((n & 0x1) != 0x1) {
                            this.file_ = new ArrayList();
                            n |= 0x1;
                        }
                        this.file_.add(codedInputStream.readMessage(DescriptorProtos$FileDescriptorProto.PARSER, extensionRegistryLite));
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
                this.file_ = Collections.unmodifiableList((List<?>)this.file_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
    }
    
    public List getFileList() {
        return this.file_;
    }
    
    public List getFileOrBuilderList() {
        return this.file_;
    }
    
    public int getFileCount() {
        return this.file_.size();
    }
    
    public DescriptorProtos$FileDescriptorProto getFile(final int n) {
        return this.file_.get(n);
    }
    
    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(final int n) {
        return this.file_.get(n);
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getFileCount(); ++i) {
            if (!this.getFile(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.file_.size(); ++i) {
            codedOutputStream.writeMessage(1, (MessageLite)this.file_.get(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        for (int i = 0; i < this.file_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(1, (MessageLite)this.file_.get(i));
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final ByteString byteString) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final byte[] array) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$FileDescriptorSet parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$FileDescriptorSet$Builder newBuilder() {
        return DescriptorProtos$FileDescriptorSet.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$FileDescriptorSet$Builder newBuilder(final DescriptorProtos$FileDescriptorSet set) {
        return DescriptorProtos$FileDescriptorSet.DEFAULT_INSTANCE.toBuilder().mergeFrom(set);
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder toBuilder() {
        return (this == DescriptorProtos$FileDescriptorSet.DEFAULT_INSTANCE) ? new DescriptorProtos$FileDescriptorSet$Builder((DescriptorProtos$1)null) : new DescriptorProtos$FileDescriptorSet$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$FileDescriptorSet$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FileDescriptorSet$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$FileDescriptorSet getDefaultInstance() {
        return DescriptorProtos$FileDescriptorSet.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$FileDescriptorSet.PARSER;
    }
    
    public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorSet.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$FileDescriptorSet();
        PARSER = new DescriptorProtos$FileDescriptorSet$1();
    }
}
