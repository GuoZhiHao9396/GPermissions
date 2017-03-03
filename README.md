# GPermissions
#Android6.0权限

![image](https://github.com/GuoZhiHao9396/GPermissions/blob/master/app/src/main/res/raw/test.gif)

AndroidStudio使用Gradle构建添加依赖（推荐）

Add it in your root build.gradle at the end of repositories:
```java
	dependencies {
           compile files('libs/gpermissionslibrary-v1.0.0.jar')
    }
```
#使用介绍

```java
    1、Activity或者Fragment实现IGPermissions接口，该接口有三个方法rationale（拒绝后的操作）、permissionFail（请求失败）、permissionSuccess（请求成功）
    
    2、直接在需要请求的地方实现如下方法：
       例如：GPermissionsUtils.requestPermission(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0, false);
       参数（上下文，请求权限的数组，请求权限的参数值，是否采用系统的拒绝后操作）   
       
    3、在系统的onRequestPermissionsResult方法下执行
       GPermissionsUtils.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
```
IGPermissions接口
```接口
public interface IGPermissions {

    void rationale(int requestCode);

    void permissionFail(int requestCode);

    void permissionSuccess(int requestCode);
}
```

#License
```text
Copyright 2016 ZhiHao Guo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
