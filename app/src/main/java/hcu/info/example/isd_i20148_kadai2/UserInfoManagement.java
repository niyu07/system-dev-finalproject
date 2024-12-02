package hcu.info.example.isd_i20148_kadai2;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoManagement extends AppCompatActivity {

    private final UserInfo userInfo = UserInfo.getInstance();
    private final BookInfo book = new BookInfo();
    private TextView tvUserInfo;
    private TextView tvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_management);

        // UI コンポーネントの初期化
        tvUserInfo = findViewById(R.id.tvUserInfo);
        tvUserInfo.setMovementMethod(new ScrollingMovementMethod());
        tvid = findViewById(R.id.tvid);
        EditText etBookID = findViewById(R.id.etBookName);
        EditText etBookName = findViewById(R.id.etBookName);
        Button btRegbook = findViewById(R.id.buttonRegbook);
        Button btRemBook = findViewById(R.id.buttonRemoveBook);
        Button btBack = findViewById(R.id.buttonBacklogin);

        // IntentからユーザーIDを取得
        Intent intent = getIntent();
        String id = intent.getStringExtra("KEY_STRING");

        if (id != null) {
            tvid.setText(id);
            System.out.println("ユーザーID: " + id);
        } else {
            System.out.println("ユーザーIDが取得できませんでした。");
        }

        // 貸出情報の登録ボタンの処理
        btRegbook.setOnClickListener(view -> {
            if (etBookID.getText().length() == 0) {
                tvUserInfo.setText("情報不足で登録できません");
                return;
            }

            if (userInfo.addbook(id, etBookID.getText().toString(), etBookName.getText().toString())) {
                if (book.rentBook(etBookID.getText().toString())) {
                    tvUserInfo.setText("登録しました");
                    etBookID.setText("");
                    etBookName.setText("");
                } else {
                    tvUserInfo.setText("貸出できません");
                }
            } else {
                tvUserInfo.setText("ユーザIDが登録されていません");
            }
        });

        // 返却情報の登録ボタンの処理
        btRemBook.setOnClickListener(view -> {
            if (etBookID.getText().length() == 0) {
                tvUserInfo.setText("情報不足で変更できません");
                return;
            }

            if (userInfo.removebook(id, etBookID.getText().toString())) {
                if (book.returnBook(etBookID.getText().toString())) {
                    tvUserInfo.setText("返却しました");
                    etBookID.setText("");
                    etBookName.setText("");
                } else {
                    tvUserInfo.setText("借りている本が違います");
                }
            } else {
                tvUserInfo.setText("借りているユーザが違います");
            }
        });

        // 初期画面に戻るボタンの処理
        btBack.setOnClickListener(view -> finish());
    }
}
