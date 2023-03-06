package com.pom;

public class Pages {

    private LogIn logIn;
    private Dash_Board dashBoard;
    private Profile profile;

//    private Methods methods;


    public LogIn logIn() {

        if (logIn == null) {
            logIn = new LogIn();
        }

        return logIn;
    }


    public Dash_Board dashBoard() {

        if (dashBoard == null) {
            dashBoard = new Dash_Board();
        }

        return dashBoard;
    }

    public Profile profile() {

        if (profile == null) {
            profile = new Profile();
        }

        return profile;
    }

//    public Methods methods() {
//
//        if (methods == null) {
//            methods = new Methods();
//        }
//
//        return methods;
//    }


}
