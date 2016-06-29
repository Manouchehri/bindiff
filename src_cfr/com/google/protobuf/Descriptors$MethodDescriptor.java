/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.Message;

public final class Descriptors$MethodDescriptor
extends Descriptors$GenericDescriptor {
    private final int index;
    private DescriptorProtos$MethodDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$ServiceDescriptor service;
    private Descriptors$Descriptor inputType;
    private Descriptors$Descriptor outputType;

    public int getIndex() {
        return this.index;
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto toProto() {
        return this.proto;
    }

    @Override
    public String getName() {
        return this.proto.getName();
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    public Descriptors$ServiceDescriptor getService() {
        return this.service;
    }

    public Descriptors$Descriptor getInputType() {
        return this.inputType;
    }

    public Descriptors$Descriptor getOutputType() {
        return this.outputType;
    }

    public DescriptorProtos$MethodOptions getOptions() {
        return this.proto.getOptions();
    }

    private Descriptors$MethodDescriptor(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$ServiceDescriptor descriptors$ServiceDescriptor, int n2) {
        this.index = n2;
        this.proto = descriptorProtos$MethodDescriptorProto;
        this.file = descriptors$FileDescriptor;
        this.service = descriptors$ServiceDescriptor;
        String string = String.valueOf(String.valueOf(descriptors$ServiceDescriptor.getFullName()));
        String string2 = String.valueOf(String.valueOf(descriptorProtos$MethodDescriptorProto.getName()));
        this.fullName = new StringBuilder(1 + string.length() + string2.length()).append(string).append(".").append(string2).toString();
        Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addSymbol(this);
    }

    private void crossLink() {
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = Descriptors$FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getInputType(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
        if (!(descriptors$GenericDescriptor instanceof Descriptors$Descriptor)) {
            String string = String.valueOf(String.valueOf(this.proto.getInputType()));
            throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(25 + string.length()).append("\"").append(string).append("\" is not a message type.").toString(), null);
        }
        this.inputType = (Descriptors$Descriptor)descriptors$GenericDescriptor;
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = Descriptors$FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getOutputType(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
        if (!(descriptors$GenericDescriptor2 instanceof Descriptors$Descriptor)) {
            String string = String.valueOf(String.valueOf(this.proto.getOutputType()));
            throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, new StringBuilder(25 + string.length()).append("\"").append(string).append("\" is not a message type.").toString(), null);
        }
        this.outputType = (Descriptors$Descriptor)descriptors$GenericDescriptor2;
    }

    private void setProto(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        this.proto = descriptorProtos$MethodDescriptorProto;
    }

    /* synthetic */ Descriptors$MethodDescriptor(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$ServiceDescriptor descriptors$ServiceDescriptor, int n2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$MethodDescriptorProto, descriptors$FileDescriptor, descriptors$ServiceDescriptor, n2);
    }

    static /* synthetic */ void access$2800(Descriptors$MethodDescriptor descriptors$MethodDescriptor) {
        descriptors$MethodDescriptor.crossLink();
    }

    static /* synthetic */ void access$2900(Descriptors$MethodDescriptor descriptors$MethodDescriptor, DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        descriptors$MethodDescriptor.setProto(descriptorProtos$MethodDescriptorProto);
    }
}

