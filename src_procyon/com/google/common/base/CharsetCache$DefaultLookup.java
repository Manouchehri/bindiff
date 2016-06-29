package com.google.common.base;

import java.nio.charset.*;

class CharsetCache$DefaultLookup implements Function
{
    public Charset apply(final String s) {
        return Charset.forName(s);
    }
}
