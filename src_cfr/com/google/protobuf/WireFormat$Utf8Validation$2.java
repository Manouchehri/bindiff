/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$Utf8Validation;

final class WireFormat$Utf8Validation$2
extends WireFormat$Utf8Validation {
    WireFormat$Utf8Validation$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    Object readString(CodedInputStream codedInputStream) {
        return codedInputStream.readStringRequireUtf8();
    }
}

