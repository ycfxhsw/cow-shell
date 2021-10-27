package com.ycf.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * @author ycf
 * @date 2021/10/27 15:25
 * @description TODO
 */
@Component
public class CustomPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        AttributedString attributedString = new AttributedString("cow-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
        return attributedString;
    }
}
