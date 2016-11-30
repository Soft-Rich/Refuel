package be.ehb.digx.refuel;

/**
 * Created by richsoft on 25/11/2016.
 */

public interface BaseAdapter<U, D> {
    public D adaptFromUi(U userinterface);
    public U adaptToUi(D domain);
}
