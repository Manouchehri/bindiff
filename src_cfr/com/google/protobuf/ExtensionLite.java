/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$FieldType;

public abstract class ExtensionLite {
    public abstract int getNumber();

    public abstract WireFormat$FieldType getLiteType();

    public abstract boolean isRepeated();

    public abstract Object getDefaultValue();

    public abstract MessageLite getMessageDefaultInstance();

    boolean isLite() {
        return true;
    }
}

