/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Message;

public abstract class Descriptors$GenericDescriptor {
    public abstract Message toProto();

    public abstract String getName();

    public abstract String getFullName();

    public abstract Descriptors$FileDescriptor getFile();
}

