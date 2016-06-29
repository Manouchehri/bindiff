package com.google.common.io;

import com.google.common.base.*;
import java.io.*;

class BaseEncoding$StandardBaseEncoding$2 extends InputStream
{
    int bitBuffer;
    int bitBufferLength;
    int readChars;
    boolean hitPadding;
    final CharMatcher paddingMatcher;
    final /* synthetic */ Reader val$reader;
    final /* synthetic */ BaseEncoding$StandardBaseEncoding this$0;
    
    BaseEncoding$StandardBaseEncoding$2(final BaseEncoding$StandardBaseEncoding this$0, final Reader val$reader) {
        this.this$0 = this$0;
        this.val$reader = val$reader;
        this.bitBuffer = 0;
        this.bitBufferLength = 0;
        this.readChars = 0;
        this.hitPadding = false;
        this.paddingMatcher = this.this$0.padding();
    }
    
    @Override
    public int read() {
        while (true) {
            final int read = this.val$reader.read();
            if (read == -1) {
                if (!this.hitPadding && !this.this$0.alphabet.isValidPaddingStartPosition(this.readChars)) {
                    throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append(this.readChars).toString());
                }
                return -1;
            }
            else {
                ++this.readChars;
                final char c = (char)read;
                if (this.paddingMatcher.matches(c)) {
                    if (!this.hitPadding && (this.readChars == 1 || !this.this$0.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                        throw new BaseEncoding$DecodingException(new StringBuilder(41).append("Padding cannot start at index ").append(this.readChars).toString());
                    }
                    this.hitPadding = true;
                }
                else {
                    if (this.hitPadding) {
                        throw new BaseEncoding$DecodingException(new StringBuilder(61).append("Expected padding character but found '").append(c).append("' at index ").append(this.readChars).toString());
                    }
                    this.bitBuffer <<= this.this$0.alphabet.bitsPerChar;
                    this.bitBuffer |= this.this$0.alphabet.decode(c);
                    this.bitBufferLength += this.this$0.alphabet.bitsPerChar;
                    if (this.bitBufferLength >= 8) {
                        this.bitBufferLength -= 8;
                        return this.bitBuffer >> this.bitBufferLength & 0xFF;
                    }
                    continue;
                }
            }
        }
    }
    
    @Override
    public void close() {
        this.val$reader.close();
    }
}
