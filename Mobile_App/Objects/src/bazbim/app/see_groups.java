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

public class see_groups extends Activity implements B4AActivity{
	public static see_groups mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "bazbim.app", "bazbim.app.see_groups");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (see_groups).");
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
		activityBA = new BA(this, layout, processBA, "bazbim.app", "bazbim.app.see_groups");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "bazbim.app.see_groups", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (see_groups) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (see_groups) Resume **");
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
		return see_groups.class;
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
        BA.LogInfo("** Activity (see_groups) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (see_groups) Resume **");
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
public anywheresoftware.b4a.objects.LabelWrapper _lbl_group_num = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_user_num = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scr_items = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public bazbim.app.main _main = null;
public bazbim.app.log_in_act _log_in_act = null;
public bazbim.app.choose_groups _choose_groups = null;
public bazbim.app.config_app _config_app = null;
public bazbim.app.sizeviewv3 _sizeviewv3 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
bazbim.app.sec_class_2 _sc = null;
 //BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"see_groups\")";
mostCurrent._activity.LoadLayout("see_groups",mostCurrent.activityBA);
 //BA.debugLineNum = 27;BA.debugLine="sizeviewV3.SetPX(Activity.Width,Activity.Height,2";
mostCurrent._sizeviewv3._setpx(mostCurrent.activityBA,(float) (mostCurrent._activity.getWidth()),(float) (mostCurrent._activity.getHeight()),(float) (240),(float) (320));
 //BA.debugLineNum = 28;BA.debugLine="sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)";
mostCurrent._sizeviewv3._setpastscreensizetoinche(mostCurrent.activityBA,(float) (3.333),(float) (4.444));
 //BA.debugLineNum = 29;BA.debugLine="sizeviewV3.SetSize_lbl_Views(lbl_user_num,-5,5,40";
mostCurrent._sizeviewv3._setsize_lbl_views(mostCurrent.activityBA,mostCurrent._lbl_user_num,(float) (-5),(float) (5),(float) (40),(float) (150),(float) (12));
 //BA.debugLineNum = 30;BA.debugLine="sizeviewV3.SetSize_lbl_Views(lbl_group_num,-5,165";
mostCurrent._sizeviewv3._setsize_lbl_views(mostCurrent.activityBA,mostCurrent._lbl_group_num,(float) (-5),(float) (165),(float) (40),(float) (70),(float) (12));
 //BA.debugLineNum = 31;BA.debugLine="sizeviewV3.SetSizeViews(scr_items,30,0,280,240,15";
mostCurrent._sizeviewv3._setsizeviews(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._scr_items.getObject())),(float) (30),(float) (0),(float) (280),(float) (240),(float) (15));
 //BA.debugLineNum = 32;BA.debugLine="scr_items.Panel.Height=3000";
mostCurrent._scr_items.getPanel().setHeight((int) (3000));
 //BA.debugLineNum = 63;BA.debugLine="Dim sc As sec_Class_2";
_sc = new bazbim.app.sec_class_2();
 //BA.debugLineNum = 65;BA.debugLine="grp_job.Initialize(\"grp_info\",Me)";
_grp_job._initialize(processBA,"grp_info",see_groups.getObject());
 //BA.debugLineNum = 66;BA.debugLine="grp_job.PostString(config_App.grp_info_url,\"us_na";
_grp_job._poststring(mostCurrent._config_app._grp_info_url,"us_name="+_sc._encryption(mostCurrent._config_app._user_username)+"&ps_user="+_sc._encryption(mostCurrent._config_app._user_password));
 //BA.debugLineNum = 67;BA.debugLine="ProgressDialogShow2(\"در حال دریافت اطلاعات گروه ه";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("در حال دریافت اطلاعات گروه ها ؛ لطفا کمی صبر نمایید ..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 143;BA.debugLine="If KeyCode=KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 144;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 145;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 147;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _analyz_group_info(String _str_val) throws Exception{
bazbim.app.sec_class_2 _sc = null;
anywheresoftware.b4a.objects.collections.JSONParser _js1 = null;
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.LabelWrapper[] _group_num = null;
anywheresoftware.b4a.objects.LabelWrapper[] _user_num = null;
int _view_top = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _mp = null;
 //BA.debugLineNum = 97;BA.debugLine="Sub analyz_group_info(str_val As String)";
 //BA.debugLineNum = 99;BA.debugLine="Dim sc As sec_Class_2";
_sc = new bazbim.app.sec_class_2();
 //BA.debugLineNum = 100;BA.debugLine="Dim js1 As JSONParser";
_js1 = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 101;BA.debugLine="js1.Initialize(sc.Decryption(str_val))";
_js1.Initialize(_sc._decryption(_str_val));
 //BA.debugLineNum = 103;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 104;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 105;BA.debugLine="lst=js1.NextArray";
_lst = _js1.NextArray();
 //BA.debugLineNum = 107;BA.debugLine="Dim group_num(10),user_num(10) As Label";
_group_num = new anywheresoftware.b4a.objects.LabelWrapper[(int) (10)];
{
int d0 = _group_num.length;
for (int i0 = 0;i0 < d0;i0++) {
_group_num[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
_user_num = new anywheresoftware.b4a.objects.LabelWrapper[(int) (10)];
{
int d0 = _user_num.length;
for (int i0 = 0;i0 < d0;i0++) {
_user_num[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
 //BA.debugLineNum = 108;BA.debugLine="Dim view_top As Int=0";
_view_top = (int) (0);
 //BA.debugLineNum = 110;BA.debugLine="For i=0 To lst.Size-1";
{
final int step9 = 1;
final int limit9 = (int) (_lst.getSize()-1);
for (_i = (int) (0) ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
 //BA.debugLineNum = 111;BA.debugLine="Dim mp As Map";
_mp = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 112;BA.debugLine="mp.Initialize";
_mp.Initialize();
 //BA.debugLineNum = 113;BA.debugLine="mp=lst.Get(i)";
_mp.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_lst.Get(_i)));
 //BA.debugLineNum = 116;BA.debugLine="group_num(i).Initialize(\"\")";
_group_num[_i].Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 117;BA.debugLine="user_num(i).Initialize(\"\")";
_user_num[_i].Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 120;BA.debugLine="group_num(i).TextColor=Colors.Black";
_group_num[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 121;BA.debugLine="group_num(i).Color=Colors.Green";
_group_num[_i].setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 122;BA.debugLine="group_num(i).TextSize=lbl_group_num.TextSize";
_group_num[_i].setTextSize(mostCurrent._lbl_group_num.getTextSize());
 //BA.debugLineNum = 123;BA.debugLine="group_num(i).Gravity=Gravity.CENTER";
_group_num[_i].setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 125;BA.debugLine="user_num(i).TextColor=Colors.White";
_user_num[_i].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 126;BA.debugLine="user_num(i).Color=Colors.Red";
_user_num[_i].setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 127;BA.debugLine="user_num(i).TextSize=lbl_user_num.TextSize";
_user_num[_i].setTextSize(mostCurrent._lbl_user_num.getTextSize());
 //BA.debugLineNum = 128;BA.debugLine="user_num(i).Gravity=Gravity.CENTER";
_user_num[_i].setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 130;BA.debugLine="group_num(i).Text=mp.Get(\"grp_num\")";
_group_num[_i].setText(BA.ObjectToCharSequence(_mp.Get((Object)("grp_num"))));
 //BA.debugLineNum = 131;BA.debugLine="user_num(i).Text=mp.Get(\"us_num\")";
_user_num[_i].setText(BA.ObjectToCharSequence(_mp.Get((Object)("us_num"))));
 //BA.debugLineNum = 133;BA.debugLine="scr_items.Panel.AddView(group_num(i),lbl_group_n";
mostCurrent._scr_items.getPanel().AddView((android.view.View)(_group_num[_i].getObject()),mostCurrent._lbl_group_num.getLeft(),_view_top,mostCurrent._lbl_group_num.getWidth(),mostCurrent._lbl_group_num.getHeight());
 //BA.debugLineNum = 134;BA.debugLine="scr_items.Panel.AddView(user_num(i),lbl_user_num";
mostCurrent._scr_items.getPanel().AddView((android.view.View)(_user_num[_i].getObject()),mostCurrent._lbl_user_num.getLeft(),_view_top,mostCurrent._lbl_user_num.getWidth(),mostCurrent._lbl_user_num.getHeight());
 //BA.debugLineNum = 135;BA.debugLine="view_top=view_top+group_num(i).Height+3%y";
_view_top = (int) (_view_top+_group_num[_i].getHeight()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private lbl_group_num As Label";
mostCurrent._lbl_group_num = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private lbl_user_num As Label";
mostCurrent._lbl_user_num = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private scr_items As ScrollView";
mostCurrent._scr_items = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
bazbim.app.sec_class_2 _sc = null;
 //BA.debugLineNum = 71;BA.debugLine="Sub JobDone(Job As HttpJob)";
 //BA.debugLineNum = 72;BA.debugLine="Dim sc As sec_Class_2";
_sc = new bazbim.app.sec_class_2();
 //BA.debugLineNum = 74;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 75;BA.debugLine="If Job.Success Then";
if (_job._success) { 
 //BA.debugLineNum = 76;BA.debugLine="If Job.JobName=\"grp_info\" Then";
if ((_job._jobname).equals("grp_info")) { 
 //BA.debugLineNum = 77;BA.debugLine="If Job.GetString=sc.Encryption(\"wrong_info\") Th";
if ((_job._getstring()).equals(_sc._encryption("wrong_info"))) { 
 //BA.debugLineNum = 78;BA.debugLine="config_App.wrong_info";
mostCurrent._config_app._wrong_info(mostCurrent.activityBA);
 }else {
 //BA.debugLineNum = 80;BA.debugLine="analyz_group_info(Job.GetString)";
_analyz_group_info(_job._getstring());
 };
 };
 }else {
 //BA.debugLineNum = 84;BA.debugLine="Msgbox(\"خطایی در ارتباط با مرکز به وجود آمده ؛ ل";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید"),BA.ObjectToCharSequence(""),mostCurrent.activityBA);
 //BA.debugLineNum = 85;BA.debugLine="Activity_KeyPress(KeyCodes.KEYCODE_BACK)";
_activity_keypress(anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK);
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim grp_job As HttpJob";
_grp_job = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
}
