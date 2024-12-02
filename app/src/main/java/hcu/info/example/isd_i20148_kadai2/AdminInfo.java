package hcu.info.example.isd_i20148_kadai2;

import java.util.ArrayList;

public class AdminInfo {

    // Singleton インスタンス
    private static AdminInfo adminInfo = new AdminInfo();

    // 管理者リスト
    private static ArrayList<Admin> adminList;

    // コンストラクタ: 初期設定
    private AdminInfo() {
        adminList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        // 初期登録
        Admin admin = new Admin();
        admin.adminID = "0000";
        admin.adminName = "admin";
        adminList.add(admin);
    }

    // Singleton インスタンスを取得
    public static AdminInfo getInstance() {
        return adminInfo;
    }

    // 管理者登録
    public boolean setAdmin(String adminID, String adminName) {
        if (existsOfStudentID(adminID)) {
            return false; // すでに登録されている
        } else {
            // データの追加
            Admin admin = new Admin();
            admin.adminID = adminID;
            admin.adminName = adminName;
            adminList.add(admin);
            return true; // 登録成功
        }
    }

    // 指定された管理者IDが存在するか確認
    // 存在する場合は true、存在しない場合は false を返す
    public static boolean existsOfStudentID(String userID) {
        for (Admin admin : adminList) {
            if (userID.equals(admin.adminID)) {
                return true;
            }
        }
        return false;
    }
}
