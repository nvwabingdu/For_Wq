package com.example.myapplication.android.utils;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-10-28
 * Time: 21:16
 */
class UtilsFile {
    /**
     * @param filePath 文件路径
     *                 递归遍历文件   未完……
     */
    public static void traverseTheDocument(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File f : fileList) {
                    if (f.isDirectory()) {
                        /*Log.e("TAG",f.getName());*/
                        traverseTheDocument(f.getAbsolutePath());
                    } else {
                        /*Log.e("TAG", f.getAbsolutePath());*/
                        transformCode("D:" + File.separator + "奇记图书馆" + File.separator + "目录.txt", f.getAbsolutePath());
                    }
                }
            }
        } else {
            Log.e("TAG", "文件不存在!");
        }
    }

    /**
     * @param txtFilePath 一个txt文件路径
     * @param content     io流中乱码的文字
     *                    用于把读取的乱码文字重新转换成UTF-8编码格式     未完……
     */
    public static void transformCode(String txtFilePath, String content) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFilePath, true), "UTF-8"));
            out.write(content + "\r\n");//可选择不换行
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void creatFile(String filePath) throws Exception {
        File f = new File(filePath);
        f.exists();//文件或目录是否存在
        f.isFile();//是否是文件
        f.isDirectory();//是否是目录
        f.getName();//获取文件或目录的名字
        f.lastModified();//获取最后的修改日期
        f.length();//获取文件大小，字节为单位
        f.list();//如果对象是目录，则返回目录下所有文件和目录名字的列表 String对象
        f.listFiles();//返回此目录下面所有 文件和目录  File对象

        f.mkdir();//----创建File中的目录(就是文件夹)
        f.mkdirs();//----创建File中的目录，如果父目录不存在，还会创建父目录
        f.renameTo(new File("D:" + File.separator + "dsd.txt"));//修改文件的名称，会删除原文件
        f.createNewFile();//如果File代表文件，则创建一个空文件
        f.delete();//删除文件或目录(如果目录下包吨子目录或文件，则不能删除)

        f.renameTo(new File(""));//重命名
        f.setReadOnly();//设置为只读

    }

    /**
     * @param filePath
     * @return 遍历文件夹
     * @throws Exception
     */
    public static ArrayList<String> listAllFiles(String filePath) throws Exception {
        File file = new File(filePath);
        ArrayList<String> fList = new ArrayList<>();
        if (file.exists()) {
            if (file != null) {
                File[] fileslist = file.listFiles();
                for (File f : fileslist) {
                    if (f.isDirectory()) {
                        listAllFiles(f.toString());//递归
                        fList.add(f.getAbsolutePath());//添加目录
                    } else {
                        fList.add(f.getAbsolutePath());//添加文件
                    }
                }
            }
        }
        return fList;
    }

    /**
     * @param filePath
     * @param dirPath
     * @param dirsPath
     * @return 文件的增加
     * @throws Exception
     */
    public static Boolean addFile(String filePath, String dirPath, String dirsPath) throws Exception {
        if (!filePath.equals("")) {
            File f = new File(filePath);
            return f.createNewFile();//创建文件
        } else if (!dirPath.equals("")) {
            File f = new File(dirPath);
            return f.mkdir();//创建文件夹
        } else if (!dirsPath.equals("")) {
            File f = new File(dirsPath);
            return f.mkdirs();//创建多重文件夹
        }
        return false;
    }

    /**
     * @param filePath
     * @return 文件的删除
     * @throws Exception
     */
    public static Boolean delFile(String filePath) throws Exception {
        File f = new File(filePath);
        if (f.exists()) {
            f.delete();
        }
        return false;
    }

    public static void updateFile(String filePath) throws Exception {
        File f = new File(filePath);

    }

    public static void m1() throws Exception {
        File file = new File("C:" + File.separator + "Users" + File.separator + "86182" + File.separator + "Desktop" + File.separator + "2222.txt");
        BufferedReader b= new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        while ((line = b.readLine()) != null) {
            System.out.print(line + "\r\n");
        }
        b.close();
    }

    public static void m2() throws Exception {
        File file = new File("C:" + File.separator + "Users" + File.separator + "86182" + File.separator + "Desktop" + File.separator + "2222.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        bufferedWriter.write("您好好");//覆盖式写法
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void m3() throws Exception {
        //RandomAccessFile
        //随机访问文件流，自身具备读写的方法。
        //通过skipBytes(int x),seek(int x)来达到随机访问。
        //注意：用RandomAccessFile来操作文件的时候,由于对占两个字节的字符可能出现截断的情况，所以只建议操作字节型文件
        //操作文字，也就是字符型数据，要出错。
        File file = new File("C:" + File.separator + "Users" + File.separator + "86182" + File.separator + "Desktop" + File.separator + "2222.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        long filelength = randomAccessFile.length();
        randomAccessFile.seek(filelength);
        randomAccessFile.writeBytes("12345678");
        randomAccessFile.close();
    }
}
