/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSetOrBuilder;
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

public final class DescriptorProtos$FileDescriptorSet
extends GeneratedMessage
implements DescriptorProtos$FileDescriptorSetOrBuilder {
    public static final int FILE_FIELD_NUMBER = 1;
    private List file_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$FileDescriptorSet DEFAULT_INSTANCE = new DescriptorProtos$FileDescriptorSet();
    public static final Parser PARSER = new DescriptorProtos$FileDescriptorSet$1();

    private DescriptorProtos$FileDescriptorSet(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$FileDescriptorSet() {
        this.file_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$FileDescriptorSet(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
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
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block10;
                        bl3 = true;
                        continue block10;
                    }
                    case 10: 
                }
                if (!(bl2 & true)) {
                    this.file_ = new ArrayList();
                    bl2 |= true;
                }
                this.file_.add(codedInputStream.readMessage(DescriptorProtos$FileDescriptorProto.PARSER, extensionRegistryLite));
            }
            return;
        }
        catch (InvalidProtocolBufferException var5_6) {
            throw new RuntimeException(var5_6.setUnfinishedMessage(this));
        }
        catch (IOException var5_7) {
            throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            if (bl2 & true) {
                this.file_ = Collections.unmodifiableList(this.file_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
    }

    @Override
    public List getFileList() {
        return this.file_;
    }

    @Override
    public List getFileOrBuilderList() {
        return this.file_;
    }

    @Override
    public int getFileCount() {
        return this.file_.size();
    }

    @Override
    public DescriptorProtos$FileDescriptorProto getFile(int n2) {
        return (DescriptorProtos$FileDescriptorProto)this.file_.get(n2);
    }

    @Override
    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int n2) {
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.file_.get(n2);
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
        int n2 = 0;
        do {
            if (n2 >= this.getFileCount()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            if (!this.getFile(n2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        int n2 = 0;
        do {
            if (n2 >= this.file_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(1, (MessageLite)this.file_.get(n2));
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
            if (n3 >= this.file_.size()) {
                this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.file_.get(n3));
            ++n3;
        } while (true);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(ByteString byteString) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(byte[] arrby) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$FileDescriptorSet$Builder newBuilderForType() {
        return DescriptorProtos$FileDescriptorSet.newBuilder();
    }

    public static DescriptorProtos$FileDescriptorSet$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FileDescriptorSet$Builder newBuilder(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileDescriptorSet);
    }

    @Override
    public DescriptorProtos$FileDescriptorSet$Builder toBuilder() {
        DescriptorProtos$FileDescriptorSet$Builder descriptorProtos$FileDescriptorSet$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$FileDescriptorSet$Builder = new DescriptorProtos$FileDescriptorSet$Builder(null);
            return descriptorProtos$FileDescriptorSet$Builder;
        }
        descriptorProtos$FileDescriptorSet$Builder = new DescriptorProtos$FileDescriptorSet$Builder(null).mergeFrom(this);
        return descriptorProtos$FileDescriptorSet$Builder;
    }

    @Override
    protected DescriptorProtos$FileDescriptorSet$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FileDescriptorSet$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$FileDescriptorSet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$FileDescriptorSet(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ List access$502(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet, List list) {
        descriptorProtos$FileDescriptorSet.file_ = list;
        return descriptorProtos$FileDescriptorSet.file_;
    }

    static /* synthetic */ List access$500(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet) {
        return descriptorProtos$FileDescriptorSet.file_;
    }

    /* synthetic */ DescriptorProtos$FileDescriptorSet(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

