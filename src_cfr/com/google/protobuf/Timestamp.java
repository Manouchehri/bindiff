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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp$1;
import com.google.protobuf.Timestamp$Builder;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.TimestampProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Timestamp
extends GeneratedMessage
implements TimestampOrBuilder {
    public static final int SECONDS_FIELD_NUMBER = 1;
    private long seconds_;
    public static final int NANOS_FIELD_NUMBER = 2;
    private int nanos_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Timestamp DEFAULT_INSTANCE = new Timestamp();
    public static final Parser PARSER = new Timestamp$1();

    private Timestamp(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Timestamp() {
        this.seconds_ = 0;
        this.nanos_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Timestamp(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
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
        if (!(object instanceof Timestamp)) {
            return super.equals(object);
        }
        Timestamp timestamp = (Timestamp)object;
        boolean bl2 = true;
        if (!bl2) return false;
        if (this.getSeconds() != timestamp.getSeconds()) return false;
        boolean bl3 = true;
        bl2 = bl3;
        if (!bl2) return false;
        if (this.getNanos() != timestamp.getNanos()) return false;
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

    public static Timestamp parseFrom(ByteString byteString) {
        return (Timestamp)PARSER.parseFrom(byteString);
    }

    public static Timestamp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Timestamp parseFrom(byte[] arrby) {
        return (Timestamp)PARSER.parseFrom(arrby);
    }

    public static Timestamp parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Timestamp parseFrom(InputStream inputStream) {
        return (Timestamp)PARSER.parseFrom(inputStream);
    }

    public static Timestamp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream) {
        return (Timestamp)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream) {
        return (Timestamp)PARSER.parseFrom(codedInputStream);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Timestamp$Builder newBuilderForType() {
        return Timestamp.newBuilder();
    }

    public static Timestamp$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Timestamp$Builder newBuilder(Timestamp timestamp) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(timestamp);
    }

    @Override
    public Timestamp$Builder toBuilder() {
        Timestamp$Builder timestamp$Builder;
        if (this == DEFAULT_INSTANCE) {
            timestamp$Builder = new Timestamp$Builder(null);
            return timestamp$Builder;
        }
        timestamp$Builder = new Timestamp$Builder(null).mergeFrom(this);
        return timestamp$Builder;
    }

    @Override
    protected Timestamp$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Timestamp$Builder(generatedMessage$BuilderParent, null);
    }

    public static Timestamp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Timestamp getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Timestamp(GeneratedMessage$Builder generatedMessage$Builder, Timestamp$1 timestamp$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$302(Timestamp timestamp, long l2) {
        timestamp.seconds_ = l2;
        return timestamp.seconds_;
    }

    static /* synthetic */ int access$402(Timestamp timestamp, int n2) {
        timestamp.nanos_ = n2;
        return timestamp.nanos_;
    }

    /* synthetic */ Timestamp(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Timestamp$1 timestamp$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

