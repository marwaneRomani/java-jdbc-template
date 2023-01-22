package org.example;

/* could be replaced with a xml or json config file */
public class DataSource {
    private String driver;
    private String userName;
    private String password;

    public DataSource(String driver, String userName, String password) {
        this.driver = driver;
        this.userName = userName;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
