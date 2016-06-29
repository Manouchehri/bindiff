package com.google.common.hash;

import java.io.*;
import java.nio.charset.*;

class Funnels$StringCharsetFunnel$SerializedForm implements Serializable
{
    private final String charsetCanonicalName;
    private static final long serialVersionUID = 0L;
    
    Funnels$StringCharsetFunnel$SerializedForm(final Charset charset) {
        this.charsetCanonicalName = charset.name();
    }
    
    private Object readResolve() {
        return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
    }
}
