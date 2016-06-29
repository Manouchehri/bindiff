/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

public class Quad {
    private final Object m_first;
    private final Object m_second;
    private final Object m_third;
    private final Object m_fourth;

    public Quad(Object object, Object object2, Object object3, Object object4) {
        this.m_first = object;
        this.m_second = object2;
        this.m_third = object3;
        this.m_fourth = object4;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Quad)) {
            return false;
        }
        Quad quad = (Quad)object;
        if (quad.first() != null || this.m_first != null) {
            if (quad.first() == null) return false;
            if (this.m_first == null) {
                return false;
            }
            if (!quad.m_first.equals(this.m_first)) {
                return false;
            }
        }
        if (quad.second() != null || this.m_second != null) {
            if (quad.second() == null) return false;
            if (this.m_second == null) {
                return false;
            }
            if (!quad.m_second.equals(this.m_second)) {
                return false;
            }
        }
        if (quad.third() != null || this.m_third != null) {
            if (quad.third() == null) return false;
            if (this.m_third == null) {
                return false;
            }
            if (!quad.m_third.equals(this.m_third)) {
                return false;
            }
        }
        if (quad.fourth() == null) {
            if (this.m_fourth == null) return true;
        }
        if (quad.fourth() == null) return false;
        if (this.m_fourth == null) {
            return false;
        }
        if (quad.m_fourth.equals(this.m_fourth)) return true;
        return false;
    }

    public Object first() {
        return this.m_first;
    }

    public Object fourth() {
        return this.m_fourth;
    }

    public int hashCode() {
        int n2;
        int n3 = this.m_first == null ? 1 : this.m_first.hashCode();
        int n4 = this.m_second == null ? 1 : this.m_second.hashCode();
        int n5 = this.m_third == null ? 1 : this.m_third.hashCode();
        if (this.m_fourth == null) {
            n2 = 1;
            return n3 * n4 * n5 * n2;
        }
        n2 = this.m_fourth.hashCode();
        return n3 * n4 * n5 * n2;
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
        String string4 = String.valueOf(this.m_fourth);
        return new StringBuilder(9 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length()).append("< ").append(string).append(", ").append(string2).append(", ").append(string3).append(", ").append(string4).append(">").toString();
    }
}

