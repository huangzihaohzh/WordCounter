package wordcounter.view;



import wordcounter.entity.TextFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class main {

    public static void main(String args[]) {
        /*
        解析用户输入参数,并根据用户输入的参数调用不同方法，并显示结果
        用户需求模式 wc.exe [parameter] [file_name]
        基本功能列表：
        wc.exe -c file.c     //返回文件 file.c 的字符数
        wc.exe -w file.c    //返回文件 file.c 的词的数目
        wc.exe -l file.c      //返回文件 file.c 的行数
         */
        //检验参数是否有效，并保存为parameter和fileName两部分
        ArrayList<String> parameters = new ArrayList<String>();
        String fileName = null;
        String parameterRegex = "-[cwlsa]";
        String fileNameRegex = "^[^-]\\S+$";
        for (String arg : args) {
            //判断是否为参数
            if (Pattern.matches(parameterRegex,arg )) {
                parameters.add(arg);
            }
            //判断是否为地址或文件名
            if (Pattern.matches(fileNameRegex,arg)) {
                fileName = arg;
            }
        }
        //判断参数是否齐全
        if (parameters.isEmpty()) {
            System.out.println("缺少参数");
            printHelp();
            return;
        }
        if (fileName == null) {
            System.out.println("缺少文件名");
            printHelp();
            return;
        }
        //根据用户输入执行不同的计算
        try{
            TextFile textFile = new TextFile(fileName);
            for(String arg:parameters){
                //用户选项为“-c”
                if(arg.equals("-c")){
                    int charNum = textFile.charNumCounter();
                    if(charNum>=0)
                        System.out.println("文件字符数为："+charNum);
                    else
                        System.out.println("字符数计算出错");
                }
                //用户选项为“-w”
                if(arg.equals("-w")){
                    int wordNum = textFile.wordNumCounter();
                    if(wordNum>=0)
                        System.out.println("文件单词数为："+wordNum);
                    else
                        System.out.println("单词计算出错");
                }
                //用户选项为“-l”
                if(arg.equals("-l")){
                    int lineNum = textFile.lineNumCounter();
                    if(lineNum>=0)
                        System.out.println("文件行数为："+lineNum);
                    else
                        System.out.println("行数计算错误");
                }
            }
        } catch(FileNotFoundException fileNotFindException) {
            System.out.println("文件不存在");
            fileNotFindException.printStackTrace();
        } catch(IOException IOEx) {
            System.out.println("I/O错误");
            IOEx.printStackTrace();
        }

    }

    //显示帮助
    private static void printHelp() {
        String help = "Help:\n" +
                "wc.exe [参数] [文件名]\n" +
                "可选的参数：\n" +
                "    -c    返回对应文件的字符数\n" +
                "    -w    返回对应文件的词数\n" +
                "    -l    返回对应文件的行数\n" +
                "文件名：\n" +
                "    首字符不能为“-”";
        System.out.println(help);
    }
}
