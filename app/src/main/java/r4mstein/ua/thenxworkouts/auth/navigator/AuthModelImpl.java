package r4mstein.ua.thenxworkouts.auth.navigator;

import javax.inject.Inject;

import r4mstein.ua.thenxworkouts.root.base.BaseModel;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class AuthModelImpl extends BaseModel<IAuthContract.Presenter> implements IAuthContract.Model {

    @Inject
    public AuthModelImpl() {

    }
}
