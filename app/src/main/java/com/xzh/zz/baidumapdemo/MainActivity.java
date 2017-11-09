package com.xzh.zz.baidumapdemo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;//假如用到位置提醒功能，需要import该类
import com.baidu.location.Poi;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_main_gps)
    TextView mTvMainGps;
    @Bind(R.id.bt_main_gps)
    Button mBtMainGps;
    @Bind(R.id.tv_main_wifi)
    TextView mTvMainWifi;
    @Bind(R.id.bt_main_wifi)
    Button mBtMainWifi;
    @Bind(R.id.tv_main_jizhan)
    TextView mTvMainJizhan;
    @Bind(R.id.bt_main_jizhan)
    Button mBtMainJizhan;
    @Bind(R.id.tv_main_ispass)
    TextView mTvMainIspass;
    @Bind(R.id.bt_main_ispass)
    Button mBtMainIspass;
    @Bind(R.id.et_main_1)
    EditText mEtMain1;
    @Bind(R.id.et_main_2)
    EditText mEtMain2;
    @Bind(R.id.et_main_3)
    EditText mEtMain3;
    @Bind(R.id.et_main_4)
    EditText mEtMain4;
    @Bind(R.id.activity_main)
    LinearLayout mActivityMain;
    private String mEt1;
    private String mEt2;
    private String mEt3;
    private String mEt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},1);

        mEt1 = mEtMain1.getText().toString().trim();
        mEt2 = mEtMain2.getText().toString().trim();
        mEt3 = mEtMain3.getText().toString().trim();
        mEt4 = mEtMain4.getText().toString().trim();
    }

    @OnClick({R.id.bt_main_gps, R.id.bt_main_wifi, R.id.bt_main_jizhan, R.id.bt_main_ispass})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_main_gps:

                break;
            case R.id.bt_main_wifi:
                break;
            case R.id.bt_main_jizhan:
                break;
            case R.id.bt_main_ispass:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1){
            if (grantResults.length!=0){
                int grantResult1=grantResults[1];
                int grantResult0=grantResults[0];

                if (grantResult0==-1||grantResult1==-1){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("没有给GPS权限")
                            .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    // 设置完成后返回到原来的界面
                                    startActivityForResult(intent, 0);
                                }
                            })
                            .show();
                }
            }
        }
    }
}
