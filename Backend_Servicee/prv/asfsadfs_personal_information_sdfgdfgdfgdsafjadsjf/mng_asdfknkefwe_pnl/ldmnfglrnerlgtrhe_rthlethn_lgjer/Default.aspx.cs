using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Web;
//using System.Web.UI;
using System.IO;
//using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Globalization;

public partial class prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_mng_asdfknkefwe_pnl_ldmnfglrnerlgtrhe_rthlethn_lgjer_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"].ToString() == "login_sdfrgernikgvabaiwenaksjdvaskv_us")
            {

            }
            else
            {
                Response.Redirect("~/error.html");
            }
        }
        catch {
            Session.RemoveAll();
            Response.Redirect("~/error.html");        
        }

        sec_Class_2 sc = new sec_Class_2();

        try
        {
            #region ویرایش کاربران
            if (Request.Form["opr"] == "edi_users")
            {
                Session["r"] = Request.Form["r"];
                Session["opr"] = "edi_users";
                txt_score.Visible = true;
                txt_date.Visible = true;
                txt_groups.Visible = true;

                SqlConnection con = new SqlConnection(config_web_class.connection_String);
                con.Open();
                SqlCommand com_get_data = new SqlCommand("Select * From tbl_users Where(r='" + Request.Form["r"] + "')", con);
                SqlDataReader dr = com_get_data.ExecuteReader();
                dr.Read();
                txt_username.Text = sc.Decryption(dr["username"].ToString());
                txt_pass.Text = sc.Decryption(dr["password"].ToString());
                txt_score.Text = sc.Decryption(dr["score"].ToString());
                txt_name.Text = dr["fname"].ToString();
                txt_last_name.Text = dr["lname"].ToString();
                txt_date.Text = dr["Date"].ToString();
                txt_code_melli.Text = dr["melicode"].ToString();
                txt_phone.Text = dr["phone_number"].ToString();
                txt_groups.Text = sc.Decryption(dr["groups"].ToString());
                dr.Dispose();
                dr.Close();
                con.Close();
            }

            #endregion

            #region ویرایش اخبار
            else if (Request.Form["opr"] == "desc")
            {

            }
            #endregion

        }
        catch
        {
            txt_date.Visible = false;
        }

        if (File.Exists(MapPath("~/prv/tm.bm")))
        {
            p_st.InnerText = "عضویت بسته است";
        }
        else
        {
            p_st.InnerText = "عضویت باز است";
        }

    }

    protected void btn_ok_member_Click(object sender, EventArgs e)
    {
        sec_Class_2 sc = new sec_Class_2();

        if (txt_username.Text != "")
        {
            txt_username.Text = sc.Encryption(txt_username.Text);
        }
        if (txt_pass.Text != "")
        {
            txt_pass.Text = sc.Encryption(txt_pass.Text);
        }
        if (txt_score.Text != "")
        {
            txt_score.Text = sc.Encryption(txt_score.Text);
        }
        if (txt_groups.Text != "")
        {
            txt_groups.Text = sc.Encryption(txt_groups.Text);
        }
        try
        {
            if (Session["opr"].ToString() == "edi_users")
            {
                SqlConnection con = new SqlConnection(config_web_class.connection_String);
                con.Open();
                SqlCommand up_com = new SqlCommand("Update tbl_users set username=N'" + (txt_username.Text) + "',password=N'" + (txt_pass.Text) + "',score=N'" + (txt_score.Text) + "',fname=N'" + txt_name.Text + "',lname=N'" + txt_last_name.Text + "',Date=N'" + txt_date.Text + "',melicode=N'" + txt_code_melli.Text + "',phone_number=N'" + txt_phone.Text + "',groups='" + (txt_groups.Text) + "' Where(r='" + Session["r"].ToString() + "') ", con);
                up_com.ExecuteNonQuery();
                con.Close();
                Session.Remove("opr");
                Response.Redirect(Request.Url.ToString());
            }
        }
        catch
        {
            SqlConnection con = new SqlConnection(config_web_class.connection_String);
            con.Open();
            #region بررسی تکراری بودن نام کاربری
            SqlCommand repeat_com = new SqlCommand("Select fname From tbl_users Where(username='" + (txt_username.Text) + "')", con);
            SqlDataReader dr = repeat_com.ExecuteReader();
            if (dr.HasRows == true)
            {
                Response.Write("این نام کاربری تکراری میباشد");
                return;
            }
            dr.Close();
            #endregion

            PersianCalendar pc = new PersianCalendar();
            string dt = pc.GetYear(DateTime.Now) + "/" + pc.GetMonth(DateTime.Now) + "/" + pc.GetDayOfMonth(DateTime.Now);
            string tm = DateTime.Now.Hour.ToString() + ":" + DateTime.Now.Minute.ToString();


            SqlCommand insert_com = new SqlCommand("Insert Into tbl_users (username,password,score,fname,lname,Date,melicode,phone_number) VALUES (N'" + (txt_username.Text) + "',N'" + (txt_pass.Text) + "',N'" + (txt_score.Text) + "',N'" + txt_name.Text + "',N'" + txt_last_name.Text + "','" + dt + "," + tm + "',N'" + txt_code_melli.Text + "',N'" + txt_phone.Text + "')", con);

            insert_com.ExecuteNonQuery();
            Response.Redirect(Request.Url.ToString());
            con.Close();
        }
    }
    protected void btn_add_grp_Click(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection(config_web_class.connection_String);
        con.Open();
        SqlCommand insert_com = new SqlCommand("Insert into tbl_groups (group_number) values('" + txt_grp_num.Text + "')", con);
        insert_com.ExecuteNonQuery();
        Response.Redirect(Request.Url.ToString());
        con.Close();
    }
    protected void btn_open_membership_Click(object sender, EventArgs e)
    {
        File.Delete(MapPath("~/prv/tm.bm"));
        Response.Redirect(Request.Url.ToString());
    }
    protected void btn_close_membership_Click(object sender, EventArgs e)
    {
        File.WriteAllText(MapPath("~/prv/tm.bm"),"");
        Response.Redirect(Request.Url.ToString());
    }
    protected void btn_exit_Click(object sender, EventArgs e)
    {
        Session.RemoveAll();
        Response.Redirect("~/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/mng_asdfknkefwe_pnl/Default.aspx");
    }
    protected void btn_news_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/mng_asdfknkefwe_pnl/dfsrgwergwerg.aspx");
    }
}