package org.jfree.ui.action;

import java.util.*;
import javax.swing.*;

public class DowngradeActionMap
{
    private final HashMap actionMap;
    private final ArrayList actionList;
    private DowngradeActionMap parent;
    
    public DowngradeActionMap() {
        this.actionMap = new HashMap();
        this.actionList = new ArrayList();
    }
    
    public void setParent(final DowngradeActionMap parent) {
        this.parent = parent;
    }
    
    public DowngradeActionMap getParent() {
        return this.parent;
    }
    
    public void put(final Object o, final Action action) {
        if (action == null) {
            this.remove(o);
        }
        else {
            if (this.actionMap.containsKey(o)) {
                this.remove(o);
            }
            this.actionMap.put(o, action);
            this.actionList.add(o);
        }
    }
    
    public Action get(final Object o) {
        final Action action = this.actionMap.get(o);
        if (action != null) {
            return action;
        }
        if (this.parent != null) {
            return this.parent.get(o);
        }
        return null;
    }
    
    public void remove(final Object o) {
        this.actionMap.remove(o);
        this.actionList.remove(o);
    }
    
    public void clear() {
        this.actionMap.clear();
        this.actionList.clear();
    }
    
    public Object[] keys() {
        return this.actionList.toArray();
    }
    
    public int size() {
        return this.actionMap.size();
    }
    
    public Object[] allKeys() {
        if (this.parent == null) {
            return this.keys();
        }
        final Object[] allKeys = this.parent.allKeys();
        final Object[] keys = this.keys();
        final Object[] array = new Object[allKeys.length + keys.length];
        System.arraycopy(keys, 0, array, 0, keys.length);
        System.arraycopy(array, 0, array, keys.length, array.length);
        return array;
    }
}
