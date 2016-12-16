MLogCat
=======
MLogCat是指Mobile LogCat移植自Eclipse的LogCat。

MLogCat是一个library，原先出自[Catlog](https://github.com/nolanlawson/Catlog),现用[SAF](https://github.com/fengzhizi715/SAF)框架做了一些优化。未来会做一些定制功能。方便app开发人员在线调试bug。


使用方法
---
在AndroidMainfest.xml里添加

        <!-- 日志显示页面 logcat start -->
        <activity
            android:name="cn.salesuite.mlogcat.activity.LogcatActivity"
            android:configChanges="keyboard|keyboardHidden|orientation"
            android:label="@string/app_name"
            android:launchMode="singleTop"
            android:windowSoftInputMode="stateHidden" >

            <intent-filter>
                <action android:name="com.nolanlawson.logcat.intents.LAUNCH" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
        <activity
            android:name="cn.salesuite.mlogcat.activity.AboutActivity"
            android:theme="@android:style/Theme.Dialog" />
        <activity
            android:name="cn.salesuite.mlogcat.activity.ShowRecordLogDialogActivity"
            android:theme="@android:style/Theme.Dialog" />
        <activity android:name="cn.salesuite.mlogcat.activity.SettingsActivity" />

        <service android:name="cn.salesuite.mlogcat.activity.LogcatRecordingService" />
        <service android:name="cn.salesuite.mlogcat.activity.CrazyLoggerService" />

        <receiver android:name="cn.salesuite.mlogcat.activity.RecordingWidgetProvider" >
            <intent-filter>
                <action android:name="android.appwidget.action.APPWIDGET_UPDATE" />

                <data android:scheme="catlog_widget" />
            </intent-filter>
            <intent-filter>
                <action android:name="android.appwidget.action.APPWIDGET_UPDATE" />
            </intent-filter>
            <intent-filter>
                <action android:name="com.nolanlawson.logcat.action.RECORD_OR_STOP" />

                <data android:scheme="catlog_widget" />
            </intent-filter>

            <meta-data
                android:name="android.appwidget.provider"
                android:resource="@xml/recording_widget_info" />
        </receiver>
        <!-- 日志显示页面 logcat end -->
        

在某个activity中跳转到LogcatActivity即可进入MLogCat的界面。