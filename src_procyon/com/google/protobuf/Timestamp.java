package com.google.protobuf;

import java.io.*;

public final class Timestamp extends GeneratedMessage implements TimestampOrBuilder
{
    public static final int SECONDS_FIELD_NUMBER = 1;
    private long seconds_;
    public static final int NANOS_FIELD_NUMBER = 2;
    private int nanos_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Timestamp DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Timestamp(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Timestamp() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.seconds_ = 0L;
        this.nanos_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Timestamp(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 8: {
                        this.seconds_ = codedInputStream.readInt64();
                        continue;
                    }
                    case 16: {
                        this.nanos_ = codedInputStream.readInt32();
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
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
    }
    
    public long getSeconds() {
        return this.seconds_;
    }
    
    public int getNanos() {
        return this.nanos_;
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
        if (this.seconds_ != 0L) {
            codedOutputStream.writeInt64(1, this.seconds_);
        }
        if (this.nanos_ != 0) {
            codedOutputStream.writeInt32(2, this.nanos_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.seconds_ != 0L) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt64Size(1, this.seconds_);
        }
        if (this.nanos_ != 0) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt32Size(2, this.nanos_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Timestamp)) {
            return super.equals(o);
        }
        final Timestamp timestamp = (Timestamp)o;
        return true && this.getSeconds() == timestamp.getSeconds() && this.getNanos() == timestamp.getNanos();
    }
    
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        return this.memoizedHashCode = 29 * (53 * (37 * (53 * (37 * (19 * 41 + this.getDescriptorForType().hashCode()) + 1) + Internal.hashLong(this.getSeconds())) + 2) + this.getNanos()) + this.unknownFields.hashCode();
    }
    
    public static Timestamp parseFrom(final ByteString byteString) {
        return (Timestamp)Timestamp.PARSER.parseFrom(byteString);
    }
    
    public static Timestamp parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)Timestamp.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Timestamp parseFrom(final byte[] array) {
        return (Timestamp)Timestamp.PARSER.parseFrom(array);
    }
    
    public static Timestamp parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)Timestamp.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Timestamp parseFrom(final InputStream inputStream) {
        return (Timestamp)Timestamp.PARSER.parseFrom(inputStream);
    }
    
    public static Timestamp parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)Timestamp.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Timestamp parseDelimitedFrom(final InputStream inputStream) {
        return (Timestamp)Timestamp.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Timestamp parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)Timestamp.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Timestamp parseFrom(final CodedInputStream codedInputStream) {
        return (Timestamp)Timestamp.PARSER.parseFrom(codedInputStream);
    }
    
    public static Timestamp parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)Timestamp.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Timestamp$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Timestamp$Builder newBuilder() {
        return Timestamp.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Timestamp$Builder newBuilder(final Timestamp timestamp) {
        return Timestamp.DEFAULT_INSTANCE.toBuilder().mergeFrom(timestamp);
    }
    
    public Timestamp$Builder toBuilder() {
        return (this == Timestamp.DEFAULT_INSTANCE) ? new Timestamp$Builder((Timestamp$1)null) : new Timestamp$Builder((Timestamp$1)null).mergeFrom(this);
    }
    
    protected Timestamp$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Timestamp$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Timestamp getDefaultInstance() {
        return Timestamp.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Timestamp.PARSER;
    }
    
    public Timestamp getDefaultInstanceForType() {
        return Timestamp.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Timestamp();
        PARSER = new Timestamp$1();
    }
}
