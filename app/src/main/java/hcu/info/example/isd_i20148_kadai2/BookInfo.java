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
        Book book11 = new Book(); book11.bookID = "0011"; book11.bookName = "gggg"; bookList.add(book11);
        Book book12 = new Book(); book12.bookID = "0012"; book12.bookName = "hhhh"; bookList.add(book12);
        Book book13 = new Book(); book13.bookID = "0013"; book13.bookName = "aaaa"; bookList.add(book13); // 重複名
        Book book14 = new Book(); book14.bookID = "0014"; book14.bookName = "iiii"; bookList.add(book14);
        Book book15 = new Book(); book15.bookID = "0015"; book15.bookName = "bbbb"; bookList.add(book15); // 重複名
        Book book16 = new Book(); book16.bookID = "0016"; book16.bookName = "jjjj"; bookList.add(book16);
        Book book17 = new Book(); book17.bookID = "0017"; book17.bookName = "kkkk"; bookList.add(book17);
        Book book18 = new Book(); book18.bookID = "0018"; book18.bookName = "cccc"; bookList.add(book18); // 重複名
        Book book19 = new Book(); book19.bookID = "0019"; book19.bookName = "llll"; bookList.add(book19);
        Book book20 = new Book(); book20.bookID = "0020"; book20.bookName = "mmmm"; bookList.add(book20);
        Book book21 = new Book(); book21.bookID = "0021"; book21.bookName = "aaaa"; bookList.add(book21); // 重複名
        Book book22 = new Book(); book22.bookID = "0022"; book22.bookName = "nnnn"; bookList.add(book22);
        Book book23 = new Book(); book23.bookID = "0023"; book23.bookName = "bbbb"; bookList.add(book23); // 重複名
        Book book24 = new Book(); book24.bookID = "0024"; book24.bookName = "oooo"; bookList.add(book24);
        Book book25 = new Book(); book25.bookID = "0025"; book25.bookName = "pppp"; bookList.add(book25);
        Book book26 = new Book(); book26.bookID = "0026"; book26.bookName = "qqqq"; bookList.add(book26);
        Book book27 = new Book(); book27.bookID = "0027"; book27.bookName = "rrrr"; bookList.add(book27);
        Book book28 = new Book(); book28.bookID = "0028"; book28.bookName = "aaaa"; bookList.add(book28); // 重複名
        Book book29 = new Book(); book29.bookID = "0029"; book29.bookName = "bbbb"; bookList.add(book29); // 重複名
        Book book30 = new Book(); book30.bookID = "0030"; book30.bookName = "ssss"; bookList.add(book30);

    }

    public static BookInfo getInstance() {
        return bookInfo;
    }

    //以下にそれぞれのメソッドを書いていく

    //図書の登録
    public boolean setbook(String _bookid, String _bookname){
        if (existsOfBookID(_bookid)) {
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

    //図書の検索するメソッド
    public String searchBook(String book_id){
        StringBuffer bn = new StringBuffer();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.bookName.equals(book_id)) {
                //学生情報を表示できるようにしたい
                System.out.println("a");
                bn.append(book.getBookIDandName() + "\n");
            }
        }
        return bn.toString();
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
    public static Boolean existsOfBookID(String _bookID){
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


//    //図書の貸出状況の管理をするシステム 貸出をしたら学籍番号と図書IDを登録する
//    public boolean setBookState(String _Userid, String _Bookid){
//        String State = _Userid + _Bookid;
//        boolean added = BookStateList.add(State);
//
//        return true;
//    }
//
//    //図書状況の情報を取得するメソッド
//    public String getBookStateInfo(){
//        StringBuffer sb = new StringBuffer();
//        for(int i=0;i<BookStateList.size();i++){
//            String bsi = BookStateList.get(i);
//            sb.append(bsi).append("\n");
//        }
//        return sb.toString();
//    }




}
