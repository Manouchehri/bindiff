/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.CharMatcher;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import java.io.InputStream;
import java.io.Reader;

class BaseEncoding$StandardBaseEncoding$2
extends InputStream {
    int bitBuffer;
    int bitBufferLength;
    int readChars;
    boolean hitPadding;
    final CharMatcher paddingMatcher;
    final /* synthetic */ Reader val$reader;
    final /* synthetic */ BaseEncoding$StandardBaseEncoding this$0;

    BaseEncoding$StandardBaseEncoding$2(BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding, Reader reader) {
        this.this$0 = baseEncoding$StandardBaseEncoding;
        this.val$reader = reader;
        this.bitBuffer = 0;
        this.bitBufferLength = 0;
        this.readChars = 0;
        this.hitPadding = false;
        this.paddingMatcher = this.this$0.padding();
    }

    @Override
    public int read() {
        do {
            int n2;
            char c2;
            if ((n2 = this.val$reader.read()) == -1) {
                if (this.hitPadding) return -1;
                if (this.this$0.alphabet.isValidPaddingStartPosition(this.readChars)) return -1;
                c2 = this.readChars;
                throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append((int)c2).toString());
            }
            ++this.readChars;
            c2 = (char)n2;
            if (this.paddingMatcher.matches(c2)) {
                if (!(this.hitPadding || this.readChars != 1 && this.this$0.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                    int n3 = this.readChars;
                    throw new BaseEncoding$DecodingException(new StringBuilder(41).append("Padding cannot start at index ").append(n3).toString());
                }
                this.hitPadding = true;
                continue;
            }
            if (this.hitPadding) {
                int n4 = this.readChars;
                throw new BaseEncoding$DecodingException(new StringBuilder(61).append("Expected padding character but found '").append(c2).append("' at index ").append(n4).toString());
            }
            this.bitBuffer <<= this.this$0.alphabet.bitsPerChar;
            this.bitBuffer |= this.this$0.alphabet.decode(c2);
            this.bitBufferLength += this.this$0.alphabet.bitsPerChar;
            if (this.bitBufferLength >= 8) break;
        } while (true);
        this.bitBufferLength -= 8;
        return this.bitBuffer >> this.bitBufferLength & 255;
    }

    @Override
    public void close() {
        this.val$reader.close();
    }
}

