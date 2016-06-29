/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$FieldDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public boolean hasNumber();

    public int getNumber();

    public boolean hasLabel();

    public DescriptorProtos$FieldDescriptorProto$Label getLabel();

    public boolean hasType();

    public DescriptorProtos$FieldDescriptorProto$Type getType();

    public boolean hasTypeName();

    public String getTypeName();

    public ByteString getTypeNameBytes();

    public boolean hasExtendee();

    public String getExtendee();

    public ByteString getExtendeeBytes();

    public boolean hasDefaultValue();

    public String getDefaultValue();

    public ByteString getDefaultValueBytes();

    public boolean hasOneofIndex();

    public int getOneofIndex();

    public boolean hasOptions();

    public DescriptorProtos$FieldOptions getOptions();

    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder();
}

