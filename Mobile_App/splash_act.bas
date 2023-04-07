Type=Activity
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals


End Sub

Sub Globals

	Private btn_1 As Button
	Private btn_2 As Button
	Private btn_3 As Button
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("splash_page")
	#region Set view sizes
	sizeviewV3.SetPX(Activity.Width,Activity.Height,240,320)
	sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)
	sizeviewV3.SetSize_btn(btn_1,40,140,50,80,25)
	sizeviewV3.SetSize_btn(btn_2,120,90,50,130,25)
	sizeviewV3.SetSize_btn(btn_3,200,40,50,180,25)
	#end region
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub btn_1_Click
	config_App.is_first=False
	StartActivity(main_act)
	Activity.Finish
End Sub