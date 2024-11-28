package hcu.info.example.isd_i20148_kadai2;

import java.util.HashMap;
import java.util.Map;

public class Book {
    public String bookID;
    public String bookName;
    public String bookState;



    //初期設定
    Book() {
        bookID = "No information.";
        bookName = "No information.";
        bookState = "貸出可能";
    }

    //図書IDと図書名を返すメソッド
    public String getBookIDandName(){
        return "図書ID: " + bookID + " 図書名: " + bookName + "貸出状況: " + bookState;
    }

}


