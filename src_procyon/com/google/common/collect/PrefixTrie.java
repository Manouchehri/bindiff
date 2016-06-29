package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import java.io.*;

@GoogleInternal
public class PrefixTrie implements PrefixMap
{
    private final char rangeOffset;
    private final int rangeSize;
    private final PrefixTrie$Node root;
    
    public PrefixTrie() {
        this.rangeOffset = '\0';
        this.rangeSize = 128;
        this.root = new PrefixTrie$Node(this.rangeSize);
    }
    
    public PrefixTrie(final char rangeOffset, final char c) {
        this.rangeOffset = rangeOffset;
        this.rangeSize = c - rangeOffset + '\u0001';
        if (this.rangeSize <= 0) {
            throw new IllegalArgumentException("Char range must include some chars");
        }
        this.root = new PrefixTrie$Node(this.rangeSize);
    }
    
    @Override
    public Object put(final CharSequence charSequence, final Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return this.putInternal(charSequence, o);
    }
    
    private Object putInternal(final CharSequence charSequence, final Object value) {
        PrefixTrie$Node root = this.root;
        for (int i = 0; i < charSequence.length(); ++i) {
            final char c = (char)(charSequence.charAt(i) - this.rangeOffset);
            try {
                PrefixTrie$Node prefixTrie$Node = root.next[c];
                if (prefixTrie$Node == null) {
                    final PrefixTrie$Node[] next = root.next;
                    final char c2 = c;
                    final PrefixTrie$Node prefixTrie$Node2 = new PrefixTrie$Node(this.rangeSize);
                    next[c2] = prefixTrie$Node2;
                    prefixTrie$Node = prefixTrie$Node2;
                }
                root = prefixTrie$Node;
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                throw new IllegalArgumentException(new StringBuilder(36).append("'").append(charSequence.charAt(i)).append("' is not a legal prefix character.").toString());
            }
        }
        final Object value2 = root.value;
        root.value = value;
        return value2;
    }
    
    @Override
    public Object get(final CharSequence charSequence) {
        PrefixTrie$Node root = this.root;
        PrefixTrie$Node root2 = this.root;
        for (int i = 0; i < charSequence.length(); ++i) {
            final char c = (char)(charSequence.charAt(i) - this.rangeOffset);
            if (c < '\0' || this.rangeSize <= c) {
                return null;
            }
            root2 = root2.next[c];
            if (root2 == null) {
                break;
            }
            if (root2.value != null) {
                root = root2;
            }
        }
        return root.value;
    }
    
    @Override
    public Object remove(final CharSequence charSequence) {
        return this.putInternal(charSequence, null);
    }
    
    public Map toMap() {
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        this.addEntries(this.root, new StringBuilder(), linkedHashMap);
        return linkedHashMap;
    }
    
    private void addEntries(final PrefixTrie$Node prefixTrie$Node, final StringBuilder sb, final Map map) {
        if (prefixTrie$Node.value != null) {
            map.put(sb.toString(), prefixTrie$Node.value);
        }
        for (char c = '\0'; c < prefixTrie$Node.next.length; ++c) {
            final PrefixTrie$Node prefixTrie$Node2 = prefixTrie$Node.next[c];
            if (prefixTrie$Node2 != null) {
                sb.append((char)(c + this.rangeOffset));
                this.addEntries(prefixTrie$Node2, sb, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
