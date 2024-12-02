package hcu.info.example.isd_i20148_kadai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class BookRegistration extends AppCompatActivity {

    // インスタンスの初期化
    AdminInfo adminInfo = AdminInfo.getInstance();
    UserInfo user = new UserInfo();
    BookInfo book = new BookInfo();

    // UI コンポーネントの初期化
    TextView tvBookRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_registration);
        tvBookRegist = findViewById(R.id.tvBookRegst);

        // EditText の初期化
        EditText etBookID = findViewById(R.id.etBookName);
        EditText etBookName = findViewById(R.id.etBookName);

        // 図書の登録ボタンの処理
        Button btRegGra = findViewById(R.id.buttonRegGra);
        btRegGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 入力チェック
                if (etBookID.getText().length() == 0 || etBookName.getText().length() == 0) {
                    tvBookRegist.setText("情報不足で登録できません");
                    return;
                } else {
                    // 図書の登録処理
                    if (book.setbook(etBookID.getText().toString(), etBookName.getText().toString())) {
                        tvBookRegist.setText("図書を登録しました");
                        etBookID.setText("");
                        etBookName.setText("");
                    } else {
                        tvBookRegist.setText("その図書はすでに登録されています");
                    }
                }
            }
        });

        // 図書一覧ボタンの処理
        Button btDispBook = findViewById(R.id.buttonDispBook);
        btDispBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 登録されている図書情報の表示
                if (book.getNumOfBookInfo() == 0) {
                    tvBookRegist.setText("何も登録されていません");
                    return;
                }
                tvBookRegist.setText(book.getBookInfo());
            }
        });

        // 初期画面に戻るボタンの処理
        Button btBack = findViewById(R.id.buttonBacklogin);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
