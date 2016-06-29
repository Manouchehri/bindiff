package y.c;

import java.util.*;

public class l extends EventObject
{
    private Object a;
    private byte b;
    
    public l(final i i, final byte b, final Object a) {
        super(i);
        this.b = b;
        this.a = a;
    }
    
    public byte a() {
        return this.b;
    }
    
    public Object b() {
        return this.a;
    }
    
    public i c() {
        return (i)this.getSource();
    }
    
    public String toString() {
        return this.a(this.a());
    }
    
    private String a(final byte b) {
        switch (b) {
            case 0: {
                return "NODE_CREATION";
            }
            case 1: {
                return "EDGE_CREATION";
            }
            case 2: {
                return "PRE_NODE_REMOVAL";
            }
            case 3: {
                return "POST_NODE_REMOVAL";
            }
            case 4: {
                return "PRE_EDGE_REMOVAL";
            }
            case 5: {
                return "POST_EDGE_REMOVAL";
            }
            case 6: {
                return "NODE_REINSERTION";
            }
            case 7: {
                return "EDGE_REINSERTION";
            }
            case 8: {
                return "PRE_EDGE_CHANGE";
            }
            case 9: {
                return "POST_EDGE_CHANGE";
            }
            case 10: {
                return "SUBGRAPH_INSERTION";
            }
            case 11: {
                return "SUBGRAPH_REMOVAL";
            }
            case 12: {
                return "PRE_EVENT";
            }
            case 13: {
                return "POST_EVENT";
            }
            default: {
                return "UNKNOWN TYPE (" + b + ")";
            }
        }
    }
    
    static l a(final i i, final q q) {
        return new l(i, (byte)0, q);
    }
    
    static l a(final i i, final d d) {
        return new l(i, (byte)1, d);
    }
    
    static l b(final i i, final q q) {
        return new l(i, (byte)2, q);
    }
    
    static l c(final i i, final q q) {
        return new l(i, (byte)3, q);
    }
    
    static l b(final i i, final d d) {
        return new l(i, (byte)4, d);
    }
    
    static l c(final i i, final d d) {
        return new l(i, (byte)5, d);
    }
    
    static l d(final i i, final q q) {
        return new l(i, (byte)6, q);
    }
    
    static l d(final i i, final d d) {
        return new l(i, (byte)7, d);
    }
    
    static l a(final i i) {
        return new l(i, (byte)12, null);
    }
    
    static l b(final i i) {
        return new l(i, (byte)13, null);
    }
}
