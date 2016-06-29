package org.jfree.ui.about;

public class Contributor
{
    private String name;
    private String email;
    
    public Contributor(final String name, final String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
}
