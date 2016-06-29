package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;

@VisibleForTesting
final class CharMatcher$Whitespace extends CharMatcher$NamedFastMatcher
{
    static final String TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000";
    static final int MULTIPLIER = 1682554634;
    static final int SHIFT;
    static final CharMatcher$Whitespace INSTANCE;
    
    CharMatcher$Whitespace() {
        super("CharMatcher.whitespace()");
    }
    
    @Override
    public boolean matches(final char c) {
        return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(1682554634 * c >>> CharMatcher$Whitespace.SHIFT) == c;
    }
    
    @GwtIncompatible("java.util.BitSet")
    @Override
    void setBits(final BitSet set) {
        for (int i = 0; i < "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length(); ++i) {
            set.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(i));
        }
    }
    
    static {
        SHIFT = Integer.numberOfLeadingZeros("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f \f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length() - 1);
        INSTANCE = new CharMatcher$Whitespace();
    }
}
