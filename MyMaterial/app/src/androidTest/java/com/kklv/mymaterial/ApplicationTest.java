package com.kklv.mymaterial;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    /**
     * Created by Administrator on 2016/5/26.
     */
    public void testadd() throws Exception {
        MyMath myMath=new MyMath();
        assertEquals(21,myMath.add(1,1));
    }
}