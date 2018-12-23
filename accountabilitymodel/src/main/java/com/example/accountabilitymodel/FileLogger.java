package com.example.accountabilitymodel;

public class FileLogger extends AbstractLogger {
    public FileLogger(int levenl){
        this.level=levenl;
    }
    @Override
    protected void write(String message) {
        System.out.println("File Console::Logger: " + message);
    }
}
