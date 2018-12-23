package com.example.accountabilitymodel;

public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger=new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger=new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoLogger=new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoLogger);

        return errorLogger;
    }
    public static void main(String[] args){
        AbstractLogger loggerChain=getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO,"青山");
        loggerChain.logMessage(AbstractLogger.DEBUG,"绿水");
        loggerChain.logMessage(AbstractLogger.ERROR,"长流");
    }
}
