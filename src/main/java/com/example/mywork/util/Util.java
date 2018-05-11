package com.example.mywork.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;

/**
 * Created by midas on 2017-05-15.
 */

public class Util
{
    //----------------------------------------------------------------------------------------------------
    // Convert String To URL Encoding String
    public static String EncodeUrlString(String strSource, boolean bExceptUrlChar, String strTextType)
    {
        if( strSource == null )
            return "";

        // Set Text Encoding Type
        if( strTextType == null || strTextType.length() <= 0 )
            strTextType = "UTF-8";

        String strEncode = "";
        try
        {
            // Parsing Source
            if( bExceptUrlChar == false )
            {
                // Full
                strEncode = URLEncoder.encode(strSource, strTextType);
            }
            else
            {
                // Except >> ':/ ?=&'
                String strWord = "";
                int nTextCnt = strSource.length();
                for(int i = 0; i < nTextCnt; i++)
                {
                    char szChar = strSource.charAt(i);
                    if( szChar == ':' )
                    {
                        strEncode += URLEncoder.encode(strWord, strTextType);
                        strEncode += ":";
                        strWord = "";
                    }
                    else if( szChar == '/' )
                    {
                        strEncode += URLEncoder.encode(strWord, strTextType);
                        strEncode += "/";
                        strWord = "";
                    }
                    else if( szChar == ' ' )
                    {
                        strEncode += URLEncoder.encode(strWord, strTextType);
                        strEncode += " ";
                        strWord = "";
                    }
                    else if( szChar == '?' )
                    {
                        strEncode += URLEncoder.encode(strWord, strTextType);
                        strEncode += "?";
                        strWord = "";
                    }
                    else if( szChar == '=' )
                    {
                        strEncode += URLEncoder.encode(strWord, strTextType);
                        strEncode += "=";
                        strWord = "";
                    }
                    else if( szChar == '&' )
                    {
                        strEncode += URLEncoder.encode(strWord, strTextType);
                        strEncode += "&";
                        strWord = "";
                    }
                    else
                    {
                        strWord += "" + szChar;
                    }
                }

                if( strWord.length() > 0 )
                    strEncode += URLEncoder.encode(strWord, strTextType);
            }
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            strEncode = "";
        }

        return strEncode;
    }

    //----------------------------------------------------------------------------------------------------
    // String Encodig Base64
    public static String EncodeBase64String(String strString)
    {
        if( strString == null || strString.length() <= 0 )
            return "";

        // Convert String -> byte[]
        byte[] btSource = new byte[strString.length()];
        btSource = strString.getBytes();

        // Base64 Encoding
        byte[] btResult = null;
        try
        {
            Class pBase64 = Class.forName("org.apache.commons.codec.binary.Base64");            
            Class[] pParameterTypes = new Class[] { byte[].class };
            Method pEncodeBase64 = pBase64.getMethod("encodeBase64", pParameterTypes);

            btResult = (byte[])pEncodeBase64.invoke(pBase64, btSource);            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        // Check Result
        if( btResult == null )
            return "";

        // Convert byte[] -> String
        String strResult = new String(btResult);
        return strResult;
    }

    //----------------------------------------------------------------------------------------------------
    // String Decoding Base64
    public static String DecodeBase64String(String strString)
    {
        if( strString == null || strString.length() <= 0 )
            return "";

        // Convert String -> byte[]
        byte[] btSource = new byte[strString.length()];
        btSource = strString.getBytes();

        // Base64 Encoding
        byte[] btResult = null;
        try
        {
            Class pBase64 = Class.forName("org.apache.commons.codec.binary.Base64");
            Class[] pParameterTypes = new Class[] { byte[].class };
            Method pDecodeBase64 = pBase64.getMethod("decodeBase64", pParameterTypes);

            btResult = (byte[])pDecodeBase64.invoke(pBase64, btSource);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        // Check Result
        if( btResult == null )
            return "";

        // Convert byte[] -> String
        String strResult = new String(btResult);
        return strResult;
    }
}
