//using System;
//using System.Text;


   public class sec_Class_2
    {

         static string Base64Encode(string plainText)
        {
            var plainTextBytes = System.Text.Encoding.UTF8.GetBytes(plainText);
            return System.Convert.ToBase64String(plainTextBytes);
        }
         static string Base64Decode(string base64EncodedData)
        {
            var base64EncodedBytes = System.Convert.FromBase64String(base64EncodedData);
            return System.Text.Encoding.UTF8.GetString(base64EncodedBytes);
        }

        public string Encryption(string Val)
        {
            Val = Base64Encode(Val);
            Val = data_Encryption(Val);
            Val = Val.Substring(3, Val.Length - 3) + Val.Substring(0, 3);
            Val = Val.Substring(3, Val.Length - 3) + Val.Substring(0, 3);
            return Val;

        }
        public string Decryption(string Val)
        {
            Val = Val.Substring(Val.Length - 3, 3) + Val.Substring(0, Val.Length - 3);
            Val = Val.Substring(Val.Length - 3, 3) + Val.Substring(0, Val.Length - 3);
            Val = data_Decryption(Val);
            Val = Base64Decode(Val);
            return Val;
        }


        public string data_Encryption(string inp)
        {
            string txt = "", tx2, tx1 = inp;
            for (int i = 0; i < inp.Length; i++)
            {
                tx2 = tx1.Remove(1, tx1.Length - 1);
                tx1 = tx1.Remove(0, 1);
                txt += sina_ENC(tx2);
            }
            return txt;
        }


        public string sina_ENC(string v)
        {
            if (v == "0")
            {
                return "dsG";
            }
            else if (v == "1")
            {
                return "tqY";
            }
            else if (v == "2")
            {
                return "b8n";
            }
            else if (v == "3")
            {
                return "kmT";
            }
            else if (v == "4")
            {
                return "CV8";
            }
            else if (v == "5")
            {
                return "2pM";
            }
            else if (v == "7")
            {
                return "nAv";
            }
            else if (v == "8")
            {
                return "GAH";
            }
            else if (v == "9")
            {
                return "PJS";
            }
            else if (v == "a")
            {
                return "xNM";
            }
            else if (v == "b")
            {
                return "3v6";
            }
            else if (v == "c")
            {
                return "NFt";
            }
            else if (v == "d")
            {
                return "wmp";
            }
            else if (v == "e")
            {
                return "iMH";
            }
            else if (v == "f")
            {
                return "ECu";
            }
            else if (v == "g")
            {
                return "T63";
            }
            else if (v == "h")
            {
                return "p21";
            }
            else if (v == "i")
            {
                return "tGw";
            }
            else if (v == "j")
            {
                return "9OK";
            }
            else if (v == "k")
            {
                return "pvg";
            }
            else if (v == "l")
            {
                return "5Ms";
            }
            else if (v == "m")
            {
                return "bz6";
            }
            else if (v == "n")
            {
                return "04w";
            }
            else if (v == "o")
            {
                return "jSp";
            }
            else if (v == "p")
            {
                return "rpQ";
            }
            else if (v == "q")
            {
                return "DTd";
            }
            else if (v == "r")
            {
                return "OAY";
            }
            else if (v == "s")
            {
                return "0bm";
            }
            else if (v == "t")
            {
                return "mMM";
            }
            else if (v == "u")
            {
                return "wJo";
            }
            else if (v == "v")
            {
                return "1Xx";
            }
            else if (v == "w")
            {
                return "9Bv";
            }
            else if (v == "x")
            {
                return "pG3";
            }
            else if (v == "y")
            {
                return "Dv2";
            }
            else if (v == "z")
            {
                return "yCu";
            }
            else if (v == "A")
            {
                return "zw1";
            }
            else if (v == "B")
            {
                return "Hnx";
            }
            else if (v == "C")
            {
                return "4iw";
            }
            else if (v == "D")
            {
                return "01G";
            }
            else if (v == "E")
            {
                return "lPE";
            }
            else if (v == "F")
            {
                return "3I3";
            }
            else if (v == "G")
            {
                return "5mu";
            }
            else if (v == "H")
            {
                return "JAw";
            }
            else if (v == "I")
            {
                return "fMe";
            }
            else if (v == "J")
            {
                return "VHF";
            }
            else if (v == "K")
            {
                return "2Y9";
            }
            else if (v == "L")
            {
                return "9nX";
            }
            else if (v == "M")
            {
                return "OoP";
            }
            else if (v == "N")
            {
                return "Wgv";
            }
            else if (v == "O")
            {
                return "sHJ";
            }
            else if (v == "P")
            {
                return "RGL";
            }
            else if (v == "Q")
            {
                return "KCr";
            }
            else if (v == "R")
            {
                return "MaH";
            }
            else if (v == "S")
            {
                return "9S9";
            }
            else if (v == "T")
            {
                return "zWa";
            }
            else if (v == "U")
            {
                return "oS0";
            }
            else if (v == "V")
            {
                return "KMV";
            }
            else if (v == "W")
            {
                return "gn2";
            }
            else if (v == "X")
            {
                return "WkS";
            }
            else if (v == "Y")
            {
                return "dEl";
            }
            else if (v == "Z")
            {
                return "UJN";
            }
            else if (v == "~")
            {
                return "Fcy";
            }
            else if (v == "`")
            {
                return "5qg";
            }
            else if (v == "!")
            {
                return "w0V";
            }
            else if (v == "#")
            {
                return "FqJ";
            }
            else if (v == "$")
            {
                return "FtV";
            }
            else if (v == "%")
            {
                return "7tF";
            }
            else if (v == "^")
            {
                return "6MR";
            }
            else if (v == "&")
            {
                return "BDM";
            }
            else if (v == "*")
            {
                return "3mD";
            }
            else if (v == "(")
            {
                return "eRR";
            }
            else if (v == ")")
            {
                return "7xG";
            }
            else if (v == "_")
            {
                return "oTF";
            }
            else if (v == "-")
            {
                return "UnP";
            }
            else if (v == "=")
            {
                return "Mpv";
            }
            else if (v == "+")
            {
                return "vJ2";
            }
            else if (v == "/")
            {
                return "xlS";
            }
            else if (v == "?")
            {
                return "dhT";
            }
            else if (v == "<")
            {
                return "MbI";
            }
            else if (v == ">")
            {
                return "B5h";
            }
            else if (v == ".")
            {
                return "MJq";
            }
            else if (v == "{")
            {
                return "75Y";
            }
            else if (v == "}")
            {
                return "MlQ";
            }
            else if (v == "[")
            {
                return "Pr0";
            }
            else if (v == "]")
            {
                return "Oyh";
            }
            else if (v == ",")
            {
                return "EMH";
            }
            else if (v == "ا")
            {
                return "6mX";
            }
            else if (v == "آ")
            {
                return "E1P";
            }
            else if (v == "ب")
            {
                return "7Wp";
            }
            else if (v == "پ")
            {
                return "iXb";
            }
            else if (v == "ت")
            {
                return "lE4";
            }
            else if (v == "س")
            {
                return "qer";
            }
            else if (v == "ج")
            {
                return "9eX";
            }
            else if (v == "چ")
            {
                return "NwT";
            }
            else if (v == "ح")
            {
                return "0j4";
            }
            else if (v == "خ")
            {
                return "7gy";
            }
            else if (v == "د")
            {
                return "v9w";
            }
            else if (v == "ذ")
            {
                return "1fb";
            }
            else if (v == "ر")
            {
                return "mOo";
            }
            else if (v == "ز")
            {
                return "HQF";
            }
            else if (v == "ژ")
            {
                return "TDy";
            }
            else if (v == "س")
            {
                return "2MR";
            }
            else if (v == "ش")
            {
                return "1qJ";
            }
            else if (v == "ص")
            {
                return "Sqk";
            }
            else if (v == "ض")
            {
                return "5kl";
            }
            else if (v == "ط")
            {
                return "Hxi";
            }
            else if (v == "ظ")
            {
                return "27E";
            }
            else if (v == "ع")
            {
                return "7Tg";
            }
            else if (v == "غ")
            {
                return "DjO";
            }
            else if (v == "ف")
            {
                return "G8G";
            }
            else if (v == "ق")
            {
                return "hVQ";
            }
            else if (v == "ک")
            {
                return "vcW";
            }
            else if (v == "گ")
            {
                return "ujS";
            }
            else if (v == "ل")
            {
                return "vp2";
            }
            else if (v == "م")
            {
                return "kEl";
            }
            else if (v == "ن")
            {
                return "7Ts";
            }
            else if (v == "و")
            {
                return "9zk";
            }
            else if (v == "ه")
            {
                return "AQn";
            }
            else if (v == "ی")
            {
                return "DBX";
            }
            else if (v == "ء")
            {
                return "GGo";
            }
            else if (v == "ئ")
            {
                return "aIt";
            }
            else
            {
                return v + v + v;
            }
        }


        int lng = 3;



        public string data_Decryption(string inp)
        {
            string txt = "", tx2, tx1 = inp;
            for (int i = 0; i < inp.Length / lng; i++)
            {
                tx2 = tx1.Remove(lng, tx1.Length - lng);
                tx1 = tx1.Remove(0, lng);
                txt += sina_DEC(tx2);
            }
            return txt;
        }


        public string sina_DEC(string v)
        {
            if (v == "dsG")
            {
                return "0";
            }
            else if (v == "tqY")
            {
                return "1";
            }
            else if (v == "b8n")
            {
                return "2";
            }
            else if (v == "kmT")
            {
                return "3";
            }
            else if (v == "CV8")
            {
                return "4";
            }
            else if (v == "2pM")
            {
                return "5";
            }
            else if (v == "nAv")
            {
                return "7";
            }
            else if (v == "GAH")
            {
                return "8";
            }
            else if (v == "PJS")
            {
                return "9";
            }
            else if (v == "xNM")
            {
                return "a";
            }
            else if (v == "3v6")
            {
                return "b";
            }
            else if (v == "NFt")
            {
                return "c";
            }
            else if (v == "wmp")
            {
                return "d";
            }
            else if (v == "iMH")
            {
                return "e";
            }
            else if (v == "ECu")
            {
                return "f";
            }
            else if (v == "T63")
            {
                return "g";
            }
            else if (v == "p21")
            {
                return "h";
            }
            else if (v == "tGw")
            {
                return "i";
            }
            else if (v == "9OK")
            {
                return "j";
            }
            else if (v == "pvg")
            {
                return "k";
            }
            else if (v == "5Ms")
            {
                return "l";
            }
            else if (v == "bz6")
            {
                return "m";
            }
            else if (v == "04w")
            {
                return "n";
            }
            else if (v == "jSp")
            {
                return "o";
            }
            else if (v == "rpQ")
            {
                return "p";
            }
            else if (v == "DTd")
            {
                return "q";
            }
            else if (v == "OAY")
            {
                return "r";
            }
            else if (v == "0bm")
            {
                return "s";
            }
            else if (v == "mMM")
            {
                return "t";
            }
            else if (v == "wJo")
            {
                return "u";
            }
            else if (v == "1Xx")
            {
                return "v";
            }
            else if (v == "9Bv")
            {
                return "w";
            }
            else if (v == "pG3")
            {
                return "x";
            }
            else if (v == "Dv2")
            {
                return "y";
            }
            else if (v == "yCu")
            {
                return "z";
            }
            else if (v == "zw1")
            {
                return "A";
            }
            else if (v == "Hnx")
            {
                return "B";
            }
            else if (v == "4iw")
            {
                return "C";
            }
            else if (v == "01G")
            {
                return "D";
            }
            else if (v == "lPE")
            {
                return "E";
            }
            else if (v == "3I3")
            {
                return "F";
            }
            else if (v == "5mu")
            {
                return "G";
            }
            else if (v == "JAw")
            {
                return "H";
            }
            else if (v == "fMe")
            {
                return "I";
            }
            else if (v == "VHF")
            {
                return "J";
            }
            else if (v == "2Y9")
            {
                return "K";
            }
            else if (v == "9nX")
            {
                return "L";
            }
            else if (v == "OoP")
            {
                return "M";
            }
            else if (v == "Wgv")
            {
                return "N";
            }
            else if (v == "sHJ")
            {
                return "O";
            }
            else if (v == "RGL")
            {
                return "P";
            }
            else if (v == "KCr")
            {
                return "Q";
            }
            else if (v == "MaH")
            {
                return "R";
            }
            else if (v == "9S9")
            {
                return "S";
            }
            else if (v == "zWa")
            {
                return "T";
            }
            else if (v == "oS0")
            {
                return "U";
            }
            else if (v == "KMV")
            {
                return "V";
            }
            else if (v == "gn2")
            {
                return "W";
            }
            else if (v == "WkS")
            {
                return "X";
            }
            else if (v == "dEl")
            {
                return "Y";
            }
            else if (v == "UJN")
            {
                return "Z";
            }
            else if (v == "Fcy")
            {
                return "~";
            }
            else if (v == "5qg")
            {
                return "`";
            }
            else if (v == "w0V")
            {
                return "!";
            }
            else if (v == "FqJ")
            {
                return "#";
            }
            else if (v == "FtV")
            {
                return "$";
            }
            else if (v == "7tF")
            {
                return "%";
            }
            else if (v == "6MR")
            {
                return "^";
            }
            else if (v == "BDM")
            {
                return "&";
            }
            else if (v == "3mD")
            {
                return "*";
            }
            else if (v == "eRR")
            {
                return "(";
            }
            else if (v == "7xG")
            {
                return ")";
            }
            else if (v == "oTF")
            {
                return "_";
            }
            else if (v == "UnP")
            {
                return "-";
            }
            else if (v == "Mpv")
            {
                return "=";
            }
            else if (v == "vJ2")
            {
                return "+";
            }
            else if (v == "xlS")
            {
                return "/";
            }
            else if (v == "dhT")
            {
                return "?";
            }
            else if (v == "MbI")
            {
                return "<";
            }
            else if (v == "B5h")
            {
                return ">";
            }
            else if (v == "MJq")
            {
                return ".";
            }
            else if (v == "75Y")
            {
                return "{";
            }
            else if (v == "MlQ")
            {
                return "}";
            }
            else if (v == "Pr0")
            {
                return "[";
            }
            else if (v == "Oyh")
            {
                return "]";
            }
            else if (v == "EMH")
            {
                return ",";
            }
            else if (v == "6mX")
            {
                return "ا";
            }
            else if (v == "E1P")
            {
                return "آ";
            }
            else if (v == "7Wp")
            {
                return "ب";
            }
            else if (v == "iXb")
            {
                return "پ";
            }
            else if (v == "lE4")
            {
                return "ت";
            }
            else if (v == "qer")
            {
                return "س";
            }
            else if (v == "9eX")
            {
                return "ج";
            }
            else if (v == "NwT")
            {
                return "چ";
            }
            else if (v == "0j4")
            {
                return "ح";
            }
            else if (v == "7gy")
            {
                return "خ";
            }
            else if (v == "v9w")
            {
                return "د";
            }
            else if (v == "1fb")
            {
                return "ذ";
            }
            else if (v == "mOo")
            {
                return "ر";
            }
            else if (v == "HQF")
            {
                return "ز";
            }
            else if (v == "TDy")
            {
                return "ژ";
            }
            else if (v == "2MR")
            {
                return "س";
            }
            else if (v == "1qJ")
            {
                return "ش";
            }
            else if (v == "Sqk")
            {
                return "ص";
            }
            else if (v == "5kl")
            {
                return "ض";
            }
            else if (v == "Hxi")
            {
                return "ط";
            }
            else if (v == "27E")
            {
                return "ظ";
            }
            else if (v == "7Tg")
            {
                return "ع";
            }
            else if (v == "DjO")
            {
                return "غ";
            }
            else if (v == "G8G")
            {
                return "ف";
            }
            else if (v == "hVQ")
            {
                return "ق";
            }
            else if (v == "vcW")
            {
                return "ک";
            }
            else if (v == "ujS")
            {
                return "گ";
            }
            else if (v == "vp2")
            {
                return "ل";
            }
            else if (v == "kEl")
            {
                return "م";
            }
            else if (v == "7Ts")
            {
                return "ن";
            }
            else if (v == "9zk")
            {
                return "و";
            }
            else if (v == "AQn")
            {
                return "ه";
            }
            else if (v == "DBX")
            {
                return "ی";
            }
            else if (v == "GGo")
            {
                return "ء";
            }
            else if (v == "aIt")
            {
                return "ئ";
            }
            else
            {
                return v.Remove(1);
            }
        }
    }
