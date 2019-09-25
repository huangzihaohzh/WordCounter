package wordcounter.test;

import wordcounter.entity.TextFile;

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

    //测试TextFile.charNumCounter()
    
}
