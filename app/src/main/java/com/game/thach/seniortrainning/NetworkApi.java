package com.game.thach.seniortrainning;

import javax.inject.Inject;

/**
 * Created by phamn on 5/7/2017.
 */

public class NetworkApi {

    @Inject
    public NetworkApi(){

    }

    public boolean validateUser(String name, String password){
        if(name == null || name.length() == 0){
            return false;
        }else{
            return true;
        }
    }

}
