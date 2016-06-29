/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$EnumDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private List value_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos$EnumOptions options_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$EnumDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$EnumDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$EnumDescriptorProto$1();

    private DescriptorProtos$EnumDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$EnumDescriptorProto() {
        this.name_ = "";
        this.value_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$EnumDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.value_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.value_.add(codedInputStream.readMessage(DescriptorProtos$EnumValueDescriptorProto.PARSER, extensionRegistryLite));
                                continue block11;
                            }
                            case 26: 
                        }
                        object = null;
                        if ((this.bitField0_ & 2) == 2) {
                            object = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$EnumOptions)codedInputStream.readMessage(DescriptorProtos$EnumOptions.PARSER, extensionRegistryLite);
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
                this.value_ = Collections.unmodifiableList(this.value_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var8_12) {
            Object var9_11 = null;
            if ((n2 & 2) == 2) {
                this.value_ = Collections.unmodifiableList(this.value_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var8_12;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$8500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$8600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
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
    public List getValueList() {
        return this.value_;
    }

    @Override
    public List getValueOrBuilderList() {
        return this.value_;
    }

    @Override
    public int getValueCount() {
        return this.value_.size();
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto getValue(int n2) {
        return (DescriptorProtos$EnumValueDescriptorProto)this.value_.get(n2);
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int n2) {
        return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.value_.get(n2);
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public DescriptorProtos$EnumOptions getOptions() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
        if (this.options_ == null) {
            descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.getDefaultInstance();
            return descriptorProtos$EnumOptions;
        }
        descriptorProtos$EnumOptions = this.options_;
        return descriptorProtos$EnumOptions;
    }

    @Override
    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
        if (this.options_ == null) {
            descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.getDefaultInstance();
            return descriptorProtos$EnumOptions;
        }
        descriptorProtos$EnumOptions = this.options_;
        return descriptorProtos$EnumOptions;
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
        for (int i2 = 0; i2 < this.getValueCount(); ++i2) {
            if (this.getValue(i2).isInitialized()) continue;
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
        for (int i2 = 0; i2 < this.value_.size(); ++i2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.value_.get(i2));
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
        for (int i2 = 0; i2 < this.value_.size(); n2 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.value_.get((int)i2))), ++i2) {
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeMessageSize(3, this.getOptions());
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$EnumDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumDescriptorProto$Builder newBuilder(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumDescriptorProto);
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto$Builder toBuilder() {
        DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$EnumDescriptorProto$Builder = new DescriptorProtos$EnumDescriptorProto$Builder(null);
            return descriptorProtos$EnumDescriptorProto$Builder;
        }
        descriptorProtos$EnumDescriptorProto$Builder = new DescriptorProtos$EnumDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$EnumDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$EnumDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$EnumDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$EnumDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$EnumDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$9002(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, Object object) {
        descriptorProtos$EnumDescriptorProto.name_ = object;
        return descriptorProtos$EnumDescriptorProto.name_;
    }

    static /* synthetic */ List access$9102(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, List list) {
        descriptorProtos$EnumDescriptorProto.value_ = list;
        return descriptorProtos$EnumDescriptorProto.value_;
    }

    static /* synthetic */ DescriptorProtos$EnumOptions access$9202(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        descriptorProtos$EnumDescriptorProto.options_ = descriptorProtos$EnumOptions;
        return descriptorProtos$EnumDescriptorProto.options_;
    }

    static /* synthetic */ int access$9302(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, int n2) {
        descriptorProtos$EnumDescriptorProto.bitField0_ = n2;
        return descriptorProtos$EnumDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$9000(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return descriptorProtos$EnumDescriptorProto.name_;
    }

    static /* synthetic */ List access$9100(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return descriptorProtos$EnumDescriptorProto.value_;
    }

    /* synthetic */ DescriptorProtos$EnumDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

