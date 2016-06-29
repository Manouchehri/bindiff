package com.google.common.hash;

import java.io.*;

final class MessageDigestHashFunction$SerializedForm implements Serializable
{
    private final String algorithmName;
    private final int bytes;
    private final String toString;
    private static final long serialVersionUID = 0L;
    
    private MessageDigestHashFunction$SerializedForm(final String algorithmName, final int bytes, final String toString) {
        this.algorithmName = algorithmName;
        this.bytes = bytes;
        this.toString = toString;
    }
    
    private Object readResolve() {
        return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
    }
}
