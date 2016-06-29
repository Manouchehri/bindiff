/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;

public enum Descriptors$FieldDescriptor$JavaType {
    INT(0),
    LONG(0),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(0.0),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(ByteString.EMPTY),
    ENUM(null),
    MESSAGE(null);
    
    private final Object defaultDefault;

    private Descriptors$FieldDescriptor$JavaType(Object object) {
        this.defaultDefault = object;
    }

    static /* synthetic */ Object access$2200(Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType) {
        return descriptors$FieldDescriptor$JavaType.defaultDefault;
    }
}

