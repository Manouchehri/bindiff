/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$EnumValueDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public boolean hasNumber();

    public int getNumber();

    public boolean hasOptions();

    public DescriptorProtos$EnumValueOptions getOptions();

    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder();
}

