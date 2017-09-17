package com.rzfsc.mine.service.user;

import okhttp3.Call;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 17/9/3.
 */

public interface WebService {

    // TODO user retrofit
    Call getUser(String userId);
}
