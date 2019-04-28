package com.ta.framework.util;

import com.ta.framework.entity.User;


public class UserSession  extends RequestSession{
        /**
         * 获取session中
         * @param
         * @return user
         */
        public static User getUser() {
            return (User) getSession().getAttribute("user");
        }

        /**
         *
         * @param User
         */
        public static void setUser(User User) {
            getSession().setAttribute("user", User);
        }

        /**
         * 从Session中移除
         */
        public static void removeUser() {
            getSession().removeAttribute("user");
        }

    }


