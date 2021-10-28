package com.ycf.command;

import com.ycf.symbol.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("Custom")
public class CustomCommand {
    @Autowired
    Symbol symbol;

    @ShellMethod(key = "add", value = "求两数之和")
    public int sum(int a, int b) {
        return a + b;
    }

    @ShellMethod(key = "cowsay", value = "小母牛说话")
    public String cowSay(@ShellOption(defaultValue = "hello cow!", help = "小母牛要说的话") String say,
                         @ShellOption(value = {"-e", "-eye"}, defaultValue = "oo", help = "小母牛眼睛形状,默认为oo") String eyes) {
        return symbol.cowSay(say, eyes);
    }
}
