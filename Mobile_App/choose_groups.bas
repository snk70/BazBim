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
	'Dim lst_groups,lst_users As List

	Dim grp_job,member_ship As HttpJob
	
	
End Sub

Sub Globals
	Dim lst_grp_num,lst_grp_users_num As List

	Dim user_group_selected As Int

	Dim job_st As Int
	Dim job_rs As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
Activity.Color=Colors.White
	Dim sc As sec_Class_2
	grp_job.Initialize("grp_info",Me)
	grp_job.PostString(config_App.grp_info_url,"us_name="&sc.Encryption(config_App.user_username)&"&us_pass="&sc.Encryption(config_App.user_password)&"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")
	ProgressDialogShow2("در حال دریافت اطلاعات گروه ها ؛ لطفا کمی صبر نمایید ...",False)

End Sub

Sub JobDone(job As HttpJob)
	Dim sc As sec_Class_2
	
	If job.Success=True Then
		If job.JobName="grp_info" Then
			If job.GetString=sc.Encryption("wrong_info") Then
				ToastMessageShow("Wrong information",False)
			Else
				lst_grp_num.Initialize
				lst_grp_users_num.Initialize
				lst_grp_num.Clear
				lst_grp_users_num.Clear
				Dim js As JSONParser
				js.Initialize(sc.Decryption(job.GetString))
				Dim lst_info As List
				lst_info.Initialize
				lst_info=js.NextArray
				For i=0 To lst_info.Size-1
					Dim mp As Map
					mp.Initialize
					mp=lst_info.Get(i)
					lst_grp_num.Add(mp.Get("grp_num"))
					lst_grp_users_num.Add(mp.Get("user_num"))
				Next

				Dim sel_item As Int =InputList(lst_grp_num,"انتخاب گروه مورد نظر",-1)
				If sel_item>-1 Then
					If Msgbox2("آیا مایل به عضویت در گروه شماره "&lst_grp_num.Get(sel_item)&" با "&lst_grp_users_num.Get(sel_item)&" اعضا را دارید ؟","عضویت در گروه","بله","خیر","",Null)=DialogResponse.POSITIVE Then
						'کاربر درخواست عضویت داد
						user_group_selected=sel_item
						job_st=1
					Else
						Activity_KeyPress(KeyCodes.KEYCODE_BACK)
					End If
				Else
					Activity_KeyPress(KeyCodes.KEYCODE_BACK)
				End If
			End If
		Else If job.JobName="member_ship_req" Then
	 		job_st=2
			job_rs=job.GetString
		End If
	Else If job.Success=False Then
		job_st=0
		'		Msgbox("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید","")
	End If
	
	apply_responses
	
	
	
	
'	
'	
'	
'	
'	
'	ProgressDialogHide
'	If job.Success Then
'		If job.JobName="grp_info" Then
'			If job.GetString=sc.Encryption("wrong_info") Then
'				config_App.wrong_info
'			Else
'				
'			End If
'		Else If job.JobName="member_ship_req" Then
'			If job.GetString=sc.Encryption("tm_exp") Then
'				'عضویت بسته است
'				Msgbox(". کاربر گرامی ؛ انتخاب گروه ها در این دوره به پایان رسیده . "&CRLF&"از فردا نسبت به انتخاب گروه های جدید اقدام نمایید .","پایان دوره")
'				Activity_KeyPress(KeyCodes.KEYCODE_BACK)
'			Else If job.GetString=sc.Encryption("ok_added") Then
'				'کاربر افزوده شد
'				ToastMessageShow("کاربر گرامی ؛ با تشکر ، انتخاب شما ثبت گردید .",True)
'				Activity_KeyPress(KeyCodes.KEYCODE_BACK)
'			Else If job.GetString=sc.Encryption("error_operation") Then
'				'خطای کویری های سمت سرور
'				Msgbox("متأسفانه مشکلی در هنگام برقراری ارتباط با مرکز به وجود آمده است ، لطفا کمی صبر کنید و مجددا تلاش نمایید ."&CRLF&"در صورت عدم رفع مشکل ، لطفا موضوع را با کارشناسان بازبیم در ارتباط بگذارید .","خطا")
'			Else If job.GetString=sc.Encryption("not_enough_score") Then
'				'امتیاز کافی نیست
'				Msgbox("کاربر گرامی ؛ امتیاز شما برای انتخاب جدید کافی نمیباشد ، لطفا نسبت به جمع آوری امتیاز های جدید اقدام نمایید .","عدم امتیاز کافی")
'				Activity_KeyPress(KeyCodes.KEYCODE_BACK)
'			End If
'		End If
'	Else
'		'		Msgbox("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید","")
'		ToastMessageShow("خطایی در ارتباط با مرکز به وجود آمده ؛ لطفا از وصل بودن اینترنت خود مطمئن شوید و مجددا تلاش کنید",True)
'		'		ExitApplication
'	End If
	
End Sub

Sub Activity_Resume

End Sub

Sub apply_responses

	Dim sc As sec_Class_2
	
	If job_st=0 Then
		
	Else If job_st=1 Then
		member_ship.Initialize("member_ship_req",Me)
		member_ship.PostString(config_App.member_grp,"us_name="&sc.Encryption(config_App.user_username)&"&us_pass="&sc.Encryption(config_App.user_password)&"&req_qrp="&sc.Encryption(lst_grp_num.Get(user_group_selected))&"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")
	Else If job_st=2 Then
		If job_rs=sc.Encryption("tm_exp") Then
			'عضویت بسته است
			Msgbox(". کاربر گرامی ؛ انتخاب گروه ها در این دوره به پایان رسیده . "&CRLF&"از فردا نسبت به انتخاب گروه های جدید اقدام نمایید .","پایان دوره")
			Activity_KeyPress(KeyCodes.KEYCODE_BACK)
		Else If job_rs=sc.Encryption("ok_added") Then
			'کاربر افزوده شد
			ToastMessageShow("کاربر گرامی ؛ با تشکر ، انتخاب شما ثبت گردید .",True)
			Activity_KeyPress(KeyCodes.KEYCODE_BACK)
		Else If job_rs=sc.Encryption("error_operation") Then
			'خطای کویری های سمت سرور
			Msgbox("متأسفانه مشکلی در هنگام برقراری ارتباط با مرکز به وجود آمده است ، لطفا کمی صبر کنید و مجددا تلاش نمایید ."&CRLF&"در صورت عدم رفع مشکل ، لطفا موضوع را با کارشناسان بازبیم در ارتباط بگذارید .","خطا")
		Else If job_rs=sc.Encryption("not_enough_score") Then
			'امتیاز کافی نیست
			Msgbox("کاربر گرامی ؛ امتیاز شما برای انتخاب جدید کافی نمیباشد ، لطفا نسبت به جمع آوری امتیاز های جدید اقدام نمایید .","عدم امتیاز کافی")
			Activity_KeyPress(KeyCodes.KEYCODE_BACK)
		End If
	End If

	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub set_and_sort_groups(str_val As String)
	Dim sc As sec_Class_2
	str_val=sc.Decryption(str_val)
	''''''''''''''''''''''''''''''''''
	Dim groups_info_js As JSONParser
	groups_info_js.Initialize(str_val)
	''''''''''''''''''''''''''''''''''
	Dim groups_info_lists As List
	groups_info_lists.Initialize
	groups_info_lists=groups_info_js.NextArray
	''''''''''''''''''''''''''''''''''
	Dim groups_user_num(groups_info_lists.Size) As String
	Dim groups_number(groups_info_lists.Size) As String
	
	''''''''''''''''''''''''''''''''''
	For i=0 To groups_info_lists.Size-1
		Dim mp As Map
		mp.Initialize
		mp=groups_info_lists.Get(i)
		''''''''''''''''''''''''''''''''''
		groups_user_num(i)=mp.Get("user_num")
		groups_number(i)=mp.Get("grp_num")
	Next
	
	Dim lst_numbers As List
	lst_numbers.Initialize2(groups_number)
	
	Dim sel_grp As Int = InputList(lst_numbers,"انتخاب گروه مورد نظر",-1)
	
	If sel_grp>-1 Then
		Dim group_info As String="گروه شماره "&groups_number(sel_grp)&CRLF&CRLF&"تعداد اعضاء "&groups_user_num(sel_grp)&CRLF&CRLF&"آیا مایل به انتخاب این گروه هستید ؟"
	
		If	 Msgbox2(group_info,"انتخاب گروه","بله","خیر","",Null)=DialogResponse.POSITIVE Then
			ProgressDialogShow2("در حال ارسال درخواست عضویت شما ؛ لطفا کمی صبر کنید ...",False)
			member_ship.Initialize("member_ship_req",Me)
			member_ship.PostString(config_App.member_grp,"us_name="&sc.Encryption(config_App.user_username)&"&us_pass="&sc.Encryption(config_App.user_password)&"req_qrp="&sc.Encryption(groups_number(sel_grp))&"&asjdfawejkurigerogjrgnrigeruiguberg=rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j&ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k=3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")
		End If
		Activity_KeyPress(KeyCodes.KEYCODE_BACK)
	Else
		Activity_KeyPress(KeyCodes.KEYCODE_BACK)
	End If

End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode=KeyCodes.KEYCODE_BACK Then
		StartActivity(main_act)
		Activity.Finish
	End If
	Return True
End Sub

