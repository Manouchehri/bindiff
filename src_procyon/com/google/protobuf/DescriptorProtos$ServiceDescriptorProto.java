package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$ServiceDescriptorProto extends GeneratedMessage implements DescriptorProtos$ServiceDescriptorProtoOrBuilder
{
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int METHOD_FIELD_NUMBER = 2;
    private List method_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos$ServiceOptions options_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$ServiceDescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$ServiceDescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$ServiceDescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.method_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$ServiceDescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.name_ = bytes;
                        continue;
                    }
                    case 18: {
                        if ((n & 0x2) != 0x2) {
                            this.method_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.method_.add(codedInputStream.readMessage(DescriptorProtos$MethodDescriptorProto.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        DescriptorProtos$ServiceOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x2) == 0x2) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$ServiceOptions)codedInputStream.readMessage(DescriptorProtos$ServiceOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x2;
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
            if ((n & 0x2) == 0x2) {
                this.method_ = Collections.unmodifiableList((List<?>)this.method_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
    }
    
    public boolean hasName() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (String)name_;
        }
        final ByteString byteString = (ByteString)name_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.name_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public List getMethodList() {
        return this.method_;
    }
    
    public List getMethodOrBuilderList() {
        return this.method_;
    }
    
    public int getMethodCount() {
        return this.method_.size();
    }
    
    public DescriptorProtos$MethodDescriptorProto getMethod(final int n) {
        return this.method_.get(n);
    }
    
    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(final int n) {
        return this.method_.get(n);
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public DescriptorProtos$ServiceOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$ServiceOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$ServiceOptions.getDefaultInstance() : this.options_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getMethodCount(); ++i) {
            if (!this.getMethod(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        for (int i = 0; i < this.method_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.method_.get(i));
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeMessage(3, this.getOptions());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        for (int i = 0; i < this.method_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.method_.get(i));
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeMessageSize(3, this.getOptions());
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder() {
        return DescriptorProtos$ServiceDescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder(final DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return DescriptorProtos$ServiceDescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$ServiceDescriptorProto);
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$ServiceDescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$ServiceDescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$ServiceDescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$ServiceDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$ServiceDescriptorProto getDefaultInstance() {
        return DescriptorProtos$ServiceDescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$ServiceDescriptorProto.PARSER;
    }
    
    public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$ServiceDescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$ServiceDescriptorProto();
        PARSER = new DescriptorProtos$ServiceDescriptorProto$1();
    }
}
