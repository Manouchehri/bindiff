/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$OneofDescriptor {
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
        return Collections.unmodifiableList(Arrays.asList(this.fields));
    }

    public Descriptors$FieldDescriptor getField(int n2) {
        return this.fields[n2];
    }

    private Descriptors$OneofDescriptor(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2) {
        this.proto = descriptorProtos$OneofDescriptorProto;
        this.fullName = Descriptors.access$1600(descriptors$FileDescriptor, descriptors$Descriptor, descriptorProtos$OneofDescriptorProto.getName());
        this.file = descriptors$FileDescriptor;
        this.index = n2;
        this.containingType = descriptors$Descriptor;
        this.fieldCount = 0;
    }

    /* synthetic */ Descriptors$OneofDescriptor(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$OneofDescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n2);
    }

    static /* synthetic */ Descriptors$FieldDescriptor[] access$1802(Descriptors$OneofDescriptor descriptors$OneofDescriptor, Descriptors$FieldDescriptor[] arrdescriptors$FieldDescriptor) {
        descriptors$OneofDescriptor.fields = arrdescriptors$FieldDescriptor;
        return descriptors$OneofDescriptor.fields;
    }

    static /* synthetic */ int access$1902(Descriptors$OneofDescriptor descriptors$OneofDescriptor, int n2) {
        descriptors$OneofDescriptor.fieldCount = n2;
        return descriptors$OneofDescriptor.fieldCount;
    }

    static /* synthetic */ Descriptors$FieldDescriptor[] access$1800(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return descriptors$OneofDescriptor.fields;
    }

    static /* synthetic */ int access$1908(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return descriptors$OneofDescriptor.fieldCount++;
    }
}

