package com.google.common.io;

import java.io.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.collect.*;
import java.util.regex.*;

class CharSource$CharSequenceCharSource extends CharSource
{
    private static final Splitter LINE_SPLITTER;
    private final CharSequence seq;
    
    protected CharSource$CharSequenceCharSource(final CharSequence charSequence) {
        this.seq = (CharSequence)Preconditions.checkNotNull(charSequence);
    }
    
    @Override
    public Reader openStream() {
        return new CharSequenceReader(this.seq);
    }
    
    @Override
    public String read() {
        return this.seq.toString();
    }
    
    @Override
    public boolean isEmpty() {
        return this.seq.length() == 0;
    }
    
    @Override
    public long length() {
        return this.seq.length();
    }
    
    @Override
    public Optional lengthIfKnown() {
        return Optional.of((long)this.seq.length());
    }
    
    private Iterable lines() {
        return new CharSource$CharSequenceCharSource$1(this);
    }
    
    @Override
    public String readFirstLine() {
        final Iterator<String> iterator = (Iterator<String>)this.lines().iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }
    
    @Override
    public ImmutableList readLines() {
        return ImmutableList.copyOf(this.lines());
    }
    
    @Override
    public Object readLines(final LineProcessor lineProcessor) {
        final Iterator<String> iterator = (Iterator<String>)this.lines().iterator();
        while (iterator.hasNext() && lineProcessor.processLine(iterator.next())) {}
        return lineProcessor.getResult();
    }
    
    @Override
    public String toString() {
        final String truncate = truncate(this.seq, 30, "...");
        return new StringBuilder(17 + String.valueOf(truncate).length()).append("CharSource.wrap(").append(truncate).append(")").toString();
    }
    
    private static String truncate(CharSequence charSequence, final int n, final String s) {
        Preconditions.checkNotNull(charSequence);
        final int n2 = n - s.length();
        Preconditions.checkArgument(n2 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n, s.length());
        if (charSequence.length() <= n) {
            final String string = charSequence.toString();
            if (string.length() <= n) {
                return string;
            }
            charSequence = string;
        }
        return new StringBuilder(n).append(charSequence, 0, n2).append(s).toString();
    }
    
    static {
        LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
    }
}
