/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo
extends GeneratedMessage
implements DescriptorProtos$SourceCodeInfoOrBuilder {
    public static final int LOCATION_FIELD_NUMBER = 1;
    private List location_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$SourceCodeInfo DEFAULT_INSTANCE = new DescriptorProtos$SourceCodeInfo();
    public static final Parser PARSER = new DescriptorProtos$SourceCodeInfo$1();

    private DescriptorProtos$SourceCodeInfo(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$SourceCodeInfo() {
        this.location_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$SourceCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block12 : {
                try {
                    boolean bl3 = false;
                    block9 : while (!bl3) {
                        int n2 = codedInputStream.readTag();
                        switch (n2) {
                            case 0: {
                                bl3 = true;
                                continue block9;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block9;
                                bl3 = true;
                                continue block9;
                            }
                            case 10: 
                        }
                        if (!(bl2 & true)) {
                            this.location_ = new ArrayList();
                            bl2 |= true;
                        }
                        this.location_.add(codedInputStream.readMessage(DescriptorProtos$SourceCodeInfo$Location.PARSER, extensionRegistryLite));
                    }
                    Object var8_9 = null;
                    if (!(bl2 & true)) break block12;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.location_ = Collections.unmodifiableList(this.location_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if (bl2 & true) {
                this.location_ = Collections.unmodifiableList(this.location_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$23600();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$23700().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
    }

    @Override
    public List getLocationList() {
        return this.location_;
    }

    @Override
    public List getLocationOrBuilderList() {
        return this.location_;
    }

    @Override
    public int getLocationCount() {
        return this.location_.size();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location getLocation(int n2) {
        return (DescriptorProtos$SourceCodeInfo$Location)this.location_.get(n2);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int n2) {
        return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.location_.get(n2);
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
        int n2 = 0;
        do {
            if (n2 >= this.location_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(1, (MessageLite)this.location_.get(n2));
            ++n2;
        } while (true);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        int n3 = 0;
        do {
            if (n3 >= this.location_.size()) {
                this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.location_.get(n3));
            ++n3;
        } while (true);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteString byteString) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] arrby) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Builder newBuilderForType() {
        return DescriptorProtos$SourceCodeInfo.newBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo$Builder newBuilder(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$SourceCodeInfo);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Builder toBuilder() {
        DescriptorProtos$SourceCodeInfo$Builder descriptorProtos$SourceCodeInfo$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$SourceCodeInfo$Builder = new DescriptorProtos$SourceCodeInfo$Builder(null);
            return descriptorProtos$SourceCodeInfo$Builder;
        }
        descriptorProtos$SourceCodeInfo$Builder = new DescriptorProtos$SourceCodeInfo$Builder(null).mergeFrom(this);
        return descriptorProtos$SourceCodeInfo$Builder;
    }

    @Override
    protected DescriptorProtos$SourceCodeInfo$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$SourceCodeInfo$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$SourceCodeInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ List access$25302(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo, List list) {
        descriptorProtos$SourceCodeInfo.location_ = list;
        return descriptorProtos$SourceCodeInfo.location_;
    }

    static /* synthetic */ List access$25300(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        return descriptorProtos$SourceCodeInfo.location_;
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

