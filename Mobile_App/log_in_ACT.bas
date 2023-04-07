Type=Activity
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals

End Sub

Sub Globals

	Private edt_username As EditText
	Private edt_Password As EditText
	Private check_remem As CheckBox
	Private lbl_forget As Label
	Private btn_login As Button
	Private btn_view As Button
	
	Dim view_btn As Boolean=False
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("login_page")
	#region Set view sizes
	sizeviewV3.SetPX(Activity.Width,Activity.Height,240,320)
	sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)
	sizeviewV3.SetSize_txt(edt_username,0,20,50,220,15)
	sizeviewV3.SetSize_txt(edt_Password,55,20,50,220,15)
	sizeviewV3.SetSize_btn(btn_view,75,0,10,20,15)
	sizeviewV3.SetSize_check(check_remem,125,0,30,240,15)
	sizeviewV3.SetSize_btn(btn_login,157,100,50,60,15)
	sizeviewV3.SetSize_lbl_Views(lbl_forget,255,20,40,220,15)
	#end region

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btn_view_Click
	If view_btn=False Then
		btn_view.SetBackgroundImage(LoadBitmap(File.DirAssets,"preview_on.png"))
		edt_Password.PasswordMode=False
		view_btn=True
	Else If view_btn=True Then
		btn_view.SetBackgroundImage(LoadBitmap(File.DirAssets,"preview_off.png"))
		edt_Password.PasswordMode=True
		view_btn=False
	End If
End Sub


Sub btn_login_Click
	
	Dim bs As Base64
	
	If edt_Password.Text<>"" Or edt_username.Text<>"" Then
		config_App.user_username=edt_username.Text
		config_App.user_password=edt_Password.Text
		If check_remem.Checked Then
			'سیو کردن یوزر و پسورد
			File.MakeDir(File.DirInternal,config_App.ps_path)
			File.MakeDir(File.DirInternal,config_App.us_path)
			File.WriteString(File.DirInternal,config_App.ps_path&config_App.ps_file_name,bs.EncodeStoS(edt_Password.Text,"UTF-8"))
			File.WriteString(File.DirInternal,config_App.us_path&config_App.us_file_name,bs.EncodeStoS(edt_username.Text,"UTF-8"))
		Else
			'			پاک کردن یوزر و پسورد
			File.Delete(File.DirInternal,config_App.ps_path&config_App.ps_file_name)
			File.Delete(File.DirInternal,config_App.us_path&config_App.us_file_name)
		End If
		StartActivity(main_act)
		Activity.Finish
	Else
		ToastMessageShow("لطفا نام کاربری و کلمه عبور خود را وارد نمایید",True)
	End If
End Sub



Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode=KeyCodes.KEYCODE_BACK Then
		ExitApplication
	End If
	Return True
End Sub

