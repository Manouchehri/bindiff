package com.google.security.zynamics.zylib.strings;

import java.util.*;

public final class Commafier
{
    private static String DEFAULT_SEPARATOR;
    private final String m_separator;
    private final StringBuilder sb;
    private boolean needsComma;
    
    public Commafier() {
        this.sb = new StringBuilder();
        this.needsComma = false;
        this.m_separator = Commafier.DEFAULT_SEPARATOR;
    }
    
    public Commafier(final Iterable iterable) {
        this(iterable, Commafier.DEFAULT_SEPARATOR);
    }
    
    public Commafier(final Iterable iterable, final String separator) {
        this.sb = new StringBuilder();
        this.needsComma = false;
        this.m_separator = separator;
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.append(iterator.next());
        }
    }
    
    public Commafier(final String s) {
        this.sb = new StringBuilder();
        this.needsComma = false;
        this.m_separator = Commafier.DEFAULT_SEPARATOR;
        this.sb.append(s);
    }
    
    public static String commafy(final Iterable iterable) {
        return new Commafier(iterable).toString();
    }
    
    public static String commafy(final Iterable iterable, final String s) {
        return new Commafier(iterable, s).toString();
    }
    
    public void append(final Object o) {
        if (this.needsComma) {
            this.sb.append(this.m_separator);
        }
        this.needsComma = true;
        this.sb.append(o);
    }
    
    public void appendUncommafied(final String s) {
        this.sb.append(s);
    }
    
    @Override
    public String toString() {
        return this.sb.toString();
    }
    
    static {
        Commafier.DEFAULT_SEPARATOR = ", ";
    }
}
