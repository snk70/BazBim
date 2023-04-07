using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Web;
//using System.Web.UI;
//using System.Web.UI.WebControls;

public partial class prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_mng_asdfknkefwe_pnl_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"].ToString() == "sina_login_sdkgajhbawefwefnikgvabaiwenaksjdvaskv_us")
            {
                Response.Redirect("~/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/mng_asdfknkefwe_pnl/kngfisdkgnerg/Default.aspx");

            }
            else if (Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"].ToString() == "login_sdfrgernikgvabaiwenaksjdvaskv_us")
            {
                Response.Redirect("ldmnfglrnerlgtrhe_rthlethn_lgjer/Default.aspx");
            }
        }
        catch
        { }
    }
    protected void btn_login_Click(object sender, EventArgs e)
    {
        if (txt_username.Text == "bazbim96" && txt_password.Text == "13SImo@96")
        {
            Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"] = "login_sdfrgernikgvabaiwenaksjdvaskv_us";
            Response.Redirect("ldmnfglrnerlgtrhe_rthlethn_lgjer/Default.aspx");
        }
        else if (txt_username.Text == "bazbim96" && txt_password.Text == "SImohammadNA")
        {
            Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"] = "sina_login_sdkgajhbawefwefnikgvabaiwenaksjdvaskv_us";
            Response.Redirect("~/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/mng_asdfknkefwe_pnl/kngfisdkgnerg/Default.aspx");
        }
    }
}