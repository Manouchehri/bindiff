package com.google.protobuf;

import java.util.logging.*;
import java.util.*;

public final class Descriptors$FieldDescriptor extends Descriptors$GenericDescriptor implements FieldSet$FieldDescriptorLite, Comparable
{
    private static final WireFormat$FieldType[] table;
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
    
    public DescriptorProtos$FieldDescriptorProto toProto() {
        return this.proto;
    }
    
    public String getName() {
        return this.proto.getName();
    }
    
    public int getNumber() {
        return this.proto.getNumber();
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public Descriptors$FieldDescriptor$JavaType getJavaType() {
        return this.type.getJavaType();
    }
    
    public WireFormat$JavaType getLiteJavaType() {
        return this.getLiteType().getJavaType();
    }
    
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }
    
    public Descriptors$FieldDescriptor$Type getType() {
        return this.type;
    }
    
    public WireFormat$FieldType getLiteType() {
        return Descriptors$FieldDescriptor.table[this.type.ordinal()];
    }
    
    public boolean needsUtf8Check() {
        return this.type == Descriptors$FieldDescriptor$Type.STRING && this.getFile().getOptions().getJavaStringCheckUtf8();
    }
    
    public boolean isMapField() {
        return this.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && this.isRepeated() && this.getMessageType().getOptions().getMapEntry();
    }
    
    public boolean isRequired() {
        return this.proto.getLabel() == DescriptorProtos$FieldDescriptorProto$Label.LABEL_REQUIRED;
    }
    
    public boolean isOptional() {
        return this.proto.getLabel() == DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
    }
    
    public boolean isRepeated() {
        return this.proto.getLabel() == DescriptorProtos$FieldDescriptorProto$Label.LABEL_REPEATED;
    }
    
    public boolean isPacked() {
        if (!this.isPackable()) {
            return false;
        }
        if (this.getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO2) {
            return this.getOptions().getPacked();
        }
        return !this.getOptions().hasPacked() || this.getOptions().getPacked();
    }
    
    public boolean isPackable() {
        return this.isRepeated() && this.getLiteType().isPackable();
    }
    
    public boolean hasDefaultValue() {
        return this.proto.hasDefaultValue();
    }
    
    public Object getDefaultValue() {
        if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }
        return this.defaultValue;
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
        if (!this.isExtension()) {
            throw new UnsupportedOperationException("This field is not an extension.");
        }
        return this.extensionScope;
    }
    
    public Descriptors$Descriptor getMessageType() {
        if (this.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new UnsupportedOperationException("This field is not of message type.");
        }
        return this.messageType;
    }
    
    public Descriptors$EnumDescriptor getEnumType() {
        if (this.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) {
            throw new UnsupportedOperationException("This field is not of enum type.");
        }
        return this.enumType;
    }
    
    public int compareTo(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.containingType != this.containingType) {
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }
        return this.getNumber() - descriptors$FieldDescriptor.getNumber();
    }
    
    public String toString() {
        return this.getFullName();
    }
    
    private Descriptors$FieldDescriptor(final DescriptorProtos$FieldDescriptorProto proto, final Descriptors$FileDescriptor file, final Descriptors$Descriptor descriptors$Descriptor, final int index, final boolean b) {
        this.index = index;
        this.proto = proto;
        this.fullName = computeFullName(file, descriptors$Descriptor, proto.getName());
        this.file = file;
        if (proto.hasType()) {
            this.type = Descriptors$FieldDescriptor$Type.valueOf(proto.getType());
        }
        if (this.getNumber() <= 0) {
            throw new Descriptors$DescriptorValidationException(this, "Field numbers must be positive integers.", (Descriptors$1)null);
        }
        if (b) {
            if (!proto.hasExtendee()) {
                throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", (Descriptors$1)null);
            }
            this.containingType = null;
            if (descriptors$Descriptor != null) {
                this.extensionScope = descriptors$Descriptor;
            }
            else {
                this.extensionScope = null;
            }
            if (proto.hasOneofIndex()) {
                throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", (Descriptors$1)null);
            }
            this.containingOneof = null;
        }
        else {
            if (proto.hasExtendee()) {
                throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", (Descriptors$1)null);
            }
            this.containingType = descriptors$Descriptor;
            if (proto.hasOneofIndex()) {
                if (proto.getOneofIndex() < 0 || proto.getOneofIndex() >= descriptors$Descriptor.toProto().getOneofDeclCount()) {
                    final String s = "FieldDescriptorProto.oneof_index is out of range for type ";
                    final String value = String.valueOf(descriptors$Descriptor.getName());
                    throw new Descriptors$DescriptorValidationException(this, (value.length() != 0) ? s.concat(value) : new String(s), (Descriptors$1)null);
                }
                (this.containingOneof = descriptors$Descriptor.getOneofs().get(proto.getOneofIndex())).fieldCount++;
            }
            else {
                this.containingOneof = null;
            }
            this.extensionScope = null;
        }
        file.pool.addSymbol(this);
    }
    
    private void crossLink() {
        if (this.proto.hasExtendee()) {
            final Descriptors$GenericDescriptor lookupSymbol = this.file.pool.lookupSymbol(this.proto.getExtendee(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
            if (!(lookupSymbol instanceof Descriptors$Descriptor)) {
                final String value = String.valueOf(String.valueOf(this.proto.getExtendee()));
                throw new Descriptors$DescriptorValidationException(this, new StringBuilder(25 + value.length()).append("\"").append(value).append("\" is not a message type.").toString(), (Descriptors$1)null);
            }
            this.containingType = (Descriptors$Descriptor)lookupSymbol;
            if (!this.getContainingType().isExtensionNumber(this.getNumber())) {
                final String value2 = String.valueOf(String.valueOf(this.getContainingType().getFullName()));
                throw new Descriptors$DescriptorValidationException(this, new StringBuilder(55 + value2.length()).append("\"").append(value2).append("\" does not declare ").append(this.getNumber()).append(" as an extension number.").toString(), (Descriptors$1)null);
            }
        }
        if (this.proto.hasTypeName()) {
            final Descriptors$GenericDescriptor lookupSymbol2 = this.file.pool.lookupSymbol(this.proto.getTypeName(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
            if (!this.proto.hasType()) {
                if (lookupSymbol2 instanceof Descriptors$Descriptor) {
                    this.type = Descriptors$FieldDescriptor$Type.MESSAGE;
                }
                else {
                    if (!(lookupSymbol2 instanceof Descriptors$EnumDescriptor)) {
                        final String value3 = String.valueOf(String.valueOf(this.proto.getTypeName()));
                        throw new Descriptors$DescriptorValidationException(this, new StringBuilder(17 + value3.length()).append("\"").append(value3).append("\" is not a type.").toString(), (Descriptors$1)null);
                    }
                    this.type = Descriptors$FieldDescriptor$Type.ENUM;
                }
            }
            if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                if (!(lookupSymbol2 instanceof Descriptors$Descriptor)) {
                    final String value4 = String.valueOf(String.valueOf(this.proto.getTypeName()));
                    throw new Descriptors$DescriptorValidationException(this, new StringBuilder(25 + value4.length()).append("\"").append(value4).append("\" is not a message type.").toString(), (Descriptors$1)null);
                }
                this.messageType = (Descriptors$Descriptor)lookupSymbol2;
                if (this.proto.hasDefaultValue()) {
                    throw new Descriptors$DescriptorValidationException(this, "Messages can't have default values.", (Descriptors$1)null);
                }
            }
            else {
                if (this.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) {
                    throw new Descriptors$DescriptorValidationException(this, "Field with primitive type has type_name.", (Descriptors$1)null);
                }
                if (!(lookupSymbol2 instanceof Descriptors$EnumDescriptor)) {
                    final String value5 = String.valueOf(String.valueOf(this.proto.getTypeName()));
                    throw new Descriptors$DescriptorValidationException(this, new StringBuilder(23 + value5.length()).append("\"").append(value5).append("\" is not an enum type.").toString(), (Descriptors$1)null);
                }
                this.enumType = (Descriptors$EnumDescriptor)lookupSymbol2;
            }
        }
        else if (this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE || this.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
            throw new Descriptors$DescriptorValidationException(this, "Field with message or enum type missing type_name.", (Descriptors$1)null);
        }
        if (this.proto.getOptions().getPacked() && !this.isPackable()) {
            throw new Descriptors$DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", (Descriptors$1)null);
        }
        Label_1355: {
            if (this.proto.hasDefaultValue()) {
                if (this.isRepeated()) {
                    throw new Descriptors$DescriptorValidationException(this, "Repeated fields cannot have default values.", (Descriptors$1)null);
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
                                this.defaultValue = Float.POSITIVE_INFINITY;
                                break;
                            }
                            if (this.proto.getDefaultValue().equals("-inf")) {
                                this.defaultValue = Float.NEGATIVE_INFINITY;
                                break;
                            }
                            if (this.proto.getDefaultValue().equals("nan")) {
                                this.defaultValue = Float.NaN;
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
                            catch (TextFormat$InvalidEscapeSequenceException ex) {
                                final String s = "Couldn't parse default value: ";
                                final String value6 = String.valueOf(ex.getMessage());
                                throw new Descriptors$DescriptorValidationException(this, (value6.length() != 0) ? s.concat(value6) : new String(s), ex, null);
                            }
                        }
                        case 16: {
                            this.defaultValue = this.enumType.findValueByName(this.proto.getDefaultValue());
                            if (this.defaultValue == null) {
                                final String value7 = String.valueOf(String.valueOf(this.proto.getDefaultValue()));
                                throw new Descriptors$DescriptorValidationException(this, new StringBuilder(30 + value7.length()).append("Unknown enum default value: \"").append(value7).append("\"").toString(), (Descriptors$1)null);
                            }
                            break;
                        }
                        case 17:
                        case 18: {
                            throw new Descriptors$DescriptorValidationException(this, "Message type had default value.", (Descriptors$1)null);
                        }
                    }
                    break Label_1355;
                }
                catch (NumberFormatException ex2) {
                    final String value8 = String.valueOf(String.valueOf(this.proto.getDefaultValue()));
                    throw new Descriptors$DescriptorValidationException(this, new StringBuilder(33 + value8.length()).append("Could not parse default value: \"").append(value8).append("\"").toString(), ex2, null);
                }
            }
            if (this.isRepeated()) {
                this.defaultValue = Collections.emptyList();
            }
            else {
                switch (Descriptors$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.getJavaType().ordinal()]) {
                    case 1: {
                        this.defaultValue = this.enumType.getValues().get(0);
                        break;
                    }
                    case 2: {
                        this.defaultValue = null;
                        break;
                    }
                    default: {
                        this.defaultValue = this.getJavaType().defaultDefault;
                        break;
                    }
                }
            }
        }
        if (!this.isExtension()) {
            this.file.pool.addFieldByNumber(this);
        }
        if (this.containingType != null && this.containingType.getOptions().getMessageSetWireFormat()) {
            if (!this.isExtension()) {
                throw new Descriptors$DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", (Descriptors$1)null);
            }
            if (!this.isOptional() || this.getType() != Descriptors$FieldDescriptor$Type.MESSAGE) {
                throw new Descriptors$DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", (Descriptors$1)null);
            }
        }
    }
    
    private void setProto(final DescriptorProtos$FieldDescriptorProto proto) {
        this.proto = proto;
    }
    
    public MessageLite$Builder internalMergeFrom(final MessageLite$Builder messageLite$Builder, final MessageLite messageLite) {
        return ((Message$Builder)messageLite$Builder).mergeFrom((Message)messageLite);
    }
    
    static {
        table = WireFormat$FieldType.values();
        if (Descriptors$FieldDescriptor$Type.values().length != DescriptorProtos$FieldDescriptorProto$Type.values().length) {
            throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
        }
    }
}
