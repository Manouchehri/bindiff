/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$ServiceDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public List getMethodList();

    public DescriptorProtos$MethodDescriptorProto getMethod(int var1);

    public int getMethodCount();

    public List getMethodOrBuilderList();

    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int var1);

    public boolean hasOptions();

    public DescriptorProtos$ServiceOptions getOptions();

    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder();
}

