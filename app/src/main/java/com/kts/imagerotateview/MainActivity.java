package com.kts.imagerotateview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText inputAngle;
    Button angleBtn;
    FrameLayout frameView;
    int angle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("관광명소");

        //위젯 대입
        inputAngle = (EditText) findViewById(R.id.inputAngle);
        angleBtn = (Button) findViewById(R.id.angleBtn);
        frameView = (FrameLayout) findViewById(R.id.frameView);
        imageView = (ImageView) findViewById(R.id.imageView);

        angleBtn.setOnClickListener(v -> {
            try{ //숫자가 아닌 다른 문자를 넣으면 강제종료 되는 현상 예외처리
            angle = Integer.parseInt(inputAngle.getText().toString()); //사진 각도 변경
            frameView.setRotation(angle);
            }catch (NumberFormatException e){ //부적절한 문자열을 수치로 변환할 때 생기는 에러에 대한 예외처리
                Toast.makeText(getApplicationContext(), "각도는 숫자만 입력할 수 있습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }

    //메뉴의 내용을 xml 파일에서 자동으로 불러옴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater(); //메뉴 인플레이터 생성
        mInflater.inflate(R.menu.menu, menu); //메뉴 xml 파일 등록
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //각각 한라산, 추자도, 범섬에 대한 이미지를 이벤트에 맞게 변경
        switch(item.getItemId()){
            case R.id.item1:
                item.setChecked(true); //해당 사진 메뉴를 누르면 체크표시 됨
                imageView.setImageResource(R.drawable.hanrasan);
                return true;
            case R.id.item2:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.choojado);
                return true;
            case R.id.item3:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.bumseom);
                return true;
        }
        return false;
    }
}

