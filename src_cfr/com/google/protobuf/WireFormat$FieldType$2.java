/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

final class WireFormat$FieldType$2
extends WireFormat$FieldType {
    WireFormat$FieldType$2(String string2, int n3, WireFormat$JavaType wireFormat$JavaType, int n4) {
        super(string, n2, (WireFormat$JavaType)((Object)string2), n3, null);
    }

    @Override
    public boolean isPackable() {
        return false;
    }
}

