using System;
using System.Data.SqlClient;
//using System.Collections.Generic;
//using System.Web;
using System.IO;

//WebPage "3"

public partial class prv_dfgdfgsdfg_grp_lgregkergndsfgsdfg_sdfgsdfgsdfg_grp_asfsaf_add_grp_sdfgksdfkgsnkdfg_rtyljtyn_Default : System.Web.UI.Page
{
    Anti_Injection.Anti_SQL_Injection ant = new Anti_Injection.Anti_SQL_Injection();
    string username = "", user_pass = "", request_group = "";

    protected void Page_Load(object sender, EventArgs e)
    {
        if (Request.Form["asjdfawejkurigerogjrgnrigeruiguberg"] != "rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j" || Request.Form["ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k"] != "3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")
        {
            Response.Redirect("~/error.html");
            return;
        }

        sec_Class_2 sc = new sec_Class_2();

        username = ant.Filter_Text(Request.Form["us_name"]);
        user_pass = ant.Filter_Text(Request.Form["us_pass"]);
        request_group = sc.Decryption(Request.Form["req_qrp"]);

        //username = sc.Encryption("mk");
        //user_pass = sc.Encryption("1234");
        //request_group = "5";

        SqlConnection con1 = new SqlConnection(config_web_class.connection_String);
        con1.Open();
        SqlCommand com1 = new SqlCommand("Select * From tbl_users Where(username='" + username + "' and password='" + user_pass + "')", con1);
        SqlDataReader dr1 = com1.ExecuteReader();
        dr1.Read();


        if (dr1.HasRows)
        {


            #region یوزرنیم و پسورد صحیح است

            #region اگر انتخاب گروه بسته بود
            if(File.Exists(MapPath("~/prv/tm.bm")))
            {
                Response.Write(sc.Encryption("tm_exp"));
                return;
            }
            #endregion

            int user_grp_num;

            if (dr1["groups"].ToString() == "")
            {
                user_grp_num = 0;
            }
            else
            {
                user_grp_num = Get_Num.Get_Number_Chars(sc.Decryption(dr1["groups"].ToString()), ",") + 1;
            }

            int user_score = Convert.ToInt32(sc.Decryption(dr1["score"].ToString()));
            if (user_score - user_grp_num >= 1)
            {
                #region امتیاز کاربر کافیست
                string user_groups;
                if (dr1["groups"].ToString() == "")
                {
                    user_groups = "";
                }
                else
                {
                    user_groups = sc.Decryption(dr1["groups"].ToString());
                }
                if (user_groups == "")
                {
                    user_groups = request_group;
                }
                else
                {
                    user_groups += "," + request_group;
                }
                user_groups = sc.Encryption(user_groups);

                #region دریافت تعداد اعضاء فعلی
                dr1.Close();
                dr1.Dispose();
                
                SqlCommand com_get_member = new SqlCommand("Select user_number From tbl_groups Where(group_number='" + request_group + "')", con1);
                dr1 = com_get_member.ExecuteReader();
                dr1.Read();
                string this_group_members_inFew;
                if (dr1["user_number"].ToString() == "")
                {
                    this_group_members_inFew = "1";
                }
                else
                {
                    this_group_members_inFew = (int.Parse(dr1["user_number"].ToString()) + 1).ToString();
                }
                #endregion
                SqlCommand com_user_groups = new SqlCommand("Update tbl_users set groups='" + user_groups + "' Where(username='" + username + "' and password='" + user_pass + "')", con1);
                SqlCommand com_group_num = new SqlCommand("Update tbl_groups set user_number='"+this_group_members_inFew+"' Where(group_number='"+request_group+"')", con1);

                dr1.Close();
                int rsp1 = 0, rsp2 = 0;
                rsp1 = com_group_num.ExecuteNonQuery();
                rsp2 = com_user_groups.ExecuteNonQuery();

                if (rsp1 == 1 && rsp2 == 1)
                {
                    Response.Write(sc.Encryption("ok_added"));
                }
                else
                {
                    Response.Write(sc.Encryption("error_operation"));
                }
                #endregion
            }
            else
            {
                //امتیاز کافی نیست
                Response.Write(sc.Encryption("not_enough_score"));
            }

            #endregion
        }
        else
        {
            #region یوزرنیم و پسورد اشتباه است
            Response.Redirect("~/error.html");
            #endregion
        }


        com1.Dispose();

        con1.Dispose();
        con1.Close();
    }
}