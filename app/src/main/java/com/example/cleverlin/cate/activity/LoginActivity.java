package com.example.cleverlin.cate.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.bean.User;
import com.example.cleverlin.cate.presenter.UserLoginPresenter;
import com.example.cleverlin.cate.activity.viewInterface.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements LoginView {


    @BindView(R.id.username)
    AutoCompleteTextView mUsername;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.login)
    Button login;
    private UserLoginPresenter userLoginPresenter;
    private ProgressDialog mPbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPbLoading=new ProgressDialog(this);
        userLoginPresenter=new UserLoginPresenter(this);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
    }

    private void attemptLogin() {
        mUsername.setError(null);
        mPasswordView.setError(null);
        String email = getUserName();
        String password = getPassword();

        boolean cancel = false;
        View focusView = null;//谁错给谁焦点

        //判断账号是否为空
        if (TextUtils.isEmpty(email)) {
            mUsername.setError(getString(R.string.error_field_required));
            focusView = mUsername;
            cancel = true;
        }
        //判断密码是否为空以及长度要求
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    @OnClick({R.id.register, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.login:
                Intent intentMain=new Intent(this,MainActivity.class);
                startActivity(intentMain);
                this.finish();
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return false;
    }

    @Override
    public String getUserName() {
        return mUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordView.getText().toString();
    }

    @Override
    public void showLoading() {
        mPbLoading.show();
        mPbLoading.setMessage("Logining……");
    }

    @Override
    public void hideLoading() {
        mPbLoading.dismiss();
    }

    @Override
    public void toMainActivity(User user) {
       // user.getPassword() user.getUsername()
        //传到主页获取该用户相关信息
    }

    @Override
    public void showFailedError(String message) {
        Toast.makeText(this, "Login Faild:"+message, Toast.LENGTH_SHORT).show();
    }
}

