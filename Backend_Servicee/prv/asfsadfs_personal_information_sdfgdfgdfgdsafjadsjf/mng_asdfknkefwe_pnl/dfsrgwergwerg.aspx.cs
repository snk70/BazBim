using System;
using System.Collections.Generic;
//using System.Linq;
//using System.Web;
//using System.Web.UI;
//using System.Web.UI.WebControls;
using System.IO;

public partial class prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_mng_asdfknkefwe_pnl_dfsrgwergwerg : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"].ToString() == "login_sdfrgernikgvabaiwenaksjdvaskv_us")
            {

            }
            else if (Session["kdxfgnskgergkjdfgneeifwefjogreigenrgbeugbergerierirewt3487438257uirthreb34r734834fu34c"].ToString() == "sina_login_sdkgajhbawefwefnikgvabaiwenaksjdvaskv_us")
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
    }
    protected void btn_ok_Click(object sender, EventArgs e)
    {
        File.Delete(MapPath("~/bazbim_news/sdgdfg_news.bz"));
        File.WriteAllText(MapPath("~/bazbim_news/sdgdfg_news.bz"), CKEditorControl1.Text);
    }
    protected void btn_load_Click(object sender, EventArgs e)
    {
        if (File.Exists(MapPath("~/bazbim_news/sdgdfg_news.bz")))
        {
            CKEditorControl1.Text = File.ReadAllText(MapPath("~/bazbim_news/sdgdfg_news.bz"));
        }
    }
    protected void btn_exit_Click(object sender, EventArgs e)
    {
        Session.RemoveAll();
        Response.Redirect("~/prv/asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf/mng_asdfknkefwe_pnl/Default.aspx");
    }
}