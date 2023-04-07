using System;
using System.Data.SqlClient;
using System.Collections.Generic;
//using System.Web;

//WebPage "1"

public partial class prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_Default : System.Web.UI.Page
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

        sec_Class_2 sc = new sec_Class_2();


        username = ant.Filter_Text(Request.Form["us_name"]);
        user_pass = ant.Filter_Text(Request.Form["us_pass"]);
        //username = sc.Encryption("mj");
        //user_pass = sc.Encryption("1234");

        SqlConnection con1 = new SqlConnection(config_web_class.connection_String);
        con1.Open();
        SqlCommand com1 = new SqlCommand("Select * From tbl_users Where(username='" + username + "' and password='" + user_pass + "')", con1);
        SqlDataReader dr1 = com1.ExecuteReader();
        if (dr1.HasRows)
        {

            #region یوزرنیم و پسورد صحیح است
            Json_Creater.Json js1 = new Json_Creater.Json();
            List<string> js_keys = new List<string>();
            List<string> js_vals = new List<string>();

            while (dr1.Read())
            {
                js_keys.Add("username");
                js_vals.Add(dr1["username"].ToString());

                js_keys.Add("score");
                js_vals.Add(dr1["score"].ToString());

                js_keys.Add("fname");
                js_vals.Add(dr1["fname"].ToString());


                int grp_num;
                if (dr1["groups"].ToString() == "")
                {
                    js_keys.Add("groups");
                    js_vals.Add(sc.Encryption("null"));
                    grp_num = 0;
                }
                else
                {
                    js_keys.Add("groups");
                    js_vals.Add(dr1["groups"].ToString());

                    grp_num = Get_Num.Get_Number_Chars(sc.Decryption(dr1["groups"].ToString()), ",") + 1;
                }
                js_keys.Add("group_num");
                js_vals.Add(grp_num.ToString());
            }
            js1.Add_Lists(js_keys, js_vals);
            Response.Write(sc.Encryption(js1.Json_Encode()));

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