package org.live.module.login.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.live.R;
import org.live.common.listener.BackHandledFragment;
import org.live.module.login.listener.OnLoginActivityEventListener;
import org.live.module.login.presenter.LoginPresenter;
import org.live.module.login.util.constant.LoginConstant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 忘记密码模块
 * Created by KAM on 2017/4/11.
 */

public class ForgetPasswordFragment extends BackHandledFragment implements View.OnClickListener {
    private static final String TAG = "Global";
    /**
     * 成员编号输入框
     */
    private EditText fMemberNoEditText;
    /**
     * 姓名输入框
     */
    private EditText fRealNameEditText;
    /**
     * 重置密码输入框
     */
    private EditText fPasswordEditText;
    /**
     * 确认重置密码输入框
     */
    private EditText fRePasswordEditText;
    /**
     * 密码重置按钮
     */
    private Button fResetButton;
    private View view;
    private OnLoginActivityEventListener loginActivityEventListener;
    private LoginPresenter loginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        if (getActivity() instanceof OnLoginActivityEventListener) {
            this.loginActivityEventListener = (OnLoginActivityEventListener) getActivity();
        }
        this.loginPresenter = loginActivityEventListener.getLoginPresenter(); // 取得登陆模块表示器
        initUIElement();
        loginActivityEventListener.setTitle("找回密码"); // 设置标题
        return view;
    }


    /**
     * 初始化UI控件
     */
    private void initUIElement() {
        fMemberNoEditText = (EditText) view.findViewById(R.id.et_forgetPassword_memberNo);
        fRealNameEditText = (EditText) view.findViewById(R.id.et_forgetPassword_realName);
        fPasswordEditText = (EditText) view.findViewById(R.id.et_forgetPassword_password);
        fRePasswordEditText = (EditText) view.findViewById(R.id.et_forgetPassword_rePassword);
        fResetButton = (Button) view.findViewById(R.id.btn_forgetPassword_submit);
        fResetButton.setOnClickListener(this);
    }

    @Override
    public boolean onBackPressed() {
        loginActivityEventListener.setTitle("登陆"); // 设置标题
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forgetPassword_submit:
                if (validateForm()) {
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("account", fMemberNoEditText.getText().toString());
                    params.put("newPassword", fPasswordEditText.getText().toString());
                    params.put("realName", fRealNameEditText.getText().toString());
                    try {
                        loginActivityEventListener.showProgressBar();
                        loginPresenter.httpRequest(LoginConstant.MODEL_TYPE_FORGET_PASSWORD, params); // 请求重置密码
                        loginActivityEventListener.hideProgressBar();
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                        loginActivityEventListener.hideProgressBar();
                    }
                }
                break;
        }
    }

    /**
     * 检验表单
     */
    public boolean validateForm() {

        Map<String, String> vals = new LinkedHashMap<String, String>(); // 待校验的字符组
        Map<String, String> labels = new HashMap<String, String>(); // 字符组对应的标签组
        Map<String, Map<String, Object>> rules = new HashMap<>(); // 字符组对应的规则组
        String[] columns = {"memberNo", "realName", "password", "rePassword"};
        String[] titles = {"学号/工号", "姓名", "重置密码", "确认重置密码"};
        EditText[] editTexts = {fMemberNoEditText, fRealNameEditText, fPasswordEditText, fRePasswordEditText};
        for (int i = 0; i < columns.length; i++) {
            String key = columns[i];
            String val = editTexts[i].getText().toString();
            String label = titles[i];
            vals.put(key, val);
            labels.put(key, label);
        } // 构建校验数据源

        for (String key : columns) {
            Map<String, Object> rule = new HashMap<String, Object>();
            switch (key) {
                case "memberNo":
                    rule.put("required", true);
                    rule.put("number", true);
                    rule.put("maxLength", 15);
                    break;
                case "realName":
                    rule.put("required", true);
                    rule.put("maxLength", 10);
                    break;
                case "password":
                    rule.put("required", true);
                    rule.put("maxLength", 15);
                    break;
                case "rePassword":
                    rule.put("required", true);
                    rule.put("maxLength", 15);
                    rule.put("confirm", fPasswordEditText.getText().toString());
                    break;
            }
            rules.put(key, rule);
        } // 构建校验规则组


        return loginPresenter.validateForm(vals, labels, rules); // 开启校验
    }
}
