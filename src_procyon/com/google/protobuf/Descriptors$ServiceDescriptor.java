package com.google.protobuf;

import java.util.logging.*;
import java.util.*;

public final class Descriptors$ServiceDescriptor extends Descriptors$GenericDescriptor
{
    private final int index;
    private DescriptorProtos$ServiceDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private Descriptors$MethodDescriptor[] methods;
    
    public int getIndex() {
        return this.index;
    }
    
    public DescriptorProtos$ServiceDescriptorProto toProto() {
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
    
    public DescriptorProtos$ServiceOptions getOptions() {
        return this.proto.getOptions();
    }
    
    public List getMethods() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.methods));
    }
    
    public Descriptors$MethodDescriptor findMethodByName(final String s) {
        final Descriptors$DescriptorPool access$1400 = this.file.pool;
        final String value = String.valueOf(String.valueOf(this.fullName));
        final String value2 = String.valueOf(String.valueOf(s));
        final Descriptors$GenericDescriptor symbol = access$1400.findSymbol(new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString());
        if (symbol != null && symbol instanceof Descriptors$MethodDescriptor) {
            return (Descriptors$MethodDescriptor)symbol;
        }
        return null;
    }
    
    private Descriptors$ServiceDescriptor(final DescriptorProtos$ServiceDescriptorProto proto, final Descriptors$FileDescriptor file, final int index) {
        this.index = index;
        this.proto = proto;
        this.fullName = computeFullName(file, null, proto.getName());
        this.file = file;
        this.methods = new Descriptors$MethodDescriptor[proto.getMethodCount()];
        for (int i = 0; i < proto.getMethodCount(); ++i) {
            this.methods[i] = new Descriptors$MethodDescriptor(proto.getMethod(i), file, this, i, null);
        }
        file.pool.addSymbol(this);
    }
    
    private void crossLink() {
        final Descriptors$MethodDescriptor[] methods = this.methods;
        for (int length = methods.length, i = 0; i < length; ++i) {
            methods[i].crossLink();
        }
    }
    
    private void setProto(final DescriptorProtos$ServiceDescriptorProto proto) {
        this.proto = proto;
        for (int i = 0; i < this.methods.length; ++i) {
            this.methods[i].setProto(proto.getMethod(i));
        }
    }
}
