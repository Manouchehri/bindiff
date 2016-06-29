/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Message;

final class Descriptors$DescriptorPool$PackageDescriptor
extends Descriptors$GenericDescriptor {
    private final String name;
    private final String fullName;
    private final Descriptors$FileDescriptor file;

    @Override
    public Message toProto() {
        return this.file.toProto();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    Descriptors$DescriptorPool$PackageDescriptor(String string, String string2, Descriptors$FileDescriptor descriptors$FileDescriptor) {
        this.file = descriptors$FileDescriptor;
        this.fullName = string2;
        this.name = string;
    }
}

