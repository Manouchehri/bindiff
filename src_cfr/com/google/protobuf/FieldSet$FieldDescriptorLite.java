/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public interface FieldSet$FieldDescriptorLite
extends Comparable {
    public int getNumber();

    public WireFormat$FieldType getLiteType();

    public WireFormat$JavaType getLiteJavaType();

    public boolean isRepeated();

    public boolean isPacked();

    public Internal$EnumLiteMap getEnumType();

    public MessageLite$Builder internalMergeFrom(MessageLite$Builder var1, MessageLite var2);
}

