package hcu.info.example.isd_i20148_kadai2;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String userID;
    public String userName;
    //HashMAp
    public Map<String, String> userBook = new HashMap<>();

    //初期状態
    User(){
        userID = "No information.";
        userName = "No information.";
    }

    //ユーザ情報の表示
    public String getUserIDandName(){
        return "学籍番号: " + userID + " 名前: " + userName + "貸出状況: " + getInfo();
    }

    //ユーザが借りている図書を表示するメソッド
    public String getRentBook() {return"学籍番号: " + userID + "名前："+  userName + "\n" + getInfo();}

    public String getInfo() {
        StringBuffer cg = new StringBuffer();
        for (Map.Entry<String, String> entry : userBook.entrySet()) {
            String grade = entry.getValue() != null ? entry.getValue() : "未登録";
            cg.append("図書ID: " + entry.getKey() + "　" + "図書名: " + grade + "\n");
        }
        return cg.toString();
    }
}
