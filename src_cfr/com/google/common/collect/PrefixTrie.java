/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.collect.Maps;
import com.google.common.collect.PrefixMap;
import com.google.common.collect.PrefixTrie$Node;
import java.util.LinkedHashMap;
import java.util.Map;

@GoogleInternal
public class PrefixTrie
implements PrefixMap {
    private final char rangeOffset;
    private final int rangeSize;
    private final PrefixTrie$Node root;

    public PrefixTrie() {
        this.rangeOffset = '\u0000';
        this.rangeSize = 128;
        this.root = new PrefixTrie$Node(this.rangeSize);
    }

    public PrefixTrie(char c2, char c3) {
        this.rangeOffset = c2;
        this.rangeSize = c3 - c2 + 1;
        if (this.rangeSize <= 0) {
            throw new IllegalArgumentException("Char range must include some chars");
        }
        this.root = new PrefixTrie$Node(this.rangeSize);
    }

    @Override
    public Object put(CharSequence charSequence, Object object) {
        if (object != null) return this.putInternal(charSequence, object);
        throw new NullPointerException();
    }

    private Object putInternal(CharSequence charSequence, Object object) {
        PrefixTrie$Node prefixTrie$Node = this.root;
        int n2 = 0;
        do {
            if (n2 >= charSequence.length()) {
                Object object2 = prefixTrie$Node.value;
                prefixTrie$Node.value = object;
                return object2;
            }
            int n3 = charSequence.charAt(n2) - this.rangeOffset;
            try {
                PrefixTrie$Node prefixTrie$Node2 = prefixTrie$Node.next[n3];
                if (prefixTrie$Node2 == null) {
                    prefixTrie$Node2 = prefixTrie$Node.next[n3] = new PrefixTrie$Node(this.rangeSize);
                }
                prefixTrie$Node = prefixTrie$Node2;
            }
            catch (ArrayIndexOutOfBoundsException var6_8) {
                char c2 = charSequence.charAt(n2);
                throw new IllegalArgumentException(new StringBuilder(36).append("'").append(c2).append("' is not a legal prefix character.").toString());
            }
            ++n2;
        } while (true);
    }

    @Override
    public Object get(CharSequence charSequence) {
        PrefixTrie$Node prefixTrie$Node = this.root;
        PrefixTrie$Node prefixTrie$Node2 = this.root;
        int n2 = 0;
        while (n2 < charSequence.length()) {
            int n3 = charSequence.charAt(n2) - this.rangeOffset;
            if (n3 < 0) return null;
            if (this.rangeSize <= n3) {
                return null;
            }
            prefixTrie$Node2 = prefixTrie$Node2.next[n3];
            if (prefixTrie$Node2 == null) {
                return prefixTrie$Node.value;
            }
            if (prefixTrie$Node2.value != null) {
                prefixTrie$Node = prefixTrie$Node2;
            }
            ++n2;
        }
        return prefixTrie$Node.value;
    }

    @Override
    public Object remove(CharSequence charSequence) {
        return this.putInternal(charSequence, null);
    }

    public Map toMap() {
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        this.addEntries(this.root, new StringBuilder(), linkedHashMap);
        return linkedHashMap;
    }

    private void addEntries(PrefixTrie$Node prefixTrie$Node, StringBuilder stringBuilder, Map map) {
        if (prefixTrie$Node.value != null) {
            map.put(stringBuilder.toString(), prefixTrie$Node.value);
        }
        int n2 = 0;
        while (n2 < prefixTrie$Node.next.length) {
            PrefixTrie$Node prefixTrie$Node2 = prefixTrie$Node.next[n2];
            if (prefixTrie$Node2 != null) {
                stringBuilder.append((char)(n2 + this.rangeOffset));
                this.addEntries(prefixTrie$Node2, stringBuilder, map);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            ++n2;
        }
    }
}

