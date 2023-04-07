package bazbim.app;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class sec_class_2 extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "bazbim.app.sec_class_2");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", bazbim.app.sec_class_2.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public int _lng = 0;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public bazbim.app.main _main = null;
public bazbim.app.log_in_act _log_in_act = null;
public bazbim.app.choose_groups _choose_groups = null;
public bazbim.app.see_groups _see_groups = null;
public bazbim.app.config_app _config_app = null;
public bazbim.app.sizeviewv3 _sizeviewv3 = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Dim lng As Int";
_lng = 0;
 //BA.debugLineNum = 3;BA.debugLine="End Sub";
return "";
}
public String  _data_decryption(String _t) throws Exception{
String _txt = "";
String _tx2 = "";
String[] _cdc = null;
int _n = 0;
String _x = "";
int _b = 0;
 //BA.debugLineNum = 314;BA.debugLine="Public Sub data_Decryption( t As String) As String";
 //BA.debugLineNum = 315;BA.debugLine="lng =3";
_lng = (int) (3);
 //BA.debugLineNum = 318;BA.debugLine="Dim txt As String";
_txt = "";
 //BA.debugLineNum = 320;BA.debugLine="Dim tx2 As String";
_tx2 = "";
 //BA.debugLineNum = 321;BA.debugLine="Dim cdc(t.Length) As String";
_cdc = new String[_t.length()];
java.util.Arrays.fill(_cdc,"");
 //BA.debugLineNum = 323;BA.debugLine="txt = t";
_txt = _t;
 //BA.debugLineNum = 325;BA.debugLine="For n = 0 To t.Length / lng - 1";
{
final int step6 = 1;
final int limit6 = (int) (_t.length()/(double)_lng-1);
for (_n = (int) (0) ; (step6 > 0 && _n <= limit6) || (step6 < 0 && _n >= limit6); _n = ((int)(0 + _n + step6)) ) {
 //BA.debugLineNum = 326;BA.debugLine="Dim x As String";
_x = "";
 //BA.debugLineNum = 327;BA.debugLine="x = txt.Substring(txt.Length - lng)";
_x = _txt.substring((int) (_txt.length()-_lng));
 //BA.debugLineNum = 328;BA.debugLine="cdc(n) = sina_DEC(x)";
_cdc[_n] = _sina_dec(_x);
 //BA.debugLineNum = 329;BA.debugLine="txt = txt.SubString2(0, txt.Length - lng)";
_txt = _txt.substring((int) (0),(int) (_txt.length()-_lng));
 }
};
 //BA.debugLineNum = 332;BA.debugLine="For b = 0 To cdc.Length - 1";
{
final int step12 = 1;
final int limit12 = (int) (_cdc.length-1);
for (_b = (int) (0) ; (step12 > 0 && _b <= limit12) || (step12 < 0 && _b >= limit12); _b = ((int)(0 + _b + step12)) ) {
 //BA.debugLineNum = 333;BA.debugLine="tx2 = cdc(b) & tx2";
_tx2 = _cdc[_b]+_tx2;
 }
};
 //BA.debugLineNum = 336;BA.debugLine="Return tx2";
if (true) return _tx2;
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public String  _data_encryption(String _t) throws Exception{
String _txt = "";
String _tx1 = "";
String[] _cec = null;
int _i = 0;
String _x = "";
int _j = 0;
 //BA.debugLineNum = 31;BA.debugLine="Public Sub data_Encryption(t As String) As String";
 //BA.debugLineNum = 33;BA.debugLine="Dim txt As String";
_txt = "";
 //BA.debugLineNum = 35;BA.debugLine="Dim tx1 As String = \"\"";
_tx1 = "";
 //BA.debugLineNum = 36;BA.debugLine="tx1 = \"\"";
_tx1 = "";
 //BA.debugLineNum = 37;BA.debugLine="Dim cec(t.Length) As String";
_cec = new String[_t.length()];
java.util.Arrays.fill(_cec,"");
 //BA.debugLineNum = 38;BA.debugLine="txt = t";
_txt = _t;
 //BA.debugLineNum = 40;BA.debugLine="For i = 0 To t.Length - 1";
{
final int step6 = 1;
final int limit6 = (int) (_t.length()-1);
for (_i = (int) (0) ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
 //BA.debugLineNum = 41;BA.debugLine="Dim x As String";
_x = "";
 //BA.debugLineNum = 42;BA.debugLine="x = txt.Substring(txt.Length - 1)";
_x = _txt.substring((int) (_txt.length()-1));
 //BA.debugLineNum = 43;BA.debugLine="cec(i) = sina_ENC(x)";
_cec[_i] = _sina_enc(_x);
 //BA.debugLineNum = 44;BA.debugLine="txt = txt.SubString2(0, txt.Length - 1)";
_txt = _txt.substring((int) (0),(int) (_txt.length()-1));
 }
};
 //BA.debugLineNum = 46;BA.debugLine="tx1 = \"\"";
_tx1 = "";
 //BA.debugLineNum = 47;BA.debugLine="For j = 0 To cec.Length - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cec.length-1);
for (_j = (int) (0) ; (step13 > 0 && _j <= limit13) || (step13 < 0 && _j >= limit13); _j = ((int)(0 + _j + step13)) ) {
 //BA.debugLineNum = 48;BA.debugLine="tx1 = cec(j) & tx1";
_tx1 = _cec[_j]+_tx1;
 }
};
 //BA.debugLineNum = 53;BA.debugLine="Return tx1";
if (true) return _tx1;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _decryption(String _val) throws Exception{
anywheresoftware.b4a.agraham.encryption.Base64 _bs = null;
 //BA.debugLineNum = 21;BA.debugLine="Sub Decryption(Val As String) As String";
 //BA.debugLineNum = 22;BA.debugLine="Dim bs As Base64";
_bs = new anywheresoftware.b4a.agraham.encryption.Base64();
 //BA.debugLineNum = 23;BA.debugLine="Val=Val.SubString2(Val.Length-3,Val.Length)&Val.S";
_val = _val.substring((int) (_val.length()-3),_val.length())+_val.substring((int) (0),(int) (_val.length()-3));
 //BA.debugLineNum = 24;BA.debugLine="Val=Val.SubString2(Val.Length-3,Val.Length)&Val.S";
_val = _val.substring((int) (_val.length()-3),_val.length())+_val.substring((int) (0),(int) (_val.length()-3));
 //BA.debugLineNum = 25;BA.debugLine="Val=data_Decryption(Val)";
_val = _data_decryption(_val);
 //BA.debugLineNum = 26;BA.debugLine="Val=bs.DecodeStoS(Val,\"UTF-8\")";
_val = _bs.DecodeStoS(_val,"UTF-8");
 //BA.debugLineNum = 27;BA.debugLine="Return Val";
if (true) return _val;
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _encryption(String _val) throws Exception{
anywheresoftware.b4a.agraham.encryption.Base64 _bs = null;
 //BA.debugLineNum = 12;BA.debugLine="Sub Encryption(Val As String) As String";
 //BA.debugLineNum = 13;BA.debugLine="Dim bs As Base64";
_bs = new anywheresoftware.b4a.agraham.encryption.Base64();
 //BA.debugLineNum = 14;BA.debugLine="Val=bs.EncodeStoS(Val,\"UTF-8\")";
_val = _bs.EncodeStoS(_val,"UTF-8");
 //BA.debugLineNum = 15;BA.debugLine="Val=data_Encryption(Val)";
_val = _data_encryption(_val);
 //BA.debugLineNum = 16;BA.debugLine="Val=Val.SubString2(3,Val.Length)&Val.SubString2(0";
_val = _val.substring((int) (3),_val.length())+_val.substring((int) (0),(int) (3));
 //BA.debugLineNum = 17;BA.debugLine="Val=Val.SubString2(3,Val.Length)&Val.SubString2(0";
_val = _val.substring((int) (3),_val.length())+_val.substring((int) (0),(int) (3));
 //BA.debugLineNum = 18;BA.debugLine="Return Val";
if (true) return _val;
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _sina_dec(String _v) throws Exception{
 //BA.debugLineNum = 340;BA.debugLine="Public Sub sina_DEC(v As String) As String";
 //BA.debugLineNum = 341;BA.debugLine="If v=\"dsG\" Then";
if ((_v).equals("dsG")) { 
 //BA.debugLineNum = 342;BA.debugLine="Return \"0\"";
if (true) return "0";
 }else if((_v).equals("tqY")) { 
 //BA.debugLineNum = 344;BA.debugLine="Return \"1\"";
if (true) return "1";
 }else if((_v).equals("b8n")) { 
 //BA.debugLineNum = 346;BA.debugLine="Return \"2\"";
if (true) return "2";
 }else if((_v).equals("kmT")) { 
 //BA.debugLineNum = 348;BA.debugLine="Return \"3\"";
if (true) return "3";
 }else if((_v).equals("CV8")) { 
 //BA.debugLineNum = 350;BA.debugLine="Return \"4\"";
if (true) return "4";
 }else if((_v).equals("2pM")) { 
 //BA.debugLineNum = 352;BA.debugLine="Return \"5\"";
if (true) return "5";
 }else if((_v).equals("nAv")) { 
 //BA.debugLineNum = 354;BA.debugLine="Return \"7\"";
if (true) return "7";
 }else if((_v).equals("GAH")) { 
 //BA.debugLineNum = 356;BA.debugLine="Return \"8\"";
if (true) return "8";
 }else if((_v).equals("PJS")) { 
 //BA.debugLineNum = 358;BA.debugLine="Return \"9\"";
if (true) return "9";
 }else if((_v).equals("xNM")) { 
 //BA.debugLineNum = 360;BA.debugLine="Return \"a\"";
if (true) return "a";
 }else if((_v).equals("3v6")) { 
 //BA.debugLineNum = 362;BA.debugLine="Return \"b\"";
if (true) return "b";
 }else if((_v).equals("NFt")) { 
 //BA.debugLineNum = 364;BA.debugLine="Return \"c\"";
if (true) return "c";
 }else if((_v).equals("wmp")) { 
 //BA.debugLineNum = 366;BA.debugLine="Return \"d\"";
if (true) return "d";
 }else if((_v).equals("iMH")) { 
 //BA.debugLineNum = 368;BA.debugLine="Return \"e\"";
if (true) return "e";
 }else if((_v).equals("ECu")) { 
 //BA.debugLineNum = 370;BA.debugLine="Return \"f\"";
if (true) return "f";
 }else if((_v).equals("T63")) { 
 //BA.debugLineNum = 372;BA.debugLine="Return \"g\"";
if (true) return "g";
 }else if((_v).equals("p21")) { 
 //BA.debugLineNum = 374;BA.debugLine="Return \"h\"";
if (true) return "h";
 }else if((_v).equals("tGw")) { 
 //BA.debugLineNum = 376;BA.debugLine="Return \"i\"";
if (true) return "i";
 }else if((_v).equals("9OK")) { 
 //BA.debugLineNum = 378;BA.debugLine="Return \"j\"";
if (true) return "j";
 }else if((_v).equals("pvg")) { 
 //BA.debugLineNum = 380;BA.debugLine="Return \"k\"";
if (true) return "k";
 }else if((_v).equals("5Ms")) { 
 //BA.debugLineNum = 382;BA.debugLine="Return \"l\"";
if (true) return "l";
 }else if((_v).equals("bz6")) { 
 //BA.debugLineNum = 384;BA.debugLine="Return \"m\"";
if (true) return "m";
 }else if((_v).equals("04w")) { 
 //BA.debugLineNum = 386;BA.debugLine="Return \"n\"";
if (true) return "n";
 }else if((_v).equals("jSp")) { 
 //BA.debugLineNum = 388;BA.debugLine="Return \"o\"";
if (true) return "o";
 }else if((_v).equals("rpQ")) { 
 //BA.debugLineNum = 390;BA.debugLine="Return \"p\"";
if (true) return "p";
 }else if((_v).equals("DTd")) { 
 //BA.debugLineNum = 392;BA.debugLine="Return \"q\"";
if (true) return "q";
 }else if((_v).equals("OAY")) { 
 //BA.debugLineNum = 394;BA.debugLine="Return \"r\"";
if (true) return "r";
 }else if((_v).equals("0bm")) { 
 //BA.debugLineNum = 396;BA.debugLine="Return \"s\"";
if (true) return "s";
 }else if((_v).equals("mMM")) { 
 //BA.debugLineNum = 398;BA.debugLine="Return \"t\"";
if (true) return "t";
 }else if((_v).equals("wJo")) { 
 //BA.debugLineNum = 400;BA.debugLine="Return \"u\"";
if (true) return "u";
 }else if((_v).equals("1Xx")) { 
 //BA.debugLineNum = 402;BA.debugLine="Return \"v\"";
if (true) return "v";
 }else if((_v).equals("9Bv")) { 
 //BA.debugLineNum = 404;BA.debugLine="Return \"w\"";
if (true) return "w";
 }else if((_v).equals("pG3")) { 
 //BA.debugLineNum = 406;BA.debugLine="Return \"x\"";
if (true) return "x";
 }else if((_v).equals("Dv2")) { 
 //BA.debugLineNum = 408;BA.debugLine="Return \"y\"";
if (true) return "y";
 }else if((_v).equals("yCu")) { 
 //BA.debugLineNum = 410;BA.debugLine="Return \"z\"";
if (true) return "z";
 }else if((_v).equals("zw1")) { 
 //BA.debugLineNum = 412;BA.debugLine="Return \"A\"";
if (true) return "A";
 }else if((_v).equals("Hnx")) { 
 //BA.debugLineNum = 414;BA.debugLine="Return \"B\"";
if (true) return "B";
 }else if((_v).equals("4iw")) { 
 //BA.debugLineNum = 416;BA.debugLine="Return \"C\"";
if (true) return "C";
 }else if((_v).equals("01G")) { 
 //BA.debugLineNum = 418;BA.debugLine="Return \"D\"";
if (true) return "D";
 }else if((_v).equals("lPE")) { 
 //BA.debugLineNum = 420;BA.debugLine="Return \"E\"";
if (true) return "E";
 }else if((_v).equals("3I3")) { 
 //BA.debugLineNum = 422;BA.debugLine="Return \"F\"";
if (true) return "F";
 }else if((_v).equals("5mu")) { 
 //BA.debugLineNum = 424;BA.debugLine="Return \"G\"";
if (true) return "G";
 }else if((_v).equals("JAw")) { 
 //BA.debugLineNum = 426;BA.debugLine="Return \"H\"";
if (true) return "H";
 }else if((_v).equals("fMe")) { 
 //BA.debugLineNum = 428;BA.debugLine="Return \"I\"";
if (true) return "I";
 }else if((_v).equals("VHF")) { 
 //BA.debugLineNum = 430;BA.debugLine="Return \"J\"";
if (true) return "J";
 }else if((_v).equals("2Y9")) { 
 //BA.debugLineNum = 432;BA.debugLine="Return \"K\"";
if (true) return "K";
 }else if((_v).equals("9nX")) { 
 //BA.debugLineNum = 434;BA.debugLine="Return \"L\"";
if (true) return "L";
 }else if((_v).equals("OoP")) { 
 //BA.debugLineNum = 436;BA.debugLine="Return \"M\"";
if (true) return "M";
 }else if((_v).equals("Wgv")) { 
 //BA.debugLineNum = 438;BA.debugLine="Return \"N\"";
if (true) return "N";
 }else if((_v).equals("sHJ")) { 
 //BA.debugLineNum = 440;BA.debugLine="Return \"O\"";
if (true) return "O";
 }else if((_v).equals("RGL")) { 
 //BA.debugLineNum = 442;BA.debugLine="Return \"P\"";
if (true) return "P";
 }else if((_v).equals("KCr")) { 
 //BA.debugLineNum = 444;BA.debugLine="Return \"Q\"";
if (true) return "Q";
 }else if((_v).equals("MaH")) { 
 //BA.debugLineNum = 446;BA.debugLine="Return \"R\"";
if (true) return "R";
 }else if((_v).equals("9S9")) { 
 //BA.debugLineNum = 448;BA.debugLine="Return \"S\"";
if (true) return "S";
 }else if((_v).equals("zWa")) { 
 //BA.debugLineNum = 450;BA.debugLine="Return \"T\"";
if (true) return "T";
 }else if((_v).equals("oS0")) { 
 //BA.debugLineNum = 452;BA.debugLine="Return \"U\"";
if (true) return "U";
 }else if((_v).equals("KMV")) { 
 //BA.debugLineNum = 454;BA.debugLine="Return \"V\"";
if (true) return "V";
 }else if((_v).equals("gn2")) { 
 //BA.debugLineNum = 456;BA.debugLine="Return \"W\"";
if (true) return "W";
 }else if((_v).equals("WkS")) { 
 //BA.debugLineNum = 458;BA.debugLine="Return \"X\"";
if (true) return "X";
 }else if((_v).equals("dEl")) { 
 //BA.debugLineNum = 460;BA.debugLine="Return \"Y\"";
if (true) return "Y";
 }else if((_v).equals("UJN")) { 
 //BA.debugLineNum = 462;BA.debugLine="Return \"Z\"";
if (true) return "Z";
 }else if((_v).equals("Fcy")) { 
 //BA.debugLineNum = 464;BA.debugLine="Return \"~\"";
if (true) return "~";
 }else if((_v).equals("5qg")) { 
 //BA.debugLineNum = 466;BA.debugLine="Return \"`\"";
if (true) return "`";
 }else if((_v).equals("w0V")) { 
 //BA.debugLineNum = 468;BA.debugLine="Return \"!\"";
if (true) return "!";
 }else if((_v).equals("FqJ")) { 
 //BA.debugLineNum = 470;BA.debugLine="Return \"#\"";
if (true) return "#";
 }else if((_v).equals("FtV")) { 
 //BA.debugLineNum = 472;BA.debugLine="Return \"$\"";
if (true) return "$";
 }else if((_v).equals("7tF")) { 
 //BA.debugLineNum = 474;BA.debugLine="Return \"%\"";
if (true) return "%";
 }else if((_v).equals("6MR")) { 
 //BA.debugLineNum = 476;BA.debugLine="Return \"^\"";
if (true) return "^";
 }else if((_v).equals("BDM")) { 
 //BA.debugLineNum = 478;BA.debugLine="Return \"&\"";
if (true) return "&";
 }else if((_v).equals("3mD")) { 
 //BA.debugLineNum = 480;BA.debugLine="Return \"*\"";
if (true) return "*";
 }else if((_v).equals("eRR")) { 
 //BA.debugLineNum = 482;BA.debugLine="Return \"(\"";
if (true) return "(";
 }else if((_v).equals("7xG")) { 
 //BA.debugLineNum = 484;BA.debugLine="Return \")\"";
if (true) return ")";
 }else if((_v).equals("oTF")) { 
 //BA.debugLineNum = 486;BA.debugLine="Return \"_\"";
if (true) return "_";
 }else if((_v).equals("UnP")) { 
 //BA.debugLineNum = 488;BA.debugLine="Return \"-\"";
if (true) return "-";
 }else if((_v).equals("Mpv")) { 
 //BA.debugLineNum = 490;BA.debugLine="Return \"=\"";
if (true) return "=";
 }else if((_v).equals("vJ2")) { 
 //BA.debugLineNum = 492;BA.debugLine="Return \"+\"";
if (true) return "+";
 }else if((_v).equals("xlS")) { 
 //BA.debugLineNum = 494;BA.debugLine="Return \"/\"";
if (true) return "/";
 }else if((_v).equals("dhT")) { 
 //BA.debugLineNum = 496;BA.debugLine="Return \"?\"";
if (true) return "?";
 }else if((_v).equals("MbI")) { 
 //BA.debugLineNum = 498;BA.debugLine="Return \"<\"";
if (true) return "<";
 }else if((_v).equals("B5h")) { 
 //BA.debugLineNum = 500;BA.debugLine="Return \">\"";
if (true) return ">";
 }else if((_v).equals("MJq")) { 
 //BA.debugLineNum = 502;BA.debugLine="Return \".\"";
if (true) return ".";
 }else if((_v).equals("75Y")) { 
 //BA.debugLineNum = 504;BA.debugLine="Return \"{\"";
if (true) return "{";
 }else if((_v).equals("MlQ")) { 
 //BA.debugLineNum = 506;BA.debugLine="Return \"}\"";
if (true) return "}";
 }else if((_v).equals("Pr0")) { 
 //BA.debugLineNum = 508;BA.debugLine="Return \"[\"";
if (true) return "[";
 }else if((_v).equals("Oyh")) { 
 //BA.debugLineNum = 510;BA.debugLine="Return \"]\"";
if (true) return "]";
 }else if((_v).equals("EMH")) { 
 //BA.debugLineNum = 512;BA.debugLine="Return \",\"";
if (true) return ",";
 }else if((_v).equals("6mX")) { 
 //BA.debugLineNum = 514;BA.debugLine="Return \"ا\"";
if (true) return "ا";
 }else if((_v).equals("E1P")) { 
 //BA.debugLineNum = 516;BA.debugLine="Return \"آ\"";
if (true) return "آ";
 }else if((_v).equals("7Wp")) { 
 //BA.debugLineNum = 518;BA.debugLine="Return \"ب\"";
if (true) return "ب";
 }else if((_v).equals("iXb")) { 
 //BA.debugLineNum = 520;BA.debugLine="Return \"پ\"";
if (true) return "پ";
 }else if((_v).equals("lE4")) { 
 //BA.debugLineNum = 522;BA.debugLine="Return \"ت\"";
if (true) return "ت";
 }else if((_v).equals("qer")) { 
 //BA.debugLineNum = 524;BA.debugLine="Return \"س\"";
if (true) return "س";
 }else if((_v).equals("9eX")) { 
 //BA.debugLineNum = 526;BA.debugLine="Return \"ج\"";
if (true) return "ج";
 }else if((_v).equals("NwT")) { 
 //BA.debugLineNum = 528;BA.debugLine="Return \"چ\"";
if (true) return "چ";
 }else if((_v).equals("0j4")) { 
 //BA.debugLineNum = 530;BA.debugLine="Return \"ح\"";
if (true) return "ح";
 }else if((_v).equals("7gy")) { 
 //BA.debugLineNum = 532;BA.debugLine="Return \"خ\"";
if (true) return "خ";
 }else if((_v).equals("v9w")) { 
 //BA.debugLineNum = 534;BA.debugLine="Return \"د\"";
if (true) return "د";
 }else if((_v).equals("1fb")) { 
 //BA.debugLineNum = 536;BA.debugLine="Return \"ذ\"";
if (true) return "ذ";
 }else if((_v).equals("mOo")) { 
 //BA.debugLineNum = 538;BA.debugLine="Return \"ر\"";
if (true) return "ر";
 }else if((_v).equals("HQF")) { 
 //BA.debugLineNum = 540;BA.debugLine="Return \"ز\"";
if (true) return "ز";
 }else if((_v).equals("TDy")) { 
 //BA.debugLineNum = 542;BA.debugLine="Return \"ژ\"";
if (true) return "ژ";
 }else if((_v).equals("2MR")) { 
 //BA.debugLineNum = 544;BA.debugLine="Return \"س\"";
if (true) return "س";
 }else if((_v).equals("1qJ")) { 
 //BA.debugLineNum = 546;BA.debugLine="Return \"ش\"";
if (true) return "ش";
 }else if((_v).equals("Sqk")) { 
 //BA.debugLineNum = 548;BA.debugLine="Return \"ص\"";
if (true) return "ص";
 }else if((_v).equals("5kl")) { 
 //BA.debugLineNum = 550;BA.debugLine="Return \"ض\"";
if (true) return "ض";
 }else if((_v).equals("Hxi")) { 
 //BA.debugLineNum = 552;BA.debugLine="Return \"ط\"";
if (true) return "ط";
 }else if((_v).equals("27E")) { 
 //BA.debugLineNum = 554;BA.debugLine="Return \"ظ\"";
if (true) return "ظ";
 }else if((_v).equals("7Tg")) { 
 //BA.debugLineNum = 556;BA.debugLine="Return \"ع\"";
if (true) return "ع";
 }else if((_v).equals("DjO")) { 
 //BA.debugLineNum = 558;BA.debugLine="Return \"غ\"";
if (true) return "غ";
 }else if((_v).equals("G8G")) { 
 //BA.debugLineNum = 560;BA.debugLine="Return \"ف\"";
if (true) return "ف";
 }else if((_v).equals("hVQ")) { 
 //BA.debugLineNum = 562;BA.debugLine="Return \"ق\"";
if (true) return "ق";
 }else if((_v).equals("vcW")) { 
 //BA.debugLineNum = 564;BA.debugLine="Return \"ک\"";
if (true) return "ک";
 }else if((_v).equals("ujS")) { 
 //BA.debugLineNum = 566;BA.debugLine="Return \"گ\"";
if (true) return "گ";
 }else if((_v).equals("vp2")) { 
 //BA.debugLineNum = 568;BA.debugLine="Return \"ل\"";
if (true) return "ل";
 }else if((_v).equals("kEl")) { 
 //BA.debugLineNum = 570;BA.debugLine="Return \"م\"";
if (true) return "م";
 }else if((_v).equals("7Ts")) { 
 //BA.debugLineNum = 572;BA.debugLine="Return \"ن\"";
if (true) return "ن";
 }else if((_v).equals("9zk")) { 
 //BA.debugLineNum = 574;BA.debugLine="Return \"و\"";
if (true) return "و";
 }else if((_v).equals("AQn")) { 
 //BA.debugLineNum = 576;BA.debugLine="Return \"ه\"";
if (true) return "ه";
 }else if((_v).equals("DBX")) { 
 //BA.debugLineNum = 578;BA.debugLine="Return \"ی\"";
if (true) return "ی";
 }else if((_v).equals("GGo")) { 
 //BA.debugLineNum = 580;BA.debugLine="Return \"ء\"";
if (true) return "ء";
 }else if((_v).equals("aIt")) { 
 //BA.debugLineNum = 582;BA.debugLine="Return \"ئ\"";
if (true) return "ئ";
 }else {
 //BA.debugLineNum = 584;BA.debugLine="Return v.Substring(v.Length - 1)";
if (true) return _v.substring((int) (_v.length()-1));
 };
 //BA.debugLineNum = 587;BA.debugLine="End Sub";
return "";
}
public String  _sina_enc(String _v) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Public Sub sina_ENC(v As String) As String";
 //BA.debugLineNum = 60;BA.debugLine="If v=\"0\" Then";
if ((_v).equals("0")) { 
 //BA.debugLineNum = 61;BA.debugLine="Return \"dsG\"";
if (true) return "dsG";
 }else if((_v).equals("1")) { 
 //BA.debugLineNum = 63;BA.debugLine="Return \"tqY\"";
if (true) return "tqY";
 }else if((_v).equals("2")) { 
 //BA.debugLineNum = 65;BA.debugLine="Return \"b8n\"";
if (true) return "b8n";
 }else if((_v).equals("3")) { 
 //BA.debugLineNum = 67;BA.debugLine="Return \"kmT\"";
if (true) return "kmT";
 }else if((_v).equals("4")) { 
 //BA.debugLineNum = 69;BA.debugLine="Return \"CV8\"";
if (true) return "CV8";
 }else if((_v).equals("5")) { 
 //BA.debugLineNum = 71;BA.debugLine="Return \"2pM\"";
if (true) return "2pM";
 }else if((_v).equals("7")) { 
 //BA.debugLineNum = 73;BA.debugLine="Return \"nAv\"";
if (true) return "nAv";
 }else if((_v).equals("8")) { 
 //BA.debugLineNum = 75;BA.debugLine="Return \"GAH\"";
if (true) return "GAH";
 }else if((_v).equals("9")) { 
 //BA.debugLineNum = 77;BA.debugLine="Return \"PJS\"";
if (true) return "PJS";
 }else if((_v).equals("a")) { 
 //BA.debugLineNum = 79;BA.debugLine="Return \"xNM\"";
if (true) return "xNM";
 }else if((_v).equals("b")) { 
 //BA.debugLineNum = 81;BA.debugLine="Return \"3v6\"";
if (true) return "3v6";
 }else if((_v).equals("c")) { 
 //BA.debugLineNum = 83;BA.debugLine="Return \"NFt\"";
if (true) return "NFt";
 }else if((_v).equals("d")) { 
 //BA.debugLineNum = 85;BA.debugLine="Return \"wmp\"";
if (true) return "wmp";
 }else if((_v).equals("e")) { 
 //BA.debugLineNum = 87;BA.debugLine="Return \"iMH\"";
if (true) return "iMH";
 }else if((_v).equals("f")) { 
 //BA.debugLineNum = 89;BA.debugLine="Return \"ECu\"";
if (true) return "ECu";
 }else if((_v).equals("g")) { 
 //BA.debugLineNum = 91;BA.debugLine="Return \"T63\"";
if (true) return "T63";
 }else if((_v).equals("h")) { 
 //BA.debugLineNum = 93;BA.debugLine="Return \"p21\"";
if (true) return "p21";
 }else if((_v).equals("i")) { 
 //BA.debugLineNum = 95;BA.debugLine="Return \"tGw\"";
if (true) return "tGw";
 }else if((_v).equals("j")) { 
 //BA.debugLineNum = 97;BA.debugLine="Return \"9OK\"";
if (true) return "9OK";
 }else if((_v).equals("k")) { 
 //BA.debugLineNum = 99;BA.debugLine="Return \"pvg\"";
if (true) return "pvg";
 }else if((_v).equals("l")) { 
 //BA.debugLineNum = 101;BA.debugLine="Return \"5Ms\"";
if (true) return "5Ms";
 }else if((_v).equals("m")) { 
 //BA.debugLineNum = 103;BA.debugLine="Return \"bz6\"";
if (true) return "bz6";
 }else if((_v).equals("n")) { 
 //BA.debugLineNum = 105;BA.debugLine="Return \"04w\"";
if (true) return "04w";
 }else if((_v).equals("o")) { 
 //BA.debugLineNum = 107;BA.debugLine="Return \"jSp\"";
if (true) return "jSp";
 }else if((_v).equals("p")) { 
 //BA.debugLineNum = 109;BA.debugLine="Return \"rpQ\"";
if (true) return "rpQ";
 }else if((_v).equals("q")) { 
 //BA.debugLineNum = 111;BA.debugLine="Return \"DTd\"";
if (true) return "DTd";
 }else if((_v).equals("r")) { 
 //BA.debugLineNum = 113;BA.debugLine="Return \"OAY\"";
if (true) return "OAY";
 }else if((_v).equals("s")) { 
 //BA.debugLineNum = 115;BA.debugLine="Return \"0bm\"";
if (true) return "0bm";
 }else if((_v).equals("t")) { 
 //BA.debugLineNum = 117;BA.debugLine="Return \"mMM\"";
if (true) return "mMM";
 }else if((_v).equals("u")) { 
 //BA.debugLineNum = 119;BA.debugLine="Return \"wJo\"";
if (true) return "wJo";
 }else if((_v).equals("v")) { 
 //BA.debugLineNum = 121;BA.debugLine="Return \"1Xx\"";
if (true) return "1Xx";
 }else if((_v).equals("w")) { 
 //BA.debugLineNum = 123;BA.debugLine="Return \"9Bv\"";
if (true) return "9Bv";
 }else if((_v).equals("x")) { 
 //BA.debugLineNum = 125;BA.debugLine="Return \"pG3\"";
if (true) return "pG3";
 }else if((_v).equals("y")) { 
 //BA.debugLineNum = 127;BA.debugLine="Return \"Dv2\"";
if (true) return "Dv2";
 }else if((_v).equals("z")) { 
 //BA.debugLineNum = 129;BA.debugLine="Return \"yCu\"";
if (true) return "yCu";
 }else if((_v).equals("A")) { 
 //BA.debugLineNum = 131;BA.debugLine="Return \"zw1\"";
if (true) return "zw1";
 }else if((_v).equals("B")) { 
 //BA.debugLineNum = 133;BA.debugLine="Return \"Hnx\"";
if (true) return "Hnx";
 }else if((_v).equals("C")) { 
 //BA.debugLineNum = 135;BA.debugLine="Return \"4iw\"";
if (true) return "4iw";
 }else if((_v).equals("D")) { 
 //BA.debugLineNum = 137;BA.debugLine="Return \"01G\"";
if (true) return "01G";
 }else if((_v).equals("E")) { 
 //BA.debugLineNum = 139;BA.debugLine="Return \"lPE\"";
if (true) return "lPE";
 }else if((_v).equals("F")) { 
 //BA.debugLineNum = 141;BA.debugLine="Return \"3I3\"";
if (true) return "3I3";
 }else if((_v).equals("G")) { 
 //BA.debugLineNum = 143;BA.debugLine="Return \"5mu\"";
if (true) return "5mu";
 }else if((_v).equals("H")) { 
 //BA.debugLineNum = 145;BA.debugLine="Return \"JAw\"";
if (true) return "JAw";
 }else if((_v).equals("I")) { 
 //BA.debugLineNum = 147;BA.debugLine="Return \"fMe\"";
if (true) return "fMe";
 }else if((_v).equals("J")) { 
 //BA.debugLineNum = 149;BA.debugLine="Return \"VHF\"";
if (true) return "VHF";
 }else if((_v).equals("K")) { 
 //BA.debugLineNum = 151;BA.debugLine="Return \"2Y9\"";
if (true) return "2Y9";
 }else if((_v).equals("L")) { 
 //BA.debugLineNum = 153;BA.debugLine="Return \"9nX\"";
if (true) return "9nX";
 }else if((_v).equals("M")) { 
 //BA.debugLineNum = 155;BA.debugLine="Return \"OoP\"";
if (true) return "OoP";
 }else if((_v).equals("N")) { 
 //BA.debugLineNum = 157;BA.debugLine="Return \"Wgv\"";
if (true) return "Wgv";
 }else if((_v).equals("O")) { 
 //BA.debugLineNum = 159;BA.debugLine="Return \"sHJ\"";
if (true) return "sHJ";
 }else if((_v).equals("P")) { 
 //BA.debugLineNum = 161;BA.debugLine="Return \"RGL\"";
if (true) return "RGL";
 }else if((_v).equals("Q")) { 
 //BA.debugLineNum = 163;BA.debugLine="Return \"KCr\"";
if (true) return "KCr";
 }else if((_v).equals("R")) { 
 //BA.debugLineNum = 165;BA.debugLine="Return \"MaH\"";
if (true) return "MaH";
 }else if((_v).equals("S")) { 
 //BA.debugLineNum = 167;BA.debugLine="Return \"9S9\"";
if (true) return "9S9";
 }else if((_v).equals("T")) { 
 //BA.debugLineNum = 169;BA.debugLine="Return \"zWa\"";
if (true) return "zWa";
 }else if((_v).equals("U")) { 
 //BA.debugLineNum = 171;BA.debugLine="Return \"oS0\"";
if (true) return "oS0";
 }else if((_v).equals("V")) { 
 //BA.debugLineNum = 173;BA.debugLine="Return \"KMV\"";
if (true) return "KMV";
 }else if((_v).equals("W")) { 
 //BA.debugLineNum = 175;BA.debugLine="Return \"gn2\"";
if (true) return "gn2";
 }else if((_v).equals("X")) { 
 //BA.debugLineNum = 177;BA.debugLine="Return \"WkS\"";
if (true) return "WkS";
 }else if((_v).equals("Y")) { 
 //BA.debugLineNum = 179;BA.debugLine="Return \"dEl\"";
if (true) return "dEl";
 }else if((_v).equals("Z")) { 
 //BA.debugLineNum = 181;BA.debugLine="Return \"UJN\"";
if (true) return "UJN";
 }else if((_v).equals("~")) { 
 //BA.debugLineNum = 183;BA.debugLine="Return \"Fcy\"";
if (true) return "Fcy";
 }else if((_v).equals("`")) { 
 //BA.debugLineNum = 185;BA.debugLine="Return \"5qg\"";
if (true) return "5qg";
 }else if((_v).equals("!")) { 
 //BA.debugLineNum = 187;BA.debugLine="Return \"w0V\"";
if (true) return "w0V";
 }else if((_v).equals("#")) { 
 //BA.debugLineNum = 189;BA.debugLine="Return \"FqJ\"";
if (true) return "FqJ";
 }else if((_v).equals("$")) { 
 //BA.debugLineNum = 191;BA.debugLine="Return \"FtV\"";
if (true) return "FtV";
 }else if((_v).equals("%")) { 
 //BA.debugLineNum = 193;BA.debugLine="Return \"7tF\"";
if (true) return "7tF";
 }else if((_v).equals("^")) { 
 //BA.debugLineNum = 195;BA.debugLine="Return \"6MR\"";
if (true) return "6MR";
 }else if((_v).equals("&")) { 
 //BA.debugLineNum = 197;BA.debugLine="Return \"BDM\"";
if (true) return "BDM";
 }else if((_v).equals("*")) { 
 //BA.debugLineNum = 199;BA.debugLine="Return \"3mD\"";
if (true) return "3mD";
 }else if((_v).equals("(")) { 
 //BA.debugLineNum = 201;BA.debugLine="Return \"eRR\"";
if (true) return "eRR";
 }else if((_v).equals(")")) { 
 //BA.debugLineNum = 203;BA.debugLine="Return \"7xG\"";
if (true) return "7xG";
 }else if((_v).equals("_")) { 
 //BA.debugLineNum = 205;BA.debugLine="Return \"oTF\"";
if (true) return "oTF";
 }else if((_v).equals("-")) { 
 //BA.debugLineNum = 207;BA.debugLine="Return \"UnP\"";
if (true) return "UnP";
 }else if((_v).equals("=")) { 
 //BA.debugLineNum = 209;BA.debugLine="Return \"Mpv\"";
if (true) return "Mpv";
 }else if((_v).equals("+")) { 
 //BA.debugLineNum = 211;BA.debugLine="Return \"vJ2\"";
if (true) return "vJ2";
 }else if((_v).equals("/")) { 
 //BA.debugLineNum = 213;BA.debugLine="Return \"xlS\"";
if (true) return "xlS";
 }else if((_v).equals("?")) { 
 //BA.debugLineNum = 215;BA.debugLine="Return \"dhT\"";
if (true) return "dhT";
 }else if((_v).equals("<")) { 
 //BA.debugLineNum = 217;BA.debugLine="Return \"MbI\"";
if (true) return "MbI";
 }else if((_v).equals(">")) { 
 //BA.debugLineNum = 219;BA.debugLine="Return \"B5h\"";
if (true) return "B5h";
 }else if((_v).equals(".")) { 
 //BA.debugLineNum = 221;BA.debugLine="Return \"MJq\"";
if (true) return "MJq";
 }else if((_v).equals("{")) { 
 //BA.debugLineNum = 223;BA.debugLine="Return \"75Y\"";
if (true) return "75Y";
 }else if((_v).equals("}")) { 
 //BA.debugLineNum = 225;BA.debugLine="Return \"MlQ\"";
if (true) return "MlQ";
 }else if((_v).equals("[")) { 
 //BA.debugLineNum = 227;BA.debugLine="Return \"Pr0\"";
if (true) return "Pr0";
 }else if((_v).equals("]")) { 
 //BA.debugLineNum = 229;BA.debugLine="Return \"Oyh\"";
if (true) return "Oyh";
 }else if((_v).equals(",")) { 
 //BA.debugLineNum = 231;BA.debugLine="Return \"EMH\"";
if (true) return "EMH";
 }else if((_v).equals("ا")) { 
 //BA.debugLineNum = 233;BA.debugLine="Return \"6mX\"";
if (true) return "6mX";
 }else if((_v).equals("آ")) { 
 //BA.debugLineNum = 235;BA.debugLine="Return \"E1P\"";
if (true) return "E1P";
 }else if((_v).equals("ب")) { 
 //BA.debugLineNum = 237;BA.debugLine="Return \"7Wp\"";
if (true) return "7Wp";
 }else if((_v).equals("پ")) { 
 //BA.debugLineNum = 239;BA.debugLine="Return \"iXb\"";
if (true) return "iXb";
 }else if((_v).equals("ت")) { 
 //BA.debugLineNum = 241;BA.debugLine="Return \"lE4\"";
if (true) return "lE4";
 }else if((_v).equals("س")) { 
 //BA.debugLineNum = 243;BA.debugLine="Return \"qer\"";
if (true) return "qer";
 }else if((_v).equals("ج")) { 
 //BA.debugLineNum = 245;BA.debugLine="Return \"9eX\"";
if (true) return "9eX";
 }else if((_v).equals("چ")) { 
 //BA.debugLineNum = 247;BA.debugLine="Return \"NwT\"";
if (true) return "NwT";
 }else if((_v).equals("ح")) { 
 //BA.debugLineNum = 249;BA.debugLine="Return \"0j4\"";
if (true) return "0j4";
 }else if((_v).equals("خ")) { 
 //BA.debugLineNum = 251;BA.debugLine="Return \"7gy\"";
if (true) return "7gy";
 }else if((_v).equals("د")) { 
 //BA.debugLineNum = 253;BA.debugLine="Return \"v9w\"";
if (true) return "v9w";
 }else if((_v).equals("ذ")) { 
 //BA.debugLineNum = 255;BA.debugLine="Return \"1fb\"";
if (true) return "1fb";
 }else if((_v).equals("ر")) { 
 //BA.debugLineNum = 257;BA.debugLine="Return \"mOo\"";
if (true) return "mOo";
 }else if((_v).equals("ز")) { 
 //BA.debugLineNum = 259;BA.debugLine="Return \"HQF\"";
if (true) return "HQF";
 }else if((_v).equals("ژ")) { 
 //BA.debugLineNum = 261;BA.debugLine="Return \"TDy\"";
if (true) return "TDy";
 }else if((_v).equals("س")) { 
 //BA.debugLineNum = 263;BA.debugLine="Return \"2MR\"";
if (true) return "2MR";
 }else if((_v).equals("ش")) { 
 //BA.debugLineNum = 265;BA.debugLine="Return \"1qJ\"";
if (true) return "1qJ";
 }else if((_v).equals("ص")) { 
 //BA.debugLineNum = 267;BA.debugLine="Return \"Sqk\"";
if (true) return "Sqk";
 }else if((_v).equals("ض")) { 
 //BA.debugLineNum = 269;BA.debugLine="Return \"5kl\"";
if (true) return "5kl";
 }else if((_v).equals("ط")) { 
 //BA.debugLineNum = 271;BA.debugLine="Return \"Hxi\"";
if (true) return "Hxi";
 }else if((_v).equals("ظ")) { 
 //BA.debugLineNum = 273;BA.debugLine="Return \"27E\"";
if (true) return "27E";
 }else if((_v).equals("ع")) { 
 //BA.debugLineNum = 275;BA.debugLine="Return \"7Tg\"";
if (true) return "7Tg";
 }else if((_v).equals("غ")) { 
 //BA.debugLineNum = 277;BA.debugLine="Return \"DjO\"";
if (true) return "DjO";
 }else if((_v).equals("ف")) { 
 //BA.debugLineNum = 279;BA.debugLine="Return \"G8G\"";
if (true) return "G8G";
 }else if((_v).equals("ق")) { 
 //BA.debugLineNum = 281;BA.debugLine="Return \"hVQ\"";
if (true) return "hVQ";
 }else if((_v).equals("ک")) { 
 //BA.debugLineNum = 283;BA.debugLine="Return \"vcW\"";
if (true) return "vcW";
 }else if((_v).equals("گ")) { 
 //BA.debugLineNum = 285;BA.debugLine="Return \"ujS\"";
if (true) return "ujS";
 }else if((_v).equals("ل")) { 
 //BA.debugLineNum = 287;BA.debugLine="Return \"vp2\"";
if (true) return "vp2";
 }else if((_v).equals("م")) { 
 //BA.debugLineNum = 289;BA.debugLine="Return \"kEl\"";
if (true) return "kEl";
 }else if((_v).equals("ن")) { 
 //BA.debugLineNum = 291;BA.debugLine="Return \"7Ts\"";
if (true) return "7Ts";
 }else if((_v).equals("و")) { 
 //BA.debugLineNum = 293;BA.debugLine="Return \"9zk\"";
if (true) return "9zk";
 }else if((_v).equals("ه")) { 
 //BA.debugLineNum = 295;BA.debugLine="Return \"AQn\"";
if (true) return "AQn";
 }else if((_v).equals("ی")) { 
 //BA.debugLineNum = 297;BA.debugLine="Return \"DBX\"";
if (true) return "DBX";
 }else if((_v).equals("ء")) { 
 //BA.debugLineNum = 299;BA.debugLine="Return \"GGo\"";
if (true) return "GGo";
 }else if((_v).equals("ئ")) { 
 //BA.debugLineNum = 301;BA.debugLine="Return \"aIt\"";
if (true) return "aIt";
 }else {
 //BA.debugLineNum = 303;BA.debugLine="Return v & v & v";
if (true) return _v+_v+_v;
 };
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
