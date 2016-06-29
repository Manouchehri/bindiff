/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldOptions$1;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldOptions
extends GeneratedMessage$ExtendableMessage
implements DescriptorProtos$FieldOptionsOrBuilder {
    private int bitField0_;
    public static final int CTYPE_FIELD_NUMBER = 1;
    private int ctype_;
    public static final int PACKED_FIELD_NUMBER = 2;
    private boolean packed_;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    private int jstype_;
    public static final int LAZY_FIELD_NUMBER = 5;
    private boolean lazy_;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    private boolean deprecated_;
    public static final int WEAK_FIELD_NUMBER = 10;
    private boolean weak_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$FieldOptions DEFAULT_INSTANCE = new DescriptorProtos$FieldOptions();
    public static final Parser PARSER = new DescriptorProtos$FieldOptions$1();

    private DescriptorProtos$FieldOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
    }

    private DescriptorProtos$FieldOptions() {
        this.ctype_ = 0;
        this.packed_ = false;
        this.jstype_ = 0;
        this.lazy_ = false;
        this.deprecated_ = false;
        this.weak_ = false;
        this.uninterpretedOption_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$FieldOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block20 : {
                try {
                    boolean bl2 = false;
                    block15 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            int n4;
                            case 0: {
                                bl2 = true;
                                continue block15;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block15;
                                bl2 = true;
                                continue block15;
                            }
                            case 8: {
                                n4 = codedInputStream.readEnum();
                                DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.valueOf(n4);
                                if (descriptorProtos$FieldOptions$CType == null) {
                                    unknownFieldSet$Builder.mergeVarintField(1, n4);
                                    continue block15;
                                }
                                this.bitField0_ |= 1;
                                this.ctype_ = n4;
                                continue block15;
                            }
                            case 16: {
                                this.bitField0_ |= 2;
                                this.packed_ = codedInputStream.readBool();
                                continue block15;
                            }
                            case 24: {
                                this.bitField0_ |= 16;
                                this.deprecated_ = codedInputStream.readBool();
                                continue block15;
                            }
                            case 40: {
                                this.bitField0_ |= 8;
                                this.lazy_ = codedInputStream.readBool();
                                continue block15;
                            }
                            case 48: {
                                n4 = codedInputStream.readEnum();
                                DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.valueOf(n4);
                                if (descriptorProtos$FieldOptions$JSType == null) {
                                    unknownFieldSet$Builder.mergeVarintField(6, n4);
                                    continue block15;
                                }
                                this.bitField0_ |= 4;
                                this.jstype_ = n4;
                                continue block15;
                            }
                            case 80: {
                                this.bitField0_ |= 32;
                                this.weak_ = codedInputStream.readBool();
                                continue block15;
                            }
                            case 7994: 
                        }
                        if ((n2 & 64) != 64) {
                            this.uninterpretedOption_ = new ArrayList();
                            n2 |= 64;
                        }
                        this.uninterpretedOption_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption.PARSER, extensionRegistryLite));
                    }
                    Object var10_13 = null;
                    if ((n2 & 64) != 64) break block20;
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
        catch (Throwable var9_15) {
            Object var10_14 = null;
            if ((n2 & 64) == 64) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var9_15;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$16200();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$16300().ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
    }

    @Override
    public boolean hasCtype() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldOptions$CType getCtype() {
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType;
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType2 = DescriptorProtos$FieldOptions$CType.valueOf(this.ctype_);
        if (descriptorProtos$FieldOptions$CType2 == null) {
            descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.STRING;
            return descriptorProtos$FieldOptions$CType;
        }
        descriptorProtos$FieldOptions$CType = descriptorProtos$FieldOptions$CType2;
        return descriptorProtos$FieldOptions$CType;
    }

    @Override
    public boolean hasPacked() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public boolean getPacked() {
        return this.packed_;
    }

    @Override
    public boolean hasJstype() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldOptions$JSType getJstype() {
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType;
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType2 = DescriptorProtos$FieldOptions$JSType.valueOf(this.jstype_);
        if (descriptorProtos$FieldOptions$JSType2 == null) {
            descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.JS_NORMAL;
            return descriptorProtos$FieldOptions$JSType;
        }
        descriptorProtos$FieldOptions$JSType = descriptorProtos$FieldOptions$JSType2;
        return descriptorProtos$FieldOptions$JSType;
    }

    @Override
    public boolean hasLazy() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getLazy() {
        return this.lazy_;
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override
    public boolean hasWeak() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public boolean getWeak() {
        return this.weak_;
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
            codedOutputStream.writeEnum(1, this.ctype_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBool(2, this.packed_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBool(3, this.deprecated_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBool(5, this.lazy_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(6, this.jstype_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBool(10, this.weak_);
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
            n2 += CodedOutputStream.computeEnumSize(1, this.ctype_);
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeBoolSize(2, this.packed_);
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeBoolSize(5, this.lazy_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeEnumSize(6, this.jstype_);
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeBoolSize(10, this.weak_);
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

    public static DescriptorProtos$FieldOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(byte[] arrby) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$FieldOptions parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldOptions)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldOptions)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$FieldOptions$Builder newBuilderForType() {
        return DescriptorProtos$FieldOptions.newBuilder();
    }

    public static DescriptorProtos$FieldOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FieldOptions$Builder newBuilder(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FieldOptions);
    }

    @Override
    public DescriptorProtos$FieldOptions$Builder toBuilder() {
        DescriptorProtos$FieldOptions$Builder descriptorProtos$FieldOptions$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$FieldOptions$Builder = new DescriptorProtos$FieldOptions$Builder(null);
            return descriptorProtos$FieldOptions$Builder;
        }
        descriptorProtos$FieldOptions$Builder = new DescriptorProtos$FieldOptions$Builder(null).mergeFrom(this);
        return descriptorProtos$FieldOptions$Builder;
    }

    @Override
    protected DescriptorProtos$FieldOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FieldOptions$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$FieldOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$FieldOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$ExtendableBuilder);
    }

    static /* synthetic */ int access$16702(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, int n2) {
        descriptorProtos$FieldOptions.ctype_ = n2;
        return descriptorProtos$FieldOptions.ctype_;
    }

    static /* synthetic */ boolean access$16802(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.packed_ = bl2;
        return descriptorProtos$FieldOptions.packed_;
    }

    static /* synthetic */ int access$16902(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, int n2) {
        descriptorProtos$FieldOptions.jstype_ = n2;
        return descriptorProtos$FieldOptions.jstype_;
    }

    static /* synthetic */ boolean access$17002(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.lazy_ = bl2;
        return descriptorProtos$FieldOptions.lazy_;
    }

    static /* synthetic */ boolean access$17102(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.deprecated_ = bl2;
        return descriptorProtos$FieldOptions.deprecated_;
    }

    static /* synthetic */ boolean access$17202(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, boolean bl2) {
        descriptorProtos$FieldOptions.weak_ = bl2;
        return descriptorProtos$FieldOptions.weak_;
    }

    static /* synthetic */ List access$17302(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, List list) {
        descriptorProtos$FieldOptions.uninterpretedOption_ = list;
        return descriptorProtos$FieldOptions.uninterpretedOption_;
    }

    static /* synthetic */ int access$17402(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions, int n2) {
        descriptorProtos$FieldOptions.bitField0_ = n2;
        return descriptorProtos$FieldOptions.bitField0_;
    }

    static /* synthetic */ List access$17300(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        return descriptorProtos$FieldOptions.uninterpretedOption_;
    }

    /* synthetic */ DescriptorProtos$FieldOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

