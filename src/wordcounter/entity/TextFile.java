package wordcounter.entity;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class TextFile {

    private String filePath = null;
    private File file = null;
    private FileInputStream fileStream = null;
    private InputStreamReader streamReader = null;
    private StringBuffer stringBuffer = new StringBuffer();
    private Stream<String> stringStream = null;


    /**
     * 通过接收String类型的文件路径来构建TextFile对象
     */
    public TextFile(String aTextFilePath) throws FileNotFoundException,IOException,NullPointerException{
        this.filePath = aTextFilePath;
        this.file = new File(this.filePath);
        this.fileStream = new FileInputStream(this.file);    // throws FileNotFindException
        this.streamReader = new InputStreamReader(fileStream,Charset.forName("UTF-8"));

        //创建char数组和StringBuffer作为缓冲区，将char数组不断写入StringBuffer中
        char[] charTemp = new char[1];
        while(streamReader.read(charTemp) > -1){
            this.stringBuffer.append(charTemp);
        }
        this.stringStream = Stream.of(this.stringBuffer.toString());
    }

    /**
     * 计算文件字符数
     */
    public  int charNumCounter() {
        int charNum = 0;
        //charNum = (int) this.stringStream.filter(str->str.matches(".")).count();
        charNum = (int) this.stringBuffer.toString().toCharArray().length;
        return charNum;
    }

    /**
     * 计算文件单词数
     */
    public int wordNumCounter() {
        //String wordRegex = "\\b[a-zA-Z]+";
        String wordRegex = "\\b";
        int wordNum = 0;
        //wordNum = (int) stringStream.filter(word->word.matches(wordRegex)).count();
        String[] temp = stringBuffer.toString().split(wordRegex);
        for(String str:temp){
            if(str.matches("\\b[a-zA-Z]+"))
                wordNum++;
        }
        return wordNum;
    }

    /**
     * 计算文件行数
     *
     */
    public int lineNumCounter() throws IOException{
        return stringBuffer.toString().split("\\n").length;
    }
}
