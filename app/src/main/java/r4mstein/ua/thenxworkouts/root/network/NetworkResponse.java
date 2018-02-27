package r4mstein.ua.thenxworkouts.root.network;

import javax.annotation.Nullable;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class NetworkResponse<R extends BaseResponseDto> {

    private int mStatusCode = -1;
    private R mDto;

    public int getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(final int _statusCode) {
        mStatusCode = _statusCode;
    }

    public @Nullable R getDto() {
        return mDto;
    }

    public void setDto(final R _dto) {
        mDto = _dto;
    }
}
