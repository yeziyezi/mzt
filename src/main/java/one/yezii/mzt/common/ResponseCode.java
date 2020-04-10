package one.yezii.mzt.common;

public enum ResponseCode {
    ERROR_400(400, "Bad Request"),
    ERROR_404(404, "Not Found"),
    ERROR_500(500, "Internal Server Error"),
    ERROR_405(405, "Method Not Allowed"),
    ERROR_UNKNOWN(Integer.MAX_VALUE, "Error"),
    OK_200(200, "OK");
    private String message;
    private int code;

    ResponseCode(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public static ResponseCode ofCode(int code) {
        for (ResponseCode e : ResponseCode.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return ERROR_UNKNOWN;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
