package com.google.protobuf;

import java.io.*;

public final class Duration extends GeneratedMessage implements DurationOrBuilder
{
    public static final int SECONDS_FIELD_NUMBER = 1;
    private long seconds_;
    public static final int NANOS_FIELD_NUMBER = 2;
    private int nanos_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Duration DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Duration(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Duration() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.seconds_ = 0L;
        this.nanos_ = 0;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Duration(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
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
        if (!(o instanceof Duration)) {
            return super.equals(o);
        }
        final Duration duration = (Duration)o;
        return true && this.getSeconds() == duration.getSeconds() && this.getNanos() == duration.getNanos();
    }
    
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        return this.memoizedHashCode = 29 * (53 * (37 * (53 * (37 * (19 * 41 + this.getDescriptorForType().hashCode()) + 1) + Internal.hashLong(this.getSeconds())) + 2) + this.getNanos()) + this.unknownFields.hashCode();
    }
    
    public static Duration parseFrom(final ByteString byteString) {
        return (Duration)Duration.PARSER.parseFrom(byteString);
    }
    
    public static Duration parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)Duration.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Duration parseFrom(final byte[] array) {
        return (Duration)Duration.PARSER.parseFrom(array);
    }
    
    public static Duration parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)Duration.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Duration parseFrom(final InputStream inputStream) {
        return (Duration)Duration.PARSER.parseFrom(inputStream);
    }
    
    public static Duration parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)Duration.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Duration parseDelimitedFrom(final InputStream inputStream) {
        return (Duration)Duration.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Duration parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)Duration.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Duration parseFrom(final CodedInputStream codedInputStream) {
        return (Duration)Duration.PARSER.parseFrom(codedInputStream);
    }
    
    public static Duration parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)Duration.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Duration$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Duration$Builder newBuilder() {
        return Duration.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Duration$Builder newBuilder(final Duration duration) {
        return Duration.DEFAULT_INSTANCE.toBuilder().mergeFrom(duration);
    }
    
    public Duration$Builder toBuilder() {
        return (this == Duration.DEFAULT_INSTANCE) ? new Duration$Builder((Duration$1)null) : new Duration$Builder((Duration$1)null).mergeFrom(this);
    }
    
    protected Duration$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Duration$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Duration getDefaultInstance() {
        return Duration.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Duration.PARSER;
    }
    
    public Duration getDefaultInstanceForType() {
        return Duration.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Duration();
        PARSER = new Duration$1();
    }
}
