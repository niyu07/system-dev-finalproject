package hcu.info.example.isd_i20148_kadai2;

import java.util.ArrayList;

public class AdminInfo {

    private static AdminInfo adminInfo = new AdminInfo();

    //リストの作成
    private static ArrayList<Admin> adminList;

    AdminInfo(){
        adminList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        //初期登録
        Admin admin = new Admin();admin.adminID = "0000"; admin.adminName = "admin"; adminList.add(admin);

    }

    public static AdminInfo getInstance(){
        return adminInfo;
    }


    //管理者登録
    public boolean setAdmin(String _adminid, String _adminname) {
        if(existsOfStudentID(_adminid)) {
            return false; //すでに登録されている
        }else {
            Admin admin = new Admin();
            //データの追加
            admin.adminID = _adminid;
            admin.adminName = _adminname;
        }
        return false;
    }

    // 指定された学籍番号が存在するかどうかの確認　存在する場合はtrue，存在しない場合はfalseを返す
    public static Boolean existsOfStudentID(String _userID){
        for(int i=0;i<adminList.size();i++){
            Admin admin = adminList.get(i);
            if(_userID.equals(admin.adminID)){
                return true;
            }
        }
        return false;
    }


}
