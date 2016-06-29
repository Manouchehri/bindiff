/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import java.util.ArrayList;
import org.jfree.base.modules.Module;
import org.jfree.base.modules.PackageState;

class PackageSorter$SortModule
implements Comparable {
    private int position = -1;
    private final PackageState state;
    private ArrayList dependSubsystems;

    public PackageSorter$SortModule(PackageState packageState) {
        this.state = packageState;
    }

    public ArrayList getDependSubsystems() {
        return this.dependSubsystems;
    }

    public void setDependSubsystems(ArrayList arrayList) {
        this.dependSubsystems = arrayList;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int n2) {
        this.position = n2;
    }

    public PackageState getState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SortModule: ");
        stringBuffer.append(this.position);
        stringBuffer.append(" ");
        stringBuffer.append(this.state.getModule().getName());
        stringBuffer.append(" ");
        stringBuffer.append(this.state.getModule().getModuleClass());
        return stringBuffer.toString();
    }

    public int compareTo(Object object) {
        PackageSorter$SortModule packageSorter$SortModule = (PackageSorter$SortModule)object;
        if (this.position > packageSorter$SortModule.position) {
            return 1;
        }
        if (this.position >= packageSorter$SortModule.position) return 0;
        return -1;
    }
}

