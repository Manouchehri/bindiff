/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import java.io.InputStream;
import java.io.Reader;

class BaseEncoding$2
extends ByteSource {
    final /* synthetic */ CharSource val$encodedSource;
    final /* synthetic */ BaseEncoding this$0;

    BaseEncoding$2(BaseEncoding baseEncoding, CharSource charSource) {
        this.this$0 = baseEncoding;
        this.val$encodedSource = charSource;
    }

    @Override
    public InputStream openStream() {
        return this.this$0.decodingStream(this.val$encodedSource.openStream());
    }
}

