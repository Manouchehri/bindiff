/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
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

public final class DescriptorProtos$UninterpretedOption
extends GeneratedMessage
implements DescriptorProtos$UninterpretedOptionOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 2;
    private List name_;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    private volatile Object identifierValue_;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    private long positiveIntValue_;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    private long negativeIntValue_;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    private double doubleValue_;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private ByteString stringValue_;
    public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
    private volatile Object aggregateValue_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$UninterpretedOption DEFAULT_INSTANCE = new DescriptorProtos$UninterpretedOption();
    public static final Parser PARSER = new DescriptorProtos$UninterpretedOption$1();

    private DescriptorProtos$UninterpretedOption(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$UninterpretedOption() {
        this.name_ = Collections.emptyList();
        this.identifierValue_ = "";
        this.positiveIntValue_ = 0;
        this.negativeIntValue_ = 0;
        this.doubleValue_ = 0.0;
        this.stringValue_ = ByteString.EMPTY;
        this.aggregateValue_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$UninterpretedOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block18 : {
                try {
                    boolean bl3 = false;
                    block15 : while (!bl3) {
                        ByteString byteString;
                        int n2 = codedInputStream.readTag();
                        switch (n2) {
                            case 0: {
                                bl3 = true;
                                continue block15;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block15;
                                bl3 = true;
                                continue block15;
                            }
                            case 18: {
                                if (!(bl2 & true)) {
                                    this.name_ = new ArrayList();
                                    bl2 |= true;
                                }
                                this.name_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption$NamePart.PARSER, extensionRegistryLite));
                                continue block15;
                            }
                            case 26: {
                                byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.identifierValue_ = byteString;
                                continue block15;
                            }
                            case 32: {
                                this.bitField0_ |= 2;
                                this.positiveIntValue_ = codedInputStream.readUInt64();
                                continue block15;
                            }
                            case 40: {
                                this.bitField0_ |= 4;
                                this.negativeIntValue_ = codedInputStream.readInt64();
                                continue block15;
                            }
                            case 49: {
                                this.bitField0_ |= 8;
                                this.doubleValue_ = codedInputStream.readDouble();
                                continue block15;
                            }
                            case 58: {
                                this.bitField0_ |= 16;
                                this.stringValue_ = codedInputStream.readBytes();
                                continue block15;
                            }
                            case 66: 
                        }
                        byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 32;
                        this.aggregateValue_ = byteString;
                    }
                    Object var9_10 = null;
                    if (!(bl2 & true)) break block18;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.name_ = Collections.unmodifiableList(this.name_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var8_12) {
            Object var9_11 = null;
            if (bl2 & true) {
                this.name_ = Collections.unmodifiableList(this.name_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var8_12;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$21300();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$21400().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
    }

    @Override
    public List getNameList() {
        return this.name_;
    }

    @Override
    public List getNameOrBuilderList() {
        return this.name_;
    }

    @Override
    public int getNameCount() {
        return this.name_.size();
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart getName(int n2) {
        return (DescriptorProtos$UninterpretedOption$NamePart)this.name_.get(n2);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.name_.get(n2);
    }

    @Override
    public boolean hasIdentifierValue() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getIdentifierValue() {
        Object object = this.identifierValue_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.identifierValue_ = string;
        return string;
    }

    @Override
    public ByteString getIdentifierValueBytes() {
        ByteString byteString;
        Object object = this.identifierValue_;
        if (!(object instanceof String)) return (ByteString)object;
        this.identifierValue_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasPositiveIntValue() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }

    @Override
    public boolean hasNegativeIntValue() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }

    @Override
    public boolean hasDoubleValue() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public double getDoubleValue() {
        return this.doubleValue_;
    }

    @Override
    public boolean hasStringValue() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public ByteString getStringValue() {
        return this.stringValue_;
    }

    @Override
    public boolean hasAggregateValue() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public String getAggregateValue() {
        Object object = this.aggregateValue_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.aggregateValue_ = string;
        return string;
    }

    @Override
    public ByteString getAggregateValueBytes() {
        ByteString byteString;
        Object object = this.aggregateValue_;
        if (!(object instanceof String)) return (ByteString)object;
        this.aggregateValue_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
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
            if (n2 >= this.getNameCount()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            if (!this.getName(n2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i2 = 0; i2 < this.name_.size(); ++i2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.name_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(3, this.getIdentifierValueBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeUInt64(4, this.positiveIntValue_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt64(5, this.negativeIntValue_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeDouble(6, this.doubleValue_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(7, this.stringValue_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBytes(8, this.getAggregateValueBytes());
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
        for (int i2 = 0; i2 < this.name_.size(); n2 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.name_.get((int)i2))), ++i2) {
        }
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(3, this.getIdentifierValueBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBytesSize(7, this.stringValue_);
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeBytesSize(8, this.getAggregateValueBytes());
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(ByteString byteString) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(byte[] arrby) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$UninterpretedOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$UninterpretedOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$UninterpretedOption)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$Builder newBuilderForType() {
        return DescriptorProtos$UninterpretedOption.newBuilder();
    }

    public static DescriptorProtos$UninterpretedOption$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$UninterpretedOption$Builder newBuilder(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$UninterpretedOption);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$Builder toBuilder() {
        DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$UninterpretedOption$Builder = new DescriptorProtos$UninterpretedOption$Builder(null);
            return descriptorProtos$UninterpretedOption$Builder;
        }
        descriptorProtos$UninterpretedOption$Builder = new DescriptorProtos$UninterpretedOption$Builder(null).mergeFrom(this);
        return descriptorProtos$UninterpretedOption$Builder;
    }

    @Override
    protected DescriptorProtos$UninterpretedOption$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$UninterpretedOption$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$UninterpretedOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ List access$22702(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, List list) {
        descriptorProtos$UninterpretedOption.name_ = list;
        return descriptorProtos$UninterpretedOption.name_;
    }

    static /* synthetic */ Object access$22802(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, Object object) {
        descriptorProtos$UninterpretedOption.identifierValue_ = object;
        return descriptorProtos$UninterpretedOption.identifierValue_;
    }

    static /* synthetic */ long access$22902(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, long l2) {
        descriptorProtos$UninterpretedOption.positiveIntValue_ = l2;
        return descriptorProtos$UninterpretedOption.positiveIntValue_;
    }

    static /* synthetic */ long access$23002(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, long l2) {
        descriptorProtos$UninterpretedOption.negativeIntValue_ = l2;
        return descriptorProtos$UninterpretedOption.negativeIntValue_;
    }

    static /* synthetic */ double access$23102(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, double d2) {
        descriptorProtos$UninterpretedOption.doubleValue_ = d2;
        return descriptorProtos$UninterpretedOption.doubleValue_;
    }

    static /* synthetic */ ByteString access$23202(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, ByteString byteString) {
        descriptorProtos$UninterpretedOption.stringValue_ = byteString;
        return descriptorProtos$UninterpretedOption.stringValue_;
    }

    static /* synthetic */ Object access$23302(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, Object object) {
        descriptorProtos$UninterpretedOption.aggregateValue_ = object;
        return descriptorProtos$UninterpretedOption.aggregateValue_;
    }

    static /* synthetic */ int access$23402(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption, int n2) {
        descriptorProtos$UninterpretedOption.bitField0_ = n2;
        return descriptorProtos$UninterpretedOption.bitField0_;
    }

    static /* synthetic */ List access$22700(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return descriptorProtos$UninterpretedOption.name_;
    }

    static /* synthetic */ Object access$22800(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return descriptorProtos$UninterpretedOption.identifierValue_;
    }

    static /* synthetic */ Object access$23300(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        return descriptorProtos$UninterpretedOption.aggregateValue_;
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

