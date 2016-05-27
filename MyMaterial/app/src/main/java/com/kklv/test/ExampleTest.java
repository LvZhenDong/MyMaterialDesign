package com.kklv.test;

import android.test.InstrumentationTestCase;

import com.kklv.mymaterial.MyMath;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ExampleTest extends InstrumentationTestCase {
    MyMath mMyMath=new MyMath();

    public void test(){
        assertEquals(3,mMyMath.add(1,2));
    }
}
