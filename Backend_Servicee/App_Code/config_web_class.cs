using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for config_web_class
/// </summary>
public class config_web_class
{
	public config_web_class()
	{

        

	}

    //public static string connection_String = @"Data Source=.\SQLEXPRESS;AttachDbFilename=C:\Users\Sina\Documents\bazbim_db.mdf;Integrated Security=True;Connect Timeout=30;User Instance=True";
    public static string connection_String = System.Configuration.ConfigurationManager.ConnectionStrings["bazbim_dbConnectionString1"].ConnectionString;    

}