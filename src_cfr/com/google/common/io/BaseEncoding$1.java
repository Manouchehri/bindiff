/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import java.io.OutputStream;
import java.io.Writer;

class BaseEncoding$1
extends ByteSink {
    final /* synthetic */ CharSink val$encodedSink;
    final /* synthetic */ BaseEncoding this$0;

    BaseEncoding$1(BaseEncoding baseEncoding, CharSink charSink) {
        this.this$0 = baseEncoding;
        this.val$encodedSink = charSink;
    }

    @Override
    public OutputStream openStream() {
        return this.this$0.encodingStream(this.val$encodedSink.openStream());
    }
}

