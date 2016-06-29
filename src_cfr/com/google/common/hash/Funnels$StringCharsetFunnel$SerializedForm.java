/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.Funnels;
import java.io.Serializable;
import java.nio.charset.Charset;

class Funnels$StringCharsetFunnel$SerializedForm
implements Serializable {
    private final String charsetCanonicalName;
    private static final long serialVersionUID = 0;

    Funnels$StringCharsetFunnel$SerializedForm(Charset charset) {
        this.charsetCanonicalName = charset.name();
    }

    private Object readResolve() {
        return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
    }
}

