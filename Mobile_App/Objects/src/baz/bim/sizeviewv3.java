package baz.bim;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class sizeviewv3 {
private static sizeviewv3 mostCurrent = new sizeviewv3();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static float _v5 = 0f;
public static float _v6 = 0f;
public static float _v7 = 0f;
public static float _v0 = 0f;
public static float _vv1 = 0f;
public static float _vv2 = 0f;
public static float _vv3 = 0f;
public static float _vv4 = 0f;
public static float _vv5 = 0f;
public static float _dv_width = 0f;
public static float _dv_height = 0f;
public anywheresoftware.b4a.samples.httputils2.httputils2service _vvv5 = null;
public baz.bim.main _vvv6 = null;
public baz.bim.choose_groups _choose_groups = null;
public baz.bim.log_in_act _log_in_act = null;
public baz.bim.see_groups _see_groups = null;
public baz.bim.config_app _config_app = null;
public baz.bim.main_act _main_act = null;
public static int  _vvvv1(anywheresoftware.b4a.BA _ba,float _wdh,float _hgh,float _szw,float _szh,int _fs) throws Exception{
float _fs1 = 0f;
float _fs2 = 0f;
float _fs3 = 0f;
float _n1 = 0f;
float _n2 = 0f;
 //BA.debugLineNum = 78;BA.debugLine="Private Sub fsz(wdh As Float,hgh As Float,szw As F";
 //BA.debugLineNum = 79;BA.debugLine="Dim fs1,fs2,fs3 As Float";
_fs1 = 0f;
_fs2 = 0f;
_fs3 = 0f;
 //BA.debugLineNum = 80;BA.debugLine="Dim n1,n2 As Float";
_n1 = 0f;
_n2 = 0f;
 //BA.debugLineNum = 82;BA.debugLine="fs1=getinch(wdh)";
_fs1 = (float)(Double.parseDouble(_vv6(_ba,_wdh)));
 //BA.debugLineNum = 83;BA.debugLine="fs3=getinch(hgh)";
_fs3 = (float)(Double.parseDouble(_vv6(_ba,_hgh)));
 //BA.debugLineNum = 84;BA.debugLine="n1=fs1/szw";
_n1 = (float) (_fs1/(double)_szw);
 //BA.debugLineNum = 85;BA.debugLine="n2=fs3/szh";
_n2 = (float) (_fs3/(double)_szh);
 //BA.debugLineNum = 87;BA.debugLine="If n1>n2 Then";
if (_n1>_n2) { 
 //BA.debugLineNum = 88;BA.debugLine="fs2=n2*fs";
_fs2 = (float) (_n2*_fs);
 }else if(_n2>_n1) { 
 //BA.debugLineNum = 90;BA.debugLine="fs2=n1*fs";
_fs2 = (float) (_n1*_fs);
 }else if(_n1==_n2) { 
 //BA.debugLineNum = 92;BA.debugLine="fs2=n1*fs";
_fs2 = (float) (_n1*_fs);
 };
 //BA.debugLineNum = 95;BA.debugLine="Return fs2*1.5773684210526315789473684210526";
if (true) return (int) (_fs2*1.5773684210526315789473684210526);
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return 0;
}
public static String  _vv6(anywheresoftware.b4a.BA _ba,float _px) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Sub getinch(px As Float)";
 //BA.debugLineNum = 73;BA.debugLine="Dim h As Float";
_vv1 = 0f;
 //BA.debugLineNum = 74;BA.debugLine="h=px/inc";
_vv1 = (float) (_px/(double)_v5);
 //BA.debugLineNum = 75;BA.debugLine="Return h";
if (true) return BA.NumberToString(_vv1);
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static double  _vvvv2(anywheresoftware.b4a.BA _ba,float _px) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Private Sub GetPastHeight(px As Float) As Double";
 //BA.debugLineNum = 120;BA.debugLine="Return (PastHeightScreen/getinch(HeightAct))*getin";
if (true) return (_vv5/(double)(double)(Double.parseDouble(_vv6(_ba,_vv3))))*(double)(Double.parseDouble(_vv6(_ba,_px)));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return 0;
}
public static double  _vvvv3(anywheresoftware.b4a.BA _ba,float _px) throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Private Sub GetPastWidth(px As Float) As Double";
 //BA.debugLineNum = 115;BA.debugLine="Return (PastWidthScreen/getinch(WidthAct))*getinch";
if (true) return (_vv4/(double)(double)(Double.parseDouble(_vv6(_ba,_vv2))))*(double)(Double.parseDouble(_vv6(_ba,_px)));
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Dim inc As Float";
_v5 = 0f;
 //BA.debugLineNum = 6;BA.debugLine="Dim t,l,w,h As Float";
_v6 = 0f;
_v7 = 0f;
_v0 = 0f;
_vv1 = 0f;
 //BA.debugLineNum = 7;BA.debugLine="Dim WidthAct,HeightAct As Float";
_vv2 = 0f;
_vv3 = 0f;
 //BA.debugLineNum = 8;BA.debugLine="Dim PastWidthScreen,PastHeightScreen As Float";
_vv4 = 0f;
_vv5 = 0f;
 //BA.debugLineNum = 9;BA.debugLine="Dim DV_Width,DV_Height As Float";
_dv_width = 0f;
_dv_height = 0f;
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _vv7(anywheresoftware.b4a.BA _ba,float _wdt,float _hig) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub SetPastScreenSizetoInche(Wdt As Float,Hig As F";
 //BA.debugLineNum = 32;BA.debugLine="PastWidthScreen=Wdt";
_vv4 = _wdt;
 //BA.debugLineNum = 33;BA.debugLine="PastHeightScreen=Hig";
_vv5 = _hig;
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _vv0(anywheresoftware.b4a.BA _ba,float _wdt,float _hig,float _pastscreenwidth_px,float _pastscreenheight_px) throws Exception{
float _f1 = 0f;
float _f2 = 0f;
float _f3 = 0f;
float _vatar = 0f;
 //BA.debugLineNum = 13;BA.debugLine="Sub SetPX(Wdt As Float,Hig As Float,PastScreenWidt";
 //BA.debugLineNum = 14;BA.debugLine="DV_Width=PastScreenWidth_PX";
_dv_width = _pastscreenwidth_px;
 //BA.debugLineNum = 15;BA.debugLine="DV_Height=PastScreenHeight_PX";
_dv_height = _pastscreenheight_px;
 //BA.debugLineNum = 17;BA.debugLine="WidthAct=Wdt";
_vv2 = _wdt;
 //BA.debugLineNum = 18;BA.debugLine="HeightAct=Hig";
_vv3 = _hig;
 //BA.debugLineNum = 20;BA.debugLine="Dim f1,f2,f3 As Float";
_f1 = 0f;
_f2 = 0f;
_f3 = 0f;
 //BA.debugLineNum = 21;BA.debugLine="Dim vatar As Float";
_vatar = 0f;
 //BA.debugLineNum = 22;BA.debugLine="vatar=GetDeviceLayoutValues.ApproximateScreenSize";
_vatar = (float) (anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(_ba).getApproximateScreenSize());
 //BA.debugLineNum = 23;BA.debugLine="f1=(Hig*Hig)+(Wdt*Wdt)";
_f1 = (float) ((_hig*_hig)+(_wdt*_wdt));
 //BA.debugLineNum = 24;BA.debugLine="f2=Sqrt(f1)";
_f2 = (float) (anywheresoftware.b4a.keywords.Common.Sqrt(_f1));
 //BA.debugLineNum = 25;BA.debugLine="f3=f2/vatar";
_f3 = (float) (_f2/(double)_vatar);
 //BA.debugLineNum = 26;BA.debugLine="inc=f3";
_v5 = _f3;
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_btn(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ButtonWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub SetSize_btn(View As Button,tv As Float,lv As F";
 //BA.debugLineNum = 41;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 42;BA.debugLine="View.TextSize=fsz(View.Width,View.Height,GetPastWi";
_view.setTextSize((float) (_vvvv1(_ba,(float) (_view.getWidth()),(float) (_view.getHeight()),(float) (_vvvv3(_ba,(float) (_view.getWidth()))),(float) (_vvvv2(_ba,(float) (_view.getHeight()))),(int) (_fontsize))));
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_check(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub SetSize_check(View As CheckBox,tv As Float,lv";
 //BA.debugLineNum = 46;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 47;BA.debugLine="View.TextSize=fsz(View.Width,View.Height,GetPastWi";
_view.setTextSize((float) (_vvvv1(_ba,(float) (_view.getWidth()),(float) (_view.getHeight()),(float) (_vvvv3(_ba,(float) (_view.getWidth()))),(float) (_vvvv2(_ba,(float) (_view.getHeight()))),(int) (_fontsize))));
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_img(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub SetSize_img(View As ImageView,tv As Float,lv A";
 //BA.debugLineNum = 65;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_lbl_views(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.LabelWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Sub SetSize_lbl_Views(View As Label,tv As Float,lv";
 //BA.debugLineNum = 60;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 61;BA.debugLine="View.TextSize=fsz(View.Width,View.Height,GetPastWi";
_view.setTextSize((float) (_vvvv1(_ba,(float) (_view.getWidth()),(float) (_view.getHeight()),(float) (_vvvv3(_ba,(float) (_view.getWidth()))),(float) (_vvvv2(_ba,(float) (_view.getHeight()))),(int) (_fontsize))));
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_listview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ListViewWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub SetSize_listview(View As ListView,tv As Float,";
 //BA.debugLineNum = 69;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_scrolview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ScrollViewWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub SetSize_ScrolView(View As ScrollView,tv As Flo";
 //BA.debugLineNum = 56;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _setsize_txt(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.EditTextWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub SetSize_txt(View As EditText,tv As Float,lv As";
 //BA.debugLineNum = 51;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_view.getObject())),_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 52;BA.debugLine="View.TextSize=fsz(View.Width,View.Height,GetPastWi";
_view.setTextSize((float) (_vvvv1(_ba,(float) (_view.getWidth()),(float) (_view.getHeight()),(float) (_vvvv3(_ba,(float) (_view.getWidth()))),(float) (_vvvv2(_ba,(float) (_view.getHeight()))),(int) (_fontsize))));
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public static String  _vvv1(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,float _tv,float _lv,float _hv,float _wv,float _fontsize) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub SetSizeViews(View As View,tv As Float,lv As Fl";
 //BA.debugLineNum = 37;BA.debugLine="sizemode(View,tv,lv,hv,wv,WidthAct,HeightAct)";
_vvvv4(_ba,_view,_tv,_lv,_hv,_wv,_vv2,_vv3);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _vvvv4(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _view,float _tv,float _lv,float _hv,float _wv,float _xv,float _yv) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Private Sub sizemode(View As View,tv As Float,lv A";
 //BA.debugLineNum = 101;BA.debugLine="View.Top=tv*(yv/DV_Height)";
_view.setTop((int) (_tv*(_yv/(double)_dv_height)));
 //BA.debugLineNum = 102;BA.debugLine="View.Left=lv*(xv/DV_Width)";
_view.setLeft((int) (_lv*(_xv/(double)_dv_width)));
 //BA.debugLineNum = 103;BA.debugLine="View.Width=wv*(xv/DV_Width)";
_view.setWidth((int) (_wv*(_xv/(double)_dv_width)));
 //BA.debugLineNum = 104;BA.debugLine="View.Height=hv*(yv/DV_Height)";
_view.setHeight((int) (_hv*(_yv/(double)_dv_height)));
 //BA.debugLineNum = 106;BA.debugLine="t=View.Top";
_v6 = (float) (_view.getTop());
 //BA.debugLineNum = 107;BA.debugLine="l=View.Left";
_v7 = (float) (_view.getLeft());
 //BA.debugLineNum = 108;BA.debugLine="w=View.Width";
_v0 = (float) (_view.getWidth());
 //BA.debugLineNum = 109;BA.debugLine="h=View.Height";
_vv1 = (float) (_view.getHeight());
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
}
