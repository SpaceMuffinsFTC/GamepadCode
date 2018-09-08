package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.content.Intent;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DateFormat;
import java.util.Date;

class CodeSharer {
    Context context;

    public CodeSharer(Context ctx)
    {
        context=ctx;
    }

    public void share(String text) {
        //What to do, what text to send in
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");

        //What date to display when sent
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH:mm:ss");
        Date date = new Date();

        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "code_generated_"+dateFormat.format(date));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, codeForString(text));
        context.startActivity(sharingIntent);
    }

    //creating new string
    private String codeForString(String str) {
        String newString="\"";
        int charsInLine=0;

        //breaks line after 80 characters
        for(int i=0;i<str.length();i++)
        {

            newString+=str.charAt(i);
            charsInLine+=1;
            if(charsInLine>=80)
            {
                newString+="\"+\n\"";
                charsInLine=0;
            }
        }
        return newString+"\"";
    }
}
