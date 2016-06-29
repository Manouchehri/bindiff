package com.google.common.io;

import com.google.common.base.CharMatcher;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import java.io.InputStream;
import java.io.Reader;

class BaseEncoding$StandardBaseEncoding$2 extends InputStream {
   int bitBuffer;
   int bitBufferLength;
   int readChars;
   boolean hitPadding;
   final CharMatcher paddingMatcher;
   // $FF: synthetic field
   final Reader val$reader;
   // $FF: synthetic field
   final BaseEncoding$StandardBaseEncoding this$0;

   BaseEncoding$StandardBaseEncoding$2(BaseEncoding$StandardBaseEncoding var1, Reader var2) {
      this.this$0 = var1;
      this.val$reader = var2;
      this.bitBuffer = 0;
      this.bitBufferLength = 0;
      this.readChars = 0;
      this.hitPadding = false;
      this.paddingMatcher = this.this$0.padding();
   }

   public int read() {
      while(true) {
         int var1 = this.val$reader.read();
         if(var1 == -1) {
            if(!this.hitPadding && !this.this$0.alphabet.isValidPaddingStartPosition(this.readChars)) {
               int var4 = this.readChars;
               throw new BaseEncoding$DecodingException((new StringBuilder(32)).append("Invalid input length ").append(var4).toString());
            }

            return -1;
         }

         ++this.readChars;
         char var2 = (char)var1;
         int var3;
         if(!this.paddingMatcher.matches(var2)) {
            if(this.hitPadding) {
               var3 = this.readChars;
               throw new BaseEncoding$DecodingException((new StringBuilder(61)).append("Expected padding character but found \'").append(var2).append("\' at index ").append(var3).toString());
            }

            this.bitBuffer <<= this.this$0.alphabet.bitsPerChar;
            this.bitBuffer |= this.this$0.alphabet.decode(var2);
            this.bitBufferLength += this.this$0.alphabet.bitsPerChar;
            if(this.bitBufferLength >= 8) {
               this.bitBufferLength -= 8;
               return this.bitBuffer >> this.bitBufferLength & 255;
            }
         } else {
            if(!this.hitPadding && (this.readChars == 1 || !this.this$0.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
               var3 = this.readChars;
               throw new BaseEncoding$DecodingException((new StringBuilder(41)).append("Padding cannot start at index ").append(var3).toString());
            }

            this.hitPadding = true;
         }
      }
   }

   public void close() {
      this.val$reader.close();
   }
}
