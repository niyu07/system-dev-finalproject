package hcu.info.example.isd_i20148_kadai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class UserRegistration extends AppCompatActivity {

    AdminInfo adminInfo= AdminInfo.getInstance();
    TextView tvUserRegist;
    UserInfo user = new UserInfo();
    BookInfo book = new BookInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_registration);
        tvUserRegist = findViewById(R.id.tvUserRegst);

        //editextの宣言
        EditText etUserID = findViewById(R.id.etUserID);
        EditText etUserName = findViewById(R.id.etUserName);


        //利用者の登録
        Button btRegUser = findViewById(R.id.buttonRegUser);
        btRegUser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                // 学籍番号か氏名が未入力の場合は，メッセージを出して，登録をしない
                if (etUserID.getText().length() == 0 || etUserName.getText().length() == 0) {
                    tvUserRegist.setText("情報不足で登録できません");
                    return;
                }else {
                    if (user.setUser(etUserID.getText().toString(), etUserName.getText().toString())){
                        tvUserRegist.setText("利用者を登録しました");
                        etUserID.setText("");
                        etUserName.setText("");
                    }else {
                        tvUserRegist.setText("その学籍番号はすでに登録されています");
                    }
                }
            }
        });


        //利用者一覧
        Button btDispUser = findViewById(R.id.buttonDispUser);
        btDispUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 登録者数が0人の場合は，メッセージを出す
                if(user.getNumOfStudentInfo() == 0) {
                    tvUserRegist.setText("誰も登録されていません");
                    return;
                }
                tvUserRegist.setText(user.getUser());
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