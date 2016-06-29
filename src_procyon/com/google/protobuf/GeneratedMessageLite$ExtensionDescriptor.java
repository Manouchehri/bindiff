package com.google.protobuf;

final class GeneratedMessageLite$ExtensionDescriptor implements FieldSet$FieldDescriptorLite
{
    final Internal$EnumLiteMap enumTypeMap;
    final int number;
    final WireFormat$FieldType type;
    final boolean isRepeated;
    final boolean isPacked;
    
    GeneratedMessageLite$ExtensionDescriptor(final Internal$EnumLiteMap enumTypeMap, final int number, final WireFormat$FieldType type, final boolean isRepeated, final boolean isPacked) {
        this.enumTypeMap = enumTypeMap;
        this.number = number;
        this.type = type;
        this.isRepeated = isRepeated;
        this.isPacked = isPacked;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public WireFormat$FieldType getLiteType() {
        return this.type;
    }
    
    public WireFormat$JavaType getLiteJavaType() {
        return this.type.getJavaType();
    }
    
    public boolean isRepeated() {
        return this.isRepeated;
    }
    
    public boolean isPacked() {
        return this.isPacked;
    }
    
    public Internal$EnumLiteMap getEnumType() {
        return this.enumTypeMap;
    }
    
    public MessageLite$Builder internalMergeFrom(final MessageLite$Builder messageLite$Builder, final MessageLite messageLite) {
        return ((GeneratedMessageLite$Builder)messageLite$Builder).mergeFrom((GeneratedMessageLite)messageLite);
    }
    
    public int compareTo(final GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor) {
        return this.number - generatedMessageLite$ExtensionDescriptor.number;
    }
}
