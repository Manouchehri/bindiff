package y.h;

import y.c.*;

class ii extends q
{
    fj l;
    
    protected ii(final bu bu, final fj l) {
        super(bu);
        if (l != null) {
            (this.l = l).b(this);
        }
    }
    
    public q a(final i i) {
        if (i instanceof bu) {
            return ((bu)i).a(this.l.createCopy());
        }
        return super.a(i);
    }
    
    public String toString() {
        if (this.l != null && this.l.labelCount() > 0) {
            final String labelText = this.l.getLabelText();
            if (labelText != null && labelText.length() > 0) {
                return labelText;
            }
        }
        return super.toString();
    }
}
