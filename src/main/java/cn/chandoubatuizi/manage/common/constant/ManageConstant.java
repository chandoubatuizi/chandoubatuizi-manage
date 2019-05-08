package cn.chandoubatuizi.manage.common.constant;

public class ManageConstant {

    /**
     * 账户状态
     */
    public interface UserAccount {
        /**
         * 锁定
         */
        int USER_LOCK = 0;

        /**
         * 正常
         */
        int USER_NORMAL = 1;
    }

    /**
     * 登录最大尝试次数
     */
    public static final int MAX_RETRY_COUNT = 5;
}
