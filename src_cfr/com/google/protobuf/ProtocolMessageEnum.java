/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLite;

public interface ProtocolMessageEnum
extends Internal$EnumLite {
    @Override
    public int getNumber();

    public Descriptors$EnumValueDescriptor getValueDescriptor();

    public Descriptors$EnumDescriptor getDescriptorForType();
}

