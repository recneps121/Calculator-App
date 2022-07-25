package com.example.calculator;


public class NumericButtonData {
    private String value;
    private int row;
    private int column;
    private int size;

    public NumericButtonData(String value, int row, int column, int size) {
        this.value = value;
        this.row = row;
        this.column = column;
        this.size = size;
    }


    //Getters
    public String getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getSize() {
        return size;
    }
}
