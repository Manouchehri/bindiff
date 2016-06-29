package com.google.protobuf;

public class Descriptors$DescriptorValidationException extends Exception
{
    private static final long serialVersionUID = 5750205775490483148L;
    private final String name;
    private final Message proto;
    private final String description;
    
    public String getProblemSymbolName() {
        return this.name;
    }
    
    public Message getProblemProto() {
        return this.proto;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    private Descriptors$DescriptorValidationException(final Descriptors$GenericDescriptor descriptors$GenericDescriptor, final String description) {
        final String value = String.valueOf(String.valueOf(descriptors$GenericDescriptor.getFullName()));
        final String value2 = String.valueOf(String.valueOf(description));
        super(new StringBuilder(2 + value.length() + value2.length()).append(value).append(": ").append(value2).toString());
        this.name = descriptors$GenericDescriptor.getFullName();
        this.proto = descriptors$GenericDescriptor.toProto();
        this.description = description;
    }
    
    private Descriptors$DescriptorValidationException(final Descriptors$GenericDescriptor descriptors$GenericDescriptor, final String s, final Throwable t) {
        this(descriptors$GenericDescriptor, s);
        this.initCause(t);
    }
    
    private Descriptors$DescriptorValidationException(final Descriptors$FileDescriptor descriptors$FileDescriptor, final String description) {
        final String value = String.valueOf(String.valueOf(descriptors$FileDescriptor.getName()));
        final String value2 = String.valueOf(String.valueOf(description));
        super(new StringBuilder(2 + value.length() + value2.length()).append(value).append(": ").append(value2).toString());
        this.name = descriptors$FileDescriptor.getName();
        this.proto = descriptors$FileDescriptor.toProto();
        this.description = description;
    }
}
