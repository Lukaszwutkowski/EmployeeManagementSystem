package com.managementSystemProject.Generator;

public class PasswordGenerator {

    private int defaultPasswordLength = 10;

    private String password = randomPassword(defaultPasswordLength);

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public String getPassword() {
        return password;
    }
}
