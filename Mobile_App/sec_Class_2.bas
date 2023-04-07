Type=Class
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
Sub Class_Globals
	Dim lng As Int	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
End Sub




Sub Encryption(Val As String) As String
	Dim bs As Base64
	Val=bs.EncodeStoS(Val,"UTF-8")
	Val=data_Encryption(Val)
	Val=Val.SubString2(3,Val.Length)&Val.SubString2(0,3)
	Val=Val.SubString2(3,Val.Length)&Val.SubString2(0,3)
	Return Val
End Sub

Sub Decryption(Val As String) As String
	Dim bs As Base64
	Val=Val.SubString2(Val.Length-3,Val.Length)&Val.SubString2(0,Val.Length-3)
	Val=Val.SubString2(Val.Length-3,Val.Length)&Val.SubString2(0,Val.Length-3)
	Val=data_Decryption(Val)
	Val=bs.DecodeStoS(Val,"UTF-8")
	Return Val
End Sub


Public Sub data_Encryption(t As String) As String

	Dim txt As String

	Dim tx1 As String = ""
	tx1 = ""
	Dim cec(t.Length) As String
	txt = t

	For i = 0 To t.Length - 1
		Dim x As String
		x = txt.Substring(txt.Length - 1)
		cec(i) = sina_ENC(x)
		txt = txt.SubString2(0, txt.Length - 1)
	Next
	tx1 = ""
	For j = 0 To cec.Length - 1
		tx1 = cec(j) & tx1

	Next

	'''''''''''''''''''''''''''''''''''''''''''''''''''''''
	Return tx1
End Sub



Public Sub sina_ENC(v As String) As String

	If v="0" Then
		Return "dsG"
	Else If v="1" Then
		Return "tqY"
	Else If v="2" Then
		Return "b8n"
	Else If v="3" Then
		Return "kmT"
	Else If v="4" Then
		Return "CV8"
	Else If v="5" Then
		Return "2pM"
	Else If v="7" Then
		Return "nAv"
	Else If v="8" Then
		Return "GAH"
	Else If v="9" Then
		Return "PJS"
	Else If v="a" Then
		Return "xNM"
	Else If v="b" Then
		Return "3v6"
	Else If v="c" Then
		Return "NFt"
	Else If v="d" Then
		Return "wmp"
	Else If v="e" Then
		Return "iMH"
	Else If v="f" Then
		Return "ECu"
	Else If v="g" Then
		Return "T63"
	Else If v="h" Then
		Return "p21"
	Else If v="i" Then
		Return "tGw"
	Else If v="j" Then
		Return "9OK"
	Else If v="k" Then
		Return "pvg"
	Else If v="l" Then
		Return "5Ms"
	Else If v="m" Then
		Return "bz6"
	Else If v="n" Then
		Return "04w"
	Else If v="o" Then
		Return "jSp"
	Else If v="p" Then
		Return "rpQ"
	Else If v="q" Then
		Return "DTd"
	Else If v="r" Then
		Return "OAY"
	Else If v="s" Then
		Return "0bm"
	Else If v="t" Then
		Return "mMM"
	Else If v="u" Then
		Return "wJo"
	Else If v="v" Then
		Return "1Xx"
	Else If v="w" Then
		Return "9Bv"
	Else If v="x" Then
		Return "pG3"
	Else If v="y" Then
		Return "Dv2"
	Else If v="z" Then
		Return "yCu"
	Else If v="A" Then
		Return "zw1"
	Else If v="B" Then
		Return "Hnx"
	Else If v="C" Then
		Return "4iw"
	Else If v="D" Then
		Return "01G"
	Else If v="E" Then
		Return "lPE"
	Else If v="F" Then
		Return "3I3"
	Else If v="G" Then
		Return "5mu"
	Else If v="H" Then
		Return "JAw"
	Else If v="I" Then
		Return "fMe"
	Else If v="J" Then
		Return "VHF"
	Else If v="K" Then
		Return "2Y9"
	Else If v="L" Then
		Return "9nX"
	Else If v="M" Then
		Return "OoP"
	Else If v="N" Then
		Return "Wgv"
	Else If v="O" Then
		Return "sHJ"
	Else If v="P" Then
		Return "RGL"
	Else If v="Q" Then
		Return "KCr"
	Else If v="R" Then
		Return "MaH"
	Else If v="S" Then
		Return "9S9"
	Else If v="T" Then
		Return "zWa"
	Else If v="U" Then
		Return "oS0"
	Else If v="V" Then
		Return "KMV"
	Else If v="W" Then
		Return "gn2"
	Else If v="X" Then
		Return "WkS"
	Else If v="Y" Then
		Return "dEl"
	Else If v="Z" Then
		Return "UJN"
	Else If v="~" Then
		Return "Fcy"
	Else If v="`" Then
		Return "5qg"
	Else If v="!" Then
		Return "w0V"
	Else If v="#" Then
		Return "FqJ"
	Else If v="$" Then
		Return "FtV"
	Else If v="%" Then
		Return "7tF"
	Else If v="^" Then
		Return "6MR"
	Else If v="&" Then
		Return "BDM"
	Else If v="*" Then
		Return "3mD"
	Else If v="(" Then
		Return "eRR"
	Else If v=")" Then
		Return "7xG"
	Else If v="_" Then
		Return "oTF"
	Else If v="-" Then
		Return "UnP"
	Else If v="=" Then
		Return "Mpv"
	Else If v="+" Then
		Return "vJ2"
	Else If v="/" Then
		Return "xlS"
	Else If v="?" Then
		Return "dhT"
	Else If v="<" Then
		Return "MbI"
	Else If v=">" Then
		Return "B5h"
	Else If v="." Then
		Return "MJq"
	Else If v="{" Then
		Return "75Y"
	Else If v="}" Then
		Return "MlQ"
	Else If v="[" Then
		Return "Pr0"
	Else If v="]" Then
		Return "Oyh"
	Else If v="," Then
		Return "EMH"
	Else If v="ا" Then
		Return "6mX"
	Else If v="آ" Then
		Return "E1P"
	Else If v="ب" Then
		Return "7Wp"
	Else If v="پ" Then
		Return "iXb"
	Else If v="ت" Then
		Return "lE4"
	Else If v="س" Then
		Return "qer"
	Else If v="ج" Then
		Return "9eX"
	Else If v="چ" Then
		Return "NwT"
	Else If v="ح" Then
		Return "0j4"
	Else If v="خ" Then
		Return "7gy"
	Else If v="د" Then
		Return "v9w"
	Else If v="ذ" Then
		Return "1fb"
	Else If v="ر" Then
		Return "mOo"
	Else If v="ز" Then
		Return "HQF"
	Else If v="ژ" Then
		Return "TDy"
	Else If v="س" Then
		Return "2MR"
	Else If v="ش" Then
		Return "1qJ"
	Else If v="ص" Then
		Return "Sqk"
	Else If v="ض" Then
		Return "5kl"
	Else If v="ط" Then
		Return "Hxi"
	Else If v="ظ" Then
		Return "27E"
	Else If v="ع" Then
		Return "7Tg"
	Else If v="غ" Then
		Return "DjO"
	Else If v="ف" Then
		Return "G8G"
	Else If v="ق" Then
		Return "hVQ"
	Else If v="ک" Then
		Return "vcW"
	Else If v="گ" Then
		Return "ujS"
	Else If v="ل" Then
		Return "vp2"
	Else If v="م" Then
		Return "kEl"
	Else If v="ن" Then
		Return "7Ts"
	Else If v="و" Then
		Return "9zk"
	Else If v="ه" Then
		Return "AQn"
	Else If v="ی" Then
		Return "DBX"
	Else If v="ء" Then
		Return "GGo"
	Else If v="ئ" Then
		Return "aIt"
	Else
		Return v & v & v
	End If
End Sub


'''''''''''''
' Dim lng As Int
'''''''''''''



Public Sub data_Decryption( t As String) As String
	lng =3


	Dim txt As String

	Dim tx2 As String
	Dim cdc(t.Length) As String

	txt = t

	For n = 0 To t.Length / lng - 1
		Dim x As String
		x = txt.Substring(txt.Length - lng)
		cdc(n) = sina_DEC(x)
		txt = txt.SubString2(0, txt.Length - lng)
	Next

	For b = 0 To cdc.Length - 1
		tx2 = cdc(b) & tx2
	Next
	''''''''''''''''''''
	Return tx2
End Sub


Public Sub sina_DEC(v As String) As String
	If v="dsG" Then
		Return "0"
	Else If v="tqY" Then
		Return "1"
	Else If v="b8n" Then
		Return "2"
	Else If v="kmT" Then
		Return "3"
	Else If v="CV8" Then
		Return "4"
	Else If v="2pM" Then
		Return "5"
	Else If v="nAv" Then
		Return "7"
	Else If v="GAH" Then
		Return "8"
	Else If v="PJS" Then
		Return "9"
	Else If v="xNM" Then
		Return "a"
	Else If v="3v6" Then
		Return "b"
	Else If v="NFt" Then
		Return "c"
	Else If v="wmp" Then
		Return "d"
	Else If v="iMH" Then
		Return "e"
	Else If v="ECu" Then
		Return "f"
	Else If v="T63" Then
		Return "g"
	Else If v="p21" Then
		Return "h"
	Else If v="tGw" Then
		Return "i"
	Else If v="9OK" Then
		Return "j"
	Else If v="pvg" Then
		Return "k"
	Else If v="5Ms" Then
		Return "l"
	Else If v="bz6" Then
		Return "m"
	Else If v="04w" Then
		Return "n"
	Else If v="jSp" Then
		Return "o"
	Else If v="rpQ" Then
		Return "p"
	Else If v="DTd" Then
		Return "q"
	Else If v="OAY" Then
		Return "r"
	Else If v="0bm" Then
		Return "s"
	Else If v="mMM" Then
		Return "t"
	Else If v="wJo" Then
		Return "u"
	Else If v="1Xx" Then
		Return "v"
	Else If v="9Bv" Then
		Return "w"
	Else If v="pG3" Then
		Return "x"
	Else If v="Dv2" Then
		Return "y"
	Else If v="yCu" Then
		Return "z"
	Else If v="zw1" Then
		Return "A"
	Else If v="Hnx" Then
		Return "B"
	Else If v="4iw" Then
		Return "C"
	Else If v="01G" Then
		Return "D"
	Else If v="lPE" Then
		Return "E"
	Else If v="3I3" Then
		Return "F"
	Else If v="5mu" Then
		Return "G"
	Else If v="JAw" Then
		Return "H"
	Else If v="fMe" Then
		Return "I"
	Else If v="VHF" Then
		Return "J"
	Else If v="2Y9" Then
		Return "K"
	Else If v="9nX" Then
		Return "L"
	Else If v="OoP" Then
		Return "M"
	Else If v="Wgv" Then
		Return "N"
	Else If v="sHJ" Then
		Return "O"
	Else If v="RGL" Then
		Return "P"
	Else If v="KCr" Then
		Return "Q"
	Else If v="MaH" Then
		Return "R"
	Else If v="9S9" Then
		Return "S"
	Else If v="zWa" Then
		Return "T"
	Else If v="oS0" Then
		Return "U"
	Else If v="KMV" Then
		Return "V"
	Else If v="gn2" Then
		Return "W"
	Else If v="WkS" Then
		Return "X"
	Else If v="dEl" Then
		Return "Y"
	Else If v="UJN" Then
		Return "Z"
	Else If v="Fcy" Then
		Return "~"
	Else If v="5qg" Then
		Return "`"
	Else If v="w0V" Then
		Return "!"
	Else If v="FqJ" Then
		Return "#"
	Else If v="FtV" Then
		Return "$"
	Else If v="7tF" Then
		Return "%"
	Else If v="6MR" Then
		Return "^"
	Else If v="BDM" Then
		Return "&"
	Else If v="3mD" Then
		Return "*"
	Else If v="eRR" Then
		Return "("
	Else If v="7xG" Then
		Return ")"
	Else If v="oTF" Then
		Return "_"
	Else If v="UnP" Then
		Return "-"
	Else If v="Mpv" Then
		Return "="
	Else If v="vJ2" Then
		Return "+"
	Else If v="xlS" Then
		Return "/"
	Else If v="dhT" Then
		Return "?"
	Else If v="MbI" Then
		Return "<"
	Else If v="B5h" Then
		Return ">"
	Else If v="MJq" Then
		Return "."
	Else If v="75Y" Then
		Return "{"
	Else If v="MlQ" Then
		Return "}"
	Else If v="Pr0" Then
		Return "["
	Else If v="Oyh" Then
		Return "]"
	Else If v="EMH" Then
		Return ","
	Else If v="6mX" Then
		Return "ا"
	Else If v="E1P" Then
		Return "آ"
	Else If v="7Wp" Then
		Return "ب"
	Else If v="iXb" Then
		Return "پ"
	Else If v="lE4" Then
		Return "ت"
	Else If v="qer" Then
		Return "س"
	Else If v="9eX" Then
		Return "ج"
	Else If v="NwT" Then
		Return "چ"
	Else If v="0j4" Then
		Return "ح"
	Else If v="7gy" Then
		Return "خ"
	Else If v="v9w" Then
		Return "د"
	Else If v="1fb" Then
		Return "ذ"
	Else If v="mOo" Then
		Return "ر"
	Else If v="HQF" Then
		Return "ز"
	Else If v="TDy" Then
		Return "ژ"
	Else If v="2MR" Then
		Return "س"
	Else If v="1qJ" Then
		Return "ش"
	Else If v="Sqk" Then
		Return "ص"
	Else If v="5kl" Then
		Return "ض"
	Else If v="Hxi" Then
		Return "ط"
	Else If v="27E" Then
		Return "ظ"
	Else If v="7Tg" Then
		Return "ع"
	Else If v="DjO" Then
		Return "غ"
	Else If v="G8G" Then
		Return "ف"
	Else If v="hVQ" Then
		Return "ق"
	Else If v="vcW" Then
		Return "ک"
	Else If v="ujS" Then
		Return "گ"
	Else If v="vp2" Then
		Return "ل"
	Else If v="kEl" Then
		Return "م"
	Else If v="7Ts" Then
		Return "ن"
	Else If v="9zk" Then
		Return "و"
	Else If v="AQn" Then
		Return "ه"
	Else If v="DBX" Then
		Return "ی"
	Else If v="GGo" Then
		Return "ء"
	Else If v="aIt" Then
		Return "ئ"
	Else
		Return v.Substring(v.Length - 1)
	End If

End Sub