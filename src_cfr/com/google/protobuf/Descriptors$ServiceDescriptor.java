/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$MethodDescriptor;
import com.google.protobuf.Message;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$ServiceDescriptor
extends Descriptors$GenericDescriptor {
    private final int index;
    private DescriptorProtos$ServiceDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private Descriptors$MethodDescriptor[] methods;

    public int getIndex() {
        return this.index;
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto toProto() {
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

    public DescriptorProtos$ServiceOptions getOptions() {
        return this.proto.getOptions();
    }

    public List getMethods() {
        return Collections.unmodifiableList(Arrays.asList(this.methods));
    }

    public Descriptors$MethodDescriptor findMethodByName(String string) {
        String string2 = String.valueOf(String.valueOf(this.fullName));
        String string3 = String.valueOf(String.valueOf(string));
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = Descriptors$FileDescriptor.access$1400(this.file).findSymbol(new StringBuilder(1 + string2.length() + string3.length()).append(string2).append(".").append(string3).toString());
        if (descriptors$GenericDescriptor == null) return null;
        if (!(descriptors$GenericDescriptor instanceof Descriptors$MethodDescriptor)) return null;
        return (Descriptors$MethodDescriptor)descriptors$GenericDescriptor;
    }

    private Descriptors$ServiceDescriptor(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, int n2) {
        this.index = n2;
        this.proto = descriptorProtos$ServiceDescriptorProto;
        this.fullName = Descriptors.access$1600(descriptors$FileDescriptor, null, descriptorProtos$ServiceDescriptorProto.getName());
        this.file = descriptors$FileDescriptor;
        this.methods = new Descriptors$MethodDescriptor[descriptorProtos$ServiceDescriptorProto.getMethodCount()];
        int n3 = 0;
        do {
            if (n3 >= descriptorProtos$ServiceDescriptorProto.getMethodCount()) {
                Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addSymbol(this);
                return;
            }
            this.methods[n3] = new Descriptors$MethodDescriptor(descriptorProtos$ServiceDescriptorProto.getMethod(n3), descriptors$FileDescriptor, this, n3, null);
            ++n3;
        } while (true);
    }

    private void crossLink() {
        Descriptors$MethodDescriptor[] arrdescriptors$MethodDescriptor = this.methods;
        int n2 = arrdescriptors$MethodDescriptor.length;
        int n3 = 0;
        while (n3 < n2) {
            Descriptors$MethodDescriptor descriptors$MethodDescriptor = arrdescriptors$MethodDescriptor[n3];
            Descriptors$MethodDescriptor.access$2800(descriptors$MethodDescriptor);
            ++n3;
        }
    }

    private void setProto(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        this.proto = descriptorProtos$ServiceDescriptorProto;
        int n2 = 0;
        while (n2 < this.methods.length) {
            Descriptors$MethodDescriptor.access$2900(this.methods[n2], descriptorProtos$ServiceDescriptorProto.getMethod(n2));
            ++n2;
        }
    }

    /* synthetic */ Descriptors$ServiceDescriptor(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, int n2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$ServiceDescriptorProto, descriptors$FileDescriptor, n2);
    }

    static /* synthetic */ void access$800(Descriptors$ServiceDescriptor descriptors$ServiceDescriptor) {
        descriptors$ServiceDescriptor.crossLink();
    }

    static /* synthetic */ void access$1200(Descriptors$ServiceDescriptor descriptors$ServiceDescriptor, DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        descriptors$ServiceDescriptor.setProto(descriptorProtos$ServiceDescriptorProto);
    }
}

