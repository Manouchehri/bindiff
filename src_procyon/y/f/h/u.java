package y.f.h;

import java.util.*;
import y.c.*;
import y.g.*;

public class u implements Comparator
{
    f a;
    
    public void a(final f a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a.indexOf(o), this.a.indexOf(o2));
    }
}
