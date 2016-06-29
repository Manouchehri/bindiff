package y.f.c.a;

import java.util.*;
import y.g.*;

class cz implements Comparator, g
{
    private cz() {
    }
    
    public int compare(final Object o, final Object o2) {
        final cy cy = (cy)o;
        final cy cy2 = (cy)o2;
        final byte a = cy.a();
        final byte a2 = cy2.a();
        if (a != a2) {
            return e.a(a, a2);
        }
        switch (a) {
            case 0: {
                if (cy.b > cy2.b && cy.c < cy2.c) {
                    return -1;
                }
                if (cy.b <= cy2.b && cy.c >= cy2.c) {
                    return 1;
                }
                if (cy.c < cy2.b) {
                    return -1;
                }
                if (cy.c >= cy2.b) {
                    return 1;
                }
                break;
            }
            case 2: {
                if (cy.b > cy2.b && cy.c > cy2.c) {
                    return -1;
                }
                if (cy.b <= cy2.b && cy.c <= cy2.c) {
                    return 1;
                }
                if (cy.b == cy2.b) {
                    return (cy.c > cy2.c) ? -1 : 1;
                }
                if (cy.c == cy2.c) {
                    return (cy.b > cy2.b) ? -1 : 1;
                }
                return (cy.b <= cy2.b) ? -1 : 1;
            }
            case 1: {
                if (cy.b < cy2.b && cy.c < cy2.c) {
                    return -1;
                }
                if (cy.b >= cy2.b && cy.c >= cy2.c) {
                    return 1;
                }
                if (cy.b == cy2.b) {
                    return (cy.c < cy2.c) ? -1 : 1;
                }
                if (cy.c == cy2.c) {
                    return (cy.b < cy2.b) ? -1 : 1;
                }
                return (cy.b >= cy2.b) ? -1 : 1;
            }
            case 3: {
                if (cy.b < cy2.b && cy.c > cy2.c) {
                    return -1;
                }
                if (cy.b > cy2.b && cy.c < cy2.c) {
                    return 1;
                }
                if (cy.c < cy2.b) {
                    return 1;
                }
                if (cy2.c < cy.b) {
                    return -1;
                }
                break;
            }
        }
        final int a3 = e.a(cy.b, cy2.b);
        if (a3 != 0) {
            return a3;
        }
        final int a4 = e.a(cy.c, cy2.c);
        if (a4 == 0) {
            return -e.a(cy.b, cy2.b);
        }
        return a4;
    }
    
    cz(final cs cs) {
        this();
    }
}
