package com.ermanadary.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("test tag");


    }
}
