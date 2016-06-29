package com.google.protobuf;

import java.io.*;

public class TextFormat$ParseException extends IOException
{
    private static final long serialVersionUID = 3196188060225107702L;
    private final int line;
    private final int column;
    
    public TextFormat$ParseException(final String s) {
        this(-1, -1, s);
    }
    
    public TextFormat$ParseException(final int line, final int column, final String s) {
        final String value = String.valueOf(String.valueOf(Integer.toString(line)));
        final String value2 = String.valueOf(String.valueOf(s));
        super(new StringBuilder(14 + value.length() + value2.length()).append(value).append(":").append(column).append(": ").append(value2).toString());
        this.line = line;
        this.column = column;
    }
    
    public int getLine() {
        return this.line;
    }
    
    public int getColumn() {
        return this.column;
    }
}
