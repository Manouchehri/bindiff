/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;

public interface Message
extends MessageLite,
MessageOrBuilder {
    @Override
    public Parser getParserForType();

    public boolean equals(Object var1);

    public int hashCode();

    public String toString();

    @Override
    public Message$Builder newBuilderForType();

    @Override
    public Message$Builder toBuilder();
}

