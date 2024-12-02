package hcu.info.example.isd_i20148_kadai2;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String userID;
    public String userName;
    // 借りている図書を格納するHashMap
    public Map<String, String> userBook = new HashMap<>();

    // 初期状態
    User() {
        userID = "No information.";
        userName = "No information.";
    }

    // ユーザの学籍番号、名前、貸出状況を表示するメソッド
    public String getUserIDandName() {
        return "学籍番号: " + userID + " 名前: " + userName + " 貸出状況: " + getInfo();
    }

    // ユーザが借りている図書を表示するメソッド
    public String getRentBook() {
        return "学籍番号: " + userID + " 名前: " + userName + "\n" + getInfo();
    }

    // 借りている図書の情報を取得するメソッド
    public String getInfo() {
        StringBuilder cg = new StringBuilder();
        for (Map.Entry<String, String> entry : userBook.entrySet()) {
            String grade = entry.getValue() != null ? entry.getValue() : "未登録";
            cg.append("図書ID: ").append(entry.getKey())
                    .append("　図書名: ").append(grade)
                    .append("\n");
        }
        return cg.toString();
    }

    // ユーザが借りている図書の数をカウントするメソッド
    public int getBookCount() {
        return userBook.size();
    }
}
