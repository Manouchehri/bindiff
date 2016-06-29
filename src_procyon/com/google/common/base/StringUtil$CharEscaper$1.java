package com.google.common.base;

final class StringUtil$CharEscaper$1 extends ThreadLocal
{
    @Override
    protected char[] initialValue() {
        return new char[1024];
    }
}
