package com.ycf.command;

import com.ycf.symbol.Symbol;
import org.springframework.core.io.ClassPathResource;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.IOException;

/**
 * @author ycf
 */
@ShellComponent
@ShellCommandGroup("Custom")
public class CustomCommand {
    @ShellMethod(key = "cowsay", value = "小母牛说话")
    public String cowSay(@ShellOption(defaultValue = "hello cow!", help = "小母牛要说的话") String say,
                         @ShellOption(value = {"-e", "-eye"}, defaultValue = "oo", help = "小母牛眼睛形状,默认为oo") String eyes) {
        ClassPathResource cpr = new ClassPathResource("symbol/cow.txt");
        String path = null;
        try {
            path = cpr.getURL().getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Symbol.cowSayService(say, eyes, path);
    }

    @ShellMethod(key = {"cow -b", "cow -buddha"}, value = "佛祖像")
    public String buddha() {
        ClassPathResource cpr = new ClassPathResource("symbol/buddha.txt");
        String path = null;
        try {
            path = cpr.getURL().getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Symbol.getContent(path);
    }

    @ShellMethod(key = {"cow -c", "cow -custom"}, value = "自定义图像【e.g: -c custom.txt】")
    public String custom(@ShellOption(value = {"-p", "-path"}, help = "自定义图像文本路径名【e.g: c:/custom.txt】") String path) {
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        return Symbol.getContent(absolutePath);
    }
}
