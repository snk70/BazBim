using System;
using System.Data.SqlClient;
using System.Collections.Generic;
//using System.Web;

//WebPage "2"

public partial class prv_dfgdfgsdfg_grp_lgregkergndsfgsdfg_sdfgsdfgsdfg_grp_asfsaf_pujkdthm_grp_dgkewbbger_Default : System.Web.UI.Page
{

    string username = "", user_pass = "";
    Anti_Injection.Anti_SQL_Injection ant = new Anti_Injection.Anti_SQL_Injection();
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Request.Form["asjdfawejkurigerogjrgnrigeruiguberg"] != "rehgq643y34uruv43jfu24f6g46734fv3274ifg6744b3f7343f4j" || Request.Form["ovbnbslrterbiervnibervinervnierivienwrvnewurvukervbuhwerui34786367i34ugt34k"] != "3487r3g43jfi34fg834fkwerfnwerligh43ig8734gbergiwu54hg3847ogrkvknmler")
        {
            Response.Redirect("~/error.html");
            return;
        }

        username = ant.Filter_Text(Request.Form["us_name"]);
        user_pass = ant.Filter_Text(Request.Form["us_pass"]);

        sec_Class_2 sc = new sec_Class_2();

        SqlConnection con1 = new SqlConnection(config_web_class.connection_String);
        con1.Open();
        SqlCommand com1 = new SqlCommand("Select * From tbl_users Where(username='" + username + "' and password='" + user_pass + "')", con1);
        SqlDataReader dr1 = com1.ExecuteReader();
        if (dr1.HasRows)
        {
            #region یوزر و پس صحیح است
            SqlCommand com2 = new SqlCommand("Select * From tbl_groups", con1);
            dr1.Dispose();
            dr1 = com2.ExecuteReader();
            Json_Creater.Json js1 = new Json_Creater.Json();
            List<string> js_keys = new List<string>();
            List<string> js_vals = new List<string>();

            while (dr1.Read())
            {
                js_vals.Clear();
                js_keys.Clear();

                js_keys.Add("grp_num");
                js_vals.Add(dr1["group_number"].ToString());

                js_keys.Add("user_num");
                js_vals.Add(dr1["user_number"].ToString());

                js1.Add_Lists(js_keys, js_vals);
            }

            Response.Write(sc.Encryption(js1.Json_Encode()));
            //Response.Write(js1.Json_Encode());
            #endregion

        }
        else
        {
            #region یوزرنیم و پسورد اشتباه است
            Response.Write(sc.Encryption("wrong_info"));
            #endregion
        }


        com1.Dispose();

        con1.Dispose();
        con1.Close();
    }
}