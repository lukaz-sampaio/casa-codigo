package deveficiente.codehouse.lab.exception;

/**
 *
 * @author lucas
 */
public class ErrorDetail {
//  "errors": [
//    {
//      "codes": [
//        "email.autorRequest",
//        "email"
//      ],
//      "arguments": null,
//      "defaultMessage": "E-mail 'autor@email.com' já está em uso.",
//      "objectName": "autorRequest",
//      "code": "email"
//    }
//  ],

    private String defaultMessage;
    private String objectName;
    private Object rejectedValue;
    private String field;

    @Deprecated
    public ErrorDetail() {
    }

    public ErrorDetail(String defaultMessage, String objectName, Object rejectedValue, String field) {
        this.defaultMessage = defaultMessage;
        this.objectName = objectName;
        this.rejectedValue = rejectedValue;
        this.field = field;
    }

    public ErrorDetail(String defaultMessage, String objectName) {
        this.defaultMessage = defaultMessage;
        this.objectName = objectName;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
