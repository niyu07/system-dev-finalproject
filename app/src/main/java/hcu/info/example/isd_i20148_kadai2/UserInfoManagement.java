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

public class UserInfoManagement extends AppCompatActivity {

    UserInfo userInfo = UserInfo.getInstance();
    TextView tvUserInfo;
    TextView tvid;
    BookInfo book = new BookInfo();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_management);
        tvUserInfo = findViewById(R.id.tvUserInfo);
        tvid = findViewById(R.id.tvid);

        //editTExtの宣言
        EditText etBookID = findViewById(R.id.etBookID);
        EditText etBookName = findViewById(R.id.etBookName);

        // Intentから文字列を取得　上の方に表示する前の画面から学籍番号を取ってくるのに必要なので必ず使用するようにする
        Intent intent = getIntent();
        String id = intent.getStringExtra("KEY_STRING");

        // idがnullでないことを確認してから処理を行う　はじめにlogで確認するように作成
        if (id != null) {
            tvid.setText(id);
            System.out.println(id);
        } else {
            // idがnullの場合のエラーハンドリング
            System.out.println("ユーザーIDが取得できませんでした。");
        }

        // 貸出情報の登録
        Button btRegbook = findViewById(R.id.buttonRegbook);
        btRegbook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                // 学籍番号または図書IDが未入力の場合は，メッセージを出して，登録をしない
                if (etBookID.getText().length() == 0) {
                    tvUserInfo.setText("情報不足で登録できません");
                    return;
                }else{
                    //addbook関数を呼び出す
                    UserInfo user = new UserInfo();
                    if(user.addbook(id, etBookID.getText().toString(), etBookName.getText().toString())){
                        //図書の状態を変更するメソッドを使用すう
//                        BookInfo book = new BookInfo();
                        if(book.rentBook(etBookID.getText().toString())) {
                            System.out.println("図書ID!");
                            if (userInfo.addbook(id, etBookID.getText().toString(), etBookName.getText().toString())) {
                                System.out.println("貸出情報をユーザに繋げる");
                                tvUserInfo.setText("登録しました");
                                etBookID.setText("");
                                etBookName.setText("");
                            }else {
                                tvUserInfo.setText("ユーザIDが登録されていません");
                            }
                        }else {
                            tvUserInfo.setText("貸出できません");
                        }
                    }
                }

            }
        });

        //返却情報の登録
        Button btRemBook = findViewById(R.id.buttonRemoveBook);
        btRemBook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (etBookID.getText().length() == 0) { // 修正箇所: 不足していた括弧を追加
                    tvUserInfo.setText("情報不足で変更できません");
                    return;
                } else {
                    UserInfo user = new UserInfo();
                    if (user.removebook(id, etBookID.getText().toString())) {
                        //図書の状態を変更するメソッドを使用すう
//                        BookInfo book = new BookInfo();
                        if(book.returnBook(etBookID.getText().toString())) {
                            System.out.println("図書の貸出状況の変更！");
                            if (userInfo.removebook(id, etBookID.getText().toString())){
                                System.out.println("リストから取り出す");
                                tvUserInfo.setText("返却しました");
                                etBookID.setText("");
                                etBookName.setText("");
                            }else {
                                tvUserInfo.setText("借りているユーザが違います");
                            }
                        }else {
                            tvUserInfo.setText("借りている本が違います");
                        }
                    }
                }

            }
        });


        //以下のコメントアウトは違うページに移すのでコメントアウトをしています

//        //自身が借りている図書の情報の検索　IDで検索をかける　
//        Button btSeaMybok = findViewById(R.id.buttonSearch);
//        btSeaMybok.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view) {
//                // 学籍番号か氏名が未入力の場合は，メッセージを出して，登録をしない
//                if (etUserID.getText().length() == 0) {
//                    tvUserInfo.setText("情報不足で検索できません");
//                }else {
//                    String foundResolt = userInfo.getbook(etUserID.getText().toString());
//                    tvUserInfo.setText(foundResolt);
//                }
//
//            }
//        });
//
//
//        // 図書情報の全表示
//        Button btDispbook = findViewById(R.id.buttonDispbook);
//        btDispbook.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                // 登録者数が0人の場合は，メッセージを出す
////                BookInfo book = new BookInfo();
//                if((book.getNumOfBookInfo()) == 0) {
//                    tvUserInfo.setText("誰も登録されていません");
//                    return;
//                }
//                tvUserInfo.setText(book.getBookState());
//            }
//        });



        // 初期画面に戻る
        Button btBack = findViewById(R.id.buttonBacklogin);
        btBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}