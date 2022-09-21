package com.example.gitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gitdemo.Unny1.CartFragment;
import com.example.gitdemo.Unny1.HomeFragment;
import com.example.gitdemo.Unny1.MyFragment;
import com.example.gitdemo.Unny1.TypeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_home,iv_type,iv_cart,iv_my;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        iv_home=findViewById(R.id.navigate_home);
        iv_type=findViewById(R.id.navigate_type);
        iv_cart=findViewById(R.id.navigate_cart);
        iv_my=findViewById(R.id.navigate_my);
        //将Homefragment添加到当前页面
        //实例化碎片管理器
        fragmentManager=getSupportFragmentManager();
        //开启事务
        fragmentTransaction=fragmentManager.beginTransaction();
        //实例化碎片
        HomeFragment homeFragment=new HomeFragment();
        //设置碎片到页面
        fragmentTransaction.add(R.id.frame_main,homeFragment);
        //提交事务
        fragmentTransaction.commit();
        //添加监听器
        iv_my.setOnClickListener(this);
        iv_cart.setOnClickListener(this);
        iv_type.setOnClickListener(this);
        iv_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //实例化碎片管理器
        fragmentManager=getSupportFragmentManager();
        //开启事务
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.navigate_home:
                //实例化碎片
                HomeFragment homeFragment=new HomeFragment();
                //替换碎片到页面
                fragmentTransaction.replace(R.id.frame_main,homeFragment);
                //提交事务
                fragmentTransaction.commit();
                break;
            case R.id.navigate_type:
                //实例化碎片
                TypeFragment typeFragment=new TypeFragment();
                //替换碎片到页面
                fragmentTransaction.replace(R.id.frame_main,typeFragment);
                //提交事务
                fragmentTransaction.commit();
                break;
            case R.id.navigate_cart:
                //实例化碎片
               CartFragment cartFragment=new CartFragment();
                //替换碎片到页面
                fragmentTransaction.replace(R.id.frame_main,cartFragment);
                //提交事务
                fragmentTransaction.commit();
                break;
            case R.id.navigate_my:
                //实例化碎片
                MyFragment myFragment=new MyFragment();
                //替换碎片到页面
                fragmentTransaction.replace(R.id.frame_main,myFragment);
                //提交事务
                fragmentTransaction.commit();
                break;
        }
    }
}
