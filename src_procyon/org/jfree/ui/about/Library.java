package org.jfree.ui.about;

public class Library extends org.jfree.base.Library
{
    public Library(final String s, final String s2, final String s3, final String s4) {
        super(s, s2, s3, s4);
    }
    
    public Library(final ProjectInfo projectInfo) {
        this(projectInfo.getName(), projectInfo.getVersion(), projectInfo.getLicenceName(), projectInfo.getInfo());
    }
}
