/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolStringList;

public interface FieldMaskOrBuilder
extends MessageOrBuilder {
    public ProtocolStringList getPathsList();

    public int getPathsCount();

    public String getPaths(int var1);

    public ByteString getPathsBytes(int var1);
}

