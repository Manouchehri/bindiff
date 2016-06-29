/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.Map;

public interface MessageOrBuilder
extends MessageLiteOrBuilder {
    @Override
    public Message getDefaultInstanceForType();

    public List findInitializationErrors();

    public String getInitializationErrorString();

    public Descriptors$Descriptor getDescriptorForType();

    public Map getAllFields();

    public boolean hasOneof(Descriptors$OneofDescriptor var1);

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1);

    public boolean hasField(Descriptors$FieldDescriptor var1);

    public Object getField(Descriptors$FieldDescriptor var1);

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1);

    public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2);

    public UnknownFieldSet getUnknownFields();
}

