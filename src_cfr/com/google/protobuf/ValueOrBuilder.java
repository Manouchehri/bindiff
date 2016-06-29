/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;

public interface ValueOrBuilder
extends MessageOrBuilder {
    public int getNullValueValue();

    public NullValue getNullValue();

    public double getNumberValue();

    public String getStringValue();

    public ByteString getStringValueBytes();

    public boolean getBoolValue();

    public Struct getStructValue();

    public StructOrBuilder getStructValueOrBuilder();

    public ListValue getListValue();

    public ListValueOrBuilder getListValueOrBuilder();
}

