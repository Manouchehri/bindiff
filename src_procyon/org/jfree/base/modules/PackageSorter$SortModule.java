package org.jfree.base.modules;

import java.util.*;

class PackageSorter$SortModule implements Comparable
{
    private int position;
    private final PackageState state;
    private ArrayList dependSubsystems;
    
    public PackageSorter$SortModule(final PackageState state) {
        this.position = -1;
        this.state = state;
    }
    
    public ArrayList getDependSubsystems() {
        return this.dependSubsystems;
    }
    
    public void setDependSubsystems(final ArrayList dependSubsystems) {
        this.dependSubsystems = dependSubsystems;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(final int position) {
        this.position = position;
    }
    
    public PackageState getState() {
        return this.state;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("SortModule: ");
        sb.append(this.position);
        sb.append(" ");
        sb.append(this.state.getModule().getName());
        sb.append(" ");
        sb.append(this.state.getModule().getModuleClass());
        return sb.toString();
    }
    
    public int compareTo(final Object o) {
        final PackageSorter$SortModule packageSorter$SortModule = (PackageSorter$SortModule)o;
        if (this.position > packageSorter$SortModule.position) {
            return 1;
        }
        if (this.position < packageSorter$SortModule.position) {
            return -1;
        }
        return 0;
    }
}
