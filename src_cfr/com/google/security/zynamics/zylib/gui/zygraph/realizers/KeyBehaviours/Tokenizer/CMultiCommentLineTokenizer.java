/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.Tokenizer;

import com.google.common.base.Preconditions;

public class CMultiCommentLineTokenizer {
    private final String m_text;
    private final String m_delimiter;
    private int m_pointer = 0;

    public CMultiCommentLineTokenizer(String string, String string2) {
        this.m_delimiter = (String)Preconditions.checkNotNull(string2, "Error: Text delimiter can't be null.");
        Preconditions.checkArgument(!"".equals(string2), "Error: Text delimiter can't be empty.");
        this.m_text = (String)Preconditions.checkNotNull(string, "Error: Text can't be null.");
    }

    public boolean hasMoreTokens() {
        if (this.m_pointer >= this.m_text.length()) return false;
        return true;
    }

    public String nextToken() {
        if (this.m_pointer >= this.m_text.length()) {
            return null;
        }
        int n2 = this.m_pointer;
        int n3 = this.m_text.indexOf(this.m_delimiter, n2) + 1;
        if (n3 == 0) {
            n3 = this.m_text.length();
        }
        this.m_pointer = n3;
        String string = this.m_text.substring(n2, n3);
        if (this.hasMoreTokens()) return string;
        if (string.isEmpty()) return string;
        if (string.endsWith("\r")) return string;
        return String.valueOf(string).concat("\r");
    }
}

