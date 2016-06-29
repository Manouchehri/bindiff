package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.Tokenizer;

import com.google.common.base.*;

public class CMultiCommentLineTokenizer
{
    private final String m_text;
    private final String m_delimiter;
    private int m_pointer;
    
    public CMultiCommentLineTokenizer(final String s, final String s2) {
        this.m_pointer = 0;
        this.m_delimiter = (String)Preconditions.checkNotNull(s2, (Object)"Error: Text delimiter can't be null.");
        Preconditions.checkArgument(!"".equals(s2), (Object)"Error: Text delimiter can't be empty.");
        this.m_text = (String)Preconditions.checkNotNull(s, (Object)"Error: Text can't be null.");
    }
    
    public boolean hasMoreTokens() {
        return this.m_pointer < this.m_text.length();
    }
    
    public String nextToken() {
        if (this.m_pointer >= this.m_text.length()) {
            return null;
        }
        final int pointer = this.m_pointer;
        int length = this.m_text.indexOf(this.m_delimiter, pointer) + 1;
        if (length == 0) {
            length = this.m_text.length();
        }
        this.m_pointer = length;
        String s = this.m_text.substring(pointer, length);
        if (!this.hasMoreTokens() && !s.isEmpty() && !s.endsWith("\r")) {
            s = String.valueOf(s).concat("\r");
        }
        return s;
    }
}
