using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Web;
//using System.Web.UI;
//using System.Web.UI.WebControls;

public partial class prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_mng_asdfknkefwe_pnl_kngfisdkgnerg_rmt_to_post : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"].ToString() == "sina_login_sdkgajhbawefwefnikgvabaiwenaksjdvaskv_us")
            {

            }
            else
            {
                Response.Redirect("~/error.html");
            }

        }
        catch
        {
            Session.RemoveAll();
            Response.Redirect("~/error.html");
        }
        if (Request.QueryString["opr"] == "us")
        {
            RemotePostData.RemotePost rmt = new RemotePostData.RemotePost("Default.aspx");
            rmt.Add("opr", "edi_users");
            rmt.Add("r", Request.QueryString["r"]);
            rmt.Post();
        }
        else if (Request.QueryString["opr"] == "desc")
        {

        }
    }
}