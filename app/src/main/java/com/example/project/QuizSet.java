package com.example.project;

public class QuizSet {
    private  int n;
    private char q;
    private char a;
    private char b;
    private char c;
    private char d;

    public QuizSet(int n, char q, char a, char b, char c, char d) {
        this.n = n;
        this.q = q;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getN() {
        return n;
    }

    public char getQ() {
        return q;
    }

    public char getA() {
        return a;
    }

    public char getB() {
        return b;
    }

    public char getC() {
        return c;
    }

    public char getD() {
        return d;
    }
}

