/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$1;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$ExtendableMessage$ExtensionWriter;
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

public final class DescriptorProtos$EnumValueOptions
extends GeneratedMessage$ExtendableMessage
implements DescriptorProtos$EnumValueOptionsOrBuilder {
    private int bitField0_;
    public static final int DEPRECATED_FIELD_NUMBER = 1;
    private boolean deprecated_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$EnumValueOptions DEFAULT_INSTANCE = new DescriptorProtos$EnumValueOptions();
    public static final Parser PARSER = new DescriptorProtos$EnumValueOptions$1();

    private DescriptorProtos$EnumValueOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
    }

    private DescriptorProtos$EnumValueOptions() {
        this.deprecated_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$EnumValueOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block13 : {
                try {
                    boolean bl2 = false;
                    block10 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block10;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block10;
                                bl2 = true;
                                continue block10;
                            }
                            case 8: {
                                this.bitField0_ |= 1;
                                this.deprecated_ = codedInputStream.readBool();
                                continue block10;
                            }
                            case 7994: 
                        }
                        if ((n2 & 2) != 2) {
                            this.uninterpretedOption_ = new ArrayList();
                            n2 |= 2;
                        }
                        this.uninterpretedOption_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption.PARSER, extensionRegistryLite));
                    }
                    Object var8_9 = null;
                    if ((n2 & 2) != 2) break block13;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if ((n2 & 2) == 2) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$18600();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$18700().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueOptions.class, DescriptorProtos$EnumValueOptions$Builder.class);
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override
    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override
    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    @Override
    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int n2) {
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n2);
    }

    @Override
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n2);
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
        for (int i2 = 0; i2 < this.getUninterpretedOptionCount(); ++i2) {
            if (this.getUninterpretedOption(i2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        GeneratedMessage$ExtendableMessage$ExtensionWriter generatedMessage$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBool(1, this.deprecated_);
        }
        int n2 = 0;
        do {
            if (n2 >= this.uninterpretedOption_.size()) {
                generatedMessage$ExtendableMessage$ExtensionWriter.writeUntil(536870912, codedOutputStream);
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(999, (MessageLite)this.uninterpretedOption_.get(n2));
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
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBoolSize(1, this.deprecated_);
        }
        int n3 = 0;
        do {
            if (n3 >= this.uninterpretedOption_.size()) {
                n2 += this.extensionsSerializedSize();
                this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(n3));
            ++n3;
        } while (true);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(byte[] arrby) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$EnumValueOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$EnumValueOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueOptions)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$EnumValueOptions$Builder newBuilderForType() {
        return DescriptorProtos$EnumValueOptions.newBuilder();
    }

    public static DescriptorProtos$EnumValueOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumValueOptions$Builder newBuilder(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumValueOptions);
    }

    @Override
    public DescriptorProtos$EnumValueOptions$Builder toBuilder() {
        DescriptorProtos$EnumValueOptions$Builder descriptorProtos$EnumValueOptions$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$EnumValueOptions$Builder = new DescriptorProtos$EnumValueOptions$Builder(null);
            return descriptorProtos$EnumValueOptions$Builder;
        }
        descriptorProtos$EnumValueOptions$Builder = new DescriptorProtos$EnumValueOptions$Builder(null).mergeFrom(this);
        return descriptorProtos$EnumValueOptions$Builder;
    }

    @Override
    protected DescriptorProtos$EnumValueOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$EnumValueOptions$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$EnumValueOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$EnumValueOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$EnumValueOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$ExtendableBuilder);
    }

    static /* synthetic */ boolean access$19102(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions, boolean bl2) {
        descriptorProtos$EnumValueOptions.deprecated_ = bl2;
        return descriptorProtos$EnumValueOptions.deprecated_;
    }

    static /* synthetic */ List access$19202(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions, List list) {
        descriptorProtos$EnumValueOptions.uninterpretedOption_ = list;
        return descriptorProtos$EnumValueOptions.uninterpretedOption_;
    }

    static /* synthetic */ int access$19302(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions, int n2) {
        descriptorProtos$EnumValueOptions.bitField0_ = n2;
        return descriptorProtos$EnumValueOptions.bitField0_;
    }

    static /* synthetic */ List access$19200(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        return descriptorProtos$EnumValueOptions.uninterpretedOption_;
    }

    /* synthetic */ DescriptorProtos$EnumValueOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

