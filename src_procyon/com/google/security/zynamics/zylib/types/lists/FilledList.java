package com.google.security.zynamics.zylib.types.lists;

import com.google.common.base.*;
import java.util.*;

public class FilledList extends ArrayList implements IFilledList
{
    public FilledList() {
    }
    
    public FilledList(final Collection collection) {
        super(collection);
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Preconditions.checkNotNull(iterator.next(), (Object)"Error: Can not add null-elements to filled lists");
        }
    }
    
    @Override
    public void add(final int n, final Object o) {
        Preconditions.checkNotNull(o, (Object)"Error: Can not add null-elements to filled lists");
        super.add(n, o);
    }
    
    @Override
    public boolean add(final Object o) {
        Preconditions.checkNotNull(o, (Object)"Error: Can not add null-elements to filled lists");
        return super.add(o);
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Preconditions.checkNotNull(iterator.next(), (Object)"Error: Can not add null-elements to filled lists");
        }
        return super.addAll(collection);
    }
    
    @Override
    public boolean addAll(final int n, final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Preconditions.checkNotNull(iterator.next(), (Object)"Error: Can not add null-elements to filled lists");
        }
        return super.addAll(n, collection);
    }
}
