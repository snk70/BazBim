package bazbim.app;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class config_app {
private static config_app mostCurrent = new config_app();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _user_fname = "";
public static String _user_username = "";
public static String _user_password = "";
public static String _user_score = "";
public static String _user_groups = "";
public static int _user_group_num = 0;
public static String _domain_url = "";
public static String _grp_info_url = "";
public static String _person_info_url = "";
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public bazbim.app.main _main = null;
public bazbim.app.log_in_act _log_in_act = null;
public bazbim.app.choose_groups _choose_groups = null;
public bazbim.app.see_groups _see_groups = null;
public bazbim.app.sizeviewv3 _sizeviewv3 = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Dim user_Fname,user_username,user_password,user_S";
_user_fname = "";
_user_username = "";
_user_password = "";
_user_score = "";
_user_groups = "";
 //BA.debugLineNum = 5;BA.debugLine="Dim user_Group_num As Int";
_user_group_num = 0;
 //BA.debugLineNum = 9;BA.debugLine="Dim domain_url As String=\"http://getview.ir\"";
_domain_url = "http://getview.ir";
 //BA.debugLineNum = 10;BA.debugLine="Dim grp_info_url As String=domain_url&\"/\"&\"prv/df";
_grp_info_url = _domain_url+"/"+"prv/dfgdfgsdfg_grp_lgregkergndsfgsdfg/sdfgsdfgsdfg_grp_asfsaf/pujkdthm_grp_dgkewbbger/";
 //BA.debugLineNum = 11;BA.debugLine="Dim person_info_url As String=domain_url&\"/prv/as";
_person_info_url = _domain_url+"/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/Default.aspx";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _wrong_info(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub wrong_info";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
}
