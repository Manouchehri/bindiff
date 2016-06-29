/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.strings;

import java.util.Iterator;

public final class Commafier {
    private static String DEFAULT_SEPARATOR = ", ";
    private final String m_separator;
    private final StringBuilder sb = new StringBuilder();
    private boolean needsComma = false;

    public Commafier() {
        this.m_separator = DEFAULT_SEPARATOR;
    }

    public Commafier(Iterable iterable) {
        this(iterable, DEFAULT_SEPARATOR);
    }

    public Commafier(Iterable iterable, String string) {
        this.m_separator = string;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            this.append(t2);
        }
    }

    public Commafier(String string) {
        this.m_separator = DEFAULT_SEPARATOR;
        this.sb.append(string);
    }

    public static String commafy(Iterable iterable) {
        return new Commafier(iterable).toString();
    }

    public static String commafy(Iterable iterable, String string) {
        return new Commafier(iterable, string).toString();
    }

    public void append(Object object) {
        if (this.needsComma) {
            this.sb.append(this.m_separator);
        }
        this.needsComma = true;
        this.sb.append(object);
    }

    public void appendUncommafied(String string) {
        this.sb.append(string);
    }

    public String toString() {
        return this.sb.toString();
    }
}

