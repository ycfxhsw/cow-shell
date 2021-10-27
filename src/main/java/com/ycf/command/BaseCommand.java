package com.ycf.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;

/**
 * @author ycf
 * @date 2021/10/27 15:13
 * @description TODO
 */
@ShellComponent
public class BaseCommand {

    @ShellMethod(key = "add", value = "求两数之和")
    public int sum(int a, int b) {
        return a + b;
    }

    @ShellMethod(key = "cowsay", value = "奶牛说话")
    public String cowSay(@ShellOption(defaultValue = "hello cow!", help = "小母牛要说的话") String say,
                         @ShellOption(value = {"-e", "-eye"}, defaultValue = "oo", help = "小母牛眼睛形状,默认为o") String eyes) {
        String cow = " __________________\n" +
                "< %s >\n" +
                " ------------------\n" +
                "        \\   ^__^\n" +
                "         \\  (%s)\\_______\n" +
                "            (__)\\       )\\/\\\n" +
                "                ||----w |\n" +
                "                ||     ||";
        String format = String.format(cow, say, eyes);
        return format;
    }

    @PostConstruct
    public void startHelp() {
        System.out.println("使用【help】命令查看帮助文档！");
    }
}
