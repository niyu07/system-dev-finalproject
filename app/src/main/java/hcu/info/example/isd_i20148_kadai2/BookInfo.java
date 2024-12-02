package hcu.info.example.isd_i20148_kadai2;

import java.util.ArrayList;
import java.util.List;

public class BookInfo {

    private static BookInfo bookInfo = new BookInfo();
    Book book = new Book();

    // リストの作成
    private static ArrayList<Book> bookList;

    List<String> BookStateList = new ArrayList<>();

    public BookInfo() {
        bookList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        // 初期の図書登録
        bookList.add(createBook("0001", "aaaa"));
        bookList.add(createBook("0002", "bbbb"));
        bookList.add(createBook("0003", "aaaa")); // 重複名
        bookList.add(createBook("0004", "cccc"));
        bookList.add(createBook("0005", "bbbb")); // 重複名
        bookList.add(createBook("0006", "dddd"));
        bookList.add(createBook("0007", "eeee"));
        bookList.add(createBook("0008", "cccc")); // 重複名
        bookList.add(createBook("0009", "ffff"));
        bookList.add(createBook("0010", "aaaa")); // 重複名
        bookList.add(createBook("0011", "gggg"));
        bookList.add(createBook("0012", "hhhh"));
        bookList.add(createBook("0013", "aaaa")); // 重複名
        bookList.add(createBook("0014", "iiii"));
        bookList.add(createBook("0015", "bbbb")); // 重複名
        bookList.add(createBook("0016", "jjjj"));
        bookList.add(createBook("0017", "kkkk"));
        bookList.add(createBook("0018", "cccc")); // 重複名
        bookList.add(createBook("0019", "llll"));
        bookList.add(createBook("0020", "mmmm"));
        bookList.add(createBook("0021", "aaaa")); // 重複名
        bookList.add(createBook("0022", "nnnn"));
        bookList.add(createBook("0023", "bbbb")); // 重複名
        bookList.add(createBook("0024", "oooo"));
        bookList.add(createBook("0025", "pppp"));
        bookList.add(createBook("0026", "qqqq"));
        bookList.add(createBook("0027", "rrrr"));
        bookList.add(createBook("0028", "aaaa")); // 重複名
        bookList.add(createBook("0029", "bbbb")); // 重複名
        bookList.add(createBook("0030", "ssss"));
    }

    private Book createBook(String bookID, String bookName) {
        Book book = new Book();
        book.bookID = bookID;
        book.bookName = bookName;
        return book;
    }

    public static BookInfo getInstance() {
        return bookInfo;
    }

    // 図書の登録
    public boolean setbook(String _bookid, String _bookname) {
        if (existsOfBookID(_bookid)) {
            return false;
        } else {
            Book book = new Book();
            book.bookID = _bookid;
            book.bookName = _bookname;
            book.bookState = "貸出可能"; // 登録するときは貸出可能状態
            bookList.add(book);
            return true;
        }
    }

    // 登録された図書情報の取得
    public String getBookInfo() {
        StringBuffer bb = new StringBuffer();
        for (Book book : bookList) {
            bb.append(book.getBookIDandName()).append("\n");
        }
        return bb.toString();
    }

    // 図書の検索
    public String searchBook(String book_id) {
        StringBuffer bn = new StringBuffer();
        for (Book book : bookList) {
            if (book.bookName.equals(book_id)) {
                bn.append(book.getBookIDandName()).append("\n");
            }
        }
        return bn.toString();
    }

    // 図書の貸し出し
    public boolean rentBook(String _bookid) {
        for (Book book : bookList) {
            if (book.bookID.equals(_bookid) && book.bookState.equals("貸出可能")) {
                book.bookState = "貸出不可";
                return true; // 貸出が成功しました
            }
        }
        return false; // 貸出できません
    }

    // 図書の返却
    public boolean returnBook(String _bookid) {
        for (Book book : bookList) {
            if (book.bookID.equals(_bookid) && book.bookState.equals("貸出不可")) {
                book.bookState = "貸出可能";
                return true; // 返却が成功しました
            }
        }
        return false; // 返却できません
    }

    // 図書状況の情報を取得
    public String getBookState() {
        StringBuffer sb = new StringBuffer();
        for (Book stu : bookList) {
            sb.append(stu.getBookIDandName()).append("\n");
        }
        return sb.toString();
    }

    // 指定された図書IDが存在するか確認
    public static Boolean existsOfBookID(String _bookID) {
        for (Book book : bookList) {
            if (_bookID.equals(book.bookID)) {
                return true;
            }
        }
        return false;
    }

    // 登録された図書数の取得
    public int getNumOfBookInfo() {
        return bookList.size();
    }
}
