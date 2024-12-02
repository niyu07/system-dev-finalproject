package hcu.info.example.isd_i20148_kadai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdminInfoManagement extends AppCompatActivity {

    // インスタンスの取得
    private final AdminInfo adminInfo = AdminInfo.getInstance();
    private final UserInfo user = new UserInfo();
    private final BookInfo book = new BookInfo();

    // UI コンポーネント
    private TextView tvAdminInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Edge-to-Edge レイアウトの有効化
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_info_management);

        // UI 要素の初期化
        tvAdminInfo = findViewById(R.id.tuAdminInfo);
        Button btUserPage = findViewById(R.id.buttonUserPage);
        Button btBookPage = findViewById(R.id.buttonBookPage);
        Button bookStateButton = findViewById(R.id.buttonstate);
        Button btBack = findViewById(R.id.buttonBacklogin);

        // 利用者登録画面へ遷移
        btUserPage.setOnClickListener(view -> {
            Intent intent = new Intent(AdminInfoManagement.this, UserRegistration.class);
            startActivity(intent);
        });

        // 図書登録画面へ遷移
        btBookPage.setOnClickListener(view -> {
            Intent intent = new Intent(AdminInfoManagement.this, BookRegistration.class);
            startActivity(intent);
        });

        // 図書の貸出状況を表示
        bookStateButton.setOnClickListener(view -> {
            tvAdminInfo.setText(book.getBookState());
            System.out.println("貸出状況を表示");
        });

        // 初期画面に戻る
        btBack.setOnClickListener(view -> finish());
    }
}
