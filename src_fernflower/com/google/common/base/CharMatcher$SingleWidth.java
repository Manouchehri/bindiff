package com.google.common.base;

import com.google.common.base.CharMatcher$RangesMatcher;

final class CharMatcher$SingleWidth extends CharMatcher$RangesMatcher {
   static final CharMatcher$SingleWidth INSTANCE = new CharMatcher$SingleWidth();

   private CharMatcher$SingleWidth() {
      super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray());
   }
}
