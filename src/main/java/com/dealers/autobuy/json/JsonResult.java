package com.dealers.autobuy.json;

/**
 * Class to generate Json Result for Rest APIs
 * @author Ali Golkar
 */
public class JsonResult {
    public static final String STATUS_ERROR         = "error";
    public static final String STATUS_EXCEPTION     = "exception";
    public static final String STATUS_FAIL          = "fail";
    public static final String STATUS_SUCCESS       = "success";

    private String status;
    private String message;
    private String error;
    private Object response;

    public static JsonResult create(String status) {
        return create(status, null);
    }

    public static JsonResult create(String status, String message) {
        JsonResult result = new JsonResult();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }

    public static JsonResult create(String status, Object response) {
        JsonResult result = new JsonResult();
        result.setStatus(status);
        result.setResponse(response);
        return result;
    }

    public static JsonResult create(String status, Object response, String message) {
        JsonResult result = new JsonResult();
        result.setStatus(status);
        result.setResponse(response);
        result.setMessage(message);
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
