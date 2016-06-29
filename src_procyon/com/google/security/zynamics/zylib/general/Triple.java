package com.google.security.zynamics.zylib.general;

public class Triple
{
    private final Object m_first;
    private final Object m_second;
    private final Object m_third;
    
    public Triple(final Object first, final Object second, final Object third) {
        this.m_first = first;
        this.m_second = second;
        this.m_third = third;
    }
    
    public static Triple make(final Object o, final Object o2, final Object o3) {
        return new Triple(o, o2, o3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Triple)) {
            return false;
        }
        final Triple triple = (Triple)o;
        if (triple.first() != null || this.m_first != null) {
            if (triple.first() == null || this.m_first == null) {
                return false;
            }
            if (!triple.m_first.equals(this.m_first)) {
                return false;
            }
        }
        if (triple.second() != null || this.m_second != null) {
            if (triple.second() == null || this.m_second == null) {
                return false;
            }
            if (!triple.m_second.equals(this.m_second)) {
                return false;
            }
        }
        if (triple.third() != null || this.m_third != null) {
            if (triple.third() == null || this.m_third == null) {
                return false;
            }
            if (!triple.m_third.equals(this.m_third)) {
                return false;
            }
        }
        return true;
    }
    
    public Object first() {
        return this.m_first;
    }
    
    @Override
    public int hashCode() {
        return ((this.m_first == null) ? 1 : this.m_first.hashCode()) * ((this.m_second == null) ? 1 : this.m_second.hashCode()) * ((this.m_third == null) ? 1 : this.m_third.hashCode());
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
        return new StringBuilder(7 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(value3).length()).append("< ").append(value).append(", ").append(value2).append(", ").append(value3).append(">").toString();
    }
}
