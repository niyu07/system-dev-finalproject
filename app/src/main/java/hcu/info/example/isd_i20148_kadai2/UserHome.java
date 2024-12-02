package hcu.info.example.isd_i20148_kadai2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserHome extends AppCompatActivity {

    UserInfo userInfo = UserInfo.getInstance();
    TextView tvInfo;
    TextView tvid;
    BookInfo book = new BookInfo();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        tvInfo = findViewById(R.id.tvInfo);
        tvid = findViewById(R.id.tvid);

        //editTextの宣言
        EditText etBookID = findViewById(R.id.etBookID);

        // Intentから文字列を取得　上の方に表示する前の画面から学籍番号を取ってくるのに必要なので必ず使用するようにする
        Intent intent = getIntent();
        String id = intent.getStringExtra("KEY_STRING");
        tvInfo.setMovementMethod(new ScrollingMovementMethod());
        tvid.setText(id);

        //図書IDを使用して図書を検索する
        Button btBookSerach = findViewById(R.id.buttonBookSearch);
        btBookSerach.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // ログインをするときに学籍情報があるかどうかを確認しているのでここではいらない
                tvInfo.setText(book.searchBook(etBookID.getText().toString()));
            }
        });

        //自身が借りている図書の情報の検索　IDで検索をかける　
        Button btSeaMybok = findViewById(R.id.buttonSearch);
        btSeaMybok.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // ログインをするときに学籍情報があるかどうかを確認しているのでここではいらない
                String foundResolt = userInfo.getbook(id);
                tvInfo.setText(foundResolt);
            }
        });


        // 全図書情報の全表示
        Button btDispbook = findViewById(R.id.buttonDispbook);
        btDispbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 登録者数が0人の場合は，メッセージを出す
                if((book.getNumOfBookInfo()) == 0) {
                    tvInfo.setText("誰も登録されていません");
                    return;
                }
                tvInfo.setText(book.getBookState());
            }
        });


        //貸出画面への遷移のボタン
        Button btRemovePage = findViewById(R.id.btRemovePage);
        btRemovePage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(UserHome.this, UserInfoManagement.class);
                intent.putExtra("KEY_STRING", id);
                startActivity(intent);
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