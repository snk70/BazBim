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

public class choose_groups extends Activity implements B4AActivity{
	public static choose_groups mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "baz.bim", "baz.bim.choose_groups");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (choose_groups).");
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
		activityBA = new BA(this, layout, processBA, "baz.bim", "baz.bim.choose_groups");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "baz.bim.choose_groups", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (choose_groups) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (choose_groups) Resume **");
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
		return choose_groups.class;
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
        BA.LogInfo("** Activity (choose_groups) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (choose_groups) Resume **");
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
public static anywheresoftware.b4a.samples.httputils2.httpjob _grp_job = null;
public static anywheresoftware.b4a.samples.httputils2.httpjob _member_ship = null;
public anywheresoftware.b4a.objects.collections.List _lst_grp_num = null;
public anywheresoftware.b4a.objects.collections.List _lst_grp_users_num = null;
public static int _user_group_selected = 0;
public static int _job_st = 0;
public static String _job_rs = "";
public anywheresoftware.b4a.samples.httputils2.httputils2service _vvv5 = null;
public baz.bim.main _vvv6 = null;
public baz.bim.log_in_act _log_in_act = null;
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
baz.bim.sec_class_2 _sc = null;
 //BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 26;BA.debugLine="Activity.Color=Colors.White";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 27;BA.debugLine="Dim sc As sec_Class_2";
_sc = new baz.bim.sec_class_2();
 //BA.debugLineNum = 28;BA.debugLine="grp_job.Initialize(\"grp_info\",Me)";
_grp_job._initialize(processBA,"grp_info",choose_groups.getObject());
 //BA.debugLineNum = 29;BA.debugLine="grp_job.PostString(config_App.grp_info_url,\"us_na";
_grp_job._poststring(mostCurrent._config_app._grp_info_url,"us_name="+_sc._vvv3(mostCurrent._config_app._user_username)+"&us_pass="+_sc._vvv3(mostCurrent._config_app._user_password)+"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler");
 //BA.debugLineNum = 30;BA.debugLine="ProgressDialogShow2(\"در حال دریافت اطلاعات گروه ه";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال دریافت اطلاعات گروه ها ؛ لطفا کمی صبر نمایید ..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 210;BA.debugLine="If KeyCode=KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 211;BA.debugLine="StartActivity(main_act)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._main_act.getObject()));
 //BA.debugLineNum = 212;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 214;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _apply_responses() throws Exception{
baz.bim.sec_class_2 _sc = null;
 //BA.debugLineNum = 129;BA.debugLine="Sub apply_responses";
 //BA.debugLineNum = 131;BA.debugLine="Dim sc As sec_Class_2";
_sc = new baz.bim.sec_class_2();
 //BA.debugLineNum = 133;BA.debugLine="If job_st=0 Then";
if (_job_st==0) { 
 }else if(_job_st==1) { 
 //BA.debugLineNum = 136;BA.debugLine="member_ship.Initialize(\"member_ship_req\",Me)";
_member_ship._initialize(processBA,"member_ship_req",choose_groups.getObject());
 //BA.debugLineNum = 137;BA.debugLine="member_ship.PostString(config_App.member_grp,\"us";
_member_ship._poststring(mostCurrent._config_app._member_grp,"us_name="+_sc._vvv3(mostCurrent._config_app._user_username)+"&us_pass="+_sc._vvv3(mostCurrent._config_app._user_password)+"&req_qrp="+_sc._vvv3(BA.ObjectToString(mostCurrent._lst_grp_num.Get(_user_group_selected)))+"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler");
 }else if(_job_st==2) { 
 //BA.debugLineNum = 139;BA.debugLine="If job_rs=sc.Encryption(\"tm_exp\") Then";
if ((mostCurrent._job_rs).equals(_sc._vvv3("tm_exp"))) { 
 //BA.debugLineNum = 141;BA.debugLine="Msgbox(\". کاربر گرامی ؛ انتخاب گروه ها در این د";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(". کاربر گرامی ؛ انتخاب گروه ها در این دوره به پایان رسیده . "+anywheresoftware.b4a.keywords.Common.CRLF+"از فردا نسبت به انتخاب گروه های جدید اقدام نمایید ."),BA.ObjectToCharSequence("پایان دوره"),mostCurrent.activityBA);
 //BA.debugLineNum = 142;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 }else if((mostCurrent._job_rs).equals(_sc._vvv3("ok_added"))) { 
 //BA.debugLineNum = 145;BA.debugLine="ToastMessageShow(\"کاربر گرامی ؛ با تشکر ، انتخا";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("کاربر گرامی ؛ با تشکر ، انتخاب شما ثبت گردید ."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 146;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 }else if((mostCurrent._job_rs).equals(_sc._vvv3("error_operation"))) { 
 //BA.debugLineNum = 149;BA.debugLine="Msgbox(\"متأسفانه مشکلی در هنگام برقراری ارتباط";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("متأسفانه مشکلی در هنگام برقراری ارتباط با مرکز به وجود آمده است ، لطفا کمی صبر کنید و مجددا تلاش نمایید ."+anywheresoftware.b4a.keywords.Common.CRLF+"در صورت عدم رفع مشکل ، لطفا موضوع را با کارشناسان بازبیم در ارتباط بگذارید ."),BA.ObjectToCharSequence("خطا"),mostCurrent.activityBA);
 }else if((mostCurrent._job_rs).equals(_sc._vvv3("not_enough_score"))) { 
 //BA.debugLineNum = 152;BA.debugLine="Msgbox(\"کاربر گرامی ؛ امتیاز شما برای انتخاب جد";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("کاربر گرامی ؛ امتیاز شما برای انتخاب جدید کافی نمیباشد ، لطفا نسبت به جمع آوری امتیاز های جدید اقدام نمایید ."),BA.ObjectToCharSequence("عدم امتیاز کافی"),mostCurrent.activityBA);
 //BA.debugLineNum = 153;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 };
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Dim lst_grp_num,lst_grp_users_num As List";
mostCurrent._lst_grp_num = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._lst_grp_users_num = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="Dim user_group_selected As Int";
_user_group_selected = 0;
 //BA.debugLineNum = 21;BA.debugLine="Dim job_st As Int";
_job_st = 0;
 //BA.debugLineNum = 22;BA.debugLine="Dim job_rs As String";
mostCurrent._job_rs = "";
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
baz.bim.sec_class_2 _sc = null;
anywheresoftware.b4a.objects.collections.JSONParser _js = null;
anywheresoftware.b4a.objects.collections.List _lst_info = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _mp = null;
int _sel_item = 0;
 //BA.debugLineNum = 34;BA.debugLine="Sub JobDone(job As HttpJob)";
 //BA.debugLineNum = 35;BA.debugLine="Dim sc As sec_Class_2";
_sc = new baz.bim.sec_class_2();
 //BA.debugLineNum = 37;BA.debugLine="If job.Success=True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 38;BA.debugLine="If job.JobName=\"grp_info\" Then";
if ((_job._jobname).equals("grp_info")) { 
 //BA.debugLineNum = 39;BA.debugLine="If job.GetString=sc.Encryption(\"wrong_info\") Th";
if ((_job._getstring()).equals(_sc._vvv3("wrong_info"))) { 
 //BA.debugLineNum = 40;BA.debugLine="ToastMessageShow(\"Wrong information\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Wrong information"),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 42;BA.debugLine="lst_grp_num.Initialize";
mostCurrent._lst_grp_num.Initialize();
 //BA.debugLineNum = 43;BA.debugLine="lst_grp_users_num.Initialize";
mostCurrent._lst_grp_users_num.Initialize();
 //BA.debugLineNum = 44;BA.debugLine="lst_grp_num.Clear";
mostCurrent._lst_grp_num.Clear();
 //BA.debugLineNum = 45;BA.debugLine="lst_grp_users_num.Clear";
mostCurrent._lst_grp_users_num.Clear();
 //BA.debugLineNum = 46;BA.debugLine="Dim js As JSONParser";
_js = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 47;BA.debugLine="js.Initialize(sc.Decryption(job.GetString))";
_js.Initialize(_sc._vvv2(_job._getstring()));
 //BA.debugLineNum = 48;BA.debugLine="Dim lst_info As List";
_lst_info = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 49;BA.debugLine="lst_info.Initialize";
_lst_info.Initialize();
 //BA.debugLineNum = 50;BA.debugLine="lst_info=js.NextArray";
_lst_info = _js.NextArray();
 //BA.debugLineNum = 51;BA.debugLine="For i=0 To lst_info.Size-1";
{
final int step16 = 1;
final int limit16 = (int) (_lst_info.getSize()-1);
for (_i = (int) (0) ; (step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16); _i = ((int)(0 + _i + step16)) ) {
 //BA.debugLineNum = 52;BA.debugLine="Dim mp As Map";
_mp = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 53;BA.debugLine="mp.Initialize";
_mp.Initialize();
 //BA.debugLineNum = 54;BA.debugLine="mp=lst_info.Get(i)";
_mp.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_lst_info.Get(_i)));
 //BA.debugLineNum = 55;BA.debugLine="lst_grp_num.Add(mp.Get(\"grp_num\"))";
mostCurrent._lst_grp_num.Add(_mp.Get((Object)("grp_num")));
 //BA.debugLineNum = 56;BA.debugLine="lst_grp_users_num.Add(mp.Get(\"user_num\"))";
mostCurrent._lst_grp_users_num.Add(_mp.Get((Object)("user_num")));
 }
};
 //BA.debugLineNum = 59;BA.debugLine="Dim sel_item As Int =InputList(lst_grp_num,\"ان";
_sel_item = anywheresoftware.b4a.keywords.Common.InputList(mostCurrent._lst_grp_num,BA.ObjectToCharSequence("انتخاب گروه مورد نظر"),(int) (-1),mostCurrent.activityBA);
 //BA.debugLineNum = 60;BA.debugLine="If sel_item>-1 Then";
if (_sel_item>-1) { 
 //BA.debugLineNum = 61;BA.debugLine="If Msgbox2(\"آیا مایل به عضویت در گروه شماره \"";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("آیا مایل به عضویت در گروه شماره "+BA.ObjectToString(mostCurrent._lst_grp_num.Get(_sel_item))+" با "+BA.ObjectToString(mostCurrent._lst_grp_users_num.Get(_sel_item))+" اعضا را دارید ؟"),BA.ObjectToCharSequence("عضویت در گروه"),"بله","خیر","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 63;BA.debugLine="user_group_selected=sel_item";
_user_group_selected = _sel_item;
 //BA.debugLineNum = 64;BA.debugLine="job_st=1";
_job_st = (int) (1);
 }else {
 //BA.debugLineNum = 66;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 };
 }else {
 //BA.debugLineNum = 69;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 };
 };
 }else if((_job._jobname).equals("member_ship_req")) { 
 //BA.debugLineNum = 73;BA.debugLine="job_st=2";
_job_st = (int) (2);
 //BA.debugLineNum = 74;BA.debugLine="job_rs=job.GetString";
mostCurrent._job_rs = _job._getstring();
 };
 }else if(_job._success==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 77;BA.debugLine="job_st=0";
_job_st = (int) (0);
 };
 //BA.debugLineNum = 81;BA.debugLine="apply_responses";
_apply_responses();
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Dim grp_job,member_ship As HttpJob";
_grp_job = new anywheresoftware.b4a.samples.httputils2.httpjob();
_member_ship = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public static String  _set_and_sort_groups(String _str_val) throws Exception{
baz.bim.sec_class_2 _sc = null;
anywheresoftware.b4a.objects.collections.JSONParser _groups_info_js = null;
anywheresoftware.b4a.objects.collections.List _groups_info_lists = null;
String[] _groups_user_num = null;
String[] _groups_number = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _mp = null;
anywheresoftware.b4a.objects.collections.List _lst_numbers = null;
int _sel_grp = 0;
String _group_info = "";
 //BA.debugLineNum = 164;BA.debugLine="Sub set_and_sort_groups(str_val As String)";
 //BA.debugLineNum = 165;BA.debugLine="Dim sc As sec_Class_2";
_sc = new baz.bim.sec_class_2();
 //BA.debugLineNum = 166;BA.debugLine="str_val=sc.Decryption(str_val)";
_str_val = _sc._vvv2(_str_val);
 //BA.debugLineNum = 168;BA.debugLine="Dim groups_info_js As JSONParser";
_groups_info_js = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 169;BA.debugLine="groups_info_js.Initialize(str_val)";
_groups_info_js.Initialize(_str_val);
 //BA.debugLineNum = 171;BA.debugLine="Dim groups_info_lists As List";
_groups_info_lists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 172;BA.debugLine="groups_info_lists.Initialize";
_groups_info_lists.Initialize();
 //BA.debugLineNum = 173;BA.debugLine="groups_info_lists=groups_info_js.NextArray";
_groups_info_lists = _groups_info_js.NextArray();
 //BA.debugLineNum = 175;BA.debugLine="Dim groups_user_num(groups_info_lists.Size) As St";
_groups_user_num = new String[_groups_info_lists.getSize()];
java.util.Arrays.fill(_groups_user_num,"");
 //BA.debugLineNum = 176;BA.debugLine="Dim groups_number(groups_info_lists.Size) As Stri";
_groups_number = new String[_groups_info_lists.getSize()];
java.util.Arrays.fill(_groups_number,"");
 //BA.debugLineNum = 179;BA.debugLine="For i=0 To groups_info_lists.Size-1";
{
final int step10 = 1;
final int limit10 = (int) (_groups_info_lists.getSize()-1);
for (_i = (int) (0) ; (step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10); _i = ((int)(0 + _i + step10)) ) {
 //BA.debugLineNum = 180;BA.debugLine="Dim mp As Map";
_mp = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 181;BA.debugLine="mp.Initialize";
_mp.Initialize();
 //BA.debugLineNum = 182;BA.debugLine="mp=groups_info_lists.Get(i)";
_mp.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_groups_info_lists.Get(_i)));
 //BA.debugLineNum = 184;BA.debugLine="groups_user_num(i)=mp.Get(\"user_num\")";
_groups_user_num[_i] = BA.ObjectToString(_mp.Get((Object)("user_num")));
 //BA.debugLineNum = 185;BA.debugLine="groups_number(i)=mp.Get(\"grp_num\")";
_groups_number[_i] = BA.ObjectToString(_mp.Get((Object)("grp_num")));
 }
};
 //BA.debugLineNum = 188;BA.debugLine="Dim lst_numbers As List";
_lst_numbers = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 189;BA.debugLine="lst_numbers.Initialize2(groups_number)";
_lst_numbers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(_groups_number));
 //BA.debugLineNum = 191;BA.debugLine="Dim sel_grp As Int = InputList(lst_numbers,\"انتخا";
_sel_grp = anywheresoftware.b4a.keywords.Common.InputList(_lst_numbers,BA.ObjectToCharSequence("انتخاب گروه مورد نظر"),(int) (-1),mostCurrent.activityBA);
 //BA.debugLineNum = 193;BA.debugLine="If sel_grp>-1 Then";
if (_sel_grp>-1) { 
 //BA.debugLineNum = 194;BA.debugLine="Dim group_info As String=\"گروه شماره \"&groups_nu";
_group_info = "گروه شماره "+_groups_number[_sel_grp]+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"تعداد اعضاء "+_groups_user_num[_sel_grp]+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"آیا مایل به انتخاب این گروه هستید ؟";
 //BA.debugLineNum = 196;BA.debugLine="If	 Msgbox2(group_info,\"انتخاب گروه\",\"بله\",\"خیر\"";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_group_info),BA.ObjectToCharSequence("انتخاب گروه"),"بله","خیر","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 197;BA.debugLine="ProgressDialogShow2(\"در حال ارسال درخواست عضویت";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال ارسال درخواست عضویت شما ؛ لطفا کمی صبر کنید ..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 198;BA.debugLine="member_ship.Initialize(\"member_ship_req\",Me)";
_member_ship._initialize(processBA,"member_ship_req",choose_groups.getObject());
 //BA.debugLineNum = 199;BA.debugLine="member_ship.PostString(config_App.member_grp,\"u";
_member_ship._poststring(mostCurrent._config_app._member_grp,"us_name="+_sc._vvv3(mostCurrent._config_app._user_username)+"&us_pass="+_sc._vvv3(mostCurrent._config_app._user_password)+"req_qrp="+_sc._vvv3(_groups_number[_sel_grp])+"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler");
 };
 //BA.debugLineNum = 201;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 }else {
 //BA.debugLineNum = 203;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 };
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
}
