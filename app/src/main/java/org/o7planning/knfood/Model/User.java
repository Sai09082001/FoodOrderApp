package org.o7planning.knfood.Model;

public class User {
    private String id;
    private String userName;
    private String displayName;

    public String getTypeID() {
        return typeID;
    }

    private String typeID;

    public User() {
    }

    public User(String id, String userName, String displayName, String typeID) {
        this.id = id;
        this.userName = userName;
        this.displayName = displayName;
        this.typeID = typeID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
