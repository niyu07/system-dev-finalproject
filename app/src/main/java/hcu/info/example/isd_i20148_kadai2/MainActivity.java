package hcu.info.example.isd_i20148_kadai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UIコンポーネントの初期化
        TextView tvMain = findViewById(R.id.tvMain);
        EditText etID = findViewById(R.id.etID);
        Button btUser = findViewById(R.id.buttonUser);
        Button btAdmin = findViewById(R.id.buttonAdmin);

        // ユーザーの登録画面への遷移
        btUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = etID.getText().toString();
                if (UserInfo.existsOfUserID(userID)) {
                    // UserHome画面に遷移
                    Intent intent = new Intent(MainActivity.this, UserHome.class);
                    intent.putExtra("KEY_STRING", userID);
                    startActivity(intent);
                } else {
                    tvMain.setText("学生番号が登録されていません");
                }
            }
        });

        // 管理者の成績登録画面への遷移
        btAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminID = etID.getText().toString();
                if (AdminInfo.existsOfStudentID(adminID)) {
                    // AdminInfoManagement画面に遷移
                    Intent intent = new Intent(MainActivity.this, AdminInfoManagement.class);
                    startActivity(intent);
                    etID.setText("");
                } else {
                    tvMain.setText("管理者が登録されていません");
                }
            }
        });
    }
}
