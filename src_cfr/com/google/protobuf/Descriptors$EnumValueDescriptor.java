/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Message;

public final class Descriptors$EnumValueDescriptor
extends Descriptors$GenericDescriptor
implements Internal$EnumLite {
    private final int index;
    private DescriptorProtos$EnumValueDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$EnumDescriptor type;
    private Integer number;

    public int getIndex() {
        return this.index;
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto toProto() {
        return this.proto;
    }

    @Override
    public String getName() {
        return this.proto.getName();
    }

    @Override
    public int getNumber() {
        return this.proto.getNumber();
    }

    public String toString() {
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

    public Descriptors$EnumDescriptor getType() {
        return this.type;
    }

    public DescriptorProtos$EnumValueOptions getOptions() {
        return this.proto.getOptions();
    }

    private Descriptors$EnumValueDescriptor(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor descriptors$EnumDescriptor, int n2) {
        this.index = n2;
        this.proto = descriptorProtos$EnumValueDescriptorProto;
        this.file = descriptors$FileDescriptor;
        this.type = descriptors$EnumDescriptor;
        String string = String.valueOf(String.valueOf(descriptors$EnumDescriptor.getFullName()));
        String string2 = String.valueOf(String.valueOf(descriptorProtos$EnumValueDescriptorProto.getName()));
        this.fullName = new StringBuilder(1 + string.length() + string2.length()).append(string).append(".").append(string2).toString();
        Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addSymbol(this);
        Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addEnumValueByNumber(this);
    }

    private Descriptors$EnumValueDescriptor(Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor descriptors$EnumDescriptor, Integer n2) {
        String string = String.valueOf(String.valueOf(descriptors$EnumDescriptor.getName()));
        String string2 = String.valueOf(String.valueOf(n2));
        String string3 = new StringBuilder(20 + string.length() + string2.length()).append("UNKNOWN_ENUM_VALUE_").append(string).append("_").append(string2).toString();
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = DescriptorProtos$EnumValueDescriptorProto.newBuilder().setName(string3).setNumber(n2).build();
        this.index = -1;
        this.proto = descriptorProtos$EnumValueDescriptorProto;
        this.file = descriptors$FileDescriptor;
        this.type = descriptors$EnumDescriptor;
        String string4 = String.valueOf(String.valueOf(descriptors$EnumDescriptor.getFullName()));
        String string5 = String.valueOf(String.valueOf(descriptorProtos$EnumValueDescriptorProto.getName()));
        this.fullName = new StringBuilder(1 + string4.length() + string5.length()).append(string4).append(".").append(string5).toString();
        this.number = n2;
    }

    private void setProto(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        this.proto = descriptorProtos$EnumValueDescriptorProto;
    }

    /* synthetic */ Descriptors$EnumValueDescriptor(Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor descriptors$EnumDescriptor, Integer n2, Descriptors$1 descriptors$1) {
        this(descriptors$FileDescriptor, descriptors$EnumDescriptor, n2);
    }

    /* synthetic */ Descriptors$EnumValueDescriptor(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor descriptors$EnumDescriptor, int n2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$EnumValueDescriptorProto, descriptors$FileDescriptor, descriptors$EnumDescriptor, n2);
    }

    static /* synthetic */ void access$2600(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        descriptors$EnumValueDescriptor.setProto(descriptorProtos$EnumValueDescriptorProto);
    }
}

