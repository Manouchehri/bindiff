/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MessageOptions$1;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
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

public final class DescriptorProtos$MessageOptions
extends GeneratedMessage$ExtendableMessage
implements DescriptorProtos$MessageOptionsOrBuilder {
    private int bitField0_;
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    private boolean messageSetWireFormat_;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    private boolean noStandardDescriptorAccessor_;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    private boolean deprecated_;
    public static final int MAP_ENTRY_FIELD_NUMBER = 7;
    private boolean mapEntry_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$MessageOptions DEFAULT_INSTANCE = new DescriptorProtos$MessageOptions();
    public static final Parser PARSER = new DescriptorProtos$MessageOptions$1();

    private DescriptorProtos$MessageOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
    }

    private DescriptorProtos$MessageOptions() {
        this.messageSetWireFormat_ = false;
        this.noStandardDescriptorAccessor_ = false;
        this.deprecated_ = false;
        this.mapEntry_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$MessageOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block16 : {
                try {
                    boolean bl2 = false;
                    block13 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block13;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block13;
                                bl2 = true;
                                continue block13;
                            }
                            case 8: {
                                this.bitField0_ |= 1;
                                this.messageSetWireFormat_ = codedInputStream.readBool();
                                continue block13;
                            }
                            case 16: {
                                this.bitField0_ |= 2;
                                this.noStandardDescriptorAccessor_ = codedInputStream.readBool();
                                continue block13;
                            }
                            case 24: {
                                this.bitField0_ |= 4;
                                this.deprecated_ = codedInputStream.readBool();
                                continue block13;
                            }
                            case 56: {
                                this.bitField0_ |= 8;
                                this.mapEntry_ = codedInputStream.readBool();
                                continue block13;
                            }
                            case 7994: 
                        }
                        if ((n2 & 16) != 16) {
                            this.uninterpretedOption_ = new ArrayList();
                            n2 |= 16;
                        }
                        this.uninterpretedOption_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption.PARSER, extensionRegistryLite));
                    }
                    Object var8_9 = null;
                    if ((n2 & 16) != 16) break block16;
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
            if ((n2 & 16) == 16) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$15000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$15100().ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
    }

    @Override
    public boolean hasMessageSetWireFormat() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }

    @Override
    public boolean hasNoStandardDescriptorAccessor() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override
    public boolean hasMapEntry() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getMapEntry() {
        return this.mapEntry_;
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
            codedOutputStream.writeBool(1, this.messageSetWireFormat_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBool(2, this.noStandardDescriptorAccessor_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBool(3, this.deprecated_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBool(7, this.mapEntry_);
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
            n2 += CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeBoolSize(7, this.mapEntry_);
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

    public static DescriptorProtos$MessageOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$MessageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(byte[] arrby) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$MessageOptions parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$MessageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$MessageOptions)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$MessageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MessageOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$MessageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MessageOptions)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$MessageOptions$Builder newBuilderForType() {
        return DescriptorProtos$MessageOptions.newBuilder();
    }

    public static DescriptorProtos$MessageOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$MessageOptions$Builder newBuilder(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MessageOptions);
    }

    @Override
    public DescriptorProtos$MessageOptions$Builder toBuilder() {
        DescriptorProtos$MessageOptions$Builder descriptorProtos$MessageOptions$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$MessageOptions$Builder = new DescriptorProtos$MessageOptions$Builder(null);
            return descriptorProtos$MessageOptions$Builder;
        }
        descriptorProtos$MessageOptions$Builder = new DescriptorProtos$MessageOptions$Builder(null).mergeFrom(this);
        return descriptorProtos$MessageOptions$Builder;
    }

    @Override
    protected DescriptorProtos$MessageOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$MessageOptions$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$MessageOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$MessageOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$ExtendableBuilder);
    }

    static /* synthetic */ boolean access$15502(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.messageSetWireFormat_ = bl2;
        return descriptorProtos$MessageOptions.messageSetWireFormat_;
    }

    static /* synthetic */ boolean access$15602(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.noStandardDescriptorAccessor_ = bl2;
        return descriptorProtos$MessageOptions.noStandardDescriptorAccessor_;
    }

    static /* synthetic */ boolean access$15702(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.deprecated_ = bl2;
        return descriptorProtos$MessageOptions.deprecated_;
    }

    static /* synthetic */ boolean access$15802(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, boolean bl2) {
        descriptorProtos$MessageOptions.mapEntry_ = bl2;
        return descriptorProtos$MessageOptions.mapEntry_;
    }

    static /* synthetic */ List access$15902(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, List list) {
        descriptorProtos$MessageOptions.uninterpretedOption_ = list;
        return descriptorProtos$MessageOptions.uninterpretedOption_;
    }

    static /* synthetic */ int access$16002(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions, int n2) {
        descriptorProtos$MessageOptions.bitField0_ = n2;
        return descriptorProtos$MessageOptions.bitField0_;
    }

    static /* synthetic */ List access$15900(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        return descriptorProtos$MessageOptions.uninterpretedOption_;
    }

    /* synthetic */ DescriptorProtos$MessageOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

