package com.csonezp.xposeddemo2;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by csonezp on 16-2-2.
 */
public class HookDemo implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.csonezp.xposeddemo2")) {
            Class clasz = loadPackageParam.classLoader.loadClass("com.csonezp.xposeddemo2.MainActivity");
            XposedHelpers.findAndHookMethod(clasz, "isEquls", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Integer para1 = (Integer) param.args[0];   //获取参数1
                    String s1 = Integer.toString(para1);
                    Log.v("hook before param1:", s1);
                    param.args[0] = 3;  //设置参数1
                    Log.v("hook", "before hook!");
                    XposedBridge.log("hook before param1:" + s1);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    boolean res = (boolean) param.getResult();
                    Log.v("hook after result :", res + "");
                    Integer para1 = (Integer) param.args[0];   //获取参数1
                    String s1 = Integer.toString(para1);
                    param.setResult(true);   //设置返回值
                    XposedBridge.log("hook after result:true");
                    Log.v("hook param1:", s1);
                }
            });
        }
    }
}
