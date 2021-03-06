package com.sam.base;

/**
 * API格式封装
 */
public class APIResponse {

    private int code;
    private String message;
    private Object data;
    private boolean more;

    public APIResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public APIResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static APIResponse ofMessage(int code,String message){
        return new APIResponse(code, message, null);
    }

    public static APIResponse ofSuccess(Object data){

        return new APIResponse(Status.SUCCESS.getCode(),Status.SUCCESS.getStandardMessage(),data);

    }

    public static APIResponse ofStatus(Status status) {
        return new APIResponse(status.getCode(), status.getStandardMessage(), null);
    }

    public enum Status {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "BAD REQUEST"),
        INTERNAL_SERVER_ERROR(500, "UNKNOWN INTERNAL ERROR"),
        NOT_VALID_PARAM(40005, "NOT VALID PARAMS"),
        NOT_SUPPORTED_OPERATION(40005, "OPERATION NOT SUPPORTED"),
        NOT_LOGIN(50000, "NOT LOGIN"),;

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}
