/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AnyOrBuilder
extends MessageOrBuilder {
    public String getTypeUrl();

    public ByteString getTypeUrlBytes();

    public ByteString getValue();
}

