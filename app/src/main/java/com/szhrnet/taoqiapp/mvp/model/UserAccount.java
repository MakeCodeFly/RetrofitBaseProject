package com.szhrnet.taoqiapp.mvp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.szhrnet.taoqiapp.base.BaseApplication;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : UserAccount类
 *     email:15695947865@139.com
 * </pre>
 */
public class UserAccount {
    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String USERTOKEN = "userToken";
    private static final String PAYPASSWORD = "payPassword";
    private static final String BALANCE = "balance";
    private static final String INTEGRAL = "integral";
    private static final String PHOTO = "photo";
    private static final String NICK = "nick";
    private static final String ISIDCARD = "isIdCard";
    private static final String ISPHONE = "isPhone";
    private static final String ISADMIN = "isAdmin";
    private static final String IDCARD = "idCard";
    private static final String PHONE = "phone";
    private static final String QQ = "qq";
    private static final String ADDRESS = "address";
    private static final String CODE = "code";
    private static final String PROFILE = "profile";
    private static final String PUSHID = "pushId";
    private static final String ISPAYPASSWORD = "isPayPassword";
    private static final String ISEXPERT = "isExpert";
    private static final String CREATEUSER = "createUser";
    private static final String CREATETIME = "createTime";
    private static final String UPDATEUSER = "updateUser";
    private static final String UPDATETIME = "updateTime";
    private static final String LOGIN_USER_NAME = "login_user_pwd";
    private static final String LOGIN_USER_PWD = "login_user_name";

    private  static int id;
    private static String username;
    private static String password;
    private static String userToken;
    private static String payPassword;
    private static String balance;
    private static String integral;
    private static String photo;
    private static String nick;
    private  static int isIdCard;
    private static int isPhone;
    private static int isAdmin;
    private static String idCard;
    private static String phone;
    private static String qq;
    private static String address;
    private static String code;
    private static String profile;
    private static String pushId;
    private static int isPayPassword;
    private static int isExpert;
    private static int createUser;
    private static String createTime;
    private static int updateUser;
    private static String updateTime;

    private static String login_user_pwd;
    private static String login_user_name;



    public static void updateUserAccount(UserAccountModel model) {
        try {
            if (!TextUtils.isEmpty(model.getLogin_user_name()))
                UserAccount.login_user_name = model.getLogin_user_name();
            if (!TextUtils.isEmpty(model.getLogin_user_name()))
                UserAccount.login_user_pwd = model.getLogin_user_pwd();
            UserAccount.id = model.getId();
            UserAccount.username = model.getUsername();
            UserAccount.password = model.getPassword();
            UserAccount.userToken = model.getUserToken();
            UserAccount.payPassword = model.getPayPassword();
            UserAccount.balance = String.valueOf(model.getBalance());
            UserAccount.integral = String.valueOf(model.getIntegral());
            UserAccount.photo = model.getPhoto();
            UserAccount.nick = model.getNick();
            UserAccount.isIdCard = model.getIsIdCard();
            UserAccount.isPhone = model.getIsPhone();
            UserAccount.isAdmin = model.getIsAdmin();
            UserAccount.idCard = model.getIdCard();
            UserAccount.phone = model.getPhone();
            UserAccount.qq = model.getQq();
            UserAccount.address = model.getAddress();
            UserAccount.code = model.getCode();
            UserAccount.profile = model.getProfile();
            UserAccount.pushId = model.getPushId();
            UserAccount.isPayPassword = model.getIsPayPassword();
            UserAccount.isExpert = model.getIsExpert();
            UserAccount.createUser = model.getCreateUser();
            UserAccount.createTime = model.getCreateTime();
            UserAccount.updateUser = model.getUpdateUser();
            UserAccount.updateTime = model.getUpdateTime();
            UserAccount.save(BaseApplication.getInstance().getApplicationContext());

        } catch (Exception e) {
        }
    }

    //判断是否之前已经登录账号过
    public static boolean isEverLogin() {
        return !TextUtils.isEmpty(login_user_name)
                && !TextUtils.isEmpty(login_user_pwd);
    }

    //退出账号
    public static boolean loginOut() {
        login_user_name = null;
        login_user_pwd = null;
        UserAccount.userToken = null;
        UserAccount.save(BaseApplication.getInstance().getApplicationContext());
        return true;
    }


    /**
     * 存储数据到XML文件，持久化
     */
    private static void save(Context context) {
        // 获取数据持久化的SP
        SharedPreferences sp = context.getSharedPreferences(UserAccount.class.getName(),
                Context.MODE_PRIVATE);
        // 存储数据
        sp.edit()
                .putInt(ID, id)
                .putString(USERNAME, username)
                .putString(PASSWORD, password)
                .putString(USERTOKEN, userToken)
                .putString(PAYPASSWORD, payPassword)
                .putString(BALANCE, balance)
                .putString(INTEGRAL, integral)
                .putString(PHOTO, photo)
                .putString(NICK, nick)
                .putInt(ISIDCARD, isIdCard)
                .putInt(ISPHONE, isPhone)
                .putInt(ISADMIN, isAdmin)
                .putString(IDCARD, idCard)
                .putString(PHONE, phone)
                .putString(QQ, qq)
                .putString(ADDRESS, address)
                .putString(CODE, code)
                .putString(PROFILE, profile)
                .putString(PUSHID, pushId)
                .putInt(ISPAYPASSWORD, isPayPassword)
                .putInt(ISEXPERT, isExpert)
                .putInt(CREATEUSER, createUser)
                .putString(CREATETIME, createTime)
                .putInt(UPDATEUSER, updateUser)
                .putString(UPDATETIME, updateTime)
                .putString(LOGIN_USER_NAME, login_user_name)
                .putString(LOGIN_USER_PWD, login_user_pwd)
                .apply();
    }

    /**
     * 进行数据加载
     */
    public static void load(Context context) {
        SharedPreferences sp = context.getSharedPreferences(UserAccount.class.getName(),
                Context.MODE_PRIVATE);
        id = sp.getInt(ID, 0);
        username = sp.getString(USERNAME, "");
        password = sp.getString(PASSWORD, "");
        userToken = sp.getString(USERTOKEN, "");
        payPassword = sp.getString(PAYPASSWORD, "");
        balance = sp.getString(BALANCE, "");
        integral = sp.getString(INTEGRAL, "");
        photo = sp.getString(PHOTO, "");
        nick = sp.getString(NICK, "");
        isIdCard = sp.getInt(ISIDCARD, 0);
        isPhone = sp.getInt(ISPHONE, 0);
        isAdmin = sp.getInt(ISADMIN, 0);
        idCard = sp.getString(IDCARD, "");
        phone = sp.getString(PHONE, "");
        qq = sp.getString(QQ, "");
        address = sp.getString(ADDRESS, "");
        code = sp.getString(CODE, "");
        profile = sp.getString(PROFILE, "");
        pushId = sp.getString(PUSHID, "");
        isPayPassword = sp.getInt(ISPAYPASSWORD, 0);
        isExpert = sp.getInt(ISEXPERT, 0);
        createUser = sp.getInt(CREATEUSER, 0);
        createTime = sp.getString(CREATETIME, "");
        updateUser = sp.getInt(UPDATEUSER, 0);
        updateTime = sp.getString(UPDATETIME, "");

        login_user_name = sp.getString(LOGIN_USER_NAME, "");
        login_user_pwd = sp.getString(LOGIN_USER_PWD, "");


    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UserAccount.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserAccount.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserAccount.password = password;
    }

    public static String getUserToken() {
        return userToken;
    }

    public static void setUserToken(String userToken) {
        UserAccount.userToken = userToken;
    }

    public static String getPayPassword() {
        return payPassword;
    }

    public static void setPayPassword(String payPassword) {
        UserAccount.payPassword = payPassword;
    }

    public static String getBalance() {
        return balance;
    }

    public static void setBalance(String balance) {
        UserAccount.balance = balance;
    }

    public static String getIntegral() {
        return integral;
    }

    public static void setIntegral(String integral) {
        UserAccount.integral = integral;
    }

    public static String getPhoto() {
        return photo;
    }

    public static void setPhoto(String photo) {
        UserAccount.photo = photo;
    }

    public static String getNick() {
        return nick;
    }

    public static void setNick(String nick) {
        UserAccount.nick = nick;
    }

    public static int getIsIdCard() {
        return isIdCard;
    }

    public static void setIsIdCard(int isIdCard) {
        UserAccount.isIdCard = isIdCard;
    }

    public static int getIsPhone() {
        return isPhone;
    }

    public static void setIsPhone(int isPhone) {
        UserAccount.isPhone = isPhone;
    }

    public static int getIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(int isAdmin) {
        UserAccount.isAdmin = isAdmin;
    }

    public static String getIdCard() {
        return idCard;
    }

    public static void setIdCard(String idCard) {
        UserAccount.idCard = idCard;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        UserAccount.phone = phone;
    }

    public static String getQq() {
        return qq;
    }

    public static void setQq(String qq) {
        UserAccount.qq = qq;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        UserAccount.address = address;
    }

    public static String getCode() {
        return code;
    }

    public static void setCode(String code) {
        UserAccount.code = code;
    }

    public static String getProfile() {
        return profile;
    }

    public static void setProfile(String profile) {
        UserAccount.profile = profile;
    }

    public static String getPushId() {
        return pushId;
    }

    public static void setPushId(String pushId) {
        UserAccount.pushId = pushId;
    }

    public static int getIsPayPassword() {
        return isPayPassword;
    }

    public static void setIsPayPassword(int isPayPassword) {
        UserAccount.isPayPassword = isPayPassword;
    }

    public static int getIsExpert() {
        return isExpert;
    }

    public static void setIsExpert(int isExpert) {
        UserAccount.isExpert = isExpert;
    }

    public static int getCreateUser() {
        return createUser;
    }

    public static void setCreateUser(int createUser) {
        UserAccount.createUser = createUser;
    }

    public static String getCreateTime() {
        return createTime;
    }

    public static void setCreateTime(String createTime) {
        UserAccount.createTime = createTime;
    }

    public static int getUpdateUser() {
        return updateUser;
    }

    public static void setUpdateUser(int updateUser) {
        UserAccount.updateUser = updateUser;
    }

    public static String getUpdateTime() {
        return updateTime;
    }

    public static void setUpdateTime(String updateTime) {
        UserAccount.updateTime = updateTime;
    }

    public static String getLogin_user_pwd() {
        return login_user_pwd;
    }

    public static void setLogin_user_pwd(String login_user_pwd) {
        UserAccount.login_user_pwd = login_user_pwd;
    }

    public static String getLogin_user_name() {
        return login_user_name;
    }

    public static void setLogin_user_name(String login_user_name) {
        UserAccount.login_user_name = login_user_name;
    }
}
