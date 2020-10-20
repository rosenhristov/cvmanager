package com.scalefocus.cvmanager.model;

public enum TechnologyCategory {
    PROGRAMMING_TECHNOLOGIES("Programming Technologies"),
    FRAMEWORKS("FrameworkS"),
    APPLICATION_SERVER("Application Servers"),
    DATABASE("Database Skills"),
    INTEGRATION_TECHNOLOGY("Integration Technologies"),
    DEVELOPMENT_TOOLS("Development Tools"),
    MOBILE_DEVELOPMENT("Mobile Development"),
    OPERATING_SYSTEMS("Operating Systems"),
    SOFTWARE_DEVELOPMENT_METHODOLOGY("Software Development Methodologies"),
    OTHERS("Others");

    private String value;

    TechnologyCategory() {
    }

    TechnologyCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return  value;
    }
}
