package hcu.info.example.isd_i20148_kadai2;

import java.util.ArrayList;
import java.util.List;

public class BookInfo {

    private static BookInfo bookInfo = new BookInfo();
    Book book = new Book();
    //リストの作成
    private static ArrayList<Book> bookList;

    List<String> BookStateList = new ArrayList<String>();

    public BookInfo(){
        bookList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        //初期の図書登録
        Book book1 = new Book(); book1.bookID = "0001"; book1.bookName = "aaaa"; bookList.add(book1);
        Book book2 = new Book(); book2.bookID = "0002"; book2.bookName = "bbbb"; bookList.add(book2);
        Book book3 = new Book(); book3.bookID = "0003"; book3.bookName = "aaaa"; bookList.add(book3); // 重複名
        Book book4 = new Book(); book4.bookID = "0004"; book4.bookName = "cccc"; bookList.add(book4);
        Book book5 = new Book(); book5.bookID = "0005"; book5.bookName = "bbbb"; bookList.add(book5); // 重複名
        Book book6 = new Book(); book6.bookID = "0006"; book6.bookName = "dddd"; bookList.add(book6);
        Book book7 = new Book(); book7.bookID = "0007"; book7.bookName = "eeee"; bookList.add(book7);
        Book book8 = new Book(); book8.bookID = "0008"; book8.bookName = "cccc"; bookList.add(book8); // 重複名
        Book book9 = new Book(); book9.bookID = "0009"; book9.bookName = "ffff"; bookList.add(book9);
        Book book10 = new Book(); book10.bookID = "0010"; book10.bookName = "aaaa"; bookList.add(book10); // 重複名

    }

    public static BookInfo getInstance() {
        return bookInfo;
    }

    //以下にそれぞれのメソッドを書いていく

    //図書の登録
    public boolean setbook(String _bookid, String _bookname){
        if (existsOfStudentID(_bookid)) {
            return false;
        }else {
            Book book = new Book();
            //データの追加
            book.bookID = _bookid;
            book.bookName = _bookname;
            book.bookState = "貸出可能"; //登録するときは貸出可能状態
            bookList.add(book);
            return true;
        }
    }


    // 登録された図書情報の取得　文字列で返す
    public String getBookInfo(){
        StringBuffer bb = new StringBuffer();
        for(int i=0;i<bookList.size();i++){
            Book book = bookList.get(i);
            bb.append(book.getBookIDandName() + "\n");
        }
        return bb.toString();
    }

    //図書の検索するメソッド 使われていない？！
    public String searchBook(String book_id){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.bookID.equals(book_id)) {
                //学生情報を表示できるようにしたい
                return ("ID:" + book.bookID + "name：" + book.bookName);
            }
        }
        return "情報が見つかりませんでした";
    }

    //図書の貸し出し　生徒には登録をしていないので生徒の方でも作る必要がある
    public boolean rentBook(String _bookid){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.bookID.equals(_bookid) || book.bookState.equals("貸出可能")) {
                book.bookState = "貸出不可";  // 名前を更新
                return true; //"貸出が成功しました"
            }
        }
        return false; //"貸出できません"
    }


    //図書の返却　生徒には登録をしていないので生徒の方でも作る必要がある
    public boolean returnBook(String _bookid){
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.bookID.equals(_bookid) || book.bookState.equals("貸出不可")) {
                book.bookState = "貸出可能";  // 名前を更新
                return true; //"返却が成功しました"
            }
        }
        return false; //"返却できません"
    }

    //図書状況の情報を取得するメソッド
    public String getBookState(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<bookList.size();i++){
            Book stu = bookList.get(i);
            sb.append(stu.getBookIDandName() + "\n");
        }
        return sb.toString();
    }


    // 指定されたが図書IDが存在するかどうかの確認　存在する場合はtrue，存在しない場合はfalseを返す
    public static Boolean existsOfStudentID(String _bookID){
        for(int i=0;i<bookList.size();i++){
            Book book = bookList.get(i);
            if(_bookID.equals(book.bookID)){
                return true;
            }
        }
        return false;
    }

    // 登録された図書数の取得
    public int getNumOfBookInfo(){
        return bookList.size();
    }


    //図書の貸出状況の管理をするシステム 貸出をしたら学籍番号と図書IDを登録する
    public boolean setBookState(String _Userid, String _Bookid){
        String State = _Userid + _Bookid;
        boolean added = BookStateList.add(State);

        return true;
    }

    //図書状況の情報を取得するメソッド
    public String getBookStateInfo(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<BookStateList.size();i++){
            String bsi = BookStateList.get(i);
            sb.append(bsi).append("\n");
        }
        return sb.toString();
    }




}
