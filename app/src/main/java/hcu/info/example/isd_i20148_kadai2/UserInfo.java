package hcu.info.example.isd_i20148_kadai2;

import static android.content.Intent.getIntent;

import android.content.Intent;

import java.util.ArrayList;

public class UserInfo {

    private static UserInfo userInfo = new UserInfo();
    User user = new User();

    //リストの作成
    private static ArrayList<User> userList;

    UserInfo(){
        userList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        //初期登録
        User user1 = new User();user1.userID = "1111"; user1.userName = "aaa"; userList.add(user1);
        User user2 = new User();user2.userID = "2222"; user2.userName = "bbb"; userList.add(user2);
        User user3 = new User();user3.userID = "3333"; user3.userName = "ccc"; userList.add(user3);
    }

    public static UserInfo getInstance(){
        return userInfo;
    }

    //以下にそれぞれの機能のメソッドを作成していく







    //利用者の登録メソッド
    public boolean setUser(String _userid, String _username) {
        if(existsOfUserID(_userid)) {
            System.out.println("すでに学籍馬号が登録されています");
            return false; //すでに登録されている
        }else {
            User user= new User();
            //データの追加
            user.userName = _username;
            user.userID = _userid;
            userList.add(user);
            System.out.println("ユーザの登録をしました");
            return true;
        }
    }

    //利用者の図書の貸出　ログインで確認をとっているので学生番号があるかの確認はいらない
    public boolean addbook(String _userid, String _bookid, String _bookname) {
        if (existsOfUserID(_userid)) {
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                if (user.userID.equals(_userid)) {
                    user.userBook.put(_bookid, _bookname);
                    return true; //貸出できました
                }
            }
        }
        return false; //貸出できませんでした
    }


    //利用者の図書の返却
    public boolean removebook(String _userid, String _bookid) {
        if (existsOfUserID(_userid)) {
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                if (user.userID.equals(_userid)) {
                    user.userBook.remove(_bookid);
                    return true; //返却できました
                }
            }
        }
        return false; //貸出できませんでした
    }

    //借りている本の情報を取り出すメソッド 変更する　
    public String getbook(String _userid){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if (user.userID.equals(_userid)) {
                sb.append(user.getRentBook() + "\n");
            }

        }
        return sb.toString();
    }


    //ログインしたユーザの借りている本の数を数える
    public int count(String _userid){
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if (user.userID.equals(_userid)) {
              return user.getBookCount();
            }
        }
        return 0;
    }




    //ユーザの情報を取り出すメソッド
    public String getUser(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            sb.append(user.getUserIDandName() + "\n");
        }
        return sb.toString();
    }

    // 登録された学生数の取得
    public int getNumOfStudentInfo(){
        return userList.size();
    }




    // 指定された学籍番号が存在するかどうかの確認　存在する場合はtrue，存在しない場合はfalseを返す
    public static Boolean existsOfUserID(String _userID){
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if(_userID.equals(user.userID)){
                return true;
            }
        }
        return false;
    }


    //ボタンを自動作成するメソッド　全表示の時
}
