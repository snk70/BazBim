<%@ Page Language="C#" AutoEventWireup="true" CodeFile="dfsrgwergwerg.aspx.cs" Inherits="prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_mng_asdfknkefwe_pnl_dfsrgwergwerg" %>

<%@ Register assembly="CKEditor.NET" namespace="CKEditor.NET" tagprefix="CKEditor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        #form1
        {
            font-weight: 700;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <CKEditor:CKEditorControl ID="CKEditorControl1" runat="server">
        </CKEditor:CKEditorControl>
    
    </div>
    <p>
        &nbsp;</p>
    <asp:Button ID="btn_ok" runat="server" Height="79px" onclick="btn_ok_Click" 
        Text="OK" Width="179px" />
    <p>
        &nbsp;</p>
    <p>
    <asp:Button ID="btn_load" runat="server" Height="79px" onclick="btn_load_Click" 
        Text="لود" Width="179px" />
    </p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:Button ID="btn_exit" runat="server" Height="60px" onclick="btn_exit_Click" 
            Text="خروج" Width="67px" />
    </p>
    </form>
    </body>
</html>
