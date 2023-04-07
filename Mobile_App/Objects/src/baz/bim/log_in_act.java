package baz.bim;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class log_in_act extends Activity implements B4AActivity{
	public static log_in_act mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "baz.bim", "baz.bim.log_in_act");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (log_in_act).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "baz.bim", "baz.bim.log_in_act");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "baz.bim.log_in_act", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (log_in_act) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (log_in_act) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return log_in_act.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (log_in_act) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (log_in_act) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edt_username = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edt_password = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check_remem = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_forget = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_login = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_view = null;
public static boolean _view_btn = false;
public anywheresoftware.b4a.samples.httputils2.httputils2service _vvv5 = null;
public baz.bim.main _vvv6 = null;
public baz.bim.choose_groups _choose_groups = null;
public baz.bim.see_groups _see_groups = null;
public baz.bim.config_app _config_app = null;
public baz.bim.main_act _main_act = null;
public baz.bim.sizeviewv3 _vvv7 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"login_page\")";
mostCurrent._activity.LoadLayout("login_page",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="sizeviewV3.SetPX(Activity.Width,Activity.Height,2";
mostCurrent._vvv7._vv0(mostCurrent.activityBA,(float) (mostCurrent._activity.getWidth()),(float) (mostCurrent._activity.getHeight()),(float) (240),(float) (320));
 //BA.debugLineNum = 27;BA.debugLine="sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)";
mostCurrent._vvv7._vv7(mostCurrent.activityBA,(float) (3.333),(float) (4.444));
 //BA.debugLineNum = 28;BA.debugLine="sizeviewV3.SetSize_txt(edt_username,0,20,50,220,1";
mostCurrent._vvv7._setsize_txt(mostCurrent.activityBA,mostCurrent._edt_username,(float) (0),(float) (20),(float) (50),(float) (220),(float) (15));
 //BA.debugLineNum = 29;BA.debugLine="sizeviewV3.SetSize_txt(edt_Password,55,20,50,220,";
mostCurrent._vvv7._setsize_txt(mostCurrent.activityBA,mostCurrent._edt_password,(float) (55),(float) (20),(float) (50),(float) (220),(float) (15));
 //BA.debugLineNum = 30;BA.debugLine="sizeviewV3.SetSize_btn(btn_view,75,0,10,20,15)";
mostCurrent._vvv7._setsize_btn(mostCurrent.activityBA,mostCurrent._btn_view,(float) (75),(float) (0),(float) (10),(float) (20),(float) (15));
 //BA.debugLineNum = 31;BA.debugLine="sizeviewV3.SetSize_check(check_remem,125,0,30,240";
mostCurrent._vvv7._setsize_check(mostCurrent.activityBA,mostCurrent._check_remem,(float) (125),(float) (0),(float) (30),(float) (240),(float) (15));
 //BA.debugLineNum = 32;BA.debugLine="sizeviewV3.SetSize_btn(btn_login,157,100,50,60,15";
mostCurrent._vvv7._setsize_btn(mostCurrent.activityBA,mostCurrent._btn_login,(float) (157),(float) (100),(float) (50),(float) (60),(float) (15));
 //BA.debugLineNum = 33;BA.debugLine="sizeviewV3.SetSize_lbl_Views(lbl_forget,255,20,40";
mostCurrent._vvv7._setsize_lbl_views(mostCurrent.activityBA,mostCurrent._lbl_forget,(float) (255),(float) (20),(float) (40),(float) (220),(float) (15));
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 87;BA.debugLine="If KeyCode=KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 88;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 //BA.debugLineNum = 90;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _btn_login_click() throws Exception{
anywheresoftware.b4a.agraham.encryption.Base64 _bs = null;
 //BA.debugLineNum = 59;BA.debugLine="Sub btn_login_Click";
 //BA.debugLineNum = 61;BA.debugLine="Dim bs As Base64";
_bs = new anywheresoftware.b4a.agraham.encryption.Base64();
 //BA.debugLineNum = 63;BA.debugLine="If edt_Password.Text<>\"\" Or edt_username.Text<>\"\"";
if ((mostCurrent._edt_password.getText()).equals("") == false || (mostCurrent._edt_username.getText()).equals("") == false) { 
 //BA.debugLineNum = 64;BA.debugLine="config_App.user_username=edt_username.Text";
mostCurrent._config_app._user_username = mostCurrent._edt_username.getText();
 //BA.debugLineNum = 65;BA.debugLine="config_App.user_password=edt_Password.Text";
mostCurrent._config_app._user_password = mostCurrent._edt_password.getText();
 //BA.debugLineNum = 66;BA.debugLine="If check_remem.Checked Then";
if (mostCurrent._check_remem.getChecked()) { 
 //BA.debugLineNum = 68;BA.debugLine="File.MakeDir(File.DirInternal,config_App.ps_pat";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._config_app._ps_path);
 //BA.debugLineNum = 69;BA.debugLine="File.MakeDir(File.DirInternal,config_App.us_pat";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._config_app._us_path);
 //BA.debugLineNum = 70;BA.debugLine="File.WriteString(File.DirInternal,config_App.ps";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._config_app._ps_path+mostCurrent._config_app._ps_file_name,_bs.EncodeStoS(mostCurrent._edt_password.getText(),"UTF-8"));
 //BA.debugLineNum = 71;BA.debugLine="File.WriteString(File.DirInternal,config_App.us";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._config_app._us_path+mostCurrent._config_app._us_file_name,_bs.EncodeStoS(mostCurrent._edt_username.getText(),"UTF-8"));
 }else {
 //BA.debugLineNum = 74;BA.debugLine="File.Delete(File.DirInternal,config_App.ps_path";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._config_app._ps_path+mostCurrent._config_app._ps_file_name);
 //BA.debugLineNum = 75;BA.debugLine="File.Delete(File.DirInternal,config_App.us_path";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._config_app._us_path+mostCurrent._config_app._us_file_name);
 };
 //BA.debugLineNum = 77;BA.debugLine="StartActivity(main_act)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._main_act.getObject()));
 //BA.debugLineNum = 78;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
 //BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"لطفا نام کاربری و کلمه عبور خو";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("لطفا نام کاربری و کلمه عبور خود را وارد نمایید"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _btn_view_click() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Sub btn_view_Click";
 //BA.debugLineNum = 47;BA.debugLine="If view_btn=False Then";
if (_view_btn==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 48;BA.debugLine="btn_view.SetBackgroundImage(LoadBitmap(File.DirA";
mostCurrent._btn_view.SetBackgroundImage((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"preview_on.png").getObject()));
 //BA.debugLineNum = 49;BA.debugLine="edt_Password.PasswordMode=False";
mostCurrent._edt_password.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 50;BA.debugLine="view_btn=True";
_view_btn = anywheresoftware.b4a.keywords.Common.True;
 }else if(_view_btn==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 52;BA.debugLine="btn_view.SetBackgroundImage(LoadBitmap(File.DirA";
mostCurrent._btn_view.SetBackgroundImage((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"preview_off.png").getObject()));
 //BA.debugLineNum = 53;BA.debugLine="edt_Password.PasswordMode=True";
mostCurrent._edt_password.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 54;BA.debugLine="view_btn=False";
_view_btn = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private edt_username As EditText";
mostCurrent._edt_username = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private edt_Password As EditText";
mostCurrent._edt_password = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private check_remem As CheckBox";
mostCurrent._check_remem = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private lbl_forget As Label";
mostCurrent._lbl_forget = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private btn_login As Button";
mostCurrent._btn_login = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private btn_view As Button";
mostCurrent._btn_view = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim view_btn As Boolean=False";
_view_btn = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
}
