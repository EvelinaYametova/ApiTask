import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(connectToUrl());
    }

    private static String connectToUrl() throws IOException {
        try
        {
            File file = new File("src\\main\\resources\\input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String accessTocken = reader.readLine();
            String id = reader.readLine();
            URL url = new URL("https://api.vk.com/method/" +
                "friends.get?" +
                "user_id=" + id +
                "&fields=nickname" +
                "&access_token=" + accessTocken + "&v=5.122");
            URLConnection uc = url.openConnection();
            InputStream inputStream = uc.getInputStream();
            int ch;
            String str = "";
            String friendNames = "";
            while ((ch = inputStream.read()) != -1) { str += (char) ch; }
            Response response = new Gson().fromJson(str, Response.class);
            for (FriendInfo friend: response.getResponse().getFriendInfos()) {
                friendNames += friend.getFullName();
                friendNames += "\n";
            }
            return friendNames;
        }
        catch(Exception e)
        {e.printStackTrace();}
        return null;
    }
}