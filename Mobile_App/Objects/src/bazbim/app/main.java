package bazbim.app;


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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "bazbim.app", "bazbim.app.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "bazbim.app", "bazbim.app.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "bazbim.app.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (main) Resume **");
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
public static anywheresoftware.b4a.samples.httputils2.httpjob _ht_info = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_name = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_score = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_choose = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lst_selected = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_see = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_choose = null;
public anywheresoftware.b4a.objects.WebViewWrapper _wb_news = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public bazbim.app.log_in_act _log_in_act = null;
public bazbim.app.choose_groups _choose_groups = null;
public bazbim.app.see_groups _see_groups = null;
public bazbim.app.config_app _config_app = null;
public bazbim.app.sizeviewv3 _sizeviewv3 = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (log_in_act.mostCurrent != null);
vis = vis | (choose_groups.mostCurrent != null);
vis = vis | (see_groups.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
bazbim.app.sec_class_2 _sc = null;
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"home_information\")";
mostCurrent._activity.LoadLayout("home_information",mostCurrent.activityBA);
 //BA.debugLineNum = 39;BA.debugLine="sizeviewV3.SetPX(Activity.Width,Activity.Height,2";
mostCurrent._sizeviewv3._setpx(mostCurrent.activityBA,(float) (mostCurrent._activity.getWidth()),(float) (mostCurrent._activity.getHeight()),(float) (240),(float) (320));
 //BA.debugLineNum = 40;BA.debugLine="sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)";
mostCurrent._sizeviewv3._setpastscreensizetoinche(mostCurrent.activityBA,(float) (3.333),(float) (4.444));
 //BA.debugLineNum = 41;BA.debugLine="sizeviewV3.SetSize_lbl_Views(lbl_choose,80,170,40";
mostCurrent._sizeviewv3._setsize_lbl_views(mostCurrent.activityBA,mostCurrent._lbl_choose,(float) (80),(float) (170),(float) (40),(float) (70),(float) (15));
 //BA.debugLineNum = 42;BA.debugLine="sizeviewV3.SetSize_lbl_Views(lbl_name,0,170,40,70";
mostCurrent._sizeviewv3._setsize_lbl_views(mostCurrent.activityBA,mostCurrent._lbl_name,(float) (0),(float) (170),(float) (40),(float) (70),(float) (15));
 //BA.debugLineNum = 43;BA.debugLine="sizeviewV3.SetSize_lbl_Views(lbl_score,40,170,40,";
mostCurrent._sizeviewv3._setsize_lbl_views(mostCurrent.activityBA,mostCurrent._lbl_score,(float) (40),(float) (170),(float) (40),(float) (70),(float) (15));
 //BA.debugLineNum = 44;BA.debugLine="sizeviewV3.SetSizeViews(wb_news,0,0,220,170,0)";
mostCurrent._sizeviewv3._setsizeviews(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._wb_news.getObject())),(float) (0),(float) (0),(float) (220),(float) (170),(float) (0));
 //BA.debugLineNum = 45;BA.debugLine="sizeviewV3.SetSize_listview(lst_selected,120,170,";
mostCurrent._sizeviewv3._setsize_listview(mostCurrent.activityBA,mostCurrent._lst_selected,(float) (120),(float) (170),(float) (100),(float) (70),(float) (15));
 //BA.debugLineNum = 46;BA.debugLine="sizeviewV3.SetSize_btn(btn_see,220,0,100,110,15)";
mostCurrent._sizeviewv3._setsize_btn(mostCurrent.activityBA,mostCurrent._btn_see,(float) (220),(float) (0),(float) (100),(float) (110),(float) (15));
 //BA.debugLineNum = 47;BA.debugLine="sizeviewV3.SetSize_btn(btn_choose,220,130,100,110";
mostCurrent._sizeviewv3._setsize_btn(mostCurrent.activityBA,mostCurrent._btn_choose,(float) (220),(float) (130),(float) (100),(float) (110),(float) (15));
 //BA.debugLineNum = 50;BA.debugLine="config_App.user_username=\"snk\"";
mostCurrent._config_app._user_username = "snk";
 //BA.debugLineNum = 51;BA.debugLine="config_App.user_password=\"1234\"";
mostCurrent._config_app._user_password = "1234";
 //BA.debugLineNum = 53;BA.debugLine="Dim sc As sec_Class_2";
_sc = new bazbim.app.sec_class_2();
 //BA.debugLineNum = 54;BA.debugLine="ht_info.Initialize(\"person_info\",Me)";
_ht_info._initialize(processBA,"person_info",main.getObject());
 //BA.debugLineNum = 55;BA.debugLine="ht_info.PostString(config_App.person_info_url,\"us";
_ht_info._poststring(mostCurrent._config_app._person_info_url,"us_name="+_sc._encryption(mostCurrent._config_app._user_username)+"&ps_user="+_sc._encryption(mostCurrent._config_app._user_password));
 //BA.debugLineNum = 56;BA.debugLine="ProgressDialogShow2(\"در حال بروزرسانی اطلاعات ، ل";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال بروزرسانی اطلاعات ، لطفا کمی صبر کنید ..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _btn_choose_click() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Sub btn_choose_Click";
 //BA.debugLineNum = 137;BA.debugLine="StartActivity(choose_groups)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._choose_groups.getObject()));
 //BA.debugLineNum = 138;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _btn_see_click() throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Sub btn_see_Click";
 //BA.debugLineNum = 132;BA.debugLine="StartActivity(see_groups)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._see_groups.getObject()));
 //BA.debugLineNum = 133;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private lbl_name As Label";
mostCurrent._lbl_name = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lbl_score As Label";
mostCurrent._lbl_score = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lbl_choose As Label";
mostCurrent._lbl_choose = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lst_selected As ListView";
mostCurrent._lst_selected = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private btn_see As Button";
mostCurrent._btn_see = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private btn_choose As Button";
mostCurrent._btn_choose = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private wb_news As WebView";
mostCurrent._wb_news = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
bazbim.app.sec_class_2 _sc = null;
 //BA.debugLineNum = 68;BA.debugLine="Sub JobDone(Job As HttpJob)";
 //BA.debugLineNum = 69;BA.debugLine="Dim sc As sec_Class_2";
_sc = new bazbim.app.sec_class_2();
 //BA.debugLineNum = 71;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 72;BA.debugLine="If Job.Success Then";
if (_job._success) { 
 //BA.debugLineNum = 73;BA.debugLine="Try";
try { //BA.debugLineNum = 74;BA.debugLine="If Job.JobName=\"person_info\" Then";
if ((_job._jobname).equals("person_info")) { 
 //BA.debugLineNum = 75;BA.debugLine="If Job.GetString=sc.Encryption(\"wrong_info\") T";
if ((_job._getstring()).equals(_sc._encryption("wrong_info"))) { 
 //BA.debugLineNum = 76;BA.debugLine="Msgbox(\"نام کاربری یا کلمه عبور اشتباه میباشد";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("نام کاربری یا کلمه عبور اشتباه میباشد ؛ در صورت فراموشی ، لطفا با تلفن بازبیم تماس حاصل فرمایید"),BA.ObjectToCharSequence("خطا"),mostCurrent.activityBA);
 }else {
 //BA.debugLineNum = 78;BA.debugLine="Msgbox(Job.GetString,\"\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(_job._getstring()),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 79;BA.debugLine="refresh_info(Job.GetString)";
_refresh_info(_job._getstring());
 };
 };
 } 
       catch (Exception e14) {
			processBA.setLastException(e14); };
 }else {
 //BA.debugLineNum = 86;BA.debugLine="Msgbox(\"خطایی در ارتباط با مرکز به وجود آمده ؛ ل";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        anywheresoftware.b4a.samples.httputils2.httputils2service._process_globals();
main._process_globals();
log_in_act._process_globals();
choose_groups._process_globals();
see_groups._process_globals();
config_app._process_globals();
sizeviewv3._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim ht_info As HttpJob";
_ht_info = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _refresh_info(String _str_val) throws Exception{
bazbim.app.sec_class_2 _sc = null;
anywheresoftware.b4a.objects.collections.JSONParser _js1 = null;
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.collections.Map _mp = null;
 //BA.debugLineNum = 90;BA.debugLine="Sub refresh_info(str_val As String)";
 //BA.debugLineNum = 91;BA.debugLine="Dim sc As sec_Class_2";
_sc = new bazbim.app.sec_class_2();
 //BA.debugLineNum = 92;BA.debugLine="Dim js1 As JSONParser";
_js1 = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 93;BA.debugLine="js1.Initialize(sc.Decryption(str_val))";
_js1.Initialize(_sc._decryption(_str_val));
 //BA.debugLineNum = 95;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 96;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 97;BA.debugLine="lst=js1.NextArray";
_lst = _js1.NextArray();
 //BA.debugLineNum = 99;BA.debugLine="Dim mp As Map";
_mp = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 100;BA.debugLine="mp.Initialize";
_mp.Initialize();
 //BA.debugLineNum = 101;BA.debugLine="mp=lst.Get(0)";
_mp.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_lst.Get((int) (0))));
 //BA.debugLineNum = 104;BA.debugLine="config_App.user_Fname=mp.Get(\"fname\")";
mostCurrent._config_app._user_fname = BA.ObjectToString(_mp.Get((Object)("fname")));
 //BA.debugLineNum = 105;BA.debugLine="config_App.user_Score=mp.Get(\"score\")";
mostCurrent._config_app._user_score = BA.ObjectToString(_mp.Get((Object)("score")));
 //BA.debugLineNum = 106;BA.debugLine="config_App.user_Group_num=mp.Get(\"group_num\")";
mostCurrent._config_app._user_group_num = (int)(BA.ObjectToNumber(_mp.Get((Object)("group_num"))));
 //BA.debugLineNum = 107;BA.debugLine="config_App.user_groups=mp.Get(\"groups\")";
mostCurrent._config_app._user_groups = BA.ObjectToString(_mp.Get((Object)("groups")));
 //BA.debugLineNum = 109;BA.debugLine="lbl_name.Text=\"سلام \"&config_App.user_Fname";
mostCurrent._lbl_name.setText(BA.ObjectToCharSequence("سلام "+mostCurrent._config_app._user_fname));
 //BA.debugLineNum = 110;BA.debugLine="lbl_score.Text=\"امتیاز : \"&config_App.user_Score";
mostCurrent._lbl_score.setText(BA.ObjectToCharSequence("امتیاز : "+mostCurrent._config_app._user_score));
 //BA.debugLineNum = 111;BA.debugLine="lbl_choose.Text=\"انتخاب :\"&(config_App.user_Score";
mostCurrent._lbl_choose.setText(BA.ObjectToCharSequence("انتخاب :"+BA.NumberToString(((double)(Double.parseDouble(mostCurrent._config_app._user_score))-mostCurrent._config_app._user_group_num))));
 //BA.debugLineNum = 113;BA.debugLine="set_Sort_Groups_in_list(sc.Decryption(config_App.";
_set_sort_groups_in_list(_sc._decryption(mostCurrent._config_app._user_groups));
 //BA.debugLineNum = 114;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _set_sort_groups_in_list(String _str_val) throws Exception{
int _char_position = 0;
int _i = 0;
 //BA.debugLineNum = 117;BA.debugLine="Sub set_Sort_Groups_in_list(str_val As String)";
 //BA.debugLineNum = 118;BA.debugLine="Dim char_position As Int=0";
_char_position = (int) (0);
 //BA.debugLineNum = 119;BA.debugLine="For i=0 To config_App.user_Group_num-1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._config_app._user_group_num-1);
for (_i = (int) (0) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
 //BA.debugLineNum = 120;BA.debugLine="If i=config_App.user_Group_num-1 Then";
if (_i==mostCurrent._config_app._user_group_num-1) { 
 //BA.debugLineNum = 122;BA.debugLine="lst_selected.AddSingleLine(\"  \"&str_val.SubStri";
mostCurrent._lst_selected.AddSingleLine(BA.ObjectToCharSequence("  "+_str_val.substring(_char_position,_str_val.length())+"  "));
 }else {
 //BA.debugLineNum = 125;BA.debugLine="lst_selected.AddSingleLine(\"  \"&str_val.SubStri";
mostCurrent._lst_selected.AddSingleLine(BA.ObjectToCharSequence("  "+_str_val.substring(_char_position,_str_val.indexOf(",",(int) (_char_position+1)))+"  "));
 //BA.debugLineNum = 126;BA.debugLine="char_position=str_val.IndexOf2(\",\",char_positio";
_char_position = (int) (_str_val.indexOf(",",(int) (_char_position+1))+1);
 };
 }
};
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
}
