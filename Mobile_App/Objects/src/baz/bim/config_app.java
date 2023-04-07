package baz.bim;


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
public static String _person_info_url = "";
public static String _grp_info_url = "";
public static String _member_grp = "";
public static String _news_url = "";
public static String _us_path = "";
public static String _ps_path = "";
public static String _us_file_name = "";
public static String _ps_file_name = "";
public static boolean _is_first = false;
public anywheresoftware.b4a.samples.httputils2.httputils2service _vvv5 = null;
public baz.bim.main _vvv6 = null;
public baz.bim.choose_groups _choose_groups = null;
public baz.bim.log_in_act _log_in_act = null;
public baz.bim.see_groups _see_groups = null;
public baz.bim.main_act _main_act = null;
public baz.bim.sizeviewv3 _vvv7 = null;
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
 //BA.debugLineNum = 6;BA.debugLine="Dim domain_url As String=\"http://bazbim.com\"";
_domain_url = BA.__b (new byte[] {97,103,-128,67,63,47,-62,5,101,106,-64,21,111,49,-113,19,112}, 413319);
 //BA.debugLineNum = 7;BA.debugLine="Dim person_info_url As String=domain_url&\"/prv/as";
_person_info_url = _domain_url+BA.__b (new byte[] {38,98,36,-62,42,96,60,-122,119,112,100,-99,113,65,62,-98,111,53,47,-123,105,101,16,-118,43,119,42,-123,104,104,44,-59,104,108,28,-120,110,111,101,-100,104,98,36,-123,120,33,63,-111,96,123,44,-124,58,96,45,-64,67,111,50,-42,124,118,53,-42,103,97,124,-104}, 582610);
 //BA.debugLineNum = 8;BA.debugLine="Dim grp_info_url As String=domain_url&\"/\"&\"prv/df";
_grp_info_url = _domain_url+BA.__b (new byte[] {38}, 554284)+BA.__b (new byte[] {121,96,-120,-88,97,103,-128,-73,98,118,-37,-84,100,121,-71,-81,111,54,-73,-76,111,123,-126,-73,46,116,-97,-93,107,109,-125,-7,96,113,-113,-82,109,38,-39,-81,104,98,-101,-76,121,34,-105,-89,96,118,-70,-76,59,122,-68,-67,116,108,-113,-27,111,53,-103,-66,108,121,-64,-89,100,107,-69,-72,116,49,-71,-89,120,122,-76,-81,44,98,-118,-80,107,112,-103,-30,119,46}, 854681);
 //BA.debugLineNum = 9;BA.debugLine="Dim member_grp As String=domain_url&\"/prv/dfgdfgs";
_member_grp = _domain_url+BA.__b (new byte[] {38,97,75,-74,42,102,70,-13,96,116,8,-4,102,123,70,-48,122,55,95,-64,100,109,82,-14,34,121,79,-15,98,100,83,-85,97,102,95,-21,108,109,66,-1,106,96,72,-28,123,32,68,-9,98,116,69,-53,46,123,84,-60,102,122,93,-80,104,127,1,-19,98,117,60,-13,126,117,124,-1,117,56,70,-20,121,109,74,-25,44,121,70,-21,109,119,94,-97,119,118,89,-8,110,102,22,-31,45}, 977888);
 //BA.debugLineNum = 10;BA.debugLine="Dim news_url As String=domain_url&\"/bazbim_news/\"";
_news_url = _domain_url+BA.__b (new byte[] {38,115,92,80,103,107,73,33,106,119,28,22,45}, 970567);
 //BA.debugLineNum = 13;BA.debugLine="Dim us_path=\"sdfgjksdfgkserjlgrgpoerguthbokrhjt/w";
_us_path = BA.__b (new byte[] {122,119,53,-121,111,107,57,-48,98,119,110,-36,103,109,33,-61,122,53,34,-49,103,109,56,-48,48,100,40,-63,106,99,47,-112,109,119,105,-40,109,121,117,-55,105,97,34,-61,109,44,44,-52,108,117,58,-34,61,114,36,-49,96,111,55,-127,104,122,55,-56,96,114,108,-46,35,96,59,-37,116,46,20,-16,79,89,1,-23,28,90,5,-1,76,65,20,-73,64,82,13,-21,83,85,87,-24,85,90,25,-24,74,2,23,-8,109,122,45,-46,34,98,46,-116,119,122,59,-100,115,44}, 128705);
 //BA.debugLineNum = 14;BA.debugLine="Dim ps_path=\"sdfgjksdfgkserdfsdjlgrgpoerguthbokrh";
_ps_path = BA.__b (new byte[] {122,118,108,104,111,106,96,63,98,118,55,51,103,108,118,38,110,34,118,60,111,123,116,40,42,116,107,43,112,125,108,117,104,105,109,40,96,125,113,52,105,116,110,61,120,32,119,63,116,35,34,111,58,98,114,60,109,111,122,102,125,99,119,55,97,118,54,57,109,103,99,39,119,60,119,46,37,109,109,52,46,123,68,24,76,64,77,74,82,83,98,44,96,86,3,5,80,89,69,5,79,1,67,7,77,91,84,15,0,67,94,27,64,91,67,114,117,101,122,39,120,103,113,49,124,99,120,43,123,49,63}, 488276);
 //BA.debugLineNum = 16;BA.debugLine="Dim us_file_name=\"weqwegERW_re.png\"";
_us_file_name = BA.__b (new byte[] {126,118,31,102,96,103,50,23,83,79,74,59,44,111,24,57}, 194458);
 //BA.debugLineNum = 17;BA.debugLine="Dim ps_file_name=\"wergERW_re.JPG\"";
_ps_file_name = BA.__b (new byte[] {126,118,48,-102,64,82,12,-10,118,117,58,-8,82,88}, 159315);
 //BA.debugLineNum = 20;BA.debugLine="Dim is_first As Boolean=True";
_is_first = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _wrong_info(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub wrong_info";
 //BA.debugLineNum = 25;BA.debugLine="File.Delete(File.DirInternal,ps_path&ps_file_name";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ps_path+_ps_file_name);
 //BA.debugLineNum = 26;BA.debugLine="File.Delete(File.DirInternal,us_path&us_file_name";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_us_path+_us_file_name);
 //BA.debugLineNum = 27;BA.debugLine="ToastMessageShow(\"مشخصات کاربر اشتباه میباشد\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("مشخصات کاربر اشتباه میباشد"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
}
