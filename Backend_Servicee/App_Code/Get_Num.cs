using System;
using System.Text;

public class Get_Num
{
    public static int Get_Number_Chars(string text_Val, string spc_val)
    {
        bool is_ended = false;
        int rep_num = 0, x = -1;

        if (spc_val != "")
        {
            while (is_ended == false)
            {
                x = text_Val.IndexOf(spc_val, x + 1);
                if (x != -1)
                {
                    rep_num++;
                }
                else
                {
                    is_ended = true;
                }
            }
            return rep_num;
        }
        else
        {
            return 0;
        }
    }
}

