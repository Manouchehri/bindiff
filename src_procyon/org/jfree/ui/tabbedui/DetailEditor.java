package org.jfree.ui.tabbedui;

import javax.swing.*;

public abstract class DetailEditor extends JComponent
{
    private Object object;
    private boolean confirmed;
    
    public void update() {
        if (this.object == null) {
            throw new IllegalStateException();
        }
        this.updateObject(this.object);
        this.setConfirmed(false);
    }
    
    public Object getObject() {
        return this.object;
    }
    
    public void setObject(final Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.object = object;
        this.setConfirmed(false);
        this.fillObject();
    }
    
    protected static int parseInt(final String s, final int n) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public abstract void clear();
    
    protected abstract void fillObject();
    
    protected abstract void updateObject(final Object p0);
    
    public boolean isConfirmed() {
        return this.confirmed;
    }
    
    protected void setConfirmed(final boolean confirmed) {
        this.firePropertyChange("confirmed", this.confirmed, this.confirmed = confirmed);
    }
}
