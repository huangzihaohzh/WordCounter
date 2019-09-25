package wordcounter.test;

import wordcounter.entity.TextFile;

import java.io.IOException;

public class Test {
    private TextFile textFile = null;

    //Constructor
    public Test(String filePath) throws Exception{
        this.textFile = new TextFile(filePath);
    }

    //测试TextFile.charNumCounter()
    public void testCharNumCounter(){
        int charNum = textFile.charNumCounter();
        if(charNum>=0)
            System.out.println("文件字符数为："+charNum);
        else
            System.out.println("字符数计算出错");
    }

    //测试TextFile.wordNumCounter()
    public void testWordNumCounter(){
        int wordNum = textFile.wordNumCounter();
        if(wordNum>=0)
            System.out.println("文件单词数为："+wordNum);
        else
            System.out.println("单词计算出错");
    }

    //测试TextFile.lineNumCounter()
    public void testLineNumCounter() throws IOException {
        int lineNum = textFile.lineNumCounter();
        if(lineNum>=0)
            System.out.println("文件行数为："+lineNum);
        else
            System.out.println("行数计算错误");
    }
}
