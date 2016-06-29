/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;

public enum WireFormat$JavaType {
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

    private WireFormat$JavaType(Object object) {
        this.defaultDefault = object;
    }

    Object getDefaultDefault() {
        return this.defaultDefault;
    }
}

