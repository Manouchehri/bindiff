package y.h;

import java.util.*;
import y.c.*;
import java.beans.*;

public class gV implements gT
{
    private Stack b;
    private gX c;
    private ch d;
    private D e;
    protected gU a;
    private PropertyChangeSupport f;
    
    public gV() {
        this.b = new Stack();
        this.e = new D();
        this.c = null;
        this.f = new PropertyChangeSupport(this);
    }
    
    public gV(final gU gu) {
        this();
        this.a(gu);
    }
    
    public void a(final gU a) {
        if (this.a != null) {
            this.a();
        }
        if (a != null) {
            a.addViewChangeListener(this);
            this.a = a;
            this.d = null;
            final gI currentView = a.getCurrentView();
            if (currentView != null && currentView instanceof ch) {
                this.d = (ch)currentView;
            }
            if (this.d != null && this.c != null) {
                this.a(this.c);
            }
        }
    }
    
    public void a() {
        this.a = null;
        if (this.d != null && this.c != null) {
            this.d.removeViewMode(this.c);
        }
    }
    
    public void b() {
        this.a(this.b.pop());
    }
    
    protected void a(final gX c) {
        if (this.c != null) {
            b(this.d, this.c);
        }
        this.f.firePropertyChange("Mode", this.c, c);
        this.c = c;
        a(this.d, this.c);
    }
    
    protected static void a(final ch activeView, final gX gx) {
        if (activeView == null || gx == null) {
            return;
        }
        gx.setActiveView(activeView);
        activeView.addViewMode(gx);
    }
    
    protected static void b(final ch ch, final gX gx) {
        if (ch == null) {
            return;
        }
        ch.removeViewMode(gx);
    }
}
