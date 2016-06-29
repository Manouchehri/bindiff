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
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$FileDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private Object package_ = "";
    private LazyStringList dependency_ = LazyStringArrayList.EMPTY;
    private List publicDependency_ = Collections.emptyList();
    private List weakDependency_ = Collections.emptyList();
    private List messageType_ = Collections.emptyList();
    private RepeatedFieldBuilder messageTypeBuilder_;
    private List enumType_ = Collections.emptyList();
    private RepeatedFieldBuilder enumTypeBuilder_;
    private List service_ = Collections.emptyList();
    private RepeatedFieldBuilder serviceBuilder_;
    private List extension_ = Collections.emptyList();
    private RepeatedFieldBuilder extensionBuilder_;
    private DescriptorProtos$FileOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;
    private DescriptorProtos$SourceCodeInfo sourceCodeInfo_ = null;
    private SingleFieldBuilder sourceCodeInfoBuilder_;
    private Object syntax_ = "";

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
    }

    private DescriptorProtos$FileDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getMessageTypeFieldBuilder();
        this.getEnumTypeFieldBuilder();
        this.getServiceFieldBuilder();
        this.getExtensionFieldBuilder();
        this.getOptionsFieldBuilder();
        this.getSourceCodeInfoFieldBuilder();
    }

    @Override
    public DescriptorProtos$FileDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        this.package_ = "";
        this.bitField0_ &= -3;
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -5;
        this.publicDependency_ = Collections.emptyList();
        this.bitField0_ &= -9;
        this.weakDependency_ = Collections.emptyList();
        this.bitField0_ &= -17;
        if (this.messageTypeBuilder_ == null) {
            this.messageType_ = Collections.emptyList();
            this.bitField0_ &= -33;
        } else {
            this.messageTypeBuilder_.clear();
        }
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= -65;
        } else {
            this.enumTypeBuilder_.clear();
        }
        if (this.serviceBuilder_ == null) {
            this.service_ = Collections.emptyList();
            this.bitField0_ &= -129;
        } else {
            this.serviceBuilder_.clear();
        }
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= -257;
        } else {
            this.extensionBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -513;
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = null;
        } else {
            this.sourceCodeInfoBuilder_.clear();
        }
        this.bitField0_ &= -1025;
        this.syntax_ = "";
        this.bitField0_ &= -2049;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$700();
    }

    @Override
    public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$FileDescriptorProto build() {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.buildPartial();
        if (descriptorProtos$FileDescriptorProto.isInitialized()) return descriptorProtos$FileDescriptorProto;
        throw DescriptorProtos$FileDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$FileDescriptorProto);
    }

    @Override
    public DescriptorProtos$FileDescriptorProto buildPartial() {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = new DescriptorProtos$FileDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$FileDescriptorProto.access$1202(descriptorProtos$FileDescriptorProto, this.name_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$FileDescriptorProto.access$1302(descriptorProtos$FileDescriptorProto, this.package_);
        if ((this.bitField0_ & 4) == 4) {
            this.dependency_ = this.dependency_.getUnmodifiableView();
            this.bitField0_ &= -5;
        }
        DescriptorProtos$FileDescriptorProto.access$1402(descriptorProtos$FileDescriptorProto, this.dependency_);
        if ((this.bitField0_ & 8) == 8) {
            this.publicDependency_ = Collections.unmodifiableList(this.publicDependency_);
            this.bitField0_ &= -9;
        }
        DescriptorProtos$FileDescriptorProto.access$1502(descriptorProtos$FileDescriptorProto, this.publicDependency_);
        if ((this.bitField0_ & 16) == 16) {
            this.weakDependency_ = Collections.unmodifiableList(this.weakDependency_);
            this.bitField0_ &= -17;
        }
        DescriptorProtos$FileDescriptorProto.access$1602(descriptorProtos$FileDescriptorProto, this.weakDependency_);
        if (this.messageTypeBuilder_ == null) {
            if ((this.bitField0_ & 32) == 32) {
                this.messageType_ = Collections.unmodifiableList(this.messageType_);
                this.bitField0_ &= -33;
            }
            DescriptorProtos$FileDescriptorProto.access$1702(descriptorProtos$FileDescriptorProto, this.messageType_);
        } else {
            DescriptorProtos$FileDescriptorProto.access$1702(descriptorProtos$FileDescriptorProto, this.messageTypeBuilder_.build());
        }
        if (this.enumTypeBuilder_ == null) {
            if ((this.bitField0_ & 64) == 64) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
                this.bitField0_ &= -65;
            }
            DescriptorProtos$FileDescriptorProto.access$1802(descriptorProtos$FileDescriptorProto, this.enumType_);
        } else {
            DescriptorProtos$FileDescriptorProto.access$1802(descriptorProtos$FileDescriptorProto, this.enumTypeBuilder_.build());
        }
        if (this.serviceBuilder_ == null) {
            if ((this.bitField0_ & 128) == 128) {
                this.service_ = Collections.unmodifiableList(this.service_);
                this.bitField0_ &= -129;
            }
            DescriptorProtos$FileDescriptorProto.access$1902(descriptorProtos$FileDescriptorProto, this.service_);
        } else {
            DescriptorProtos$FileDescriptorProto.access$1902(descriptorProtos$FileDescriptorProto, this.serviceBuilder_.build());
        }
        if (this.extensionBuilder_ == null) {
            if ((this.bitField0_ & 256) == 256) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
                this.bitField0_ &= -257;
            }
            DescriptorProtos$FileDescriptorProto.access$2002(descriptorProtos$FileDescriptorProto, this.extension_);
        } else {
            DescriptorProtos$FileDescriptorProto.access$2002(descriptorProtos$FileDescriptorProto, this.extensionBuilder_.build());
        }
        if ((n2 & 512) == 512) {
            n3 |= 4;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$FileDescriptorProto.access$2102(descriptorProtos$FileDescriptorProto, this.options_);
        } else {
            DescriptorProtos$FileDescriptorProto.access$2102(descriptorProtos$FileDescriptorProto, (DescriptorProtos$FileOptions)this.optionsBuilder_.build());
        }
        if ((n2 & 1024) == 1024) {
            n3 |= 8;
        }
        if (this.sourceCodeInfoBuilder_ == null) {
            DescriptorProtos$FileDescriptorProto.access$2202(descriptorProtos$FileDescriptorProto, this.sourceCodeInfo_);
        } else {
            DescriptorProtos$FileDescriptorProto.access$2202(descriptorProtos$FileDescriptorProto, (DescriptorProtos$SourceCodeInfo)this.sourceCodeInfoBuilder_.build());
        }
        if ((n2 & 2048) == 2048) {
            n3 |= 16;
        }
        DescriptorProtos$FileDescriptorProto.access$2302(descriptorProtos$FileDescriptorProto, this.syntax_);
        DescriptorProtos$FileDescriptorProto.access$2402(descriptorProtos$FileDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$FileDescriptorProto;
    }

    @Override
    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$FileDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$FileDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (descriptorProtos$FileDescriptorProto == DescriptorProtos$FileDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FileDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$FileDescriptorProto.access$1200(descriptorProtos$FileDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$FileDescriptorProto.hasPackage()) {
            this.bitField0_ |= 2;
            this.package_ = DescriptorProtos$FileDescriptorProto.access$1300(descriptorProtos$FileDescriptorProto);
            this.onChanged();
        }
        if (!DescriptorProtos$FileDescriptorProto.access$1400(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.dependency_.isEmpty()) {
                this.dependency_ = DescriptorProtos$FileDescriptorProto.access$1400(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -5;
            } else {
                this.ensureDependencyIsMutable();
                this.dependency_.addAll(DescriptorProtos$FileDescriptorProto.access$1400(descriptorProtos$FileDescriptorProto));
            }
            this.onChanged();
        }
        if (!DescriptorProtos$FileDescriptorProto.access$1500(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.publicDependency_.isEmpty()) {
                this.publicDependency_ = DescriptorProtos$FileDescriptorProto.access$1500(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -9;
            } else {
                this.ensurePublicDependencyIsMutable();
                this.publicDependency_.addAll(DescriptorProtos$FileDescriptorProto.access$1500(descriptorProtos$FileDescriptorProto));
            }
            this.onChanged();
        }
        if (!DescriptorProtos$FileDescriptorProto.access$1600(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.weakDependency_.isEmpty()) {
                this.weakDependency_ = DescriptorProtos$FileDescriptorProto.access$1600(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -17;
            } else {
                this.ensureWeakDependencyIsMutable();
                this.weakDependency_.addAll(DescriptorProtos$FileDescriptorProto.access$1600(descriptorProtos$FileDescriptorProto));
            }
            this.onChanged();
        }
        if (this.messageTypeBuilder_ == null) {
            if (!DescriptorProtos$FileDescriptorProto.access$1700(descriptorProtos$FileDescriptorProto).isEmpty()) {
                if (this.messageType_.isEmpty()) {
                    this.messageType_ = DescriptorProtos$FileDescriptorProto.access$1700(descriptorProtos$FileDescriptorProto);
                    this.bitField0_ &= -33;
                } else {
                    this.ensureMessageTypeIsMutable();
                    this.messageType_.addAll(DescriptorProtos$FileDescriptorProto.access$1700(descriptorProtos$FileDescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FileDescriptorProto.access$1700(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.messageTypeBuilder_.isEmpty()) {
                this.messageTypeBuilder_.dispose();
                this.messageTypeBuilder_ = null;
                this.messageType_ = DescriptorProtos$FileDescriptorProto.access$1700(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -33;
                this.messageTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getMessageTypeFieldBuilder() : null;
            } else {
                this.messageTypeBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$1700(descriptorProtos$FileDescriptorProto));
            }
        }
        if (this.enumTypeBuilder_ == null) {
            if (!DescriptorProtos$FileDescriptorProto.access$1800(descriptorProtos$FileDescriptorProto).isEmpty()) {
                if (this.enumType_.isEmpty()) {
                    this.enumType_ = DescriptorProtos$FileDescriptorProto.access$1800(descriptorProtos$FileDescriptorProto);
                    this.bitField0_ &= -65;
                } else {
                    this.ensureEnumTypeIsMutable();
                    this.enumType_.addAll(DescriptorProtos$FileDescriptorProto.access$1800(descriptorProtos$FileDescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FileDescriptorProto.access$1800(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.enumTypeBuilder_.isEmpty()) {
                this.enumTypeBuilder_.dispose();
                this.enumTypeBuilder_ = null;
                this.enumType_ = DescriptorProtos$FileDescriptorProto.access$1800(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -65;
                this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getEnumTypeFieldBuilder() : null;
            } else {
                this.enumTypeBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$1800(descriptorProtos$FileDescriptorProto));
            }
        }
        if (this.serviceBuilder_ == null) {
            if (!DescriptorProtos$FileDescriptorProto.access$1900(descriptorProtos$FileDescriptorProto).isEmpty()) {
                if (this.service_.isEmpty()) {
                    this.service_ = DescriptorProtos$FileDescriptorProto.access$1900(descriptorProtos$FileDescriptorProto);
                    this.bitField0_ &= -129;
                } else {
                    this.ensureServiceIsMutable();
                    this.service_.addAll(DescriptorProtos$FileDescriptorProto.access$1900(descriptorProtos$FileDescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FileDescriptorProto.access$1900(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.serviceBuilder_.isEmpty()) {
                this.serviceBuilder_.dispose();
                this.serviceBuilder_ = null;
                this.service_ = DescriptorProtos$FileDescriptorProto.access$1900(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -129;
                this.serviceBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getServiceFieldBuilder() : null;
            } else {
                this.serviceBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$1900(descriptorProtos$FileDescriptorProto));
            }
        }
        if (this.extensionBuilder_ == null) {
            if (!DescriptorProtos$FileDescriptorProto.access$2000(descriptorProtos$FileDescriptorProto).isEmpty()) {
                if (this.extension_.isEmpty()) {
                    this.extension_ = DescriptorProtos$FileDescriptorProto.access$2000(descriptorProtos$FileDescriptorProto);
                    this.bitField0_ &= -257;
                } else {
                    this.ensureExtensionIsMutable();
                    this.extension_.addAll(DescriptorProtos$FileDescriptorProto.access$2000(descriptorProtos$FileDescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FileDescriptorProto.access$2000(descriptorProtos$FileDescriptorProto).isEmpty()) {
            if (this.extensionBuilder_.isEmpty()) {
                this.extensionBuilder_.dispose();
                this.extensionBuilder_ = null;
                this.extension_ = DescriptorProtos$FileDescriptorProto.access$2000(descriptorProtos$FileDescriptorProto);
                this.bitField0_ &= -257;
                this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getExtensionFieldBuilder() : null;
            } else {
                this.extensionBuilder_.addAllMessages(DescriptorProtos$FileDescriptorProto.access$2000(descriptorProtos$FileDescriptorProto));
            }
        }
        if (descriptorProtos$FileDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$FileDescriptorProto.getOptions());
        }
        if (descriptorProtos$FileDescriptorProto.hasSourceCodeInfo()) {
            this.mergeSourceCodeInfo(descriptorProtos$FileDescriptorProto.getSourceCodeInfo());
        }
        if (descriptorProtos$FileDescriptorProto.hasSyntax()) {
            this.bitField0_ |= 2048;
            this.syntax_ = DescriptorProtos$FileDescriptorProto.access$2300(descriptorProtos$FileDescriptorProto);
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$FileDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2;
        for (n2 = 0; n2 < this.getMessageTypeCount(); ++n2) {
            if (this.getMessageType(n2).isInitialized()) continue;
            return false;
        }
        for (n2 = 0; n2 < this.getEnumTypeCount(); ++n2) {
            if (this.getEnumType(n2).isInitialized()) continue;
            return false;
        }
        for (n2 = 0; n2 < this.getServiceCount(); ++n2) {
            if (this.getService(n2).isInitialized()) continue;
            return false;
        }
        n2 = 0;
        do {
            if (n2 >= this.getExtensionCount()) {
                if (!this.hasOptions()) return true;
                if (this.getOptions().isInitialized()) return true;
                return false;
            }
            if (!this.getExtension(n2).isInitialized()) {
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = null;
        try {
            descriptorProtos$FileDescriptorProto = (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            descriptorProtos$FileDescriptorProto = (DescriptorProtos$FileDescriptorProto)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (descriptorProtos$FileDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$FileDescriptorProto);
            }
        }
    }

    @Override
    public boolean hasName() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) return (String)object;
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

    public DescriptorProtos$FileDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasPackage() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getPackage() {
        Object object = this.package_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.package_ = string;
        return string;
    }

    @Override
    public ByteString getPackageBytes() {
        ByteString byteString;
        Object object = this.package_;
        if (!(object instanceof String)) return (ByteString)object;
        this.package_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setPackage(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.package_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearPackage() {
        this.bitField0_ &= -3;
        this.package_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getPackage();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setPackageBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.package_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureDependencyIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.dependency_ = new LazyStringArrayList(this.dependency_);
        this.bitField0_ |= 4;
    }

    @Override
    public ProtocolStringList getDependencyList() {
        return this.dependency_.getUnmodifiableView();
    }

    @Override
    public int getDependencyCount() {
        return this.dependency_.size();
    }

    @Override
    public String getDependency(int n2) {
        return (String)this.dependency_.get(n2);
    }

    @Override
    public ByteString getDependencyBytes(int n2) {
        return this.dependency_.getByteString(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setDependency(int n2, String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureDependencyIsMutable();
        this.dependency_.set(n2, string);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addDependency(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureDependencyIsMutable();
        this.dependency_.add(string);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllDependency(Iterable iterable) {
        this.ensureDependencyIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.dependency_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearDependency() {
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -5;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addDependencyBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureDependencyIsMutable();
        this.dependency_.add(byteString);
        this.onChanged();
        return this;
    }

    private void ensurePublicDependencyIsMutable() {
        if ((this.bitField0_ & 8) == 8) return;
        this.publicDependency_ = new ArrayList(this.publicDependency_);
        this.bitField0_ |= 8;
    }

    @Override
    public List getPublicDependencyList() {
        return Collections.unmodifiableList(this.publicDependency_);
    }

    @Override
    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    @Override
    public int getPublicDependency(int n2) {
        return (Integer)this.publicDependency_.get(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setPublicDependency(int n2, int n3) {
        this.ensurePublicDependencyIsMutable();
        this.publicDependency_.set(n2, n3);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addPublicDependency(int n2) {
        this.ensurePublicDependencyIsMutable();
        this.publicDependency_.add(n2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllPublicDependency(Iterable iterable) {
        this.ensurePublicDependencyIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.publicDependency_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearPublicDependency() {
        this.publicDependency_ = Collections.emptyList();
        this.bitField0_ &= -9;
        this.onChanged();
        return this;
    }

    private void ensureWeakDependencyIsMutable() {
        if ((this.bitField0_ & 16) == 16) return;
        this.weakDependency_ = new ArrayList(this.weakDependency_);
        this.bitField0_ |= 16;
    }

    @Override
    public List getWeakDependencyList() {
        return Collections.unmodifiableList(this.weakDependency_);
    }

    @Override
    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    @Override
    public int getWeakDependency(int n2) {
        return (Integer)this.weakDependency_.get(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setWeakDependency(int n2, int n3) {
        this.ensureWeakDependencyIsMutable();
        this.weakDependency_.set(n2, n3);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addWeakDependency(int n2) {
        this.ensureWeakDependencyIsMutable();
        this.weakDependency_.add(n2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllWeakDependency(Iterable iterable) {
        this.ensureWeakDependencyIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.weakDependency_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearWeakDependency() {
        this.weakDependency_ = Collections.emptyList();
        this.bitField0_ &= -17;
        this.onChanged();
        return this;
    }

    private void ensureMessageTypeIsMutable() {
        if ((this.bitField0_ & 32) == 32) return;
        this.messageType_ = new ArrayList(this.messageType_);
        this.bitField0_ |= 32;
    }

    @Override
    public List getMessageTypeList() {
        if (this.messageTypeBuilder_ != null) return this.messageTypeBuilder_.getMessageList();
        return Collections.unmodifiableList(this.messageType_);
    }

    @Override
    public int getMessageTypeCount() {
        if (this.messageTypeBuilder_ != null) return this.messageTypeBuilder_.getCount();
        return this.messageType_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto getMessageType(int n2) {
        if (this.messageTypeBuilder_ != null) return (DescriptorProtos$DescriptorProto)this.messageTypeBuilder_.getMessage(n2);
        return (DescriptorProtos$DescriptorProto)this.messageType_.get(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setMessageType(int n2, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.messageTypeBuilder_ != null) {
            this.messageTypeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto);
            return this;
        }
        if (descriptorProtos$DescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureMessageTypeIsMutable();
        this.messageType_.set(n2, descriptorProtos$DescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setMessageType(int n2, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.set(n2, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.messageTypeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.messageTypeBuilder_ != null) {
            this.messageTypeBuilder_.addMessage(descriptorProtos$DescriptorProto);
            return this;
        }
        if (descriptorProtos$DescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureMessageTypeIsMutable();
        this.messageType_.add(descriptorProtos$DescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(int n2, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.messageTypeBuilder_ != null) {
            this.messageTypeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto);
            return this;
        }
        if (descriptorProtos$DescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureMessageTypeIsMutable();
        this.messageType_.add(n2, descriptorProtos$DescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.add(descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.messageTypeBuilder_.addMessage(descriptorProtos$DescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(int n2, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.add(n2, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.messageTypeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllMessageType(Iterable iterable) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.messageType_);
            this.onChanged();
            return this;
        }
        this.messageTypeBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearMessageType() {
        if (this.messageTypeBuilder_ == null) {
            this.messageType_ = Collections.emptyList();
            this.bitField0_ &= -33;
            this.onChanged();
            return this;
        }
        this.messageTypeBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder removeMessageType(int n2) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.remove(n2);
            this.onChanged();
            return this;
        }
        this.messageTypeBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder getMessageTypeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int n2) {
        if (this.messageTypeBuilder_ != null) return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageTypeBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageType_.get(n2);
    }

    @Override
    public List getMessageTypeOrBuilderList() {
        if (this.messageTypeBuilder_ == null) return Collections.unmodifiableList(this.messageType_);
        return this.messageTypeBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder() {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().addBuilder(n2, DescriptorProtos$DescriptorProto.getDefaultInstance());
    }

    public List getMessageTypeBuilderList() {
        return this.getMessageTypeFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getMessageTypeFieldBuilder() {
        if (this.messageTypeBuilder_ != null) return this.messageTypeBuilder_;
        this.messageTypeBuilder_ = new RepeatedFieldBuilder(this.messageType_, (this.bitField0_ & 32) == 32, this.getParentForChildren(), this.isClean());
        this.messageType_ = null;
        return this.messageTypeBuilder_;
    }

    private void ensureEnumTypeIsMutable() {
        if ((this.bitField0_ & 64) == 64) return;
        this.enumType_ = new ArrayList(this.enumType_);
        this.bitField0_ |= 64;
    }

    @Override
    public List getEnumTypeList() {
        if (this.enumTypeBuilder_ != null) return this.enumTypeBuilder_.getMessageList();
        return Collections.unmodifiableList(this.enumType_);
    }

    @Override
    public int getEnumTypeCount() {
        if (this.enumTypeBuilder_ != null) return this.enumTypeBuilder_.getCount();
        return this.enumType_.size();
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto getEnumType(int n2) {
        if (this.enumTypeBuilder_ != null) return (DescriptorProtos$EnumDescriptorProto)this.enumTypeBuilder_.getMessage(n2);
        return (DescriptorProtos$EnumDescriptorProto)this.enumType_.get(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setEnumType(int n2, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (this.enumTypeBuilder_ != null) {
            this.enumTypeBuilder_.setMessage(n2, descriptorProtos$EnumDescriptorProto);
            return this;
        }
        if (descriptorProtos$EnumDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureEnumTypeIsMutable();
        this.enumType_.set(n2, descriptorProtos$EnumDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setEnumType(int n2, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.set(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.setMessage(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (this.enumTypeBuilder_ != null) {
            this.enumTypeBuilder_.addMessage(descriptorProtos$EnumDescriptorProto);
            return this;
        }
        if (descriptorProtos$EnumDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureEnumTypeIsMutable();
        this.enumType_.add(descriptorProtos$EnumDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(int n2, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (this.enumTypeBuilder_ != null) {
            this.enumTypeBuilder_.addMessage(n2, descriptorProtos$EnumDescriptorProto);
            return this;
        }
        if (descriptorProtos$EnumDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureEnumTypeIsMutable();
        this.enumType_.add(n2, descriptorProtos$EnumDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.addMessage(descriptorProtos$EnumDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(int n2, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.addMessage(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllEnumType(Iterable iterable) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.enumType_);
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearEnumType() {
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= -65;
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder removeEnumType(int n2) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.remove(n2);
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder getEnumTypeBuilder(int n2) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int n2) {
        if (this.enumTypeBuilder_ != null) return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumTypeBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumType_.get(n2);
    }

    @Override
    public List getEnumTypeOrBuilderList() {
        if (this.enumTypeBuilder_ == null) return Collections.unmodifiableList(this.enumType_);
        return this.enumTypeBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder() {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().addBuilder(DescriptorProtos$EnumDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder(int n2) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().addBuilder(n2, DescriptorProtos$EnumDescriptorProto.getDefaultInstance());
    }

    public List getEnumTypeBuilderList() {
        return this.getEnumTypeFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getEnumTypeFieldBuilder() {
        if (this.enumTypeBuilder_ != null) return this.enumTypeBuilder_;
        this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 64) == 64, this.getParentForChildren(), this.isClean());
        this.enumType_ = null;
        return this.enumTypeBuilder_;
    }

    private void ensureServiceIsMutable() {
        if ((this.bitField0_ & 128) == 128) return;
        this.service_ = new ArrayList(this.service_);
        this.bitField0_ |= 128;
    }

    @Override
    public List getServiceList() {
        if (this.serviceBuilder_ != null) return this.serviceBuilder_.getMessageList();
        return Collections.unmodifiableList(this.service_);
    }

    @Override
    public int getServiceCount() {
        if (this.serviceBuilder_ != null) return this.serviceBuilder_.getCount();
        return this.service_.size();
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto getService(int n2) {
        if (this.serviceBuilder_ != null) return (DescriptorProtos$ServiceDescriptorProto)this.serviceBuilder_.getMessage(n2);
        return (DescriptorProtos$ServiceDescriptorProto)this.service_.get(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setService(int n2, DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (this.serviceBuilder_ != null) {
            this.serviceBuilder_.setMessage(n2, descriptorProtos$ServiceDescriptorProto);
            return this;
        }
        if (descriptorProtos$ServiceDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureServiceIsMutable();
        this.service_.set(n2, descriptorProtos$ServiceDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setService(int n2, DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.set(n2, descriptorProtos$ServiceDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.serviceBuilder_.setMessage(n2, descriptorProtos$ServiceDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (this.serviceBuilder_ != null) {
            this.serviceBuilder_.addMessage(descriptorProtos$ServiceDescriptorProto);
            return this;
        }
        if (descriptorProtos$ServiceDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureServiceIsMutable();
        this.service_.add(descriptorProtos$ServiceDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(int n2, DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (this.serviceBuilder_ != null) {
            this.serviceBuilder_.addMessage(n2, descriptorProtos$ServiceDescriptorProto);
            return this;
        }
        if (descriptorProtos$ServiceDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureServiceIsMutable();
        this.service_.add(n2, descriptorProtos$ServiceDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.add(descriptorProtos$ServiceDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.serviceBuilder_.addMessage(descriptorProtos$ServiceDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addService(int n2, DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.add(n2, descriptorProtos$ServiceDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.serviceBuilder_.addMessage(n2, descriptorProtos$ServiceDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllService(Iterable iterable) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.service_);
            this.onChanged();
            return this;
        }
        this.serviceBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearService() {
        if (this.serviceBuilder_ == null) {
            this.service_ = Collections.emptyList();
            this.bitField0_ &= -129;
            this.onChanged();
            return this;
        }
        this.serviceBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder removeService(int n2) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.remove(n2);
            this.onChanged();
            return this;
        }
        this.serviceBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder getServiceBuilder(int n2) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int n2) {
        if (this.serviceBuilder_ != null) return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.serviceBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.service_.get(n2);
    }

    @Override
    public List getServiceOrBuilderList() {
        if (this.serviceBuilder_ == null) return Collections.unmodifiableList(this.service_);
        return this.serviceBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder() {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().addBuilder(DescriptorProtos$ServiceDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder(int n2) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().addBuilder(n2, DescriptorProtos$ServiceDescriptorProto.getDefaultInstance());
    }

    public List getServiceBuilderList() {
        return this.getServiceFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getServiceFieldBuilder() {
        if (this.serviceBuilder_ != null) return this.serviceBuilder_;
        this.serviceBuilder_ = new RepeatedFieldBuilder(this.service_, (this.bitField0_ & 128) == 128, this.getParentForChildren(), this.isClean());
        this.service_ = null;
        return this.serviceBuilder_;
    }

    private void ensureExtensionIsMutable() {
        if ((this.bitField0_ & 256) == 256) return;
        this.extension_ = new ArrayList(this.extension_);
        this.bitField0_ |= 256;
    }

    @Override
    public List getExtensionList() {
        if (this.extensionBuilder_ != null) return this.extensionBuilder_.getMessageList();
        return Collections.unmodifiableList(this.extension_);
    }

    @Override
    public int getExtensionCount() {
        if (this.extensionBuilder_ != null) return this.extensionBuilder_.getCount();
        return this.extension_.size();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto getExtension(int n2) {
        if (this.extensionBuilder_ != null) return (DescriptorProtos$FieldDescriptorProto)this.extensionBuilder_.getMessage(n2);
        return (DescriptorProtos$FieldDescriptorProto)this.extension_.get(n2);
    }

    public DescriptorProtos$FileDescriptorProto$Builder setExtension(int n2, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.extensionBuilder_ != null) {
            this.extensionBuilder_.setMessage(n2, descriptorProtos$FieldDescriptorProto);
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureExtensionIsMutable();
        this.extension_.set(n2, descriptorProtos$FieldDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setExtension(int n2, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.set(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.setMessage(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.extensionBuilder_ != null) {
            this.extensionBuilder_.addMessage(descriptorProtos$FieldDescriptorProto);
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureExtensionIsMutable();
        this.extension_.add(descriptorProtos$FieldDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(int n2, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.extensionBuilder_ != null) {
            this.extensionBuilder_.addMessage(n2, descriptorProtos$FieldDescriptorProto);
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureExtensionIsMutable();
        this.extension_.add(n2, descriptorProtos$FieldDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.add(descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.addMessage(descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addExtension(int n2, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.add(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.addMessage(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addAllExtension(Iterable iterable) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.extension_);
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearExtension() {
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= -257;
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder removeExtension(int n2) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.remove(n2);
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder getExtensionBuilder(int n2) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int n2) {
        if (this.extensionBuilder_ != null) return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extensionBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extension_.get(n2);
    }

    @Override
    public List getExtensionOrBuilderList() {
        if (this.extensionBuilder_ == null) return Collections.unmodifiableList(this.extension_);
        return this.extensionBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder() {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().addBuilder(DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder(int n2) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().addBuilder(n2, DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }

    public List getExtensionBuilderList() {
        return this.getExtensionFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getExtensionFieldBuilder() {
        if (this.extensionBuilder_ != null) return this.extensionBuilder_;
        this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 256) == 256, this.getParentForChildren(), this.isClean());
        this.extension_ = null;
        return this.extensionBuilder_;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 512) != 512) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FileOptions getOptions() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$FileOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$FileOptions = DescriptorProtos$FileOptions.getDefaultInstance();
            return descriptorProtos$FileOptions;
        }
        descriptorProtos$FileOptions = this.options_;
        return descriptorProtos$FileOptions;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setOptions(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$FileOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$FileOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$FileOptions);
        }
        this.bitField0_ |= 512;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setOptions(DescriptorProtos$FileOptions$Builder descriptorProtos$FileOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$FileOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$FileOptions$Builder.build());
        }
        this.bitField0_ |= 512;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeOptions(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 512) == 512 && this.options_ != null && this.options_ != DescriptorProtos$FileOptions.getDefaultInstance() ? DescriptorProtos$FileOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$FileOptions).buildPartial() : descriptorProtos$FileOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$FileOptions);
        }
        this.bitField0_ |= 512;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -513;
        return this;
    }

    public DescriptorProtos$FileOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 512;
        this.onChanged();
        return (DescriptorProtos$FileOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$FileOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$FileOptions = DescriptorProtos$FileOptions.getDefaultInstance();
            return descriptorProtos$FileOptions;
        }
        descriptorProtos$FileOptions = this.options_;
        return descriptorProtos$FileOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public boolean hasSourceCodeInfo() {
        if ((this.bitField0_ & 1024) != 1024) return false;
        return true;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo;
        if (this.sourceCodeInfoBuilder_ != null) return (DescriptorProtos$SourceCodeInfo)this.sourceCodeInfoBuilder_.getMessage();
        if (this.sourceCodeInfo_ == null) {
            descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
            return descriptorProtos$SourceCodeInfo;
        }
        descriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        return descriptorProtos$SourceCodeInfo;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        if (this.sourceCodeInfoBuilder_ == null) {
            if (descriptorProtos$SourceCodeInfo == null) {
                throw new NullPointerException();
            }
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo;
            this.onChanged();
        } else {
            this.sourceCodeInfoBuilder_.setMessage(descriptorProtos$SourceCodeInfo);
        }
        this.bitField0_ |= 1024;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(DescriptorProtos$SourceCodeInfo$Builder descriptorProtos$SourceCodeInfo$Builder) {
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo$Builder.build();
            this.onChanged();
        } else {
            this.sourceCodeInfoBuilder_.setMessage(descriptorProtos$SourceCodeInfo$Builder.build());
        }
        this.bitField0_ |= 1024;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder mergeSourceCodeInfo(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = (this.bitField0_ & 1024) == 1024 && this.sourceCodeInfo_ != null && this.sourceCodeInfo_ != DescriptorProtos$SourceCodeInfo.getDefaultInstance() ? DescriptorProtos$SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(descriptorProtos$SourceCodeInfo).buildPartial() : descriptorProtos$SourceCodeInfo;
            this.onChanged();
        } else {
            this.sourceCodeInfoBuilder_.mergeFrom(descriptorProtos$SourceCodeInfo);
        }
        this.bitField0_ |= 1024;
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearSourceCodeInfo() {
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = null;
            this.onChanged();
        } else {
            this.sourceCodeInfoBuilder_.clear();
        }
        this.bitField0_ &= -1025;
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder getSourceCodeInfoBuilder() {
        this.bitField0_ |= 1024;
        this.onChanged();
        return (DescriptorProtos$SourceCodeInfo$Builder)this.getSourceCodeInfoFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo;
        if (this.sourceCodeInfoBuilder_ != null) {
            return (DescriptorProtos$SourceCodeInfoOrBuilder)this.sourceCodeInfoBuilder_.getMessageOrBuilder();
        }
        if (this.sourceCodeInfo_ == null) {
            descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
            return descriptorProtos$SourceCodeInfo;
        }
        descriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        return descriptorProtos$SourceCodeInfo;
    }

    private SingleFieldBuilder getSourceCodeInfoFieldBuilder() {
        if (this.sourceCodeInfoBuilder_ != null) return this.sourceCodeInfoBuilder_;
        this.sourceCodeInfoBuilder_ = new SingleFieldBuilder(this.getSourceCodeInfo(), this.getParentForChildren(), this.isClean());
        this.sourceCodeInfo_ = null;
        return this.sourceCodeInfoBuilder_;
    }

    @Override
    public boolean hasSyntax() {
        if ((this.bitField0_ & 2048) != 2048) return false;
        return true;
    }

    @Override
    public String getSyntax() {
        Object object = this.syntax_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.syntax_ = string;
        return string;
    }

    @Override
    public ByteString getSyntaxBytes() {
        ByteString byteString;
        Object object = this.syntax_;
        if (!(object instanceof String)) return (ByteString)object;
        this.syntax_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSyntax(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2048;
        this.syntax_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder clearSyntax() {
        this.bitField0_ &= -2049;
        this.syntax_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getSyntax();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder setSyntaxBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2048;
        this.syntax_ = byteString;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$FileDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

