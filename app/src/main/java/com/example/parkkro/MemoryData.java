package com.example.parkkro;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class MemoryData {

    public static void saveddata(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("datata.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //

    public static void savedName(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("nameee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedVnum(String type, Context context){
        try{
            FileOutputStream fileOutputStream = context.openFileOutput("vnum.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(type.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void savedPhone(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("phonee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //

    public static String getData(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("datata.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    
    //

    public static String getName(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("nameee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getVnum(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("vnum.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getPhone(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("phonee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }


    //

    //slot

    public static void savedPaisa(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("paisa.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getPaisa(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("paisa.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }


    public static void savedType(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("type.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getType(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("type.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }


    public static void savedRpt(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("rpt.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getRpt(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("rpt.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static void savedSlot(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("Slot.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getSlot(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("Slot.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static void savedPaymentId(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("payment_id.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getPaymentId(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("payment_id.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

}
