/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$MethodDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public boolean hasInputType();

    public String getInputType();

    public ByteString getInputTypeBytes();

    public boolean hasOutputType();

    public String getOutputType();

    public ByteString getOutputTypeBytes();

    public boolean hasOptions();

    public DescriptorProtos$MethodOptions getOptions();

    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder();

    public boolean hasClientStreaming();

    public boolean getClientStreaming();

    public boolean hasServerStreaming();

    public boolean getServerStreaming();
}

