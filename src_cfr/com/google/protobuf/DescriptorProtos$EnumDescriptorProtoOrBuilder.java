/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$EnumDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public List getValueList();

    public DescriptorProtos$EnumValueDescriptorProto getValue(int var1);

    public int getValueCount();

    public List getValueOrBuilderList();

    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int var1);

    public boolean hasOptions();

    public DescriptorProtos$EnumOptions getOptions();

    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder();
}

