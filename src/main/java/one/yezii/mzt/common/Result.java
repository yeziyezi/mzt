package one.yezii.mzt.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Optional;

public class Result extends HashMap<String, Object> {

    public static Result ok() {
        return new Result().setCode(ResponseCode.OK_200.getCode()).setMessage("success");
    }

    public static Result error(ResponseCode responseCode) {
        return new Result().setCode(responseCode.getCode()).setMessage(responseCode.getMessage());
    }

    public static Result error400() {
        return error(ResponseCode.ERROR_400);
    }

    public boolean notOk() {
        return !isOk();
    }

    public boolean isOk() {
        return getCode().equals(ResponseCode.OK_200);
    }

    public Optional<Object> get(String key) {
        return Optional.ofNullable(super.get(key));
    }

    public Result set(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Optional<Integer> getInteger(String key) {
        return getString(key).map(Integer::valueOf);
    }

    public Optional<String> getString(String key) {
        return get(key).map(Object::toString);
    }

    public ResponseCode getCode() {
        return ResponseCode.ofCode(getInteger("code").orElse(Integer.MAX_VALUE));
    }

    public Result setCode(int code) {
        return set("code", code);
    }

    public String getMessage() {
        return getString("message").orElse("");
    }

    public Result setMessage(String message) {
        return set("message", message);
    }

    public Result setData(Object data) {
        return set("data", data);
    }

    public Result delete(String key) {
        remove(key);
        return this;
    }

    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
