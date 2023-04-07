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
	Dim ht_info As HttpJob
End Sub

Sub Globals

	Private lbl_name As Label
	Private lbl_score As Label
	Private lbl_choose As Label
	Private lst_selected As ListView
	Private Label1 As Label
	Private btn_see As Button
	Private btn_choose As Button
	Dim wb_tmr As Timer
	Private wb_news As WebView
	
End Sub

Sub Activity_Create(FirstTime As Boolean)

	Dim bs As Base64
'	Msgbox(bs.DecodeStoS(File.ReadString(File.DirInternal,config_App.ps_path&config_App.ps_file_name),"UTF-8"),"")
'	Msgbox(bs.DecodeStoS(File.ReadString(File.DirInternal,config_App.us_path&config_App.us_file_name),"UTF-8"),"")v
	
	If 	File.Exists(File.DirInternal,config_App.ps_path&config_App.ps_file_name) And File.Exists(File.DirInternal,config_App.us_path&config_App.us_file_name) Then
		config_App.user_password=bs.DecodeStoS(File.ReadString(File.DirInternal,config_App.ps_path&config_App.ps_file_name),"UTF-8")
		config_App.user_username=bs.DecodeStoS(File.ReadString(File.DirInternal,config_App.us_path&config_App.us_file_name),"UTF-8")
	End If
	
	
	If config_App.user_username="" And config_App.user_password="" Then
		StartActivity(log_in_ACT)
		Activity.Finish
	Else

		Activity.LoadLayout("home_information")
	#region Set view sizes
		sizeviewV3.SetPX(Activity.Width,Activity.Height,240,320)
		sizeviewV3.SetPastScreenSizetoInche(3.333,4.444)
		sizeviewV3.SetSize_lbl_Views(lbl_choose,80,170,40,60,15)
		sizeviewV3.SetSize_lbl_Views(lbl_name,0,170,40,60,15)
		sizeviewV3.SetSize_lbl_Views(lbl_score,40,170,40,60,15)
		sizeviewV3.SetSizeViews(wb_news,0,0,220,170,0)
		sizeviewV3.SetSize_listview(lst_selected,120,170,100,60,15)
		sizeviewV3.SetSize_btn(btn_see,230,10,70,100,15)
		sizeviewV3.SetSize_btn(btn_choose,230,130,70,100,15)
	#end region
	
		Dim sc As sec_Class_2
		ht_info.Initialize("person_info",Me)
		If config_App.user_password<>"" And config_App.user_username<>"" Then
			ht_info.PostString(config_App.person_info_url,"us_name="&sc.Encryption(config_App.user_username)&"&us_pass="&sc.Encryption(config_App.user_password)&"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")
			ProgressDialogShow2("در حال بروزرسانی اطلاعات ، لطفا کمی صبر کنید ...",False)
			'			refresh_info("0bmtGwwmpWkSWgv5MsNFtbz62pMp213v6gn2oS0tGwsHJtGwVHFDTdoS0kmTHnxWgvNFtJAwdElyCuwmp9OKUJN04w3v69OKfMetGw9nX4iwVHFyCudElb8nPJSDv2UJN9S9fMe666fMepvgtqY9BvwmppvgtqY9BvwmppvgPJS1XxoS0lPEmMM01GNFttGwfMe0bmfMebz6UJNwJodElgn2tqY5MsfMe9OKjSptGwb8ndElWkSdElOAYWgvwJoOoPb8n2Y9GAHtGw9nX4iwVHF04wNFtbz6PJStqYNFtJAwOoPtGwsHJtGwVHF9nXzWaKMVdEl9BvdElbz6dsGyCuwmp9OKUJN666wmpyCu3I3WgvNFtJAwUJNWgvNFtJAwdElyCuwmp9OKdEl9BvWgvJAwNFttGw9nX4iwVHF04wNFtbz6PJStqYNFt3I3PJSwJowmpgn2dsGtGwsHJtGwfMe9BvfMe04wtqYwmpgn2kmT")
		Else
			StartActivity(log_in_ACT)
			Activity.Finish
		End If
	End If
wb_tmr.Initialize("tmr",30000)
wb_tmr.Enabled=True
	
End Sub

Sub tmr_Tick
	wb_news.LoadUrl(config_App.news_url)
End Sub

Sub Activity_Resume
	wb_news.LoadUrl(config_App.news_url)
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub JobDone(Job As HttpJob)
	Dim sc As sec_Class_2
	
	ProgressDialogHide
	If Job.Success Then
		Try
			If Job.JobName="person_info" Then
				If Job.GetString=sc.Encryption("wrong_info") Then
					config_App.user_password=""
					config_App.user_username=""
					Msgbox("نام کاربری یا کلمه عبور اشتباه میباشد ؛ در صورت فراموشی ، لطفا با تلفن بازبیم تماس حاصل فرمایید","خطا")
					config_App.wrong_info
					StartActivity(log_in_ACT)
					Activity.Finish
				Else
					'Msgbox(Job.GetString,"")
					refresh_info(Job.GetString)
				End If
			End If
		Catch
			
		End Try
	Else
		Msgbox("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید","")
	End If
End Sub

Sub refresh_info(str_val As String)
	
	Dim sc As sec_Class_2
	''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
	Dim js1 As JSONParser
	js1.Initialize(sc.Decryption(str_val))
	''''''''''''''''''''''
	Dim lst As List
	lst.Initialize
	lst=js1.NextArray
	''''''''''''''''''''''
	Dim mp As Map
	mp.Initialize
	mp=lst.Get(0)
		
	#region درج اطلاعات
	config_App.user_Fname=mp.Get("fname")
	config_App.user_Score=sc.Decryption(mp.Get("score"))
	config_App.user_Group_num=mp.Get("group_num")
	If sc.Decryption(mp.Get("groups"))="null" Then
		config_App.user_groups=""
	Else
		config_App.user_groups=sc.Decryption(mp.Get("groups"))
	End If
	'''''''''''''''''''''''''''''''''''''''''
	lbl_name.Text="سلام "&config_App.user_Fname
	lbl_score.Text="امتیاز : "&config_App.user_Score
	lbl_choose.Text="انتخاب :"&(config_App.user_Score-config_App.user_Group_num)
	'Msgbox(config_App.user_groups,"")
	'	Return
	#End Region
	If config_App.user_groups<>"" Then
		set_Sort_Groups_in_list(config_App.user_groups)
	End If
	ProgressDialogHide

End Sub

Sub set_Sort_Groups_in_list(str_val As String)
	If config_App.user_Group_num="0" Then
		Msgbox(config_App.user_groups,config_App.user_Group_num)
		Return
	End If
	
	
	
	Dim char_position As Int=0
	For i=0 To config_App.user_Group_num-1
		If i=config_App.user_Group_num-1 Then
'			Msgbox(str_val.SubString2(char_position,str_val.Length),"")
			lst_selected.AddSingleLine("  "&str_val.SubString2(char_position,str_val.Length)&"  ")
		Else
'			Msgbox(str_val.SubString2(char_position,str_val.IndexOf2(",",char_position+1)),"")
			lst_selected.AddSingleLine("  "&str_val.SubString2(char_position,str_val.IndexOf2(",",char_position+1))&"  ")
			char_position=str_val.IndexOf2(",",char_position+1)+1
		End If
	Next
End Sub

Sub btn_see_Click
	StartActivity(see_groups)
	Activity.Finish
End Sub

Sub btn_choose_Click
	StartActivity(choose_groups)
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode=KeyCodes.KEYCODE_BACK Then
		ExitApplication
	End If
	Return True
End Sub