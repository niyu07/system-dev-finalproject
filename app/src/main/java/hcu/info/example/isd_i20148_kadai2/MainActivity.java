package hcu.info.example.isd_i20148_kadai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // AdminInfoのインスタンスを作成
    AdminInfo adminManager = new AdminInfo();
    // UserInfoのインスタンスを作成
    UserInfo user = new UserInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textViewの宣言
        TextView tvMain = findViewById(R.id.tvMain);


        //editTExtの宣言
        EditText etID = findViewById(R.id.etID);
        EditText etName = findViewById(R.id.etName);

        //buttonの宣言
        Button btUser = findViewById(R.id.buttonUser);
        Button btAdmin = findViewById(R.id.buttonAdmin);


        // ユーザの登録画面へ遷移

            btUser.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    if (UserInfo.existsOfUserID(etID.getText().toString())) {
                        String userID = etID.getText().toString();
                        Intent intent = new Intent(MainActivity.this, UserHome.class);
                        intent.putExtra("KEY_STRING", userID);
                        startActivity(intent);
                    }else {
                        tvMain.setText("学生番号が登録されていません");

                    }
                }
            });



        // 管理者の成績登録画面へ遷移
            btAdmin.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (AdminInfo.existsOfStudentID(etID.getText().toString())) {
                    // Intentを使ってAdminInfoManagement画面に遷移
                    Intent i = new Intent(MainActivity.this, AdminInfoManagement.class);
                    startActivity(i);
                    etID.setText("");
                    etName.setText("");
                    }else {
                        tvMain.setText("管理者が登録されていません");
                    }

                }
            });
    }


}