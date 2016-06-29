package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
final class ParseRequest
{
    final String rawValue;
    final int radix;
    
    private ParseRequest(final String rawValue, final int radix) {
        this.rawValue = rawValue;
        this.radix = radix;
    }
    
    static ParseRequest fromString(final String s) {
        if (s.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        final char char1 = s.charAt(0);
        String s2;
        int n;
        if (s.startsWith("0x") || s.startsWith("0X")) {
            s2 = s.substring(2);
            n = 16;
        }
        else if (char1 == '#') {
            s2 = s.substring(1);
            n = 16;
        }
        else if (char1 == '0' && s.length() > 1) {
            s2 = s.substring(1);
            n = 8;
        }
        else {
            s2 = s;
            n = 10;
        }
        return new ParseRequest(s2, n);
    }
}
