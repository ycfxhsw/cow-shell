package com.ycf.command;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.annotation.PostConstruct;

/**
 * @author ycf
 * @date 2021/10/27 15:13
 * @description TODO
 */
@ShellComponent
@ShellCommandGroup("Base")
public class BaseCommand {
    @Value("${application.formatted-version}")
    private String version;

    @ShellMethod(key = {"cow -v", "cow -version"}, value = "查看版本号.")
    public String version() {
        return version;
    }

    @PostConstruct
    public void startHelp() {
        System.out.println("使用【help】命令查看帮助文档！");
    }
}
