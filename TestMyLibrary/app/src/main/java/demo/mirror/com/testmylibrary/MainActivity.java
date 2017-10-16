package demo.mirror.com.testmylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import demo.mirror.com.mylibrary.TestUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int a = TestUtil.A;

        int b = TestUtil.A;

    }
}
