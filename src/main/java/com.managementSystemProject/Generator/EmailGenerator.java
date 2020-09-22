package com.managementSystemProject.Generator;

public class EmailGenerator {

    private String email;
    private String companySuffix = "xyzcompany.com";

    public String getEmail() {
        return email;
    }

    public String getCompanySuffix() {
        return companySuffix;
    }
    // email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
}
