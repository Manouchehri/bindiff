/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import java.util.logging.Logger;

public final class Descriptors {
    private static final Logger logger = Logger.getLogger(Descriptors.class.getName());

    private static String computeFullName(Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, String string) {
        if (descriptors$Descriptor != null) {
            String string2 = String.valueOf(String.valueOf(descriptors$Descriptor.getFullName()));
            String string3 = String.valueOf(String.valueOf(string));
            return new StringBuilder(1 + string2.length() + string3.length()).append(string2).append(".").append(string3).toString();
        }
        if (descriptors$FileDescriptor.getPackage().length() <= 0) return string;
        String string4 = String.valueOf(String.valueOf(descriptors$FileDescriptor.getPackage()));
        String string5 = String.valueOf(String.valueOf(string));
        return new StringBuilder(1 + string4.length() + string5.length()).append(string4).append(".").append(string5).toString();
    }

    static /* synthetic */ Logger access$100() {
        return logger;
    }

    static /* synthetic */ String access$1600(Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, String string) {
        return Descriptors.computeFullName(descriptors$FileDescriptor, descriptors$Descriptor, string);
    }
}

