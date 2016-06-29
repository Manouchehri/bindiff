package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$SourceCodeInfo extends GeneratedMessage implements DescriptorProtos$SourceCodeInfoOrBuilder
{
    public static final int LOCATION_FIELD_NUMBER = 1;
    private List location_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$SourceCodeInfo DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$SourceCodeInfo(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$SourceCodeInfo() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.location_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$SourceCodeInfo(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                            this.location_ = new ArrayList();
                            n |= 0x1;
                        }
                        this.location_.add(codedInputStream.readMessage(DescriptorProtos$SourceCodeInfo$Location.PARSER, extensionRegistryLite));
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
                this.location_ = Collections.unmodifiableList((List<?>)this.location_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
    }
    
    public List getLocationList() {
        return this.location_;
    }
    
    public List getLocationOrBuilderList() {
        return this.location_;
    }
    
    public int getLocationCount() {
        return this.location_.size();
    }
    
    public DescriptorProtos$SourceCodeInfo$Location getLocation(final int n) {
        return this.location_.get(n);
    }
    
    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(final int n) {
        return this.location_.get(n);
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
        for (int i = 0; i < this.location_.size(); ++i) {
            codedOutputStream.writeMessage(1, (MessageLite)this.location_.get(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        for (int i = 0; i < this.location_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(1, (MessageLite)this.location_.get(i));
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final ByteString byteString) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final byte[] array) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$SourceCodeInfo parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$SourceCodeInfo$Builder newBuilder() {
        return DescriptorProtos$SourceCodeInfo.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$SourceCodeInfo$Builder newBuilder(final DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        return DescriptorProtos$SourceCodeInfo.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$SourceCodeInfo);
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder toBuilder() {
        return (this == DescriptorProtos$SourceCodeInfo.DEFAULT_INSTANCE) ? new DescriptorProtos$SourceCodeInfo$Builder((DescriptorProtos$1)null) : new DescriptorProtos$SourceCodeInfo$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$SourceCodeInfo$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$SourceCodeInfo$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$SourceCodeInfo getDefaultInstance() {
        return DescriptorProtos$SourceCodeInfo.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$SourceCodeInfo.PARSER;
    }
    
    public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$SourceCodeInfo();
        PARSER = new DescriptorProtos$SourceCodeInfo$1();
    }
}
