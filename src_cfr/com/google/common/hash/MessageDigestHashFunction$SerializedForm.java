/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.MessageDigestHashFunction$1;
import java.io.Serializable;

final class MessageDigestHashFunction$SerializedForm
implements Serializable {
    private final String algorithmName;
    private final int bytes;
    private final String toString;
    private static final long serialVersionUID = 0;

    private MessageDigestHashFunction$SerializedForm(String string, int n2, String string2) {
        this.algorithmName = string;
        this.bytes = n2;
        this.toString = string2;
    }

    private Object readResolve() {
        return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
    }

    /* synthetic */ MessageDigestHashFunction$SerializedForm(String string, int n2, String string2, MessageDigestHashFunction$1 messageDigestHashFunction$1) {
        this(string, n2, string2);
    }
}

