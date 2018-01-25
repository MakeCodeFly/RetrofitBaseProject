package com.szhrnet.taoqiapp.mvp.model;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : GetAppInfoModel类
 *     email:15695947865@139.com
 * </pre>
 */

public class GetAppInfoModel {


    /**
     * apparr : {"app_id":2,"app_verson":"哎哎哎","app_url":"","app_remark":"aaa","app_pubtime":"2017-07-08 19:04:48","app_type":1,"app_is_qz":1}
     */

    private apparr apparr = new apparr();

    public apparr getApparr() {
        return apparr;
    }

    public void setApparr(apparr apparr) {
        this.apparr = apparr;
    }

    public static class apparr {
        /**
         * app_id : 2
         * app_verson : 哎哎哎
         * app_url :
         * app_remark : aaa
         * app_pubtime : 2017-07-08 19:04:48
         * app_type : 1
         * app_is_qz : 1
         */

        private int app_id;
        private String app_verson;
        private String app_url;
        private String app_remark;
        private String app_pubtime;
        private int app_type;
        private int app_is_qz;

        public int getApp_id() {
            return app_id;
        }

        public void setApp_id(int app_id) {
            this.app_id = app_id;
        }

        public String getApp_verson() {
            return app_verson;
        }

        public void setApp_verson(String app_verson) {
            this.app_verson = app_verson;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getApp_remark() {
            return app_remark;
        }

        public void setApp_remark(String app_remark) {
            this.app_remark = app_remark;
        }

        public String getApp_pubtime() {
            return app_pubtime;
        }

        public void setApp_pubtime(String app_pubtime) {
            this.app_pubtime = app_pubtime;
        }

        public int getApp_type() {
            return app_type;
        }

        public void setApp_type(int app_type) {
            this.app_type = app_type;
        }

        public int getApp_is_qz() {
            return app_is_qz;
        }

        public void setApp_is_qz(int app_is_qz) {
            this.app_is_qz = app_is_qz;
        }
    }
}
