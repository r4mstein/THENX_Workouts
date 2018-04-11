package r4mstein.ua.thenxworkouts.root.network;

import java.util.List;
import java.util.Map;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class NetworkError {

    public enum Type { NETWORK, CONVERSION, HTTP, VALIDATION }

    private Type mType;
    private int mStatusCode = -1;
    private String mMessage;
    private Map<String, List<String>> mHeaders;

    public final Type getType() {
        return mType;
    }

    public final NetworkError setType(final Type _type) {
        mType = _type;
        return this;
    }

    public final int getStatusCode() {
        return mStatusCode;
    }

    public final NetworkError setStatusCode(final int _code) {
        mStatusCode = _code;
        return this;
    }

    public final boolean hasStatusCode() {
        return mStatusCode != -1;
    }

    public final String getMessage() {
        return mMessage;
    }

    public final NetworkError setMessage(final String _message) {
        mMessage = _message;
        return this;
    }

    public final Map<String, List<String>> getHeaders() {
        return mHeaders;
    }

    public final NetworkError setHeaders(final Map<String, List<String>> _headers) {
        mHeaders = _headers;
        return this;
    }

    @Override
    public String toString() {
        return "NetworkError{" +
                "Type=" + mType +
                ", StatusCode=" + mStatusCode +
                ", Message='" + mMessage + '\'' +
                ", Headers=" + mHeaders +
                '}';
    }
}
