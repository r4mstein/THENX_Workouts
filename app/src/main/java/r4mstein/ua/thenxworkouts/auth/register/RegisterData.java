package r4mstein.ua.thenxworkouts.auth.register;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class RegisterData {

    private String mEmail;
    private String mPass;

    public RegisterData(final String _email, final String _pass) {
        mEmail = _email;
        mPass = _pass;
    }

    @Override
    public String toString() {
        return "RegisterData{" +
                "Email='" + mEmail + '\'' +
                ", Pass='" + mPass + '\'' +
                '}';
    }
}
