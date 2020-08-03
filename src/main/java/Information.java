import com.google.gson.annotations.SerializedName;

public class Information {
    @SerializedName("items")
    private FriendInfo[] friendInfos;
    FriendInfo[] getFriendInfos() {
        return friendInfos;
    }
}
