package com.google.protobuf;

import java.util.logging.*;

public final class Descriptors
{
    private static final Logger logger;
    
    private static String computeFullName(final Descriptors$FileDescriptor descriptors$FileDescriptor, final Descriptors$Descriptor descriptors$Descriptor, final String s) {
        if (descriptors$Descriptor != null) {
            final String value = String.valueOf(String.valueOf(descriptors$Descriptor.getFullName()));
            final String value2 = String.valueOf(String.valueOf(s));
            return new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        }
        if (descriptors$FileDescriptor.getPackage().length() > 0) {
            final String value3 = String.valueOf(String.valueOf(descriptors$FileDescriptor.getPackage()));
            final String value4 = String.valueOf(String.valueOf(s));
            return new StringBuilder(1 + value3.length() + value4.length()).append(value3).append(".").append(value4).toString();
        }
        return s;
    }
    
    static {
        logger = Logger.getLogger(Descriptors.class.getName());
    }
}
