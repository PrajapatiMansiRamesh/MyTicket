package com.example.mytiket;

import com.paypal.android.sdk.payments.PayPalConfiguration;

public class PayPalConfig {
    public static final String PAYPAL_CLIENT_ID = "Actk5Gnu0I7h7olJl-wGhtuP-y3xf6xyjCoXeKaxC3gFEyS3_rUnAULMIQZbI6Fzs-sGP16r-SMOiMVD";
    public static final int PAYPAL_REQUEST_CODE = 123;


    //Paypal Configuration Object
    public static PayPalConfiguration config = new PayPalConfiguration()
            // Start with mock environment.  When ready, switch to sandbox (ENVIRONMENT_SANDBOX)
            // or live (ENVIRONMENT_PRODUCTION)
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(PayPalConfig.PAYPAL_CLIENT_ID);

}
