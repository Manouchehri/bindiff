/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import java.io.OutputStream;
import java.io.Writer;

class BaseEncoding$StandardBaseEncoding$1
extends OutputStream {
    int bitBuffer;
    int bitBufferLength;
    int writtenChars;
    final /* synthetic */ Writer val$out;
    final /* synthetic */ BaseEncoding$StandardBaseEncoding this$0;

    BaseEncoding$StandardBaseEncoding$1(BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding, Writer writer) {
        this.this$0 = baseEncoding$StandardBaseEncoding;
        this.val$out = writer;
        this.bitBuffer = 0;
        this.bitBufferLength = 0;
        this.writtenChars = 0;
    }

    @Override
    public void write(int n2) {
        this.bitBuffer <<= 8;
        this.bitBuffer |= n2 & 255;
        this.bitBufferLength += 8;
        while (this.bitBufferLength >= this.this$0.alphabet.bitsPerChar) {
            int n3 = this.bitBuffer >> this.bitBufferLength - this.this$0.alphabet.bitsPerChar & this.this$0.alphabet.mask;
            this.val$out.write(this.this$0.alphabet.encode(n3));
            ++this.writtenChars;
            this.bitBufferLength -= this.this$0.alphabet.bitsPerChar;
        }
    }

    @Override
    public void flush() {
        this.val$out.flush();
    }

    @Override
    public void close() {
        if (this.bitBufferLength > 0) {
            int n2 = this.bitBuffer << this.this$0.alphabet.bitsPerChar - this.bitBufferLength & this.this$0.alphabet.mask;
            this.val$out.write(this.this$0.alphabet.encode(n2));
            ++this.writtenChars;
            if (this.this$0.paddingChar != null) {
                while (this.writtenChars % this.this$0.alphabet.charsPerChunk != 0) {
                    this.val$out.write(this.this$0.paddingChar.charValue());
                    ++this.writtenChars;
                }
            }
        }
        this.val$out.close();
    }
}

