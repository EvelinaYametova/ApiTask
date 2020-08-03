import com.google.gson.annotations.SerializedName;
public class FriendInfo {
    @SerializedName("first_name")
    private String name;
    @SerializedName("last_name")
    private String surename;

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getFullName() {
        return getName() + " " + getSurename();
    }
}
