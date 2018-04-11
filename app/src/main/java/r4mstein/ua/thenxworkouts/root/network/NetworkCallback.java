package r4mstein.ua.thenxworkouts.root.network;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public interface NetworkCallback<R extends BaseResponseDto> {
    void onSuccess(NetworkResponse<R> _response);
    void onError(NetworkError _error);


    static <R extends BaseResponseDto> NetworkCallback<R> create(final Runnable _s, final Runnable _e) {
        return new NetworkCallback<R>() {

            @Override
            public void onSuccess(final NetworkResponse<R> _response) {
                _s.run();
            }

            @Override
            public void onError(final NetworkError _error) {
                _e.run();
            }
        };
    }
}
