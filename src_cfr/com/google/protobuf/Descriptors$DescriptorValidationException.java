/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Message;

public class Descriptors$DescriptorValidationException
extends Exception {
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

    private Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string) {
        String string2 = String.valueOf(String.valueOf(descriptors$GenericDescriptor.getFullName()));
        String string3 = String.valueOf(String.valueOf(string));
        super(new StringBuilder(2 + string2.length() + string3.length()).append(string2).append(": ").append(string3).toString());
        this.name = descriptors$GenericDescriptor.getFullName();
        this.proto = descriptors$GenericDescriptor.toProto();
        this.description = string;
    }

    private Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string, Throwable throwable) {
        this(descriptors$GenericDescriptor, string);
        this.initCause(throwable);
    }

    private Descriptors$DescriptorValidationException(Descriptors$FileDescriptor descriptors$FileDescriptor, String string) {
        String string2 = String.valueOf(String.valueOf(descriptors$FileDescriptor.getName()));
        String string3 = String.valueOf(String.valueOf(string));
        super(new StringBuilder(2 + string2.length() + string3.length()).append(string2).append(": ").append(string3).toString());
        this.name = descriptors$FileDescriptor.getName();
        this.proto = descriptors$FileDescriptor.toProto();
        this.description = string;
    }

    /* synthetic */ Descriptors$DescriptorValidationException(Descriptors$FileDescriptor descriptors$FileDescriptor, String string, Descriptors$1 descriptors$1) {
        this(descriptors$FileDescriptor, string);
    }

    /* synthetic */ Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string, Descriptors$1 descriptors$1) {
        this(descriptors$GenericDescriptor, string);
    }

    /* synthetic */ Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string, Throwable throwable, Descriptors$1 descriptors$1) {
        this(descriptors$GenericDescriptor, string, throwable);
    }
}

