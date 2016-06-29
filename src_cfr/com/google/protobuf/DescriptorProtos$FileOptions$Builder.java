/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileOptions$Builder
extends GeneratedMessage$ExtendableBuilder
implements DescriptorProtos$FileOptionsOrBuilder {
    private int bitField0_;
    private Object javaPackage_ = "";
    private Object javaOuterClassname_ = "";
    private boolean javaMultipleFiles_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaStringCheckUtf8_;
    private int optimizeFor_ = 1;
    private Object goPackage_ = "";
    private boolean ccGenericServices_;
    private boolean javaGenericServices_;
    private boolean pyGenericServices_;
    private boolean deprecated_;
    private boolean ccEnableArenas_;
    private Object objcClassPrefix_ = "";
    private Object csharpNamespace_ = "";
    private List uninterpretedOption_ = Collections.emptyList();
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$12800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$12900().ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
    }

    private DescriptorProtos$FileOptions$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$FileOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getUninterpretedOptionFieldBuilder();
    }

    @Override
    public DescriptorProtos$FileOptions$Builder clear() {
        super.clear();
        this.javaPackage_ = "";
        this.bitField0_ &= -2;
        this.javaOuterClassname_ = "";
        this.bitField0_ &= -3;
        this.javaMultipleFiles_ = false;
        this.bitField0_ &= -5;
        this.javaGenerateEqualsAndHash_ = false;
        this.bitField0_ &= -9;
        this.javaStringCheckUtf8_ = false;
        this.bitField0_ &= -17;
        this.optimizeFor_ = 1;
        this.bitField0_ &= -33;
        this.goPackage_ = "";
        this.bitField0_ &= -65;
        this.ccGenericServices_ = false;
        this.bitField0_ &= -129;
        this.javaGenericServices_ = false;
        this.bitField0_ &= -257;
        this.pyGenericServices_ = false;
        this.bitField0_ &= -513;
        this.deprecated_ = false;
        this.bitField0_ &= -1025;
        this.ccEnableArenas_ = false;
        this.bitField0_ &= -2049;
        this.objcClassPrefix_ = "";
        this.bitField0_ &= -4097;
        this.csharpNamespace_ = "";
        this.bitField0_ &= -8193;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -16385;
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$12800();
    }

    @Override
    public DescriptorProtos$FileOptions getDefaultInstanceForType() {
        return DescriptorProtos$FileOptions.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$FileOptions build() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = this.buildPartial();
        if (descriptorProtos$FileOptions.isInitialized()) return descriptorProtos$FileOptions;
        throw DescriptorProtos$FileOptions$Builder.newUninitializedMessageException(descriptorProtos$FileOptions);
    }

    @Override
    public DescriptorProtos$FileOptions buildPartial() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = new DescriptorProtos$FileOptions(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$FileOptions.access$13302(descriptorProtos$FileOptions, this.javaPackage_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$FileOptions.access$13402(descriptorProtos$FileOptions, this.javaOuterClassname_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        DescriptorProtos$FileOptions.access$13502(descriptorProtos$FileOptions, this.javaMultipleFiles_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        DescriptorProtos$FileOptions.access$13602(descriptorProtos$FileOptions, this.javaGenerateEqualsAndHash_);
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        DescriptorProtos$FileOptions.access$13702(descriptorProtos$FileOptions, this.javaStringCheckUtf8_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        DescriptorProtos$FileOptions.access$13802(descriptorProtos$FileOptions, this.optimizeFor_);
        if ((n2 & 64) == 64) {
            n3 |= 64;
        }
        DescriptorProtos$FileOptions.access$13902(descriptorProtos$FileOptions, this.goPackage_);
        if ((n2 & 128) == 128) {
            n3 |= 128;
        }
        DescriptorProtos$FileOptions.access$14002(descriptorProtos$FileOptions, this.ccGenericServices_);
        if ((n2 & 256) == 256) {
            n3 |= 256;
        }
        DescriptorProtos$FileOptions.access$14102(descriptorProtos$FileOptions, this.javaGenericServices_);
        if ((n2 & 512) == 512) {
            n3 |= 512;
        }
        DescriptorProtos$FileOptions.access$14202(descriptorProtos$FileOptions, this.pyGenericServices_);
        if ((n2 & 1024) == 1024) {
            n3 |= 1024;
        }
        DescriptorProtos$FileOptions.access$14302(descriptorProtos$FileOptions, this.deprecated_);
        if ((n2 & 2048) == 2048) {
            n3 |= 2048;
        }
        DescriptorProtos$FileOptions.access$14402(descriptorProtos$FileOptions, this.ccEnableArenas_);
        if ((n2 & 4096) == 4096) {
            n3 |= 4096;
        }
        DescriptorProtos$FileOptions.access$14502(descriptorProtos$FileOptions, this.objcClassPrefix_);
        if ((n2 & 8192) == 8192) {
            n3 |= 8192;
        }
        DescriptorProtos$FileOptions.access$14602(descriptorProtos$FileOptions, this.csharpNamespace_);
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 16384) == 16384) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ &= -16385;
            }
            DescriptorProtos$FileOptions.access$14702(descriptorProtos$FileOptions, this.uninterpretedOption_);
        } else {
            DescriptorProtos$FileOptions.access$14702(descriptorProtos$FileOptions, this.uninterpretedOptionBuilder_.build());
        }
        DescriptorProtos$FileOptions.access$14802(descriptorProtos$FileOptions, n3);
        this.onBuilt();
        return descriptorProtos$FileOptions;
    }

    @Override
    public DescriptorProtos$FileOptions$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$FileOptions) {
            return this.mergeFrom((DescriptorProtos$FileOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FileOptions$Builder mergeFrom(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        if (descriptorProtos$FileOptions == DescriptorProtos$FileOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FileOptions.hasJavaPackage()) {
            this.bitField0_ |= 1;
            this.javaPackage_ = DescriptorProtos$FileOptions.access$13300(descriptorProtos$FileOptions);
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasJavaOuterClassname()) {
            this.bitField0_ |= 2;
            this.javaOuterClassname_ = DescriptorProtos$FileOptions.access$13400(descriptorProtos$FileOptions);
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasJavaMultipleFiles()) {
            this.setJavaMultipleFiles(descriptorProtos$FileOptions.getJavaMultipleFiles());
        }
        if (descriptorProtos$FileOptions.hasJavaGenerateEqualsAndHash()) {
            this.setJavaGenerateEqualsAndHash(descriptorProtos$FileOptions.getJavaGenerateEqualsAndHash());
        }
        if (descriptorProtos$FileOptions.hasJavaStringCheckUtf8()) {
            this.setJavaStringCheckUtf8(descriptorProtos$FileOptions.getJavaStringCheckUtf8());
        }
        if (descriptorProtos$FileOptions.hasOptimizeFor()) {
            this.setOptimizeFor(descriptorProtos$FileOptions.getOptimizeFor());
        }
        if (descriptorProtos$FileOptions.hasGoPackage()) {
            this.bitField0_ |= 64;
            this.goPackage_ = DescriptorProtos$FileOptions.access$13900(descriptorProtos$FileOptions);
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasCcGenericServices()) {
            this.setCcGenericServices(descriptorProtos$FileOptions.getCcGenericServices());
        }
        if (descriptorProtos$FileOptions.hasJavaGenericServices()) {
            this.setJavaGenericServices(descriptorProtos$FileOptions.getJavaGenericServices());
        }
        if (descriptorProtos$FileOptions.hasPyGenericServices()) {
            this.setPyGenericServices(descriptorProtos$FileOptions.getPyGenericServices());
        }
        if (descriptorProtos$FileOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$FileOptions.getDeprecated());
        }
        if (descriptorProtos$FileOptions.hasCcEnableArenas()) {
            this.setCcEnableArenas(descriptorProtos$FileOptions.getCcEnableArenas());
        }
        if (descriptorProtos$FileOptions.hasObjcClassPrefix()) {
            this.bitField0_ |= 4096;
            this.objcClassPrefix_ = DescriptorProtos$FileOptions.access$14500(descriptorProtos$FileOptions);
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasCsharpNamespace()) {
            this.bitField0_ |= 8192;
            this.csharpNamespace_ = DescriptorProtos$FileOptions.access$14600(descriptorProtos$FileOptions);
            this.onChanged();
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!DescriptorProtos$FileOptions.access$14700(descriptorProtos$FileOptions).isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = DescriptorProtos$FileOptions.access$14700(descriptorProtos$FileOptions);
                    this.bitField0_ &= -16385;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(DescriptorProtos$FileOptions.access$14700(descriptorProtos$FileOptions));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FileOptions.access$14700(descriptorProtos$FileOptions).isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = DescriptorProtos$FileOptions.access$14700(descriptorProtos$FileOptions);
                this.bitField0_ &= -16385;
                this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null;
            } else {
                this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$FileOptions.access$14700(descriptorProtos$FileOptions));
            }
        }
        this.mergeExtensionFields(descriptorProtos$FileOptions);
        this.mergeUnknownFields(descriptorProtos$FileOptions.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2 = 0;
        do {
            if (n2 >= this.getUninterpretedOptionCount()) {
                if (this.extensionsAreInitialized()) return true;
                return false;
            }
            if (!this.getUninterpretedOption(n2).isInitialized()) {
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public DescriptorProtos$FileOptions$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = null;
        try {
            try {
                descriptorProtos$FileOptions = (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$FileOptions = (DescriptorProtos$FileOptions)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$FileOptions == null) return this;
            this.mergeFrom(descriptorProtos$FileOptions);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$FileOptions == null) throw var5_7;
            this.mergeFrom(descriptorProtos$FileOptions);
            throw var5_7;
        }
    }

    @Override
    public boolean hasJavaPackage() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getJavaPackage() {
        Object object = this.javaPackage_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.javaPackage_ = string;
        return string;
    }

    @Override
    public ByteString getJavaPackageBytes() {
        ByteString byteString;
        Object object = this.javaPackage_;
        if (!(object instanceof String)) return (ByteString)object;
        this.javaPackage_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileOptions$Builder setJavaPackage(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.javaPackage_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaPackage() {
        this.bitField0_ &= -2;
        this.javaPackage_ = DescriptorProtos$FileOptions.getDefaultInstance().getJavaPackage();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaPackageBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.javaPackage_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasJavaOuterClassname() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getJavaOuterClassname() {
        Object object = this.javaOuterClassname_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.javaOuterClassname_ = string;
        return string;
    }

    @Override
    public ByteString getJavaOuterClassnameBytes() {
        ByteString byteString;
        Object object = this.javaOuterClassname_;
        if (!(object instanceof String)) return (ByteString)object;
        this.javaOuterClassname_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileOptions$Builder setJavaOuterClassname(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.javaOuterClassname_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaOuterClassname() {
        this.bitField0_ &= -3;
        this.javaOuterClassname_ = DescriptorProtos$FileOptions.getDefaultInstance().getJavaOuterClassname();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setJavaOuterClassnameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.javaOuterClassname_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasJavaMultipleFiles() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    public DescriptorProtos$FileOptions$Builder setJavaMultipleFiles(boolean bl2) {
        this.bitField0_ |= 4;
        this.javaMultipleFiles_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaMultipleFiles() {
        this.bitField0_ &= -5;
        this.javaMultipleFiles_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasJavaGenerateEqualsAndHash() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    public DescriptorProtos$FileOptions$Builder setJavaGenerateEqualsAndHash(boolean bl2) {
        this.bitField0_ |= 8;
        this.javaGenerateEqualsAndHash_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaGenerateEqualsAndHash() {
        this.bitField0_ &= -9;
        this.javaGenerateEqualsAndHash_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasJavaStringCheckUtf8() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    public DescriptorProtos$FileOptions$Builder setJavaStringCheckUtf8(boolean bl2) {
        this.bitField0_ |= 16;
        this.javaStringCheckUtf8_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaStringCheckUtf8() {
        this.bitField0_ &= -17;
        this.javaStringCheckUtf8_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOptimizeFor() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode;
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode2 = DescriptorProtos$FileOptions$OptimizeMode.valueOf(this.optimizeFor_);
        if (descriptorProtos$FileOptions$OptimizeMode2 == null) {
            descriptorProtos$FileOptions$OptimizeMode = DescriptorProtos$FileOptions$OptimizeMode.SPEED;
            return descriptorProtos$FileOptions$OptimizeMode;
        }
        descriptorProtos$FileOptions$OptimizeMode = descriptorProtos$FileOptions$OptimizeMode2;
        return descriptorProtos$FileOptions$OptimizeMode;
    }

    public DescriptorProtos$FileOptions$Builder setOptimizeFor(DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode) {
        if (descriptorProtos$FileOptions$OptimizeMode == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.optimizeFor_ = descriptorProtos$FileOptions$OptimizeMode.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearOptimizeFor() {
        this.bitField0_ &= -33;
        this.optimizeFor_ = 1;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasGoPackage() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public String getGoPackage() {
        Object object = this.goPackage_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.goPackage_ = string;
        return string;
    }

    @Override
    public ByteString getGoPackageBytes() {
        ByteString byteString;
        Object object = this.goPackage_;
        if (!(object instanceof String)) return (ByteString)object;
        this.goPackage_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileOptions$Builder setGoPackage(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 64;
        this.goPackage_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearGoPackage() {
        this.bitField0_ &= -65;
        this.goPackage_ = DescriptorProtos$FileOptions.getDefaultInstance().getGoPackage();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setGoPackageBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 64;
        this.goPackage_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasCcGenericServices() {
        if ((this.bitField0_ & 128) != 128) return false;
        return true;
    }

    @Override
    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    public DescriptorProtos$FileOptions$Builder setCcGenericServices(boolean bl2) {
        this.bitField0_ |= 128;
        this.ccGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearCcGenericServices() {
        this.bitField0_ &= -129;
        this.ccGenericServices_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasJavaGenericServices() {
        if ((this.bitField0_ & 256) != 256) return false;
        return true;
    }

    @Override
    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    public DescriptorProtos$FileOptions$Builder setJavaGenericServices(boolean bl2) {
        this.bitField0_ |= 256;
        this.javaGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearJavaGenericServices() {
        this.bitField0_ &= -257;
        this.javaGenericServices_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasPyGenericServices() {
        if ((this.bitField0_ & 512) != 512) return false;
        return true;
    }

    @Override
    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    public DescriptorProtos$FileOptions$Builder setPyGenericServices(boolean bl2) {
        this.bitField0_ |= 512;
        this.pyGenericServices_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearPyGenericServices() {
        this.bitField0_ &= -513;
        this.pyGenericServices_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 1024) != 1024) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos$FileOptions$Builder setDeprecated(boolean bl2) {
        this.bitField0_ |= 1024;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearDeprecated() {
        this.bitField0_ &= -1025;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasCcEnableArenas() {
        if ((this.bitField0_ & 2048) != 2048) return false;
        return true;
    }

    @Override
    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    public DescriptorProtos$FileOptions$Builder setCcEnableArenas(boolean bl2) {
        this.bitField0_ |= 2048;
        this.ccEnableArenas_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearCcEnableArenas() {
        this.bitField0_ &= -2049;
        this.ccEnableArenas_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasObjcClassPrefix() {
        if ((this.bitField0_ & 4096) != 4096) return false;
        return true;
    }

    @Override
    public String getObjcClassPrefix() {
        Object object = this.objcClassPrefix_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.objcClassPrefix_ = string;
        return string;
    }

    @Override
    public ByteString getObjcClassPrefixBytes() {
        ByteString byteString;
        Object object = this.objcClassPrefix_;
        if (!(object instanceof String)) return (ByteString)object;
        this.objcClassPrefix_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileOptions$Builder setObjcClassPrefix(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4096;
        this.objcClassPrefix_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearObjcClassPrefix() {
        this.bitField0_ &= -4097;
        this.objcClassPrefix_ = DescriptorProtos$FileOptions.getDefaultInstance().getObjcClassPrefix();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setObjcClassPrefixBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4096;
        this.objcClassPrefix_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasCsharpNamespace() {
        if ((this.bitField0_ & 8192) != 8192) return false;
        return true;
    }

    @Override
    public String getCsharpNamespace() {
        Object object = this.csharpNamespace_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.csharpNamespace_ = string;
        return string;
    }

    @Override
    public ByteString getCsharpNamespaceBytes() {
        ByteString byteString;
        Object object = this.csharpNamespace_;
        if (!(object instanceof String)) return (ByteString)object;
        this.csharpNamespace_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileOptions$Builder setCsharpNamespace(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8192;
        this.csharpNamespace_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearCsharpNamespace() {
        this.bitField0_ &= -8193;
        this.csharpNamespace_ = DescriptorProtos$FileOptions.getDefaultInstance().getCsharpNamespace();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setCsharpNamespaceBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8192;
        this.csharpNamespace_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 16384) == 16384) return;
        this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
        this.bitField0_ |= 16384;
    }

    @Override
    public List getUninterpretedOptionList() {
        if (this.uninterpretedOptionBuilder_ != null) return this.uninterpretedOptionBuilder_.getMessageList();
        return Collections.unmodifiableList(this.uninterpretedOption_);
    }

    @Override
    public int getUninterpretedOptionCount() {
        if (this.uninterpretedOptionBuilder_ != null) return this.uninterpretedOptionBuilder_.getCount();
        return this.uninterpretedOption_.size();
    }

    @Override
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int n2) {
        if (this.uninterpretedOptionBuilder_ != null) return (DescriptorProtos$UninterpretedOption)this.uninterpretedOptionBuilder_.getMessage(n2);
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n2);
    }

    public DescriptorProtos$FileOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ != null) {
            this.uninterpretedOptionBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption);
            return this;
        }
        if (descriptorProtos$UninterpretedOption == null) {
            throw new NullPointerException();
        }
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(n2, descriptorProtos$UninterpretedOption);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ != null) {
            this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption);
            return this;
        }
        if (descriptorProtos$UninterpretedOption == null) {
            throw new NullPointerException();
        }
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ != null) {
            this.uninterpretedOptionBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption);
            return this;
        }
        if (descriptorProtos$UninterpretedOption == null) {
            throw new NullPointerException();
        }
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(n2, descriptorProtos$UninterpretedOption);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$FileOptions$Builder addAllUninterpretedOption(Iterable iterable) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.uninterpretedOption_);
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FileOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -16385;
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FileOptions$Builder removeUninterpretedOption(int n2) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(n2);
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n2) {
        if (this.uninterpretedOptionBuilder_ != null) return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOptionBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n2);
    }

    @Override
    public List getUninterpretedOptionOrBuilderList() {
        if (this.uninterpretedOptionBuilder_ == null) return Collections.unmodifiableList(this.uninterpretedOption_);
        return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }

    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(n2, DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }

    public List getUninterpretedOptionBuilderList() {
        return this.getUninterpretedOptionFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder() {
        if (this.uninterpretedOptionBuilder_ != null) return this.uninterpretedOptionBuilder_;
        this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 16384) == 16384, this.getParentForChildren(), this.isClean());
        this.uninterpretedOption_ = null;
        return this.uninterpretedOptionBuilder_;
    }

    /* synthetic */ DescriptorProtos$FileOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$FileOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

