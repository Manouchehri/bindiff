/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

final class GeneratedMessageLite$ExtensionDescriptor
implements FieldSet$FieldDescriptorLite {
    final Internal$EnumLiteMap enumTypeMap;
    final int number;
    final WireFormat$FieldType type;
    final boolean isRepeated;
    final boolean isPacked;

    GeneratedMessageLite$ExtensionDescriptor(Internal$EnumLiteMap internal$EnumLiteMap, int n2, WireFormat$FieldType wireFormat$FieldType, boolean bl2, boolean bl3) {
        this.enumTypeMap = internal$EnumLiteMap;
        this.number = n2;
        this.type = wireFormat$FieldType;
        this.isRepeated = bl2;
        this.isPacked = bl3;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public WireFormat$FieldType getLiteType() {
        return this.type;
    }

    @Override
    public WireFormat$JavaType getLiteJavaType() {
        return this.type.getJavaType();
    }

    @Override
    public boolean isRepeated() {
        return this.isRepeated;
    }

    @Override
    public boolean isPacked() {
        return this.isPacked;
    }

    @Override
    public Internal$EnumLiteMap getEnumType() {
        return this.enumTypeMap;
    }

    @Override
    public MessageLite$Builder internalMergeFrom(MessageLite$Builder messageLite$Builder, MessageLite messageLite) {
        return ((GeneratedMessageLite$Builder)messageLite$Builder).mergeFrom((GeneratedMessageLite)messageLite);
    }

    public int compareTo(GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor) {
        return this.number - generatedMessageLite$ExtensionDescriptor.number;
    }
}

