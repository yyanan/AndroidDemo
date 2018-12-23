package com.example.accountabilitymodel;

public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int levenl){
        this.level=levenl;
    }
    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
