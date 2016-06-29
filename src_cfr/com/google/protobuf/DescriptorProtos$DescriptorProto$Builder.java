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
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$DescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private List field_ = Collections.emptyList();
    private RepeatedFieldBuilder fieldBuilder_;
    private List extension_ = Collections.emptyList();
    private RepeatedFieldBuilder extensionBuilder_;
    private List nestedType_ = Collections.emptyList();
    private RepeatedFieldBuilder nestedTypeBuilder_;
    private List enumType_ = Collections.emptyList();
    private RepeatedFieldBuilder enumTypeBuilder_;
    private List extensionRange_ = Collections.emptyList();
    private RepeatedFieldBuilder extensionRangeBuilder_;
    private List oneofDecl_ = Collections.emptyList();
    private RepeatedFieldBuilder oneofDeclBuilder_;
    private DescriptorProtos$MessageOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;
    private List reservedRange_ = Collections.emptyList();
    private RepeatedFieldBuilder reservedRangeBuilder_;
    private LazyStringList reservedName_ = LazyStringArrayList.EMPTY;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2600();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2700().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
    }

    private DescriptorProtos$DescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$DescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getFieldFieldBuilder();
        this.getExtensionFieldBuilder();
        this.getNestedTypeFieldBuilder();
        this.getEnumTypeFieldBuilder();
        this.getExtensionRangeFieldBuilder();
        this.getOneofDeclFieldBuilder();
        this.getOptionsFieldBuilder();
        this.getReservedRangeFieldBuilder();
    }

    @Override
    public DescriptorProtos$DescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        if (this.fieldBuilder_ == null) {
            this.field_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.fieldBuilder_.clear();
        }
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= -5;
        } else {
            this.extensionBuilder_.clear();
        }
        if (this.nestedTypeBuilder_ == null) {
            this.nestedType_ = Collections.emptyList();
            this.bitField0_ &= -9;
        } else {
            this.nestedTypeBuilder_.clear();
        }
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= -17;
        } else {
            this.enumTypeBuilder_.clear();
        }
        if (this.extensionRangeBuilder_ == null) {
            this.extensionRange_ = Collections.emptyList();
            this.bitField0_ &= -33;
        } else {
            this.extensionRangeBuilder_.clear();
        }
        if (this.oneofDeclBuilder_ == null) {
            this.oneofDecl_ = Collections.emptyList();
            this.bitField0_ &= -65;
        } else {
            this.oneofDeclBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -129;
        if (this.reservedRangeBuilder_ == null) {
            this.reservedRange_ = Collections.emptyList();
            this.bitField0_ &= -257;
        } else {
            this.reservedRangeBuilder_.clear();
        }
        this.reservedName_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -513;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$2600();
    }

    @Override
    public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$DescriptorProto build() {
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = this.buildPartial();
        if (descriptorProtos$DescriptorProto.isInitialized()) return descriptorProtos$DescriptorProto;
        throw DescriptorProtos$DescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$DescriptorProto);
    }

    @Override
    public DescriptorProtos$DescriptorProto buildPartial() {
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = new DescriptorProtos$DescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$DescriptorProto.access$4902(descriptorProtos$DescriptorProto, this.name_);
        if (this.fieldBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.field_ = Collections.unmodifiableList(this.field_);
                this.bitField0_ &= -3;
            }
            DescriptorProtos$DescriptorProto.access$5002(descriptorProtos$DescriptorProto, this.field_);
        } else {
            DescriptorProtos$DescriptorProto.access$5002(descriptorProtos$DescriptorProto, this.fieldBuilder_.build());
        }
        if (this.extensionBuilder_ == null) {
            if ((this.bitField0_ & 4) == 4) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
                this.bitField0_ &= -5;
            }
            DescriptorProtos$DescriptorProto.access$5102(descriptorProtos$DescriptorProto, this.extension_);
        } else {
            DescriptorProtos$DescriptorProto.access$5102(descriptorProtos$DescriptorProto, this.extensionBuilder_.build());
        }
        if (this.nestedTypeBuilder_ == null) {
            if ((this.bitField0_ & 8) == 8) {
                this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                this.bitField0_ &= -9;
            }
            DescriptorProtos$DescriptorProto.access$5202(descriptorProtos$DescriptorProto, this.nestedType_);
        } else {
            DescriptorProtos$DescriptorProto.access$5202(descriptorProtos$DescriptorProto, this.nestedTypeBuilder_.build());
        }
        if (this.enumTypeBuilder_ == null) {
            if ((this.bitField0_ & 16) == 16) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
                this.bitField0_ &= -17;
            }
            DescriptorProtos$DescriptorProto.access$5302(descriptorProtos$DescriptorProto, this.enumType_);
        } else {
            DescriptorProtos$DescriptorProto.access$5302(descriptorProtos$DescriptorProto, this.enumTypeBuilder_.build());
        }
        if (this.extensionRangeBuilder_ == null) {
            if ((this.bitField0_ & 32) == 32) {
                this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                this.bitField0_ &= -33;
            }
            DescriptorProtos$DescriptorProto.access$5402(descriptorProtos$DescriptorProto, this.extensionRange_);
        } else {
            DescriptorProtos$DescriptorProto.access$5402(descriptorProtos$DescriptorProto, this.extensionRangeBuilder_.build());
        }
        if (this.oneofDeclBuilder_ == null) {
            if ((this.bitField0_ & 64) == 64) {
                this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
                this.bitField0_ &= -65;
            }
            DescriptorProtos$DescriptorProto.access$5502(descriptorProtos$DescriptorProto, this.oneofDecl_);
        } else {
            DescriptorProtos$DescriptorProto.access$5502(descriptorProtos$DescriptorProto, this.oneofDeclBuilder_.build());
        }
        if ((n2 & 128) == 128) {
            n3 |= 2;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$DescriptorProto.access$5602(descriptorProtos$DescriptorProto, this.options_);
        } else {
            DescriptorProtos$DescriptorProto.access$5602(descriptorProtos$DescriptorProto, (DescriptorProtos$MessageOptions)this.optionsBuilder_.build());
        }
        if (this.reservedRangeBuilder_ == null) {
            if ((this.bitField0_ & 256) == 256) {
                this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
                this.bitField0_ &= -257;
            }
            DescriptorProtos$DescriptorProto.access$5702(descriptorProtos$DescriptorProto, this.reservedRange_);
        } else {
            DescriptorProtos$DescriptorProto.access$5702(descriptorProtos$DescriptorProto, this.reservedRangeBuilder_.build());
        }
        if ((this.bitField0_ & 512) == 512) {
            this.reservedName_ = this.reservedName_.getUnmodifiableView();
            this.bitField0_ &= -513;
        }
        DescriptorProtos$DescriptorProto.access$5802(descriptorProtos$DescriptorProto, this.reservedName_);
        DescriptorProtos$DescriptorProto.access$5902(descriptorProtos$DescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$DescriptorProto;
    }

    @Override
    public DescriptorProtos$DescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$DescriptorProto) {
            return this.mergeFrom((DescriptorProtos$DescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder mergeFrom(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (descriptorProtos$DescriptorProto == DescriptorProtos$DescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$DescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$DescriptorProto.access$4900(descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        if (this.fieldBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5000(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.field_.isEmpty()) {
                    this.field_ = DescriptorProtos$DescriptorProto.access$5000(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureFieldIsMutable();
                    this.field_.addAll(DescriptorProtos$DescriptorProto.access$5000(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5000(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.fieldBuilder_.isEmpty()) {
                this.fieldBuilder_.dispose();
                this.fieldBuilder_ = null;
                this.field_ = DescriptorProtos$DescriptorProto.access$5000(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -3;
                this.fieldBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getFieldFieldBuilder() : null;
            } else {
                this.fieldBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5000(descriptorProtos$DescriptorProto));
            }
        }
        if (this.extensionBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5100(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.extension_.isEmpty()) {
                    this.extension_ = DescriptorProtos$DescriptorProto.access$5100(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -5;
                } else {
                    this.ensureExtensionIsMutable();
                    this.extension_.addAll(DescriptorProtos$DescriptorProto.access$5100(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5100(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.extensionBuilder_.isEmpty()) {
                this.extensionBuilder_.dispose();
                this.extensionBuilder_ = null;
                this.extension_ = DescriptorProtos$DescriptorProto.access$5100(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -5;
                this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getExtensionFieldBuilder() : null;
            } else {
                this.extensionBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5100(descriptorProtos$DescriptorProto));
            }
        }
        if (this.nestedTypeBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5200(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.nestedType_.isEmpty()) {
                    this.nestedType_ = DescriptorProtos$DescriptorProto.access$5200(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -9;
                } else {
                    this.ensureNestedTypeIsMutable();
                    this.nestedType_.addAll(DescriptorProtos$DescriptorProto.access$5200(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5200(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.nestedTypeBuilder_.isEmpty()) {
                this.nestedTypeBuilder_.dispose();
                this.nestedTypeBuilder_ = null;
                this.nestedType_ = DescriptorProtos$DescriptorProto.access$5200(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -9;
                this.nestedTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getNestedTypeFieldBuilder() : null;
            } else {
                this.nestedTypeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5200(descriptorProtos$DescriptorProto));
            }
        }
        if (this.enumTypeBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5300(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.enumType_.isEmpty()) {
                    this.enumType_ = DescriptorProtos$DescriptorProto.access$5300(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -17;
                } else {
                    this.ensureEnumTypeIsMutable();
                    this.enumType_.addAll(DescriptorProtos$DescriptorProto.access$5300(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5300(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.enumTypeBuilder_.isEmpty()) {
                this.enumTypeBuilder_.dispose();
                this.enumTypeBuilder_ = null;
                this.enumType_ = DescriptorProtos$DescriptorProto.access$5300(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -17;
                this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getEnumTypeFieldBuilder() : null;
            } else {
                this.enumTypeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5300(descriptorProtos$DescriptorProto));
            }
        }
        if (this.extensionRangeBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5400(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.extensionRange_.isEmpty()) {
                    this.extensionRange_ = DescriptorProtos$DescriptorProto.access$5400(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -33;
                } else {
                    this.ensureExtensionRangeIsMutable();
                    this.extensionRange_.addAll(DescriptorProtos$DescriptorProto.access$5400(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5400(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.extensionRangeBuilder_.isEmpty()) {
                this.extensionRangeBuilder_.dispose();
                this.extensionRangeBuilder_ = null;
                this.extensionRange_ = DescriptorProtos$DescriptorProto.access$5400(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -33;
                this.extensionRangeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getExtensionRangeFieldBuilder() : null;
            } else {
                this.extensionRangeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5400(descriptorProtos$DescriptorProto));
            }
        }
        if (this.oneofDeclBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5500(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.oneofDecl_.isEmpty()) {
                    this.oneofDecl_ = DescriptorProtos$DescriptorProto.access$5500(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -65;
                } else {
                    this.ensureOneofDeclIsMutable();
                    this.oneofDecl_.addAll(DescriptorProtos$DescriptorProto.access$5500(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5500(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.oneofDeclBuilder_.isEmpty()) {
                this.oneofDeclBuilder_.dispose();
                this.oneofDeclBuilder_ = null;
                this.oneofDecl_ = DescriptorProtos$DescriptorProto.access$5500(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -65;
                this.oneofDeclBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOneofDeclFieldBuilder() : null;
            } else {
                this.oneofDeclBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5500(descriptorProtos$DescriptorProto));
            }
        }
        if (descriptorProtos$DescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$DescriptorProto.getOptions());
        }
        if (this.reservedRangeBuilder_ == null) {
            if (!DescriptorProtos$DescriptorProto.access$5700(descriptorProtos$DescriptorProto).isEmpty()) {
                if (this.reservedRange_.isEmpty()) {
                    this.reservedRange_ = DescriptorProtos$DescriptorProto.access$5700(descriptorProtos$DescriptorProto);
                    this.bitField0_ &= -257;
                } else {
                    this.ensureReservedRangeIsMutable();
                    this.reservedRange_.addAll(DescriptorProtos$DescriptorProto.access$5700(descriptorProtos$DescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$DescriptorProto.access$5700(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.reservedRangeBuilder_.isEmpty()) {
                this.reservedRangeBuilder_.dispose();
                this.reservedRangeBuilder_ = null;
                this.reservedRange_ = DescriptorProtos$DescriptorProto.access$5700(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -257;
                this.reservedRangeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getReservedRangeFieldBuilder() : null;
            } else {
                this.reservedRangeBuilder_.addAllMessages(DescriptorProtos$DescriptorProto.access$5700(descriptorProtos$DescriptorProto));
            }
        }
        if (!DescriptorProtos$DescriptorProto.access$5800(descriptorProtos$DescriptorProto).isEmpty()) {
            if (this.reservedName_.isEmpty()) {
                this.reservedName_ = DescriptorProtos$DescriptorProto.access$5800(descriptorProtos$DescriptorProto);
                this.bitField0_ &= -513;
            } else {
                this.ensureReservedNameIsMutable();
                this.reservedName_.addAll(DescriptorProtos$DescriptorProto.access$5800(descriptorProtos$DescriptorProto));
            }
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$DescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2;
        for (n2 = 0; n2 < this.getFieldCount(); ++n2) {
            if (this.getField(n2).isInitialized()) continue;
            return false;
        }
        for (n2 = 0; n2 < this.getExtensionCount(); ++n2) {
            if (this.getExtension(n2).isInitialized()) continue;
            return false;
        }
        for (n2 = 0; n2 < this.getNestedTypeCount(); ++n2) {
            if (this.getNestedType(n2).isInitialized()) continue;
            return false;
        }
        n2 = 0;
        do {
            if (n2 >= this.getEnumTypeCount()) {
                if (!this.hasOptions()) return true;
                if (this.getOptions().isInitialized()) return true;
                return false;
            }
            if (!this.getEnumType(n2).isInitialized()) {
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public DescriptorProtos$DescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = null;
        try {
            try {
                descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$DescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$DescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$DescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$DescriptorProto);
            throw var5_7;
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

    public DescriptorProtos$DescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$DescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureFieldIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.field_ = new ArrayList(this.field_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getFieldList() {
        if (this.fieldBuilder_ != null) return this.fieldBuilder_.getMessageList();
        return Collections.unmodifiableList(this.field_);
    }

    @Override
    public int getFieldCount() {
        if (this.fieldBuilder_ != null) return this.fieldBuilder_.getCount();
        return this.field_.size();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto getField(int n2) {
        if (this.fieldBuilder_ != null) return (DescriptorProtos$FieldDescriptorProto)this.fieldBuilder_.getMessage(n2);
        return (DescriptorProtos$FieldDescriptorProto)this.field_.get(n2);
    }

    public DescriptorProtos$DescriptorProto$Builder setField(int n2, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.fieldBuilder_ != null) {
            this.fieldBuilder_.setMessage(n2, descriptorProtos$FieldDescriptorProto);
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureFieldIsMutable();
        this.field_.set(n2, descriptorProtos$FieldDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setField(int n2, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.set(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.fieldBuilder_.setMessage(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.fieldBuilder_ != null) {
            this.fieldBuilder_.addMessage(descriptorProtos$FieldDescriptorProto);
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureFieldIsMutable();
        this.field_.add(descriptorProtos$FieldDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(int n2, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.fieldBuilder_ != null) {
            this.fieldBuilder_.addMessage(n2, descriptorProtos$FieldDescriptorProto);
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureFieldIsMutable();
        this.field_.add(n2, descriptorProtos$FieldDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.add(descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.fieldBuilder_.addMessage(descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addField(int n2, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.add(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.fieldBuilder_.addMessage(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllField(Iterable iterable) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.field_);
            this.onChanged();
            return this;
        }
        this.fieldBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearField() {
        if (this.fieldBuilder_ == null) {
            this.field_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.fieldBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeField(int n2) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.remove(n2);
            this.onChanged();
            return this;
        }
        this.fieldBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder getFieldBuilder(int n2) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int n2) {
        if (this.fieldBuilder_ != null) return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.fieldBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.field_.get(n2);
    }

    @Override
    public List getFieldOrBuilderList() {
        if (this.fieldBuilder_ == null) return Collections.unmodifiableList(this.field_);
        return this.fieldBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder() {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().addBuilder(DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder(int n2) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().addBuilder(n2, DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }

    public List getFieldBuilderList() {
        return this.getFieldFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getFieldFieldBuilder() {
        if (this.fieldBuilder_ != null) return this.fieldBuilder_;
        this.fieldBuilder_ = new RepeatedFieldBuilder(this.field_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.field_ = null;
        return this.fieldBuilder_;
    }

    private void ensureExtensionIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.extension_ = new ArrayList(this.extension_);
        this.bitField0_ |= 4;
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

    public DescriptorProtos$DescriptorProto$Builder setExtension(int n2, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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

    public DescriptorProtos$DescriptorProto$Builder setExtension(int n2, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.set(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.setMessage(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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

    public DescriptorProtos$DescriptorProto$Builder addExtension(int n2, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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

    public DescriptorProtos$DescriptorProto$Builder addExtension(DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.add(descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.addMessage(descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtension(int n2, DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.add(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.addMessage(n2, descriptorProtos$FieldDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllExtension(Iterable iterable) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.extension_);
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearExtension() {
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
            return this;
        }
        this.extensionBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeExtension(int n2) {
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
        this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
        this.extension_ = null;
        return this.extensionBuilder_;
    }

    private void ensureNestedTypeIsMutable() {
        if ((this.bitField0_ & 8) == 8) return;
        this.nestedType_ = new ArrayList(this.nestedType_);
        this.bitField0_ |= 8;
    }

    @Override
    public List getNestedTypeList() {
        if (this.nestedTypeBuilder_ != null) return this.nestedTypeBuilder_.getMessageList();
        return Collections.unmodifiableList(this.nestedType_);
    }

    @Override
    public int getNestedTypeCount() {
        if (this.nestedTypeBuilder_ != null) return this.nestedTypeBuilder_.getCount();
        return this.nestedType_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto getNestedType(int n2) {
        if (this.nestedTypeBuilder_ != null) return (DescriptorProtos$DescriptorProto)this.nestedTypeBuilder_.getMessage(n2);
        return (DescriptorProtos$DescriptorProto)this.nestedType_.get(n2);
    }

    public DescriptorProtos$DescriptorProto$Builder setNestedType(int n2, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.nestedTypeBuilder_ != null) {
            this.nestedTypeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto);
            return this;
        }
        if (descriptorProtos$DescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureNestedTypeIsMutable();
        this.nestedType_.set(n2, descriptorProtos$DescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setNestedType(int n2, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.set(n2, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.nestedTypeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.nestedTypeBuilder_ != null) {
            this.nestedTypeBuilder_.addMessage(descriptorProtos$DescriptorProto);
            return this;
        }
        if (descriptorProtos$DescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureNestedTypeIsMutable();
        this.nestedType_.add(descriptorProtos$DescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(int n2, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.nestedTypeBuilder_ != null) {
            this.nestedTypeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto);
            return this;
        }
        if (descriptorProtos$DescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureNestedTypeIsMutable();
        this.nestedType_.add(n2, descriptorProtos$DescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.add(descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.nestedTypeBuilder_.addMessage(descriptorProtos$DescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedType(int n2, DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.add(n2, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.nestedTypeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllNestedType(Iterable iterable) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.nestedType_);
            this.onChanged();
            return this;
        }
        this.nestedTypeBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearNestedType() {
        if (this.nestedTypeBuilder_ == null) {
            this.nestedType_ = Collections.emptyList();
            this.bitField0_ &= -9;
            this.onChanged();
            return this;
        }
        this.nestedTypeBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeNestedType(int n2) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.remove(n2);
            this.onChanged();
            return this;
        }
        this.nestedTypeBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder getNestedTypeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int n2) {
        if (this.nestedTypeBuilder_ != null) return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedTypeBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedType_.get(n2);
    }

    @Override
    public List getNestedTypeOrBuilderList() {
        if (this.nestedTypeBuilder_ == null) return Collections.unmodifiableList(this.nestedType_);
        return this.nestedTypeBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder() {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().addBuilder(n2, DescriptorProtos$DescriptorProto.getDefaultInstance());
    }

    public List getNestedTypeBuilderList() {
        return this.getNestedTypeFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getNestedTypeFieldBuilder() {
        if (this.nestedTypeBuilder_ != null) return this.nestedTypeBuilder_;
        this.nestedTypeBuilder_ = new RepeatedFieldBuilder(this.nestedType_, (this.bitField0_ & 8) == 8, this.getParentForChildren(), this.isClean());
        this.nestedType_ = null;
        return this.nestedTypeBuilder_;
    }

    private void ensureEnumTypeIsMutable() {
        if ((this.bitField0_ & 16) == 16) return;
        this.enumType_ = new ArrayList(this.enumType_);
        this.bitField0_ |= 16;
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

    public DescriptorProtos$DescriptorProto$Builder setEnumType(int n2, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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

    public DescriptorProtos$DescriptorProto$Builder setEnumType(int n2, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.set(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.setMessage(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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

    public DescriptorProtos$DescriptorProto$Builder addEnumType(int n2, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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

    public DescriptorProtos$DescriptorProto$Builder addEnumType(DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.addMessage(descriptorProtos$EnumDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addEnumType(int n2, DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.addMessage(n2, descriptorProtos$EnumDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllEnumType(Iterable iterable) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.enumType_);
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearEnumType() {
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= -17;
            this.onChanged();
            return this;
        }
        this.enumTypeBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeEnumType(int n2) {
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
        this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 16) == 16, this.getParentForChildren(), this.isClean());
        this.enumType_ = null;
        return this.enumTypeBuilder_;
    }

    private void ensureExtensionRangeIsMutable() {
        if ((this.bitField0_ & 32) == 32) return;
        this.extensionRange_ = new ArrayList(this.extensionRange_);
        this.bitField0_ |= 32;
    }

    @Override
    public List getExtensionRangeList() {
        if (this.extensionRangeBuilder_ != null) return this.extensionRangeBuilder_.getMessageList();
        return Collections.unmodifiableList(this.extensionRange_);
    }

    @Override
    public int getExtensionRangeCount() {
        if (this.extensionRangeBuilder_ != null) return this.extensionRangeBuilder_.getCount();
        return this.extensionRange_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int n2) {
        if (this.extensionRangeBuilder_ != null) return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRangeBuilder_.getMessage(n2);
        return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRange_.get(n2);
    }

    public DescriptorProtos$DescriptorProto$Builder setExtensionRange(int n2, DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (this.extensionRangeBuilder_ != null) {
            this.extensionRangeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto$ExtensionRange);
            return this;
        }
        if (descriptorProtos$DescriptorProto$ExtensionRange == null) {
            throw new NullPointerException();
        }
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.set(n2, descriptorProtos$DescriptorProto$ExtensionRange);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setExtensionRange(int n2, DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.set(n2, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionRangeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (this.extensionRangeBuilder_ != null) {
            this.extensionRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ExtensionRange);
            return this;
        }
        if (descriptorProtos$DescriptorProto$ExtensionRange == null) {
            throw new NullPointerException();
        }
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.add(descriptorProtos$DescriptorProto$ExtensionRange);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(int n2, DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (this.extensionRangeBuilder_ != null) {
            this.extensionRangeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto$ExtensionRange);
            return this;
        }
        if (descriptorProtos$DescriptorProto$ExtensionRange == null) {
            throw new NullPointerException();
        }
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.add(n2, descriptorProtos$DescriptorProto$ExtensionRange);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.add(descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(int n2, DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.add(n2, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
            this.onChanged();
            return this;
        }
        this.extensionRangeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllExtensionRange(Iterable iterable) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.extensionRange_);
            this.onChanged();
            return this;
        }
        this.extensionRangeBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearExtensionRange() {
        if (this.extensionRangeBuilder_ == null) {
            this.extensionRange_ = Collections.emptyList();
            this.bitField0_ &= -33;
            this.onChanged();
            return this;
        }
        this.extensionRangeBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeExtensionRange(int n2) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.remove(n2);
            this.onChanged();
            return this;
        }
        this.extensionRangeBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder getExtensionRangeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int n2) {
        if (this.extensionRangeBuilder_ != null) return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRangeBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRange_.get(n2);
    }

    @Override
    public List getExtensionRangeOrBuilderList() {
        if (this.extensionRangeBuilder_ == null) return Collections.unmodifiableList(this.extensionRange_);
        return this.extensionRangeBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder() {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance());
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().addBuilder(n2, DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance());
    }

    public List getExtensionRangeBuilderList() {
        return this.getExtensionRangeFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getExtensionRangeFieldBuilder() {
        if (this.extensionRangeBuilder_ != null) return this.extensionRangeBuilder_;
        this.extensionRangeBuilder_ = new RepeatedFieldBuilder(this.extensionRange_, (this.bitField0_ & 32) == 32, this.getParentForChildren(), this.isClean());
        this.extensionRange_ = null;
        return this.extensionRangeBuilder_;
    }

    private void ensureOneofDeclIsMutable() {
        if ((this.bitField0_ & 64) == 64) return;
        this.oneofDecl_ = new ArrayList(this.oneofDecl_);
        this.bitField0_ |= 64;
    }

    @Override
    public List getOneofDeclList() {
        if (this.oneofDeclBuilder_ != null) return this.oneofDeclBuilder_.getMessageList();
        return Collections.unmodifiableList(this.oneofDecl_);
    }

    @Override
    public int getOneofDeclCount() {
        if (this.oneofDeclBuilder_ != null) return this.oneofDeclBuilder_.getCount();
        return this.oneofDecl_.size();
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto getOneofDecl(int n2) {
        if (this.oneofDeclBuilder_ != null) return (DescriptorProtos$OneofDescriptorProto)this.oneofDeclBuilder_.getMessage(n2);
        return (DescriptorProtos$OneofDescriptorProto)this.oneofDecl_.get(n2);
    }

    public DescriptorProtos$DescriptorProto$Builder setOneofDecl(int n2, DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (this.oneofDeclBuilder_ != null) {
            this.oneofDeclBuilder_.setMessage(n2, descriptorProtos$OneofDescriptorProto);
            return this;
        }
        if (descriptorProtos$OneofDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.set(n2, descriptorProtos$OneofDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setOneofDecl(int n2, DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.set(n2, descriptorProtos$OneofDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.oneofDeclBuilder_.setMessage(n2, descriptorProtos$OneofDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (this.oneofDeclBuilder_ != null) {
            this.oneofDeclBuilder_.addMessage(descriptorProtos$OneofDescriptorProto);
            return this;
        }
        if (descriptorProtos$OneofDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.add(descriptorProtos$OneofDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(int n2, DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (this.oneofDeclBuilder_ != null) {
            this.oneofDeclBuilder_.addMessage(n2, descriptorProtos$OneofDescriptorProto);
            return this;
        }
        if (descriptorProtos$OneofDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.add(n2, descriptorProtos$OneofDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.add(descriptorProtos$OneofDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.oneofDeclBuilder_.addMessage(descriptorProtos$OneofDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(int n2, DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.add(n2, descriptorProtos$OneofDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.oneofDeclBuilder_.addMessage(n2, descriptorProtos$OneofDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllOneofDecl(Iterable iterable) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.oneofDecl_);
            this.onChanged();
            return this;
        }
        this.oneofDeclBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearOneofDecl() {
        if (this.oneofDeclBuilder_ == null) {
            this.oneofDecl_ = Collections.emptyList();
            this.bitField0_ &= -65;
            this.onChanged();
            return this;
        }
        this.oneofDeclBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeOneofDecl(int n2) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.remove(n2);
            this.onChanged();
            return this;
        }
        this.oneofDeclBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder getOneofDeclBuilder(int n2) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int n2) {
        if (this.oneofDeclBuilder_ != null) return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDeclBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(n2);
    }

    @Override
    public List getOneofDeclOrBuilderList() {
        if (this.oneofDeclBuilder_ == null) return Collections.unmodifiableList(this.oneofDecl_);
        return this.oneofDeclBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder() {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().addBuilder(DescriptorProtos$OneofDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder(int n2) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().addBuilder(n2, DescriptorProtos$OneofDescriptorProto.getDefaultInstance());
    }

    public List getOneofDeclBuilderList() {
        return this.getOneofDeclFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getOneofDeclFieldBuilder() {
        if (this.oneofDeclBuilder_ != null) return this.oneofDeclBuilder_;
        this.oneofDeclBuilder_ = new RepeatedFieldBuilder(this.oneofDecl_, (this.bitField0_ & 64) == 64, this.getParentForChildren(), this.isClean());
        this.oneofDecl_ = null;
        return this.oneofDeclBuilder_;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 128) != 128) return false;
        return true;
    }

    @Override
    public DescriptorProtos$MessageOptions getOptions() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$MessageOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.getDefaultInstance();
            return descriptorProtos$MessageOptions;
        }
        descriptorProtos$MessageOptions = this.options_;
        return descriptorProtos$MessageOptions;
    }

    public DescriptorProtos$DescriptorProto$Builder setOptions(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$MessageOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$MessageOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$MessageOptions);
        }
        this.bitField0_ |= 128;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setOptions(DescriptorProtos$MessageOptions$Builder descriptorProtos$MessageOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$MessageOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$MessageOptions$Builder.build());
        }
        this.bitField0_ |= 128;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder mergeOptions(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 128) == 128 && this.options_ != null && this.options_ != DescriptorProtos$MessageOptions.getDefaultInstance() ? DescriptorProtos$MessageOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$MessageOptions).buildPartial() : descriptorProtos$MessageOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$MessageOptions);
        }
        this.bitField0_ |= 128;
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -129;
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 128;
        this.onChanged();
        return (DescriptorProtos$MessageOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$MessageOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.getDefaultInstance();
            return descriptorProtos$MessageOptions;
        }
        descriptorProtos$MessageOptions = this.options_;
        return descriptorProtos$MessageOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    private void ensureReservedRangeIsMutable() {
        if ((this.bitField0_ & 256) == 256) return;
        this.reservedRange_ = new ArrayList(this.reservedRange_);
        this.bitField0_ |= 256;
    }

    @Override
    public List getReservedRangeList() {
        if (this.reservedRangeBuilder_ != null) return this.reservedRangeBuilder_.getMessageList();
        return Collections.unmodifiableList(this.reservedRange_);
    }

    @Override
    public int getReservedRangeCount() {
        if (this.reservedRangeBuilder_ != null) return this.reservedRangeBuilder_.getCount();
        return this.reservedRange_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int n2) {
        if (this.reservedRangeBuilder_ != null) return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRangeBuilder_.getMessage(n2);
        return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRange_.get(n2);
    }

    public DescriptorProtos$DescriptorProto$Builder setReservedRange(int n2, DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (this.reservedRangeBuilder_ != null) {
            this.reservedRangeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto$ReservedRange);
            return this;
        }
        if (descriptorProtos$DescriptorProto$ReservedRange == null) {
            throw new NullPointerException();
        }
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.set(n2, descriptorProtos$DescriptorProto$ReservedRange);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder setReservedRange(int n2, DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.set(n2, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
            this.onChanged();
            return this;
        }
        this.reservedRangeBuilder_.setMessage(n2, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (this.reservedRangeBuilder_ != null) {
            this.reservedRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ReservedRange);
            return this;
        }
        if (descriptorProtos$DescriptorProto$ReservedRange == null) {
            throw new NullPointerException();
        }
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.add(descriptorProtos$DescriptorProto$ReservedRange);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(int n2, DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (this.reservedRangeBuilder_ != null) {
            this.reservedRangeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto$ReservedRange);
            return this;
        }
        if (descriptorProtos$DescriptorProto$ReservedRange == null) {
            throw new NullPointerException();
        }
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.add(n2, descriptorProtos$DescriptorProto$ReservedRange);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.add(descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
            this.onChanged();
            return this;
        }
        this.reservedRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedRange(int n2, DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.add(n2, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
            this.onChanged();
            return this;
        }
        this.reservedRangeBuilder_.addMessage(n2, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllReservedRange(Iterable iterable) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.reservedRange_);
            this.onChanged();
            return this;
        }
        this.reservedRangeBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearReservedRange() {
        if (this.reservedRangeBuilder_ == null) {
            this.reservedRange_ = Collections.emptyList();
            this.bitField0_ &= -257;
            this.onChanged();
            return this;
        }
        this.reservedRangeBuilder_.clear();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder removeReservedRange(int n2) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.remove(n2);
            this.onChanged();
            return this;
        }
        this.reservedRangeBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder getReservedRangeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int n2) {
        if (this.reservedRangeBuilder_ != null) return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRangeBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRange_.get(n2);
    }

    @Override
    public List getReservedRangeOrBuilderList() {
        if (this.reservedRangeBuilder_ == null) return Collections.unmodifiableList(this.reservedRange_);
        return this.reservedRangeBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder() {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance());
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().addBuilder(n2, DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance());
    }

    public List getReservedRangeBuilderList() {
        return this.getReservedRangeFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getReservedRangeFieldBuilder() {
        if (this.reservedRangeBuilder_ != null) return this.reservedRangeBuilder_;
        this.reservedRangeBuilder_ = new RepeatedFieldBuilder(this.reservedRange_, (this.bitField0_ & 256) == 256, this.getParentForChildren(), this.isClean());
        this.reservedRange_ = null;
        return this.reservedRangeBuilder_;
    }

    private void ensureReservedNameIsMutable() {
        if ((this.bitField0_ & 512) == 512) return;
        this.reservedName_ = new LazyStringArrayList(this.reservedName_);
        this.bitField0_ |= 512;
    }

    @Override
    public ProtocolStringList getReservedNameList() {
        return this.reservedName_.getUnmodifiableView();
    }

    @Override
    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    @Override
    public String getReservedName(int n2) {
        return (String)this.reservedName_.get(n2);
    }

    @Override
    public ByteString getReservedNameBytes(int n2) {
        return this.reservedName_.getByteString(n2);
    }

    public DescriptorProtos$DescriptorProto$Builder setReservedName(int n2, String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureReservedNameIsMutable();
        this.reservedName_.set(n2, string);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(string);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addAllReservedName(Iterable iterable) {
        this.ensureReservedNameIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.reservedName_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder clearReservedName() {
        this.reservedName_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -513;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$Builder addReservedNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(byteString);
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

