/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.InvalidProtocolBufferException;

final class FloatValue$1
extends AbstractParser {
    FloatValue$1() {
    }

    @Override
    public FloatValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new FloatValue(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException var3_3) {
            if (!(var3_3.getCause() instanceof InvalidProtocolBufferException)) throw var3_3;
            throw (InvalidProtocolBufferException)var3_3.getCause();
        }
    }
}

