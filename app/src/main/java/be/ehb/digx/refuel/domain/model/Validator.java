package be.ehb.digx.refuel.domain.model;

/**
 * Created by richsoft on 23/11/2016.
 */

public interface Validator<U> {

    boolean validate(U u);
}