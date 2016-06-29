package com.google.protobuf;

final class Descriptors$DescriptorPool$PackageDescriptor extends Descriptors$GenericDescriptor
{
    private final String name;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    
    public Message toProto() {
        return this.file.toProto();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }
    
    Descriptors$DescriptorPool$PackageDescriptor(final String name, final String fullName, final Descriptors$FileDescriptor file) {
        this.file = file;
        this.fullName = fullName;
        this.name = name;
    }
}
