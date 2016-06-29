/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

public class Pair {
    private final Object first;
    private final Object second;

    public Pair(Object object, Object object2) {
        this.first = object;
        this.second = object2;
    }

    public static Pair make(Object object, Object object2) {
        return new Pair(object, object2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair)object;
        if (pair.first == null || !pair.first.equals(this.first)) {
            if (pair.first != null) return false;
            if (this.first != null) return false;
        }
        if (pair.second != null) {
            if (pair.second.equals(this.second)) return true;
        }
        if (pair.second != null) return false;
        if (this.second != null) return false;
        return true;
    }

    public Object first() {
        return this.first;
    }

    public int hashCode() {
        int n2;
        int n3 = this.first == null ? 1 : this.first.hashCode();
        if (this.second == null) {
            n2 = 1;
            return n3 * n2;
        }
        n2 = this.second.hashCode();
        return n3 * n2;
    }

    public Object second() {
        return this.second;
    }

    public String toString() {
        String string = String.valueOf(this.first);
        String string2 = String.valueOf(this.second);
        return new StringBuilder(5 + String.valueOf(string).length() + String.valueOf(string2).length()).append("< ").append(string).append(", ").append(string2).append(">").toString();
    }
}

