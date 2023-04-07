<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="prv_asfsadfs_personal_information_sdfgdfgdfgdsafjadsjf_mng_asdfknkefwe_pnl_ldmnfglrnerlgtrhe_rthlethn_lgjer_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style>
    .grd
    {
        direction:rtl;
        float:right;
    }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div style="direction: ltr">
    
        <asp:Button ID="btn_exit" runat="server" Height="60px" onclick="btn_exit_Click" 
            Text="خروج" Width="67px" />
    
        <asp:Button ID="btn_news" runat="server" CssClass="grd" Height="58px" 
            onclick="btn_news_Click" Text="مدیریت اخبار" Width="123px" />
    
        <br />
        <br />
        <br />
        <br />
        <br />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="r" DataSourceID="SqlDataSource1" 
            EmptyDataText="There are no data records to display." 
            EnableModelValidation="True" CssClass="grd" AllowPaging="True" 
            AllowSorting="True" BackColor="White" BorderColor="#CC9966" 
            BorderStyle="None" BorderWidth="1px" CellPadding="4">
            <Columns>
                <asp:BoundField DataField="r" HeaderText="ردیف" ReadOnly="True" 
                    SortExpression="r" />
                <asp:BoundField DataField="fname" HeaderText="نام" SortExpression="fname" />
                <asp:BoundField DataField="lname" HeaderText="فامیلی" SortExpression="lname" />
                <asp:BoundField DataField="Date" HeaderText="تاریخ ثبت نام" 
                    SortExpression="Date" />
                <asp:BoundField DataField="melicode" HeaderText="کد ملی" 
                    SortExpression="melicode" />
                <asp:BoundField DataField="phone_number" HeaderText="شماره تلفن" 
                    SortExpression="phone_number" />
                <asp:CommandField DeleteText="حذف" ShowDeleteButton="True" />
                <asp:HyperLinkField DataNavigateUrlFields="r" Text="ویرایش" 
                    DataNavigateUrlFormatString="rmt_to_post.aspx?r={0}&amp;opr=us" />
            </Columns>
            <FooterStyle BackColor="#FFFFCC" ForeColor="#330099" />
            <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="#FFFFCC" />
            <PagerStyle BackColor="#FFFFCC" ForeColor="#330099" HorizontalAlign="Center" />
            <RowStyle BackColor="White" ForeColor="#330099" />
            <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="#663399" />
        </asp:GridView>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <asp:TextBox ID="txt_name" runat="server" CssClass="grd" Width="169px" 
            placeholder="نام"></asp:TextBox>
        <asp:TextBox ID="txt_last_name" runat="server" CssClass="grd" Width="169px" 
            placeholder="فامیلی"></asp:TextBox>
        <asp:TextBox ID="txt_code_melli" runat="server" CssClass="grd" Width="169px" 
            placeholder="کد ملی"></asp:TextBox>
        <asp:TextBox ID="txt_phone" runat="server" CssClass="grd" Width="169px" 
            placeholder="شماره تلفن"></asp:TextBox>
        <asp:TextBox ID="txt_username" runat="server" CssClass="grd" Width="169px" 
            placeholder="نام کاربری"></asp:TextBox>
        <asp:TextBox ID="txt_pass" runat="server" CssClass="grd" Width="169px" 
            placeholder="رمز عبور"></asp:TextBox>
        <asp:TextBox ID="txt_score" runat="server" CssClass="grd" Width="169px" 
            placeholder="امتیاز"></asp:TextBox>
        <asp:TextBox ID="txt_date" runat="server" CssClass="grd" Width="169px" 
            placeholder="تاریخ" Visible="False"></asp:TextBox>
        <asp:TextBox ID="txt_groups" runat="server" CssClass="grd" Width="169px" 
            placeholder="کروه ها" Visible="False" Enabled="False"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_ok_member" runat="server" Height="58px" Text="تأیید" 
            Width="154px" onclick="btn_ok_member_Click" />
        <br />
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:bazbim_dbConnectionString1 %>" 
            DeleteCommand="DELETE FROM [tbl_users] WHERE [r] = @r" 
            InsertCommand="INSERT INTO [tbl_users] ([username], [password], [score], [fname], [lname], [Date], [melicode], [phone_number], [groups]) VALUES (@username, @password, @score, @fname, @lname, @Date, @melicode, @phone_number, @groups)" 
            ProviderName="<%$ ConnectionStrings:bazbim_dbConnectionString1.ProviderName %>" 
            SelectCommand="SELECT [r], [username], [password], [score], [fname], [lname], [Date], [melicode], [phone_number], [groups] FROM [tbl_users]" 
            UpdateCommand="UPDATE [tbl_users] SET [username] = @username, [password] = @password, [score] = @score, [fname] = @fname, [lname] = @lname, [Date] = @Date, [melicode] = @melicode, [phone_number] = @phone_number, [groups] = @groups WHERE [r] = @r">
            <DeleteParameters>
                <asp:Parameter Name="r" Type="Int32" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="username" Type="String" />
                <asp:Parameter Name="password" Type="String" />
                <asp:Parameter Name="score" Type="String" />
                <asp:Parameter Name="fname" Type="String" />
                <asp:Parameter Name="lname" Type="String" />
                <asp:Parameter Name="Date" Type="String" />
                <asp:Parameter Name="melicode" Type="String" />
                <asp:Parameter Name="phone_number" Type="String" />
                <asp:Parameter Name="groups" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="username" Type="String" />
                <asp:Parameter Name="password" Type="String" />
                <asp:Parameter Name="score" Type="String" />
                <asp:Parameter Name="fname" Type="String" />
                <asp:Parameter Name="lname" Type="String" />
                <asp:Parameter Name="Date" Type="String" />
                <asp:Parameter Name="melicode" Type="String" />
                <asp:Parameter Name="phone_number" Type="String" />
                <asp:Parameter Name="groups" Type="String" />
                <asp:Parameter Name="r" Type="Int32" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <br />
        <br />
        <br />
        <asp:GridView ID="GridView2" runat="server" AllowPaging="True" 
            AllowSorting="True" AutoGenerateColumns="False" CssClass="grd" DataKeyNames="r" 
            DataSourceID="SqlDataSource2" 
            EmptyDataText="There are no data records to display." 
            EnableModelValidation="True" BackColor="White" BorderColor="#CC9966" 
            BorderStyle="None" BorderWidth="1px" CellPadding="4">
            <Columns>
                <asp:BoundField DataField="r" HeaderText="ردیف" ReadOnly="True" 
                    SortExpression="r" />
                <asp:BoundField DataField="group_number" HeaderText="شماره گروه" 
                    SortExpression="group_number" />
                <asp:BoundField DataField="user_number" HeaderText="تعداد اعضا" 
                    SortExpression="user_number" />
            </Columns>
            <FooterStyle BackColor="#FFFFCC" ForeColor="#330099" />
            <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="#FFFFCC" />
            <PagerStyle BackColor="#FFFFCC" ForeColor="#330099" HorizontalAlign="Center" />
            <RowStyle BackColor="White" ForeColor="#330099" />
            <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="#663399" />
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
            ConnectionString="<%$ ConnectionStrings:bazbim_dbConnectionString1 %>" 
            DeleteCommand="DELETE FROM [tbl_groups] WHERE [r] = @r" 
            InsertCommand="INSERT INTO [tbl_groups] ([group_number], [user_number]) VALUES (@group_number, @user_number)" 
            ProviderName="<%$ ConnectionStrings:bazbim_dbConnectionString1.ProviderName %>" 
            SelectCommand="SELECT [r], [group_number], [user_number] FROM [tbl_groups]" 
            UpdateCommand="UPDATE [tbl_groups] SET [group_number] = @group_number WHERE [r] = @r">
            <DeleteParameters>
                <asp:Parameter Name="r" Type="Int32" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="group_number" Type="String" />
                <asp:Parameter Name="user_number" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="group_number" Type="String" />
                <asp:Parameter Name="user_number" Type="String" />
                <asp:Parameter Name="r" Type="Int32" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <br />
    
    </div>
    <p style="direction: ltr">
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:TextBox ID="txt_grp_num" runat="server" CssClass="grd" Height="31px" 
            Width="235px" placeholder="شماره گروه"></asp:TextBox>
        <asp:Button ID="btn_add_grp" runat="server" Height="42px" 
            Text="اضافه کردن گروه" Width="175px" onclick="btn_add_grp_Click" />
    </p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:Button ID="btn_close_membership" runat="server" CssClass="grd" 
            Height="102px" Text="بستن عضویت" Width="328px" 
            onclick="btn_close_membership_Click" />
        <asp:Button ID="btn_open_membership" runat="server" Height="102px" 
            Text="بازکردن عضویت" Width="328px" onclick="btn_open_membership_Click" />
    </p>
    <p id="p_st" runat="server" style="color:Red;text-align:center;font-size:25px;">
        &nbsp;</p>
    </form>
</body>
</html>
