package com.google.protobuf;

import java.util.logging.*;
import java.util.*;

public final class Descriptors$EnumValueDescriptor extends Descriptors$GenericDescriptor implements Internal$EnumLite
{
    private final int index;
    private DescriptorProtos$EnumValueDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$EnumDescriptor type;
    private Integer number;
    
    public int getIndex() {
        return this.index;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto toProto() {
        return this.proto;
    }
    
    public String getName() {
        return this.proto.getName();
    }
    
    public int getNumber() {
        return this.proto.getNumber();
    }
    
    public String toString() {
        return this.proto.getName();
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }
    
    public Descriptors$EnumDescriptor getType() {
        return this.type;
    }
    
    public DescriptorProtos$EnumValueOptions getOptions() {
        return this.proto.getOptions();
    }
    
    private Descriptors$EnumValueDescriptor(final DescriptorProtos$EnumValueDescriptorProto proto, final Descriptors$FileDescriptor file, final Descriptors$EnumDescriptor type, final int index) {
        this.index = index;
        this.proto = proto;
        this.file = file;
        this.type = type;
        final String value = String.valueOf(String.valueOf(type.getFullName()));
        final String value2 = String.valueOf(String.valueOf(proto.getName()));
        this.fullName = new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        file.pool.addSymbol(this);
        file.pool.addEnumValueByNumber(this);
    }
    
    private Descriptors$EnumValueDescriptor(final Descriptors$FileDescriptor file, final Descriptors$EnumDescriptor type, final Integer number) {
        final String value = String.valueOf(String.valueOf(type.getName()));
        final String value2 = String.valueOf(String.valueOf(number));
        final DescriptorProtos$EnumValueDescriptorProto build = DescriptorProtos$EnumValueDescriptorProto.newBuilder().setName(new StringBuilder(20 + value.length() + value2.length()).append("UNKNOWN_ENUM_VALUE_").append(value).append("_").append(value2).toString()).setNumber(number).build();
        this.index = -1;
        this.proto = build;
        this.file = file;
        this.type = type;
        final String value3 = String.valueOf(String.valueOf(type.getFullName()));
        final String value4 = String.valueOf(String.valueOf(build.getName()));
        this.fullName = new StringBuilder(1 + value3.length() + value4.length()).append(value3).append(".").append(value4).toString();
        this.number = number;
    }
    
    private void setProto(final DescriptorProtos$EnumValueDescriptorProto proto) {
        this.proto = proto;
    }
}
