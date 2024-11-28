package hcu.info.example.isd_i20148_kadai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class BookRegistration extends AppCompatActivity {

    AdminInfo adminInfo= AdminInfo.getInstance();
    TextView tvBookRegist;
    UserInfo user = new UserInfo();
    BookInfo book = new BookInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_registration);
        tvBookRegist = findViewById(R.id.tvBookRegst);

        //editextの宣言
        EditText etBookID = findViewById(R.id.etBookID);
        EditText etBookName = findViewById(R.id.etBookName);

        //図書の登録
        Button btRegGra = findViewById(R.id.buttonRegGra);
        btRegGra.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                // 学籍番号か氏名が未入力の場合は，メッセージを出して，登録をしない
                if (etBookID.getText().length() == 0 || etBookName.getText().length() == 0) {
                    tvBookRegist.setText("情報不足で登録できません");
                    return;
                }else {
                    if (book.setbook(etBookID.getText().toString(), etBookName.getText().toString())){
                        tvBookRegist.setText("図書を登録しました");
                        etBookID.setText("");
                        etBookName.setText("");
                    }else {
                        tvBookRegist.setText("その図書はすでに登録されています");
                    }
                }
            }
        });


        //図書一覧
        Button btDispBook = findViewById(R.id.buttonDispBook);
        btDispBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 登録者数が0人の場合は，メッセージを出す
                if(book.getNumOfBookInfo() == 0) {
                    tvBookRegist.setText("何も登録されていません");
                    return;
                }
                tvBookRegist.setText(book.getBookInfo());
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