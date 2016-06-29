/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptions$Builder;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
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

public final class DescriptorProtos$ServiceDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int METHOD_FIELD_NUMBER = 2;
    private List method_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos$ServiceOptions options_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$ServiceDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$ServiceDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$ServiceDescriptorProto$1();

    private DescriptorProtos$ServiceDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$ServiceDescriptorProto() {
        this.name_ = "";
        this.method_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$ServiceDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block16 : {
                try {
                    boolean bl2 = false;
                    block11 : while (!bl2) {
                        Object object;
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block11;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block11;
                                bl2 = true;
                                continue block11;
                            }
                            case 10: {
                                object = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.name_ = object;
                                continue block11;
                            }
                            case 18: {
                                if ((n2 & 2) != 2) {
                                    this.method_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.method_.add(codedInputStream.readMessage(DescriptorProtos$MethodDescriptorProto.PARSER, extensionRegistryLite));
                                continue block11;
                            }
                            case 26: 
                        }
                        object = null;
                        if ((this.bitField0_ & 2) == 2) {
                            object = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$ServiceOptions)codedInputStream.readMessage(DescriptorProtos$ServiceOptions.PARSER, extensionRegistryLite);
                        if (object != null) {
                            object.mergeFrom(this.options_);
                            this.options_ = object.buildPartial();
                        }
                        this.bitField0_ |= 2;
                    }
                    Object var9_10 = null;
                    if ((n2 & 2) != 2) break block16;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.method_ = Collections.unmodifiableList(this.method_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var8_12) {
            Object var9_11 = null;
            if ((n2 & 2) == 2) {
                this.method_ = Collections.unmodifiableList(this.method_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var8_12;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$10500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$10600().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
    }

    @Override
    public boolean hasName() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public List getMethodList() {
        return this.method_;
    }

    @Override
    public List getMethodOrBuilderList() {
        return this.method_;
    }

    @Override
    public int getMethodCount() {
        return this.method_.size();
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto getMethod(int n2) {
        return (DescriptorProtos$MethodDescriptorProto)this.method_.get(n2);
    }

    @Override
    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int n2) {
        return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.method_.get(n2);
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public DescriptorProtos$ServiceOptions getOptions() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        if (this.options_ == null) {
            descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.getDefaultInstance();
            return descriptorProtos$ServiceOptions;
        }
        descriptorProtos$ServiceOptions = this.options_;
        return descriptorProtos$ServiceOptions;
    }

    @Override
    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        if (this.options_ == null) {
            descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.getDefaultInstance();
            return descriptorProtos$ServiceOptions;
        }
        descriptorProtos$ServiceOptions = this.options_;
        return descriptorProtos$ServiceOptions;
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
        for (int i2 = 0; i2 < this.getMethodCount(); ++i2) {
            if (this.getMethod(i2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        for (int i2 = 0; i2 < this.method_.size(); ++i2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.method_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(3, this.getOptions());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        for (int i2 = 0; i2 < this.method_.size(); n2 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.method_.get((int)i2))), ++i2) {
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeMessageSize(3, this.getOptions());
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$ServiceDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$ServiceDescriptorProto);
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto$Builder toBuilder() {
        DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$ServiceDescriptorProto$Builder = new DescriptorProtos$ServiceDescriptorProto$Builder(null);
            return descriptorProtos$ServiceDescriptorProto$Builder;
        }
        descriptorProtos$ServiceDescriptorProto$Builder = new DescriptorProtos$ServiceDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$ServiceDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$ServiceDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$ServiceDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$ServiceDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$11002(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, Object object) {
        descriptorProtos$ServiceDescriptorProto.name_ = object;
        return descriptorProtos$ServiceDescriptorProto.name_;
    }

    static /* synthetic */ List access$11102(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, List list) {
        descriptorProtos$ServiceDescriptorProto.method_ = list;
        return descriptorProtos$ServiceDescriptorProto.method_;
    }

    static /* synthetic */ DescriptorProtos$ServiceOptions access$11202(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        descriptorProtos$ServiceDescriptorProto.options_ = descriptorProtos$ServiceOptions;
        return descriptorProtos$ServiceDescriptorProto.options_;
    }

    static /* synthetic */ int access$11302(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, int n2) {
        descriptorProtos$ServiceDescriptorProto.bitField0_ = n2;
        return descriptorProtos$ServiceDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$11000(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return descriptorProtos$ServiceDescriptorProto.name_;
    }

    static /* synthetic */ List access$11100(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return descriptorProtos$ServiceDescriptorProto.method_;
    }

    /* synthetic */ DescriptorProtos$ServiceDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

