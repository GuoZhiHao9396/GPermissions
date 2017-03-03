package com.gzh.gpermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gzh.gpermissionslibrary.GPermissionsUtils;
import com.gzh.gpermissionslibrary.IGPermissions;

/**
 * @ClassName: PermissionsFragment
 * @Description: Fragment中获取权限
 * @author: GZH
 */
public class PermissionsFragment extends Fragment implements View.OnClickListener, IGPermissions {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_permissions, container, false);
        v.findViewById(R.id.btn_f_sd).setOnClickListener(this);
        v.findViewById(R.id.btn_f_camer).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_f_sd:
                GPermissionsUtils.requestPermission(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0, true);
                break;
            case R.id.btn_f_camer:
                GPermissionsUtils.requestPermission(this, new String[]{Manifest.permission.CAMERA}, 1, true);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        GPermissionsUtils.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void rationale(int requestCode) {
        new AlertDialog.Builder(getActivity())
                .setTitle("提示信息_true")
                .setMessage("当前应用缺少必要权限，该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
                        startActivity(intent);
                    }
                }).show();
    }

    @Override
    public void permissionFail(int requestCode) {
    }

    @Override
    public void permissionSuccess(int requestCode) {
        Toast.makeText(getActivity(), "获取权限成功", Toast.LENGTH_SHORT).show();
    }

}
