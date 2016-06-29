/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Duration$1;
import com.google.protobuf.Duration$Builder;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Duration
extends GeneratedMessage
implements DurationOrBuilder {
    public static final int SECONDS_FIELD_NUMBER = 1;
    private long seconds_;
    public static final int NANOS_FIELD_NUMBER = 2;
    private int nanos_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Duration DEFAULT_INSTANCE = new Duration();
    public static final Parser PARSER = new Duration$1();

    private Duration(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Duration() {
        this.seconds_ = 0;
        this.nanos_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Duration(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block10 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block10;
                        }
                        default: {
                            if (codedInputStream.skipField(n2)) continue block10;
                            bl3 = true;
                            continue block10;
                        }
                        case 8: {
                            this.seconds_ = codedInputStream.readInt64();
                            continue block10;
                        }
                        case 16: 
                    }
                    this.nanos_ = codedInputStream.readInt32();
                }
                Object var7_8 = null;
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
        catch (Throwable var6_10) {
            Object var7_9 = null;
            this.makeExtensionsImmutable();
            throw var6_10;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
    }

    @Override
    public long getSeconds() {
        return this.seconds_;
    }

    @Override
    public int getNanos() {
        return this.nanos_;
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
        if (this.seconds_ != 0) {
            codedOutputStream.writeInt64(1, this.seconds_);
        }
        if (this.nanos_ == 0) return;
        codedOutputStream.writeInt32(2, this.nanos_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.seconds_ != 0) {
            n2 += CodedOutputStream.computeInt64Size(1, this.seconds_);
        }
        if (this.nanos_ != 0) {
            n2 += CodedOutputStream.computeInt32Size(2, this.nanos_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Duration)) {
            return super.equals(object);
        }
        Duration duration = (Duration)object;
        boolean bl2 = true;
        if (!bl2) return false;
        if (this.getSeconds() != duration.getSeconds()) return false;
        boolean bl3 = true;
        bl2 = bl3;
        if (!bl2) return false;
        if (this.getNanos() != duration.getNanos()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n2 = 41;
        n2 = 19 * n2 + this.getDescriptorForType().hashCode();
        n2 = 37 * n2 + 1;
        n2 = 53 * n2 + Internal.hashLong(this.getSeconds());
        n2 = 37 * n2 + 2;
        n2 = 53 * n2 + this.getNanos();
        this.memoizedHashCode = n2 = 29 * n2 + this.unknownFields.hashCode();
        return n2;
    }

    public static Duration parseFrom(ByteString byteString) {
        return (Duration)PARSER.parseFrom(byteString);
    }

    public static Duration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Duration parseFrom(byte[] arrby) {
        return (Duration)PARSER.parseFrom(arrby);
    }

    public static Duration parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Duration parseFrom(InputStream inputStream) {
        return (Duration)PARSER.parseFrom(inputStream);
    }

    public static Duration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Duration parseDelimitedFrom(InputStream inputStream) {
        return (Duration)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Duration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Duration parseFrom(CodedInputStream codedInputStream) {
        return (Duration)PARSER.parseFrom(codedInputStream);
    }

    public static Duration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Duration)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Duration$Builder newBuilderForType() {
        return Duration.newBuilder();
    }

    public static Duration$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Duration$Builder newBuilder(Duration duration) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(duration);
    }

    @Override
    public Duration$Builder toBuilder() {
        Duration$Builder duration$Builder;
        if (this == DEFAULT_INSTANCE) {
            duration$Builder = new Duration$Builder(null);
            return duration$Builder;
        }
        duration$Builder = new Duration$Builder(null).mergeFrom(this);
        return duration$Builder;
    }

    @Override
    protected Duration$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Duration$Builder(generatedMessage$BuilderParent, null);
    }

    public static Duration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Duration getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Duration(GeneratedMessage$Builder generatedMessage$Builder, Duration$1 duration$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$302(Duration duration, long l2) {
        duration.seconds_ = l2;
        return duration.seconds_;
    }

    static /* synthetic */ int access$402(Duration duration, int n2) {
        duration.nanos_ = n2;
        return duration.nanos_;
    }

    /* synthetic */ Duration(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Duration$1 duration$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

