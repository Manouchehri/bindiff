/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Collections;
import java.util.List;

public final class Descriptors$FieldDescriptor
extends Descriptors$GenericDescriptor
implements FieldSet$FieldDescriptorLite,
Comparable {
    private static final WireFormat$FieldType[] table = WireFormat$FieldType.values();
    private final int index;
    private DescriptorProtos$FieldDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$Descriptor extensionScope;
    private Descriptors$FieldDescriptor$Type type;
    private Descriptors$Descriptor containingType;
    private Descriptors$Descriptor messageType;
    private Descriptors$OneofDescriptor containingOneof;
    private Descriptors$EnumDescriptor enumType;
    private Object defaultValue;

    public int getIndex() {
        return this.index;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto toProto() {
        return this.proto;
    }

    @Override
    public String getName() {
        return this.proto.getName();
    }

    @Override
    public int getNumber() {
        return this.proto.getNumber();
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    public Descriptors$FieldDescriptor$JavaType getJavaType() {
        return this.type.getJavaType();
    }

    @Override
    public WireFormat.JavaType getLiteJavaType() {
        return this.getLiteType().getJavaType();
    }

    @Override
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    public Descriptors$FieldDescriptor$Type getType() {
        return this.type;
    }

    @Override
    public WireFormat$FieldType getLiteType() {
        return table[this.type.ordinal()];
    }

    public boolean needsUtf8Check() {
        if (this.type != Descriptors$FieldDescriptor$Type.STRING) return false;
        if (!this.getFile().getOptions().getJavaStringCheckUtf8()) return false;
        return true;
    }

    public boolean isMapField() {
        if (this.getType() != Descriptors$FieldDescriptor$Type.MESSAGE) return false;
        if (!this.isRepeated()) return false;
        if (!this.getMessageType().getOptions().getMapEntry()) return false;
        return true;
    }

    public boolean isRequired() {
        if (this.proto.getLabel() != DescriptorProtos$FieldDescriptorProto$Label.LABEL_REQUIRED) return false;
        return true;
    }

    public boolean isOptional() {
        if (this.proto.getLabel() != DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL) return false;
        return true;
    }

    @Override
    public boolean isRepeated() {
        if (this.proto.getLabel() != DescriptorProtos$FieldDescriptorProto$Label.LABEL_REPEATED) return false;
        return true;
    }

    @Override
    public boolean isPacked() {
        if (!this.isPackable()) {
            return false;
        }
        if (this.getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO2) {
            return this.getOptions().getPacked();
        }
        if (!this.getOptions().hasPacked()) return true;
        if (this.getOptions().getPacked()) return true;
        return false;
    }

    public boolean isPackable() {
        if (!this.isRepeated()) return false;
        if (!this.getLiteType().isPackable()) return false;
        return true;
    }

    public boolean hasDefaultValue() {
        return this.proto.hasDefaultValue();
    }

    public Object getDefaultValue() {
        if (this.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return this.defaultValue;
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
    }

    public DescriptorProtos$FieldOptions getOptions() {
        return this.proto.getOptions();
    }

    public boolean isExtension() {
        return this.proto.hasExtendee();
    }

    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
    }

    public Descriptors$OneofDescriptor getContainingOneof() {
        return this.containingOneof;
    }

    public Descriptors$Descriptor getExtensionScope() {
        if (this.isExtension()) return this.extensionScope;
        throw new UnsupportedOperationException("This field is not an extension.");
    }

    public Descriptors$Descriptor getMessageType() {
        if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) return this.messageType;
        throw new UnsupportedOperationException("This field is not of message type.");
    }

    @Override
    public Descriptors$EnumDescriptor getEnumType() {
        if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) return this.enumType;
        throw new UnsupportedOperationException("This field is not of enum type.");
    }

    public int compareTo(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.containingType == this.containingType) return this.getNumber() - descriptors$FieldDescriptor.getNumber();
        throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
    }

    public String toString() {
        return this.getFullName();
    }

    private Descriptors$FieldDescriptor(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2, boolean bl2) {
        this.index = n2;
        this.proto = descriptorProtos$FieldDescriptorProto;
        this.fullName = Descriptors.access$1600(descriptors$FileDescriptor, descriptors$Descriptor, descriptorProtos$FieldDescriptorProto.getName());
        this.file = descriptors$FileDescriptor;
        if (descriptorProtos$FieldDescriptorProto.hasType()) {
            this.type = Descriptors$FieldDescriptor$Type.valueOf(descriptorProtos$FieldDescriptorProto.getType());
        }
        if (this.getNumber() <= 0) {
            throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Field numbers must be positive integers.", null);
        }
        if (bl2) {
            if (!descriptorProtos$FieldDescriptorProto.hasExtendee()) {
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "FieldDescriptorProto.extendee not set for extension field.", null);
            }
            this.containingType = null;
            this.extensionScope = descriptors$Descriptor != null ? descriptors$Descriptor : null;
            if (descriptorProtos$FieldDescriptorProto.hasOneofIndex()) {
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "FieldDescriptorProto.oneof_index set for extension field.", null);
            }
            this.containingOneof = null;
        } else {
            if (descriptorProtos$FieldDescriptorProto.hasExtendee()) {
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "FieldDescriptorProto.extendee set for non-extension field.", null);
            }
            this.containingType = descriptors$Descriptor;
            if (descriptorProtos$FieldDescriptorProto.hasOneofIndex()) {
                if (descriptorProtos$FieldDescriptorProto.getOneofIndex() < 0 || descriptorProtos$FieldDescriptorProto.getOneofIndex() >= descriptors$Descriptor.toProto().getOneofDeclCount()) {
                    String string;
                    String string2 = String.valueOf(descriptors$Descriptor.getName());
                    if (string2.length() != 0) {
                        string = "FieldDescriptorProto.oneof_index is out of range for type ".concat(string2);
                        throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, string, null);
                    }
                    string = new String("FieldDescriptorProto.oneof_index is out of range for type ");
                    throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, string, null);
                }
                this.containingOneof = (Descriptors$OneofDescriptor)descriptors$Descriptor.getOneofs().get(descriptorProtos$FieldDescriptorProto.getOneofIndex());
                Descriptors$OneofDescriptor.access$1908(this.containingOneof);
            } else {
                this.containingOneof = null;
            }
            this.extensionScope = null;
        }
        Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addSymbol(this);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void crossLink() {
        if (this.proto.hasExtendee()) {
            var1_1 = Descriptors$FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getExtendee(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
            if (!(var1_1 instanceof Descriptors$Descriptor)) {
                var2_4 = String.valueOf(String.valueOf(this.proto.getExtendee()));
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(25 + var2_4.length()).append("\"").append(var2_4).append("\" is not a message type.").toString(), null);
            }
            this.containingType = (Descriptors$Descriptor)var1_1;
            if (!this.getContainingType().isExtensionNumber(this.getNumber())) {
                var2_5 = String.valueOf(String.valueOf(this.getContainingType().getFullName()));
                var3_10 = this.getNumber();
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(55 + var2_5.length()).append("\"").append(var2_5).append("\" does not declare ").append(var3_10).append(" as an extension number.").toString(), null);
            }
        }
        if (this.proto.hasTypeName()) {
            var1_1 = Descriptors$FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getTypeName(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
            if (!this.proto.hasType()) {
                if (var1_1 instanceof Descriptors$Descriptor) {
                    this.type = Descriptors$FieldDescriptor$Type.MESSAGE;
                } else {
                    if (!(var1_1 instanceof Descriptors$EnumDescriptor)) {
                        var2_6 = String.valueOf(String.valueOf(this.proto.getTypeName()));
                        throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(17 + var2_6.length()).append("\"").append(var2_6).append("\" is not a type.").toString(), null);
                    }
                    this.type = Descriptors$FieldDescriptor$Type.ENUM;
                }
            }
            if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                if (!(var1_1 instanceof Descriptors$Descriptor)) {
                    var2_7 = String.valueOf(String.valueOf(this.proto.getTypeName()));
                    throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(25 + var2_7.length()).append("\"").append(var2_7).append("\" is not a message type.").toString(), null);
                }
                this.messageType = (Descriptors$Descriptor)var1_1;
                if (this.proto.hasDefaultValue()) {
                    throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Messages can't have default values.", null);
                }
            } else {
                if (this.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Field with primitive type has type_name.", null);
                if (!(var1_1 instanceof Descriptors$EnumDescriptor)) {
                    var2_8 = String.valueOf(String.valueOf(this.proto.getTypeName()));
                    throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(23 + var2_8.length()).append("\"").append(var2_8).append("\" is not an enum type.").toString(), null);
                }
                this.enumType = (Descriptors$EnumDescriptor)var1_1;
            }
        } else {
            if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Field with message or enum type missing type_name.", null);
            if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Field with message or enum type missing type_name.", null);
            }
        }
        if (this.proto.getOptions().getPacked() && !this.isPackable()) {
            throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "[packed = true] can only be specified for repeated primitive fields.", null);
        }
        if (this.proto.hasDefaultValue()) {
            if (this.isRepeated()) {
                throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Repeated fields cannot have default values.", null);
            }
            try {
                switch (Descriptors$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[this.getType().ordinal()]) {
                    case 1: 
                    case 2: 
                    case 3: {
                        this.defaultValue = TextFormat.parseInt32(this.proto.getDefaultValue());
                        break;
                    }
                    case 4: 
                    case 5: {
                        this.defaultValue = TextFormat.parseUInt32(this.proto.getDefaultValue());
                        break;
                    }
                    case 6: 
                    case 7: 
                    case 8: {
                        this.defaultValue = TextFormat.parseInt64(this.proto.getDefaultValue());
                        break;
                    }
                    case 9: 
                    case 10: {
                        this.defaultValue = TextFormat.parseUInt64(this.proto.getDefaultValue());
                        break;
                    }
                    case 11: {
                        if (this.proto.getDefaultValue().equals("inf")) {
                            this.defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);
                            break;
                        }
                        if (this.proto.getDefaultValue().equals("-inf")) {
                            this.defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);
                            break;
                        }
                        if (this.proto.getDefaultValue().equals("nan")) {
                            this.defaultValue = Float.valueOf(Float.NaN);
                            break;
                        }
                        this.defaultValue = Float.valueOf(this.proto.getDefaultValue());
                        break;
                    }
                    case 12: {
                        if (this.proto.getDefaultValue().equals("inf")) {
                            this.defaultValue = Double.POSITIVE_INFINITY;
                            break;
                        }
                        if (this.proto.getDefaultValue().equals("-inf")) {
                            this.defaultValue = Double.NEGATIVE_INFINITY;
                            break;
                        }
                        if (this.proto.getDefaultValue().equals("nan")) {
                            this.defaultValue = Double.NaN;
                            break;
                        }
                        this.defaultValue = Double.valueOf(this.proto.getDefaultValue());
                        break;
                    }
                    case 13: {
                        this.defaultValue = Boolean.valueOf(this.proto.getDefaultValue());
                        break;
                    }
                    case 14: {
                        this.defaultValue = this.proto.getDefaultValue();
                        break;
                    }
                    case 15: {
                        try {
                            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());
                            break;
                        }
                        catch (TextFormat$InvalidEscapeSequenceException var1_2) {
                            v0 = String.valueOf(var1_2.getMessage());
                            if (v0.length() != 0) {
                                v1 = "Couldn't parse default value: ".concat(v0);
                                throw new Descriptors$DescriptorValidationException(this, v1, var1_2, null);
                            }
                            v1 = new String("Couldn't parse default value: ");
                            throw new Descriptors$DescriptorValidationException(this, v1, var1_2, null);
                        }
                    }
                    case 16: {
                        this.defaultValue = this.enumType.findValueByName(this.proto.getDefaultValue());
                        if (this.defaultValue != null) break;
                        var1_1 = String.valueOf(String.valueOf(this.proto.getDefaultValue()));
                        throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(30 + var1_1.length()).append("Unknown enum default value: \"").append((String)var1_1).append("\"").toString(), null);
                    }
                    case 17: 
                    case 18: {
                        throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Message type had default value.", null);
                    }
                }
            }
            catch (NumberFormatException var1_3) {
                var2_9 = String.valueOf(String.valueOf(this.proto.getDefaultValue()));
                throw new Descriptors$DescriptorValidationException(this, new StringBuilder(33 + var2_9.length()).append("Could not parse default value: \"").append(var2_9).append("\"").toString(), var1_3, null);
            }
        } else if (this.isRepeated()) {
            this.defaultValue = Collections.emptyList();
        } else {
            switch (Descriptors$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.getJavaType().ordinal()]) {
                case 1: {
                    this.defaultValue = this.enumType.getValues().get(0);
                    ** break;
                }
                case 2: {
                    this.defaultValue = null;
                    ** break;
                }
            }
            this.defaultValue = Descriptors$FieldDescriptor$JavaType.access$2200(this.getJavaType());
        }
lbl120: // 5 sources:
        if (!this.isExtension()) {
            Descriptors$FileDescriptor.access$1400(this.file).addFieldByNumber(this);
        }
        if (this.containingType == null) return;
        if (this.containingType.getOptions().getMessageSetWireFormat() == false) return;
        if (this.isExtension() == false) throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "MessageSets cannot have fields, only extensions.", null);
        if (this.isOptional() == false) throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Extensions of MessageSets must be optional messages.", null);
        if (this.getType() == Descriptors$FieldDescriptor$Type.MESSAGE) return;
        throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Extensions of MessageSets must be optional messages.", null);
    }

    private void setProto(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        this.proto = descriptorProtos$FieldDescriptorProto;
    }

    @Override
    public MessageLite$Builder internalMergeFrom(MessageLite$Builder messageLite$Builder, MessageLite messageLite) {
        return ((Message$Builder)messageLite$Builder).mergeFrom((Message)messageLite);
    }

    /* synthetic */ Descriptors$FieldDescriptor(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2, boolean bl2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$FieldDescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n2, bl2);
    }

    static /* synthetic */ void access$900(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        descriptors$FieldDescriptor.crossLink();
    }

    static /* synthetic */ void access$1300(Descriptors$FieldDescriptor descriptors$FieldDescriptor, DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        descriptors$FieldDescriptor.setProto(descriptorProtos$FieldDescriptorProto);
    }

    static {
        if (Descriptors$FieldDescriptor$Type.values().length == DescriptorProtos$FieldDescriptorProto$Type.values().length) return;
        throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
    }
}

