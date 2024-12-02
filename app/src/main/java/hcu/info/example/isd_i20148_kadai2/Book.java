package hcu.info.example.isd_i20148_kadai2;

public class Book {
    // フィールドの定義
    public String bookID;
    public String bookName;
    public String bookState;

    // コンストラクタ: 初期設定
    public Book() {
        this.bookID = "No information.";
        this.bookName = "No information.";
        this.bookState = "貸出可能";
    }

    // 図書ID、図書名、貸出状況を返すメソッド
    public String getBookIDandName() {
        return "図書ID: " + bookID + " 図書名: " + bookName + " 貸出状況: " + bookState;
    }
}
