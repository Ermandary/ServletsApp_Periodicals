package com.ermanadary.Test;

import java.util.List;

public class Test2 {
    public List<String> list;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public static void main(String[] args) {
        Test2 q = new Test2();
        System.out.println(q.isStatus());

    }
}
