/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

public class Triple {
    private final Object m_first;
    private final Object m_second;
    private final Object m_third;

    public Triple(Object object, Object object2, Object object3) {
        this.m_first = object;
        this.m_second = object2;
        this.m_third = object3;
    }

    public static Triple make(Object object, Object object2, Object object3) {
        return new Triple(object, object2, object3);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple)object;
        if (triple.first() != null || this.m_first != null) {
            if (triple.first() == null) return false;
            if (this.m_first == null) {
                return false;
            }
            if (!triple.m_first.equals(this.m_first)) {
                return false;
            }
        }
        if (triple.second() != null || this.m_second != null) {
            if (triple.second() == null) return false;
            if (this.m_second == null) {
                return false;
            }
            if (!triple.m_second.equals(this.m_second)) {
                return false;
            }
        }
        if (triple.third() == null) {
            if (this.m_third == null) return true;
        }
        if (triple.third() == null) return false;
        if (this.m_third == null) {
            return false;
        }
        if (triple.m_third.equals(this.m_third)) return true;
        return false;
    }

    public Object first() {
        return this.m_first;
    }

    public int hashCode() {
        int n2;
        int n3 = this.m_first == null ? 1 : this.m_first.hashCode();
        int n4 = this.m_second == null ? 1 : this.m_second.hashCode();
        if (this.m_third == null) {
            n2 = 1;
            return n3 * n4 * n2;
        }
        n2 = this.m_third.hashCode();
        return n3 * n4 * n2;
    }

    public Object second() {
        return this.m_second;
    }

    public Object third() {
        return this.m_third;
    }

    public String toString() {
        String string = String.valueOf(this.m_first);
        String string2 = String.valueOf(this.m_second);
        String string3 = String.valueOf(this.m_third);
        return new StringBuilder(7 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length()).append("< ").append(string).append(", ").append(string2).append(", ").append(string3).append(">").toString();
    }
}

