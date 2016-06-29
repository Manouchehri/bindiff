package com.google.security.zynamics.zylib.general;

public class Pair
{
    private final Object first;
    private final Object second;
    
    public Pair(final Object first, final Object second) {
        this.first = first;
        this.second = second;
    }
    
    public static Pair make(final Object o, final Object o2) {
        return new Pair(o, o2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        final Pair pair = (Pair)o;
        return ((pair.first != null && pair.first.equals(this.first)) || (pair.first == null && this.first == null)) && ((pair.second != null && pair.second.equals(this.second)) || (pair.second == null && this.second == null));
    }
    
    public Object first() {
        return this.first;
    }
    
    @Override
    public int hashCode() {
        return ((this.first == null) ? 1 : this.first.hashCode()) * ((this.second == null) ? 1 : this.second.hashCode());
    }
    
    public Object second() {
        return this.second;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.first);
        final String value2 = String.valueOf(this.second);
        return new StringBuilder(5 + String.valueOf(value).length() + String.valueOf(value2).length()).append("< ").append(value).append(", ").append(value2).append(">").toString();
    }
}
