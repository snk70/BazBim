Type=StaticCode
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	Dim user_Fname,user_username,user_password,user_Score,user_groups As String
	Dim user_Group_num As Int	
	Dim domain_url As String="http://bazbim.com"
	Dim person_info_url As String=domain_url&"/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/Default.aspx"
	Dim grp_info_url As String=domain_url&"/"&"prv/dfgdfgsdfg_grp_lgregkergndsfgsdfg/sdfgsdfgsdfg_grp_asfsaf/pujkdthm_sel_grp_dgkewbbger/"
	Dim member_grp As String=domain_url&"/prv/dfgdfgsdfg_grp_lgregkergndsfgsdfg/sdfgsdfgsdfg_grp_asfsaf/add_grp_sdfgksdfkgsnkdfg_rtyljtyn/"
	Dim news_url As String=domain_url&"/bazbim_news/"
	
	
	Dim us_path="sdfgjksdfgkserjlgrgpoerguthbokrhjt/wgqregegtrhehjerjtyjtgdfbaasdfaef/grwer_WERGEWRG_ERGWERG_WERGWERGWERGergegrn/rrfdt/"
	Dim ps_path="sdfgjksdfgkserdfsdjlgrgpoerguthbokrhjt/wgqregegtr234shehjerjtyjtgdfbaasdfaef/grwer_WERGEWRqwdG_ERGWERG_WERGWERGWERGergegrn/rrfdsdt/"
	
	Dim us_file_name="weqwegERW_re.png"
	Dim ps_file_name="wergERW_re.JPG"
	
	
	Dim is_first As Boolean=True
	
End Sub

Sub wrong_info
	File.Delete(File.DirInternal,ps_path&ps_file_name)
	File.Delete(File.DirInternal,us_path&us_file_name)
	ToastMessageShow("مشخصات کاربر اشتباه میباشد",False)
End Sub