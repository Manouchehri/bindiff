package com.google.protobuf;

import java.util.logging.*;
import java.util.*;

public final class Descriptors$MethodDescriptor extends Descriptors$GenericDescriptor
{
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
    
    public DescriptorProtos$MethodDescriptorProto toProto() {
        return this.proto;
    }
    
    public String getName() {
        return this.proto.getName();
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
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
    
    private Descriptors$MethodDescriptor(final DescriptorProtos$MethodDescriptorProto proto, final Descriptors$FileDescriptor file, final Descriptors$ServiceDescriptor service, final int index) {
        this.index = index;
        this.proto = proto;
        this.file = file;
        this.service = service;
        final String value = String.valueOf(String.valueOf(service.getFullName()));
        final String value2 = String.valueOf(String.valueOf(proto.getName()));
        this.fullName = new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        file.pool.addSymbol(this);
    }
    
    private void crossLink() {
        final Descriptors$GenericDescriptor lookupSymbol = this.file.pool.lookupSymbol(this.proto.getInputType(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
        if (!(lookupSymbol instanceof Descriptors$Descriptor)) {
            final String value = String.valueOf(String.valueOf(this.proto.getInputType()));
            throw new Descriptors$DescriptorValidationException(this, new StringBuilder(25 + value.length()).append("\"").append(value).append("\" is not a message type.").toString(), (Descriptors$1)null);
        }
        this.inputType = (Descriptors$Descriptor)lookupSymbol;
        final Descriptors$GenericDescriptor lookupSymbol2 = this.file.pool.lookupSymbol(this.proto.getOutputType(), this, Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY);
        if (!(lookupSymbol2 instanceof Descriptors$Descriptor)) {
            final String value2 = String.valueOf(String.valueOf(this.proto.getOutputType()));
            throw new Descriptors$DescriptorValidationException(this, new StringBuilder(25 + value2.length()).append("\"").append(value2).append("\" is not a message type.").toString(), (Descriptors$1)null);
        }
        this.outputType = (Descriptors$Descriptor)lookupSymbol2;
    }
    
    private void setProto(final DescriptorProtos$MethodDescriptorProto proto) {
        this.proto = proto;
    }
}
