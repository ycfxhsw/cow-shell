package com.ycf.command;

import com.ycf.symbol.Symbol;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author ycf
 */
@ShellComponent
@ShellCommandGroup("Custom")
public class CustomCommand {
    @ShellMethod(key = "cowsay", value = "小母牛说话")
    public String cowSay(@ShellOption(defaultValue = "hello cow!", help = "小母牛要说的话") String say,
                         @ShellOption(value = {"-e", "-eye"}, defaultValue = "oo", help = "小母牛眼睛形状,默认为oo") String eyes) {
        return Symbol.cowSayService(say, eyes, "src\\main\\resources\\symbol\\cow.txt");
    }

    @ShellMethod(key = {"cow-b", "cow-buddha"}, value = "佛祖像")
    public String buddha() {
        return Symbol.getContent("src\\main\\resources\\symbol\\buddha.txt");
    }
}
