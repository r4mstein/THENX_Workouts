package r4mstein.ua.thenxworkouts.auth;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class AuthData {

    private String mEmail;
    private String mPass;

    public AuthData(final String _email, final String _pass) {
        mEmail = _email;
        mPass = _pass;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPass() {
        return mPass;
    }

    @Override
    public String toString() {
        return "AuthData{" +
                "Email='" + mEmail + '\'' +
                ", Pass='" + mPass + '\'' +
                '}';
    }
}
