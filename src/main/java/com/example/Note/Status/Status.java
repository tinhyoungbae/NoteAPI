package com.example.Note.Status;

public class Status {
    private final static String statusOk = "Ok";
    private final static String statusError = "Error";
    private final static String messageOk = "Query Successfully";
    private final static String messageError = "Something went wrong!!!";

    public Status(){

    }

    public static String getStatusOk() {
        return statusOk;
    }

    public static String getStatusError() {
        return statusError;
    }

    public static String getMessageOk() {
        return messageOk;
    }

    public static String getMessageError() {
        return messageError;
    }
}
