package hcu.info.example.isd_i20148_kadai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdminInfoManagement extends AppCompatActivity {

    AdminInfo adminInfo= AdminInfo.getInstance();
    TextView tvAdminInfo;
    UserInfo user = new UserInfo();
    BookInfo book = new BookInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_info_management);
        tvAdminInfo = findViewById(R.id.tuAdminInfo);

        //buttonの宣言
        Button btUserPage = findViewById(R.id.buttonUserPage);
        Button btBookPage = findViewById(R.id.buttonBookPage);


        // 利用者登録画面へ遷移

        btUserPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(AdminInfoManagement.this, UserRegistration.class);
                startActivity(i);
            }
        });



        // 図書登録画面へ遷移
        btBookPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                    Intent i = new Intent(AdminInfoManagement.this, BookRegistration.class);
                    startActivity(i);
                }
        });

        //図書の貸出状況するボタン
        Button bookstate = findViewById(R.id.buttonstate);
        bookstate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tvAdminInfo.setText(book.getBookState());
                System.out.println("呼び出し");
            }
        });


        // 初期画面に戻る
        Button btBack = findViewById(R.id.buttonBacklogin);
        btBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

    }
}