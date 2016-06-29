package com.google.protobuf;

import java.util.*;
import java.util.logging.*;

public final class Descriptors$OneofDescriptor
{
    private final int index;
    private DescriptorProtos$OneofDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private Descriptors$Descriptor containingType;
    private int fieldCount;
    private Descriptors$FieldDescriptor[] fields;
    
    public int getIndex() {
        return this.index;
    }
    
    public String getName() {
        return this.proto.getName();
    }
    
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
    }
    
    public int getFieldCount() {
        return this.fieldCount;
    }
    
    public List getFields() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.fields));
    }
    
    public Descriptors$FieldDescriptor getField(final int n) {
        return this.fields[n];
    }
    
    private Descriptors$OneofDescriptor(final DescriptorProtos$OneofDescriptorProto proto, final Descriptors$FileDescriptor file, final Descriptors$Descriptor containingType, final int index) {
        this.proto = proto;
        this.fullName = computeFullName(file, containingType, proto.getName());
        this.file = file;
        this.index = index;
        this.containingType = containingType;
        this.fieldCount = 0;
    }
}
