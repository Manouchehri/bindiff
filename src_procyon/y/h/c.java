package y.h;

import java.util.*;
import javax.swing.event.*;

public abstract class c implements dx
{
    private boolean a;
    private boolean b;
    private ArrayList c;
    
    public c() {
        this.a = true;
        this.c = new ArrayList();
    }
    
    public boolean a() {
        return this.a;
    }
    
    public boolean b() {
        return this.a;
    }
    
    public boolean c() {
        return this.b;
    }
    
    public void d() {
        if (!this.b) {
            this.b = true;
            this.f();
        }
    }
    
    public void e() {
        if (this.b) {
            this.b = false;
            this.f();
        }
    }
    
    protected void f() {
        final boolean z = fj.z;
        if (!this.c.isEmpty()) {
            final ChangeEvent changeEvent = new ChangeEvent(this);
            final ChangeListener[] array = new ChangeListener[this.c.size()];
            this.c.toArray(array);
            int i = array.length - 1;
            while (i >= 0) {
                array[i].stateChanged(changeEvent);
                --i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    public void a(final ChangeListener changeListener) {
        this.c.add(changeListener);
    }
    
    public void b(final ChangeListener changeListener) {
        this.c.remove(changeListener);
    }
}
