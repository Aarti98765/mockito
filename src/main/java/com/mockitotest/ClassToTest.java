package com.mockitotest;

public class ClassToTest {
    private final MyDataBase myDataBase;

    public boolean query(String query) {
        return this.myDataBase.query(query);
    }

    public ClassToTest(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }
}

