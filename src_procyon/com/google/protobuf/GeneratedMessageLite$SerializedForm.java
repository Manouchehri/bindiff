package com.google.protobuf;

import java.io.*;

final class GeneratedMessageLite$SerializedForm implements Serializable
{
    private static final long serialVersionUID = 0L;
    private final String messageClassName;
    private final byte[] asBytes;
    
    GeneratedMessageLite$SerializedForm(final MessageLite messageLite) {
        this.messageClassName = messageLite.getClass().getName();
        this.asBytes = messageLite.toByteArray();
    }
    
    protected Object readResolve() {
        try {
            return ((Parser)Class.forName(this.messageClassName).getField("PARSER").get(null)).parsePartialFrom(this.asBytes);
        }
        catch (ClassNotFoundException ex) {
            throw new RuntimeException("Unable to find proto buffer class", ex);
        }
        catch (NoSuchFieldException ex2) {
            throw new RuntimeException("Unable to find PARSER", ex2);
        }
        catch (SecurityException ex3) {
            throw new RuntimeException("Unable to call PARSER", ex3);
        }
        catch (IllegalAccessException ex4) {
            throw new RuntimeException("Unable to call parseFrom method", ex4);
        }
        catch (InvalidProtocolBufferException ex5) {
            throw new RuntimeException("Unable to understand proto buffer", ex5);
        }
    }
}
