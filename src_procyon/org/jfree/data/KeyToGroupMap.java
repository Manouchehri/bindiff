package org.jfree.data;

import java.io.*;
import org.jfree.util.*;
import java.util.*;
import java.lang.reflect.*;

public class KeyToGroupMap implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -2228169345475318082L;
    private Comparable defaultGroup;
    private List groups;
    private Map keyToGroupMap;
    
    public KeyToGroupMap() {
        this("Default Group");
    }
    
    public KeyToGroupMap(final Comparable defaultGroup) {
        if (defaultGroup == null) {
            throw new IllegalArgumentException("Null 'defaultGroup' argument.");
        }
        this.defaultGroup = defaultGroup;
        this.groups = new ArrayList();
        this.keyToGroupMap = new HashMap();
    }
    
    public int getGroupCount() {
        return this.groups.size() + 1;
    }
    
    public List getGroups() {
        final ArrayList list = new ArrayList<Comparable>();
        list.add(this.defaultGroup);
        for (final Comparable comparable : this.groups) {
            if (!list.contains(comparable)) {
                list.add(comparable);
            }
        }
        return list;
    }
    
    public int getGroupIndex(final Comparable comparable) {
        int index = this.groups.indexOf(comparable);
        if (index < 0) {
            if (this.defaultGroup.equals(comparable)) {
                index = 0;
            }
        }
        else {
            ++index;
        }
        return index;
    }
    
    public Comparable getGroup(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        Comparable defaultGroup = this.defaultGroup;
        final Comparable comparable2 = this.keyToGroupMap.get(comparable);
        if (comparable2 != null) {
            defaultGroup = comparable2;
        }
        return defaultGroup;
    }
    
    public void mapKeyToGroup(final Comparable comparable, final Comparable comparable2) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        final Comparable group = this.getGroup(comparable);
        if (!group.equals(this.defaultGroup) && !group.equals(comparable2) && this.getKeyCount(group) == 1) {
            this.groups.remove(group);
        }
        if (comparable2 == null) {
            this.keyToGroupMap.remove(comparable);
        }
        else {
            if (!this.groups.contains(comparable2) && !this.defaultGroup.equals(comparable2)) {
                this.groups.add(comparable2);
            }
            this.keyToGroupMap.put(comparable, comparable2);
        }
    }
    
    public int getKeyCount(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'group' argument.");
        }
        int n = 0;
        final Iterator<Comparable<?>> iterator = this.keyToGroupMap.values().iterator();
        while (iterator.hasNext()) {
            if (comparable.equals(iterator.next())) {
                ++n;
            }
        }
        return n;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyToGroupMap)) {
            return false;
        }
        final KeyToGroupMap keyToGroupMap = (KeyToGroupMap)o;
        return ObjectUtilities.equal(this.defaultGroup, keyToGroupMap.defaultGroup) && this.keyToGroupMap.equals(keyToGroupMap.keyToGroupMap);
    }
    
    public Object clone() {
        final KeyToGroupMap keyToGroupMap = (KeyToGroupMap)super.clone();
        keyToGroupMap.defaultGroup = (Comparable)clone(this.defaultGroup);
        keyToGroupMap.groups = (List)clone(this.groups);
        keyToGroupMap.keyToGroupMap = (Map)clone(this.keyToGroupMap);
        return keyToGroupMap;
    }
    
    private static Object clone(final Object o) {
        if (o == null) {
            return null;
        }
        final Class<?> class1 = o.getClass();
        Object invoke = null;
        try {
            final Method method = class1.getMethod("clone", (Class[])null);
            if (Modifier.isPublic(method.getModifiers())) {
                try {
                    invoke = method.invoke(o, (Object[])null);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        catch (NoSuchMethodException ex2) {
            invoke = o;
        }
        return invoke;
    }
    
    private static Collection clone(final Collection collection) {
        Collection<Object> collection2 = null;
        if (collection != null) {
            try {
                final List list = (List)collection.getClass().newInstance();
                final Iterator<Object> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    list.add(clone(iterator.next()));
                }
                collection2 = (Collection<Object>)list;
            }
            catch (Exception ex) {
                throw new CloneNotSupportedException("Exception.");
            }
        }
        return collection2;
    }
}
