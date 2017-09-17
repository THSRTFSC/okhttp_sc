/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rzfsc.mine.db;

import com.rzfsc.mine.db.entity.User;

/** Generates dummy data and inserts them into the database */
class DatabaseInitUtil {

    static void initializeDb(AppDatabase db) {
        User user = new User();
        user.setUserMobile("15157157761");
        user.setUserEmail("libing@myhexin.com");
        user.setUserName("libing");
        user.setId(1);

        insertData(db, user);
    }

    private static void insertData(AppDatabase db, User user) {
        db.beginTransaction();
        try {
            db.mUserDao().insertAll(user);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
