package y.f.i;

import java.util.*;
import y.g.*;

class aB implements Comparator
{
    public int compare(final Object o, final Object o2) {
        final int a = e.a(((ag)o).a(), ((ag)o2).a());
        if (a != 0) {
            return a;
        }
        final int a2 = e.a(((ag)o).b(), ((ag)o2).b());
        if (a2 != 0) {
            return a2;
        }
        return e.a(((ag)o).c(), ((ag)o2).c());
    }
}
