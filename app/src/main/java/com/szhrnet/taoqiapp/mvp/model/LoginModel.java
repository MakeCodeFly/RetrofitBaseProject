package com.szhrnet.taoqiapp.mvp.model;

/**
 * Created by Administrator on 2017/12/2.
 */

public class LoginModel {


    /**
     * user_id : 10005
     * user_token : 6678f58a46b284868ecf03dd1184ec89
     * userarr : {"user_id":10005,"level_id":1,"user_token":"6678f58a46b284868ecf03dd1184ec89","user_gender":0,"user_age":0,"user_pic":"http://120.79.81.94/static/images/common/user_default.png","user_nick":"15695947865","region_id":0,"user_name":"15695947865","user_balance":0,"user_client_id":"","user_email":"","user_address":"","user_mobile":"15695947865","user_is_auth":0,"level_name":"屌丝","region_name":"","is_set_pay_pwd":0}
     */

    private int user_id;
    private String user_token;
    private userarr userarr = new userarr();

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public LoginModel.userarr getUserarr() {
        return userarr;
    }

    public void setUserarr(LoginModel.userarr userarr) {
        this.userarr = userarr;
    }

    public static class userarr {
        /**
         * user_id : 10005
         * level_id : 1
         * user_token : 6678f58a46b284868ecf03dd1184ec89
         * user_gender : 0
         * user_age : 0
         * user_pic : http://120.79.81.94/static/images/common/user_default.png
         * user_nick : 15695947865
         * region_id : 0
         * user_name : 15695947865
         * user_balance : 0
         * user_client_id :
         * user_email :
         * user_address :
         * user_mobile : 15695947865
         * user_is_auth : 0
         * level_name : 屌丝
         * region_name :
         * is_set_pay_pwd : 0
         */



        private int user_id;
        private int level_id;
        private String user_token;
        private int user_gender;
        private int user_age;
        private String user_pic;
        private String user_nick;
        private String region_id;
        private String user_name;
        private String user_balance;
        private String user_client_id;
        private String user_email;
        private String user_address;
        private String user_mobile;
        private int user_is_auth;
        private String level_name;
        private String region_name;
        private int is_set_pay_pwd;


        private  String login_user_pwd;
        private  String login_user_name;

        private String hx;



        public String getLogin_user_pwd() {
            return login_user_pwd;
        }

        public void setLogin_user_pwd(String login_user_pwd) {
            this.login_user_pwd = login_user_pwd;
        }

        public String getLogin_user_name() {
            return login_user_name;
        }

        public void setLogin_user_name(String login_user_name) {
            this.login_user_name = login_user_name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getLevel_id() {
            return level_id;
        }

        public void setLevel_id(int level_id) {
            this.level_id = level_id;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }

        public int getUser_gender() {
            return user_gender;
        }

        public void setUser_gender(int user_gender) {
            this.user_gender = user_gender;
        }

        public int getUser_age() {
            return user_age;
        }

        public void setUser_age(int user_age) {
            this.user_age = user_age;
        }

        public String getUser_pic() {
            return user_pic;
        }

        public void setUser_pic(String user_pic) {
            this.user_pic = user_pic;
        }

        public String getUser_nick() {
            return user_nick;
        }

        public void setUser_nick(String user_nick) {
            this.user_nick = user_nick;
        }

        public String getRegion_id() {
            return region_id;
        }

        public void setRegion_id(String region_id) {
            this.region_id = region_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_balance() {
            return user_balance;
        }

        public void setUser_balance(String user_balance) {
            this.user_balance = user_balance;
        }

        public String getUser_client_id() {
            return user_client_id;
        }

        public void setUser_client_id(String user_client_id) {
            this.user_client_id = user_client_id;
        }

        public String getUser_email() {
            return user_email;
        }

        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }

        public String getUser_address() {
            return user_address;
        }

        public void setUser_address(String user_address) {
            this.user_address = user_address;
        }

        public String getUser_mobile() {
            return user_mobile;
        }

        public void setUser_mobile(String user_mobile) {
            this.user_mobile = user_mobile;
        }

        public int getUser_is_auth() {
            return user_is_auth;
        }

        public void setUser_is_auth(int user_is_auth) {
            this.user_is_auth = user_is_auth;
        }

        public String getLevel_name() {
            return level_name;
        }

        public void setLevel_name(String level_name) {
            this.level_name = level_name;
        }

        public String getRegion_name() {
            return region_name;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }

        public int getIs_set_pay_pwd() {
            return is_set_pay_pwd;
        }

        public void setIs_set_pay_pwd(int is_set_pay_pwd) {
            this.is_set_pay_pwd = is_set_pay_pwd;
        }

        public String getHx() {
            return hx;
        }

        public void setHx(String hx) {
            this.hx = hx;
        }
    }
}
