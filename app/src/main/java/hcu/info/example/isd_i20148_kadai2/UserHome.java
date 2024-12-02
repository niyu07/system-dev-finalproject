package hcu.info.example.isd_i20148_kadai2;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserHome extends AppCompatActivity {

    // フィールドの宣言
    private UserInfo userInfo = UserInfo.getInstance();
    private BookInfo book = new BookInfo();
    private TextView tvInfo, tvid;
    private EditText etBookName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        // UIコンポーネントの初期化
        tvInfo = findViewById(R.id.tvInfo);
        tvid = findViewById(R.id.tvid);
        etBookName = findViewById(R.id.etBookName);

        tvInfo.setMovementMethod(new ScrollingMovementMethod());

        // 前画面から学籍番号を取得して表示
        Intent intent = getIntent();
        String id = intent.getStringExtra("KEY_STRING");
        tvid.setText(id);

        // 各ボタンのリスナーを設定
        setupBookSearchButton();
        setupMyBookSearchButton(id);
        setupDisplayAllBooksButton();
        setupTransitionToLendPageButton(id);
        setupBackButton();
    }

    // 図書を検索するボタンの設定
    private void setupBookSearchButton() {
        Button btBookSearch = findViewById(R.id.buttonBookSearch);
        btBookSearch.setOnClickListener(view -> {
            String searchResult = book.searchBook(etBookName.getText().toString());
            tvInfo.setText(searchResult);
        });
    }

    // 自身が借りている図書を検索するボタンの設定
    private void setupMyBookSearchButton(String id) {
        Button btSearchMyBook = findViewById(R.id.buttonSearch);
        btSearchMyBook.setOnClickListener(view -> {
            String result = userInfo.getbook(id);
            tvInfo.setText(result);
        });
    }

    // 全図書情報を表示するボタンの設定
    private void setupDisplayAllBooksButton() {
        Button btDispBook = findViewById(R.id.buttonDispbook);
        btDispBook.setOnClickListener(view -> {
            if (book.getNumOfBookInfo() == 0) {
                tvInfo.setText("誰も登録されていません");
            } else {
                tvInfo.setText(book.getBookState());
            }
        });
    }

    // 貸出画面に遷移するボタンの設定
    private void setupTransitionToLendPageButton(String id) {
        Button btRemovePage = findViewById(R.id.btRemovePage);
        btRemovePage.setOnClickListener(view -> {
            Intent intent = new Intent(UserHome.this, UserInfoManagement.class);
            intent.putExtra("KEY_STRING", id);
            startActivity(intent);
        });
    }

    // 初期画面に戻るボタンの設定
    private void setupBackButton() {
        Button btBack = findViewById(R.id.buttonBacklogin);
        btBack.setOnClickListener(view -> finish());
    }
}
