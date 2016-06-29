/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSequenceReader;
import com.google.common.io.CharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1;
import com.google.common.io.LineProcessor;
import java.io.Reader;
import java.util.Iterator;
import java.util.regex.Pattern;

class CharSource$CharSequenceCharSource
extends CharSource {
    private static final Splitter LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
    private final CharSequence seq;

    protected CharSource$CharSequenceCharSource(CharSequence charSequence) {
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
        if (this.seq.length() != 0) return false;
        return true;
    }

    @Override
    public long length() {
        return this.seq.length();
    }

    @Override
    public Optional lengthIfKnown() {
        return Optional.of(Long.valueOf(this.seq.length()));
    }

    private Iterable lines() {
        return new CharSource$CharSequenceCharSource$1(this);
    }

    @Override
    public String readFirstLine() {
        Iterator iterator = this.lines().iterator();
        if (!iterator.hasNext()) return null;
        String string = (String)iterator.next();
        return string;
    }

    @Override
    public ImmutableList readLines() {
        return ImmutableList.copyOf(this.lines());
    }

    @Override
    public Object readLines(LineProcessor lineProcessor) {
        String string;
        Iterator iterator = this.lines().iterator();
        do {
            if (!iterator.hasNext()) return lineProcessor.getResult();
        } while (lineProcessor.processLine(string = (String)iterator.next()));
        return lineProcessor.getResult();
    }

    public String toString() {
        String string = CharSource$CharSequenceCharSource.truncate(this.seq, 30, "...");
        return new StringBuilder(17 + String.valueOf(string).length()).append("CharSource.wrap(").append(string).append(")").toString();
    }

    private static String truncate(CharSequence charSequence, int n2, String string) {
        Preconditions.checkNotNull(charSequence);
        int n3 = n2 - string.length();
        Preconditions.checkArgument(n3 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n2, string.length());
        if (charSequence.length() > n2) return new StringBuilder(n2).append(charSequence, 0, n3).append(string).toString();
        String string2 = charSequence.toString();
        if (string2.length() <= n2) {
            return string2;
        }
        charSequence = string2;
        return new StringBuilder(n2).append(charSequence, 0, n3).append(string).toString();
    }

    static /* synthetic */ CharSequence access$100(CharSource$CharSequenceCharSource charSource$CharSequenceCharSource) {
        return charSource$CharSequenceCharSource.seq;
    }

    static /* synthetic */ Splitter access$200() {
        return LINE_SPLITTER;
    }
}

