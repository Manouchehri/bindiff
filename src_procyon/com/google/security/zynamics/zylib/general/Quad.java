package com.google.security.zynamics.zylib.general;

public class Quad
{
    private final Object m_first;
    private final Object m_second;
    private final Object m_third;
    private final Object m_fourth;
    
    public Quad(final Object first, final Object second, final Object third, final Object fourth) {
        this.m_first = first;
        this.m_second = second;
        this.m_third = third;
        this.m_fourth = fourth;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Quad)) {
            return false;
        }
        final Quad quad = (Quad)o;
        if (quad.first() != null || this.m_first != null) {
            if (quad.first() == null || this.m_first == null) {
                return false;
            }
            if (!quad.m_first.equals(this.m_first)) {
                return false;
            }
        }
        if (quad.second() != null || this.m_second != null) {
            if (quad.second() == null || this.m_second == null) {
                return false;
            }
            if (!quad.m_second.equals(this.m_second)) {
                return false;
            }
        }
        if (quad.third() != null || this.m_third != null) {
            if (quad.third() == null || this.m_third == null) {
                return false;
            }
            if (!quad.m_third.equals(this.m_third)) {
                return false;
            }
        }
        if (quad.fourth() != null || this.m_fourth != null) {
            if (quad.fourth() == null || this.m_fourth == null) {
                return false;
            }
            if (!quad.m_fourth.equals(this.m_fourth)) {
                return false;
            }
        }
        return true;
    }
    
    public Object first() {
        return this.m_first;
    }
    
    public Object fourth() {
        return this.m_fourth;
    }
    
    @Override
    public int hashCode() {
        return ((this.m_first == null) ? 1 : this.m_first.hashCode()) * ((this.m_second == null) ? 1 : this.m_second.hashCode()) * ((this.m_third == null) ? 1 : this.m_third.hashCode()) * ((this.m_fourth == null) ? 1 : this.m_fourth.hashCode());
    }
    
    public Object second() {
        return this.m_second;
    }
    
    public Object third() {
        return this.m_third;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.m_first);
        final String value2 = String.valueOf(this.m_second);
        final String value3 = String.valueOf(this.m_third);
        final String value4 = String.valueOf(this.m_fourth);
        return new StringBuilder(9 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(value3).length() + String.valueOf(value4).length()).append("< ").append(value).append(", ").append(value2).append(", ").append(value3).append(", ").append(value4).append(">").toString();
    }
}
