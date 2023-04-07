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
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim grp_job As HttpJob

End Sub

Sub Globals

	Private lbl_group_num As Label
	Private lbl_user_num As Label
	Private scr_items As ScrollView
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("see_groups")
	#region Set view sizes
	sizeviewV3.SetPX(Activity.Width,Activity.Height,240,320)
	sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)
	sizeviewV3.SetSize_lbl_Views(lbl_user_num,-5,5,40,150,12)
	sizeviewV3.SetSize_lbl_Views(lbl_group_num,-5,165,40,70,12)
	sizeviewV3.SetSizeViews(scr_items,30,0,280,240,15)
	scr_items.Panel.Height=3000
	#end region
	Dim sc As sec_Class_2

	grp_job.Initialize("grp_info",Me)
	grp_job.PostString(config_App.grp_info_url,"us_name="&sc.Encryption(config_App.user_username)&"&us_pass="&sc.Encryption(config_App.user_password)&"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")

	ProgressDialogShow2("در حال دریافت اطلاعات گروه ها ؛ لطفا کمی صبر نمایید ...",False)



End Sub

Sub JobDone(Job As HttpJob)
	Dim sc As sec_Class_2
	
'	ProgressDialogHide
	If Job.Success Then
		If Job.JobName="grp_info" Then
			If Job.GetString=sc.Encryption("wrong_info") Then
				config_App.wrong_info
			Else
				analyz_group_info(Job.GetString)
			End If
		End If
	Else
		Msgbox("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید","")
		Activity_KeyPress(KeyCodes.KEYCODE_BACK)
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub analyz_group_info(str_val As String)
	ProgressDialogHide

	Dim sc As sec_Class_2
	Dim js1 As JSONParser
	js1.Initialize(sc.Decryption(str_val))
	''''''''''''''''''''''
	Dim lst As List
	lst.Initialize
	lst=js1.NextArray
	''''''''''''''''''''''
	Dim group_num(lst.Size),user_num(lst.Size) As Button
	Dim view_top As Int=0
	''''''''''''''''''''''
	For i=0 To lst.Size-1
		Dim mp As Map
		mp.Initialize
		mp=lst.Get(i)
		
		#region اضافه شدن ویوها
		group_num(i).Initialize("")
		user_num(i).Initialize("")
		
		
		group_num(i).TextColor=Colors.Black
		'		group_num(i).Color=Colors.ARGB(255,222,194,76)
		group_num(i).SetBackgroundImage(LoadBitmap(File.DirAssets,"preview_off.png"))
		group_num(i).TextSize=lbl_group_num.TextSize
		group_num(i).Gravity=Gravity.CENTER
		
		
		user_num(i).TextColor=Colors.White
		'		user_num(i).Color=Colors.ARGB(255,78,148,133)
		user_num(i).TextSize=lbl_user_num.TextSize
		user_num(i).Gravity=Gravity.CENTER
		
		group_num(i).Text=mp.Get("grp_num")
		user_num(i).Text=mp.Get("user_num")
		
		scr_items.Panel.AddView(group_num(i),lbl_group_num.Left,view_top,lbl_group_num.Width,lbl_group_num.Height)
		group_num(i).SetBackgroundImage(view_image(group_num(i),Colors.ARGB(255,222,194,76),Colors.Black,5))
		scr_items.Panel.AddView(user_num(i),lbl_user_num.Left,view_top,lbl_user_num.Width,lbl_user_num.Height)
		user_num(i).SetBackgroundImage(view_image(user_num(i),Colors.ARGB(255,78,148,133),Colors.Black,5))
		view_top=group_num(i).Top+group_num(i).Height+3%y
		#End Region
		scr_items.Panel.Height=view_top
	Next
		
	
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode=KeyCodes.KEYCODE_BACK Then
		StartActivity(main_act)
		Activity.Finish
	End If
	Return True
End Sub


Sub view_image(My_view As View,back_color As Int,border_color As Int,border_Size As Int) As Bitmap
	Dim view_Canvas As Canvas
	view_Canvas.Initialize(My_view)
	view_Canvas.DrawColor(back_color)
	view_Canvas.DrawLine(0,0,My_view.Width,0,border_color,border_Size)
	view_Canvas.DrawLine(My_view.Width,0,My_view.Width,My_view.Height,border_color,border_Size)
	view_Canvas.DrawLine(My_view.Width,My_view.Height,0,My_view.Height,border_color,border_Size)
	view_Canvas.DrawLine(0,My_view.Height,0,0,border_color,border_Size)
	Return view_Canvas.Bitmap
End Sub
